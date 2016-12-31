Ext.define('iih.mr.tm.gro.action.GroupChooseClickAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		//点击grid上选中的行，对操作权限进行修改
		console.log('--------------------------- GroupChooseClickAction ---------------------------------------');
		var grid = this.getBlock('result').down('groupelementchooselistblock');  
		var rb = grid.getSelectionModel().getSelection();  

		var enabledFlag=null;
        //打开按钮
        var open =grid.down('button[method=open]');
        //插入按钮
        var through =grid.down('button[method=through]');
		
		//将选中的这一条对应的可用的标志位可用
		/*var canOpen 		= rb[0].data.canOpen;
		var canThrough 		= rb[0].data.canThrough;
	    
	    //打开1可用  0为停用
	    if(canOpen=='1'){
	    	open.setDisabled(false);  
	    }else  if(canOpen=='0'){
	    	open.setDisabled(true);  
	    }
	    //插入 1可用  0为停用
	    if(canThrough=='1'){
	    	through.setDisabled(false);  
	    }else  if(canThrough=='0'){
	    	through.setDisabled(true);  
	    }*/
    }
});
