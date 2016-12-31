/** 
 * 环节质控查询页面，缺陷列表加载完成后查找到tools上的相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：cheng_feng
 */

Ext.define('iih.mr.qa.process_qa_search.action.ProcessQaDefectViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		
		var me = this;
		
	    var owner = this.getOwner();
	    
		//获取缺陷一览的 block
		var bottomBlock = this.getBlock('bottom');		
		var defectGrid = bottomBlock.down('xapgrid');
		
		
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
        bottomBlock.setHeight(200);
    }
	
})