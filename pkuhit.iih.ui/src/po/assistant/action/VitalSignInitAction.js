Ext.define('iih.po.assistant.action.VitalSignInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
	    this.showLoading();
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations);
    },
    prepareOperations: function(operations) {
	    Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    	return fmt;
		}
		var curdate = new Date().Format("yyyy-MM-dd");
		var bDate = new Date();
		bDate.setDate(bDate.getDate()-7);
	    var encounterSn = IMER_GLOBAL.encounterSn;
 	//  var url = this.url+"?enPk=723551&acquisitionStartTime=2010-02-19 21:05:10.630&acquisitionStopTime=2020-02-19 21:05:10.630";
    	url = this.url;
    	var startTime = bDate.Format("yyyy-MM-dd") +" 00:00:00";
    	var endTime = curdate+" 23:59:59";
    	var params = {enPk:encounterSn,acquisitionStartTime:startTime,endTime:endTime};
    	var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
    		mclass: null,
    		method: METHODS.METHOD_GET,
    		condition: null,
    		scope: this,
    		params:params,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	//alert("onsuccess");
        var block = this.getBlock('result');
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        } else {
            block.setData(m);
        }
    }
});