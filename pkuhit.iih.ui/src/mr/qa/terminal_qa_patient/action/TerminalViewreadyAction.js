/** 
 * 终末质控页面加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.terminal_qa_patient.action.TerminalViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		var me = this;
		
	    var owner = this.getOwner();
	    
	    var typeFlag = owner.typeFlag;
	    
	    //获取就诊一览的 block
		var resultBlock = this.getBlock('result');	
		var waitSignGrid = resultBlock.down('xapgrid[name=waitSignGrid]');
		//var alreadySignGrid = resultBlock.down('xapgrid[name=alreadySignGrid]');
		
		//签收按钮
		var sign = waitSignGrid.down('button[method=sign]');
		sign.on('click',function(btn){
			context.event.name='click';
			var signChain = me.getOwner().getActionChain("sign");
			signChain.execute(context);
		});
		
		/*//打回按钮
		var back = waitSignGrid.down('button[method=back]');
		back.on('click',function(btn){
			context.event.name='click';
			var backChain = me.getOwner().getActionChain("back");
			backChain.execute(context);
		});
		
		//进入终末质控按钮
		var inTerminal = resultBlock.down('button[method=inTerminal]');
		inTerminal.on('click',function(btn){
			context.event.name='click';
			var inTerminalChain = me.getOwner().getActionChain("inTerminal");
			inTerminalChain.execute(context);
		});*/

/*		//完成终末质控按钮
		var finishTerminal = alreadySignGrid.down('button[name=finishTerminal]');
		finishTerminal.on('click',function(btn){
			context.event.name='click';
			var finishTerminalChain = me.getOwner().getActionChain("finishTerminal");
			finishTerminalChain.execute(context);
		});*/
		
		/*if(typeFlag == '2'){
			sign.setVisible(false); 
			back.setVisible(true); 
			inTerminal.setVisible(true); 
			finishTerminal.setVisible(true); 
			//terminalGrid.getView().checkboxShow = false;
			terminalGrid.refresh();
		}else if(typeFlag == '3'){
			sign.setVisible(true); 
			back.setVisible(false); 
			inTerminal.setVisible(false); 
			finishTerminal.setVisible(false); 
			//terminalGrid.checkboxShow=true;
			terminalGrid.refresh();
		}*/
	}
	
})