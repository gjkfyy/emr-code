Ext.define('iih.mr.model.QAPatientEncounterModel',{
	extend: 'Ext.data.Model',
	fields: [
			 {name:'enPk',type:"string"},
			 {name:'canEdit',type:"string"},
			 {name:'statusCode',type:"string"},
			 {name:'qcFlag',type:"string"},
			 {name:'amrNo',type:"string"},
			 {name:'curBedCd',type:"string"},
			 {name:'paNm',type:"string"},
			 {name:'sexNm',type:"string"},
			 {name:'age',type:"string"},
	         {name:'curDeptNm',type:"string"},
	         {name:'rcvTime',type:"string"},
	         {name:'enCnt',type:"string"},
	         {name:'curMainDiNm',type:"string"},
	         {name:'fnshTime',type:"string"},
	         {name:'illStaF',type:"string"},
	         {name:'suF',type:"string"},
	         {name:'faultTotal',type:"string"},
	         {name:'faultTodoReform',type:"string"},
	         {name:'faultTodoReview',type:"string"},
	         {name:'executeEndTime',type:"string"},
	         {name:'executeDeptName',type:"string"},
	         {name:'excuteUserName',type:"string"},
	         'qapatient'
	         ]
});
