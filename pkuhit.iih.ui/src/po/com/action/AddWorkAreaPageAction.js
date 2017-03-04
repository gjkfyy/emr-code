Ext.define('iih.po.com.action.AddWorkAreaPageAction', {
	extend: 'Xap.ej.action.Action',
	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var me = this;
	    this.pageCode = context.pageCode;
        this.pageTitle = context.pageTitle;
        this.viewConfig = context.viewConfig;
	    var view = this.getOwner();
        var workarea = view.down('workareapageview');
        var tabs = workarea.items.items;
        var page = null;
        for (var i = 0; i < tabs.length; i++) {
            var tab = tabs[i];
            if (tab.tabId == this.pageCode) {
                page = tab;
                break;
            }
        };
        var config;
        var plugin = Xap.ej.platform.Plugin;
        var list = plugin.getExtensionPoint('functionlist');
        if(list.extensions.length > 0) {
            for(var i=0;i<list.extensions.length;i++){
                var item = list.extensions[i];
                if(this.pageCode == item.cd){
                    config = item;
                    break;
                }
            }
        };
        if(page){
            var workView = workarea.getMainPage(page.tabId);
            //Ext.apply(workView,this.viewConfig);
            workarea.setActiveTab(page);
            if(config && config.editorInside){
                var callBack = function(){
                    this.addPage(arguments[0]);
                };
                workarea.callBack = {
                    method: callBack,
                    scope: this,
                    params: [config]
                };
                var closePages = new Array();
                closePages.push(page);
                workarea.closePages = closePages;
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender");
            }
        }else{
            if(config){
                if(config.baseMenu){
                    var callBack = function(){
                        this.addPage(arguments[0]);
                    };
                    workarea.callBack = {
                        method: callBack,
                        scope: this,
                        params: [config]
                    };
                    workarea.closePages = null;
                    var canvas = Xap.getCanvas();
                    canvas.fireEvent("portalRender");
                }else{
                    this.addPage(config);
                }
                
            }
        };
        
        if(config.itemView){
            var canvas = Xap.getCanvas();
            canvas.fireEvent("addWorkPage",{pageCode:config.itemView.cd});
        }
       
    },
    	
    addPage: function(config){
        var view = this.getOwner();
        var workarea = view.down('workareapageview');
        if(config.assistantConfig){
            var tabConfig = {
                    xclass: 'iih.po.com.view.WorkPageView',
                    tabId: this.pageCode,
                    title: this.pageTitle?this.pageTitle:config.text,
                    closable: config.closable,
                    baseMenu: config.baseMenu,
                    isItem: config.isItem,
                    haveAssistant: true,
                    hideMode:'offsets'
            };
            var view =  Xap.create(tabConfig);
            
            var workContent = view.getBlock('workContent');
            workContent.removeAll();
            var workView =  Ext.create(config.xclass,config.viewConfig);
            Ext.apply(workView,this.viewConfig);
            Ext.apply(workView,{itemId:this.pageCode});
            if(IMER_GLOBAL.revisionCd){
                Ext.apply(workView,{revisionCd:IMER_GLOBAL.revisionCd});
                IMER_GLOBAL.revisionCd = null;
            };
            workContent.add(workView);
            
            var helpContent = view.getBlock('helpContent');
            var helpTab = helpContent.down('xaptabpanel');
            var plugin = Xap.ej.platform.Plugin;
            var list = plugin.getExtensionPoint('assistant');
            if(list.extensions.length > 0) {
                for(var i=0;i<list.extensions.length;i++){
                    var item = list.extensions[i];
                    var helpCfg = {
                        tabId: item.cd,
                        title: item.text,
                        xclass: item.xclass,
                        isQuery:item.isQuery,
                        haveEncounter:item.haveEncounter,
                        hideMode:'offsets'
                    };
                    helpTab.add(Ext.create(helpCfg));
                }
            };
            helpTab.setActiveTab(0);
        }else{
            var tabConfig = {
                        xclass: config.xclass,
                        tabId: this.pageCode,
                        title: this.pageTitle?this.pageTitle:config.text,
                        closable: config.closable,
                        baseMenu: config.baseMenu,
                        isItem: config.isItem,
                        hideMode:'offsets'
                };
            var view =  Xap.create(tabConfig);
            Ext.apply(view,this.viewConfig);
            Ext.apply(view,config.viewConfig);
            if(IMER_GLOBAL.revisionCd){
                Ext.apply(view,{revisionCd:IMER_GLOBAL.revisionCd});
                IMER_GLOBAL.revisionCd = null;
            };
        };
        var tabbar = workarea.getTabBar();
        var enContainer = tabbar.down('container[name=enContainer]');
        if(enContainer)
            tabbar.remove(enContainer);
        if(config.haveEncounter){
            tabbar.add({
                xtype: 'container',
                name: 'enContainer',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end'
                },
                flex: 1,
                items: [{
                    itemId: 'encounterCombox',
                    id:'encounterSelectCombox',
                    xtype: 'xapcombobox',
                    emptyText: '请选择就诊',
                    labelAlign: 'right',
                    editable:false,
                    width: 300,
                    allowBlank: true,
                    forceSelection: true,
                    listeners:{
                        afterrender: function(combo) {
                            var action = Xap.create({
                                xclass: 'iih.po.com.action.AssistantInitAction'
                            });
                            action.combo = combo;
                            Xap.runAction(action);
                        },
                        change : function(combo,newValue,oldValue) {
                            var tabpanel = combo.up('workareapageview');
                            var tab = tabpanel.getActiveTab();
                            if(tab)
                                tab.fireEvent("changeEncounter",newValue);
                        }
                    }
                },{
                    xtype: 'label',
                    width: 5
                }]
            });
        };
        
        //门诊病历书写添加“模板选择”按
        if((config.cd='XAPM07.69'||config.cd=='XAPM07.82')){
            tabbar.add({
                xtype: 'container',
                name: 'enContainer',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end'
                },
                flex: 1,
                items: [{
                    xtype: 'button',
                    id:'erpSignBtn',
                    text: '电子签名',
                    disabled:true,
                    hidden:true,
                    handler : function() {
                    	var iemrEditor=document.getElementById('iemrEditor');//取到编辑器插件
                    	if(iemrEditor&&iemrEditor.valid){
    			    		if(iemrEditor.IsModified()){
    			                Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
    			                return false;
    			            }
                    	}else{
                    		Ext.MessageBox.alert('提示', '请打开病历以后在签名！');
                    		return;
                    	}
                    	var pdfPath=iemrEditor.ExportPDF();
                    	pdfPath=pdfPath.replace('file:///','');
                    	var context={erpSignType:'erpSign',pdfPath:pdfPath} ;
                    	var outmrwriteview=Ext.getCmp('outmrwriteview');
                    	var createAction=outmrwriteview.getActionChain('createErpSign');
                    	createAction.execute(context);
                    }
                },{
                    xtype: 'label',
                    width: 5
                },{
                    xtype: 'button',
                    id:'serchErpSignBtn',
                    text: '浏览签名',
                    hidden:true,
                    disabled:true,
                    handler : function() {
                    	var context={erpSignType:'serchErpSign'} ;
                    	var outmrwriteview=Ext.getCmp('outmrwriteview');
                    	var createAction=outmrwriteview.getActionChain('createErpSign');
                    	createAction.execute(context);
                    }
                },{
                    xtype: 'label',
                    width: 5
                },/*{									//去掉页面右上方的"重新选择模板"模板按钮    wang_dehong 2017-03-04
                    xtype: 'button',
                    id:'reSelectTempBtn',
                    text: '重新选择模板',
                    hidden:false,
                    disabled:true,
                    handler : function() {
                    	XapMessageBox.confirm2('重新选择模板会覆盖当前正在编辑的病历，是否继续？', function(id){
            				if(id=='yes'){
            					var context={opType:'reSelectTemp'} ;
                            	var outmrwriteview=Ext.getCmp('outmrwriteview');
                            	var createAction=outmrwriteview.getActionChain('create');
                            	createAction.execute(context);
            				}else{
            					me.enable();
            				}
            			});
                    }
                },*/{     
                	xtype: 'label',
                    width: 5
                },{
                	xtype: 'button',
                	id:'callOrderBtn',
                	text: 'CIS调用',
                	hidden:true,
                	//disabled:true,
                	handler : function() {
                		var context={} ;
        				var outmrwriteview=Ext.getCmp('outmrwriteview');
        				var createAction=outmrwriteview.getActionChain('createOrder');
        				createAction.execute(context);
                	}
                },{
                    xtype: 'label',
                    width: 5
                },{
                	xtype: 'button',
                	id:'encounterOverBtn',
                	text: '诊毕',
                	hidden:true,
                	//disabled:true,
                	handler : function() {
                		XapMessageBox.confirm2('该患者是否完成就诊？', function(
                				btn) {
                			if (btn == 'yes') {
                				var context={} ;
                				var portalview = Ext.getCmp('portalview');
                				var patientPopAction = portalview.getActionChain('patientPop');
                				patientPopAction.execute(context);
                			}

                		});
                		
                	}
                },{
                    xtype: 'label',
                    width: 5
                },{
                    xtype: 'button',
                    id:'zKOnlineCd',
                    text: '指纹录入',
                    hidden:true,
                    buttonAlign:'right',                    
                    //margin:'0 5 0 0',
                    //disabled:true,
                    handler : function() {
                        if(config.cd=='XAPM07.69'){
                        	console.log(Ext.getCmp('outmrwriteview'));
                            var showSyqyComp= Ext.getCmp('outmrwriteview').getActionChain('showSyqyComp');
                            showSyqyComp.execute();
                        } else if(config.cd=='mrdoceditview'){
                            var showSyqyComp= Ext.getCmp('mrdoclistview').getActionChain('showSyqyComp');
                            showSyqyComp.execute();
                        }
                    }
                },{
                    xtype: 'label',
                    width: 5
                }]
            });
        };
      //住院指纹录入按钮
        /*if(config.cd=='mrdoceditview'||config.cd=='XAPM07.69'){
            tabbar.add({
                xtype: 'container',
                name: 'enContainer',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end'
                },
                flex: config.cd=='XAPM07.69'?'':1,
                items: [{
                	xtype: 'button',
                	id:'zKOnlineCd',
                	text: '指纹录入',
                	hidden:true,
                	buttonAlign:'right',                  	
                	//margin:'0 5 0 0',
                	//disabled:true,
                	handler : function() {
                		if(config.cd=='XAPM07.69'){
                			var showSyqyComp= Ext.getCmp('outmrwriteview').getActionChain('showSyqyComp');
                    		showSyqyComp.execute();
                		} else if(config.cd=='mrdoceditview'){
                			var showSyqyComp= Ext.getCmp('mrdoclistview').getActionChain('showSyqyComp');
                    		showSyqyComp.execute();
                		}
                	}
                },{
                    xtype: 'label',
                    width: 5
                }]
            });
        };*/
      //住院病历书写添加“病案首页”按钮
        if((config.cd=='XAPM07.05')){
            tabbar.add({
                xtype: 'container',
                name: 'enContainer',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end'
                },
                flex: 1,
                items: [{
                	xtype: 'button',
                	id:'callPatCaseBtn',
                	text: '病案首页',
                	hidden:true,
                	//disabled:true,
                	handler : function() {
                		var context={} ;
        				var mrwriteview=Ext.getCmp('mrdoclistview');
        				var createAction=mrwriteview.getActionChain('patCase');
        				createAction.execute(context);
                	}
                },{
                    xtype: 'label',
                    width: 5
                }]
            });
        };
      //护理病历书写已完成按钮
        if(config.cd=="XAPM07.96"){
            tabbar.add({
                xtype: 'container',
                name: 'enContainer',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end'
                },
                flex:1,
                items: [{
                	xtype: 'button',
                	id:'writeCompleted',
                	text: '书写完成',
                	hidden:false,
                	//disabled:true,
                	handler : function() {
             			var context={};
                		var nursingrecordsview=Ext.getCmp('nursingrecordsview');
                		var checkFinish=nursingrecordsview.getActionChain('checkFinish');
                		checkFinish.execute(context);
                	}
                },{
                    xtype: 'label',
                    width: 5
                },{
                	xtype: 'button',
                	id:'matchPrintBtn',
                	text: '批量打印',
                	hidden:false,
                	//disabled:true,
                	handler : function() {
                		var context={};
	    				var nursingrecordsview=Ext.getCmp('nursingrecordsview');
	    				var finish=nursingrecordsview.getActionChain('showBatchPrint');
	    				finish.execute(context);
                		
                	}
                },{
                    xtype: 'label',
                    width: 5
                },{
                    xtype: 'button',
                    id:'zKOnlineCd',
                    text: '指纹录入',
                    hidden:true,
                    buttonAlign:'right',                    
                    //margin:'0 5 0 0',
                    //disabled:true,
                    handler : function() {
                    	console.log(Ext.getCmp('nursingrecordsview'));
	                    var showSyqyComp= Ext.getCmp('nursingrecordsview').getActionChain('showSyqyComp');
	                    showSyqyComp.execute();
                    }
                }]
            });
        };
        workarea.add(view).show();
        workarea.setActiveTab(view);
        if(config.isItem)
            workarea.setActiveTab(0);
    }
});