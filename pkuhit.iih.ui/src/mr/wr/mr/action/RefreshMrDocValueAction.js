Ext.define('iih.mr.wr.mr.action.RefreshMrDocValueAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var plugin = document.getElementById('iemrEditor');
        //获取文档中所有引用目标元素的id
        var elemIds=plugin.GetReferenceElem();
        elemIds=elemIds.replace(new RegExp(/(\n)/g),",");
        if(elemIds.length>0){
        	this.prepareOperations(operations,elemIds);
        }else{
        	var count=this.getOwner().count;
            console.log(count);
            if(count&&count==3){
            	console.log('----------plugin.EnableOCX(true);---------'+count);
            	plugin.EnableOCX(true);
            }else{
            	this.getOwner().count=count+1;
            }
        }
    },
    
    prepareOperations: function(operations,elemIds) {
//    	var medicalRecord=this.getOwner().medicalRecord;
    	
        var url=this.url+'/'+elemIds+'?enPk='+IMER_GLOBAL.encounterSn;
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
//        console.log(operation);
        if(null!=operation.result.dataList&&operation.result.dataList.length>0){
        	this.importReferenceElem(plugin,operation.result.dataList);
        }
        var count=this.getOwner().count;
        console.log(count);
        if(count&&count==3){
        	console.log('----------plugin.EnableOCX(true);---------'+count);
        	plugin.EnableOCX(true);
        }else{
        	this.getOwner().count=count+1;
        }
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取引用元素元素值失败!');
    },
    importReferenceElem:function(plugin,elemValues){
    	if (elemValues != null && elemValues.length > 0) {
            for ( var i = 0; i < elemValues.length; i++) {
            	var dataElementId=elemValues[i].dataElementId;
            	var value=elemValues[i].value;
            	//循环遍历引用元素值并刷新文档中的引用目标元素
                plugin.ImportReferenceElem(dataElementId, value);
            }
        }
    }
});
