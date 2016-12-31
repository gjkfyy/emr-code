Ext.define('iih.mr.kr.csa.block.CSADiAndMrTemplateBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: ['Xap.ej.element.grid.Grid'],
	alias:'widget.csadiandmrtemplateblock',
	id:'csaDiAndMrTemplateBlock',
	//layout: 'fit',
	border: 0,
    items:  [{
    	
	      xtype: 'xapgrid',
	      action:'digrid',
	      height:227,
	      title:'诊断',
		  autoScroll:true,
		  checkboxShow:true,
		  mode:'multi',
		  showHeaderCheckbox:true,
		  CM_JR_Record:[
	             {header: '诊断编码', dataIndex: 'diCode',hidden:true},
	             {header: '诊断主键', dataIndex: 'diSuiteDiCode',hidden:true},
	             {header: '所属类型', dataIndex: 'ownerType',hidden:true},
	             {header: '所属编码', dataIndex: 'ownerCode',hidden:true},
	             {header: '诊断(模板)', dataIndex: 'diName',width:250},
	             {header: 'ICD编码', dataIndex: 'icdCode',width:100}
		    ]
    },{

          xtype: 'xapgrid',
          action:'mrgrid',
          title:'模板',
          height:200,
          mode:'multi',
	  	  autoScroll:true,
	  	  CM_JR_Record:[
				{header: '模板ID', dataIndex: 'mrTemplateCode',hidden:true},
				{header: '病历模板', dataIndex: 'mrTemplateName',width:250},
				{header: '病历类型编码', dataIndex: 'mrTypeCode',hidden:true},
				{header: '文件编码', dataIndex: 'filePk',hidden:true},
				{header: '所属编码', dataIndex: 'ownerCode',width:100,hidden:true},
				{header: '所属类型', dataIndex: 'ownerType',width:100,hidden:true},
				{header: '所属分类', dataIndex: 'ownerTypeName',width:100,hidden:false},
	            {header: '所属', dataIndex: 'ownerName',width:100,hidden:false},
	  	    ]
    
    }]
  
})
