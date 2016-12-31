Ext.define('iih.masterdata.dataelement.dimensionvalue.view.DictGeneralDataInferView',{
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

    alias:'widget.dictgeneraldatainferview',
	
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.masterdata.dataelement.dimensionvalue.block.DictGeneralDataInferBlock',
				height:243
			}
		},
		actions: {
			'init':{
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataEditInitAction',
				url:'md/mr/Dimen/value/codeValue',
				blocks: {
					bottom: 'content'
				}
			},
			'save': {
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataSaveAction',
				url:"md/mr/Dimen/value",
				blocks: {
					result: 'content'
				}
			},
			'cancel': {
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.CancelAction',
				blocks: {
					result: 'content'
				}
			}
		},

		chains: {
			'init': ['init'],
			'save': ['save'],
			'cancel': ['cancel']
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