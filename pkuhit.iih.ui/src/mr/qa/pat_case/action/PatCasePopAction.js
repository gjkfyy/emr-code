
Ext.define('iih.mr.qa.pat_case.action.PatCasePopAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	//extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.pat_case.view.PatCasePopView'],
	defaultConfig: {
	    width: 800,
	    height: 600,
	    layout : 'fit',
	    modal: true
	},	
	execute: function(context){
		var owner = this.getOwner();
		var config = {
				title:'病案首页',
				width:1200,
				height:640,
	    		//width: 950,
	    		//height:515,
	    		contentConfig: {
	    			xtype: 'patcasepopview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {/*
	    				name: 'init',
	    				context: {
	    					data:data
	    				}
	    			*/}
	    		}
	    	};
		 var windowConfig = Ext.apply({}, this.defaultConfig);
         if(config.width) {
             windowConfig.width = config.width;
             config.width = null;
         }
         if(config.height) {
             windowConfig.height = config.height;
             config.height = null;
         }
         if(config.title) {
             windowConfig.title = config.title;
             config.title = null;
         }
		 var window = Ext.create('Ext.window.Window', windowConfig);

         var contentConfig = config.contentConfig;
         var initChainConfig = contentConfig.initChain;
         contentConfig.initChain = null;
         
         window.add(contentConfig);
         window.show();
    /*     window.on('close',function(){
        	 var outmrdoceditview=Ext.getCmp('patcasepopview');
             var emrRefreshOutpatientDisposal=outmrdoceditview.getActionChain("emrRefreshOutpatientDisposal");

             emrRefreshOutpatientDisposal.execute();
         })*/
		//this.callParent([config]);
	}
})

