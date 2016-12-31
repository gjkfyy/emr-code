/*
* 抽象出重置逻辑
*/
Ext.define('Xap.ej.stl.action.MigrationAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
        var content = this.getBlock('content');
        if(content) {
            this.doReset(content);
        }
    },

    /*
    * TODO 实现
    */
    doReset: Ext.emptyFn
});
