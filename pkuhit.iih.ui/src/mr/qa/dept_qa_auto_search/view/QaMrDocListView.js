Ext.define('iih.mr.qa.dept_qa_auto_search.view.QaMrDocListView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.mr.qa.dept_qa_auto_search.block.QaMrDocListBlock'
       
    ],
    
	alias:'widget.qamrdoclistview',
	
	xapConfig: {
		
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.dept_qa_auto_search.block.QaMrDocListBlock'
			}
		},
        actions: {
        	'init': {
				xclass: 'iih.mr.qa.dept_qa_auto_search.action.QaMrDocInitAction',
				url: 'mrs',
				blocks: {
					content: 'content'
				}
            }
        },  
        chains: {
        	'init': ['init']
        },
        connections: {
        	'content': [/*{
                event: 'afterrender',
                chain: 'init'
            }*/]
        }
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
	        var chainTree = this.getActionChain('init');
	        if(chainTree) {
	            chainTree.execute();
	        };
		});
	}
});