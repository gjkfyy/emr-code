Ext.define('iih.po.com.action.PatientTreeInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
    	var operations = context.operations;
    	var url = this.url;
    	var mclass = null;
    	var enTpCd;
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1)
    	    enTpCd = IMER_CONSTANT.OUTPATIENT;
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2)
    	    enTpCd = IMER_CONSTANT.INPATIENT;
    	var condition = {
    	   workScreen: '1',
    	   userId: IMER_GLOBAL.user.code,
    	   deptCd: IMER_GLOBAL.department.code,
    	   enTpCd: enTpCd     
    	};
    	var form = this.getBlock('search');
    	condition = Ext.apply(condition,form.getData());
    	var qs = Ext.Object.toQueryString(condition);
    	url += '?' + qs;
    	console.log(url);
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
        var block = this.getBlock('list');
        var m = operation.result;
		if(m){
		    //console.log(m.dataList);
			block.setData(m.dataList);
			var view = this.getOwner();
            var list = view.down('dataview');
            var store = list.getStore();
            var btn = view.down('splitbutton[name=sort]');
            var menu = btn.down('menu');
            var sort;
            Ext.each(menu.items.items,function(item){
                if(item.checked)
                    sort=item.name;
            });
            store.sort(sort,'ASC');
		}
    }
});