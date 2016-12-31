Ext.define("iih.mr.model.DefectInputModel",{
	extend: 'Ext.data.Model',
	fields:[
		{name:"defectDescription",type:"string"},
		{name:"deductionStandard",type:"string"},
		{name:"needDefect",type:"string"},
		{name:"rectificatRequire",type:"string"},
		{name:"paragraph",type:"string"}
	]
});