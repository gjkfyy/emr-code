Ext.define('iih.po.assistant.action.RefreshInpOrderAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
    		var url=this.url+'/SYSM01.18';
            var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess
            };
            operations.push(operation);
    },
    onSuccess: function(operation) {
    	var configs=operation.result.dataList;
    	var grid = this.getBlock('orderlist').down('xapgrid');
		var selModel = grid.getSelectionModel();
        var records = selModel.getSelection();
        var tmp='';
		if(configs&&configs.length>0){
			var itemLinkSymbol='';
			var orSymbol='';
    		var orItems=new Array();
			for(i in configs){
				var config=configs[i];
				if(config.key=='ITEM_LINK_SYMBOL'){
					itemLinkSymbol=config.value;
				}else if(config.key=='ITEM_CONFIG'){
					if(config.value){
						orItems=config.value.split(",");
					}
				}else if(config.key=='OR_LINK_SYMBOL'){
					orSymbol=config.value;
				}
			}
	        for(var j=0; j<records.length;j++){
            	    if(j>0){
            	    	tmp = tmp +orSymbol;
            	    }
            	    for(h in orItems){
            	    	var item=records[j].raw[orItems[h]];
            	    	if(item){
            	    		if(h>0){
	            	    		tmp = tmp +itemLinkSymbol;
	            	    	}
	            	    	tmp = tmp + records[j].raw[orItems[h]];
            	    	}
            	    }
            }
		}else{
			 for(var j=0; j<records.length;j++){
				 if(j>0){
		    	    	tmp = tmp +'，'
		    	 }
		     	 tmp = tmp+' ' + records[j].get('svNm');
		     	 tmp = tmp+' ' + records[j].get('dosage');
		     	 tmp = tmp +' '+ records[j].get('freqNm');
			 }
		}
		var hisDocPlugin=document.getElementById('iemrEditor');
        hisDocPlugin.InsertText(tmp);
    }
});
