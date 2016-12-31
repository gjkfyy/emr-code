Ext.define('iih.masterdata.dataelement.dimensionvalue.view.DictGeneralDataListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.dictgeneraldatalistview',

	requires:[
		'Xap.ej.element.field.ComboBox',
   		'Xap.ej.element.field.Checkbox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'Xap.ej.element.grid.Grid',
   		'Xap.ej.element.label.Label',
   		'Xap.ej.element.field.DateField', 
   		'Xap.ej.element.grid.column.Date',
   		'Xap.ej.element.grid.column.CheckColumn'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'result':{
				xclass: 'iih.masterdata.dataelement.dimensionvalue.block.DictGeneralDataGridBlock',
				flex:1
			}
		},
		actions: {
			'init':{
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataInitAction',
				url:'md/mr/Dimen/code',
				blocks: {
					result: 'result'
				}
			},
			'create':{
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.PopupDictDataInferAction',
				blocks: {
					result: 'result'
				}
			},
			'edit':{
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.PopupDictDataEditAction',
				blocks: {
					result: 'result'
				}
			},
			'deleted': {//删除
                xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataDeletedAction',
                url:'md/mr/Dimen/value',
                blocks: {
                    result: 'result'
                }                
            },
			'activated': {//启用
                xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataActivatedAction',
                url:'dict/dgd/activated',
                blocks: {
                    result: 'result'
                }                
            }, 
            'stopped': {//停用
                xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataStoppedAction',
                url:'dict/dgd/stopped',
                blocks: {
                    result: 'result'
                }
            },
            'changeUp': {//上移
                xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataChangeUpAction',
                url:'dict/change/up',
                blocks: {
                    result: 'result'
                }                
            }, 
            'changeDown': {//下移
                xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataChangeDownAction',
                url:'dict/change/down',
                blocks: {
                    result: 'result'
                }
            }, 
            'dictDataViewready': {
                xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataViewreadyAction',
                blocks: {
                    result: 'result'
                }
            }
		},

		chains: {
			'init': ['init'],
			'create': ['create'],
			'edit': ['edit'],
			'activated': ['activated'],
			'stopped': ['stopped'],
			'changeUp': ['changeUp'],
			'changeDown': ['changeDown'],
			'deleted':['deleted'],
			'dictDataViewready': ['dictDataViewready']
		
		},

		connections: {
			'result': [{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'dictDataViewready'
			}]
		}
	}
})