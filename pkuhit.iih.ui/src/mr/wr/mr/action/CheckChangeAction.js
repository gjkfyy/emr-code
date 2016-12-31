Ext.define('iih.mr.wr.mr.action.CheckChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getOwner().getBlock('condition');
	    var personal=block.down('[name=personal]');
	    var dept=block.down('[name=dept]');
	    var all=block.down('[name=all]');
	    
		var checkPersonal =personal.getValue();
		var checkDept =dept.getValue();
		var checkAll =all.getValue();
		 
		var sum = 0;
		var sdte = '';
		if(checkPersonal.personal){
			sum++;
			sdte = 'personal';
		}
		if(checkDept.dept){
			sum++;
			sdte = 'dept';
		}
		if(checkAll.all){
			sum++;
			sdte = 'all';
		}
		var name = context.event.from.name;
		//如果三个组件只选了一个,则最后一个设置为只读
		if(sum==1){
			var checkbox=block.down('[name='+sdte+']');
//			console.log(checkbox);
			checkbox.items.items[0].readOnly = true;
		}else{
			personal.items.items[0].readOnly = false;
			dept.items.items[0].readOnly = false;
			all.items.items[0].readOnly = false;
		}
		if(name=='dept'){
			var block = this.getOwner().getBlock('condition');
	        var deptCode=block.down('[name=deptCode]');
	        //登陆科室编码
	        //var departCode = IMER_GLOBAL.department.code;
	        deptCode.select("");
	        if(deptCode.disabled){
	        	deptCode.setDisabled(false);
	        }else{
	        	deptCode.setDisabled(true);
	        };
		}
        var result = this.getOwner();
        var initChain = result.getActionChain('init');
        initChain.execute();
    }
});
