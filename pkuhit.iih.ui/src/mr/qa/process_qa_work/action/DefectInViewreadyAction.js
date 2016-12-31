/** 
 * 缺陷一览页面加载完成后查找到相关按钮进行事件的监听
 * @extends Xap.ej.action.Action
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.process_qa_work.action.DefectInViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){
		
		var me = this;
		
	    var owner = this.getOwner();
	    
	    //获取缺陷一览的 block
		var block = this.getBlock('bottomcontent');
		
		var defectsinGrid = block.down('xapgrid');
		
		
		var rs = [{ 
				'pk':'pk',
   				'qaItemPk':'qaItemPk',
   				'qaSystemItemCode':'qaSystemItemCode',
   				'reformRequirement': 'Lisa',
   				'reformFlag':1,
   				'statusCode':'QAM01.04',
   				'dropFlag':1,
   				'reformRequirement':'xxxxx',
   				'dropDescription':'yyyy',
   				'canEdit':1,
   				'canReform':1,
   				'faultConfirmResult':'QAM07.01'
   			},
   			{ 
   				'pk':'pk',
   				'qaItemPk':'qaItemPk',
   				'qaSystemItemCode':'qaSystemItemCode',
   				'reformRequirement': 'Lisa111',
   				'reformFlag':1,
   				'statusCode':'QAM01.04',
   				'dropFlag':0,
   				'reformRequirement':'xxxxx',
   				'dropDescription':'yyyy',
   				'canEdit':1,
   				'canReform':1,
   				'faultConfirmResult':'QAM07.01'
   			}];
		
		//defectsinGrid.setData(rs);
		
		//提缺陷按钮
		var defectsin = block.down('button[action=defectsin]');
		
		
		//完成本次质控按钮
		var defectsfinish = block.down('button[action=defectsfinish]');
		
		//向上按钮
		var up = block.down('tool[itemId=up]');
		
		//向下按钮
		var down = block.down('tool[itemId=down]');
		
		/*//保存按钮
		var defectssave = block.down('button[action=defectssave]');*/
		
		/*//编辑缺陷按钮
		var editDefect = grid.down('xapactioncolumn[id=editDefect]');
		
		//删除缺陷按钮
		var defectDelete = block.down('button[action=defectDelete]');*/
		
		
		//提缺陷按钮监听
		defectsin.on('click',function(btn){
			var popupFaultInputViewChain = owner.getActionChain("popupFaultInputViewAction");
			popupFaultInputViewChain.execute();
		});
		
		//完成本次质控按钮监听
		defectsfinish.on('click',function(btn){
			var popupDefectNoticeInferViewChain = owner.getActionChain("popupDefectNoticeInferViewAction");
			popupDefectNoticeInferViewChain.execute();
		});
		
		/*//保存按钮 监听
		defectssave.on('click',function(btn){
			var defectssaveChain = owner.getActionChain("saveDefectsAction");
			defectssaveChain.execute();
		});
		
		editDefect.on('click',function(btn){
			var editDefectChain = owner.getActionChain("editDefectAction");
			editDefectChain.execute();
		});
		
		
		//删除按钮 监听
		defectDelete.on('click',function(btn){
			XapMessageBox.confirm2(
				'确认删除？',
   				function(btn){
				if(btn=="yes"){
					var defectDeleteChain = owner.getActionChain("deleteDefectsAction");
					defectDeleteChain.execute();
				}
			});
			
		});*/
		
        down.addListener('click', function() {
            me.minimize(block);
            up.show();
            down.hide();
        });
        up.addListener('click', function() {
            me.maximize(CONFIG_PARAM.ASSISTANT_HEIGHT_ZY,block);
            up.hide();
            down.show();
        });
        
        //表头
		var tbar = defectsinGrid.down('header');
        tbar.addListener('dblclick', function() {
            if(down.hidden==false){
               me.minimize(block);
               up.show();
               down.hide();
            }else{
               me.maximize(300,block);
               up.hide();
               down.show();
            }
        });

	},
    
    maximize: function(h,block) {
        block.setHeight(h);
    },
    
    minimize: function(block) {
        block.setHeight(170);
    }
	
})