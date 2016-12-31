Ext.define('iih.mr.qa.qa_apply.block.QaApplyInferBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.qaapplyinferblock',
	
	buttons:[{
            xtype: "button",
            name: 'send',
            method:'send',
            text: '确定',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '关闭' ,
            iconCls: 'icon-cancel' 
    }],

	items: [{
		xtype: 'xapform',
		name:'qaApply',
		width:'100%',
		border: 1,
		layout: {
			type: 'table',
			columns: 2,
			tableAttrs: {
	            border: 0,
	            cellpadding: 5,
	            cellspacing: 1,
	            width: '100%',
	            height:'100%'
	        },
	        tdAttrs: {
	            valign: 'left'
	        }
		},
		items:[{
			xtype:'xaptextfield',
			name:'applyCd',
			labelAlign : 'right',
			labelWidth:100,
			width:260,
			fieldLabel:'病历超时申请通知书编码',
			hidden: true
		},{
			xtype: 'xaplabel',
			colspan : 2,
			style: { fontSize:'16px', fontWeight:'700', color:'#00f'},
			margin:'0 10 0 10',
	    	labelAlign : 'left',
	    	text: '您的病历没有在指定的时间内完成，系统已经自动为您生成申请，请说明原因后发送。'
		},{
			xtype : 'displayfield',
			value : '<hr width=610,height:1/>',
			width : 610,
			colspan : 2,
			style : 'margin:-2px 0px -10px 10px;'
		},{
			xtype:'xaptextfield',
			name:'enPk',
			labelAlign : 'right',
			labelWidth:100,
			width:260,
			fieldLabel:'就  诊  号',
			disabled: true
		},{
			xtype:'xaptextfield',
			name:'paNm',
			labelAlign : 'right',
			labelWidth:100,
			width:260,
			fieldLabel:'患者姓名',
			disabled: true
		},{
			xtype : 'xaptextfield',
			fieldLabel : '入院时间',
			labelWidth:100,
			labelAlign : 'right',
			width: 260,
			name: 'curDeptIntoTime',
			dataIndex : 'curDeptIntoTime',
			disabled: true
		},{
			xtype : 'xaptextfield',
			fieldLabel : '文书类别',
			labelWidth:100,
			labelAlign : 'right',
			width: 260,
			name: 'mrTpNm',
			dataIndex : 'mrTpNm',
			disabled: true
		},{
			xtype : 'xaptextarea',
			fieldLabel : '事件规则',
			colspan : 2,
			labelWidth:100,
			labelAlign : 'right',
			padding:'8 0 8 0',
			width: 600,
			name: 'req',
			dataIndex : 'req',
			disabled: true
		},{
			xtype : 'xaptextarea',
			fieldLabel : '申请说明',
			colspan : 2,
			labelWidth:100,
			labelAlign : 'right',
			padding:'8 0 8 0',
			width: 600,
			name: 'applyDesc',
			dataIndex : 'applyDesc'
		},{
			xtype: 'xaplabel',
			colspan : 2,
			style: { fontSize:'16px', fontWeight:'700'},
			margin:'0 0 0 10',
	    	labelAlign : 'right',
	    	text: '审批信息'
		},{
			xtype : 'displayfield',
			value : '<hr width=610,height:1/>',
			width : 610,
			colspan : 2,
			style : 'margin:-2px 0px -10px 10px;'
		},{
			xtype : 'xaptextarea',
			fieldLabel : '备      注',
			colspan : 2,
			labelWidth:100,
			labelAlign : 'right',
			padding:'8 0 8 0',
			width: 600,
			name: 'memo',
			dataIndex : 'memo'
		},{
			xtype : 'xaptextfield',
			fieldLabel : '审批科室',
			labelWidth:100,
			colspan : 1,
			labelAlign : 'right',
			width: 260,
			name: 'deptNm',
			dataIndex : 'deptNm',
			disabled: true
		},{
			xtype : 'xaptextfield',
			fieldLabel : '主管医师',
			labelWidth:100,
			colspan : 1,
			labelAlign : 'right',
			width: 260,
			name: 'mngDctNm',
			dataIndex : 'mngDctNm',
			disabled: true
		},{
			xtype : 'xaptextfield',
			fieldLabel : '审  批  人',
			labelWidth:100,
			colspan : 1,
			labelAlign : 'right',
			width: 260,
			name: 'approvalDctNm',
			dataIndex : 'approvalDctNm',
			disabled: true
		},{
			xtype : 'xaptextfield',
			fieldLabel : '扣      分',
			labelWidth:100,
			colspan : 1,
			labelAlign : 'right',
			width: 260,
			name: 'onceDrpScr',
			dataIndex : 'onceDrpScr',
			disabled: true
		}]
	}],
    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})