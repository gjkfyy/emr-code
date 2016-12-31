Ext.define('iih.mr.wr.mr.view.MrDocPropertyEditView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
	    'iih.mr.wr.mr.block.MrDocPropertyEditBlock',
	    'iih.mr.tm.mr.action.CancelTemplatePropertyEditAction',
	    'iih.mr.wr.mr.action.ConfimCreateMrDocAction',
	    'iih.mr.wr.mr.action.ModifyMrProAction',
	    'iih.mr.wr.mr.action.InitjobTitleAction'
	],

	alias:'widget.mrdocpropertyeditview',
	
	layout:'fit',
	
	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.mr.block.MrDocPropertyEditBlock',
                height:150
            }
		},
		actions: {
		    'init': { 
		    	xclass: 'iih.mr.wr.mr.action.InitMrDocPropertyEditAction',
		        url:'app/sup/doctors',
		        blocks: {
		            content:'content'
		        }
		    },
		    'initjobTitle': { 
                xclass: 'iih.mr.wr.mr.action.InitjobTitleAction',
                blocks: {
                    content:'content'
                }
            }/*,
		    'initCombox': { 
                xclass: 'iih.mr.wr.mr.action.InitComboxAction',
                blocks: {
                    content:'content'
                }
            }*/,
            'confimUpPro':{
                xclass:'iih.mr.wr.mr.action.ModifyMrProAction',
                url:'mr',
                blocks:{
                    content:'content'
                }
            },
		    'cancel': {
		        xclass: 'iih.mr.wr.mr.action.CancelCreateMrDocAction',
		        //url:'cancelTemplatePropertyEdit',
		        blocks: {
		            content: 'content'
		        }
		    },
            'templateProperty': {
                xclass: 'iih.mr.wr.mr.action.MrTemplatePropertyInitAction',
                url:'mr/tpl/template',
                blocks: {
                    content: 'content'
                }
            },
            'mrDocPropertyEditInitComboxAction': {
                xclass: 'iih.mr.wr.mr.action.MrDocPropertyEditInitComboxAction',
                url:'/app/sup/doctors',
                blocks: {
                    content: 'content'
                }
            }
		},

		chains: {
		    'init': ['init'],
		    'initjobTitle': ['initjobTitle'],
            'confimUpPro': ['confimUpPro'],
            'mrDocPropertyEditInitComboxAction': ['mrDocPropertyEditInitComboxAction'],
            'cancel': ['cancel'],
            'templateProperty':['templateProperty']
		},

		connections: {
		    'content':[/*{
                event:'afterrender',
                chain:'init'
            },*/{    
                //确认按钮（修改病历属性）
                selector: 'button[method=confimUpPro]',
                event: 'click',
                chain: 'confimUpPro'
            },{    
                //关闭按钮
                selector: 'button[method=close]',
                event: 'click',
                chain: 'cancel'
            },{    
                //取消按钮
                selector: 'button[method=cancel]',
                event: 'click',
                chain: 'cancel'
            },{
                selector: 'xapdisplayfield[name=templeName]',
                event: 'click',
                chain: 'templateProperty'
            },{    
                //上级医师
                selector: 'xapcombobox[name=higherLvlEmpId]',
                event: 'change',
                chain: 'initjobTitle'
            }]
		}
	}
})