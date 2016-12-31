/** 
 * 加载质控报表查询条件
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.action.ShowReportConditionAction', {
extend: 'Xap.ej.action.Action',

	requires: [],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = me.getOwner();   
		
		var topBlock = owner.getBlock('top');
		
		var beginTimeItem = topBlock.down('xapdatefield[name=beginTime]');
		
		var intervalSymbolItem = topBlock.down('xapdisplayfield[name=intervalSymbol]');
		
		var endTimeItem = topBlock.down('xapdatefield[name=endTime]');
		
		var paramTypeItem = topBlock.down('xapdisplayfield[name=paramType]');
		
		var paramValueItem = topBlock.down('xapcombobox[name=paramValue]');
		
		var reportRecord = owner.reportRecord.data;
		
		var reportParaTp = reportRecord.paraTp;
		
		if(reportParaTp=='4'){
			beginTimeItem.setVisible(true);
			intervalSymbolItem.setVisible(true);
			endTimeItem.setVisible(true);
			paramTypeItem.setVisible(false);
			paramValueItem.setVisible(false);
		}else{
			beginTimeItem.setVisible(false);
			intervalSymbolItem.setVisible(false);
			endTimeItem.setVisible(false);
			paramTypeItem.setVisible(true);
			paramValueItem.setVisible(true);
			var displayStr;
			var dataStr;
			if(reportParaTp=='1'){//月度
				displayStr = '月度：';
				dataStr = [{"code":"1", "name":"一月"},
						        {"code":"2", "name":"二月"},
						        {"code":"3", "name":"三月"},
						        {"code":"4", "name":"四月"},
						        {"code":"5", "name":"五月"},
						        {"code":"6", "name":"六月"},
						        {"code":"7", "name":"七月"},
						        {"code":"8", "name":"八月"},
						        {"code":"9", "name":"九月"},
						        {"code":"10", "name":"十月"},
						        {"code":"11", "name":"十一月"},
						        {"code":"12", "name":"十二月"}];
			} else if(reportParaTp=='2'){//季度
				displayStr = '季度：';
				dataStr = [{"code":"1", "name":"一季度"},
						        {"code":"2", "name":"二季度"},
						        {"code":"3", "name":"三季度"},
						        {"code":"4", "name":"四季度"}];
			} else if(reportParaTp=='3'){//年度
				displayStr = '年度：';
				var nowStr = new Date(); 
	    		var yearStr = nowStr.getFullYear(); //年份
				dataStr = [{"code":yearStr, "name":yearStr},
						        {"code":yearStr-1, "name":yearStr-1},
						        {"code":yearStr-2, "name":yearStr-2},
						        {"code":yearStr-3, "name":yearStr-3},
						        {"code":yearStr-4, "name":yearStr-4}];
			}
			paramTypeItem.setValue(displayStr);
			paramValueItem.setData(dataStr);
		}
	}
});