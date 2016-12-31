Ext.define('iih.po.assistant.view.EditKnowledgeView',{
	extend : 'Xap.ej.template.BaseTemplate',

   	layout: 'fit',
   	
   	alias:'widget.editknowledgeview',

   	xapConfig: {
   		blocks: {
   			'list': {
   				xclass: 'iih.po.assistant.block.EditKnowledgeBlock'
	   		}
	    },
		actions: {	
			'init':{
				xclass: 'iih.po.assistant.action.EditPersonKnowledgeInitAction',
				url:'knowledgesType'
			},
			'prapareData': {
				xclass: 'iih.po.assistant.action.PersonKnowledgePrapareDataAction',
				url:'knowledge'
			},
			'typeEdit': {
				xclass: 'iih.po.assistant.action.EditPersonKnowledgeTypeAction'
			},
			'close': {
				xclass: 'iih.po.assistant.action.CancelEditMrKnowledgeAction'
			},
			'save': {
				xclass: 'iih.po.assistant.action.SaveFragmentTplAction',
				url:'knowledge',
		        blocks: {
		            result:'list'
		        }
			}
		},
		chains: {	
			'init': ['init'],
			'typeEdit': ['typeEdit'],
			'prapareData': ['prapareData'],
			'close': ['close'],
			'save': ['save']
		},
		connections: {	
			'list': [{
				selector: 'button[method=edit]',
	            event: 'click',
	            chain: 'typeEdit'//编辑类别
	        },{
				selector: 'button[method=close]',
	            event: 'click',
	            chain: 'close'
	        },{
				selector: 'button[method=save]',
	            event: 'click',
	            chain: 'save'
	        }]	
		}
   	}
})