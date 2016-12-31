Ext.define('iih.po.com.action.SpecialCharacterSearchAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    var view = this.getOwner();
	    var grid = view.down('xapgrid');
        var store = grid.getStore();
        var data = [{
            'fst':'α',
            'snd':'β',
            'thd':'γ'
        },{
            'fst':'℃',
            'snd':'±',
            'thd':'‰'
        },{
            'fst':'mOms/kg',
            'snd':'ng/ml',
            'thd':'pg/ml'
        },{
            'fst':'10^12/L',
            'snd':'10^9/L',
            'thd':'KIU/L'
        },{
            'fst':'R/s',
            'snd':'U/L',
            'thd':'g/L'
        },{
            'fst':'mmHg',
            'snd':'mmol/L',
            'thd':'IU/L'
        },{
            'fst':'umol/L',
            'snd':'ng/L',
            'thd':'ug'
        },{
            'fst':'①',
            'snd':'②',
            'thd':'③'
        },{
            'fst':'④',
            'snd':'⑤',
            'thd':'⑥'
        },{
            'fst':'Ⅰ',
            'snd':'Ⅱ',
            'thd':'Ⅲ'
        },{
            'fst':'Ⅳ',
            'snd':'Ⅴ',
            'thd':'Ⅵ'
        }];
        grid.setData(data);
    	/*var operations = context.operations;
    	var METHODS = this.getInvocationMethods();
    	var operation = {
    	    url: this.url,
    	    mclass: null,
    	    method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess
    	};
    	operations.push(operation);*/
    },
    
    onSuccess: function(operation) {
        /*var block = this.getBlock('content');
        var grid = block.down('xapgrid');
        var m = operation.result;
		if(m){
		    grid.setData(m.dataList);
		}*/
    }
});