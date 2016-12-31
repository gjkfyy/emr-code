Ext.define('iih.mr.wr.omr.view.PastMrSelectView', {
	extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',

	requires: [],
	alias:'widget.pastmrselectview',

	xapConfig: {
		blocks: {
			'left': {
				xclass: 'iih.mr.wr.omr.block.PastMrDocTreeBlock',
				width:210
            },
			'right': {
				xclass: 'iih.mr.wr.mr.view.MrDocEditView'
			}
		},
        actions: {
            'initEncounterList': {
            	xclass: 'iih.mr.wr.omr.action.EncounterListInitAction',
//                xclass: 'iih.po.com.action.AssistantInitAction',
                url: 'mr/ens',
                blocks:{
                	left: 'left'
                }
            },
            'pastMrTreeInit': {
            	xclass: 'iih.mr.wr.omr.action.PastMrTreeInitAction',
//                xclass: 'iih.po.com.action.AssistantInitAction',
                url: 'mr_doc_tree/mrs',
                blocks:{
                	left: 'left'
                }
            },
            'treeNodeChange': {
                xclass: 'iih.mr.wr.omr.action.PastMrDocTreeNodeChangeAction',
                blocks: {
                    result: 'left'
                }
            }
        },
		chains: {
            'initEncounterList':['initEncounterList'],
            'pastMrTreeInit':['pastMrTreeInit'],
            'treeNodeChange': ['treeNodeChange']
        },
        connections: {
            'left': [{
//                selector: 'combo[itemId=encounterCombox]',
                event: 'afterrender',
                chain: 'initEncounterList'
            },{
                selector: 'combo[itemId=encounterCombox]',
                event: 'change',
                chain: 'pastMrTreeInit'
            },{
                selector: 'xaptree',
                event: 'itemclick',
                chain: 'treeNodeChange'
		    }]
        }
     }
});