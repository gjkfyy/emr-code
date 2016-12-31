Ext.define('iih.po.com.view.OtherOmrView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.otheromrview', 
	
	requires:[],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.po.com.block.OtherOmrBlock'
			}
		},
		actions:{
			'init':{
				xclass: 'iih.po.com.action.OtherOmrInitAction',
//				url:'mr/other', //mr/other为调用安博维电子病历，externalInterf为调用cis住院病历
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init']
		},
		connections:{
			'content':[{
                event:'afterrender',
                chain:'init'
            }]
		}
	}
})