Ext.define('iih.mr.tm.gro.view.GroupElementSearchView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	requires: [
	           'iih.mr.tm.gro.action.GroupElementLoadTreeDataAction',
	           'iih.mr.tm.gro.action.GroupElementTreeSerchAction',
	           'iih.mr.tm.gro.action.GroupElementListSearchAction',
	           'iih.mr.tm.gro.action.GroupElementClickAction',
	           'iih.mr.tm.gro.action.CreateGroupElementAction'
	          ],
	
	alias:'widget.groupelementsearchview',	
	
	layout:'fit',

	xapConfig: {
		
		blocks: {
            /*'left': {
                xclass: 'iih.mr.tm.bas.block.BasTemplateTreeBlock',
                width:200
            },*/
            'right': {
                xclass: 'iih.mr.tm.gro.block.GroupElementWorkBlock'/*,
                flex:1*/
            }
		},

		actions: {
			/*'refreshTree': {
                url:'mr/tpl/tree/groupElement',
                xclass: 'iih.mr.tm.gro.action.GroupElementLoadTreeDataAction',
                blocks: {
                    result: 'left',
                }
			},
			'groupElementTreeSerch': {
				xclass: 'iih.mr.tm.gro.action.GroupElementTreeSerchAction',
				url:'mr/tpl/tree/groupElement',
				blocks: {
					result: 'left'
				}
			},*/
			'groupElementActivate': {
				url:'/mr/tpl/groupElement',
                xclass: 'iih.mr.tm.gro.action.GroupElementActivateAction',
                blocks: {
                    result: 'right',
                }
			},
			
			'searchGroupElementList': {
				xclass: 'iih.mr.tm.gro.action.GroupElementListSearchAction',
				url:'mr/tpl/groupElement',
				blocks: {
					result: 'right'
				}
			},
			'groupElementClick': {
				xclass: 'iih.mr.tm.gro.action.GroupElementClickAction',
				url:'mr/tpl/groupElement',
				blocks: {
					result: 'right'
				}
			},
			'groupElementStatCdChange': {
				xclass: 'iih.mr.tm.gro.action.GroupElementStatCdChangeAction',
				url:'mr/tpl/groupElement',
				blocks: {
					result: 'right'
				}
			},
            'createGroupElement': {
				xclass: 'iih.mr.tm.gro.action.CreateGroupElementAction',
				blocks: {
                    result: 'right'
                }      
			}
		},

		chains: {
			/*'initTree': ['refreshTree'],
			'groupElementTreeSerch': ['groupElementTreeSerch'],	*/
			'beforeActivate': ['groupElementActivate'],			
			'search': ['searchGroupElementList'],		
			'groupElementClick': ['groupElementClick'],
			'groupElementStatCdChange': ['groupElementStatCdChange'],
			'createGroupElement': ['createGroupElement']
			
		},

		connections: {
			 /*'left': [ {
                 selector: 'xaptree',//[name=groupElement]名字加不上
                 event: 'afterrender',
                 chain: 'initTree'
	            },	            
	            {
                    selector: 'xaptrigger',
                    event: 'onTriggerClick',
                    chain: 'groupElementTreeSerch'
	            }
			 ],*/
			 'right': [{    
					 selector: 'groupelementsearchlistblock',
	                 event: 'afterrender',
	                 chain: 'search'
					},
					{  
					 selector: 'grid',
	                 event: 'cellclick',
	                 chain: 'groupElementClick'
					},
					{ 
					 selector: '[name=groupElementStatCd]',
	                 event: 'change',
	                 chain: 'groupElementStatCdChange'
					},
					{ 
					 selector: 'button[method=create]',
	                 event: 'click',
	                 chain: 'createGroupElement'
					}
			   ]
		}
	}
})
