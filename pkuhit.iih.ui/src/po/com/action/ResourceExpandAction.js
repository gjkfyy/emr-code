Ext.define('iih.po.com.action.ResourceExpandAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var view = this.getOwner();
        var event = context.event;
        if(event){
            this.node = event.arguments[0];
            var nodeData = event.arguments[0].raw.data;
            var operations = context.operations;
            var url = this.url;
            var METHODS = this.getInvocationMethods();
            var method = METHODS.METHOD_GET;
            if(view.objcd == IMER_CONSTANT.BASE_TPL){
                return;
            }
            else if(view.objcd == IMER_CONSTANT.MR_TPL){
                url = 'app/mr/tpl/tree';
                method = METHODS.METHOD_CREATE;
            }
            else if(view.objcd == IMER_CONSTANT.GROUP_ELEMENT){
                return;
            }
            /*var condition = {
                objcd: view.objcd    
            };
            var form = this.getOwner().getBlock('top');
            condition = Ext.apply(condition,form.getData());
            var qs = Ext.Object.toQueryString(condition);
            url += '?' + qs;*/
            var mclass = null;
            var operation = {
                url: url,
                mclass: mclass,
                method: method,
                data:nodeData,
                condition: null,
                scope: this,
                success: this.onSuccess
            };
            operations.push(operation);
        }
    },
    
    onSuccess: function(operation) {
        var block = this.getBlock('tree');
        var tree = block.down('xaptree[name=mrTree]');
        var m = operation.result;
        if(m){
            var data = m.root.children;
            Ext.Array.forEach(data,function(node,index,array){ 
                if(!node.leaf){
                    node.children = null;
                }
            });
            var treeData = [];
            for(var i in data){
                treeData.push(data[i]);
            }
            this.node.appendChild(treeData);
        }
    }
});