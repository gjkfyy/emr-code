/*
* 用于画面迁移的Action，可以被各种Portal实现
*/
Ext.define('Xap.ej.stl.action.MigrationAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
        var target = this.getBlock('target');
        if(target) {
            this.beforeMigration(target);
            this.doMigration(target);
        }
    },

    /*
    * TODO 实现
    */
    beforeMigration: Ext.emptyFn,

    /*
    * TODO 实现
    */
    doMigration: Ext.emptyFn
});
