Ext.define('iih.mr.wr.omr.action.TimestampErpSignErpSignAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var sigField;

        var FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
        var SigFieldMgr = FoxitPDFSDK.GetPDFSignatureMgr();

        //set the position to locate the signature.
        sigField = SigFieldMgr.Add( 0, 10, 60, 25, 44 );

        if( null==sigField)
        {
        	Ext.MessageBox.alert('提示', FoxitPDFSDK.GetLastSigModuleErrMsg());
        }

        //Set filter and subFilter if need.This mainly be used by customer algorithm.
        //when you signed by default algorithm they will be default set Filter with "Adobe.PPKLite" and SubFilter with "adbe.pkcs7.detached"
        sigField.Filter = 'Adobe.PPKLite';
        sigField.SubFilter = 'ETSI.RFC3161';

        //sign and save as pdf
		var tsOutputPath = "C:\\" + 'timestamp.pdf';
		// 其中User和Password的格式是：user:password
        var bRet = SigFieldMgr.SignDocumentTs( sigField, tsOutputPath, '10.1.6.196', '/tss/tsp', 8080, ':' );
        if(!bRet)
        {
        	//Ext.MessageBox.alert('提示', "签章失败.");
            SigFieldMgr.Remove(sigField);
			return false;
        }
        else
        {
			return true;
			 //Ext.MessageBox.alert('提示', "签章成功！");
        }
	}
});
