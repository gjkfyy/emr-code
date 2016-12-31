/** 
 * 环节整改通知页面，缺陷列表加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.process_qa_reform.action.ProcessRfmDefectViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		
		var me = this;
		
	    var owner = this.getOwner();
	    
		//获取缺陷一览的 block
		var bottomBlock = this.getBlock('bottom');		
		var defectGrid = bottomBlock.down('xapgrid');
		
		/*//整改按钮，点击前先判断文书是否修改
		var rfmBtn = bottomBlock.down('xapgrid xapbutton[action=rfm]');
		rfmBtn.on('click',function(btn){
			context.event.name='rfmClick';
			var rfmDefectChain = me.getOwner().getActionChain("rfmDefect");
			rfmDefectChain.execute(context);
		});*/
		
		//完成本次整改按钮，点击前先判断文书是否修改
		var finishRfmBtn = bottomBlock.down('xapgrid xapbutton[action=finishRfm]');
		finishRfmBtn.on('click',function(btn){
			context.event.name='finishRfmClick';
			var finishRfmChain = me.getOwner().getActionChain("defectStatusJudge");
			finishRfmChain.execute(context);
		});
		
		//向上按钮
		var up = bottomBlock.down('tool[itemId=up]');
		up.addListener('click', function() {
            me.maximize(300,bottomBlock);
            up.hide();
            down.show();
        });
		
		//向下按钮
		var down = bottomBlock.down('tool[itemId=down]');
		down.addListener('click', function() {
            me.minimize(bottomBlock);
            up.show();
            down.hide();
        });
       
        //表头
		var tbar = defectGrid.down('header');
        tbar.addListener('dblclick', function() {
            if(down.hidden==false){
               me.minimize(bottomBlock);
               up.show();
               down.hide();
            }else{
               me.maximize(300,bottomBlock);
               up.hide();
               down.show();
            }
        });
		
	},
    
    maximize: function(h,bottomBlock) {
        bottomBlock.setHeight(h);
    },
    
    minimize: function(bottomBlock) {
        bottomBlock.setHeight(170);
    }
	
})