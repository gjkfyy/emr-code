Ext.define('iih.po.com.block.AssistantBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel','Xap.ej.element.field.ComboBox'],

    alias:'widget.assistantblock',

    layout: 'fit',
    
    border:false,
    
    items: [{
        xtype:'xaptabpanel',
        layout: 'fit',
        border:false,
        tabButtons: [{
            itemId: 'emrWriterId',
            xtype: 'textfield',
            hidden: true
        }, {
            xtype: 'label',
            width: 5,
            hidden: true
        },{
            xtype:'xapcombobox',
            name:'enType',
            width: 50,
            labelWidth:50,
            labelAlign:'right',
            comboData : [
    			 {"code":'ENM01.01', "value":"门诊"},
                 {"code":'ENM01.04', "value":"住院"}
            ],
            displayField: 'value',
            valueField: 'code',
            allowBlank:false,
            editable:false,
            value:'',
            hidden: true //对应六院需求
        },{
            xtype: 'label',
            width: 5
        }, {
            itemId: 'encounterCombox',
            id:'assistantEncounterList',
            xtype: 'xapcombobox',
            emptyText: '请选择就诊',
            labelAlign: 'right',
            editable:false,
            maxWidth: 400,
            flex:1,
            allowBlank: true,
            forceSelection: true,
            listeners:{
                change : function(combo,newValue,oldValue) {
                    var block = combo.up('assistantblock');
                    var tabpanel = block.down('xaptabpanel');
                    var tabs = tabpanel.items.items;
                    for (var i = 0; i < tabs.length; i++) {
                        var tab = tabs[i];
                        tab.refresh = false;
                    };
                    var tab = tabpanel.getActiveTab();
                    tab.fireEvent("changeEncounter",newValue);
//                    IMER_GLOBAL.encounterSn = newValue;
                    tab.refresh = true;
                }
            }
        }, {
            xtype: 'label',
            width: 5
        }, {
    	    itemId: 'otherOmr',
    	    hidden: true,
            xtype: 'button',
//            hidden:true,
            text: '其它病历',
            handler : function() {
            	var block = this.up('assistantblock');
            	var view = block.up();
        		var chain = view.getActionChain('otherOmr');
                chain.execute();
            }
            
        },{
            xtype: 'label',
            width: 5
        },{
            itemId: 'writeToMrDocButton',
            xtype: 'button',
            text: '写回病历',
            handler : function() {
                var block = this.up('assistantblock');
                var workArea = block.up('workpageview');
                var plugin = document.getElementById('iemrEditor');
                if(plugin && !plugin.IsReadOnly()){
                    var tab = block.down('xaptabpanel').getActiveTab();
                    tab.fireEvent("writeMrDoc");
                }else{
                    XapMessageBox.warn('病历是只读的！','',workArea);
                }
            }
        }, {
            xtype: 'label',
            width: 5
        }, /*{
            itemId: 'queryButton',
            xtype: 'button',
            text: '高级查询',
            handler : function() {
            	var block = this.up('assistantblock');
            	var tab = block.down('xaptabpanel').getActiveTab();
            	if(tab){
            		var chain = tab.getActionChain('searchwindowpopup');
                    chain.execute();
            	}
            }
        },{
            xtype: 'label',
            width: 5
        },*/{
            itemId: 'refresh',
            xtype: 'tool',
            type: 'refresh'
        },{
            xtype: 'label',
            width: 5
        },{
            itemId: 'up',
            hidden: false,
            xtype: 'tool',
            type: 'up'
        },{
            itemId: 'down',
            hidden: true,
            xtype: 'tool',
            type: 'down'
        },{
            xtype: 'label',
            width: 5
        }]
    }],
    
    initComponent: function() {
        this.callParent();
        var me = this;
        var tabpanel = this.down('xaptabpanel');
        if (tabpanel.tabButtons.length > 0 && !this.hideTabBar) {
            this.initTabButton();
        };
        
        var helpContent = me.down('xaptabpanel');
        var up = helpContent.down('tool[itemId=up]');
        var down = helpContent.down('tool[itemId=down]');
        /*var otherMr = helpContent.down('tool[itemId=otherOmr]');
        otherMr.addListener('click', function() {
        	alert("in");
        });*/
        down.addListener('click', function() {
            me.minimize();
            up.show();
            down.hide();
        });
        up.addListener('click', function() {
            me.maximize(CONFIG_PARAM.ASSISTANT_HEIGHT);//wangyanli 将助手去高度设置为可配置参数，默认为300，根据不同医院需求配置参数
            up.hide();
            down.show();
        });
        var refresh = helpContent.down('tool[itemId=refresh]');
        refresh.addListener('click', function() {
            var tab = helpContent.getActiveTab();
            var mrCombo = helpContent.down('xapcombobox[itemId=encounterCombox]');
            var enNo = mrCombo.getValue();
            if(tab && enNo)
                tab.fireEvent("changeEncounter",enNo);
        });
        var tbar = helpContent.getTabBar();
        tbar.addListener('dblclick', function(tabBar, e) {
            var target=e.getTarget();
            if(e.getTarget().tagName.toLowerCase() == "div"){
                if(down.hidden==false){
                    me.minimize();
                    up.show();
                    down.hide();
                  }else{
                      //me.maximize(300);
                	  me.maximize(CONFIG_PARAM.ASSISTANT_HEIGHT);//wangyanli 将助手去高度设置为可配置参数，默认为300，根据不同医院需求配置参数
                    up.hide();
                    down.show();
                  }
            }
        });
        helpContent.addListener('tabchange', function(p,n,o) {
            var mrCombo = p.down('xapcombobox[itemId=encounterCombox]');
            mrCombo.setDisabled(!n.haveEncounter);
            var writeButton = p.down('button[itemId=writeToMrDocButton]');
            writeButton.setDisabled(!n.haveEncounter);
            /*var queryButton = p.down('button[itemId=queryButton]');
            queryButton.setDisabled(!n.isQuery);*/
            /*if(n.isQuery){
                queryButton.addListener('click', function() {
                    var chain = n.getActionChain('searchwindowpopup');
                    chain.execute();
                });
            };*/
            if(!n.refresh && mrCombo.getValue()){
                n.fireEvent("changeEncounter",mrCombo.getValue());
                n.refresh = true;
            }
        });
        //me.minimize();
        helpContent.setActiveTab(0);
    },
    
    initTabButton: function() {
        var tabpanel = this.down('xaptabpanel');
        tabpanel.getTabBar().add({
            xtype: 'container',
            layout: {
                type: 'hbox',
                align: 'middle',
                pack: 'end'
            },
            flex: 1,
            items: Ext.isArray(tabpanel.tabButtons) ? tabpanel.tabButtons : [tabpanel.tabButtons]
        });
    },
    
    maximize: function(h) {
        this.setHeight(h);
    },
    
    minimize: function() {
        this.setHeight(32);
    },
    
    setEncouterData: function(data){
        var combo = this.down('xapcombobox[itemId=encounterCombox]');
        if(combo){
            combo.clearValue();
            if(data){
                var array = new Array();
                Ext.each(data,function(rec){
                    if(rec){
                        var time = Ext.Date.parse(rec.currentDeptIntoTime, 'time');
                        var value = Ext.Date.format(time, 'Y-m-d H:i');
                        //var value = Ext.util.Format.date(rec.currentDeptIntoTime, "Y-m-d H:i:s");
                        value = value + '_';
                        value = value + rec.encounterTypeName;
                        //病历文书数，需要开关配置，因为有的医院只上门诊，住院病历文书数为0，不准确
                        if(CONFIG_PARAM.OUT_MR_COUNT && rec.encounterTypeName=='门诊'){
                        	value = value + "("+rec.mrTotal+")";
                        }
                        if(CONFIG_PARAM.IN_MR_COUNT && rec.encounterTypeName=='住院'){
                        	value = value + "("+rec.mrTotal+")";
                        }
                        value = value + '_';
                        value = value + rec.currentDeptName;
                        if(rec.currentMainDiagnosisName){
                            value = value + '_';
                            value = value + rec.currentMainDiagnosisName;
                        }
                        value = value + '_';
                        value = value + "("+rec.mrTotal+")";
                        array.push({'text':value,'value':rec.pk});
                    }
                });
                combo.setData(array);
                //var record = combo.getStore().getAt(0);
                //combo.select(record);
                combo.setValue(IMER_GLOBAL.encounterSn);
            }
        }
    }
})