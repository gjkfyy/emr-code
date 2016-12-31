/** 
 * 科室质控页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.dept_qa_patient.action.DeptViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
	    //获取就诊一览的 block
		var resultBlock = this.getBlock('result');	
		var deptGrid = resultBlock.down('xapgrid');
		
		//打回按钮
		var back = deptGrid.down('button[method=back]');
		back.on('click',function(btn){
			XapMessageBox.confirm2 (
			'确认打回？',
			function(btn){
				if(btn == 'yes'){
					context.event.name='deptclick';
					var backChain = me.getOwner().getActionChain("back");
					backChain.execute(context);
				}
			});
		});
		
		//进入科室质控按钮
		var inDept = deptGrid.down('button[method=inDept]');
		inDept.on('click',function(btn){
			context.event.name='click';
			var inDeptChain = me.getOwner().getActionChain("inDept");
			inDeptChain.execute(context);
		});

		/*//完成科室质控按钮
		var finishDept = deptGrid.down('button[name=finishDept]');
		finishDept.on('click',function(btn){
			context.event.name='finishDeptClick';
			var finishDeptChain = me.getOwner().getActionChain("finishDept");
			finishDeptChain.execute(context);
		});*/
	}
})