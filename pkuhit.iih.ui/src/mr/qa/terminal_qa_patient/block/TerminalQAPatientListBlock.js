Ext.define('iih.mr.qa.terminal_qa_patient.block.TerminalQAPatientListBlock',{
	extend : 'Xap.ej.block.FormBlock',

	alias:'widget.terminalqapatientlistblock',

	requires: ['Xap.ej.block.ToolbarBlock'],
		   	
	layout: 'fit',

	border: 0,
	items: [{
        xtype:'xaptabpanel',
//        layout: '',
        border:false, 
        items:[{
            title:'待签收患者一览',
            groupType:1,
            name:'waitSign',
            xtype:'xappanel',
           layout: {
			    type : 'vbox',
			    align : 'stretch'
			},
            items:[{
            xtype:'xapform',
            height:76,
            layout: {
				type: 'table',
				columns: 3,
				//width: 1024,
				tableAttrs: {
		            border: 0,
		            cellpadding: 0,
		            cellspacing: 1,
		            width: '100%',
		            height:56
		        },
		        tdAttrs: {
		            valign: 'left'
		        }
			},
            items:[{
			xtype:'comboxgrid',
			margin:'10 0 10 0',
			name:'curDeptNm',
			method:'curDeptNmWait',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'科室',
			labelAlign : 'right',
			labelWidth : 50,
			listWidth:230,    //gird的宽度
			width:210,        //combo的宽度
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
			columns: [{              //grid的column配置
			   text: '科室编码',
			   dataIndex: 'code',
			   width:80
			},{
			   text: '科室',
			   flex:1,
			   dataIndex: 'name'
			}],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('terminalqapatientlistview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					curDeptNm:newValue
				});
			    console.log(newValue);     //本次选择的科室编码
			    console.log(oldValue);     //上次选择的科室编码
			    console.log(record);       //本次选择的科室完整记录
			}
            },{
				xtype:'xaptextfield',
		        name:'amrNo',
		        method:'amrNoWait',
		        labelWidth:60,
		        labelAlign:'right',
		        fieldLabel:'住院号',
		        listeners:{
		        	specialkey : function(field, e) {  
		                if (e.getKey() == Ext.EventObject.ENTER) {  
		                    var view = this.up('terminalqapatientlistview');
							var initChain = view.getActionChain('search');
							initChain.execute({}); 
		                }  
		            }
		        }
			},{
				xtype:'xaptextfield',
		        name:'patientName',
		        method:'patientNameWait',
		        labelWidth:60,
		        labelAlign:'right',
		        fieldLabel:'患者姓名',
		        listeners:{
		        	specialkey : function(field, e) {  
		                if (e.getKey() == Ext.EventObject.ENTER) {  
		                    var view = this.up('terminalqapatientlistview');
							var initChain = view.getActionChain('search');
							initChain.execute({}); 
		                }  
		            }
		        }
			},{
				xtype:'xaptoolbarblock',
				method:'searchWait',
				colspan:3,
				items: [{
					xtype: 'button',
					text: '查询',
					iconCls: 'icon-Search',
					action: 'searchWait'
				}]
			}]
            
			},{
			    xtype: 'xapgrid',
			    name:'waitSignGrid',
			    border: 0,
			    ifSelect : true,
			    selectBy: 'pk',
			    flex:1,
				tools:[{
			       xtype:'button',
			       name:'sign',
			       text:'签收',
			       method:'sign',
           		   disabled : true
			   },{
				   xtype: 'label',		              
			       width:10
			   }],
			    selType:'checkboxmodel',
				autoScroll:true,
			   	pageSize : 25,
				pageShow : true
			}]
        },{
            title:'已签收患者一览',
            name:'alreadySign',
            xtype:'xappanel',
            groupType:2,
            layout: {
			    type : 'vbox',
			    align : 'stretch'
			},
            items:[{
            xtype:'xapform',
            height:108,
            layout: {
				type: 'table',
				columns: 12,
				//width: 1024,
				tableAttrs: {
		            border: 0,
		            cellpadding: 0,
		            cellspacing: 1,
		            width: '100%',
		            height:56
		        },
		        tdAttrs: {
		            valign: 'left'
		        }
			},
            items:[{
			xtype:'comboxgrid',
			colspan:4,
			margin:'10 0 10 0',
			name:'curDeptNm',
			method:'curDeptNmAlready',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'科室',
			labelAlign : 'right',
			labelWidth : 50,
			listWidth:230,    //gird的宽度
			width:210,        //combo的宽度
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
			columns: [{              //grid的column配置
			   text: '科室编码',
			   dataIndex: 'code',
			   width:80
			},{
			   text: '科室',
			   flex:1,
			   dataIndex: 'name'
			}],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('terminalqapatientlistview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					curDeptNm:newValue
				});
			    console.log(newValue);     //本次选择的科室编码
			    console.log(oldValue);     //上次选择的科室编码
			    console.log(record);       //本次选择的科室完整记录
			}
			},{
		          xtype: 'xapdatefield',
	    	      name:'beginTime',
	    	      labelWidth:80,
	    	      width:190,
		    	      margin:'0 -40 0 10',
	    	      labelAlign:'right',
	    	      editable:false,
	    	      fieldLabel:'出院时间'
	    	  },{
	    		  	xtype: 'xapdisplayfield',
	    			fieldLabel: '',
	    			labelWidth:20,
	    			vertical: true,
	    			name:'fenge',
	    			value: '~'/*,
	    			margin:'0 60 0 0'*/
		    	},{
		    	  	xtype: 'xapdatefield',
		    	//    autoScroll:true,
		    	  	name:'endTime',
		    	  	labelWidth:60,
		    	  	width:120,
		    	  	labelAlign:'left',
//		    	  	margin:'10 0 10 0',
		    	  	editable:false
		    	},{
					xtype:'xaptextfield',
					colspan:4,
			        name:'patientName',
			        method:'patientNameAlready',
			        labelWidth:60,
			        labelAlign:'right',
			        fieldLabel:'患者姓名',
			        listeners:{
			        	specialkey : function(field, e) {  
			                if (e.getKey() == Ext.EventObject.ENTER) {  
			                    var view = this.up('terminalqapatientlistview');
								var initChain = view.getActionChain('search');
								initChain.execute({}); 
			                }  
			            }
			        }
			   },{
				  	xtype: 'xapdisplayfield',
					fieldLabel: '',
					width:150,
					vertical: true,
					name:'tiankong',
					value: ''
			  },{
					xtype:'xaptextfield',
					colspan:4,
			        name:'amrNo',
			        method:'amrNoAlready',
			        labelWidth:60,
			        labelAlign:'right',
			        fieldLabel:'住院号',
			        listeners:{
			        	specialkey : function(field, e) {  
			                if (e.getKey() == Ext.EventObject.ENTER) {  
			                    var view = this.up('terminalqapatientlistview');
								var initChain = view.getActionChain('search');
								initChain.execute({}); 
			                }  
			            }
			        }
				},{
		          xtype: 'xapnumberfield',
	    	      name:'qaAutoScrMin',
	    	      labelWidth:80,
	    	      width:190,
	    	       margin:'0 -40 10 10',
	    	      labelAlign:'right',
	    	      editable:true,
	    	      fieldLabel:'自动质控分数',
    	    	  decimalPrecision: 0, //精确1位小数
		    	  maxValue: 100,
		    	  minValue: 0	
	    	  },{
	    		  	xtype: 'xapdisplayfield',
	    			fieldLabel: '',
	    			labelWidth:20,
	    			vertical: true,
	    			name:'fenge',
	    			value: '~'/*,
	    			margin:'0 60 0 0'*/
	    	},{
	    	  	xtype: 'xapnumberfield',
	    	//    autoScroll:true,
	    	  	name:'qaAutoScrMax',
	    	  	labelWidth:60,
	    	  	width:120,
	    	  	labelAlign:'left',
//	    	  	margin:'0 0 10 0',
	    	  	editable:true,
	    	  	decimalPrecision: 0, //精确1位小数
	    	    maxValue: 100,
	    	    minValue: 0
	    		},{
		            xtype:'xapcombobox',
		            name:'specialMr',
		            labelAlign : 'right',
		            hidden:false,
		            margin:'0 0 10 -40',
		            colspan: 4,
//		    	        editable:false,
//		    	        multiSelect : true, //多选
		            fieldLabel:'专项病历',
		    		comboData : [
		    			{"value":"01", "text":"转科病例"},
		    			{"value":"02", "text":"会诊病例"},
		    			{"value":"03", "text":"危急值病例"},
		    			{"value":"04", "text":"非计划再次手术病例"},
		    			{"value":"06", "text":"住院超过30天"},
		    			{"value":"07", "text":"输血患者"},
		    			{"value":"08", "text":"下病危，病重通知单的患者 "},
		    			{"value":"09", "text":"抢救患者"},
		    			{"value":"10", "text":"特护患者"},
		    			{"value":"11", "text":"重大，特殊手术患者"},
		    			{"value":"12", "text":"死亡患者"},
		    			{"value":"17", "text":"转入、转出重症监护室   "},
		    			{"value":"18", "text":"手术前讨论记录"},
		    			{"value":"19", "text":"有创诊疗操作记录"},
		    			{"value":"20", "text":"疑难病例讨论"},
		    			{"value":"21", "text":"多学科会诊"}
		    		]
		    	},{
				  	xtype: 'xapdisplayfield',
					fieldLabel: '',
					colspan:4,
					name:'blank',
					value: ''
			  },{
				  	xtype: 'xapdisplayfield',
					fieldLabel: '',
					vertical: true,
					name:'msgInfo',
					value: ''
			  },{
				xtype:'xaptoolbarblock',
				colspan:12,
				items: [{
					xtype: 'button',
					text: '查询',
					iconCls: 'icon-Search',
					action: 'searchAlready',
					align:'right'
				}]
			}]
			},{
			    xtype: 'xapgrid',
			    name:'alreadySignGrid',
			    border: 0,
			    ifSelect : true,
			    selectBy: 'pk',
			    flex:1,
//			    height:520,
				tools:[{
		           xtype:'button',
		           name:'back',
		           text:'打回',
		           method:'back',
           		   disabled : true
       			},{
				   xtype: 'label',		              
			       width:10
			   },{
			       xtype:'button',
			       name:'inTerminal',
			       iconCls: 'icon-inTerminal',
			       text:'进入终末质控',
			       method:'inTerminal',
           		   disabled : true
			   }/*,{
				   xtype: 'label',		              
			       width:10
			   },{
			       xtype:'button',
			       name:'finishTerminal',
			       iconCls: 'icon-Open',
			       text:'完成终末质控',
			       method:'finishTerminal',
           		   disabled : true
       		}*/],
				autoScroll:true,
			   	pageSize : 25,
				pageShow : true
			}]
        }]
    }],
    
     initComponent: function() {
        var tabItems = this.items[0].items;
        tabItems[0].items[1].CM_JR_Record = this.createWaitGridColumn();
        tabItems[1].items[1].CM_JR_Record = this.createGridColumn();
        this.callParent();
    },
    
    createWaitGridColumn: function() {
        var columnConfig = [   
  				{ header: '就诊外键', dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header: '床位号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',flex:1,hidden:true},
  				{  dataIndex: 'curMainDiNm',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'currentDeptIntoTime',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室编码', dataIndex: 'currentDeptCode',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室名称', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生编码', dataIndex: 'currentManageDoctorId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生名称', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header:'病案状态编码', dataIndex: 'statusCode',field: 'textfield',type: 'string',flex:1,hidden:true},
                { header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:100},
                { header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:100},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:70 },
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:70},
                { header: '住院科室', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:110  },
                { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',flex:1},
                { header: '出院时间', dataIndex: 'finishTime',xtype: 'xapdatecolumn',flex:1},
				{ header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                /*{ header: '手术标识', dataIndex: 'surgeryFlag',name: 'surgeryFlag',width:80 ,
					renderer:function(value,metaData,record){
			        if(value == 1){
			        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
			        }else{
			        	return null;
			        	}
					}
				}*/
        ];
        return columnConfig;
    },
    
    createGridColumn: function() {
        var columnConfig = [   
        		{xtype:'xapactioncolumn',text:'操作',width : 60,
				items: [
					/*{text:'打回',
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('terminalqapatientlistview');
							XapMessageBox.confirm2 (
							'确认打回？',
							function(btn){
								if(btn == 'yes'){
									var backChain = owner.getActionChain("back");
									backChain.execute({
										record:record
									});
								}
							});
						}	
					},*/
					{text:'完成',
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							var btnFlag = record.data.btnFlag;
							if(btnFlag == '1'){
								return true;
							}else{
								return false
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('terminalqapatientlistview');
							var finishDeptChain = owner.getActionChain("finishTerminal");
							finishDeptChain.execute({
								record:record,
								eventNm:'finishTerminalClick'
							});
						}	
					}
				]
			},
			{ header : '按钮状态',dataIndex : 'btnFlag', field: 'textfield',type: 'string',hidden:true },
			{ header: '就诊外键', dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{ header: '床位号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',flex:1,hidden:true},
			{  dataIndex: 'curMainDiNm',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{  dataIndex: 'currentDeptIntoTime',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{  header: '当前科室编码', dataIndex: 'currentDeptCode',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{  header: '当前科室名称', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{  header: '主管医生编码', dataIndex: 'currentManageDoctorId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{  header: '主管医生名称', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
			{ header:'病案状态编码', dataIndex: 'statusCode',field: 'textfield',type: 'string',flex:1,hidden:true},
            {  header: '标记', dataIndex: 'qaFlag',name: 'qaFlag',width:50,
			renderer:function(value,metaData,record){
		        if(value == 1){
		        	return "<label>★</label>";
		        }else{
		        	return null;
		        	}
				}
			},
            { header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:100},
            { header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:100},
            { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:70 },
            { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:70},
            { header: '住院科室', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:110  },
            { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',flex:1},
            { header: '出院时间', dataIndex: 'finishTime',xtype: 'xapdatecolumn',flex:1},
			{ header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
            /*{ header: '手术标识', dataIndex: 'surgeryFlag',name: 'surgeryFlag',width:80 ,
				renderer:function(value,metaData,record){
		        if(value == 1){
		        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
		        }else{
		        	return null;
		        	}
				}
			},*/
            { header: '缺陷数', dataIndex: 'faultTotal',field: 'textfield',type: 'int',width:60  },
            { header: '自动质控分数', dataIndex: 'qaAutoScr',field: 'textfield',flex:1 }
        ];
        return columnConfig;
    },
    
    setData : function(data) {
    	var grid;
    	if(data.groupType == '1'){
    		 grid = this.down('xapgrid[name=waitSignGrid]');
    	}else if(data.groupType == '2'){
    		 grid = this.down('xapgrid[name=alreadySignGrid]');
    	}
    	var dataList = data.dataList;
    	if(grid){
    		if(dataList){
        	var totalList = {"total":data.total,"dataList":dataList};
        	var pageSize = data.pageSize;
        	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
        		grid.setPageData(totalList);
	    	}else{
	    		grid.setData(dataList);
	    	}
        }else{
        	var totalList = {"total":data.total,"dataList":dataList};
        	grid.setPageData(totalList);
        }
    	}
    }
})