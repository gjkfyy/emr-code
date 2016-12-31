Ext.define('iih.mr.tm.mr.action.MrtemplateClickAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		//点击grid上选中的行，对操作权限进行修改
		var grid = this.getBlock('result').down('mrtemplatelistblock');  
		var rb = grid.getSelectionModel().getSelection();  
		/*if(rb.length > 1){
			//选择多条组合元素
		}else{
	    	
	    }*/

		var enabledFlag=null;
        //升级按钮
		/*var upgrade =grid.down('button[method=upgrade]');
        //打开
        var open =grid.down('button[method=open]');*/
        //属性按钮
        var propertyBtn =grid.down('button[method=property]');
        //删除按钮
        var deleteBt =grid.down('button[method=delete]');
        //提交
        var submit =grid.down('button[method=submit]');              
        /*//审核通过
        var verify =grid.down('button[method=verify]');
     	//驳回
        var reject =grid.down('button[method=reject]');  */      
        //停用
        var disable =grid.down('button[method=disable]');
        //启用
        var enable =grid.down('button[method=enable]');
		
		//将选中的这一条对应的可用的标志位可用
		var canUpdate 		= rb[0].raw.canUpdate;
		var canDelete 		= rb[0].raw.canDelete;
		var canSubmit 		= rb[0].raw.canSubmit;
	    var canReview 		= rb[0].raw.canReview;
		var canReject 		= rb[0].raw.canReject;
		var canStop 		= rb[0].raw.canStop;
		var canActivated 	= rb[0].raw.canActivated;
//		var canUpgrade		= rb[0].raw.canUpgrade;
	    
		if(canUpdate=='1'){
			propertyBtn.setDisabled(false);  
		}else{
			propertyBtn.setDisabled(true);  
		}
		
		console.log(rb[0]);
	    //升级 1可用  0为停用
	    /*if(canUpgrade=='1'){
	    	upgrade.setDisabled(false);  
	    }else  if(canUpgrade=='0'){
	    	upgrade.setDisabled(true);  
	    }*/
	    //删除 1可用  0为停用
	    if(canDelete=='1'){
	    	deleteBt.setDisabled(false);  
	    }else  if(canDelete=='0'){
	    	deleteBt.setDisabled(true);  
	    }
	    //提交 1可用  0为停用
	    if(canSubmit=='1'){
	    	submit.setDisabled(false);  
	    }else  if(canSubmit=='0'){
	    	submit.setDisabled(true);  
	    }
	    //canReview通过  1可用  0为停用
	    //alert(canReview);
	    //不要给我返回除了1和0以外的值
	    /*if(canReview=='1'){
	    	verify.setDisabled(false);  
	    }else  if(canReview=='0'){
	    	verify.setDisabled(true);  
	    }else{
	    	verify.setDisabled(true);  
	    }*/
	    
	    //驳回 1可用  0为停用
	    /*if(canReject=='1'){
	    	reject.setDisabled(false);  
	    }else  if(canReject=='0'){
	    	reject.setDisabled(true);  
	    }*/
	    //停用 1可用  0为停用
	    if(canStop=='1'){
	    	disable.setDisabled(false);  
	    }else  if(canStop=='0'){
	    	disable.setDisabled(true);  
	    }
	    //启用 1可用  0为停用
	    if(canActivated=='1'){
	    	enable.setDisabled(false);  
	    }else  if(canActivated=='0'){
	    	enable.setDisabled(true);  
	    }
	    /*//应用 1可用  0为停用
	    if(canUpgrade=='1'){
	    	//可用升级
	    	deleteBt.setDisabled(false);  
	    }else  if(canUpgrade=='0'){
	    	//可用升级
	    	deleteBt.setDisabled(true);  
	    }*/
    }
});
