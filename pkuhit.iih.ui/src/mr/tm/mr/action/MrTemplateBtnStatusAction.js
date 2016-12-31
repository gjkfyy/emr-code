Ext.define('iih.mr.tm.mr.action.MrTemplateBtnStatusAction', {
        extend: 'Xap.ej.action.Action',

	execute: function(context) {
		//按钮状态值
		var activatestatus = context.activatestatus;
		if(!activatestatus){//默认值设置	        
	        //var btnupgradeStatus  = false ;//升级
	        //var btnverifyStatus  = false ;//审核通过
	        //var btnrejectStatus  = false ;//驳回
	        //var btncancleVerifyStatus  = false ;// 取消审核
	        //var btnissueStatus  = false ;// 发布
			//var btnsubmitStatus  = false ;//提交
			var btnopenStatus  = false ;//打开
	        var btndeleteStatus  = false ;//删除
	        var btnpropertyStatus  = false ;// 属性
	        var btndisableStatus  = false ;//停用
	        var btnenableStatus  = false ;//启用
	        var btndefaultStatus  = false ;//默认模板
	        activatestatus = {
	        		//'btnupgradeStatus':btnupgradeStatus,
	        		//'btnsubmitStatus':btnsubmitStatus,
	        		//'btnverifyStatus':btnverifyStatus,
	        		//'btnrejectStatus':btnrejectStatus,
	        		//'btncancleVerifyStatus':btncancleVerifyStatus,
	        		//'btnissueStatus':btnissueStatus,
	        		'btnopenStatus':btnopenStatus,
	        		'btndeleteStatus':btndeleteStatus,
	        		'btnpropertyStatus':btnpropertyStatus,
	        		'btndisableStatus':btndisableStatus,
	        		'btnenableStatus':btnenableStatus,
	        		'btndefaultStatus':btndefaultStatus
	        };
		}
		this.setbuttonsstatus(activatestatus);
    },
    setbuttonsstatus:function(activatestatus){ //根据值设置按钮状态
		var block = this.getBlock('result');
	    var gridBlock =block.down('mrtemplatelistblock');
	    var btnopen = gridBlock.down('button[method=open]');
	    this.setbuttion(btnopen,activatestatus.btnopenStatus);
	    var btndelete = gridBlock.down('button[method=delete]');
	    this.setbuttion(btndelete,activatestatus.btndeleteStatus);
	    var btnproperty = gridBlock.down('button[method=property]');
	    this.setbuttion(btnproperty,activatestatus.btnpropertyStatus);
	    var btndisable = gridBlock.down('button[method=disable]');
	    this.setbuttion(btndisable,activatestatus.btndisableStatus);
	    var btnenable = gridBlock.down('button[method=enable]');
	    this.setbuttion(btnenable,activatestatus.btnenableStatus);
	    var btndefault = gridBlock.down('button[method=default]');
	    this.setbuttion(btndefault,activatestatus.btndefaultStatus);
	    /*var btnsubmit = gridBlock.down('button[method=submit]');
	    this.setbuttion(btnsubmit,activatestatus.btnsubmitStatus);
		var btnverify = gridBlock.down('button[method=verify]');
	    this.setbuttion(btnverify,activatestatus.btnverifyStatus);
	    var btnupgrade = gridBlock.down('button[method=upgrade]');
	    this.setbuttion(btnupgrade,activatestatus.btnupgradeStatus);
	    var btnreject = gridBlock.down('button[method=reject]');
	    this.setbuttion(btnreject,activatestatus.btnrejectStatus);
	    var btncancleVerify = gridBlock.down('button[method=cancleVerify]');
	    this.setbuttion(btncancleVerify,activatestatus.btncancleVerifyStatus);
	    var btnissue = gridBlock.down('button[method=issue]');
	    this.setbuttion(btnissue,activatestatus.btnissueStatus);*/
    },
    setbuttion:function(btn,status){//设置单个按钮状态
    	 btn.setDisabled(!status);
    }
});
