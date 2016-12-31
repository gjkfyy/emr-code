Ext.define('iih.mr.tm.xml.block.FormXmlDataTopBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.field.TextField'
	           ],
	
	alias:'widget.formxmldatatopblock',
	layout: {
        type: 'table',
        columns: 2,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            width: '200'
        },
        tdAttrs: {
            valign: 'left'
        }
    },
    
	autoScroll : false,
	
	items:[{
		xtype:'xaptextfield',
        name:'dataResource',
        width: 200,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'数据元',
        allowBlank:true,
        blankText:'请输入内容！'
	},{
		xtype:'button',
        name:'search',
        method:'search',
        iconCls:'icon-Search',
        text: ' 检索'
	}],

    initComponent: function() {
        this.callParent();
    }
    
})