Ext.define('iih.mr.kr.csm.view.CSMShareView', {              
    extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    alias: 'widget.csmshareView',
    id:'csmshareView',
	requires:[
	          'iih.mr.kr.csm.block.CSMShareBlock',
	          'iih.mr.kr.csm.action.CSMShareViewreadyAction',
	          'iih.mr.kr.csm.action.CSMShareDeptAction',
	          'iih.mr.kr.csm.action.CSMShareSaveAction'
	          ],
    xapConfig:{
	 
	     blocks: {
				   'top':{ 
						xclass:'iih.mr.kr.csm.block.CSMShareBlock',
						flex:12
					},
					'bottom':{
	    				xclass: 'Xap.ej.block.ToolbarBlock',
	    				items: [{
	    					xtype: 'xapbutton',
	    					text: '确认',
	    					action: 'confirm',
	    					iconCls: 'icon-cancel' ,
	    					
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
        	   'shareviewreadyAction': {
				    xclass: 'iih.mr.kr.csm.action.CSMShareViewreadyAction',
					blocks: {
	        	          topblock: 'top',
	  	                  bottomblock:'bottom'
					 }
	          },
	          'shareDeptAction': {
				    xclass: 'iih.mr.kr.csm.action.CSMShareDeptAction',
				    url:'/kr/disuite/share/view',
					blocks: {
	        	          topblock: 'top',
	  	                  bottomblock:'bottom'
					 }
	          },
	          'shareSaveAction': {
				    xclass: 'iih.mr.kr.csm.action.CSMShareSaveAction',
				    url:'/kr/disuite/share/save',
					blocks: {
	        	          topblock: 'top',
	  	                  bottomblock:'bottom'
					 }
	          }
           },
           chains:{
        	   'shareviewreadyAction':['shareviewreadyAction'],
        	   'shareDeptAction':['shareDeptAction'],
        	   'shareSaveAction':['shareSaveAction'],
           },
           connections:{
        	   'top':[{
        		   selector:'xapcombobox[action=dept]',
        		   event: 'afterrender',
			       chain: 'shareviewreadyAction'
        	   }]
           }
	
      }
})   