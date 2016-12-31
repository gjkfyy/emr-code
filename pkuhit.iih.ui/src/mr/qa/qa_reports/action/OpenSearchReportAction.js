/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.action.OpenSearchReportAction', {
extend: 'Xap.ej.action.Action',

	requires: [],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = me.getOwner();   
		
		var reportRecord = owner.reportRecord.data;
		
		var reportUrl = reportRecord.url.trim();
		
		var resultBlock = owner.getBlock('result');
		var deptCd = IMER_GLOBAL.department.code;
		//Params=参数1名称=参数1数值；参数2名称=参数2数值；参数3名称=参数3数值… …
		//例如：http://IP地址：服务器端口/web路径/ReportEmitter?rpt=Demo/参数报表/时间参数.brt&params=year=1997;area=华南区
		//yyyy-MM-dd HH:mm:ss
		reportUrl += "&toolbardisplay=top&params=deptCd="+deptCd;//&fitwidth=true
		var htmlStr = {'html':'<iframe align = "center" width="100%" height="100%" src="'+reportUrl+'"> </iframe>'};
		
		resultBlock.add(htmlStr);
		
    }
});