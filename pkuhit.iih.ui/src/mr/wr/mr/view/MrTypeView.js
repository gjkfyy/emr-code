Ext.define('iih.mr.wr.mr.view.MrTypeView',{
	extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',

	requires: ['Xap.ej.block.ToolbarBlock',
		          'Xap.ej.element.tree.Tree',
		   		  'Xap.ej.element.button.Button',
		   		  'Xap.ej.element.grid.plugin.CellEditing',
		          'Xap.ej.element.grid.column.CheckColumn',
		          'Xap.ej.element.grid.column.Number',
		          'Xap.ej.element.field.NumberField',
		          'Xap.ej.block.GridBlock',
		          'Xap.ej.element.radiogroup.RadioGroup',
		          'iih.mr.qa.qa_divide_level.action.ToQaAutoConfig'],
               
	alias:'widget.mrtypeview',
	
	border: 0,
	
	id: 'mrtypeviewid',

	xapConfig: {
		blocks: {
			'left': {
                xclass: 'iih.mr.wr.mr.block.MrTypeCcatTreeBlock',
                width:200
            },
            'right': {
                xclass: 'iih.mr.wr.mr.block.MrTypeListBlock',
                flex:1
            }
		},		
		actions: {
			'tree': {
				xclass: 'iih.mr.wr.mr.action.MrTypeCcatTreeSearchAction',
				url: 'mr/md/mrccattree',
				blocks: {
					result: 'left'
				}
			},
			'search': {
                xclass: 'iih.mr.wr.mr.action.MrTypeSearchAction',
                url: 'mr/md/mrtype/ccat',
                blocks: {
                    result: 'right'
                }
            },
            'open': {
                xclass: 'iih.mr.wr.mr.action.MrTypePopAction',
                blocks: {
                   content: 'content'
                }
            },
            'delete': {
                xclass: 'iih.mr.wr.mr.action.MrTypeDelAction',
                url:'mr/md/mrtype',
                blocks: {
                   content: 'content'
                }
            },
            'toQaAutoConfig':{
				xclass: 'iih.mr.qa.qa_divide_level.action.ToQaAutoConfig',
				blocks: {
				   content: 'right'
				}
			}
		},

		chains: {
			'tree': ['tree'],
			'search': ['search'],
			'open': ['open'],
            'delete': ['delete'],
            'toQaAutoConfig':['toQaAutoConfig']
		},
			
		connections: {
			'left': [{
			    event: 'afterrender',
			    chain: 'tree'
			},{
                selector: 'xaptree',
                event: 'select',
                chain: 'search'
            }],
		'right': [{
			selector: 'xapgrid',
			event : 'itemdblclick',
			chain: 'toQaAutoConfig'
		}]
		}
		
	},
	initComponent : function() {
		this.callParent();
		var self = this;
	}
})
