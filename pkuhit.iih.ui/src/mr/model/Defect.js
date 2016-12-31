Ext.define("iih.mr.model.Defect",{
	extend: 'Ext.data.Model',
	fields:[
		{name:"bugCd",type:"string"},
	//	{name:"defectNotice",type:"string"},
	//	{name:"qaItem",type:"string"},
		{name:"bugNm",type:"int"},
		{name:"mrNo",type:"string"},
	//	{name:"mrDoc",type:"string"},
		{name:"bugDesc",type:"string"},
		{name:"bugStateNm",type:"string"},
		{name:"bugState",type:"string"},
		{name:"qaLevel",type:"string"},
		{name:"qaType",type:"string"},
		{name:"senderCd",type:"string"},
		{name:"sendedDeptCd",type:"string"},
		{name:"sendedTime",type:"date"},
		{name:"deadline",type:"date"},
		{name:"defectFlag",type:"string"},
		{name:"defectRequire",type:"string"},
		{name:"defecterCd",type:"s  tring"},
		{name:"defectStartTime",type:"date"},
		{name:"defectFinishTime",type:"date"},
		{name:"defectState",type:"string"},
		{name:"defectDeclare",type:"string"},
		{name:"checkerCd",type:"string"},
		{name:"checkTime",type:"date"},
		{name:"pointsFlag",type:"string"},
		{name:"checkState",type:"string"},
		{name:"pointsDeclare",type:"string"},
		'processTask'
	]
	/*,
	hasMany:[
		 {model:"DefectNotice",name:"defectNotice"},   //整改通知对象
		 {model:"QAItem",name:"qaItem"},				//质控项对象
		 {model:"mrDoc",name:"mrDoc"}				//病历文书对象---无
	]
	*/
});
