Ext.define('iih.po.assistant.action.FragmentCheckChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var block = this.getOwner().getBlock('west');//得到MrKnowledgeBlock
	    var personal=block.down('[name=personal]');//个人
	    var dept=block.down('[name=dept]');//科室
	    
		var checkPersonal =personal.getValue();
		var checkDept =dept.getValue();
		 
		var sum = 0;//用于判断一共选择了几个
		var sdte = '';//当只选择一个时，存放当前选择的名称
		if(checkPersonal){//如果个人选中sum自加
			sum++;
			sdte = 'personal';
		}
		if(checkDept){//如果科室选中sum自加
			sum++;
			sdte = 'dept';
		}
		//var name = context.event.from.name;
		if(sum==1){//如果两个组件只选了一个,则将选中的设置为只读
			var checkbox=block.down('[name='+sdte+']');
			checkbox.setReadOnly(true);
		}else{//否则取消只读设置
			personal.setReadOnly(false);
			dept.setReadOnly(false);
		}
		//初始化复选框后初始化个人知识库列表
        var result = this.getOwner();
        var initChain = result.getActionChain('init');
        initChain.execute();
    }
});
