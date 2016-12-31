Ext.define('iih.mr.kr.csm.model.CSMModel',{
extend: 'Ext.data.TreeModel',
	//idProperty:'tempSn',
	fields:[
	    {name: 'id',  type: 'string'},
		{name: 'name',  type: 'string'},
		{name: 'expand',  type: 'string'},
		{name: 'leaf',   type: 'boolean'},
		{name:'diCode',type:'string'},
		{name:'diName',type:'string'},
		{name:'diSuiteCode',type:'string'},
		{name:'diSuiteTypeCode',type:'string'},
		{name:'diSuiteTypeName',type:'string'},
		{name:'orgCode',type:'string'},
		{name:'ownerCode',type:'string'},
		{name:'ownerType',type:'string'},
		{name:'ownerCode',type:'string'},
		{name:'text',type:'string'},
		'children'

	]
	//fields:['tempSn',  'text','leaf', 'id', 'children']
})