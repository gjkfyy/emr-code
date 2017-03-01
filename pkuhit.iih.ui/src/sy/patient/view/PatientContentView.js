Ext.define('iih.sy.patient.view.PatientContentView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			alias : 'widget.patientcontentview',
			requires : ['iih.sy.patient.view.PatientLeftListView',
					'iih.sy.patient.block.PatientRightBlock',
					'iih.sy.patient.action.PatientRightDeptDelAction',
					'iih.sy.patient.action.PatientLeftSearchAction',
					'iih.sy.patient.action.PatientRightListAction',
					'iih.sy.patient.action.PatientCreateAction',
					'iih.sy.patient.action.ToReportAction',
					'iih.sy.patient.action.HasEditConfirmAction',
					'iih.sy.patient.action.CreateOmrDocAction'],

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
			            },
			            'newDoc':{
			            	xclass: 'iih.sy.patient.action.ToReportAction',
							blocks: {
								condition: 'left',
								result: 'right'
							}
			            },
			            'hasEditConfirm': {
			                xclass: 'iih.sy.patient.action.HasEditConfirmAction',
			                url: 'omr',
			                blocks: {
			                    result: 'right'
			                }
			            },
			            'createDoc': {
			                xclass: 'iih.sy.patient.action.CreateOmrDocAction',
			                url:'param',
			                blocks:{
			                    result:'left'
			                }
			            }
					},
					chains : {
						'patientRightList': ['patientRightList'],
						'editPatient' : ['editPatient'],
						'newDoc' : ['newDoc'],
						'hasEditConfirm' : ['hasEditConfirm'],
						'createDoc' : ['createDoc']
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
								},{
					                selector: 'button[method=createDoc]',
					                event: 'click',
					                chain: 'hasEditConfirm'
					            },]
					}
				}
		});