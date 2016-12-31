Ext.define('iih.sy.pwd.view.PwdUpdateView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.pwdupdateview', 
	
	requires:[
	   		  'Xap.ej.element.button.Button',
	   		  'iih.sy.pwd.block.PwdUpdateBlock',
	          'iih.sy.pwd.action.VaidatorOldPwdAction',
	          'iih.sy.pwd.action.VaidatorIemrPwdAction',
	          'iih.sy.pwd.action.ConfirmNewPwdAction',
	          'iih.sy.pwd.action.SaveNewPwdAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.sy.pwd.block.PwdUpdateBlock'
			}
		},
		actions:{
			'vaidatorOldPwd':{
				xclass: 'iih.sy.pwd.action.VaidatorOldPwdAction',
				url:'pwdupdate/vaidatoroldpwd',
				blocks: {
				    content: 'content'
				}
			},
			'vaidatorIemrPwd':{
				xclass: 'iih.sy.pwd.action.VaidatorIemrPwdAction',
				blocks: {
				    content: 'content'
				}
			},
			'confirmNewPwd':{
				xclass: 'iih.sy.pwd.action.ConfirmNewPwdAction',
				blocks: {
				    content: 'content'
				}
			},
			'saveNewPwd':{
				xclass: 'iih.sy.pwd.action.SaveNewPwdAction',
				url:'pwdupdate/save',
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
			'vaidatorOldPwd':['vaidatorOldPwd'],
			'vaidatorIemrPwd':['vaidatorIemrPwd'],
			'confirmNewPwd':['confirmNewPwd'],
			'saveNewPwd':['saveNewPwd'],
			'cancel':['cancel']
		},
		connections:{
			'content':[{
				selector: 'xaptextfield[name=oldPwd]',
				event: 'blur',
				chain: 'vaidatorOldPwd'
			},{
				selector: 'xaptextfield[name=iemrPassword]',
				event: 'blur',
				chain: 'vaidatorIemrPwd'
			},/*{
				selector: 'xaptextfield[name=confirmPwd]',
				event: 'blur',
				chain: 'confirmNewPwd'
			},*/{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'confirmNewPwd'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		}
	}
})