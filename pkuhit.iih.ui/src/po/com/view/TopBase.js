Ext.define('iih.po.com.view.TopBase', {
    extend: 'Ext.container.Container',

    requires: ['iih.po.com.action.LogoutAction'],
    
    alias: 'widget.topbase',
    
    border: 0,
    
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    baseCls: '',
    
    header: false,
    
    defaultType: 'container',
    
    initComponent: function() {
        this.items = [{
            items: [this.getToolBarArea()]
        },{
            flex: 1,
            items: [this.getContentArea()]
        }];
        
        this.callParent();
    },
    
    //top页面的工具条
    getToolBarArea: function() {
        var titleArea = this.getExtraTitle();
        var buttonArea = this.getButtonArea();
        //var items = titleArea != null ? [titleArea, this.getExtraContent()] : [this.getExtraContent()];
        return Ext.create('Ext.container.Container', {
            header: false,
            border: false,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            baseCls: '',
            items: [titleArea,buttonArea]
        });
    },
    //top页面的内容区域
    getContentArea: function() {
        var extraContent = this.getExtraContent();
        var switchArea = this.getSwitchArea();
        //var items = titleArea != null ? [titleArea, this.getExtraContent()] : [this.getExtraContent()];
        return Ext.create('Ext.container.Container', {
            header: false,
            border: false,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            baseCls: '',
            items: [extraContent,switchArea]
        });
    },
    //设置title区域内容
    getExtraTitle: function() {
        var baseUrl;
        var app = Xap.getApp();
        var tmpArray = app.baseUrl.split('/');
        if(tmpArray.length>2)
            baseUrl = tmpArray[2];
        return Ext.create('Ext.container.Container', {
            flex: 1,
            border: false,
            baseCls: '',
            cls: 'topHeader',
            layout: {
                type: 'hbox',
                align: 'stretch',
                padding: '2 0 5 2'
            },
            items: [{
                xtype: 'image',
                imgCls: this.iconCls || '',
                src: this.icon || '',
                width: 16,
                height: 16,
                margin: '2 5 0 4'
            },{
                xtype: 'label',
                text: IMER_CONSTANT.SYSTEMNAME
            },{
                xtype: 'label',
                text: IMER_CONSTANT.VERSION
            },{
                xtype: 'label',
                text: baseUrl?'(Server : '+baseUrl+')':IMER_CONSTANT.IP
            },{
                xtype: 'container',
                cls: 'topHeader',
                flex: 1,
                style: {
                    height: '100%'
                }
            }]
        });
    },
    //top页面的内容区域，子类需重写该方法配置区域内容
    getExtraContent: function() {
        return Ext.create('Ext.container.Container', { flex:1, border: false, baseCls: '' });
    },
    
    //top区域右侧按钮区域
    getButtonArea: function() {
        var global = window.global;
        //var webkitMaxmized = global && global.mainWindow && global.maxmized;
        var webkitMaxmized = global && global.maxmized;
        return Ext.create('Ext.container.Container', {
            flex: 1,
            header: false,
            border: false,
            baseCls: '',
            id: 'topbase-buttons',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            defaultType: 'container',
            items: [{
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end',
                    padding: '0 0 0 0'
                },
                border: 0,
                baseCls: '',
                defaults: {
                    border: false,
                    margin: '0 4 0 4',
                    padding: 0
                },
                items: [/*{
                    xtype: 'container',
                    name:'selectPorBtn',
                    margin: '0 5 0 0'
                },{
                    xtype: 'button',
                    name:'orgName',
                    margin: '0 5 0 0'
                },*/{
                    xtype: 'container',
                    name:'selectDeptBtn',
                    margin: '0 5 0 0'
                },{
                    xtype: 'button',
                    name:'iemrUser',
                    margin: '0 5 0 0',
                    menu: {
                        cls: 'top-base',
                        frame: true,
                        margin: 0,
                        padding: 0,
                        minWidth: 70,
                        items: [{
                            iconCls: 'home_16',
                            text: '首页',
                            action: 'homepage',
                            hidden: true,
                        },{
                            iconCls: 'logout_16',
                            text: '注销',
                            action: 'logout'
                        },/*{
                            iconCls: 'config_16',
                            text: '设置',
                            action: 'config'
                        },*/{
                            iconCls: 'config_16',
                            text: '修改密码',
                            action: 'password'
                        }/*,{
                            iconCls: 'help_16',
                            text: '帮助',
                            action: 'help'
                        }*/],
                        listeners: {
                            click: function(menu, item, e) {
                                var button = menu.ownerButton;
                                var portal = button.up('portalview');
                                var workArea = portal.down('xaptabpanel[id=workareapageview]');
                                if(item.action=='logout'){
                                    XapMessageBox.confirm2('是否要注销？', function(buttonId) {
                                        if (buttonId == 'yes') {
                                            IMER_GLOBAL.user.code = null;
                                            IMER_GLOBAL.user.name = null;
                                            IMER_GLOBAL.hospitalArea.code = null;
                                            IMER_GLOBAL.hospitalArea.name = null;
                                            IMER_GLOBAL.department.code = null;
                                            IMER_GLOBAL.department.name = null;
                                            IMER_GLOBAL.portal.code = null;
                                            IMER_GLOBAL.portal.name = null;
                                            IMER_GLOBAL.encounterSn = null;
                                            IMER_GLOBAL.encounterCount = null;
                                            var callBack = function(){
                                                var logout = Xap.create({
                                                    xclass: 'iih.po.com.action.LogoutAction'
                                                });
                                                Xap.runAction(logout);
                                            };
                                            workArea.callBack = {
                                                method: callBack,
                                                scope: buttonId,
                                                params: []
                                            };
                                            workArea.closePages = null;
                                            var canvas = Xap.getCanvas();
                                            canvas.fireEvent("portalRender");
                                            
                                            /*var portal = button.up('portalview');
                                            var app = portal.ownerCt;
                                            var layout = app.getLayout();
                                            layout.setActiveItem(0);*/
                                        }
                                    });
                                }else if(item.action=='config'){
                                	 var userConfig = Xap.create({
                                         xclass: 'iih.sy.config.action.PopupConfigAction'
                                     });
                                     Xap.runAction(userConfig);
                                }else if(item.action=='password'){
                                    var pwd = Xap.create({
                                        xclass: 'iih.sy.pwd.action.PopupPwdUpdateAction'
                                    });
                                    Xap.runAction(pwd);
                                }else if(item.action=='help'){
                                    var gui = require('nw.gui');
                                    //gui.Shell.openItem("help.chm");
                                    /*var gui = require('nw.gui');
                                    if(gui){
                                        if(!global.helpWindow){
                                            var win = gui.Window.get();
                                            //var width = win.width;
                                            //var height = win.height;
                                            var width = IMER_CONSTANT.WORKAREA_MIN_WIDTH;
                                            var height = IMER_CONSTANT.WORKAREA_MIN_HEIGHT;
                                            global.helpWindow = gui.Window.open('help.chm', {
                                                'position': 'center',
                                                'width':width,
                                                'height':height,
                                                'toolbar':false,
                                                'focus':true
                                            });
                                            global.helpWindow.on('close', function () {
                                                global.helpWindow = null;
                                                this.close(true);
                                            });
                                        }else{
                                            global.helpWindow.show();
                                        }
                                    }*/
                                }
                            }
                        }
                    }
                },{
                    margin: '0 5 0 0'
                },{
                    xtype: 'button',
                    iconCls: 'skin_16',
                    tooltip: '换肤',
                    height: 19,
                    width: 28,
                    margin: '0 0 0 10',
                    action: 'skin'
                },{
                    xtype: 'button',
                    iconCls: 'minimize_16',
                    hidden: IMER_CONSTANT.CLIENT == 'browser' ? true : false,
                    tooltip: '最小化',
                    height: 19,
                    width: 28,
                    margin: 0,
                    action: 'minimum',
                    handler:function(btn,e){
                        var top = this.up('topview');
                        var chain = top.getActionChain('topBaseButtons');
                        chain.execute({
                            action: btn.action
                        });
                    }
                },{
                    xtype: 'button',
                    iconCls: 'restore_16',
                    hidden: IMER_CONSTANT.CLIENT == 'browser' ? true : (!(!!webkitMaxmized)),
                    tooltip: '还原',
                    height: 19,
                    width: 28,
                    margin: 0,
                    action: 'restore',
                    handler:function(btn,e){
                        var top = this.up('topview');
                        var chain = top.getActionChain('topBaseButtons');
                        chain.execute({
                            action: btn.action
                        });
                    }
                },{
                    xtype: 'button',
                    iconCls: 'maximize_16',
                    hidden: IMER_CONSTANT.CLIENT == 'browser' ? true : (webkitMaxmized || false),
                    tooltip: '最大化',
                    height: 19,
                    width: 28,
                    margin: 0,
                    action: 'maximize',
                    handler:function(btn,e){
                        var top = this.up('topview');
                        var chain = top.getActionChain('topBaseButtons');
                        chain.execute({
                            action: btn.action
                        });
                    }
                },{
                    xtype: 'button',
                    iconCls: 'close_16',
                    hidden: IMER_CONSTANT.CLIENT == 'browser' ? true : false,
                    tooltip: '关闭',
                    height: 19,
                    width: 48,
                    margin: 0,
                    action: 'close',
                    handler:function(btn,e){
                        var top = this.up('topview');
                        var chain = top.getActionChain('topBaseButtons');
                        chain.execute({
                            action: btn.action
                        });
                    }
                }]
            }]
        });
    },
    
    getSwitchArea: function(){
        return Ext.create('Ext.container.Container', {
            width: 450,
            header: false,
            border: false,
            baseCls: '',
            layout: {
                type: 'hbox',
                align: 'middle',
                pack: 'end'
            },
            defaultType: 'container',
            items: [{
                name:'msgArea',
                border: 0,
                baseCls: '',
                defaults: {
                    border: false
                },
                items: []
            },{
                name:'switchBtn',
                border: 0,
                baseCls: '',
                defaults: {
                    border: false
                },
                items: []
            }]
        });
    }
});