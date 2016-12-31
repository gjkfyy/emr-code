Ext.define('iih.mr.kr.csm.block.CSMDiAndMrTemplateBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: ['Xap.ej.element.grid.Grid'],
	alias:'widget.csmdiandmrtemplateblock',
	//layout: 'fit',
	border: 0,
    items:  [{
    	  
    	  xtype:'xaptoolbarblock',
    	  layout: {
    			type: 'hbox',
    			pack: 'left'
    		},
    	  items:[{
    		    xtype: 'xapbutton',
				text: '新建组套',
				action: 'insertBtn',
				iconCls: 'icon-Create',
    	  },{
    		    xtype: 'xapbutton',
				text: '修改',
				action: 'modefiyBtn',
				iconCls: 'icon-Open'
    	  },{
    		    xtype: 'xapbutton',
				text: '删除',
				action: 'delBtn',
				iconCls: 'icon-Delete',
				
    	  },{
    		     xtype: 'xapbutton',
				text: '共享',
				action: 'shareBtn',
				iconCls: 'icon-Property',
    	  }]
    },{
    	
	      xtype: 'xapgrid',
	      action:'digrid',
	      height:260,
	      title:'诊断',
		  autoScroll:true,
		  //checkboxShow:true,
		  mode:'multi',
		  showHeaderCheckbox:true,
		  CM_JR_Record:[
	             {header: '诊断编码', dataIndex: 'diCode',hidden:true},
	             {header: '诊断主键', dataIndex: 'diSuiteDiCode',hidden:true},
	             {header: '所属类型', dataIndex: 'ownerType',hidden:true},
	             {header: '所属编码', dataIndex: 'ownerCode',hidden:true},
	             {header: '诊断(模板)', dataIndex: 'diName',width:200},
	             {header: 'ICD编码', dataIndex: 'icdCode',width:100}
		    ]
    },{

          xtype: 'xapgrid',
          action:'mrgrid',
          title:'模板',
          height:300,
	  	  autoScroll:true,
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
