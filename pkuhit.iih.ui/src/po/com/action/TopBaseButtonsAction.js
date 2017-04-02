Ext.define('iih.po.com.action.TopBaseButtonsAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var global = window.global;
	    var gui = require('nw.gui');
	    var block = this.getOwner();
	    switch (context.action) {
        case 'skin' : break;
        case 'docMgr':
        	this.selectPortal('XAPM06.1001','病历管理');
            break;
        case 'seniorQuery':
        	this.selectPortal('XAPM06.1002','高级检索');
        	break;
        case 'templateMgr':
        	this.selectPortal('XAPM06.03','病历模板管理');
        	break;
        case 'minimum':
            global.mainWindow = gui.Window.get();
            if (global && global.mainWindow) {
                global.mainWindow.minimize();
            }
            break;
        case 'restore':
            this.maximize();
            break;
        case 'maximize':
            this.maximize();
            break;
        case 'close':
            // TODO 临时方案 
            XapMessageBox.confirm2('确定退出定制病历管理系统 V1.0？',function(btn){
                if(btn == 'yes') {
                    //window.opener = null;
                    //window.open('', '_self');
                    //window.close();
                    var portal = block.up('portalview');
                    var workArea = portal.down('xaptabpanel[id=workareapageview]');
                    var callBack = function(item){
                        item.close();
                    };
                    workArea.callBack = {
                        method: callBack,
                        scope: btn,
                        params: [gui.Window.get()]
                    };
                    workArea.closePages = null;
                    var canvas = Xap.getCanvas();
                    canvas.fireEvent("portalRender");
                }
            },window);
            break;
        default:
            break;
        }
    },
    selectPortal: function(portalCode,portalName){
    	 var portal = this.getOwner().ownerCt.up('portalview');
         var chain = portal.getActionChain('init');
         
         chain.execute({
             hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
             hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
             departmentCode:IMER_GLOBAL.department.code,
             departmentName:IMER_GLOBAL.department.name,
             portalCode:portalCode,
             portalName:portalName
         });
    },
    maximize: function() {
        if (window.global) {
            if (window.maxmized) {
                window.resizeTo(window.original.width, window.original.height);
                window.moveTo(window.original.x, window.original.y);
                window.maxmized = false;
                Ext.getCmp('topbase-buttons').down('button[action=restore]').hide();
                Ext.getCmp('topbase-buttons').down('button[action=maximize]').show();
                IMER_CONSTANT.WORKAREA_WIDTH = Math.max(IMER_CONSTANT.CONSTRAIN_WIDTH, document.body.clientWidth) - IMER_CONSTANT.FIXED_WIDTH;
            } else if (!window.maxmized) {
                window.original = {
                    x: window.screenLeft,
                    y: window.screenTop,
                    width: window.outerWidth,
                    height: window.outerHeight
                };
                window.resizeTo(window.screen.availWidth, window.screen.availHeight);
                window.maxmized = true;
                Ext.getCmp('topbase-buttons').down('button[action=maximize]').hide();
                Ext.getCmp('topbase-buttons').down('button[action=restore]').show();
                IMER_CONSTANT.WORKAREA_WIDTH = window.screen.width - IMER_CONSTANT.FIXED_WIDTH;
            }
        }
    }
});