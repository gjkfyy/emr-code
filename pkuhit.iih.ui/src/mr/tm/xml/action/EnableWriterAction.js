Ext.define('iih.mr.tm.xml.action.EnableWriterAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		 var plugin = document.getElementById('iemrEditor'); 
	     plugin.EnableOCX(true);//设置编辑器可用
	}
});
