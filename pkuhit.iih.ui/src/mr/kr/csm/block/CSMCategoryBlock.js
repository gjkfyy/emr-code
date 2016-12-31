Ext.define('iih.mr.kr.csm.block.CSMCategoryBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [
	           'Xap.ej.element.grid.Grid',
	           'Xap.ej.element.field.Radio',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.tree.FilterTree'
	           ],
	alias:'widget.csmcategoryblock',
	border: 0,
    items:  [{

    	xtype:'xappanel',
    	border:0,
    	padding:'5 0 5 0',
    	layout : {
    		type: 'hbox',
    		 align : 'stretch',
    		 pack: 'center'
    		
    	},
	    items:[{
	    	 xtype:'xapradio',
	    	 boxLabel: '科室', 
	    	 action: 'ownerTypeDept', 
	    	 inputValue: 'MDM08.02',
	    	 name:'ownerType',
	    	 checked:true,
	    	 padding:'0 20 0 0',
	    	 val:true,
	    	
	        
	    },{
	    	xtype: "xapcombobox",
			action:'dept',
			disabled:false
	    },{
	    	 xtype:'xapradio',
	    	 boxLabel: '个人', 
	    	 action: 'ownerTypePerson', 
	    	 inputValue: 'MDM08.03',
	    	 name:'ownerType',
	    	 padding:'0 0 0 20',
	    	 val:false,
	    },{
	    	 xtype:'xaptextfield',
	    	 fieldLabel: '组套分类', 
	    	 action: 'categoryNm', 
	    	 padding:'0 0 0 20',
	    },{
	    	 xtype: 'label',
             width: 20
	    },{
	    	xtype: 'xapbutton',
			text: '新增',
			action: 'insertBtn',
			iconCls: 'icon-Create',
			
	    },{
	    	  xtype: 'label',
              width: 10
	    },{
	    	xtype: 'xapbutton',
			text: '删除',
			action: 'delBtn',
			iconCls: 'icon-Delete',
			
	    }]
    
    },{
    	 xtype: 'xapgrid',
         action:'categorygrid',
         checkboxShow:true,
         title:'模板',
         height:300,
         mode:'multi',
	  	  autoScroll:true,
	  	  CM_JR_Record:[
	               {header: '自定义分类编码', dataIndex: 'diSuiteTpCd',hidden:true},
	               {header: '组套分类名称', dataIndex: 'diSuiteTpNm',width:200},
	               {header: '所属分类', dataIndex: 'ownerTypeName',width:100,hidden:false},
	               {header: '所属', dataIndex: 'ownerName',width:100,hidden:false},
	            
	  	    ]
    }]
  
})
