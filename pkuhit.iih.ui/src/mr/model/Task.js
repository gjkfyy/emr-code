Ext.define("iih.mr.model.Task",{
	extend: 'Ext.data.Model',
	fields:[
		{name:"worktype",type:"string"},
		{name:"workdescription",type:"string"},
		{name:"cutofftime",type:"date"},
		{name:"remainingtime",type:"string"},
		{name:"sourcedepartment",type:"string"}
	]
	/*,
	belongsTo:"Defect"
	*/
});
