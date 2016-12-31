Ext.define('Xap.ej.model.ProcessTask', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'processId',
		type : 'string'
	}, {
		name : 'name',
		type:'string'
	}, {
		name : 'method',
		type:'string'
	}],

	
	hasMany : {
		model : 'Xap.ej.model.ProcessTask',
		name : 'followings'
	}
});