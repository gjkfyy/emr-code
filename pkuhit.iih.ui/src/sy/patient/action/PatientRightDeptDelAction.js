Ext.define('iih.sy.patient.action.PatientRightDeptDelAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
		var rb = this.getBlock('result');
		var grid = rb.down('xapgrid');
		var record = context.event.arguments[0];
		Ext.Msg.confirm("警告", "确定要删除吗？", function(button) {
                if (button == "yes") {
                	grid.getStore().remove(record);
                }
       })
	}
});
