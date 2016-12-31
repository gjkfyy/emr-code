Ext.define('iih.po.com.action.SelectPortalChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('----------------SelectPortalChangeAction-------------------');
		var selectBlock = this.getBlock('selectportals');
		var newValue = context.event.arguments[0].value
		var operations = context.operations;
		this.prepareOperations(operations,newValue);
    	this.callParent();
    },
    prepareOperations : function(operations,newValue) {
    	var condition = '?newValue='+newValue;
		var url = this.url+condition;
		var METHODS = this.getInvocationMethods();
		var operation = {
			url : url,
			mclass : null,
			method : METHODS.METHOD_GET,
			condition : null,
			data : null,
			scope : this,
			success : this.onSuccess,
			fail: this.onFail
		};
		operations.push(operation);
	},
	onSuccess : function(operation) {
		var block = this.getBlock('selectportals');
		var com = block.down('[name=dept]');
		var m = operation.result;
		console.log('-------------SelectPortalInit------------------')
		var data,portals,deptCd;
		var select = block.down('container[name=selectButtons]');
		if(!Ext.isEmpty(m, false)){
			data = m.data;
			deptCd = m.deptCd;
			if(data) {
				com.setData(eval(data));
				com.setValue(deptCd);
			}
			//根据条件查询portal页面
			portals = m.portals;
			//console.log(portals);
			select.removeAll(true);
			var login = this.getOwner();
			var app = login.ownerCt;
			var layout = app.getLayout();
			var portal = app.down('selectportal');
			var chainSelect = portal.getActionChain('selectportals');
			var chainBack = portal.getActionChain('back');
			if(!Ext.isEmpty(portals, false)){
				for(var i=0;i<portals.length;i++){
					var item = Ext.create('Ext.button.Button',{cls: portals[i].shortNmEn,
											tooltip:portals[i].nm,
											height: 100,
											width: 100,
											margin: '0 0 0 10',
											action: portals[i].poCd,
											handler:function(btn,e){
												chainSelect.execute(btn);
											}});
					//console.log(portals[i].nm);
					select.add(item);
				}
			}
		}
	},
	onFail : function(operation) {
		var block = this.getBlock('selectportals');
		var showInfo = block.down('xapdisplayfield');
		showInfo.setValue('<font color=red>系统故障!</font>');
	}
});
