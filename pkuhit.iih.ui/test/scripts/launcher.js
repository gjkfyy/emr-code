'use strict';

var configManager = require('./ConfigManager.js'),
    netMgr        = require('./NetManager.js'),
	// path        = require('path'),
    // fs          = require('fs'),
    updater     = require('./UpdateManager.js');
    // FileManager   = global.getFileManager();

/*
* 入口
*/
exports.startUp = function() {
	// 初始化部分配置信息
	initAppConfig();

	// 初始化更新程序
	update();

	// 初始化网络组件
	initNetConnection();

	// 初始化应用
	initApp();
}

function initAppConfig() {
	var ac = configManager.getAppConfig();
}

function initNetConnection() {
	Xap.ej.Net.netMgr = netMgr;
	//Xap.ej.Net.open();
	Xap.ej.Net.on('data', function(conn,data){
		//alert(data.data);
		console.log(data.data.token+'==========');
		if(typeof(data.data) == 'string'){
			iih.po.com.hisToiemrUtil.refreshOrder(data.data);
		}else if(data.data.token.indexOf('finish')>=0){
			iih.po.com.hisToiemrUtil.finish(data.data);
		}else{
   			//iih.po.com.hisLoginIemrUtil.autoLogin(conn,data);
   			iih.po.com.hisToiemrUtil.common(conn,data);
		}
    });
	
	iih.po.com.iemrTohisEvent.on('diagnosisComit',function(){
		
		var  patientId =  IMER_GLOBAL.patientId;
		
		 var xmlstring = "<?xml version='1.0' encoding='UTF-8'?>"
    		 + "<message>"
    		 + " <object code='DIAGNOSIS' action='create' patientId='"+patientId+"' >"
    		 + " </object>"
    		 + "</message>";
		 console.log(xmlstring);
			 
			 
			 var sockets =   netMgr.getSockets();
				for( var soc in sockets){
				    console.log(soc);
				   sockets[soc].send(xmlstring);
				   console.log('HIS  diagnosis refaresh');
				}
	});
}

function initApp() {
	loadApplication();
}

function loadApplication() {
	Ext.application({
	    requires: [
	    	'iih.po.com.view.App',
	    	'Xap.ej.block.Canvas',
	    	'Xap.ej.action.RemoteChainExecutor2',
	    	'Xap.ej.action.Chain',
	    	'iih.po.com.PortalPlugin',
			'IMER_GLOBAL'
	    ],

	    name: 'iih_po_com',

	    launch: function() {
	        // 加载插件
	        var plugin = Xap.ej.platform.Plugin;
	        plugin.load([
	            'iih.po.com.PortalPlugin'
	        ]);

	        var app = Xap.getApp();
	        app.mainView = {
	            xtype: 'app'
	        };
	        var ac = configManager.getAppConfig();
	        app.baseUrl =  ac.baseServerUrl || "http://localhost:8081/";
	        app.launch();

			// 根据url参数进入portal
			var params = Ext.urlDecode(window.location.search.substring(1));
			var userCd = params['userCd'];
			var password = params['password'];
			var portalCd = params['portalCd'];
			var hosArea = params['hosArea'];
			var deptCd = params['deptCd'];
			var encounterSn = params['encounterSn'];
			var patientId = params['patientId'];
			var cardId=params['cardId'];
			console.log('cardId='+cardId);
			console.log('userCd='+userCd);
			console.log('password='+password);
			console.log('portalCd='+portalCd);
			console.log('deptCd='+deptCd);
			console.log('encounterSn='+encounterSn);
			console.log('patientId='+patientId);
			if(userCd && password && portalCd && deptCd){
				var app = Ext.getCmp('commonappmain');
				var loginView = app.down('login');
				var name = loginView.down('xaptextfield[name=username]');
				var pass = loginView.down('xaptextfield[name=password]');
				name.setValue(userCd);
				pass.setValue(password);

				var chainLogin = loginView.getActionChain('autologin');
                chainLogin.execute({
					'userCd':userCd,
					'portalCd':portalCd,
					'hosArea':hosArea||'PKUHIT',
					'deptCd':deptCd,
					'encounterSn':encounterSn,
					'cardId':cardId,
					'patientId':patientId
				});
			}
	    }
	});
}

function update(){
	var ac = configManager.getAppConfig();
	updater.update(ac.baseServerUrl+"ws/version?xmode=debug");
}

//========================自动更新暂时不用=============================//
function initUpdater() {
	var ac = configManager.getAppConfig();
	if(!ac.updateUrl)
		ac.updateUrl = IMER_CONSTANT.SERVER_URL + '/update.json?appId=' + ac.appId;

	// 进度条
	var progressView = null;

	// init Updater begin
	updater.onStart(function() {
		mask.hide();
		console.log('start update');
	});

	updater.onProgress(function(progress, message) {
		// TODO 国际化方案
		if(!progressView) {
			progressView = Ext.Msg.progress('更新', '', '下载...');
		}
		progressView.updateProgress(progress, message);
	});

	updater.onFinish(function() {
		// TODO 从队列中取得最新的数据（文件或Storage）
		// var data = util.readJsonSync(FileManager.tmpFile) || {};
		// TODO remove file
		// 初始化界面
		if(progressView) {
			progressView.updateProgress(1.0, '更新完成');
			progressView = null;
		}
		initApp();
	});

	updater.onError(function(e) {
		console.log(e);
		if(progressView) {
			progressView.updateProgress(1.0, '更新失败');
			progressView = null;
		}
		Ext.MessageBox.show({
			title: '更新错误',
			msg: '更新失败，请联系管理员解决',
			buttons: Ext.MessageBox.OK,
			fn: function() {
				mainWindow.close();
			},
			icon: Ext.Msg.ERROR
		});
	});
}