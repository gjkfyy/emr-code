var fs            = require('fs'),
    events        = require('events'),
    util          = require('./util.js'),
    http          = require('http'),
    FileManager   = global.getFileManager(),
    configManager = require('./ConfigManager.js');

var emitter = new events.EventEmitter();

var isWorking = false;

var updateExeName = null;

function checkUpdate(updateUrl, currentVersion, callback, events) {
    events = events || {
        // success: function () {},
        // fail: function () {}
    };

    // updateUrl += '?' + util.createRdStr();

    jQuery.getJSON(updateUrl).done(function (data) {
        // TODO 目前实行强制更新
        if (!data || !data.appVersion || !data.downloadUrl) {
            callback(null, false);
            return;
        }
        else {
            detectVersion(data);
        }
    }).fail(function () {
        doProcessError('check Update Error');
    });

    function detectVersion (data) {
        var current = getVersionInfo(currentVersion),
            target = getVersionInfo(data.appVersion),
            hasNewVersion = false,
            hasNewPatch = false;
        console.log('target.version:' + target.versionNum);
        console.log('current.version:' + current.versionNum);

        if (target.versionNum > current.versionNum) hasNewVersion = true;

        if (target.versionNum === current.versionNum) {
            console.log('target.extra:' + target.extra);
            console.log('current.extra:' + current.extra);
                        
            if (target.extra && !current.extra) hasNewPatch = true;
            if (target.extra > current.extra) hasNewPatch = true
        }

        if (callback) {
            callback(data, hasNewVersion, hasNewPatch);
        }
    }

    function getVersionInfo(version) {
        var versionInfo = version.split('-'),
            extra = versionInfo[1],
            numbers = versionInfo[0].split('.'),
            multiple = 100,
            versionNum = 0;
        var len = numbers.length;
        if(len >= 4) {
            extra = numbers[3];
        }

        for (var i = 0;i < 3; i++) {
            if (numbers[i] !== undefined) {
                versionNum += numbers[i] * multiple;
                multiple = multiple / 10;
            }
        }

        return {
            versionNum: versionNum,
            extra: extra
        };
    }
};

/**
 * download update
 * @param  {object} data
 * @param  {String} filePath
 */
function downloadFile(data) {
    var fileUrl = data.downloadUrl;
    var filePath = FileManager.appDataDir + '\\setup';
    if (fileUrl.indexOf('.msi') > 0) {
        filePath += '.msi';
    }
    else {
        // 默认msp
        filePath += '.msp';
    }
    // TODO filePath
    var file = fs.createWriteStream(filePath);
    console.log('try to download [' + fileUrl + '] to [' + filePath + ']');
    http.get(fileUrl, function(response) {
        if (!/200|201/.test(response.statusCode)) {
            doProcessError('File not found!');
            isWorking = false;
            return false;
        }

        var progress = 1;

        var total = parseInt(response.headers['content-length'], 10);
        var cur = 0;
        response.on("data", function(chunk) {
            file.write(chunk);
            cur += chunk.length;
            emitter.emit('progress', progress * (parseFloat(cur) / total));
        });

        response.on("end", function() {
            file.end();
            // emitter.emit('progress', 1.0);
            tryTolaunchUpdateExe(filePath);

            /*
            console.log('try to run unzip file to [' + process.cwd() + ']');
            // 解压缩
            new targz().extract(filePath, process.cwd() + '/tmp', function(err){
                if(err) {
                    emitter.emit('error', err);
                }
                console.log('The extraction has ended!');
                emitter.emit('progress', 1.0);
                emitter.emit('finish', true);
                isWorking = false;
            });
            */
        });
    }).on('error',function (e) {
        // TODO try to remove unfinished files
        doProcessError(e);
        isWorking = false;
    });
};

function doProcessError(data)
{
    emitter.emit('error', data);
    isWorking = false;
}

function doFinish()
{
    // emitter.emit('progress', 1.0);
    emitter.emit('finish');
    isWorking = false;
}

function tryTolaunchUpdateExe(filePath) {
    // 如果存在，则执行
    if(fs.existsSync(filePath)) {
        var cmdArgs = [];
        // patch
        if(filePath.indexOf('.msp') > 0)
        {
            cmdArgs = ['/p', filePath];
        }
        else if(filePath.indexOf('.msi') > 0){
            cmdArgs = ['/i', filePath];
        }
        var spawn = require('child_process').spawn
        var child = spawn('msiexec', cmdArgs, {
            detached: true,
            stdio: [ 'ignore']
        });
        child.unref();
        mainWindow.close();
        return true;
    }
    return false;
}

function doUpdate(data, hasNewVersion, hasNewPatch) {
    console.log('hasNewVersion? [' + hasNewVersion + ']');
    console.log('update json: { version:' + data.appVersion + ', download: ' + data.downloadUrl +' }');
	console.log('has new version, so try to download [' + data.downloadUrl + ']');
	downloadFile(data);
}

/**
 * try to update
 * 如果Updater正在工作，调用run无效
 */
exports.run = function() {
    if(isWorking)
        return;
    isWorking = true;
    var packageConfig = configManager.getPackageConfig(),
        appConfig = configManager.getAppConfig(),
        checkUrl = appConfig.updateUrl + '&_rdstr=' + util.createRdStr(),
        // TODO
        currentVersion = packageConfig.version;

    emitter.emit('start');
    checkUpdate(checkUrl, currentVersion, function (data, hasNewVersion, hasNewPatch) {
        if(!data) {
            doProcessError('检查更新失败');
        }
        else {
			if (hasNewVersion || hasNewPatch) {
				if(appConfig.autoUpdate) {
					doUpdate(data, hasNewVersion, hasNewPatch);
				}
				else {
					Ext.MessageBox.show({
						title: '产品升级',
						msg: '发现新版本，本产品升级后才可以使用，是否升级？',
						buttons: Ext.MessageBox.OKCANCEL,
						fn: function(btn) {
							if(btn == 'ok') {
								doUpdate(data, hasNewVersion, hasNewPatch);
							}
							// else if(btn == 'cancel') 
							else {
								mainWindow.close();
							}
						},
						icon: Ext.Msg.QUESTION
					});
				}
			}
			else {
				doFinish();
			}
        }
    });
}

exports.onProgress = function(callback) {
    emitter.on('progress', callback);
}

exports.onStart = function(callback) {
    emitter.on('start', callback);
}

exports.onFinish = function(callback) {
    emitter.on('finish', callback);
}

exports.onError = function(callback) {
    emitter.on('error', callback);
}