Ext.define('iih.sy.patient.view.PatientContentView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			alias : 'widget.patientcontentview',
			requires : ['iih.sy.patient.view.PatientLeftListView',
					'iih.sy.patient.block.PatientRightBlock',
					'iih.sy.patient.action.PatientRightDeptDelAction',
					'iih.sy.patient.action.PatientLeftSearchAction',
					'iih.sy.patient.action.PatientRightListAction',
					'iih.sy.patient.action.PatientCreateAction'],

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.sy.patient.view.PatientLeftListView',
						width : 350,
						region:'west',
						split: true,
		                collapsible: true,
		                header:false
					},
					'right' : {
						xclass : 'iih.sy.patient.block.PatientRightBlock',
						flex : 1
					}
				},

					actions : {
						'patientRightList': {
							xclass: 'iih.sy.patient.action.PatientRightListAction',
							url: 'iemrPatient',
							blocks: {
								condition: 'left',
								result: 'right'
							}
						},
						'editPatient': {
			                xclass: 'iih.sy.patient.action.PatientEditWinAction',
			                url:'patient',
			                blocks:{
			                    result:'right'
			                }
			            }
					},
					chains : {
						'patientRightList': ['patientRightList'],
						'editPatient' : ['editPatient']
					},

					connections : {
						'left'	:[{
									selector: 'xapgrid',
									event: 'itemclick',
									chain: 'patientRightList'
								}],
						'right' : [{
									event: 'afterrender',
									chain: 'init'
								},{
									selector: 'button[action=editPatient]',
									event: 'click',
									chain: 'editPatient'
								}]
					}
				}
		});