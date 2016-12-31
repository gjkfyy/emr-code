Ext.define('iih.mr.kr.csm.action.CSMBtnOpAction', {
	extend: 'Xap.ej.action.Action',
	requires:['iih.mr.kr.csm.view.CSMDisuiteView','iih.mr.kr.csm.view.CSMShareView'],
	
	execute: function(context) {
    
	     var me = this;
	     var owner = me.getOwner();
	     var block = me.getBlock('leftblock');
	     var csmtree = block.down('filtertree[action=csmtree]');
	     var  treeData= csmtree.getSelectionModel().getSelection();
	     var b =false;
	     if(treeData.length>0){
	    	 
	    	 if(treeData[0].childNodes.length>0){
	    		 b = true;
	    	 }
	     }
	     var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    if(context.event.arguments[0].action=="insertBtn"){
	    	
	    	//新建组套默认现在当前所选择的科室
	    	this.createPopDisuite('新建组套',1,properties.data);
	    	
	    }else if(context.event.arguments[0].action=="modefiyBtn"){
	    	
	    	if(b){
	    		XapMessageBox.info('请选择组套!');
	    		return;
	    	}
	    	
	    	this.createPopDisuite('编辑组套',2,properties.data);
	    	
	    }else if(context.event.arguments[0].action=="delBtn"){
	    	
	    	if(b){
	    		XapMessageBox.info('请选择组套!');
	    		return;
	    	}
	    	 //删除组套
	    	 var disuiteDelAction = owner.getActionChain("csmdisuiteDelAction");
	    	 disuiteDelAction.execute();
	    	
	    }else if(context.event.arguments[0].action=="shareBtn"){
	    	
	    	 var action = Xap.create({
	 			  xclass: 'Xap.ej.action.PopAction'
	 		   });
	     	   var config = {
	     			width: 360,
		    		height:450,
		    		title:'组套共享',
	         		contentConfig: {
	         		   xtype: 'csmshareView'
	         		}
	         	};

	 		action.execute(config);
	    	
	    }
    	
    },
    
    createPopDisuite:function(title,type,data){
    	
    	 var action = Xap.create({
 			  xclass: 'Xap.ej.action.PopAction'
 		   });
     	   var config = {
     			width: 760,
	    		height:410,
	    		title:title,
         		contentConfig: {
         		   xtype: 'csmdisuiteview',
         		   viewConfig:{
                      typeFlag: type,
                      data:data
                  }
         		}
         	};

 		action.execute(config);
    }
});
