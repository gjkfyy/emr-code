Ext.define('iih.mr.kr.csa.action.CSATreeItemClickAction', {
	extend: 'Xap.ej.action.Action',
	execute: function(context){
	
	    var me = this;
        var owner=me.getOwner();
        
        if(context.event.arguments[1].childNodes.length>0){
         	return;
        }
        var diNode = context.event.arguments[1] ;
         var diSuiteCode = diNode.data.diSuiteCode;
         var diCode = diNode.data.diCode;
         var owner=me.getOwner();	
 	     var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
 	     properties.setData({
 	    	diSuiteCode:diSuiteCode,
 	    	diCode:diCode
 	     });
       
 	     if(diCode!="*"){
 	    	 
 	    	var diagnosisChain = owner.getActionChain('csaDiagnosisSearchAction');
 	        diagnosisChain.execute();
 	     }else{
 	    	var diGrid = me.getBlock('rightblock').down('xapgrid[action=digrid]');
 	    	var store = diGrid.getStore();
 	    	store.removeAll();
 	     }
       
        var mrChain = owner.getActionChain('csaMrSearchAction');
        mrChain.execute();
    }
	
});
