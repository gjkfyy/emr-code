Ext.define('iih.mr.wr.nsv.block.NurScorePropertyEditBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.DateField',
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.datetimefield.DateTimeField'
	],
	alias:'widget.omrdocpropertyeditblock',
	/*
     * layout:{ type: 'table', columns: 2, //width: 1024, tableAttrs: { border:
     * 0, cellpadding: 4, // cellspacing: 1, width: '100%' }, tdAttrs: { valign:
     * 'left' }},
     */
	layout:{
		type: 'table',
		columns: 2,
		tableAttrs: {
			border: 0,
			width: '100%'
		},
        tdAttrs: {
            valign: 'left'
        }
	},
	buttons:[{
            xtype: "button",
            name: 'confimUpPro',
            method:'confimUpPro',
            hidden:true,
            text: '确认',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'close',
            hidden:true,
            method:'close',
            text: '关闭',
            iconCls: 'icon-close'
        },{
            xtype: "button",
            name: 'cancel',
            hidden:true,
            method:'cancel',
            text: '取消',
            iconCls: 'icon-cancel'
        }],
	
	items: [{
		xtype:'xaptextfield',
		name:'mrNm',
		fieldLabel:'病 历 名 称',
		labelAlign:'left',
		labelWidth:80,
		width:503,
		colspan:2,
		padding:'15 0 0 30'
	},{
		xtype:'xaptextfield',
		name:'mrType',
		fieldLabel:'病 历 类 型',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	},{
		xtype:'datetimefield',
		name:'logicSmtDate',
		fieldLabel:'业 务 时 间',
		labelAlign:'right',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	},{
		xtype:'xaptextfield',
		name:'completedFlag',
		fieldLabel:'是 否 完 成',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	}/*,{
		xtype:'xapcombobox',
		name:'higherLvlEmpId',
		fieldLabel:'查 房 医 师',
		labelAlign:'right',
		editable:false,
		readOnly:true,
		labelWidth:80,
		width:230,
		queryMode: 'local',
		displayField: 'name',
		valueField: 'id',
		padding:'5 0 0 30'
	}*/,{
		xtype:'xaptextfield',
		name:'statusName',
		fieldLabel:'病 历 状 态',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	}/*,{
		xtype:'xaptextfield',
		name:'qaStatusName',
		fieldLabel:'终末质控状态',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 10 0 0'
	}*/,/*{
		xtype:'xaptextfield',
		name:'signLevelName',
		fieldLabel:'审 签 级 别',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	},*/{
		xtype:'xapdisplayfield',
		name:'templeName',
		fieldLabel:'模 板 名 称',
		labelAlign:'right',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30',
		renderer:function(value){
			if(value){
				return "<a class='link' href='#' id='temp'>"+value+"</a>";
			}
	    }
	}/*,{
		xtype:'datetimefield',
		name:'logicSubmitTime',
		fieldLabel:'逻辑提交时间',
		labelAlign:'right',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	}*/,{
		xtype:'xaptextfield',
		name:'submitName',
		fieldLabel:'提    交    人',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	},{
		xtype:'datetimefield',
		name:'submitDate',
		fieldLabel:'提 交 时 间',
		labelAlign:'right',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	},{
		xtype:'xaptextfield',
		name:'deptName',
		fieldLabel:'所 属 科 室',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	}/*,{
		xtype:'xaptextfield',
		name:'treatDoctorName',
		fieldLabel:'经 治 医 师',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	},{
		xtype:'xapcombobox',
		name:'masterDoctorName',
		labelAlign:'right',
		queryMode: 'local',
		displayField: 'name',
		editable:false,
		valueField: 'id',
		fieldLabel:'主 治 医 师',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	},{
		xtype:'datetimefield',
		name:'mastDoctorDate',
		labelAlign:'right',
		fieldLabel:'二级审签时间',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	},{
		xtype:'xapcombobox',
		name:'dirDoctorName',
		labelAlign:'right',
		queryMode: 'local',
		displayField: 'name',
		valueField: 'id',
		name:'dirDoctorName',
		editable:false,
		fieldLabel:'主 任 医 师',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	},{
		xtype:'datetimefield',
		name:'dirDoctorDate',
		labelAlign:'right',
		fieldLabel:'三级审签时间',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	}*/,{
		xtype:'datetimefield',
		name:'createTime',
		fieldLabel:'创 建 时 间',
		labelAlign:'right',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	},{
		xtype:'xaptextfield',
		name:'createUserName',
		fieldLabel:'创&nbsp;&nbsp;建&nbsp;&nbsp;人',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	}/*,{
		xtype:'xaptextfield',
		name:'lastUpdateUserName',
		fieldLabel:'最后修改人',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 30'
	},{
		xtype:'datetimefield',
		name:'lastUpdateTime',
		fieldLabel:'最后修改时间',
		labelAlign:'right',
		labelWidth:80,
		width:230,
//		colspan:2,
		padding:'5 0 0 10'
	}*/],
	setData: function(data) {
        this.callParent(arguments);
    },
    getData: function() {
        this.callParent(arguments);
    }
})