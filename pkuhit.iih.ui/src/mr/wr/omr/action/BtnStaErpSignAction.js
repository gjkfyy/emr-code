var FoxitPDFSDK=null;
Ext.define('iih.mr.wr.omr.action.BtnStaErpSignAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	/*
	 * @Override
	 */
	
	execute: function(context) {
		var erpSignType=context.erpSignType;
		if(erpSignType&&'serchErpSign'==erpSignType){
			//这是浏览签名
			var erpSignSaveBtn=Ext.getCmp('erpSignSaveBtn');
			erpSignSaveBtn.hide();
			var timePokeSignBtn=Ext.getCmp('timePokeSignBtn');
			timePokeSignBtn.hide();
			var fingerprintGatherBtn=Ext.getCmp('fingerprintGatherBtn');
			fingerprintGatherBtn.hide();
			var patientSignBtn=Ext.getCmp('patientSignBtn');
			patientSignBtn.hide();
			var doctorSignBtn=Ext.getCmp('doctorSignBtn');
			doctorSignBtn.hide();
			
			var FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
            FoxitPDFSDK.UnLockActiveX("SDKAXYX8713","96DD4132B358C88E9CBDB7A07B789D723DB5835F");
			FoxitPDFSDK.CloseFile();
			FoxitPDFSDK.SetCurrentLanguage(6);
			var outmrdoceditview= Ext.getCmp('outmrdoceditview');
			var mr=outmrdoceditview.medicalRecord;
			var mrDocPdfFile=mr.caFileData;
			var base64DecodePath = 'C:\\base64Decode.pdf';
			//console.log(mrDocPdfFile);
			if(FoxitPDFSDK){
				if(mrDocPdfFile&&mrDocPdfFile.length>10){
					var savePath=FoxitPDFSDK.ReadBase64ToFile(mrDocPdfFile, base64DecodePath);
					FoxitPDFSDK.CloseFile();
					FoxitPDFSDK.OpenFile(base64DecodePath,'');
					FoxitPDFSDK.bHighlightFormFields = false;
				}else{
					Ext.MessageBox.alert('提示', '没有找到签名文件，该病历可能尚未签名！');
				}
			}else{
				Ext.MessageBox.alert('提示', 'CA阅读器ActiveX插件不可用，请重试！');
			}
		}else if(erpSignType&&'erpSign'==erpSignType){
			//电子签名
			if(context.pdfPath){
				this.foxit_sdk_initialize(context.pdfPath);
			}
		}		
	},
	foxit_sdk_initialize:function(pdfPath)
    {
		FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
		FoxitPDFSDK.UnLockActiveX("SDKAXYX8713","96DD4132B358C88E9CBDB7A07B789D723DB5835F");
		//FoxitPDFSDK.SetCurrentLanguageByString("C:\\npactivex\\lang_zh_cn.xml");
		FoxitPDFSDK.CloseFile();
		FoxitPDFSDK.OpenFile(pdfPath,'');
		FoxitPDFSDK.SetCurrentLanguage(6);
		FoxitPDFSDK.bHighlightFormFields = false;
       //document.getElementById("FoxitPDFSDK").OpenFile( demoTestPDF,demoTestPDFPassword);
    },// 铅笔标注
    foxit_sdk_set_tool:function (tool)
	{
		FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
		FoxitPDFSDK.CurrentTool = tool;
	},
	// Wacom医生手写签名
	foxit_sdk_wacom_doctor:function ()
    {

		// 启动Wacom面板
		var sigCtl = document.getElementById("sigCtl1");
		//var dc = new ActiveXObject("Florentis.DynamicCapture");
		var dc = document.getElementById("sigcapt");
		var rc = dc.Capture(sigCtl, "who", "why");
		switch( rc ) {
		case 0: // CaptureOK
			//alert("Signature captured successfully");
			var txtSignature = document.getElementById("txtSignature");
			flags = 0x2000 + 0x80000 + 0x400000; //SigObj.outputBase64 | SigObj.color32BPP | SigObj.encodeData
			b64 = sigCtl.Signature.RenderBitmap("", 200, 100, "image/png", 1, 0x000000, 0xffffff, 0.0, 0.0, flags );

			// 计算位置
			var isGetPosition = false;
			var left = 0;
			var top = 0;
			var pageIndex = 0;
			for (i = 0; i < FoxitPDFSDK.PageCount; i++) {
				var FindResult = FoxitPDFSDK.FindPageFirst(i, '医生签字', false, false);
				if (FindResult != null) {
					isGetPosition = true;
					// 返回的String格式：left top right bottom
					var rectString = FindResult.GetFindRectStringByIndex(0);
					// String转换为Array
					var rectArray = rectString.split(' ');
					// 插入图片
					// ‘患者或近亲属或法定代理人签字’，这段文字‘字’的下方为rect的right和bottom,
					// 需要向下偏移一定量，假设为50（可修改），再偏移图片的大小，
					var left = rectArray[2] - hDoctorImg - 50;
					var top = rectArray[3] - hDoctorImg; //rectArray[3] - offsetSign - hPatientImg - hDoctorImg;
					pageIndex = FindResult.GetFindPageNum();
					break ;
				}
			}
			FoxitPDFSDK.FindClose();
			
			// 建议，设置获取位置不成功时，的默认值。
			if (!isGetPosition) {
				left = FoxitPDFSDK.GetPageWidth(0) - wPatientImg;
				top = hFingerImg;
				pageIndex = FoxitPDFSDK.PageCount - 1; // 最后一页
			}

			// 添加图片（暂时不支持jpg的base64添加），参数可设置(图片大小在"sigCtl1" id上设置)
			var addimageRet = FoxitPDFSDK.AddImageByFileBase64(pageIndex, left, top, wDoctorImg, hDoctorImg, b64, 100, 0);
			break;
        case 1: // CaptureCancel
			alert("Signature capture cancelled");
			break;
        case 100: // CapturePadError
			alert("No capture service available");
			break;
        case 101: // CaptureError
			alert("Tablet Error");
			break;
        case 102: // CaptureIntegrityKeyInvalid
			alert("The integrity key parameter is invalid (obsolete)");
			break;
        case 103: // CaptureNotLicensed
			alert("No valid Signature Capture licence found");
			break;
        case 200: // CaptureAbort
			alert("Error - unable to parse document contents");
			break;
        default: 
			alert("Capture Error " + rc);
			break;
		}
    },
	// Wacom患者手写签名
    foxit_sdk_wacom_patient:function ()
    {
		// 启动Wacom面板
		var sigCtl = document.getElementById("sigCtl1");
		//var dc = new ActiveXObject("Florentis.DynamicCapture");
		var dc = document.getElementById("sigcapt");
		var rc = dc.Capture(sigCtl, "who", "why");
		switch( rc ) {
		case 0: // CaptureOK
			//alert("Signature captured successfully");
			var txtSignature = document.getElementById("txtSignature");
			flags = 0x2000 + 0x80000 + 0x400000; //SigObj.outputBase64 | SigObj.color32BPP | SigObj.encodeData
			b64 = sigCtl.Signature.RenderBitmap("", 300, 150, "image/png", 1, 0x000000, 0xffffff, 0.0, 0.0, flags );

			var isGetPosition = false;
			var left = 0;
			var top = 0;
			var pageIndex = 0;
			for (i = 0; i < FoxitPDFSDK.PageCount; i++) {
				var FindResult = FoxitPDFSDK.FindPageFirst(i, '患者或近亲属或法定代理人签字', false, false);
				if (FindResult != null) {
					isGetPosition = true;
					// 返回的String格式：left top right bottom
					var rectString = FindResult.GetFindRectStringByIndex(0);
					// String转换为Array
					var rectArray = rectString.split(' ');
					// 插入图片
					// ‘患者或近亲属或法定代理人签字’，这段文字‘字’的下方为rect的right和bottom,
					// 需要向下偏移一定量，假设为50（可修改），再偏移图片的大小
					var left = rectArray[2] - hPatientImg - offsetSign;
					if (left < 0)
					{
						left = rectArray[2];
					}
					var top = rectArray[3] - hPatientImg; // - offsetSign - hPatientImg;
					var pageIndex = FindResult.GetFindPageNum();
					//fingerLeft = rectArray[1];
					break ;
				}
			}
			FoxitPDFSDK.FindClose();
			
			// 建议，设置获取位置不成功时，的默认值。
			if (!isGetPosition) {
				left = FoxitPDFSDK.GetPageWidth(0) - wPatientImg;
				top = hFingerImg;
				pageIndex = FoxitPDFSDK.PageCount - 1; // 最后一页
			}
			
			// 患者指纹位置
			fingerLeft = left + wPatientImg + 10;
			fingerBottom = top - 20;
			// 添加图片（暂时不支持jpg的base64添加），参数可设置(图片大小在"sigCtl1" id上设置)
			var addimageRet = FoxitPDFSDK.AddImageByFileBase64(pageIndex, left, top, wPatientImg, hPatientImg, b64, 100, 0);

			break;
        case 1: // CaptureCancel
			alert("Signature capture cancelled");
			break;
        case 100: // CapturePadError
			alert("No capture service available");
			break;
        case 101: // CaptureError
			alert("Tablet Error");
			break;
        case 102: // CaptureIntegrityKeyInvalid
			alert("The integrity key parameter is invalid (obsolete)");
			break;
        case 103: // CaptureNotLicensed
			alert("No valid Signature Capture licence found");
			break;
        case 200: // CaptureAbort
			alert("Error - unable to parse document contents");
			break;
        default: 
			alert("Capture Error " + rc);
			break;
		}
    },
	
	// 时间戳签名
    foxit_sdk_ts_signature:function  ()
    {
        var sigField;

        FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
        SigFieldMgr = FoxitPDFSDK.GetPDFSignatureMgr();

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
        var bRet = SigFieldMgr.SignDocumentTs( sigField, tsOutputPath, '10.1.6.195', '/tss/tsp', 8080, ':' );
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
    },
	// 数据保存为Base64
    foxit_sdk_save_base64:function (value)
	{
		FuiMessageBox.confirm2('签名保存后将无法对病历进行修改和再次签名，请确认是否继续保存签名？', function(btn) {
            if (btn == 'yes') {
				var signresult = foxit_sdk_ts_signature(); 
				if(!signresult){
					Ext.MessageBox.alert('提示', '已签章或签章失败，病历保存失败！');
				   return ; 
				}
				FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
				// 保存文件
				FoxitPDFSDK.Save();
				// 获得文件路径
				//var filePath = FoxitPDFSDK.FilePath;
				var filePath = "C:\\" + 'timestamp.pdf';
				// 转换为base64
				var base64 = FoxitPDFSDK.ReadFileToBase64(filePath);
				var data={'base64':base64};
				data.docId=docId;
				FuiPageFactory.submit({
			          serviceName: 'fi.clinical.mr.online.mr_doc_edit.MRDocEditService',
			          serviceMethodName: 'savePDF',
			          data: [data],
			          success: function(mrbMrDocFile) {
							var electronicSign=Ext.getCmp('electronicSign');
							electronicSign.setDisabled(true);
							var gridDoc = me.getMrDocGrid();
							var deleteBtn=gridDoc.down('button[action=delete]');
							deleteBtn.setDisabled(true);
							var emrDocDelete = window.iemr.extensions.constants[0].EMR_DOC_DELETE;
							var emrSave = window.iemr.extensions.constants[0].EMR_SAVE;
							var emrRefreshMacro = window.iemr.extensions.constants[0].EMR_REFRESH_MACRO;//刷新宏元素
							var emrRefreshDiagnosis = window.iemr.extensions.constants[0].EMR_REFRESH_DIAGNOSIS;//刷新诊断
							iemrEditor.SetCommandVisible(emrDocDelete, false);
							iemrEditor.SetCommandVisible(emrSave, false);
							iemrEditor.SetCommandVisible(emrRefreshMacro, false);
							iemrEditor.SetCommandVisible(emrRefreshDiagnosis, false);
							iemrEditor.SetReadOnly();
							iemrEditor.UpdateToolbar();
							docEditPage.data.updateCount = mrbMrDocFile.updateCount;
			          },
			          failure: function(data) {
//			              Ext.MessageBox.alert('提示', '保存失败！');
			          }
			    });
            }else if (btn == 'no') {
                return false;
            }
        });
	},
	// 指纹采集
	foxit_sdk_get_finger:function ()
    {
		MXOTOCX = document.getElementById("idMXOTOCX");
		var isMxUsbDevice = MXOTOCX.IsMxUsbDevice();
		if (isMxUsbDevice == -1) {
			alert("请插入指纹采集设备！");
			return ;
		}
		// 采集特征码
		var dwWaitTime = 5000; //超时时间（毫秒）
		var mxUsbGetTz = MXOTOCX.mxUsbGetTz(dwWaitTime);
		// 采集指纹图片
		var ret = MXOTOCX.mxGetTzImage(demoFingerBmp);
		
		FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
		// 参数可设置
		//var left = FoxitPDFSDK.GetPageWidth(0) - wFingerImg;
		var top = 0;
		var left = 160; //fingerLeft; // FoxitPDFSDK.GetPageWidth(0) - 100;
		var bottom = fingerBottom; //FoxitPDFSDK.GetPageHeight(0) - 304;
		var lastPageIndex = FoxitPDFSDK.PageCount - 1; // 最后一页
		var addimageRet = FoxitPDFSDK.AddImageObject(lastPageIndex, left, bottom, wFingerImg, hFingerImg, demoFingerBmp, 100, 0);
    }
});
