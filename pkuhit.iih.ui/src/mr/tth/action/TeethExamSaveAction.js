Ext.define('iih.mr.tth.action.TeethExamSaveAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
    doExecute: function(context) {
    	this.callParent();
    	this.showLoading('处理中...');
    	if(!IMER_GLOBAL.encounterSn){
    	    XapMessageBox.info('请选择患者!');
    	    return;
    	};
    	var block = this.getBlock('content');
    	var encounterSn = context.encounterSn;
    	var data = block.getData(encounterSn);
    	/*var view = this.getOwner();
    	var datasArr = [];
    	var tl = view.down('teethtopleftblock');
    	var tlData = tl.getData();
    	datasArr.push(tlData);
    	var tr = view.down('teethtoprightblock');
    	var trData = tr.getData();
    	datasArr.push(trData);
    	var bl = view.down('teethbottomleftblock');
    	var blData = bl.getData();
    	datasArr.push(blData);
        var br = view.down('teethbottomrightblock');
        var brData = br.getData();
        datasArr.push(brData);
    	var content = view.down('teethcontentblock');
    	var enPk = content.down('xaptextfield[name=enPk]');
        enPk.setValue(IMER_GLOBAL.encounterSn);
        var examDoctorCd = content.down('xaptextfield[name=examDoctorCd]');
        examDoctorCd.setValue(IMER_GLOBAL.user.code);
    	var data = content.getData();
    	Ext.apply(data,{
    	    'TeethExamItemArray': datasArr
    	});
    	var bleeding = view.query('xaptextfield[value=●]');
    	var bTexts = view.query('xaptextfield[bText=true]');
    	var valueCount = 0;
    	Ext.Array.each(bTexts, function(text){
    	    if(text.getValue())
    	        valueCount++;
    	});
    	var lTexts = view.query('xaptextfield[lText=true]');
    	var lValue = 0;
        Ext.Array.each(lTexts, function(text){
            if(text.getValue())
                valueCount++;
        });
    	Ext.apply(data,{
            'bleeding': bleeding.length,
            'blValueCount': valueCount
        });*/
    	var operations = context.operations;
        if(!operations) {
            return;
        }
        this.prepareOperations(operations,data);
    },
    
    prepareOperations: function(operations,data) {
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            //condition: data,    
            data:data,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.length = 0;
        operations.push(operation);
    },
    
    onSuccess: function(operation){
        //var block = this.getBlock('content');
        //block.setData(operation.result);
        XapMessageBox.info('保存成功!');
        var view = this.getOwner();
        var chain = view.getActionChain('init');
        chain.execute();
    },
    
    onFail: function(operation){
        this.hideLoading();
    }
});