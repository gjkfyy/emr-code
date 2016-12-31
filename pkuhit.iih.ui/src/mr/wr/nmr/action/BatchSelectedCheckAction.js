Ext.define('iih.mr.wr.nmr.action.BatchSelectedCheckAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
    	var grid =this.getOwner().getBlock('content').down('xapgrid[name=mrDocGrid]');
    	var rb=grid.getSelectionModel().getSelection();
    	var self=this;
    	if(rb&&rb.length>0){
    		var taskMrPrint;//任务变量
    		var count=-1;
    		taskMrPrint = {
                    run: function(){
                    	count++;
                    	var printMrInit=self.getOwner().getActionChain('printMrInit');
            			printMrInit.execute({mrPk:rb[count].data.mrPk});
                    	 if(count>=rb.length-1){
                        	 Ext.TaskManager.stop(taskMrPrint);
                        }
                    },//执行任务时执行的函数
                    interval: 8000//任务间隔，毫秒为单位
                };
                Ext.TaskManager.start(taskMrPrint);//启动任务
    	}else{
    		XapMessageBox.info('请选择一条记录进行操作！');
    	}
    	
    }
});
