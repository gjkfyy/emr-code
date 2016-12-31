Ext.define('iih.sy.userinfo.action.DeptInsertRowAction', {
	extend: 'Xap.ej.action.Action',

	requires: [
        'Xap.ej.data.DataModel'
    ],

    execute:function(context){
    	var deptGrid =  this.getBlock('result').down('xapgrid[name=deptgrid]');
    	var rowCount = deptGrid.getStore().getCount();
    	var lastrowindex = rowCount-1;//最后一行索引
    	var selectedGrid = context.event.arguments[0];
    	var rowindex = deptGrid.store.indexOf(selectedGrid);//获得选中的第一项在store内的行号
		var r = {'deptCode' : '','deptName' : '','roleList' : []};
    	if(rowCount==-1){
    		deptGrid.getStore().insert(0, r);
    	}else if(rowindex==lastrowindex){
    		deptGrid.getStore().insert(rowCount, r);
    	       // gridBlock.plugins[0].startEdit(0, 0);
    	}
       
    
    }

});
