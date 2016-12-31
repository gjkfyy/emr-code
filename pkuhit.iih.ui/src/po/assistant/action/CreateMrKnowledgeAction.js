Ext.define('iih.po.assistant.action.CreateMrKnowledgeAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.assistant.view.EditKnowledgeView'],
	
	execute: function(context) {
		//method得当前操作是edit或create
		var method = context.event.arguments[0].method;
		if(method=='edit'){
			var rb = this.getBlock('west');
			var grid = rb.down('xapgrid'); 
			//若为edit，得到当前选中行
			var selected=grid.getSelectionModel().getSelection();
			if(selected.length > 0){
				//判断选中的知识库的创建者与登陆者是否一致，一致时可进行修改，否则没有权限
				if(selected[0].raw.crtUserId!=IMER_GLOBAL.user.code){
					XapMessageBox.info("当前用户没有权限！");
					return;
				}
				var config = {
		    	    modal: true,           
		    		width: 603,
		    		height:357,
		    		title :'编辑',
		    		contentConfig: {
		    			xtype:'editknowledgeview',
		    			initChain: {
		    				name: 'init',
		    				context:{
		    					method:method,//当前操作edit
		    					parentView:this.getOwner()
		    				}
		    			}
		    		}
		    	};
			}else {
				XapMessageBox.info("请选择一条记录！");
			}; 
        }else{
        	var config = {
	    	    modal: true,           
	    		width: 603,
	    		height:351,
	    		title :'新建',
	    		contentConfig: {
	    			xtype:'editknowledgeview',
	    			initChain: {
	    				name: 'init',
	    				context:{
	    					method:method,//当前操作create
	    					parentView:this.getOwner()
	    				}
	    			}
	    		}
	    	};
        }
    	this.callParent([config]);
    }
});
