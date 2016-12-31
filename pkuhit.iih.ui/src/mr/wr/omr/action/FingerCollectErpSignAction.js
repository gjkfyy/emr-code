Ext.define('iih.mr.wr.omr.action.FingerCollectErpSignAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
		var wFingerImg = 50;		// 指纹采集图像的宽（目前该设备是256，插入到PDF做50%缩小，可设置），在右下角
		var hFingerImg = 75;		// 指纹采集图像的高（目前该设备是304，插入到PDF做50%缩小，可设置）
		var demoFingerBmp = 'C:\\finger.bmp';
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
		
		// 参数可设置
		//var left = FoxitPDFSDK.GetPageWidth(0) - wFingerImg;
		var top = 0;
		var left = 160; //fingerLeft; // FoxitPDFSDK.GetPageWidth(0) - 100;
		var bottom = fingerBottom; //FoxitPDFSDK.GetPageHeight(0) - 304;
		var lastPageIndex = FoxitPDFSDK.PageCount - 1; // 最后一页
		var addimageRet = FoxitPDFSDK.AddImageObject(lastPageIndex, left, bottom, wFingerImg, hFingerImg, demoFingerBmp, 100, 0);
	}
});
