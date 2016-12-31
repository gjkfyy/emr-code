Ext.define('iih.po.assistant.action.VitalSignSearchCancelAction', {
    extend: 'Xap.ej.action.Action',

    /*
     * @Override
     */
    execute: function(context) {
        // 关闭窗口
        var owner = this.getOwner().ownerCt.ownerCt;// 从新建病历进来关闭此页面
        if (owner == null || owner == undefined) {
            this.getOwner().ownerCt.close();// 从病历属性进来关闭此页面
        } else {
            owner.close();
        }
    }
});
