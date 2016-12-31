Ext.define('iih.mr.wr.omr.view.CreateErpSignView', {
	extend : 'Xap.ej.template.BaseTemplate',

	alias : 'widget.createerpsignview',
	id : 'createerpsignview',
	xapConfig : {
		blocks : {
			'content' : {
				xclass : 'iih.mr.wr.omr.block.CreateErpSignBlock',
				height : 600
			}
		},
		actions : {
			'init' : {
				xclass : 'iih.mr.wr.omr.action.BtnStaErpSignAction',
				blocks : {
					content : 'content'
				}
			},
			'doctorErpSign':{
				xclass : 'iih.mr.wr.omr.action.DoctorErpSignAction',
				blocks : {
					content : 'content'
				}
			},
			'erpSiqnSave':{
				xclass : 'iih.mr.wr.omr.action.ErpSignSaveAction',
				url:'omr/cafile',
				blocks : {
					content : 'content'
				}
			},
			'confirmErpSign':{
				xclass : 'iih.mr.wr.omr.action.ConfirmErpSignAction',
				blocks : {
					content : 'content'
				}
			},
			'patientErpSign':{
				xclass : 'iih.mr.wr.omr.action.PatientErpSignAction',
				blocks : {
					content : 'content'
				}
			},
			'fingerCollectErpSign':{
				xclass : 'iih.mr.wr.omr.action.FingerCollectErpSignAction',
				blocks : {
					content : 'content'
				}
			},
			'timestampErpSign':{
				xclass : 'iih.mr.wr.omr.action.TimestampErpSignErpSignAction',
				blocks : {
					content : 'content'
				}
			}
		},
		chains : {
			'init' : [ 'init' ],
			'doctorErpSign':['doctorErpSign'],
			'erpSiqnSave':['erpSiqnSave'],
			'confirmErpSign':['confirmErpSign'],
			'patientErpSign':['patientErpSign'],
			'fingerCollectErpSign':['fingerCollectErpSign'],
			'timestampErpSign':['timestampErpSign']
		},
		connections : {
			'content' : [ {
				selector : 'button[itemId=doctorSignBtn]',
				event : 'click',
				chain : 'doctorErpSign'
			},{
				selector : 'button[itemId=erpSignSaveBtn]',
				event : 'click',
				chain : 'confirmErpSign'
			},{
				selector : 'button[itemId=patientSignBtn]',
				event : 'click',
				chain : 'patientErpSign'
			},{
				selector : 'button[itemId=fingerprintGatherBtn]',
				event : 'click',
				chain : 'fingerCollectErpSign'
			},{
				selector : 'button[itemId=timePokeSignBtn]',
				event : 'click',
				chain : 'timestampErpSign'
			}]
		}
	}
});