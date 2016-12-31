Ext.define('iih.po.assistant.view.EditKnowledgeTypeView',{
	extend : 'Xap.ej.template.BaseTemplate',

   	layout: 'fit',
   	
   	alias:'widget.editknowledgetypeview',

   	xapConfig: {
   		blocks: {
   			'list': {
   				xclass: 'iih.po.assistant.block.EditKnowledgeTypeBlock'
	   		}
	    },
		actions: {	
			'init': {
				xclass: 'iih.po.assistant.action.EditMrKnowledgeTypeInitAction',
				url:'knowledgesType'
			},
            'create': {
                xclass: 'iih.po.assistant.action.CreateKnowledgeTypeAction'
            },
            'edit': {
                xclass: 'iih.po.assistant.action.EditKnowledgeTypeAction'
            },
            'delete': {
                xclass: 'iih.po.assistant.action.DeleteKnowledgeTypeAction',
                url:'knowledgesType'
            },
			'save': {
				xclass: 'iih.po.assistant.action.SaveEditMrKnowledgeAction',
				url:'knowledgesType'
			},
			'close': {
				xclass: 'iih.po.assistant.action.CancelEditMrKnowledgeTypeAction'
			}
		},
		chains: {	
			'init': ['init'],
			'create': ['create'],
			'edit': ['edit'],
			'delete': ['delete'],
			'save': ['save'],
			'close': ['close']
		},
		connections: {	
			'list': [{
                selector: 'toolbar button[method=create]',
                event: 'click',
                chain: 'create'
            },{
                selector: 'toolbar button[method=edit]',
                event: 'click',
                chain: 'edit'
            },{
                selector: 'toolbar button[method=delete]',
                event: 'click',
                chain: 'delete'
            },{
				selector: 'button[method=save]',
	            event: 'click',
	            chain: 'save'
	        },{
				selector: 'button[method=close]',
	            event: 'click',
	            chain: 'close'
	        },{
				selector: 'button[method=fresh]',
	            event: 'click',
	            chain: 'init'
	        }]	
		}
   	}
})