Ext.define('iih.mr.wr.mr.action.MrDocListFreshAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    execute: function(context) {
        var owner = this.getOwner();
        var chain = owner.getActionChain('init');
        if(chain) {
            chain.execute();
        }
    }
});
