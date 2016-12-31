Ext.define('iih.mr.wr.omr.view.OmrDocPropertyView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.wr.omr.block.OmrDocPropertyBlock',
//	    'iih.mr.tm.omr.action.CancelTemplatePropertyEditAction',
	    'iih.mr.wr.omr.action.ConfimCreateOmrDocAction',
	    'iih.mr.wr.omr.action.InitOmrDocPropertyAction',
	    'iih.mr.wr.omr.action.ModifyOmrProAction'/*,
	    'iih.mr.wr.omr.action.InitjobTitleAction'*/
	],

	alias:'widget.omrdocpropertyview',
	
	layout:'fit',
	
	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.omr.block.OmrDocPropertyBlock',
                height:100
            }
		},

		actions: {
		    'init': { 
		    	xclass: 'iih.mr.wr.omr.action.InitOmrDocPropertyAction',
		        url:'app/sup/doctors',
		        blocks: {
		            content:'content'
		        }
		    }/*,
		    'initjobTitle': { 
                xclass: 'iih.mr.wr.mr.action.InitjobTitleAction',
                blocks: {
                    content:'content'
                }
            }*/,
            'confim':{
                xclass:'iih.mr.wr.omr.action.ConfimCreateOmrDocAction',
                url:'mr_doc_file',
                blocks:{
                    content:'content'
                }
            },
            'confimUpPro':{
                xclass:'iih.mr.wr.omr.action.ModifyOmrProAction',
                url:'mr_doc_file',
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
		    }
		},

		chains: {
		    'init': ['init'],
//		    'initjobTitle': ['initjobTitle'],
            'confim': ['confim'],
            'confimUpPro': ['confimUpPro'],
            'cancel': ['cancel']
		},

		connections: {
		    'content':[{
                event:'afterrender',
                chain:'init'
            }/*,{    
                //确认按钮（新建病历选择模板属性）
                selector: 'button[method=confim]',
                event: 'click',
                chain: 'confim'
            },{    
                //确认按钮（修改病历属性）
                selector: 'button[method=confimUpPro]',
                event: 'click',
                chain: 'confimUpPro'
            },{    
                //取消按钮
                selector: 'button[method=cancel]',
                event: 'click',
                chain: 'cancel'
            },{    
                //关闭按钮
                selector: 'button[method=close]',
                event: 'click',
                chain: 'cancel'
            },{    
                //上级医师
                selector: 'xapcombobox[name=higherLvlEmpId]',
                event: 'change',
                chain: 'initjobTitle'
            }*/]
		}
	}
})