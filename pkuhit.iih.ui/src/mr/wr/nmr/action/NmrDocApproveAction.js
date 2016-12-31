Ext.define('iih.mr.wr.nmr.action.NmrDocApproveAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
//    userName:'',
    /*
    * @Override
    */
    execute: function(context) {
    	var operations = context.operations;
        if(!operations) {
            return;
        }
        var user = IMER_GLOBAL.user;
        user.signLevelCode=this.getOwner().medicalRecord.userSignLevelCode;
        var userName=IMER_GLOBAL.user.name;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        plugin.SwitchRedline(0, '');
        plugin.ShowRedline(0);//不显示审签痕迹
        var signatureLevel=0;
        var macroId='';
        if('MRM02.03'==user.signLevelCode){
        	signatureLevel=2;
        	macroId='MR.M.013.D.38';
        }else if('MRM02.04'==user.signLevelCode){
        	signatureLevel=3;
        	macroId='MR.M.013.D.39';
        }else{
        	Ext.Msg.alert('提示','您没有权限进行此操作!');
        	return false;
        }
        plugin.AddSignature(signatureLevel);
        plugin.ImportMacroValue(macroId,userName);//进行签名
        
        var approvePostAction=this.getOwner().getActionChain('approvePost');
        approvePostAction.execute();
    }
});
