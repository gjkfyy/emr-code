Ext.define("iih.mr.model.BasicTemplate",{
	extend: 'Ext.data.Model',
	fields:[
		{name:"baseTemplateStatusCd",type:"string"},
		{name:"baseTemplateNm",type:"string"},
		{name:"pageTypeCd",type:"string"},
        {name:"ownerMedicalInstituteCd",type:"string"},
        {name:"createBy",type:"string"},
        {name:"createTime",type:"string"},
        {name:"applyFlag",type:"string"},
		'processTask'
	]
});
