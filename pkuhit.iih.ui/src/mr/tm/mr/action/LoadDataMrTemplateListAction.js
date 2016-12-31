Ext.define('iih.mr.tm.mr.action.LoadDataMrTemplateListAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context,data) {
       this.callParent();    	
       var data = context.data;
       var rs = this.getBlock('result');
       var grid = rs.down('flowgrid');       
       //console.log(context);
       //console.log(grid);
       //console.log(grid.getSelectionModel());
       var rb=grid.getSelectionModel().getSelection();
       //console.log(rb);
       console.log(rb[0].getData());
       var  jsonData=[rb[0].getData()]
       //jsonData是数组类型
       rs.setData(jsonData); 
    }
});
