var configManager = require('./ConfigManager.js'),
	http = require('http'),
	querystring = require('querystring');

exports.update = function(url) {
    getVersion(url);
//    checkUpdate();
};

/**
 * 1、服务端获取version
 * @param url
 */
function getVersion(url){
	var req = http.request(url, function(res) {
	    console.log("Got response: " + res.statusCode);
	    var body = '';
		res.on('data',function(d){
	        body += d;
	    }).on('end', function(){
	        var version = body;
	        checkUpdate(version);
	    });
	}).on('error', function(e) {
	    console.log("Got error: " + e.message);
	});
	req.end();
}
/**
 * 
 * 2、对比本地version
 * 3、若需要更新，调用beginUpdate
 * 4、无需更新return
 */
function checkUpdate(version){
	console.log(version);
	var ac = configManager.getAppConfig();
	if(ac.version == version){
		console.log("client is lastest");
		false;
	}else{
		console.log("client version is:"+ ac.version +" and server version is "+version);
		console.log("begin update....");
		beginUpdate();
		return true;
	}
}
/**
 * 开始更新
 * 1、获取安装目录。
 * 2、调用founderUpdate.exe,传递参数。
 * 3、关闭webkit。
 */
function beginUpdate(){
	var exec = require("child_process").exec;            
    var strCmd = "REG QUERY HKEY_LOCAL_MACHINE\\SOFTWARE\\PKU-HIT\\EMR\\InstallPath /v INSTALLLOCATION";
    exec(strCmd, function (error, stdout, stderr) {
		var updateCmd = getUpdateCmd(stdout);
		exec(updateCmd, function (error, stdout, stderr) {
			console.log('start founderAutoUpdate.....');
			if(error != null){
				console.log('stderr:'+stderr);
				console.log('exec error:'+error);
			}
		});
        if(error != null){
            console.log('stderr:'+stderr);
            console.log('exec error:'+error);
        }
    });

}

function getUpdateCmd(stdout){
	var ac = configManager.getAppConfig();
	var iemrInstallPath = handleInstallPathStdout(stdout);
	var updateCmd= iemrInstallPath+"\\update\\FounderAutoUpdate.exe /AppName=IEMR /AppPath="+iemrInstallPath+" /ServerURL="+ ac.baseServerUrl+"UpdateInfo.xml";
	console.log(updateCmd);
	return updateCmd;
}

function handleInstallPathStdout(stdout){
	console.log(stdout);
	var reg = /REG_SZ/;
	var iemrPathArray = stdout.split(reg);
	var iemrPath = iemrPathArray[1];
	iemrPath = iemrPath.replace(/\s+/g,"")
	console.log(iemrPath);
	return iemrPath;
}