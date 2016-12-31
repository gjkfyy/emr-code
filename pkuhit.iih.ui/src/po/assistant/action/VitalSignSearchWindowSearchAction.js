Ext.define('iih.po.assistant.action.VitalSignSearchWindowSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
		var owner = this.getOwner();//"VitalSignHelperSearchView"
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        var data = properties.getData();
        var sourceView = properties.data.sourceView; 	//VitalSignHelperView
        var view = properties.data.parentWindow;
        var block = this.getBlock('result');
    	var beginTime = block.down('xapdatefield[name=beginTime]').rawValue;
    	var endTime = block.down('xapdatefield[name=endTime]').rawValue;
         /*var owner = this.getOwner().ownerCt.ownerCt;// 从新建病历进来关闭此页面
        if (owner == null || owner == undefined) {
            this.getOwner().ownerCt.close();// 从病历属性进来关闭此页面
        } else {
            owner.close();
        }*/
        var date = {},errorText;
        var msgInfo = view.down('xapdisplayfield[name=msgInfo]');
        date.beginTime = beginTime;
        date.endTime = endTime;
        var cookie = new Ext.state.CookieProvider();  
 		Ext.state.Manager.setProvider(cookie);  
		var DoctorAndEncounterSn = IMER_GLOBAL.user.code+IMER_GLOBAL.encounterSn;
		var beginDate,endDate;
		beginDate = new Date(beginTime);
		endDate = new Date(endTime);
		cookie.set(DoctorAndEncounterSn,date);
        var chain = sourceView.getActionChain('search');
        if((endDate.getTime()-beginDate.getTime())>=0){
        	endDate.setDate(endDate.getDate()-30);
        	if((endDate.getTime()-beginDate.getTime())<0){
        		view.close();
        		if(chain) {
                	chain.execute({date:date});
                }
        	}else{
        		errorText = '时间间隔不能超过30天！';
          		msgInfo.setValue('<font color=red>' + errorText + '</font>');
          		return;
        	}
        }else{
        	errorText = '开始时间不能大于结束时间！';
      		msgInfo.setValue('<font color=red>' + errorText + '</font>');
      		return;
        }
    }/*,

    prepareOperations: function(operations) {
        var url = this.url+"?enPk=723551&acquisitionStartTime=2010-02-19 21:05:10.630&acquisitionStopTime=2020-02-19 21:05:10.630";
        alert(url);
        //this.url+'?encounterSn=838535&currentPageIndex=1&acquisitionStartTime=2012-01-01%2000:00:00&acquisitionStopTime=2040-01-01%2023:59:59&pageSize=2&xmode=debug';
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
    		mclass: null,
    		method: METHODS.METHOD_GET,
    		condition: null,
    		scope: this,
    		success: this.onSuccess,
            fail: this.onFail
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	alert("onSuccess");
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
    },
    onFail: function(operation) {
        alert("保存失败!");
    }*/
});