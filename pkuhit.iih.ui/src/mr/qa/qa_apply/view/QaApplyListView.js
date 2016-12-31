Ext.define('iih.mr.qa.qa_apply.view.QaApplyListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.qaapplylistview',

	requires:[
		'Xap.ej.element.grid.column.ActionColumn',
		'Xap.ej.element.field.ComboBox',
   		'Xap.ej.element.field.Checkbox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'Xap.ej.element.grid.Grid',
   		'Xap.ej.element.label.Label',
   		'Xap.ej.element.field.DateField', 
   		'Xap.ej.element.button.Button',
   		'Xap.ej.element.field.DisplayField',
   		'Xap.ej.element.grid.column.Date',
   		'Xap.ej.block.ToolbarBlock',
   		'Xap.ej.element.grid.column.CheckColumn',
   		'iih.mr.qa.qa_apply.block.QaApplyGridBlock'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'top': {
                xclass: 'iih.mr.qa.qa_apply.block.QaApplySearchBlock',
				height:85
            },
			'bottom': {
				xclass: 'iih.mr.qa.qa_apply.block.QaApplyGridBlock',
				flex:1
			}
		},
		actions: {
			'init':{
				xclass: 'iih.mr.qa.qa_apply.action.QaApplyListInitAction',
				url:'mr/applylist',
				blocks: {
					bottom: 'bottom'
				}
			},'popSendApply':{
				xclass: 'iih.mr.qa.qa_apply.action.PopupApplyInferAction',
				blocks: {
					bottom: 'bottom'
				}
			},'passApply': {
                xclass: 'iih.mr.qa.qa_apply.action.PopupApplyInferPassAction',
                url:'mr/editapplypass',
                blocks: {
                	bottom: 'bottom'
                }                
            },'refuseApply': {
                xclass: 'iih.mr.qa.qa_apply.action.PopupApplyInferRefuseAction',
                url:'mr/editapplyrefuse',
                blocks: {
                	bottom: 'bottom'
                }
            }
		},

		chains: {
			'init': ['init'],
			'popSendApply': ['popSendApply'],
			'passApply': ['passApply'],
			'refuseApply': ['refuseApply']
		},

		connections: {
			/*'bottom': [{
				selector: 'button[method=sendApply]',
				event: 'click',
				chain: 'popSendApply'
			}]*/
			'bottom': [{
				event: 'afterrender',
				chain: 'init'
			}/*,{
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
			}*/]
		}
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
			 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        var chain = this.getActionChain('init');
	        var block = this.getBlock('bottom');
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