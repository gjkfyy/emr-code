Ext.define('iih.sy.patient.view.PatientCreateView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.patientcreateview', 
	
	requires:[
	   		  'Xap.ej.element.button.Button',
	   		  'iih.sy.patient.block.PatientInfoBlock',
	          'iih.sy.pwd.action.SaveNewPwdAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.sy.patient.block.PatientInfoBlock'
			}
		},
		actions:{
			'savePatient':{
				xclass: 'iih.sy.patient.action.PatientSaveAction',
				url:'patient',
				blocks: {
				    content: 'content'
				}
			},
			'cancel':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'savePatient':['savePatient'],
			'cancel':['cancel']
		},
		connections:{
			'content':[{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'savePatient'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		}
	}
})