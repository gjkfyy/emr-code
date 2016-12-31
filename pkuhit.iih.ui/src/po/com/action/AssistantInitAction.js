Ext.define('iih.po.com.action.AssistantInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        
        if(!IMER_GLOBAL.patientId)
            return;
        var operations = context.operations;
        var url = this.url||'mr/ens';
        var mclass = null;
        var condition = {
            patientId: IMER_GLOBAL.patientId,
            workScreen: '2'
        };
        var qs = Ext.Object.toQueryString(condition);
        url += '?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: condition,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var m = operation.result;
		if(m){
		    var block = this.getBlock('helpContent');
		    if(block){
		        block.setEncouterData(m.dataList);
		       /* view.encounterComboxValue = m.dataList;//根据下拉框是门诊还是住院显示历次就诊
		        var hospitalAreaCode = IMER_GLOBAL.hospitalArea.code;
	            var otherOmr = block.down('button[itemId=otherOmr]');
	            if(hospitalAreaCode =='SZLH'){//调用其它病历按钮是否显示PKUHIT为六院院区编码
	                otherOmr.show();
	            }else{
	                otherOmr.hide();
	            }*/
		    }else{
		        this.setEncouterData(m.dataList);
		    }
		    var view = this.getOwner();
		    if(view != undefined){
		    	var chain = view.getActionChain('ifShowBtn');
	            chain.execute();
		    }
		}
    },
    
    setEncouterData: function(data){
        var combo = this.combo;
        if(combo){
            combo.clearValue();
            if(data){
                var array = new Array();
                Ext.each(data,function(rec){
                    if(rec){
                        var time = Ext.Date.parse(rec.currentDeptIntoTime, 'time');
                        var value = Ext.Date.format(time, 'Y-m-d H:i');
                        //var value = Ext.util.Format.date(rec.currentDeptIntoTime, "Y-m-d H:i:s");
                        value = value + '_';
                        value = value + rec.encounterTypeName;
                        if(rec.currentMainDiagnosisName){
                            value = value + '_';
                            value = value + rec.currentMainDiagnosisName;
                        }
                        value =value +'('+rec.mrTotal+')';
                        array.push({'text':value,'value':rec.pk});
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