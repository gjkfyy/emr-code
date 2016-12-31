Ext.define('iih.mr.tm.mr.action.MrTemplateTreeItemExpandAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	execute: function(context) {
		var me = this;
        var operations = context.operations;  
		me.node =context.event.arguments[0];
    	//自定义参数，可有可无
		var params = {
			parOrgCd : IMER_GLOBAL.hospitalArea.code,
			orgTpCd : 'ORGM01.04'
		};	
		//返回值参数
		var nodeData =	context.event.arguments[0].raw.data;
        var operation = {
            url: me.url,
			//params : params,
            mclass: null,
            method: 'post',
            data:nodeData,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);  
    }, 

    onSuccess: function(operation) {
		var me = this;
        var block = this.getBlock('result');
        if(operation.result.root){
			var data = operation.result.root.children;
			//先找到children的节点并去除掉children=[],使children=null
			Ext.Array.forEach(data,function(node,index,array){ 
				if(!node.leaf){
					node.children = null;
				}
			});
			var treeData = [];
			for(var d in data){
				treeData.push(data[d]);
			}
			me.node.appendChild(treeData);
		};
    } 
});
