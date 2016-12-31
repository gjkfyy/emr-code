Ext.define('iih.mr.kr.csm.view.CSMCategoryView',{
    extend : 'Xap.ej.template.BaseTemplate',
	alias:'widget.csmcategoryView',
	id:'csmcategoryView',
	requires:[
	          'iih.mr.kr.csm.block.CSMCategoryBlock',
	          'iih.mr.kr.csm.action.CSMCategoryAdminDeptListAction',
	          'iih.mr.kr.csm.action.CSMCategorySearchAction',
	          'iih.mr.kr.csm.action.CSMCategoryInsertAction',
	          'iih.mr.kr.csm.action.CSMCategoryDelAction',
	          'iih.mr.kr.csm.action.CSMCategoryForAdminSearchAction',
	          'iih.mr.kr.csm.action.CSMCategoryEventAction'
	   ],
	
	xapConfig:{
	
		blocks: {
			   'content':{
				   xclass: 'iih.mr.kr.csm.block.CSMCategoryBlock'
			   }
		  },
		actions:{
			  'categoryAdminDeptListAction': {
				xclass: 'iih.mr.kr.csm.action.CSMCategoryAdminDeptListAction',
				url:'/kr/disuite/admin/deptlist',
				blocks: {
			         content:'content'
				 }
	          },
	          'categorySearchAction': {
					xclass: 'iih.mr.kr.csm.action.CSMCategorySearchAction',
					url:'/kr/disuite/category/list',
					blocks: {
				         content:'content'
					 }
		        },
		       'categoryInsertAction': {
					xclass: 'iih.mr.kr.csm.action.CSMCategoryInsertAction',
					url:'/kr/disuite/category/create',
					blocks: {
				         content:'content'
					 }
		         },
		         'categoryDelAction': {
						xclass: 'iih.mr.kr.csm.action.CSMCategoryDelAction',
						url:'/kr/disuite/category/delete',
						blocks: {
					         content:'content'
						 }
			         },
			    'categoryForAdminsSearchction': {
					    xclass: 'iih.mr.kr.csm.action.CSMCategoryForAdminSearchAction',
					    url:'/kr/disuite/category/list',
						blocks: {
						         content:'content'
							 }
				        },
				  'categoryEventAction': {
						 xclass: 'iih.mr.kr.csm.action.CSMCategoryEventAction',
					     blocks: {
							         content:'content'
								 }
					        }       
		  },
		 chains:{
			  'categoryAdminDeptListAction':['categoryAdminDeptListAction'],
			  'categorySearchAction':['categorySearchAction'],
			  'categoryInsertAction':['categoryInsertAction'],
			  'categoryDelAction':['categoryDelAction'],
			  'categoryForAdminsSearchction':['categoryForAdminsSearchction'],
			  'categoryEventAction':['categoryEventAction'],
		  },
		 connections:{
			  'content':[{
				  selector:'xapcombobox[action=dept]',
  				  event: 'afterrender',
  				  chain: 'categoryAdminDeptListAction'
			  },{
				  selector:'xapgrid[action=categorygrid]',
  				  event: 'afterrender',
  				  chain: 'categoryEventAction'
			  },{
				  selector:'xapbutton[action=insertBtn]',
  				  event: 'click',
  				  chain: 'categoryInsertAction'
			  },{
				  selector:'xapbutton[action=delBtn]',
  				  event: 'click',
  				  chain: 'categoryDelAction'
			  },{
				  selector:'xapradio[name=ownerType]',
  				  event: 'change',
  				  //chain: 'categorySearchAction'
  				  chain:'categoryEventAction'
			  },{
				  selector:'xapcombobox[action=dept]',
  				  event: 'change',
  				  chain: 'categoryForAdminsSearchction'
			  }]
		  }
    }
})