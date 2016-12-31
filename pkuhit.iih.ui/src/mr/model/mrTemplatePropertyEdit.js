Ext.define("iih.mr.model.BasicTemplate",{
	extend: 'Ext.data.Model',
	fields:[
		{name:"mrDocTypeCd",type:"string"},
		{name:"baseTemplateCd",type:"string"},
		{name:"mrTemplateNm",type:"string"},
        {name:"ownerTypeCd",type:"string"},
        {name:"diagnosisCd",type:"string"},
        {name:"ownerCd",type:"string"},
        {name:"mrReviewLvlCd",type:"string"},
		'processTask'
	]
});
