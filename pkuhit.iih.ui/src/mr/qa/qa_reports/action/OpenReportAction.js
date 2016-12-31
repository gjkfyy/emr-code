/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.action.OpenReportAction', {
extend: 'Xap.ej.action.Action',

	requires: [],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = me.getOwner();   
		
		var reportRecord = owner.reportRecord.data;
		
		var reportUrl = reportRecord.url;
		
		var paraNm = reportRecord.paraNm;
		
		var paraTp = reportRecord.paraTp;
		
		var paraArr = paraNm.split(';');
		
		var topBlock = owner.getBlock('top');
		
		var paramValueItem = topBlock.down('xapcombobox[name=paramValue]');
		
		var formItems = topBlock.items.items;
		
		var beginTime='';
		var endTime='';
		var deptCd='';
		
	    var nowStr = new Date(); 
	    var yearStr = nowStr.getFullYear(); //年份
	    var paramValue = paramValueItem.getValue();//季度、月份
		var messageStr = '';
		if(paraTp=='4'){
			beginTime = formItems[0].value;
			endTime = formItems[2].value;
			if(beginTime>endTime){
				var message = '起始日期必须小于结束日期，请重新选择！';
				XapMessageBox.info(message);
				return;
			}
			messageStr='时间区间';
		}else if(paraTp=='3'){//年份
			if(paramValue!=null && paramValue!='null' && paramValue!='' && paramValue!='undefined' ){
				var yearValue = paramValue;
				beginTime = yearValue + '-01-01 00:00:00';
	            endTime = yearValue + '-12-31 23:59:59';
			}
			messageStr='年度';
		}else if(paraTp=='2' ){//季度
			if(paramValue!=null && paramValue!='null' && paramValue!='' && paramValue!='undefined' ){
				var quarterStr = paramValue;
				if(quarterStr=='1'){
					beginTime = yearStr + '-01-01 00:00:00';
	                endTime = yearStr + '-03-31 23:59:59';
				}else if(quarterStr=='2'){
					beginTime = yearStr + '-04-01 00:00:00';
	                endTime = yearStr + '-06-30 23:59:59';
				}else if(quarterStr=='3'){
					beginTime = yearStr + '-07-01 00:00:00';
	                endTime = yearStr + '-09-30 23:59:59';
				}else if(quarterStr=='4'){
					beginTime = yearStr + '-10-01 00:00:00';
	                endTime = yearStr + '-12-31 23:59:59';
				}
			}
			messageStr='季度';
		}else if(paraTp=='1' ){//月份
			 if(paramValue!=null && paramValue!='null' && paramValue!='' && paramValue!='undefined' ){
			     var monthStr = paramValue;
			     monthStr = monthStr<10?('0'+monthStr):monthStr;
				 var new_date = new Date(yearStr, monthStr, 1);  //取当年当月中的第一天          
	             var dayStr = new Date(new_date.getTime()-1000*60*60*24).getDate();//获取当月最后一天日期
	             dayStr = dayStr<10?('0'+dayStr):dayStr;
	             beginTime = yearStr + '-' + monthStr + '-' +'01 00:00:00';
	             endTime = yearStr + '-' + monthStr + '-' + dayStr+' 23:59:59';
			 }
			 messageStr='月度';
		}
		
		deptCd = formItems[5].comboxHiddenValue;
		
		var bottomBlock = owner.getBlock('bottom');
		
		bottomBlock.removeAll();
		
		//Params=参数1名称=参数1数值；参数2名称=参数2数值；参数3名称=参数3数值… …
		//例如：http://IP地址：服务器端口/web路径/ReportEmitter?rpt=Demo/参数报表/时间参数.brt&params=year=1997;area=华南区
		//yyyy-MM-dd HH:mm:ss
		
		var srcStr = reportUrl;
		
		if((beginTime==undefined) || (endTime==undefined) || (beginTime=='') || (endTime=='') ){
			var message = '请选择'+messageStr+'！';
			XapMessageBox.info(message);
			return;
		}else if((beginTime!=undefined) && (endTime!=undefined) ){
			if(paraTp=='4'){
				beginTime = Ext.util.Format.date(beginTime,'Y-m-d');
				endTime = Ext.util.Format.date(endTime,'Y-m-d');
				beginTime += ' 00:00:00';
				endTime += ' 23:59:59';
			}else{
				beginTime = Ext.util.Format.date(beginTime,'Y-m-d h:m:s');
				endTime = Ext.util.Format.date(endTime,'Y-m-d h:m:s');
			}
			var vArr = new Array([beginTime,endTime,deptCd]);
		    var paramStr ='&params=paramType='+paraTp+';';
			for(var i=0;i<paraArr.length;i++){
				paramStr+=paraArr[i]+'='+vArr[0][i]+';';
			}
			paramStr = paramStr.substring(0, paramStr.length-1);
			srcStr = reportUrl+paramStr;
		}
		srcStr += "&toolbardisplay=top";//&fitwidth=true
		var htmlStr = {'html':'<iframe align = "center" width="100%" height="100%" src="'+srcStr+'"> </iframe>'};
		
		bottomBlock.add(htmlStr);
		
    }
});