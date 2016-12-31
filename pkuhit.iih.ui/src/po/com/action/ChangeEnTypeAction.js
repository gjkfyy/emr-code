Ext.define('iih.po.com.action.ChangeEnTypeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var owner = this.getOwner();
        var block = owner.getBlock('helpContent');
        var enType = block.down('xapcombobox[name=enType]');
        var combo = block.down('xapcombobox[itemId=encounterCombox]');
        var enTpCd = enType.value;
        var data = owner.encounterComboxValue;
        
        if(combo){
            combo.clearValue();
            if(data){
                var array = new Array();
                Ext.each(data,function(rec){
                    if(rec){
                    	if(enTpCd == rec.encounterTypeCode){
                    		var time = Ext.Date.parse(rec.currentDeptIntoTime, 'time');
                            var value = Ext.Date.format(time, 'Y-m-d H:i');
                            //var value = Ext.util.Format.date(rec.currentDeptIntoTime, "Y-m-d H:i:s");
                            value = value + '_';
                            
                            value = value + rec.encounterTypeName;
                            
                            if(rec.currentMainDiagnosisName){
                                value = value + '_';
                                value = value + rec.currentMainDiagnosisName;
                            }
                            array.push({'text':value,'value':rec.pk});
                    	} 
                    }
                });
                combo.setData(array);
                var record = combo.getStore().getAt(0);
                combo.select(record);
                //combo.setValue(IMER_GLOBAL.encounterSn);
            }
        }
    
        
    }
});