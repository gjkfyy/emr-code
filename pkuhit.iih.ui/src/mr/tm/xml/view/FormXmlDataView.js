Ext.define('iih.mr.tm.xml.view.FormXmlDataView', {
    extend: 'Xap.ej.stl.view.BorderTemplate',
    
    requires: [
               'iih.mr.tm.xml.view.FormXmlDataLeftView',
               'Ext.grid.plugin.CellEditing',
               ],
    
    alias: 'widget.formxmldataview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'west': {
                xclass: 'iih.mr.tm.xml.view.FormXmlDataLeftView',
                width:300
                
            },
            'center': {
                xclass: 'iih.mr.tm.xml.block.FormXmlDataRightBlock',
                flex:1
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.tm.xml.action.FormXmlDataInitAction',
                blocks: {
                    condition: 'west',
                    result: 'center'
                }
            }
        },

        chains: {
        	'init':['init']
        },

        connections: {
        	'west': []
        }
    },
    
    initComponent : function() {
        this.callParent();
        var me = this;
    }
});