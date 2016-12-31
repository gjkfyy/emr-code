Ext.define('iih.mr.model.TerminalQAPatientListGridModel',{
	extend: 'Ext.data.Model',
	fields: [
			 {name:'enTypeCd',type:"string"},
			 {name:'mrFstPgStateCd',type:"string"},
	         {name:'qcFlag',type:"string"},
	         {name:'rate',type:"string"},
	         {name:'grade',type:"string"},
	         {name:'defectNum',type:"string"},
	         {name:'abarbeitungNum',type:"string"},
	         {name:'verifyNum',type:"string"},
	         {name:'medicalNum',type:"string"},
	         {name:'patientNm',type:"string"},
	         {name:'sexNm',type:"string"},
	         {name:'age',type:"string"},
	         {name:'wardAreaNm',type:"string"},
	         {name:'deptNm',type:"string"},
	         {name:'inpTimes',type:"Short"},
	         {name:'inpTime',type:"Date"},
	         {name:'inDiagnose',type:"string"},
//	         {name:'fee',type:"string"},
	         {name:'doctor',type:"string"},
//	         {name:'serious',type:"string"},
//	         {name:'operationNm',type:"string"},
	         'terqapatient'
	         ]
});
