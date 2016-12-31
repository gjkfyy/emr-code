Ext.define('iih.mr.dr.condition_set.view.ConditionPanelView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			
			alias : 'widget.conditionpanelview',
			
			requires : ['iih.mr.dr.condition_set.view.ConditionPanelLeftView',
					'iih.mr.dr.condition_set.block.ConditionPanelRightBlock',
					'iih.mr.dr.condition_set.action.PopupConditionSettingAction'
			],

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.mr.dr.condition_set.view.ConditionPanelLeftView',
						width : 400
					},
					'right' : {
						xclass : 'iih.mr.dr.condition_set.block.ConditionPanelRightBlock',
						flex : 1
					}
				},

				actions : {
					'conditionInfer':{
						xclass: 'iih.mr.dr.condition_set.action.PopupConditionSettingAction',
						blocks: {
							result: 'right'
						}
					}
				},

				chains : {
					'conditionInfer': ['conditionInfer']
				},

				connections : {
					'right': [{
						selector: 'button[action=conditionInfer]',
						event: 'click',
						chain: 'conditionInfer'
					}]
				}
			}
		});