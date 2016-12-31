Ext.define('iih.po.assistant.action.OrderCheckchangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		var block =  this.getBlock('orderlist');//this.getOwner().getBlock('orderlist');
	    var longterm = block.down('[name=longterm]').items.items[0];
	    var temporary = block.down('[name=temporary]').items.items[0];
	    
	  //判断是否选择了医嘱类型
	    if(longterm.checked && temporary.checked){
	    	longterm.readOnly = false;
	    	temporary.readOnly = false;
	    }else if(longterm.checked && !temporary.checked){
	    	longterm.readOnly = true;
	    	temporary.readOnly = false;
	    }else if(!longterm.checked && temporary.checked){
	    	longterm.readOnly = false;
	    	temporary.readOnly = true;
	    }
		
        var result = this.getOwner();
        var initChain = result.getActionChain('init');
        initChain.execute();
    }
});
