Ext.define('iih.mrb.action.SearchDeptListAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
    * @Override
    */
    execute: function(context) {
        this.prepareOperations(context.operations);
    },
    prepareOperations: function(operations) {
    	
        var block = this.getOwner().getBlock('condition');
        console.log('block') ;
        console.log(block) ;
        var enTypeCode=block.down('[name=enTypeCode]').getValue();
        console.log('enTypeCode') ;
        console.log(enTypeCode) ;
        var condition = {} ;
        if(enTypeCode != 'ALL'){
        	condition={"deptTpCd":enTypeCode};
        }
        console.log('condition') ;
        console.log(condition) ;
        var comboxgridCurDeptNm=block.down('[name=curDeptNm]');
        
        console.log('comboxgridCurDeptNm') ;
        console.log(comboxgridCurDeptNm) ;
        comboxgridCurDeptNm.searchParam =  condition ;
        var condition= {} ;
        
/*      
        var url = this.url;
        var operation = {
                url: url,
                method: 'get',
                params: condition,
                scope: this,
                success: this.onSuccess
                // fail: this.onFail
            };
        operations.push(operation);*/
    },
    onSuccess: function(operation) {
        var block = this.getOwner().getBlock('condition');
        var deptCodeList=block.down('[name=deptCodeList]');
        deptCodeList.select(null);
        if(operation.result){
        	console.log('operation.result.dataList');
        	console.log(operation.result.dataList);
        	deptCodeList.setData(operation.result.dataList);
/*            var properties = this.getOwner().ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
            var selectdata = properties.data.deptCodeSelect;
            if(selectdata){
            	deptCodeList.select(selectdata);
                properties.data.mrTpCd = null;
            }else{
            	deptCodeList.select('ALL');
            };*/
            //var result = this.getOwner();
            //var initChain = result.getActionChain('init');
            //initChain.execute();
            //if(mrCustClaCd!='ALL')mrTypeCd.expand();
        }
    }
});