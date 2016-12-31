Ext.define('iih.mr.wr.mr.action.MrShareElementSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var block = this.getBlock('content');
	    var grid = block.down('xapgrid');
        block.loadingMask = Ext.create('Xap.ej.element.window.LoadMask', block);
        block.loadingMask.show();
	    var url = this.url;
	    var pageNum = grid.currentPage; 
        var pageSize = grid.pageSize;
        this.turnpage = false;
        if(context.event && context.event.name == 'turnpage')
            this.turnpage = true;
	    var condition = {
            pageSize: pageSize,
            pageNum: pageNum
        };
	    var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var operation = {
            url: url,
            method: 'get',
            condition: condition,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        context.operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('content');
    	if(operation.result){
            if(block)
                block.setListData(operation.result,this.turnpage);
        };
        block.loadingMask.hide();
        block.updateLayout();
    },
    onFail: function(operation) {
        var block = this.getBlock('content');
        block.loadingMask.hide();
        block.updateLayout();
    }
});
