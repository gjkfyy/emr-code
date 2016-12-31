Ext.define('iih.mr.kr.csm.view.CSMDisuiteView', {              
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    alias: 'widget.csmdisuiteview',
    id:'csmdisuiteview',
	requires:[
	        
	         'Xap.ej.element.button.Button',
	         'iih.mr.kr.csm.action.CSMDisuiteViewreadyAction',
	         'iih.mr.kr.csm.action.CSMDisuiteCategoryAction',
	         'iih.mr.kr.csm.action.CSMDisuiteEffectAction',
	         'iih.mr.kr.csm.action.CSMDisuiteOpAction',
	         'iih.mr.kr.csm.action.CSMDisuiteSaveAction',
	         'iih.mr.kr.csm.action.CSMDisuiteMrSearchAction',
	         'iih.mr.kr.csm.action.CSMDisuiteDiSearchAction',
	    
	          ],
    xapConfig:{
	 
	     blocks: {
				   'top':{ 
						xclass:'iih.mr.kr.csm.block.CSMDisuiteBlock',
						flex:12
					},
					'bottom':{
	    				xclass: 'Xap.ej.block.ToolbarBlock',
	    				items: [{
	    					xtype: 'xapbutton',
	    					text: '确认',
	    					action: 'confirm',
	    					iconCls: 'icon-OK',
	    					
	    				}, 
	    				{
	    					xtype: 'xapbutton',
	    					text: '取消',
	    					action: 'close',
	    					iconCls: 'icon-cancel' ,
	    					
	    				}]
	    			}
           },
           actions:{
        	   'viewreadyAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteViewreadyAction',
					blocks: {
	       	            topblock: 'top',
	       	            bottomblock:'bottom'
					 }
		       },
		       'categoryAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteCategoryAction',
					url:'/kr/disuite/category/list',
					blocks: {
	       	            topblock: 'top',
	       	            bottomblock:'bottom'
					 }
		       },
		       'categoryEffectAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteEffectAction',
					url:'/kr/disuite/can/create',
					blocks: {
	       	            topblock: 'top',
	       	            bottomblock:'bottom'
					 }
		       },
		       'disuiteOpAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteOpAction',
					blocks: {
	       	            topblock: 'top',
	       	            bottomblock:'bottom'
					 }
		       },
		       'disuiteSaveAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteSaveAction',
					url:'kr/disuite/save',
					blocks: {
	      	            topblock: 'top',
	      	            bottomblock:'bottom'
					 }
	           },
	           'disuiteMrSearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteMrSearchAction',
					url:'/kr/disuite/mrtemplate/list',
					blocks: {
	      	            topblock: 'top',
	      	            bottomblock:'bottom'
					 }
	           },
	           'disuiteDiSearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteDiSearchAction',
					url:'/kr/disuite/diagnosis/list',
					blocks: {
	      	            topblock: 'top',
	      	            bottomblock:'bottom'
					 }
	           }
           },
           chains:{
        	   'viewreadyAction':['viewreadyAction'],
        	   'categoryAction':['categoryAction'],
        	   'categoryEffectAction':['categoryEffectAction'],
        	   'disuiteOpAction':['disuiteOpAction'],
        	   'disuiteSaveAction':['disuiteSaveAction'],
        	   'disuiteDiSearchAction':['disuiteDiSearchAction'],
        	   'disuiteMrSearchAction':['disuiteMrSearchAction'],
           },
           connections:{
        	   'top':[{
        		   selector:'xappanel[action=disute]',
        		   event: 'afterrender',
			       chain: 'viewreadyAction'
        	   }]
        	   
           }
	
      }
})   