
/** 
 * 病历树面板
 * @extends Xap.ej.element.panel.Panel
 * @author ：wang_yanli 
 */
Ext.define('iih.mr.qa.process_qa_work.block.MrInBlock',{
	extend : 'Xap.ej.element.panel.Panel',
	
	requires: ['iih.mr.qa.process_qa_work.view.QaMrDocTreeView'],

    alias:'widget.mrinblock',
    
    layout: 'fit',
        
    title: '病历一览',
    
    tools: [{
        type: 'left',
        handler: function(event, toolEl, header, tool) {
            var panel = header.ownerCt;
            panel.collapse();
        }
    }],
    
    items:[{
    	xtype:'qamrdoctreeview'
    }]

})