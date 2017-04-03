Ext.define('iih.mr.wr.nmr.block.BatchConditionBolck',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.grid.column.ActionColumn',
		'Xap.ej.element.grid.Grid',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.field.TextField',
        'Xap.ej.element.radiogroup.RadioGroup',
        'Xap.ej.element.checkboxgroup.CheckboxGroup'
	],

	alias:'widget.batchconditionbolck',
	
	layout: {
        type: 'table',
        columns: 9
    },
	items: [{
        xtype:'xapcombobox',
        name:'batchCategoryCode',
        colspan: 3,
        padding:'10 0 0 15',
        margin : '0 0 0 3',
        labelWidth:100,
        width:245,
        editable:false,
        value:'ALL',
        allOptions: true,
        id:'batchCategoryCode',
        //allOptions: true,
        fieldLabel:'护理文书类型组',
        queryMode: 'local',
//        comboData : [
//         			{"value":"QAM06.02", "name":"一般患者护理记录单"},
//         			{"value":"QAM06.05", "name":"危重患者护理记录单"},
//         			{"value":"QAM06.04", "name":"特殊护理记录单"}
//         		],
        displayField: 'name',
        valueField: 'code'
    },{
        xtype:'xapcombobox',
        name:'typeCode',
        padding:'10 0 0 20',
        labelWidth:80,
        width:260,
        colspan: 5,
        value:'ALL',
        editable:false,
        allOptions: true,
        fieldLabel:'护理文书类型',
        queryMode: 'local',
        displayField: 'name',
        hidden:true,
        valueField: 'code'
    },{
		xtype: 'xapbutton',
		text : '病历打印',
		width:100,
		margin:'8 10 0 350',
		name:'selectArchive',
		handler: function() {
			var view=Ext.getCmp('batchprintview');
			var btachMrsPrint = view.getActionChain("btachMrsCheckPrint");
			btachMrsPrint.execute();
		}	
	}]
});