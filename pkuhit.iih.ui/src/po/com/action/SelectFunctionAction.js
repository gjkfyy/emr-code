Ext.define('iih.po.com.action.SelectFunctionAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var pageCode = context.pageCode;
        var canvas = Xap.getCanvas();
        canvas.fireEvent("addWorkPage",{pageCode:pageCode});
    }
});