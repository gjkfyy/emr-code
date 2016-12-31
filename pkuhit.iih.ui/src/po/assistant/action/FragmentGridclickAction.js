Ext.define('iih.po.assistant.action.FragmentGridclickAction', {
	extend: 'Xap.ej.action.ServiceInvocation',		
	/*
	* @Override
	*/
	doExecute: function(context) {
		this.callParent();
        var operations = context.operations;  
        var center = this.getBlock('center');
        var west = this.getBlock('west');
        //得到选择的值
		var grid = west.down('xapgrid[name=knoeledgeteGrid]');
		var result =grid.getSelectionModel().getSelection()[0].data;
		if(result){
			//将选择的值插入
			var fromStatus = center.down('xaptextarea').setValue(result.fragmentTplContent);
		}
	}
});
