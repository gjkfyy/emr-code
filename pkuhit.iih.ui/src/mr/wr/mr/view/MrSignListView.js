Ext.define('iih.mr.wr.mr.view.MrSignListView', {
	//extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['iih.mr.wr.mr.action.MrSignInitAction',
	           'iih.mr.wr.mr.action.MrSignOpenAction'],

	alias:'widget.mrsignlistview',
	layout: {
        type : 'vbox',
        align : 'stretch'
    },

	xapConfig: {
		blocks: {
		    'content': {
                xclass: 'iih.mr.wr.mr.block.MrSignListBlock',
                flex:1
            }
		},
		actions: {
            'waitSignInit': {
               xclass: 'iih.mr.wr.mr.action.MrSignInitAction',
               url: 'waitSign/mrs',
               blocks: {
                  content: 'content'
               }
            },
            'alreadySignInit': {
               xclass: 'iih.mr.wr.mr.action.AlreadySignInitAction',
               url: 'signed/mrs',
               blocks: {
                  content: 'content'
               }
            },
            'signedPatients': {
               xclass: 'iih.mr.wr.mr.action.SignedPatientsInitAction',
               url: 'signed/patients',
               blocks: {
                  content: 'content'
               }
            },
            'waitDeptSignPatients': {
                xclass: 'iih.mr.wr.mr.action.WaitDeptSignPatientsInitAction',
                url: 'wait/dept/sign/patients',
                blocks: {
                   content: 'content'
                }
             },
            'waitDeptSignInit': {
               xclass: 'iih.mr.wr.mr.action.WaitDeptSignInitAction',
               url: 'waitDeptSign/mrs',
               blocks: {
                  content: 'content'
               }
            },
            'open': {
                xclass: 'iih.mr.wr.mr.action.MrSignOpenAction',
                url: 'startApprove/mr'
            },
            'alreadySignOpen': {
                xclass: 'iih.mr.wr.mr.action.AlreadySignOpenAction'
            }
        },
		   
        chains: {
            'waitSignInit': ['waitSignInit'],
            'alreadySignInit': ['alreadySignInit'],
            'signedPatients': ['signedPatients'],
            'waitDeptSignPatients':['waitDeptSignPatients'],
            'waitDeptSignInit': ['waitDeptSignInit'],
            'open': ['open'],
            'alreadySignOpen': ['alreadySignOpen']
        },
        
        connections: {
            'content': [/*{
                event: 'afterrender',
                chain: 'waitSignInit'
            },*/{
                selector: 'xaptabpanel xapgrid[name=waitPersonSign]',
                event: 'linkClick',
                chain: 'open'
            },{
                selector: 'xaptabpanel xapgrid[name=waitPersonSign]',
                event: 'itemdblclick',
                chain: 'open'
            },{
                selector: 'xaptabpanel xapgrid[name=waitDeptSign]',
                event: 'linkClick',
                chain: 'open'
            },{
                selector: 'xaptabpanel xapgrid[name=waitDeptSign]',
                event: 'itemdblclick',
                chain: 'open'
            },{
                selector: 'xaptabpanel xapgrid[name=alreadySign]',
                event: 'linkClick',
                chain: 'alreadySignOpen'
            },{
                selector: 'xaptabpanel xapgrid[name=alreadySign]',
                event: 'itemdblclick',
                chain: 'alreadySignOpen'
            },{
                selector: 'xapcombobox[name=patient]',
                event: 'change',
                chain: 'alreadySignInit'
            },{
                selector: 'xapcombobox[name=waitDeptSignPatient]',
                event: 'change',
                chain: 'waitSignInit'
            },{//翻页操作
				selector: 'xaptabpanel xapgrid[name=waitPersonSign]',
				event: 'turnpage',
				chain: 'waitSignInit'
			},{//翻页操作
				selector: 'xaptabpanel xapgrid[name=waitDeptSign]',
				event: 'turnpage',
				chain: 'waitSignInit'
			},{//翻页操作
				selector: 'xaptabpanel xapgrid[name=alreadySign]',
				event: 'turnpage',
				chain: 'waitSignInit'
			}]
        }
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
			 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        var chain = this.getActionChain('waitSignInit');
//	        var block = this.getBlock('content');
//	        var pageSize = block.pageSize;
	        if(properties.data == undefined){
	        	 if(chain) {
	            chain.execute({});
	        	}
	        }else{
	        	var pageSize = properties.data.pageSize;
		        var pageNum = properties.data.pageNum;
		        if(chain) {
		            chain.execute({
		            	pageSize:pageSize,
		            	pageNum:pageNum
		            });
		        }
	        }
		});
	}
});