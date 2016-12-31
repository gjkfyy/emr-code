Ext.define('iih.mr.wr.nmr.action.emrSplFmPkAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	doExecute : function(context) {
		var self = this;
		self.prepareOperations(context.operations);
	},
	prepareOperations : function(operations) {
		var url = this.url;
		url += '/' + IMER_GLOBAL.encounterSn;
		var METHODS = this.getInvocationMethods();
		var operation = {
			url : url,
			method : METHODS.METHOD_GET,
			scope : this,
			success : this.onSuccess
		};
		operations.push(operation);
	},
	onSuccess : function(operation) {
		var rowNum=6;//共6行
		function f(s){ 
			if(s.match(/;/ig).length < rowNum+1){ 
				return s; 
			}else{ 
				return f(s.substring(0,s.lastIndexOf(";"))); 
			} 
		}
		function addNbsp(val,str){
			for (var int = 0; int < val; int++) {
				if(str.length<1){
					str+='&nbsp';
				}else{
					str+=';&nbsp';
				}
			}
			return str;
		}
		if (operation.result.data) {
			var obj = operation.result.data;
			var str = '';
			var arr = new Array();
			var i = 0;
			for ( var key in obj) {
				var a = obj[key];
				str = key + ";" + a;
				str =addNbsp(rowNum+1,str);
				if(str.match(/;/ig).length > rowNum){//只取6组值
					str= f(str);
				}
				str = str.replace(/;/g, "\n");
				arr[i] = str;
				i++;
			}
			if(arr[0]==null){
				arr[0]=addNbsp(rowNum+1,'').replace(/;/g, "\n");
			}
			console.info(arr);
			var plugin = document.getElementById('iemrEditor');
			plugin.ImportTableRow("中医出院护理表", arr);
		}
	}
});