Ext.define('iih.mr.tm.xml.view.FormXmlView', {
    extend: 'Xap.ej.stl.view.BorderTemplate',
    
    requires: [
               'iih.mr.tm.xml.action.FormXmlInitAction',
               'iih.mr.tm.xml.action.FormXmlItemClickAction',
               'iih.mr.tm.xml.action.FormXmlChangeAction',
               'iih.mr.tm.xml.action.FormXmlChangeTimeAction',
               'iih.mr.tm.xml.action.FormXmlChangeSelAction',
               'iih.mr.tm.xml.action.FormXmlDataSaveAction',
               'iih.mr.tm.xml.action.FormXmlDataConfimAction',
               'iih.mr.tm.xml.action.FormXmlDataResetTableAction'
               ],
    
    alias: 'widget.formxmlview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'west': {
                xclass: 'iih.mr.tm.xml.block.FormXmlTreeBlock',
                width:160
                
            },
            'center': {
                xclass: 'iih.mr.tm.xml.block.FormXmlEditBlock',
                flex:1
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.tm.xml.action.FormXmlInitAction',
                url: 'mr/tpl/tree/formxml',
                blocks: {
                    condition: 'west',
                    result: 'center'
                }
            },
	        'itemClick': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlItemClickAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'change': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlChangeAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'changeTime': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlChangeTimeAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'changeSel': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlChangeSelAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'search': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlDataSearchAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'confim': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlDataConfimAction',
	        	url:'mr/tpl/tree/createxml',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'save': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlDataSaveAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'reset': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlDataeResetAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'resetTable': {
	        	xclass: 'iih.mr.tm.xml.action.FormXmlDataResetTableAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        },
	        'enableWriter': {
	        	xclass: 'iih.mr.tm.xml.action.EnableWriterAction',
	        	blocks: {
	        		condition: 'west',
	        		result: 'center'
	        	}
	        }
        },

        chains: {
            'init': ['init'],
            'itemClick': ['itemClick'],
            'change': ['change'],
            'changeTime': ['changeTime'],
            'changeSel': ['changeSel'],
            'confim': ['confim'],
            'save': ['save'],
            'reset':['reset'],
            'resetTable':['resetTable'],
            'search': ['search'],
            'enableWriter':['enableWriter']
        },

        connections: {
            'west': [{
                selector: 'xaptree[name=formXmlTree]',
                event: 'itemclick',
                chain: 'itemClick'
            }],
            'center': [{
                event: 'beforedestroy',
                chain: 'enableWriter'
            },{
                selector: 'xapcombobox[name=mrElementTypeName]',
                event: 'change',
                chain: 'change'
            },{
                selector: 'xapcombobox[name=showFormat]',
                event: 'change',
                chain: 'changeTime'
            },{
                selector: 'xapcombobox[name=valueType]',
                event: 'change',
                chain: 'changeSel'
            },{
                selector: 'button[name=search]',
                event: 'click',
                chain: 'search'
            },{
                selector: 'button[name=confim]',
                event: 'click',
                chain: 'confim'
            },{
                selector: 'button[name=save]',
                event: 'click',
                chain: 'save'
            },{
                selector: 'button[name=reset]',
                event: 'click',
                chain: 'reset'
            }]
        }
    },
    
    initComponent : function() {
        this.callParent();
        var me = this;
    }
    
});