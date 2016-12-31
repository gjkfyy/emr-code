Ext.define('iih.mr.dr.condition_set.view.ConditionSettingView', {
	extend : 'Xap.ej.template.BaseTemplate',
			
	alias : 'widget.conditionsettingview',
			
	requires : [
	            'iih.mr.dr.condition_set.action.ConditionInferInitAction',
	            'iih.mr.dr.condition_set.action.ConditionInferSaveAction',
	            'iih.mr.dr.condition_set.action.CancelAction',
	            'iih.mr.dr.condition_set.block.ConditionSettingButtonBlock',
	            'iih.mr.dr.condition_set.view.ConditionSettingInferView'
	],
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig : {
		blocks: {
			'condition':{
				xclass: 'iih.mr.dr.condition_set.view.ConditionSettingInferView',
				flex:1
			},
			'result':{
				xclass: 'iih.mr.dr.condition_set.block.ConditionSettingButtonBlock',
				height:30
			}
		},

			actions : {
				'refresh':{
					xclass: 'iih.mr.dr.condition_set.action.ConditionInferInitAction',
					blocks: {
						result: 'condition'
					}
				},
				'save': {
					xclass: 'iih.mr.dr.condition_set.action.ConditionInferSaveAction',
//					url:'',
					blocks: {
						result: 'result'
					}
				},
				'cancel': {
					xclass: 'iih.mr.dr.condition_set.action.CancelAction',
					blocks: {
						result: 'result'
					}
				}
			},

			chains : {
				'refresh': ['refresh'],
				'save': ['save'],
				'cancel': ['cancel']
			},

			connections : {
				'result': [{
					event: 'afterrender',
					chain: 'refresh'
				},{
					selector: 'button[method=save]',
					event: 'click',
					chain: 'save'
				},{
					selector: 'button[method=cancel]',
					event: 'click',
					chain: 'cancel'
				}]
			}
		}
});