 Ext.define('iih.mr.di.action.OutDiagnosisItemClickAction', {
	extend: 'Xap.ej.action.Action',
	requires:['Xap.ej.element.field.Checkbox'],
	/*
	* @Override
	*/
	execute: function(context) {
		
		this.callParent();
    	var event = context.event;
        var me=this;
    	var outDiagnosisBlock=this.getBlock('content');
			
    	if(event) {
	    	var node = args = event.arguments[1];
	    	if(context.event.arguments[4].target.name){
	    		
	    		var dataIndex = context.event.arguments[4].target.name;
	    		if(dataIndex=="tocheck"){
	    			
	    			node.data.tocheck = context.event.arguments[4].target.checked;
	    			
	    		}else if(dataIndex=="suspected"){
	    			
	    			node.data.suspected = context.event.arguments[4].target.checked;
	    		}	    		
	    	}
    	}    	     	
	}
	
 });