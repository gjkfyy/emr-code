Ext.define('iih.sy.patient.view.PatientCreateView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.patientcreateview', 
	
	requires:[
	   		  'Xap.ej.element.button.Button',
	   		  'iih.sy.patient.block.PatientInfoBlock',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
	          'iih.sy.patient.action.PatientEditInitAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.sy.patient.block.PatientInfoBlock'
			}
		},
		actions:{
			'init':{
				xclass: 'iih.sy.patient.action.PatientEditInitAction',
				url:'iemrPatient',
				blocks: {
				    content: 'content'
				}
			},
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
			'init' : ['init'],
			'savePatient':['savePatient'],
			'cancel':['cancel']
		},
		connections:{
			'content':[{    
			    //加载数据
	            event: 'afterrender',
	            chain: 'init'
	        },{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'savePatient'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		},
		initComponent : function() {
			this.callParent();
		}
	}
})