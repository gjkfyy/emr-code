Ext.define('iih.mr.tm.xml.action.FormXmlChangeSelAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getOwner();
        //设置右面编辑页面
        var valueType = view.down('xapcombobox[name=valueType]');
        if(context.showFormat!=undefined){
        	valueType.setValue(context.valueType);
        }
        var custormPanel = view.down('[name=custormPanel]');
        var deCdShow = view.down('xapdisplayfield[name=deCdShow]');
        var addVaBtn = view.down('button[action=addVaBtn]');
        var delVaBtn = view.down('button[action=delVaBtn]');
        var dataResource = view.down('xaptextfield[name=dataResource]');
        if(!Ext.isEmpty(valueType.value,false)){
        	if(valueType.value=='dictionary'){
        		addVaBtn.hide(true);
        		delVaBtn.hide(true);
        		deCdShow.setValue(dataResource.value);
        		deCdShow.show(true);
        		custormPanel.show(true);
        	}else if(valueType.value=='custom'){
        		addVaBtn.show(true);
        		delVaBtn.show(true);
        		deCdShow.setValue('');
        		deCdShow.show(true);
        		custormPanel.show(true);
        	}else{
        		addVaBtn.hide(true);
        		delVaBtn.hide(true);
        		deCdShow.setValue('');
        		deCdShow.show(true);
        		custormPanel.show(true);
        	}
        }else{
        	custormPanel.hide(true);
        }
    }
});
