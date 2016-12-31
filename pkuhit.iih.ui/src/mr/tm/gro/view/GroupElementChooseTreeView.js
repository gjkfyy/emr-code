Ext.define('iih.mr.tm.gro.view.GroupElementChooseTreeView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: [
               'iih.mr.tm.gro.action.GroupElementTreeInitAction',
               'iih.mr.tm.gro.action.GroupElementChooseEditAction'
               ],

    alias: 'widget.groupelementchoosetreeview',
    
    layout: {
        type : 'vbox',
        align : 'stretch'
    },

    xapConfig: {
        blocks: {
            'top': {
            	xclass: 'iih.mr.tm.gro.block.GroupElementChooseSearchBlock',
                border: 0,
                height:30
            },
            'bottom':{
            	xclass: 'iih.mr.tm.gro.block.GroupElementChooseTreeBlock',
            	border: 0,
            	flex:1
            }
        },


        actions: {
           'init': {
                xclass: 'iih.mr.tm.gro.action.GroupElementTreeInitAction',
                url: 'dm-mr/mr/tpl/tree/groupElement',
                blocks: {
                	bottom: 'bottom'
                }
            },
            'treeClick': {
                xclass: 'iih.mr.tm.gro.action.ChooseTreeNodeChangeAction',
                url: 'dm-mr/mr/tpl/groupElement',
                blocks: {
                	bottom: 'bottom'
                }
            }
        },

        chains: {
            'init': ['init'],
            'treeClick': ['treeClick']
        },

        connections: {
            'bottom':[{
	                event: 'afterrender',
	                chain: 'init'
            	},{
	                 selector: 'xaptree',
	                 event: 'itemclick',
	                 chain: 'treeClick'
            	}]
        }
    }
})