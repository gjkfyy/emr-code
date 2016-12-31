Ext.define('iih.mr.dr.condition_set.block.ConditionSettingButtonBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.conditionsettingbuttonblock',

	buttons:[{
            xtype: "button",
            name: 'save',
            method:'save',
            text: '保存',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],

    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})