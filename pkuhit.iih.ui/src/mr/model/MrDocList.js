Ext.define("iih.mr.model.MrDocList",{
	extend: 'Ext.data.Model',
	fields:[
		{name:"docstatus",type:"string"},
		{name:"docname",type:"string"},
		{name:"draftsman",type:"string"},
		{name:"businesstime",type:"date"},
		{name:"lastupdatedpeople",type:"string"},
		{name:"lastupdatedtime",type:"string"}
	]
	/*,
	belongsTo:"Defect"
	*/
});
