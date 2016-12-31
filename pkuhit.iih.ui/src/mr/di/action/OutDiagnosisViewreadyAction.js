 Ext.define('iih.mr.di.action.OutDiagnosisViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	requires:[
	          'Xap.ej.element.field.Checkbox',
	          'Xap.ej.action.PopAction',
	          'iih.mr.kr.csa.view.CSAKRView',
	          'iih.mr.kr.csm.view.CSMKRView',
	          'iih.mr.kr.csm.view.CSMCategoryView'
	          ],
	/*
	* @Override
	*/
	execute: function(context) {
	   
	   var me = this;
	   var owner=me.getOwner();	
	   var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
       
	   var block = me.getBlock('content');
	   var up = block.down('button[action=moveup]');
	   var down = block.down('button[action=movedown]');
	   var insertBtn = block.down('button[action=insertBtn]');
	   var commitBtn = block.down('button[action=commitBtn]');
	   var delBtn = block.down('button[action=deleteBtn]');
	   
	   
	   up.on('click',function(btn){
		   me.diagnosisFun(me,btn);
		   
		   /*var action = Xap.create({
   			  xclass: 'Xap.ej.action.PopAction'
   		   });
       	   var config = {
       			width: 760,
	    		height:600,
	    		title:'FL',
           		contentConfig: {
           			xtype: 'csakrview',
           			//xtype: 'csmcategoryView',
           		   viewConfig:{
                        typeFlag: 3
                    }
           		}
           	};

   		action.execute(config);*/
	   });
	   
	   down.on('click',function(btn){
		   me.diagnosisFun(me,btn);
	   });
	   
	   insertBtn.on('click',function(btn){
		   me.diagnosisFun(me,btn);
	   });
	   
	   commitBtn.on('click',function(btn){
		  
		   var diagnosisSavechain = me.getOwner().getActionChain("outDiagnosisSaveAction");
		   diagnosisSavechain.execute(context);
	   });
	   
	   delBtn.on('click',function(btn){
		   me.diagnosisFun(me,btn);
	   });
	   
	   me.initDiagnosisFun(me);
    },
    
    diagnosisFun:function(me,btn){
    	
    	 var owner=me.getOwner();	
  	     var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
  	     properties.setData({
  	    	 action:btn.action
  	     });
    	
    	 var outDiagnosisMoveChain = me.getOwner().getActionChain("outDiagnosisMoveAction");
    	 outDiagnosisMoveChain.execute();
    },
    
    initDiagnosisFun:function(me){
    	
    	 var diagnosischain = me.getOwner().getActionChain("outDiagnosisInitAction");
         var diagnosisAction = diagnosischain.getActionByClass('iih.mr.di.action.OutDiagnosisInitAction');
         diagnosisAction.url = '/di/'+IMER_GLOBAL.encounterSn+'/dis?orgCode='+IMER_GLOBAL.hospitalArea.code;
        // diagnosisAction.url = '/di/123456/dis?orgCode=SZLH';
         diagnosischain.execute();
    },
});