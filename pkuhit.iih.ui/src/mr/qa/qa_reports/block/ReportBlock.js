/** 
 * 报表
 * @author ：cheng_feng
 */

Ext.define('iih.mr.qa.qa_reports.block.ReportBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: ['Xap.ej.element.field.ComboBox'],

    alias:'widget.reportblock', 
    
    layout: 'fit',
    
    bodyStyle: 'background:#F0F0F0;',//gray
       
   /* items: [{
    	
//        title: 'Panel 1',
        html: '<iframe align = "center" width="800" height="580" src="http://localhost:8088/BiosQa/ReportEmitter?rpt=sample.brt"> </iframe>'
    }],*/
     hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }

})