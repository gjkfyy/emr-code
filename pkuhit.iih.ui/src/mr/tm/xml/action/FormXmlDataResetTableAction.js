Ext.define('iih.mr.tm.xml.action.FormXmlDataResetTableAction', {
	extend: 'Xap.ej.action.Action',
	/*
	* @Override
	*/
	execute: function(context) {
    	var me = this;
    	var view = me.getOwner();
    	var dataList = '';
    	var plugin = document.getElementById('iemrEditor'); 
    	plugin.ImportEleTableHead(dataList);
    	var win = view.up('window');
        win.close();
        plugin.EnableOCX(true);//设置编辑器可用
	}
});
