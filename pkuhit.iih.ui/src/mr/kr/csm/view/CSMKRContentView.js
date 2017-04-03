Ext.define('iih.mr.kr.csm.view.CSMKRContentView', {              
    extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',
    alias: 'widget.csmkrcontentview',
    id:'csmkrcontentview',
	requires:[
	          'iih.mr.kr.csm.block.CSMTreeBlock',
	          'iih.mr.kr.csm.block.CSMDiAndMrTemplateBlock',
	          'iih.mr.kr.csm.action.CSMSearchAction',
	          'iih.mr.kr.csm.action.CSMMrTemplateSearchAction',
	          'iih.mr.kr.csm.action.CSMDiagnosisSearchAction',
	          'iih.mr.kr.csm.action.CSMAdminDeptListAction',
	          'iih.mr.kr.csm.action.CSMTreeItemClickAction',
	          'iih.mr.kr.csm.action.CSMForAdminSearchAction',
	          'iih.mr.kr.csm.action.CSMEventAction',
	          'iih.mr.kr.csm.action.CSMBtnOpAction',
	          'iih.mr.kr.csm.action.CSMDisuiteDelAction'
	          ],
    xapConfig:{
	 
	     blocks: {
			   'left':{ 
					xclass:'iih.mr.kr.csm.block.CSMTreeBlock',
					width:260
		       },
		       'right':{ 
					xclass:'iih.mr.kr.csm.block.CSMDiAndMrTemplateBlock'
		       }
           },
         actions:{
        	   'csmsearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMSearchAction',
					url:'/kr/disuite',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csmForAdminsearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMForAdminSearchAction',
					//url:'/kr/disuite/admin', //加载分类
					url:'/kr/disuite',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		  
		       'csmDiagnosisSearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMDiagnosisSearchAction',
					url:'/kr/disuite/diagnosis/list',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csmMrSearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMMrTemplateSearchAction',
					url:'/kr/disuite/mrtemplate/list',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csmAdminDeptListAction':{
		    	   xclass:'iih.mr.kr.csm.action.CSMAdminDeptListAction',
		    	   url:'kr/disuite/admin/deptlist',
		    	   blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		     

		       'csmTreeItemClickAction': {
					xclass: 'iih.mr.kr.csm.action.CSMTreeItemClickAction',
					blocks: {
			    	    leftblock: 'left',
						rightblock:'right'
					}
			   },
			   'csmEventAction': {
					 xclass: 'iih.mr.kr.csm.action.CSMEventAction',
					 blocks: {
				    	    leftblock: 'left',
							rightblock:'right'
						}
				},
				'csmBtnOpAction': {
					 xclass: 'iih.mr.kr.csm.action.CSMBtnOpAction',
					 blocks: {
				    	    leftblock: 'left',
							rightblock:'right'
						}
				} ,
				'csmdisuiteDelAction': {
					 xclass: 'iih.mr.kr.csm.action.CSMDisuiteDelAction',
					 url:'/kr/disuite/delete',
					 blocks: {
				    	    leftblock: 'left',
							rightblock:'right'
						}
				} 
           },
           chains:{
        	   'csmsearchAction':['csmsearchAction'],
        	   'csmDiagnosisSearchAction':['csmDiagnosisSearchAction'],
        	   'csmMrSearchAction':['csmMrSearchAction'],
        	   'csmAdminDeptListAction':['csmAdminDeptListAction'],
        	   'csmTreeItemClickAction':['csmTreeItemClickAction'],
        	   'csmForAdminsearchAction':['csmForAdminsearchAction'],
        	   'csmEventAction':['csmEventAction'],
        	   'csmBtnOpAction':['csmBtnOpAction'],
        	   'csmdisuiteDelAction':['csmdisuiteDelAction']
           },
           connections:{
        	   'left':[{
		        		   selector:'xapradio[name=ownerType]',
		        		   event: 'change',
					       chain: 'csmEventAction'
	        	     },{
			  				 selector: 'treepanel',
							 event: 'viewready',
							 chain: 'csmEventAction'
					 },{
						    selector:'treepanel',
		    				event: 'itemclick',
		    				chain: 'csmTreeItemClickAction'
					 },{
						    selector:'xapcombobox[action=dept]',
		    				event: 'change',
		    				chain: 'csmForAdminsearchAction'
					 },{
							  selector:'xapcombobox[action=dept]',
			  				  event : 'afterrender',
			  				  chain: 'csmAdminDeptListAction'
					 }],
			  	'right':[{
			  		  selector:'xapbutton[action=insertBtn]',
	  				  event : 'click',
	  				  chain: 'csmBtnOpAction'
			  	},{
			  		 selector:'xapbutton[action=modefiyBtn]',
	  				  event : 'click',
	  				  chain: 'csmBtnOpAction'
			  	},{
			  		 selector:'xapbutton[action=delBtn]',
	  				  event : 'click',
	  				  chain: 'csmBtnOpAction'
			  	},{
			  		 selector:'xapbutton[action=shareBtn]',
	  				  event : 'click',
	  				  chain: 'csmBtnOpAction'
			  	}]	 
           }
	
      }
})   