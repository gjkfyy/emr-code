Ext.define('iih.mr.kr.csa.view.CSAKRView', {              
    extend: 'Xap.ej.stl.view.LeftRightContainerTemplate',
    alias: 'widget.csakrview',
    id:'csakrview',
	requires:[
	          'iih.mr.kr.csa.block.CSATreeBlock',
	          'iih.mr.kr.csa.block.CSADiAndMrTemplateBlock',
	          'iih.mr.kr.csa.action.CSASearchAction',
	          'iih.mr.kr.csa.action.CSARadioChangeAction',
	          'iih.mr.kr.csa.action.CSAMrTemplateSearchAction',
	          'iih.mr.kr.csa.action.CSADiagnosisSearchAction',
	          'iih.mr.kr.csa.action.CSAAdminDeptListAction',
	          'iih.mr.kr.csa.action.CSAViewreadyAction',
	          'iih.mr.kr.csa.action.CSASysdateAction',
	          'iih.mr.kr.csa.action.CSATreeItemClickAction',
	          'iih.mr.kr.csa.action.CSAForAdminSearchAction',
	          'iih.mr.kr.csa.action.InitMrPropertyAction',
	          'iih.mr.kr.csa.action.CSAForAdminChangeAction'
	          ,'iih.mr.kr.csa.action.mrDbClickAction'
	          ],
    xapConfig:{
	 
	     blocks: {
			   'left':{ 
					xclass:'iih.mr.kr.csa.block.CSATreeBlock',
					width:230	
		       },
		       'right':{ 
					xclass:'iih.mr.kr.csa.block.CSADiAndMrTemplateBlock'
		       },
           },
         actions:{
        	   'csasearchAction': {
					xclass: 'iih.mr.kr.csa.action.CSASearchAction',
					url:'/kr/disuite',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaForAdminsearchAction': {
					xclass: 'iih.mr.kr.csa.action.CSAForAdminSearchAction',
					url:'/kr/disuite/admin',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaradioChangeAction': {
					xclass: 'iih.mr.kr.csa.action.CSARadioChangeAction',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaDiagnosisSearchAction': {
					xclass: 'iih.mr.kr.csa.action.CSADiagnosisSearchAction',
					url:'/kr/disuite/diagnosis/list',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaMrSearchAction': {
					xclass: 'iih.mr.kr.csa.action.CSAMrTemplateSearchAction',
					url:'/kr/disuite/mrtemplate/list',
					blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaAdminDeptListAction':{
		    	   xclass:'iih.mr.kr.csa.action.CSAAdminDeptListAction',
		    	   url:'kr/disuite/admin/deptlist',
		    	   blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaViewReadyAction':{
		    	   xclass:'iih.mr.kr.csa.action.CSAViewreadyAction',
		    	   blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaSysdateAction':{
		    	   xclass:'iih.mr.kr.csa.action.CSASysdateAction',
		    	   url:'/kr/csa/sysdate',
		    	   blocks: {
	        	        leftblock: 'left',
						rightblock:'right'
					 }
		       },
		       'csaTreeItemClickAction': {
					xclass: 'iih.mr.kr.csa.action.CSATreeItemClickAction',
					blocks: {
			    	    leftblock: 'left',
						rightblock:'right'
					}
			   },
			   'csaForAdminChangeAction': {
					xclass: 'iih.mr.kr.csa.action.CSAForAdminChangeAction',
					blocks: {
			    	    leftblock: 'left',
						rightblock:'right'
					}
			   },
			   'initMrProperty': {
					xclass: 'iih.mr.kr.csa.action.InitMrPropertyAction',
					blocks: {
			    	    leftblock: 'left',
						rightblock:'right'
					}
			   }
			   ,'mrDbClickAction':{
				   xclass: 'iih.mr.kr.csa.action.mrDbClickAction',
					blocks: {
			    	    leftblock: 'left',
						rightblock:'right'
					}
			   }
           },
           chains:{
        	   'csasearchAction':['csasearchAction'],
        	   'csaradioChangeAction':['csaradioChangeAction'],
        	   'initMrProperty':['initMrProperty'],
        	   'csaDiagnosisSearchAction':['csaDiagnosisSearchAction'],
        	   'csaMrSearchAction':['csaMrSearchAction'],
        	   'csaAdminDeptListAction':['csaAdminDeptListAction'],
        	   'csaViewReadyAction':['csaViewReadyAction'],
        	   'csaSysdateAction':['csaSysdateAction'],
        	   'csaTreeItemClickAction':['csaTreeItemClickAction'],
        	   'csaForAdminsearchAction':['csaForAdminsearchAction'],
        	   'csaForAdminChangeAction':['csaForAdminChangeAction']
        	   ,'mrDbClickAction':['mrDbClickAction']
           },
           connections:{
        	   'left':[/*{
        		          selector:'xapbutton[action=searchBtn]',
   				          event: 'click',
   				          chain: 'csasearchAction'
	        	   },{
	        		   
	        		      selector:'radio[action=ownerTypeDept]',
				          event: 'change',
				          chain: 'csaradioChangeAction'
	        	   },{
	        		      selector:'radio[action=ownerTypePerson]',
				          event: 'change',
				          chain: 'csaradioChangeAction'
	        	   },*/{
	        		   selector:'xapradio[name=ownerType]',
	        		   event: 'change',
				       chain: 'csaradioChangeAction'
	        	   },{
	  				 selector: 'treepanel',
					 event: 'viewready',
					 chain: 'csaViewReadyAction'
				 },{
					    selector:'treepanel',
	    				event: 'itemclick',
	    				chain: 'csaTreeItemClickAction'
				 }/*,{
					    selector:'xapcombobox[action=dept]',
	    				event: 'change',
	    				chain: 'csaForAdminChangeAction'
				 }*/],
				 'right':[{
		        		   selector:'xapgrid[action=mrgrid]',
		        		   event: 'itemclick',
					       chain: 'initMrProperty'
		        	   },
		        	   {
		        		   selector:'xapgrid[action=mrgrid]',
		        		   event: 'itemdblclick',
					       chain: 'mrDbClickAction'
		        	   }
		        	   ]
           }
	
      }
})   