/** 
 * 报表
 * @author ：cheng_feng
 */

Ext.define('iih.mrb.block.UseRateReportBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: ['Xap.ej.element.field.ComboBox'],

    alias:'widget.useratereportblock', 
    
    layout: 'fit',
    
    bodyStyle: 'background:#F0F0F0;',//gray
       
   items: [{
    	
//        title: 'Panel 1',
     //   html: '<iframe align = "center" width="800" height="580" src="http://localhost:8088/BiosQa/ReportEmitter?rpt=sample.brt"> </iframe>'
        	/* http://localhost:8088/BiosQa/ReportEmitter?rpt=userate_hospital.brt&params=startDatetime=2012-01-01 00:00:00;endDatetime=2015-01-01 00:00:59; 
        	 *  http://localhost:8088/BiosQa/ReportEmitter?rpt=userate_hospital.brt&params=startDatetime=2012-01-01 00:00:00;endDatetime=2015-01-01 00:00:59; 
        	 *   http://localhost:8088/BiosQa/ReportEmitter?rpt=userate_hospital.brt&params=startDatetime=2012-01-01 00:00:00;endDatetime=2015-01-01 00:00:59; 
*/        	
    }]/*,
     hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }*/

})