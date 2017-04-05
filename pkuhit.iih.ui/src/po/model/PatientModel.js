Ext.define("iih.po.model.PatientModel",{
	extend: 'Ext.data.Model',
	alias:'widget.patientmodel',
	fields: ['pk',
	         'inpatientNo',
	         'encounterTypeCode',
	         'encounterStatusCode',
	         'patientId',
	         'patientName',
	         'currentBedCode',
	         'sex',
	         'sexValue',
	         'age',
	         'tel',
             'currentManageDoctorId',
             'currentManageDoctorName',
             'currentMainDiagnosisName',
             'encounterCount',
             'statusName',
             'paInsurCd',
             'paInsurNm',
             {
                name:'admissionDate',
                convert: function(v, record) {
                    if(v){
                        var time = Ext.Date.parse(v, 'time');
                        return Ext.Date.format(time, 'Y-m-d');
                        //var time = Ext.util.Format.date(v, "Y-m-d H:i:s");
                        //return time;
                    }
                    return '';
                }
            },{
                name:'receiveTime',
                convert: function(v, record) {
                    if(v){
                        var time = Ext.Date.parse(v, 'time');
                        return Ext.Date.format(time, 'Y-m-d H:i');
                        //var time = Ext.util.Format.date(v, "Y-m-d H:i:s");
                        //return time;
                    }
                    return '';
                }
            }]
});
