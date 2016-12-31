Ext.define('iih.po.com.block.PatientPopForNurseBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.patientpopfornurseblock',

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
                    var block = win.down('patientpopfornurseblock');
                    block.changePatient(win,rec.raw);
                }
            }
        },
        items:[{
            title:'本人患者',
            groupType:1
        },{
            title:'病区患者',
            groupType:2
        },{
            title:'转出患者',
            groupType:3
        },{
            title:'出院未完成患者',
            groupType:6
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
                        var view = owner.up('patientpopfornurseview');
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
                var view = tabPanel.up('patientpopfornurseview');
                var curMgNurId = view.down('comboxgrid[name=curMgNurId]');
                var startDate = view.down('xapdatefield[name=startDate]');
                var endDate = view.down('xapdatefield[name=endDate]');
                var finishTime = view.down('rangedatefield[name=finishTime]');
                if(newCard.groupType == 6 || newCard.groupType == 7){
                    if(curMgNurId)curMgNurId.setDisabled(false);
                    if(finishTime)finishTime.setDisabled(false);
                }else{
                    if(curMgNurId){
                        curMgNurId.setDisabled(true);
                        curMgNurId.reset();
                    };
                    if(finishTime){
                        finishTime.setDisabled(true);
                        startDate.reset();
                        startDate.setMaxValue(null);
                        endDate.reset();
                        endDate.setMinValue(null);
                    };
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
                var block = win.down('patientpopfornurseblock');
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
            header:'经治医师',
            dataIndex:'currentManageDoctorName',
            width:100
        },{
            header:'主治医师',
            dataIndex:'majorDoctorName',
            width:100
        },{
            header:'主任医师',
            dataIndex:'directorDoctorName',
            width:100
        },{
            header:'主管护士',
            dataIndex:'currentManageNurseName',
            width:100
        }];
        return columnConfig;
    },
    
    changePatient: function(win,rec){
        var pk = rec.pk;
        if(pk == IMER_GLOBAL.encounterSn){
            win.close();
        }else{
        	if(rec.viewF == '1'){//从视图读取 开关 
        		//1	获取groupType
            	var block = win.down('patientpopfornurseblock');
    	    	var tabpanel = block.down('xaptabpanel');
    	        var grid = tabpanel.getActiveTab();
    	        var groupType = grid.groupType;
    	        
    	        //2  当 切换到 1：本人患者, 2：全科患者  时,需将点击的患者同步到mr_amr表中
                if(groupType == '1' || groupType == '2') {
                	 var patientpopfornurseview = Ext.getCmp('patientpopfornurseview');
                     var syncPaToMrAmrChain = patientpopfornurseview.getActionChain('syncPaToMrAmr');
                     
            
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
        var openPages = new Array();
        var openPageCount = 0;
        var tabs = workArea.items.items;
        Ext.each(tabs,function(item){
            if(!item.baseMenu && !item.isItem)
                closePages.push(item);
            else{
                openPageCount++;
                openPages.push(item);
            }
        });
        var callBack = function(patient){
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:patient});
        };
        workArea.callBack = {
            method: callBack,
            params: [rec]
        };
        if(closePages && closePages.length>0){
            workArea.closePages = closePages;
            var canvas = Xap.getCanvas();
            canvas.fireEvent("portalRender");
        }else{
            workArea.openPageCount = openPageCount;
            workArea.openPages = openPages;
            var canvas = Xap.getCanvas();
            canvas.fireEvent("portalRender2");
            win.close();
        }
    }
})