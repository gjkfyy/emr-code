Ext.define('iih.po.com.view.Login', {
	extend: 'Xap.ej.template.BaseTemplate',
	requires: [
	           'iih.po.com.block.LoginBlock',
	           'iih.po.com.action.LoginAction',
	           'iih.po.com.action.LoginInitAction',
	           'iih.po.com.action.LoginKeyAction',
	           'iih.po.com.action.LoginResetAction'
	           ],

	alias:'widget.login',
	layout:'fit',
	
	xapConfig: {
		blocks: {
			'loginblock': {
				xclass: 'iih.po.com.block.LoginBlock'
			}
		},

		actions: {
			'reset': {
				xclass: 'iih.po.com.action.LoginResetAction',
				blocks: {
					lvblock: 'loginblock'
				}
			},
			'caCheck': {
                xclass: 'iih.po.com.action.CaCheckAction',
                blocks: {
                    lvblock: 'loginblock'
                }
            },
            'loginComm': {
                xclass: 'iih.po.com.action.LoginCommAction',
                blocks: {
                    lvblock: 'loginblock'
                }
            },
			'caLogin': {
                xclass: 'iih.po.com.action.CaLoginAction',
                blocks: {
                    lvblock: 'loginblock'
                }
            },
            'getCertInfo': {
                xclass: 'iih.po.com.action.GetCertInfoAction',
                url: 'ca/getBJCACertInfo',
                blocks: {
                    lvblock: 'loginblock'
                }
            },
            'getCertUser': {
                xclass: 'iih.po.com.action.GetCertUserAction',
                url: 'ca/getCACertUser',
                blocks: {
                    lvblock: 'loginblock'
                }
            },
			'login': {
				xclass: 'iih.po.com.action.LoginAction',
				blocks: {
					lvblock: 'loginblock'
				}
			},
			'loginKey': {
				xclass: 'iih.po.com.action.LoginKeyAction'
			},
			'init': {
				xclass: 'iih.po.com.action.LoginInitAction',
				blocks: {
					lvblock: 'loginblock'
				}
			},
			'autologin': {
                xclass: 'iih.po.com.action.AutoLoginAction',
                blocks: {
                    lvblock: 'loginblock'
                }
            }
		},

		chains: {
			'reset':['reset'],
			'caCheck':['caCheck'],
			'loginComm':['loginComm'],
			'caLogin':['caLogin'],
			'getCertInfo':['getCertInfo'],
			'getCertUser':['getCertUser'],
			'login':['login'],
			'init':['init'],
			'loginKey':['loginKey'],
			'autologin':['autologin']
		},

		connections: {
			'loginblock': [{
				selector: 'button[action=reset]',
				event: 'click',
				chain: 'reset'
			},{
				selector: 'button[action=login]',
				event: 'click',
				chain: 'loginComm'
			},{
				selector: 'textfield[name=password]',
				event: 'keypress',
				chain: 'loginKey'
			},{
                selector: 'xapcheckboxgroup[name=caCheck]',
                event: 'change',
                chain: 'caCheck'
            },{
				event: 'afterrender',
				chain: 'init'
			}]
		}
	}
})