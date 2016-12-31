Ext.define('iih.mr.wr.mr.view.MrDocPropertyView',{
	extend : 'Xap.ej.stl.view.SingleRecordEditTemplate',

	requires: [
	    'iih.mr.wr.mr.block.MrDocPropertyBlock',
	    'iih.mr.tm.mr.action.CancelTemplatePropertyEditAction',
	    'iih.mr.wr.mr.action.ConfimCreateMrDocAction',
	    'iih.mr.wr.mr.action.InitMrDocPropertyAction',
	    'iih.mr.wr.mr.action.ModifyMrProAction',
	    'iih.mr.wr.mr.action.InitjobTitleAction'
	],

	alias:'widget.mrdocpropertyview',
	
	layout:'fit',
	
	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.mr.block.MrDocPropertyBlock',
                height:150
            }
		},

		actions: {
		    'init': { 
		    	xclass: 'iih.mr.wr.mr.action.InitMrDocPropertyAction',
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
            },
            'confim':{
                xclass:'iih.mr.wr.mr.action.ConfimCreateMrDocAction',
                url:'mr_doc_file',
                blocks:{
                    content:'content'
                }
            },
            'quality':{
                xclass: 'iih.mr.wr.mr.action.mrQualityAction',
                url: 'qaCheckCreateMr/mr',
                blocks: {
                    content: 'content'
                }
            },
            'confimUpPro':{
                xclass:'iih.mr.wr.mr.action.ModifyMrProAction',
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
		    'initjobTitle': ['initjobTitle'],
            'confim': ['confim'],
            'confimUpPro': ['confimUpPro'],
            'quality':['quality'],
            'cancel': ['cancel']
		},

		connections: {
		    'content':[{
                event:'afterrender',
                chain:'init'
            },{    
                //确认按钮（新建病历选择模板属性）
                selector: 'button[method=confim]',
                event: 'click',
                chain: 'quality'//confim
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
            }]
		}
	}
})