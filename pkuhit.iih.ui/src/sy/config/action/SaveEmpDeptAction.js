/** 
 * 用户出诊科室编辑保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wangyanli
 */

Ext.define('iih.sy.config.action.SaveEmpDeptAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:[],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
    	var owner = this.getOwner();
		var block = this.getBlock('context');
		var empDeptGrid = block.down('xapgridblock');
		var empDeptStore = empDeptGrid.getStore();//获取所有科室
		var empDeptData = empDeptStore.data.items;
		var empDeptList = [];
		for (var i = 0; i < empDeptData.length; i++) {
			var empDept = empDeptData[i].data;
			empDept.sortNo=i;
			empDeptList.push(empDept); //把所有的值加入到数组里面	}
		}
		var data = {'empDeptList':empDeptList};

    	var operations = context.operations;
        if(!operations) {
     		return;
	    }
	    this.prepareOperations(operations,data);
    
        /*if(data.rfmDes == ""){
        	showInfo.setValue('<font color=red>整改说明为空</font>');
			return null;
        }else{}*/
    },

    prepareOperations: function(operations,data){
    	//var qaFltPk = data.qaFltPk;
        var url = this.url; 
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	//提示保存成功
    	XapMessageBox.info('保存成功');
    	/*var owner = this.getOwner();
		var block = this.getBlock('context');
	    var win = block.up('window');
	    win.close();*/
    	
    }
});