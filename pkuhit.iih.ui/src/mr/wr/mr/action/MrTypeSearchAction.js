Ext.define('iih.mr.wr.mr.action.MrTypeSearchAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    execute: function(context) {
        var block = this.getBlock('result');
        block.loadingMask = Ext.create('Xap.ej.element.window.LoadMask', block);
        block.loadingMask.show();
        var mrTypeCcatId='';
        if(context.event && context.event.name=='select'){
        	mrTypeCcatId = context.event.arguments[1].raw.id;
        	block.mrTypeCcatId=mrTypeCcatId;
        }else{
        	mrTypeCcatId=context.mrTypeCcatId;
        }
            
        this.prepareOperations(context.operations,mrTypeCcatId);
    },
    prepareOperations: function(operations,mrTypeCcatId) {
        var url = this.url + '/' + mrTypeCcatId;
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess,
                fail: this.onFail
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        if(operation.result){
            var block = this.getBlock('result');
            var grid = block.down('xapgrid');
            if(grid)
                grid.setData(operation.result.dataList);
        };
        var block = this.getBlock('result');
        block.loadingMask.hide();
        block.updateLayout();
    },
    onFail: function(operation) {
        var block = this.getBlock('result');
        block.loadingMask.hide();
        block.updateLayout();
    }
});
