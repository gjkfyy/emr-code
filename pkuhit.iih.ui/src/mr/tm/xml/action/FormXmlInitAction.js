Ext.define('iih.mr.tm.xml.action.FormXmlInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this.showLoading();
        var operations = context.operations;
        var view = this.getBlock('result').ownerCt;
        var sourceView = context.sourceView;
        var data = {};
        data = {'xmlFile':sourceView.xmlFile};
        this.prepareOperations(operations,data);
    }, 
    prepareOperations: function(operations,data) {
        var url = this.url;
        var mclass = null; 
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method:'PUT',
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccessTree
        };
        operations.push(operation);
    },
       
    onSuccessTree: function(operation) {
        var block = this.getBlock('condition');
        var noTree = block.down('xaptree');
        var m = operation; 
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }else {
        	console.log(operation.result);
        	if(operation.result.data.children){
        		block.setData(operation.result.data.children);
        	}else{
        		block.setData(null);
        	}
        }
        var view = this.getBlock('result').ownerCt;
        var changeChain = view.getActionChain('change');
        var selChain = view.getActionChain('changeSel');
        //判断mrElementTypeName类型
        var id='',mrElementTypeName = '',mrElementNm='',dateTimeValue='',deCd,custormRange,valueType,freeeditFlag,showFormat,descriptions,precision,minValue,maxValue,normalMinValue,normalMaxValue,textlong;
        if(operation.result.data.children.length!=0){
        	noTree.getSelectionModel().select(0);
        	var record = noTree.getSelectionModel().selected.items[0].raw;
        	id = record.id;
        	mrElementTypeName = record.mrElementTypeName;
        	if(record.mrElementNm ==''){
        		mrElementNm = record.text;
        	}else{
        		mrElementNm = record.mrElementNm;
        	}
        	deCd = record.deCd;
        	showFormat = record.showFormat;
        	dateTimeValue = record.dateTimeValue;
        	custormRange = record.custormRange;
        	descriptions = record.descriptions;
        	freeeditFlag = record.freeeditFlag;
        	maxValue = record.maxValue;
        	minValue = record.minValue;
        	normalMinValue = record.normalMinValue;
        	normalMaxValue = record.normalMaxValue;
        	precision = record.precision;
        	regular = record.regular;        	
        }else{
        	mrElementTypeName = 'Text';
        };
        changeChain.execute({
			id:id,
			mrElementTypeName:mrElementTypeName,
			mrElementNm:mrElementNm,
			dateTimeValue:dateTimeValue,
			descriptions:descriptions,
			showFormat:showFormat,
			freeeditFlag:freeeditFlag,
			maxValue:maxValue,
			minValue:minValue,
			normalMinValue:normalMinValue,
			normalMaxValue:normalMaxValue,
			precision:precision,
			deCd:deCd,
			regular:regular,
			custormRange:custormRange,
			eventName:'afterrender'
		});
        selChain.execute({
        	valueType:valueType
		});
        noTree.collapseAll();
    }
});
