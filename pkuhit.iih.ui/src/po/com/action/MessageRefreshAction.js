Ext.define('iih.po.com.action.MessageRefreshAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
    	var operations = context.operations;
    	var url = this.url;
    	var mclass = null;
    	var condition = {
    	   userCd: IMER_GLOBAL.user.code
    	};
    	var qs = Ext.Object.toQueryString(condition);
    	url += '?' + qs;
    	var METHODS = this.getInvocationMethods();
    	var operation = {
    	    url: url,
    	    mclass: mclass,
    	    method: METHODS.METHOD_GET,
    	    condition: condition,
            scope: this,
            success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var portal = this.getOwner();
        var m = operation.result;
        if(m && m.dataList){
            var msgArea = portal.down('container[name=msgArea]');
            if(msgArea){
                msgArea.removeAll();
                var msgBtn = Ext.create('Ext.button.Button',{
                    text:m.dataList.length>0?'<span class="message-count">'+m.dataList.length+'</span>':'',
                    //cls:'message-count',
                    iconCls: m.dataList.length>0?'message_05':'message_06',
                    scale: 'large',
                    tooltip: '消息',
                    margin: '20 20 5 0',
                    handler: function(){
                        var chain = portal.getActionChain('messagePop');
                        chain.execute();
                    }
                });
                msgArea.add(msgBtn);
            }
        }
    }
});