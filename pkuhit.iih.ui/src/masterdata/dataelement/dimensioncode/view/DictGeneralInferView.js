Ext.define('iih.masterdata.dataelement.dimensioncode.view.DictGeneralInferView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	requires:[
	  	'Xap.ej.element.grid.Grid',
	    'Xap.ej.element.form.Form',
	    'Xap.ej.element.label.Label',
	    'Xap.ej.element.field.TextField',
	    'Xap.ej.element.field.ComboBox',
	    'Xap.ej.element.field.TextArea',
	    'Xap.ej.element.toolbarbutton.ToolBarButton',
	    'Xap.ej.element.button.Button',
	    'Xap.ej.element.field.NumberField',
	    'Xap.ej.element.field.DisplayField',
	    'Xap.ej.element.field.RangeNumberField'
	],

    alias:'widget.dictgeneralinferview',
	
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.masterdata.dataelement.dimensioncode.block.DictGeneralInferBlock',
				height:300
			}
		},
		actions: {
			'init':{
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictEditInitAction',
				blocks: {
					result: 'content'
				}
			},
			'save': {
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictSaveAction',
				url:"md/mr/Dimen/code",
				blocks: {
					result: 'content'
				}
			},
			'cancel': {
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.CancelAction',
				blocks: {
					result: 'content'
				}
			},
			'getNewCode':{
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictInitGetNewCode',
				url:"md/mr/Dimen/getNewCode",
				blocks: {
					result: 'content'
				}
			}
		},

		chains: {
			'init': ['init'],
			'save': ['save'],
			'cancel': ['cancel'],
			'getNewCode':['getNewCode']
		},

		connections: {
			'content': [{
				event: 'afterrender',
				chain: 'init'
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
})