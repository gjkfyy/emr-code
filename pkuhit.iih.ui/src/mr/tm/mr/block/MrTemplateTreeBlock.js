Ext.define('iih.mr.tm.mr.block.MrTemplateTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.tree.Tree',
               'Xap.ej.element.field.CustomTrigger',
	           'Xap.ej.element.field.ComboBox'
	],
	
	alias:'widget.mrtemplateTreeBlock',
	layout: 'fit',
	items:[{
            xtype:'xapformblock',
            layout: {
    		    type: 'vbox',
    		    align: 'stretch'
    		},
            items:[{
                xtype: "xapcombobox",
                name: 'mrTplCCat', //病历 自定义分类  选择下拉框
                allOptions:true,
                editable: false,
                fieldLabel: '自定义分类',
                value:'ALL',
                width:192,
                labelAlign:'left',
                labelWidth:65,
                margin:'2 2 2 2',
	            displayField: 'name',		            
	            valueField: 'code'
            },{           
                xtype: "xapcombobox",
                name: 'mrTplTypeCd',//病历类型  选择下拉框
                allOptions:true,
                editable: false,
                fieldLabel: '病历类型',
                value:'ALL',
                width:192,
                labelAlign:'left',
                labelWidth:65,
                margin:'2 2 2 2',
	            displayField: 'name',		            
	            valueField: 'code'
            },{           
                xtype: "xapcombobox",
                name: 'mrTplStatCd',//病历模板状态 选择下拉框
                allOptions:true,
                editable: false,
                fieldLabel: '模板状态',
                value:'ALL',
                width:192,
                labelAlign:'left',
                labelWidth:65,
                margin:'2 2 2 2',
                dictionary:'MRM07'  
            },{           
                xtype: "xaptrigger",
                name: 'mrTemplateTrigger',
                triggerBaseCls :'x-text-trigger', 
                margin:'2 2 2 2',
                emptyText: "按模板名称检索"
            },{
 	           xtype:'xaptree',
	           name:'mrTemplate',
	           flex: 1,
	           ifSelect:true,
	           rootVisible: false
	       }]
    }],

	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    tree.setData(myobj);
	}
    
})