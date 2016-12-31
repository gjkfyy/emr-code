Ext.define("iih.mr.model.DefectNoticeModel",{
	extend: 'Ext.data.Model',
	fields:[
	    {name:"noticeTime",type:"string"},
		{name:"sender",type:"string"},
		{name:"waitVerifyCount",type:"string"},
		'defects'
	]
	/*,
	belongsTo:"Defect"
	*/
});
