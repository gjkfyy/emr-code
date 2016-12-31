Ext.define('iih.mr.kr.csm.action.CSMTreeItemClickAction', {
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
         var diNm = diNode.data.text;
         var diSuiteTypeCode = diNode.data.diSuiteTypeCode;
         var owner=me.getOwner();	
 	     var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
 	     properties.setData({
 	    	diSuiteCode:diSuiteCode,
 	    	diCode:diCode,
 	    	diNm:diNm,
 	    	diSuiteTypeCode:diSuiteTypeCode
 	     });
       
 	     if(diCode && diCode!="*"){
 	    	 
 	    	var diagnosisChain = owner.getActionChain('csmDiagnosisSearchAction');
 	        diagnosisChain.execute();
 	        
 	     }else{
 	    	var diGrid = me.getBlock('rightblock').down('xapgrid[action=digrid]');
 	    	diGrid.removeAll();
 	     }
       
        var mrChain = owner.getActionChain('csmMrSearchAction');
        mrChain.execute();
    }
	
});
