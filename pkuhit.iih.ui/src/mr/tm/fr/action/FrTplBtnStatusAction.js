Ext.define('iih.mr.tm.fr.action.FrTplBtnStatusAction', {
        extend: 'Xap.ej.action.Action',

	execute: function(context) {
		//按钮状态值
		var activatestatus = context.activatestatus;
		if(!activatestatus){//默认值设置
	        var btnUpgradeStatus = false ; //升级
	        var btnOpenStatus = false ;//打开
	        var btnPropertyStatus = false ;//属性
	        var btnDeleteStatus = false ;//删除
	        var btnActivateStatus = false ;//启用
	        var btnDeactivateStatus = false ;//停用
	        activatestatus = {
	        		'btnUpgradeStatus':btnUpgradeStatus,
	        		'btnOpenStatus':btnOpenStatus,
	        		'btnPropertyStatus':btnPropertyStatus,
	        		'btnDeleteStatus':btnDeleteStatus,
	        		'btnActivateStatus':btnActivateStatus,
	        		'btnDeactivateStatus':btnDeactivateStatus
	        };
		}
		this.setbuttonsstatus(activatestatus);
    },
    setbuttonsstatus:function(activatestatus){ //根据值设置按钮状态
		var gridBlock = this.getBlock('result');
//	    var gridBlock = block.down('bastemplatelistblock');
	    var btndelete = gridBlock.down('button[method=delete]');
	    this.setbuttion(btndelete,activatestatus.btnDeleteStatus)
	    
//	    var btnupgrade = gridBlock.down('button[method=upgrade]');
//	    this.setbuttion(btnupgrade,activatestatus.btnUpgradeStatus)
	    
	    var btnopen = gridBlock.down('button[method=open]');
	    this.setbuttion(btnopen,activatestatus.btnOpenStatus)
	    
	    var btnproperty = gridBlock.down('button[method=property]');
	    this.setbuttion(btnproperty,activatestatus.btnPropertyStatus)
	    	    
	    var btnactivated = gridBlock.down('button[method=activated]');
	    this.setbuttion(btnactivated,activatestatus.btnActivateStatus)
	    
	    var btnstopped = gridBlock.down('button[method=stopped]');
	    this.setbuttion(btnstopped,activatestatus.btnDeactivateStatus)
    },
    setbuttion:function(btn,status){
    	 btn.setDisabled(!status);
    }
});
