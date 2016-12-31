Ext.define('iih.mr.wr.omr.action.DoctorErpSignAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
		var wDoctorImg = 120;		// 医生手写签名图片的宽，在sigCtl1中设置，在患者图片上面
		var hDoctorImg = 40;		// 医生手写签名图片的高，在sigCtl1中设置
		// 启动Wacom面板
		var sigCtl = document.getElementById("sigCtl1");
		//var dc = new ActiveXObject("Florentis.DynamicCapture");
		var dc = document.getElementById("sigcapt");
		var rc = dc.Capture(sigCtl, "who", "why");
		switch( rc ) {
		case 0: // CaptureOK
			//alert("Signature captured successfully");
			var txtSignature = document.getElementById("txtSignature");
			var flags = 0x2000 + 0x80000 + 0x400000; //SigObj.outputBase64 | SigObj.color32BPP | SigObj.encodeData
			var b64 = sigCtl.Signature.RenderBitmap("", 200, 100, "image/png", 1, 0x000000, 0xffffff, 0.0, 0.0, flags );

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
			Ext.Msg.alert("提示","Signature capture cancelled");
			break;
        case 100: // CapturePadError
        	Ext.Msg.alert("提示","No capture service available");
			break;
        case 101: // CaptureError
        	Ext.Msg.alert("提示","Tablet Error");
			break;
        case 102: // CaptureIntegrityKeyInvalid
        	Ext.Msg.alert("提示","The integrity key parameter is invalid (obsolete)");
			break;
        case 103: // CaptureNotLicensed
        	Ext.Msg.alert("提示","No valid Signature Capture licence found");
			break;
        case 200: // CaptureAbort
        	Ext.Msg.alert("提示","Error - unable to parse document contents");
			break;
        default: 
        	Ext.Msg.alert("提示","Capture Error " + rc);
			break;
		}
    
	}
});
