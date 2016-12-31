Ext.define('iih.mr.wr.mr.action.ConfirmCompleteAction', {
    extend: 'Xap.ej.action.Action',

    /*
     * @Override
     */
    execute: function(context) {
    	var me = this;
        XapMessageBox.confirm2('是否病历文书全部完成？', function(id){
				if(id=='yes'){
					var owner = me.getOwner();
			        var chain = owner.getActionChain('finish');
			        if(chain) {
			            chain.execute({});
			        }
				}
			});
    }
});
