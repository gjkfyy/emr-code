
Ext.define('iih.mr.wr.omr.action.CreateOrderAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	//extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.wr.omr.view.CreateOrderView'],
	defaultConfig: {
	    width: 800,
	    height: 600,
	    layout : 'fit',
	    modal: true
	},	
	execute: function(context){
		var patientId = IMER_GLOBAL.patientId;
		//就诊次数
		var inVisitTimes = IMER_GLOBAL.encounterCount;
		
		if(patientId == undefined || patientId == ''){
			XapMessageBox.info("请选择患者！");
			return;
		}
		var owner = this.getOwner();
		var config = {
				title:'处方录入',
	    		width: 960,
	    		height:515,
	    		contentConfig: {
	    			xtype: 'createorderview',
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
         window.on('close',function(){
        	 var outmrdoceditview=Ext.getCmp('outmrdoceditview');
             var emrRefreshOutpatientDisposal=outmrdoceditview.getActionChain("emrRefreshOutpatientDisposal");

             emrRefreshOutpatientDisposal.execute();
         })
		//this.callParent([config]);
	}
})

