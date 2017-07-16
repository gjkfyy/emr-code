Ext.define('iih.sy.search.action.LoadConditionAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	doExecute: function(context) {
		 
	    this.callParent();
	    var pageNum ,pageSize; 
	    var owner = this.getOwner();
	    var conditionBlock=Ext.getCmp('emrsearchconditionblock');
	    
        var hg = owner.getBlock('historyGrid');
        var grid = hg.down('xapgrid'); 
        var selected=grid.getSelectionModel().getSelection();
        if (selected.length > 0) {
            var id=selected[0].data.id;
            var condition=selected[0].data.condition;
            condition = Ext.JSON.decode(condition);
            conditionBlock.setData(condition);
            
            //循环遍历删除按钮，并触发click事件
            var jcxm = conditionBlock.down('fieldcontainer[name=jcxm]');
            var delButtons = jcxm.down('xapbutton[name=delItem]');
            var flg = true;
            while(flg){
            	var delButtons = jcxm.down('xapbutton[name=delItem]');
            	if(delButtons != null || delButtons != undefined ){
            		delButtons.fireEvent('click');  
            	}else{
            		flg = false;
            	}
            }
            
            //检查项目赋值
            var jcxmStr = condition.itemValues;
            if(jcxmStr != null || jcxmStr != undefined){
            	var items = jcxmStr.split("\|\|"); 
		        Ext.Array.each(items, function(item,index) {
		        	var value = item.split("\|"); 
			    	if(index == 0){
			    		jcxm.down('xapcombobox[name=mr_element]').setValue(value[0]);
			    		jcxm.down('xaptextfield[name=examItem]').setValue(value[1]);
			    	}else{
			    		conditionBlock.addItem(jcxm,value[0],value[1]);
			    	}
		        });
            }
            
        }else {
             XapMessageBox.info("请选择一条记录！");
        };
	    
	}
});