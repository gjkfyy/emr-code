Ext.define('iih.mr.tm.xml.action.FormXmlItemClickAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		var treeNode,data,evn,treeTem,nodeId;
        if(context.event != undefined){
        	treeNode = context.event.arguments[1];
            data = treeNode.raw;
        }else{
        	data={};
        	data.mrElementTypeName = context.mrElementTypeName;
        }
        var id = data.id;
        var mrElementTypeName = data.mrElementTypeName;
        var mrElementNm = data.mrElementNm;
        var deCd = data.deCd;
        var descriptions = data.descriptions;
        var showFormat = data.showFormat;
        var dateTimeValue = data.dateTimeValue;
        var freeeditFlag = data.freeeditFlag;
        var maxValue = data.maxValue;
        var minValue = data.minValue;
        var normalMaxValue = data.normalMaxValue;
        var normalMinValue = data.normalMinValue;
        var precision = data.precision;
        var regular = data.regular;
        var custormRange = data.custormRange;
        var operations = context.operations;
        var view = this.getBlock('result').ownerCt;
        //设置右面编辑页面
        var changeChain = view.getActionChain('change');
        changeChain.execute({
        	id:id,
        	mrElementTypeName:mrElementTypeName,
			mrElementNm:mrElementNm,
			deCd:deCd,
			descriptions:descriptions,
			showFormat:showFormat,
			dateTimeValue:dateTimeValue,
			freeeditFlag:freeeditFlag,
			maxValue:maxValue,
			minValue:minValue,
			normalMinValue:normalMinValue,
			normalMaxValue:normalMaxValue,
			precision:precision,
			regular:regular,
			custormRange:custormRange,
			eventName:context.event.name
		});
        
    }
});
