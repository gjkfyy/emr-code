Ext.define('iih.po.com.action.PortalInitAction', {
    extend: 'Xap.ej.action.Action',
    
    /*
    * @Override
    */
    execute: function(context) {
        IMER_GLOBAL.hospitalArea.code = context.hospitalAreaCode;
        IMER_GLOBAL.hospitalArea.name = context.hospitalAreaName;
        IMER_GLOBAL.department.code = context.departmentCode;
        IMER_GLOBAL.department.name = context.departmentName;
        IMER_GLOBAL.portal.code = context.portalCode;
        IMER_GLOBAL.portal.name = context.portalName;
        var patientInfo = context.patient;
        
        this.callParent();
        //添加全局事件
        var canvas = Xap.getCanvas();
        canvas.addEvents("addWorkPage");
        canvas.addEvents("updatePatient");
        var view = this.getOwner();
        var block = this.getBlock('portal');
        //读取功能菜单
        var funcChain = view.getActionChain('functionRefresh');
        funcChain.execute({
            menuCd:context.menuCd
        });
        //设置工作区
        var workarea = block.down('workareapageview');
        workarea.removeAll(true);
        //设置top区域
        var top = block.down('topview');
        var topChain = top.getActionChain('init');
        topChain.execute({
            patientInfo:patientInfo
        });
        //显示portal
        var app = block.up('app');
        var layout = app.getLayout();
        layout.setActiveItem(2);
        if(view.popWindow){
            view.popWindow.destroy();
            view.popWindow = null;
        }
        //关闭弹出窗体
        /*var windows = Ext.ComponentQuery.query('window');
        Ext.each(windows,function(w){
            if(w.modal)w.close();
        });*/
        
        /*if(!IMER_GLOBAL.encounterSn && IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1001){
            var patientChain = view.getActionChain('patientPop');
            patientChain.execute();
        };*/
        
        //弹出患者列表
        if(!IMER_GLOBAL.encounterSn && (IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8)){
            var patientChain = view.getActionChain('patientPop');
            patientChain.execute();
        };
        //弹出患者列表
        if(!IMER_GLOBAL.encounterSn && IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7){
            var patientChain = view.getActionChain('InpPatientPop');
            patientChain.execute();
        };
        //弹出患者列表
        if(!IMER_GLOBAL.encounterSn && IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10){
            var patientChain = view.getActionChain('patientPop');
            patientChain.execute();
        };
        //门诊时功能导航栏收起
        var functionBlock = view.down('functionnavigationblock');
        
        if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1001 || IMER_CONSTANT.PORTAL_CD_1002 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_9)
            functionBlock.collapse();
        else
            functionBlock.expand();
        
        //病历质控 读取用户 为护士？医生？权限 给全局变量赋值 2016-11-9 wangyanli
        if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_4 ){
            var qaWorkUserAcChain = view.getActionChain('qaWorkUserAcAction');
            qaWorkUserAcChain.execute();
        };
        
    }
});