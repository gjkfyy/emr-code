Ext.define('iih.mr.qa.order_qa_work.action.OrderListInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.showLoading();
		console.log('-------OrderListInitAction-------------------');
		this.callParent();
        var operations = context.operations;
        //获取患者页面的选中患者记录
    	var owner = this.getOwner(); 
    	var encounterPk;
    	if(owner.tabId == 'orderRfmdefectview'){
    		var record = owner.record;
    		encounterPk = record.data.enPk;
    	}else {
    		var patientRecord = owner.ownerCt.ownerCt.patientRecord;
    		encounterPk = patientRecord.pk;//encounterPk;
    	}
	    
    	//就诊序号
        var data = {},longOrF = '',enTypeCode=IMER_CONSTANT.INPATIENT;
        var block = this.getOwner().getBlock('top');
        var longterm = block.down('[name=longterm]').items.items[0];
	    var temporary = block.down('[name=temporary]').items.items[0];
	    //判断是否选择了医嘱类型
	    if(longterm.checked && temporary.checked){	    	
	    }else if(longterm.checked && !temporary.checked){
	    	longOrF = '1';
	    }else if(!longterm.checked && temporary.checked){
	    	longOrF = '0';
	    }
	    //判断就诊类型门诊和住院
	    if(IMER_GLOBAL.portal.code==IMER_CONSTANT.PORTAL_OUTP){//门诊
	    	enTypeCode = IMER_CONSTANT.OUTPATIENT;
	    }else if(IMER_GLOBAL.portal.code==IMER_CONSTANT.PORTAL_INP){//住院
	    	enTypeCode = IMER_CONSTANT.INPATIENT;
	    }
	    var enSn = encounterPk;//context.enPk||IMER_GLOBAL.encounterSn;//'838535';
	    data.enSn = enSn;
	    data.longOrF = longOrF;
	    data.enTypeCode = enTypeCode;
        this.prepareOperations(operations,data);
    },
    prepareOperations : function(operations,data) {
    	var enSn = data.enSn;//'838535';
    	console.log('ensn = '+enSn);
    	//enSn = '239712';
    	var condition = '?enPk='+enSn+'&longOrF='+data.longOrF+ '&enTypeCode='+data.enTypeCode+ '&currentPageIndex=1&pageSize=1000';   
        var url = this.url + condition;   
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	 
    },
    
	onSuccess : function(operation) {
		//alert("success");
        var block = this.getBlock('orderlist');
        /*var bar = block.down('toolbar');
      //判断就诊类型门诊和住院
	    if(IMER_GLOBAL.portal.code==IMER_CONSTANT.PORTAL_OUTP){//门诊
	    	bar.hide();
	    }else if(IMER_GLOBAL.portal.code==IMER_CONSTANT.PORTAL_INP){//住院
	    	bar.show();
	    }*/
        var m = operation.result.dataList;
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//console.log(m);
				block.setData(m);
			}
		}
    }
});
