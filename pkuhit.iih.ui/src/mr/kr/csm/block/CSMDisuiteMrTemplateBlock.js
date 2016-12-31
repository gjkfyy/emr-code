Ext.define('iih.mr.kr.csm.block.CSMDisuiteMrTemplateBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: ['Xap.ej.element.grid.Grid'],
	alias:'widget.csmdisuitemrtemplateblock',
	//layout: 'fit',
	border: 0,
    items:  [{

          xtype: 'xapgrid',
          action:'mrgrid',
          title:'模板',
          height:350,
	  	  autoScroll:true,
	  	  mode:'multi',
		  checkboxShow:true,
	  	  CM_JR_Record:[
	               {header: '模板ID', dataIndex: 'mrTemplateCode',hidden:true},
	               {header: '病历模板', dataIndex: 'mrTemplateName',width:200},
	               {header: '所属编码', dataIndex: 'ownerCode',width:100,hidden:true},
	               {header: '所属类型', dataIndex: 'ownerType',width:100,hidden:true},
	               {header: '所属分类', dataIndex: 'ownerTypeName',width:100,hidden:false},
	               {header: '所属', dataIndex: 'ownerName',width:100,hidden:false},
	  	    ]
    
    }]
  
})
