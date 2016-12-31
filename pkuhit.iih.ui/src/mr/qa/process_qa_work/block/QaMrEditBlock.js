/** 
 * 编辑器面板
 * @extends Xap.ej.block.Block
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.block.QaMrEditBlock',{
	//extend : 'Xap.ej.block.Block',
	extend : 'Xap.ej.block.FormBlock',
	
	requires: ['Xap.ej.element.field.ComboBox'],

    alias:'widget.qamreditblock', 
    
    layout: 'fit',
    
    bodyStyle: 'background:#F0F0F0;',//gray
       
    /*items: [{
    	xtype : 'xapcombobox',
		labelWidth : 60,
		labelAlign : 'right',
		name : 'userStatusCode',
		//dictionary : 'MRM010',
		dictionary:'QAM01',
		padding:'0 80 0 0',
		action:'defectsinstatus'
    }]*/
     hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }

})