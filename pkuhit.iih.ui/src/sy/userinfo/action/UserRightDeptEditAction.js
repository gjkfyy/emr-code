Ext.define('iih.sy.userinfo.action.UserRightDeptEditAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	var record = context.event.arguments[0];
    	var rowIndex = context.event.arguments[1];
    	var cellIndex = context.event.arguments[2];
    	var rb = this.getBlock('result');
    	var grid = rb.down('xapgrid[name=deptgrid]');
    	/*record.data.flag = '1';
		var rb = this.getBlock('result');
		var grid = rb.down('xapgrid[name=deptgrid]');
//		grid.refresh();
		grid.getPlugin().startEdit(rowIndex,cellIndex-1);*/
    	if(cellIndex == '0' & record.data.flag == '0' & record.data.roleList.length > 0){
			this.fireEvent('comboxclick', this,record);
		}else if(cellIndex == '0' & record.data.deptCode == ""){
			this.fireEvent('comboxclick', this,record);
		}else if(cellIndex == '0' & record.data.deptCode == undefined){
			this.fireEvent('comboxclick', this,record);
		}
		if(cellIndex==1){
			record.data.flag = '1';
			grid.getPlugin().startEdit(rowIndex,0);
			return false;
		}
}
});
