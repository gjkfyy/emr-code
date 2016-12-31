Ext.define('iih.mr.tm.gro.view.GroupElementChooseView', {
    extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',

    requires: [
	           'iih.mr.tm.gro.block.GroupChooseTreeBlock',
	           'iih.mr.tm.gro.action.GroupElementLoadTreeDataAction',
	           'iih.mr.tm.gro.action.GroupElementTreeSerchAction',
	           'iih.mr.tm.gro.action.GroupElementChooseListAction',
	           'iih.mr.tm.gro.action.GroupChooseClickAction',
	           'iih.mr.tm.gro.action.GroupChooseThroughAction',
	           'iih.mr.tm.gro.action.GroupElementChooseEditAction'
               ],

    alias: 'widget.groupelementchooseview',

    xapConfig: {
		blocks: {
            'left': {
                xclass: 'iih.mr.tm.gro.block.GroupChooseTreeBlock',
                width:200
            },
            'right': {
                xclass: 'iih.mr.tm.gro.block.GroupElementChooseBlock',
                flex:1
            }
		},

		actions: {
			'refreshTree': {
                url:'mr/tpl/tree/groupElement',
                xclass: 'iih.mr.tm.gro.action.GroupElementLoadTreeDataAction',
                blocks: {
                    result: 'left',
                }
			},
			'groupElementActivate': {
				url:'/mr/tpl/groupElement',
                xclass: 'iih.mr.tm.gro.action.GroupElementActivateAction',
                blocks: {
                    result: 'right',
                }
			},
			'groupElementTreeSerch': {
				xclass: 'iih.mr.tm.gro.action.GroupElementTreeSerchAction',
				url:'mr/tpl/tree/groupElement',
				blocks: {
					result: 'left'
				}
			},
			'searchGroupElementList': {
				xclass: 'iih.mr.tm.gro.action.GroupElementChooseListAction',
				url:'mr/tpl/groupElement',
				blocks: {
					result: 'right'
				}
			},
			'groupElementClick': {
				xclass: 'iih.mr.tm.gro.action.GroupChooseClickAction',
				url:'mr/tpl/groupElement',
				blocks: {
					result: 'right'
				}
			},
			'groupCloseClick': {
				xclass: 'iih.mr.tm.gro.action.GroupChooseCloseAction',
				blocks: {
					result: 'right'
				}
			},
			'groupThroughClick': {
				xclass: 'iih.mr.tm.gro.action.GroupChooseThroughAction',
				url:'mr/basefile',
				blocks: {
					result: 'right'
				}
			},
			'groupOpenClick': {
				xclass: 'iih.mr.tm.gro.action.GroupElementChooseEditAction',
                url: 'mr/basefile',
                blocks: {
                	result: 'right'
                }
			}
		},

		chains: {
			'initTree': ['refreshTree'],
			'beforeActivate': ['groupElementActivate'],	
			'groupElementTreeSerch': ['groupElementTreeSerch'],		
			'search': ['searchGroupElementList'],		
			'groupElementClick': ['groupElementClick'],
			'groupCloseClick': ['groupCloseClick'],
			'groupThroughClick': ['groupThroughClick'],
			'groupOpenClick': ['groupOpenClick']			
		},

		connections: {
			 'left': [ {
                 selector: 'xaptree',//[name=groupElement]名字加不上
                 event: 'afterrender',
                 chain: 'initTree'
	            },	            
	            {
                    selector: 'xaptrigger',
                    event: 'onTriggerClick',
                    chain: 'groupElementTreeSerch'
	            }
			 ],
			 'right': [{    
					 selector: 'groupelementchooselistblock',
	                 event: 'afterrender',
	                 chain: 'search'
					},
					{
					 selector: 'grid',
	                 event: 'cellclick',
	                 chain: 'groupElementClick'
					},
					{
					 selector: 'button[method=cancel]',
	                 event: 'click',
	                 chain: 'groupCloseClick'
					},
					{
					 selector: 'button[method=through]',
	                 event: 'click',
	                 chain: 'groupThroughClick'
					},
					{
					 selector: 'button[method=open]',
	                 event: 'click',
	                 chain: 'groupOpenClick'
					}
			   ]
		}
	}
})