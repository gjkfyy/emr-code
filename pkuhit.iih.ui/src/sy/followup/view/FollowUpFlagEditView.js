Ext.define('iih.sy.followup.view.FollowUpFlagEditView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.followupflageditview', 
	
	requires:[
	   		  'Xap.ej.element.button.Button',
	   		  'iih.sy.followup.block.FollowUpFlagEditBlock',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
	          'iih.sy.followup.action.FollowUpFlagEditInitAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.sy.followup.block.FollowUpFlagEditBlock'
			}
		},
		actions:{
			'init':{
				xclass: 'iih.sy.followup.action.FollowUpFlagEditInitAction',
				url:'iemrPatient',
				blocks: {
				    content: 'content'
				}
			},
			'saveFlag':{
				xclass: 'iih.sy.followup.action.FollowUpFlagSaveAction',
				url:'followUp/saveFlag',
				blocks: {
				    content: 'content'
				}
			},
			'cancel':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init' : ['init'],
			'saveFlag':['saveFlag'],
			'cancel':['cancel']
		},
		connections:{
			'content':[{    
			    //加载数据
	            event: 'afterrender',
	            chain: 'init'
	        },{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'saveFlag'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		},
		initComponent : function() {
			this.callParent();
		}
	}
})