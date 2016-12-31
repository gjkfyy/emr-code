/** 
 * 缺陷一览BLOCK
 * @extends Xap.ej.block.Block
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.block.DefectsInHelperBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: ['iih.mr.qa.process_qa_work.block.DefectsInBlock',
	           'iih.mr.qa.qa_work_assistant.view.QaWorkHelperView'],

    alias:'widget.defectsinhelperblock',
	layout: 'fit',
	items: [{
        xtype:'xaptabpanel',
        border:true, 
        tabButtons:[{
            itemId: 'up',
            hidden: false,
            xtype: 'tool',
            type: 'up'
        },{
            itemId: 'down',
            hidden: true,
            xtype: 'tool',
            type: 'down'
        },{
            xtype: 'label',
            width: 5
        }],
        items:[{
        	xtype: 'defectsinblock',
    		title:'缺陷一览'
        },{
    		xtype: 'qaworkhelperview',
    		title:'助手区'
    	}]
	}],
	 initComponent: function() {
         this.callParent();
         var me = this;
         var tabpanel = this.down('xaptabpanel');
         if (tabpanel.tabButtons.length > 0 && !this.hideTabBar) {
             this.initTabButton();
         };
         var helpContent = me.down('xaptabpanel');
         var up = helpContent.down('tool[itemId=up]');
         var down = helpContent.down('tool[itemId=down]');
         
         down.addListener('click', function() {
             me.minimize();
             up.show();
             down.hide();
         });
         up.addListener('click', function() {
             me.maximize(CONFIG_PARAM.ASSISTANT_HEIGHT_ZY);//yaolijie 将助手去高度设置为可配置参数，默认为500，根据不同医院需求配置参数
             up.hide();
             down.show();
         });

         var tbar = helpContent.getTabBar();
         tbar.addListener('dblclick', function(tabBar, e) {
             var target=e.getTarget();
             if(e.getTarget().tagName.toLowerCase() == "div"){
                 if(down.hidden==false){
                     me.minimize();
                     up.show();
                     down.hide();
                   }else{
                 	  me.maximize(CONFIG_PARAM.ASSISTANT_HEIGHT_ZY);//yaolijie 将助手去高度设置为可配置参数，默认为500，根据不同医院需求配置参数
                     up.hide();
                     down.show();
                   }
             }
         });
	 },
     
     initTabButton: function() {
         var tabpanel = this.down('xaptabpanel');
         tabpanel.getTabBar().add({
             xtype: 'container',
             layout: {
                 type: 'hbox',
                 align: 'middle',
                 pack: 'end'
             },
             flex: 1,
             items: Ext.isArray(tabpanel.tabButtons) ? tabpanel.tabButtons : [tabpanel.tabButtons]
         });
     },
     maximize: function(h) {
         this.setHeight(h);
     },
     
     minimize: function() {
         this.setHeight(180);
     }

})