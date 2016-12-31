Ext.define('iih.po.com.block.PatientPopBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.patientpopblock',

    layout: 'fit',
    
    flex: 1,
    
    border:false,
    
    items:[{
        xtype:'xaptabpanel',
        layout: {
            type:'vbox',
            align:'stretch'
        },
        border:false,
        defaults:{
            xtype:'xapgrid',
            selectBy:'pk',
            layout: 'fit',
            border:false,
            pageShow:true,
            pageSize:30,
            flex:1,
            listeners: {
                itemdblclick: function(grid, rec, item, index) {
                    var win = grid.up('window');
                    var block = win.down('patientpopblock');
                    block.changePatient(win,rec.raw);
                }
            }
        },
        items:[{
            title:'本人患者',
            groupType:1
        },{
            title:'全科患者',
            groupType:2
        },{
            title:'转出患者',
            groupType:3
        },{
            title:'出院未完成患者',
            groupType:6
        },{
            title:'跨科就诊患者',
            //hidden:true,
            groupType:4
        },{
            title:'会诊患者',
            //hidden:true,
            groupType:5
        },{
            title:'全部患者',
            hidden: true,
            groupType:7
        }],
        tabBar: {
            items:[{
                xtype: 'container',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end',
                    padding: '2 0 0 0'
                },
                flex: 1,
                items: [{
                    xtype: 'tool',
                    itemId: 'refreshBtn',
                    type: 'refresh',
                    tooltip: '刷新',
                    callback:function(owner,tool){
                        var view = owner.up('patientpopview');
                        var chain = view.getActionChain('init');
                        chain.execute();
                    }
                },{
                    xtype: 'label',
                    width: 5
                }]
            }]
        },
        listeners:{
            tabchange: function(tabPanel, newCard, oldCard) {
                var block = tabPanel.up('patientpopblock');
                var btn = block.down('button[itemId=doctorBtn]');
                if(newCard.groupType == 1){
                    btn.setDisabled(false);
                }else{
                    btn.setDisabled(true);
                };
                var view = tabPanel.up('patientpopview');
                var currentBedCode = view.down('xaptextfield[name=currentBedCode]');
                var amrNo = view.down('xaptextfield[name=amrNo]');
                var patientName = view.down('xaptextfield[name=patientName]');
                var respDctId = view.down('comboxgrid[name=respDctId]');
                var startDate = view.down('xapdatefield[name=startDate]');
                var endDate = view.down('xapdatefield[name=endDate]');
                var finishTime = view.down('rangedatefield[name=finishTime]');
                if(newCard.groupType > 3){
                    if(finishTime){
                        finishTime.setDisabled(false);
                        finishTime.show();
                    }
                }else{
                    if(finishTime){
                        finishTime.setDisabled(true);
                        startDate.reset();
                        startDate.setMaxValue(null);
                        endDate.reset();
                        endDate.setMinValue(null);
                        finishTime.hide();
                    };
                };
                if(newCard.groupType == 4 || newCard.groupType == 5){
                    if(currentBedCode){
                        currentBedCode.hide();
                        currentBedCode.setValue(null);
                    }
                    if(amrNo){
                        amrNo.hide();
                        amrNo.setValue(null);
                    }
                    if(patientName){
                        patientName.hide();
                        patientName.setValue(null);
                    }
                    /*if(respDctId){
                        respDctId.setDisabled(false);
                        respDctId.show();
                    }*/
                    if(finishTime)finishTime.setFieldLabel('时间范围');
                }else{
                    if(currentBedCode){
                        currentBedCode.show();
                        currentBedCode.setValue(null);
                    }
                    if(amrNo){
                        amrNo.show();
                        amrNo.setValue(null);
                    }
                    if(patientName){
                        patientName.show();
                        patientName.setValue(null);
                    }
                    if(respDctId){
                        respDctId.setDisabled(false);
                        respDctId.hide();
                    }
                    if(finishTime)finishTime.setFieldLabel('出院时间');
                }
            }
        }
    }],
    
    buttons:[{
        xtype: "container",
        flex: 1,
        layout: {
            type: 'hbox',
            align: 'middle',
            pack: 'start'
        },
        items: [{
            xtype: "button",
            itemId: 'doctorBtn',
            text: '三级检诊医师',
            handler:function(btn,e){
                var win = this.up('window');
                var view = this.up('patientpopview');
                var tabpanel = win.down('xaptabpanel');
                var grid = tabpanel.getActiveTab();
                var record = grid.getSelectionModel().getSelection();
                if(record && record.length>0){
                    var rec = record[0].raw;
                    
                 // wangyanli add  2016-8-3 如果患者从视图读取，则点击患者时，需将该患者同步到mr_amr
                	if(rec.viewF == '1'){//从视图读取 开关 
                		//1	获取groupType
                    	var block = win.down('patientpopblock');
            	    	var tabpanel = block.down('xaptabpanel');
            	        var grid = tabpanel.getActiveTab();
            	        var groupType = grid.groupType;
            	        
            	        //2  当 切换到 1：本人患者, 2：全科患者  时,需将点击的患者同步到mr_amr表中
                        if(groupType == '1' || groupType == '2') {
                        	 var patientpopview = Ext.getCmp('patientpopview');
                             var syncPaToMrAmrChain = patientpopview.getActionChain('syncPaToMrAmr');
                             
                    
                             var context = {
                             		patient:rec,
                             		callback:{                                
                                         params: win,
                                         chainParam:'setDoctor'
                             		}
                             }
                             syncPaToMrAmrChain.execute(context);
                        }
                    // wangyanli end
                	}else{
                		var chain = view.getActionChain('setDoctor');
                        chain.execute({
                            patient: rec
                        });
                	}
                    
                }else{
                    XapMessageBox.warn('请选择患者！','',win);
                }
            }
        }]
    },{
        xtype: "container",
        flex: 1,
        layout: {
            type: 'hbox',
            align: 'middle',
            pack: 'end'
        },
        items: [{
            xtype: "button",
            name: 'confim',
            method:'confim',
            width: 75,
            text: '确认',
            style : 'margin-right:10px',
            handler:function(btn,e){
                var win = this.up('window');
                var block = win.down('patientpopblock');
                var tabpanel = win.down('xaptabpanel');
                var grid = tabpanel.getActiveTab();
                var record = grid.getSelectionModel().getSelection();
                if(record && record.length>0){
                    var rec = record[0].raw;
                    block.changePatient(win,rec);
                }else{
                    XapMessageBox.warn('请选择患者！','',win);
                }
            }
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            width: 75,
            text: '取消',
            handler:function(btn,e){
                var win = this.up('window');
                if(IMER_GLOBAL.encounterSn){
                    win.close();
                }else{
                    XapMessageBox.warn('请选择患者！','',win);
                }
            }
        }]
    }],
    
    initComponent: function() {
        var me = this;
        Ext.each(me.items[0].items,function(item){
            item.CM_JR_Record = me.createGridColumn(item.groupType);
        });
        me.callParent();
    },
    
    createGridColumn: function(groupType) {
        var columnConfig = [{
            dataIndex:'pk',
            hidden:true
        },{
            dataIndex:'patientId',
            hidden:true
        },{
            header:'床号',
            dataIndex:'currentBedCode',
            width:70
        },{
            header:'住院号',
            dataIndex:'amrNo',
            width:100
        },{
            header:'姓名',
            dataIndex:'patientName',
            width:80
        },{
            header:'性别',
            dataIndex:'sexName',
            width:50
        },{
            header:'年龄',
            dataIndex:'age',
            width:50
        },{
            header:'入科时间',
            xtype:'xapdatecolumn',
            dataIndex:'currentDeptIntoTime',
            flex:2
        },{
            header:'出院时间',
            xtype:'xapdatecolumn',
            dataIndex:'finishTime',
            hidden:((groupType==6 || groupType==7)?false:true),
            flex:2
        },{
            header:'执行科室',
            dataIndex:'execUnitName',
            hidden:((groupType==4 || groupType==5)?true:true),
            width:100
        },{
            header:'申请科室',
            dataIndex:'requestDeptName',
            hidden:((groupType==4 || groupType==5)?false:true),
            width:100
        },{
            header:'申请时间',
            xtype:'xapdatecolumn',
            dataIndex:'respTime',
            hidden:((groupType==4 || groupType==5)?false:true),
            flex:2
        },{
            header:'经治医师',
            dataIndex:'currentManageDoctorName',
            hidden:((groupType==4 || groupType==5)?true:false),
            width:100
        },{
            header:'主治医师',
            dataIndex:'majorDoctorName',
            hidden:((groupType==4 || groupType==5)?true:false),
            width:100
        },{
            header:'主任医师',
            dataIndex:'directorDoctorName',
            hidden:((groupType==4 || groupType==5)?true:false),
            width:100
        },{
            header:'描述',
            dataIndex:'mrSummary',
            hidden:((groupType==4 || groupType==5)?false:true),
            flex:2
        },{
            header:'是否从视图读取',
            dataIndex:'viewF',
            hidden:true
        }];
        return columnConfig;
    },
    
    changePatient: function(win,rec){
        var pk = rec.pk;
        if(pk == IMER_GLOBAL.encounterSn){
            win.close();
        }else{
        	
        	// wangyanli add  2016-8-3 如果患者从视图读取，则点击患者时，需将该患者同步到mr_amr
        	
        	if(rec.viewF == '1'){//从视图读取 开关 
        		//1	获取groupType
            	var block = win.down('patientpopblock');
    	    	var tabpanel = block.down('xaptabpanel');
    	        var grid = tabpanel.getActiveTab();
    	        var groupType = grid.groupType;
    	        
    	        //2  当 切换到 1：本人患者, 2：全科患者  时,需将点击的患者同步到mr_amr表中
                if(groupType == '1' || groupType == '2') {
                	 var patientpopview = Ext.getCmp('patientpopview');
                     var syncPaToMrAmrChain = patientpopview.getActionChain('syncPaToMrAmr');
                     
            
                     var context = {
                     		patient:rec,
                     		callback:{                                
                                 params: win,
                                 chainParam:'updatePatient'
                     		}
                     }
                     syncPaToMrAmrChain.execute(context);
                }
            // wangyanli end                
        	}else{
        		 this.refreshPage(win, rec);
        	}
        }
    },
    
    refreshPage: function(win, rec){
        var workArea = Ext.getCmp('workareapageview');
        var closePages = new Array();
        var tabs = workArea.items.items;
        Ext.each(tabs,function(item){
            if(!item.baseMenu)
                closePages.push(item);
        });
        if(closePages && closePages.length>0){
            var callBack = function(patient){
                var canvas = Xap.getCanvas();
                canvas.fireEvent("updatePatient",{patient:patient});
                this.close();
            };
            workArea.callBack = {
                method: callBack,
                scope: win,
                params: [rec]
            };
            workArea.closePages = closePages;
            var canvas = Xap.getCanvas();
            canvas.fireEvent("portalRender");
        }else{
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:rec});
            win.close();
        }
    }
})