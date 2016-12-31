Ext.define('iih.po.assistant.action.CancelEditMrKnowledgeAction', {
    extend: 'Xap.ej.action.Action',
    
    execute: function(context) {
        // 关闭窗口
        var owner = this.getOwner().ownerCt;
        owner.close();
    }
});
