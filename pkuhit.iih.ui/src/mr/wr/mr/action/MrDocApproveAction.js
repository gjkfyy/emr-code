Ext.define('iih.mr.wr.mr.action.MrDocApproveAction', {
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
        var user=context.user;
        var userName=user.name;
        var pic = context.pic;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        plugin.SwitchRedline(0, user.id);
        plugin.ShowRedline(0);//不显示审签痕迹
        var signatureLevel=0;
        var macroId='';
        var nursePortal=false;
        if(this.getOwner().ownerCt.nursePortal){
        	nursePortal=this.getOwner().ownerCt.nursePortal;
        }
        if('MRM02.03'==user.signLevelCode){
        	signatureLevel=2;
        	macroId='MR.M.013.D.25';
        	if(nursePortal)macroId='MR.M.013.D.38';
        }else if('MRM02.04'==user.signLevelCode){
        	signatureLevel=3;
        	macroId='MR.M.013.D.24';
        	if(nursePortal)macroId='MR.M.013.D.39';
        }else{
        	Ext.Msg.alert('提示','您没有权限进行此操作!');
        	return false;
        }
        if(CONFIG_PARAM.MR_JOB_TITLE_SHOW){
        	if(context.user.jobTitleName != null && context.user.jobTitleName !=''){
	        	var tableContent = plugin.ExportTable("签名");
	            var arr = tableContent.match(new RegExp(/：+/g));
	            if(arr == null || arr.length == '1'){
	            	plugin.JumpToTable("签名");
	                plugin.OfficeCommand(".uno:JumpToNextCell");
	                plugin.InsertText(context.user.jobTitleName +"：");
	            }
        	}
        }else{
        	plugin.AddSignature(signatureLevel);
        }
        if(pic == null || pic == undefined)
        	plugin.ImportMacroValue(macroId, userName);//进行文字签名
        else
        	plugin.ImportMacroValue(macroId, '{IMG}'+pic);//进行图片签名
        
        var approvePostAction=this.getOwner().getActionChain('approvePost');
        approvePostAction.execute({
        	pic:pic
        });
    }
});
