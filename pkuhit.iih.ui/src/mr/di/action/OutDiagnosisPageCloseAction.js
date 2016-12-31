Ext.define('iih.mr.di.action.OutDiagnosisPageCloseAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    
    /*
    * @Override
    */
    doExecute: function(context) {
    	console.log('iih.mr.di.action.OutDiagnosisPageCloseAction') ;
    	var operations = context.operations;
        if(!operations) {
            return;
        }
    	var gui = require('nw.gui');
		var win = gui.Window.get();
		var page = this.getOwner();
		//console.log('page') ;
		//console.log(page) ;
		win.on('close', function() {
			var a = this ;
			var close=function(){
				a.close(true);
			};
			if(!page.hasEdit()){
			  return;
			}
			//var box = new Ext.window.MessageBox();
			XapMessageBox.confirm('是否保存对诊断录入的修改？',
		            function(btn, text){
		                if (btn == 'yes') {
		                	var saveActionChain= page.getActionChain('outDiagnosisSaveAction');
		                	saveActionChain.execute({callback:close});
		                } else if (btn == 'no') {
		                	close();
		                } else if (btn == 'cancel') {
		                }
		            },page
		        );
	
		});

    }
});
