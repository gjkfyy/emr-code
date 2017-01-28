Ext.define('iih.sy.patient.block.PatientToLeadBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [
		   		'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.ComboBoxGrid',
				'Xap.ej.element.form.Form'
		   	],

	alias:'widget.patienttoleadblock',

	items: [{
		title: '导入人员',
		xtype: 'xapform',
	layout: {
		type: 'table',
		columns: 3,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
//            width: '100%',
            height:73
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items:[
	    {
			xtype:'xaptextfield',
	        name:'empId',
	        labelWidth:50,
	        labelAlign:'right',
	        fieldLabel:'人员ID'
		},{
			xtype:'xaptextfield',
	        name:'nm',
	        labelWidth:50,
	        labelAlign:'right',
	        fieldLabel:'姓名'
			
		},{
			//暂时替代辅助录入
	        xtype:'comboxgrid',
	        anchor: "90%",
	        width:180,
	        padding:'0 0 0 0',
	        name:'deptCd', 
	        method:'execDeptCd',
	        fieldLabel:'行政科室',
	        labelWidth:60,
	        labelAlign:'right',
	        valueField : 'code',
	        columns: [{
	            text: '科室编码',
	            dataIndex: 'code',
	            hidden:true
	        },{
	            text: '科室',
	            dataIndex: 'dept'
	        }],
	        displayField: 'dept',
	        parentXtype:'usertoleadblock',
	        dictionary:'ownerCdLoad'
		},{
			xtype: 'xapradiogroup',
			method:'changeTime',
			width:280,
			items: [
				{boxLabel: '未导入人员', name: 'userToLead', inputValue: 1, checked: true},
				{boxLabel: '已导入人员', name: 'userToLead', inputValue: 2}
			]
		}
		]
	}]
})