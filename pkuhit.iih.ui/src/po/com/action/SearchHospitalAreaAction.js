Ext.define('iih.po.com.action.SearchHospitalAreaAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.element.field.ComboBox'],
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    var operations = context.operations;
	    var url = this.url;
        var mclass = null;
        var condition = {
            userId: IMER_GLOBAL.user.code,
            orgTpCd: IMER_CONSTANT.ORG_TYPE_CD_2
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
	onSuccess : function(operation) {
		var view = this.getOwner();
		var combo = view.down('xapcombobox[name=hosArea]');
		combo.clearValue();
		var data = operation.result;
		if(data){
		    var array = new Array();
		    Ext.each(data,function(rec){
		        if(rec)
		            array.push({'text':rec.name,'value':rec.code});
		    });
		    combo.setData(array);
		    var record = combo.getStore().getAt(0);
		    combo.select(record);
		}else{
            combo.clearValue();
        }
	}
});
