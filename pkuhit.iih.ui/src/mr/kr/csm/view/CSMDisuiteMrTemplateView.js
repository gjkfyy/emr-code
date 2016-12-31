Ext.define('iih.mr.kr.csm.view.CSMDisuiteMrTemplateView', {              
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    alias: 'widget.csmdisuitemrtemplateview',
    id:'csmdisuitemrtemplateView',
	requires:[
	        
                 'iih.mr.kr.csm.block.CSMDisuiteMrTemplateBlock',
                 'iih.mr.kr.csm.action.CSMDisuiteMrTemplateOpAction',
                 'iih.mr.kr.csm.action.CSMDisuiteMrTemplateSearchAction',
                
                 
	    
	          ],
    xapConfig:{
	 
	     blocks: {
				   'top':{ 
						xclass:'iih.mr.kr.csm.block.CSMDisuiteMrTemplateBlock',
						flex:12
					},
					'bottom':{
	    				xclass: 'Xap.ej.block.ToolbarBlock',
	    				items: [{
	    					xtype: 'xapbutton',
	    					text: '确认',
	    					iconCls: 'icon-OK',
	    					action: 'confirm',
	    					
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
        	   'mropAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteMrTemplateOpAction',
					blocks: {
	      	            topblock: 'top',
	      	            bottomblock:'bottom'
					 }
	           },
	           'mrsearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDisuiteMrTemplateSearchAction',
					url:'/kr/csa/mrtemplate/list',
					blocks: {
	      	            topblock: 'top',
	      	            bottomblock:'bottom'
					 }
	           }
           },
           chains:{
        	   'mropAction':['mropAction'],
        	   'mrsearchAction':['mrsearchAction'],
        	   'disuiteSaveAction':['disuiteSaveAction'],
           },
           connections:{
        	   'bottom':[{
        		   selector:'xapbutton[action=confirm]',
   				   event: 'click',
   				   chain: 'mropAction'
        	   },{
        		   selector:'xapbutton[action=close]',
   				   event: 'click',
   				   chain: 'mropAction'
        	   }],
        	   'top':[{
        		   selector:'xapgrid[action=mrgrid]',
   				   event: 'afterrender',
   				   chain: 'mrsearchAction'
        	   }]
        	
           }
	
      }
})   