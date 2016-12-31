Ext.define('iih.mr.model.InProcessQAPatientListModel',{
	extend: 'Ext.data.Model',
	fields: [
	         {name:'rbauto',type:"string"},
	         {name:'rbaut',type:"string"},
	         {name:'serious',type:"string"},
	         {name:'operationNm',type:"string"},
	         {name:'qcFlag',type:"string"},
	         'inpatient'
	         ]
});
