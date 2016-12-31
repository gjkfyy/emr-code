Ext.define('iih.sy.config.view.ConfigView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.configview', 
	
	requires:[
	   		  'Xap.ej.element.button.Button',
	   		 'Xap.ej.block.GridBlock',
	   		 'Xap.ej.element.grid.plugin.CellEditing',
	   		 'iih.sy.config.action.SearchEmpDeptAction',
	   		 'iih.sy.config.action.SaveEmpDeptAction',
	   		 'iih.sy.config.action.CancelAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.sy.config.block.ConfigBlock',
				height:210
			}
		},
		actions:{
		    'searchEmpDept': {
                xclass: 'iih.sy.config.action.SearchEmpDeptAction',
                url:'orgEmpDept',
                blocks:{
                    context: 'content'
                }
            },
            'saveEmpDept': {
                xclass: 'iih.sy.config.action.SaveEmpDeptAction',
                url:'orgEmpDept/update',
                blocks:{
                    context: 'content'
                }
            },
            'close': {
            	xclass: 'iih.sy.config.action.CancelAction',
            	blocks:{
            		context: 'content'
            	}
            }
		},
		chains:{ 'searchEmpDept':['searchEmpDept'],
		'saveEmpDept':['saveEmpDept'],
		'close':['close']
		},
		connections:{
			'content':[{
				event: 'afterrender',
				chain: 'searchEmpDept'
			},
			{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'saveEmpDept'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'close'
			}]
		}
	}
})