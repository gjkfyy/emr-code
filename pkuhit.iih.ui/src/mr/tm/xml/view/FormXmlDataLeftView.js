Ext.define('iih.mr.tm.xml.view.FormXmlDataLeftView', {
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    
    requires: [
               'iih.mr.tm.xml.action.FormXmlDataTopInitAction',
               'iih.mr.tm.xml.action.FormXmlDataTopSearchAction',
               'iih.mr.tm.xml.action.FormXmlClickAction'
               ],
    
    alias: 'widget.formxmldataleftview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.mr.tm.xml.block.FormXmlDataTopBlock',
                height:40
                
            },
            'bottom': {
                xclass: 'iih.mr.tm.xml.block.FormXmlDataButtomBlock',
                flex:1
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.tm.xml.action.FormXmlDataTopInitAction',
                url: 'ws/mr/share/meta',
                blocks: {
                    condition: 'top',
                    result: 'buttom'
                }
            },
	        'click': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlClickAction',
	        	url: 'ws/mr/share/meta',
	        	blocks: {
	        		condition: 'top',
	        		result: 'buttom'
	        	}
	        },
	        'search': {
                xclass: 'iih.mr.tm.xml.action.FormXmlDataTopSearchAction',
                url: 'ws/mr/share/meta',
                blocks: {
                    condition: 'top',
                    result: 'buttom'
                }
            }
        },

        chains: {
            'init': ['init'],
            'search': ['search'],
            'click': ['click']
        },

        connections: {
            'bottom': [{
                selector: 'xapgrid[name=dataResourceGrid]',
                event: 'cellclick',
                chain: 'click'
            }],
            'top': [{
                 selector: 'button[name=search]',
                 event: 'click',
                 chain: 'search'
             }]
    	}
    },
    
    initComponent : function() {this.callParent();}
});