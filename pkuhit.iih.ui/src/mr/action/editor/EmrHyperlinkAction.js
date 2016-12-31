Ext.define('iih.mr.action.editor.EmrHyperlinkAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	/*
	* @Override
	*/
	execute: function(context) {
		var plugin = document.getElementById('iemrEditor');
		var user = IMER_GLOBAL.user;
		var arg=context.event.arguments[1];
		if(arg&&arg.indexOf('Signature')>0){
			plugin.ImportSignature(user.name,1,'');
		}else{
			var str=arg.split('&');
			var x=str[0].substring(str[0].indexOf('=')+1);
			var y=str[1].substring(str[1].indexOf('=')+1);
			var id=str[2].substring(str[2].indexOf('=')+1);
			
			var showMdDi=this.getOwner().getActionChain('showHyperlink');
			showMdDi.execute({'x':parseInt(x),'y':parseInt(y),'id':id});
			if(id == 'MR.M.014.D.1' ||id == 'MR.M.014.D.2' ||id == 'MR.M.014.D.3'){
				var comboxgrid= Ext.getCmp('DiSelectId');
				comboxgrid.focus();
			}
		}
	}
 
});
