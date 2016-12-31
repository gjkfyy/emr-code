Ext.define('Xap.ej.model.ProcessTaskModel', {
	extend : 'Xap.ej.model.BaseModel',
	fields : [ {
		name : 'processId',
		type : 'string'
	}, {
		name : 'executingTask'
	} ],
	hasMany : {
		model : 'ExecutingTaskModel',
		name : 'executingTask'
	}
});
Ext.define('Xap.ej.model.ExecutingTaskModel', {
	extend : 'Xap.ej.model.BaseModel',
	fields : [ {
		name : 'id',
		type : 'string'
	}, {
		name : 'name',
		type:'string'
	}, {
		name : 'method',
		type:'string'
	} ]
});