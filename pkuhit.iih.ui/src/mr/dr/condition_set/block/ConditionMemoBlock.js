Ext.define('iih.mr.dr.condition_set.block.ConditionMemoBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.conditionmemoblock',
	
	border: 0,
	
	buttons:[{
            xtype: "button",
            name: 'save',
            method:'save',
            text: '保存',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'reset',
            method:'reset',
            text: '重置' ,
            iconCls: 'icon-cancel' 
    }],
    
	items: [{
		xtype: 'xapform',
		name:'defectComplete',
		width:'100%',
		border: 1,
		layout: {
			type: 'table',
			columns: 1,
			tableAttrs: {
	            border: 0,
	            cellpadding: 5,
	            cellspacing: 1,
	            width: '100%',
	            height:'100%'
	        },
	        tdAttrs: {
	            valign: 'center'
	        }
		},
		items:[{
			xtype : 'xaptextarea',
			colspan : 1,
			margin:'0 10 0 10',
			height:120,
			width: '98%',
			name: 'conditionMemo',
			dataIndex : 'conditionMemo'
		}]
	}],

    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})