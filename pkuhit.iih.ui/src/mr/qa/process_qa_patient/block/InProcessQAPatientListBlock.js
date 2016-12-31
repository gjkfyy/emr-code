Ext.define('iih.mr.qa.process_qa_patient.block.InProcessQAPatientListBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.inprocessqapatientlistblock',
	
	border: 0,

	layout: {
        type : 'fit'
    },
	items: [{
//		title: '环节质控患者查询',
		xtype: 'xapform',
	layout: {
		type: 'table',
		border:1,
		columns: 9,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%'/*,
            height:86*/
        }
	,
        tdAttrs: {
            valign: 'left'
        }
	},
	items:[
	    {
        xtype: 'xapdatefield',
//      autoScroll:true,
	      name:'beginTime',
	      labelWidth:60,
	      width:180,
	      margin:'10 -100 10 10',
	      labelAlign:'right',
	      editable:false,
	      fieldLabel:'入院时间'
	  },{
		  	xtype: 'xapdisplayfield',
			fieldLabel: '',
			labelWidth:30,
			vertical: true,
			name:'fenge',
			value: '~',
			margin:'10 0 10 0'
	},{
	  	xtype: 'xapdatefield',
	//    autoScroll:true,
	  	name:'endTime',
	  	labelWidth:60,
	  	width:120,
	  	labelAlign:'left',
	  	margin:'10 0 10 0',
	  	editable:false
	  },
	  {
			xtype:'comboxgrid',
			colspan:3,
			margin:'10 0 10 0',
			name:'curDeptNm',
			method:'curDeptNm',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'科室',
			labelAlign : 'right',
			labelWidth : 50,
			listWidth:230,    //gird的宽度
			width:210,        //combo的宽度
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
			hidden:true,
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
				var view = this.up('inprocessqapatientlistview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					curDeptNm:newValue
				});
			   /* console.log(newValue);     //本次选择的科室编码
			    console.log(oldValue);     //上次选择的科室编码
			    console.log(record);       //本次选择的科室完整记录
*/			}
	},/*{
		xtype:'comboxgrid',
        name:'curMainDiNm',
        dataIndex : 'curMainDiNm',
        method:'diagnosis',
        anchor: "90%",
        width:200,
        fieldLabel:'主诊断',
        labelWidth : 60,
		labelAlign : 'right',
        parentXtype:'inprocessqapatientlistblock',
        dictionary:'diagnosisCdLoad',
        columns: [{
            text: '适用病种编码',
            dataIndex: 'value',
//            dataIndex: 'abbr',
            hidden:true
        },{
            text: '适用病种',
            dataIndex: 'text'
//            dataIndex: 'name'
        }],
        serchParam:['keyword'],
        displayField: 'text',
//        displayField: 'name',
        valueField: 'value'
	},*/
	{
		xtype:'xaptextfield',
		colspan:3,
//		width:140,
        name:'amrNo',
        labelWidth:50,
        labelAlign:'right',
        fieldLabel:'住院号',
        margin:'10 0 10 0',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('inprocessqapatientlistview');
					var initChain = view.getActionChain('search');
					initChain.execute({}); 
                }  
            }
        }
	},{
		xtype:'xaptextfield',
		colspan:3,
//		width:140,
        name:'patientName',
        labelWidth:60,
        labelAlign:'right',
        fieldLabel:'患者姓名',
        margin:'10 0 10 10',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('inprocessqapatientlistview');
					var initChain = view.getActionChain('search');
					initChain.execute({}); 
                }  
            }
        }
	},{
		xtype: 'xapcheckboxgroup',
		colspan:3,
		method:'checkFlag',
		width:300,
		margin:'0 0 0 15',
//		colspan:4,
		vertical: true,
		items: [
			{ boxLabel: '病危/病重', name: 'dangerIll', inputValue: '1' ,width:100},//病重为seriouslyIll
			{ boxLabel: '手术', name: 'suF', inputValue: '1' ,width:70},
			{ boxLabel: '质控标记', name: 'qaFlag', inputValue: '1' ,width:130}
		]
	},{
		xtype: 'xapradiogroup',
		colspan:3,
		border: 1,
		style: {
    		borderStyle: 'dashed'
		},
		method:'changeTime',
		
//		fieldLabel: '',
		margin:'0 0 5 10',
//		width:285,
		items: [
			{boxLabel: '入院24小时内', name: 'rcvTime',width:100, inputValue: '1'},
			{boxLabel: '入院7天内', name: 'rcvTime', width:80,inputValue: '2'},
			{boxLabel: '全部', name: 'rcvTime', width:50,inputValue: '3', checked: true}
		]/*,
		listeners: {
			change:function(editor, e){ 
				var form = editor.up('xapform');
				var xapcheckbox = form.down('xapcheckbox');
				if(e.rcvTime == '3' ){
					xapcheckbox.setDisabled(true);
				}else{
					xapcheckbox.setDisabled(false);
				}
			}
		}*/
	},{
		xtype: 'xapradiogroup',
		border: 1,
		colspan:3,
		style: {
    		borderStyle: 'dashed'
		},
		method:'inOrOut',
		margin:'0 0 0 15',
		items: [
			{boxLabel: '在院患者', name: 'enStaCd',width:85, inputValue: '1',checked: true},
			{boxLabel: '出院未完成', name: 'enStaCd', width:85,inputValue: '2'}
		]
	},{
        xtype:'xapcombobox',
        name:'specialMr',
        labelAlign : 'right',
        hidden:false,
        colspan: 3,
        margin:'10 0 10 -30',
//	        editable:false,
//	        multiSelect : true, //多选
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
	  }]
	}]
})