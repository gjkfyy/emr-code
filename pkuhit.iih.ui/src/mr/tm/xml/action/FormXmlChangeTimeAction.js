Ext.define('iih.mr.tm.xml.action.FormXmlChangeTimeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getOwner();
        //设置右面编辑页面
        var showFormat = view.down('xapcombobox[name=showFormat]');
        var formatInfo = view.down('xapdisplayfield[name=formatInfo]');
        if(context.showFormat!=undefined){
        	showFormat.setValue(context.showFormat);
        }
        var dateTimeValueShow = view.down('xapdisplayfield[name=dateTimeValueShow]');
        var dateTimeValue = view.down('xaptextfield[name=dateTimeValue]');
        mrETN = showFormat.rawValue;
        Date.prototype.pattern=function(fmt) {           
            var o = {           
            "M+" : this.getMonth()+1, //月份           
            "D+" : this.getDate(), //日           
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
            "H+" : this.getHours(), //小时           
            "m+" : this.getMinutes(), //分           
            "s+" : this.getSeconds(), //秒           
            "q+" : Math.floor((this.getMonth()+3)/3), //季度           
            "S" : this.getMilliseconds() //毫秒           
            };           
            var week = {           
            "0" : "/u65e5",           
            "1" : "/u4e00",           
            "2" : "/u4e8c",           
            "3" : "/u4e09",           
            "4" : "/u56db",           
            "5" : "/u4e94",           
            "6" : "/u516d"          
            };           
            if(/(Y+)/.test(fmt)){           
                fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
            }           
            if(/(E+)/.test(fmt)){           
                fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
            }           
            for(var k in o){           
                if(new RegExp("("+ k +")").test(fmt)){           
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
                }           
            }           
            return fmt;           
        }   
        if(!Ext.isEmpty(mrETN,false)){
        	dateTimeValueShow.setValue((new Date()).pattern(mrETN));
        	dateTimeValue.setValue((new Date()).pattern(mrETN));
        }else{
//    		formatInfo.setValue('');
    		dateTimeValueShow.setValue('');
    		dateTimeValue.setValue('');
        }
    }
});
