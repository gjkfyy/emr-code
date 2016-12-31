Ext.define('iih.masterdata.dataelement.dimensioncode.view.DictGeneralListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.dictgenerallistview',

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
			'top': {
                xclass: 'iih.masterdata.dataelement.dimensioncode.block.DictGeneralGridBlock',
				height:290
            },
			'bottom': {
				xclass: 'iih.masterdata.dataelement.dimensionvalue.view.DictGeneralDataListView',
				flex:1
			}
		},
		actions: {
			'init':{
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictInitAction',
				url:'md/mr/Dimen/code',
				blocks: {
					top: 'top'
				}
			},'create':{
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.PopupDictInferAction',
				blocks: {
					top: 'top'
				}
			},'edit':{
				xclass: 'iih.masterdata.dataelement.dimensioncode.action.PopupDictEditAction',
				blocks: {
					top: 'top'
				}
			},
			'deleted': {//删除
                xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictDeletedAction',
                url:'md/mr/Dimen/code',
                blocks: {
                    result: 'top'
                }                
            },
			'activated': {//启用
                xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictActivatedAction',
                url:'dict/dg/activated',
                blocks: {
                    result: 'top'
                }                
            }, 
            'stopped': {//停用
                xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictStoppedAction',
                url:'dict/dg/stopped',
                blocks: {
                    result: 'top'
                }
            },
            'execResult':{
            	xclass: 'iih.masterdata.dataelement.dimensionvalue.action.DictDataInitAction',
                url:'md/mr/Dimen/code',
                blocks: {
                	bottom: 'bottom'
                }
            },
            'dictViewready':{
            	xclass: 'iih.masterdata.dataelement.dimensioncode.action.DictViewreadyAction',
                blocks: {
                	result: 'top'
                }
            },
			'wakeDictDataButton': {
				xclass: 'iih.masterdata.dataelement.dimensionvalue.action.WakeDictDataButtonAction',
				blocks: {
					top: 'top'
				}
			}
		},

		chains: {
			'init': ['init'],
			'create': ['create'],
			'edit': ['edit'],
			'activated': ['activated'],
			'stopped': ['stopped'],
			'execResult':['execResult'],
			'dictViewready':['dictViewready'],
			'deleted':['deleted'],
			'wakeDictDataButton':['wakeDictDataButton']
		},

		connections: {
			'top': [{
				event: 'afterrender',
				chain: 'init'
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'execResult'
			},{
				selector: 'xapgrid',
				event: 'turnpage',
				chain: 'init'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'dictViewready'
			},{
				selector: 'xapgrid',
				event: 'select',
				chain: 'wakeDictDataButton'
			}]
		}
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
			 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        var chain = this.getActionChain('init');
	        var block = this.getBlock('top');
//	        var pageSize = block.pageSize;
	        if(properties.data == undefined){
	        	if(chain) {
	        		chain.execute({});
	        	}
	        }else{
	        	var pageSize = properties.data.pageSize;
		        var pageNum = properties.data.pageNum;
		        if(chain) {
		            chain.execute({
		            	pageSize:pageSize,
		            	pageNum:pageNum
		            });
		        }
	        }
		});
	}
})