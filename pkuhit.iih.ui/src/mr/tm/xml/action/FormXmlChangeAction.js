Ext.define('iih.mr.tm.xml.action.FormXmlChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getOwner();
        var eventName= context.eventName;
        var condition = this.getBlock('condition');
    	var treeNode = condition.down('xaptree').getSelectionModel().getSelection();
    	var text = treeNode[0].data.text;
        //设置右面编辑页面
        var id = view.down('xaptextfield[name=id]');
        var mrElementTypeName = view.down('xapcombobox[name=mrElementTypeName]');
        var mrElementNm = view.down('xaptextfield[name=mrElementNm]');
        var dataResource = view.down('xaptextfield[name=dataResource]');
        var search = view.down('button[name=search]');
        var showFormat = view.down('xapcombobox[name=showFormat]');
        var formatInfo = view.down('xapdisplayfield[name=formatInfo]');
        formatInfo.setValue('YYYY年 MM月 DD日  hh时 mm分');
        var dateTimeValueShow = view.down('xapdisplayfield[name=dateTimeValueShow]');
        var precision = view.down('xapcombobox[name=precision]');
        var minValue = view.down('xaptextfield[name=minValue]');
        var maxValue = view.down('xaptextfield[name=maxValue]');
        var normalMinValue = view.down('xaptextfield[name=normalMinValue]');
        var normalMaxValue = view.down('xaptextfield[name=normalMaxValue]');
//        var textlong = view.down('xapnumberfield[name=textLong]');
//        var textUnit = view.down('xapdisplayfield[name=textUnit]');
        var deCdShow = view.down('xapdisplayfield[name=deCdShow]');
        var valueType = view.down('xapcombobox[name=valueType]');
        var custormPanel = view.down('[name=custormPanel]');
        var descriptions = view.down('xaptextfield[name=descriptions]');
        var deCd = view.down('xaptextfield[name=deCd]');
        var dateTimeValue = view.down('xaptextfield[name=dateTimeValue]');
        var grid = custormPanel.down('xapgrid[name=custormRange]');
        var store = grid.getStore();
        var vType;
        if(context.mrElementTypeName!=undefined){
        	id.setValue(context.id);
        	if(!Ext.isEmpty(context.mrElementNm,false)){
        		mrElementNm.setValue(context.mrElementNm);
        	}else{
        		mrElementNm.setValue(context.descriptions);
        	}
        	showFormat.setValue(context.showFormat);
        	dateTimeValueShow.setValue(context.dateTimeValue);
        	dateTimeValue.setValue(context.dateTimeValue);
        	precision.setValue(context.precision);
        	deCdShow.setValue(context.deCd);
        	deCd.setValue(context.deCd);
        	minValue.setValue(context.minValue);
        	maxValue.setValue(context.maxValue);
        	normalMinValue.setValue(context.normalMinValue);
        	normalMaxValue.setValue(context.normalMaxValue);
        	dataResource.setValue(context.deCd);
        	descriptions.setValue(context.descriptions);
        	var listRange = context.custormRange;
        	var data={};
        	
        	if(!Ext.isEmpty(listRange,false)){
        		if(!Ext.isEmpty(deCd.value,false)){
        			vType = 'dictionary';
        		}else{
        			vType = 'custom';
        		}
        		valueType.setValue(vType);
        		if(listRange.length>0){
        			store.removeAll();
        			for(var i=0;i<listRange.length;i++){
        				data.name=listRange[i].name;
                        data.value=listRange[i].value;
                        data.thumbnail=listRange[i].thumbnail;
                        store.add(data);
        			}
        		}
        		var selChain = view.getActionChain('changeSel');
        		selChain.execute({
                	valueType:valueType.value
        		});
        	}else{
        		if(store.data.length>0){
        			store.removeAll();
        		}
        	}
        	mrElementTypeName.setValue(context.mrElementTypeName);
        }else{
        	if(mrElementNm.value ==''){
        		mrElementNm.setValue(text);
        	}        	
        	if(eventName=='itemclick'){
        		mrElementTypeName.setValue('Text');
        		dataResource.setValue('');
        	}
        }
        mrETN = mrElementTypeName.value;
//		dataResource.show(true);
//		search.show(true);
        if(!Ext.isEmpty(mrETN,false)){
        	if(mrETN==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME1){//时间
        		showFormat.show(true);
        		formatInfo.show(true);
        		dateTimeValueShow.show(true);
        		precision.hide(true);
        		minValue.hide(true);
        		maxValue.hide(true);
        		normalMinValue.hide(true);
        		normalMaxValue.hide(true);
//        		textlong.hide(true);
//        		textUnit.hide(true);
        		deCdShow.hide(true);
        		valueType.hide(true);
        		custormPanel.hide(true);
        	}else if(mrETN==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME2){//数字
        		showFormat.hide(true);
        		formatInfo.hide(true);
        		dateTimeValueShow.hide(true);
        		precision.show(true);
        		minValue.show(true);
        		maxValue.show(true);
        		normalMinValue.show(true);
        		normalMaxValue.show(true);
//        		textlong.hide(true);
//        		textUnit.hide(true);
        		deCdShow.hide(true);
        		valueType.hide(true);
        		custormPanel.hide(true);
        	}else if(mrETN==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME3){//文本
        		showFormat.hide(true);
        		formatInfo.hide(true);
        		dateTimeValueShow.hide(true);
        		precision.hide(true);
        		minValue.hide(true);
        		maxValue.hide(true);
        		normalMinValue.hide(true);
        		normalMaxValue.hide(true);
//        		textlong.show(true);
//        		textUnit.show(true);
        		deCdShow.hide(true);
        		valueType.hide(true);
        		custormPanel.hide(true);
        	}else if(mrETN==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME4 || mrETN==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME5){//多选
        		showFormat.hide(true);
        		formatInfo.hide(true);
        		dateTimeValueShow.hide(true);
        		precision.hide(true);
        		minValue.hide(true);
        		maxValue.hide(true);
        		normalMinValue.hide(true);
        		normalMaxValue.hide(true);
//        		textlong.hide(true);
//        		textUnit.hide(true);
        		deCdShow.show(true);
        		valueType.show(true);
        		custormPanel.show(true);
        	}else if(mrETN==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME6){//签名
        		showFormat.hide(true);
        		formatInfo.hide(true);
//        		dataResource.hide(true);
//        		search.hide(true);
        		dateTimeValueShow.hide(true);
        		precision.hide(true);
        		minValue.hide(true);
        		maxValue.hide(true);
        		normalMinValue.hide(true);
        		normalMaxValue.hide(true);
//        		textlong.show(true);
//        		textUnit.show(true);
        		deCdShow.hide(true);
        		valueType.hide(true);
        		custormPanel.hide(true);
        	}
        }else{
        	mrElementTypeName.setValue('Text');
        	showFormat.hide(true);
    		formatInfo.hide(true);
    		dateTimeValueShow.hide(true);
    		precision.hide(true);
    		minValue.hide(true);
    		maxValue.hide(true);
    		normalMinValue.hide(true);
    		normalMaxValue.hide(true);
//    		textlong.show(true);
//    		textUnit.show(true);
    		deCdShow.hide(true);
    		valueType.hide(true);
    		custormPanel.hide(true);
        }
    }
});
