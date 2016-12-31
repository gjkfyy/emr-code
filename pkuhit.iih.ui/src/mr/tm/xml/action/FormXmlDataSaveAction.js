Ext.define('iih.mr.tm.xml.action.FormXmlDataSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getOwner();
        var tree = view.down('xaptree');
        var block = view.down('formxmleditblock');
        var rootnodes = tree.getRootNode().childNodes;
        var grid,id='',mrElementTypeName='',mrElementNm='',showFormat='',dateTimeValue='',minValue='',maxValue='',normalMinValue='',normalMaxValue='',precision='',deCd='',custormRange=[],name='',value='',thumbnail='';
        var values = block.getForm().getValues();
        var store = tree.getStore();
        var condition = this.getBlock('condition');
        var treeNode = condition.down('xaptree').getSelectionModel().getSelection();
        id = treeNode[0].data.id;
//        id = values.id;
        mrElementTypeName = values.mrElementTypeName;
        mrElementNm = values.mrElementNm;
        deCd = values.deCd;
        if(mrElementTypeName==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME1){
        	showFormat = values.showFormat;
        	dateTimeValue = values.dateTimeValue;
        }else if(mrElementTypeName==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME2){
        	precision = values.precision;
        	minValue = values.minValue;
        	maxValue = values.maxValue;
        	normalMinValue = values.normalMinValue;
        	normalMaxValue = values.normalMaxValue;
        }else if(mrElementTypeName==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME3){
        }else if(mrElementTypeName==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME4 || mrElementTypeName==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME5){
        	grid = block.down('xapgrid[name=custormRange]');
        	var gridData = grid.getStore().data.items;
        	if(gridData.length>0){
        		for(var i=0;i<gridData.length;i++){
        			name = gridData[i].get('name');
        			value = gridData[i].get('value');
        			thumbnail = gridData[i].get('thumbnail');
        			custormRange[i] = {'name':name,'value':value,'thumbnail':thumbnail};
        		}
        	}
        }
        var record = tree.getStore().getNodeById(id);
        record.raw.mrElementTypeName = mrElementTypeName;
        record.raw.mrElementNm = mrElementNm;
        record.raw.deCd = deCd;
        record.raw.showFormat = showFormat;
        record.raw.dateTimeValue = dateTimeValue;
        record.raw.precision = precision;
        record.raw.minValue = minValue;
        record.raw.maxValue = maxValue;
        record.raw.normalMinValue = normalMinValue;
        record.raw.normalMaxValue = normalMaxValue;
        record.raw.custormRange = custormRange;
        store.sync();
        console.log(tree);
    }
});
