Ext.define('iih.po.assistant.block.MrKnowledgeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: ['Xap.ej.element.grid.Grid',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.field.CustomTrigger'],
	           
	alias:'widget.MrKnowledgeBlock',
	
	header:false,
	    
	items:[{		 
    	xtype:'panel',
    	tbar:[/*{
	    	xtype: 'xapcheckboxgroup',
			method:'checkFlag',
			width:100,
			vertical: true,
			items: [
				{ boxLabel: '个人', name: 'ownerTypeCd', inputValue: 'MDM12.03',checked: true},
				{ boxLabel: '科室', name: 'ownerTypeCd', inputValue: 'MDM12.02'}
			]
	    }*/{
		        xtype: 'xapcheckbox',
		        padding:'0 0 0 5',
		        name:'personal',
		        vertical: true,
		        boxLabel: '个人', 
		        inputValue: 'MDM12.03',
		        checked:true
		    },{
		        xtype: 'xapcheckbox',
		        padding:'0 0 0 5',
		        name:'dept',
		        vertical: true,
		        boxLabel: '科室',
		        inputValue: 'MDM12.02'
		    },{           
	            xtype: "xaptrigger",
	            name: 'fragmentTplNm',
                triggerBaseCls :'x-text-trigger', 
	            width:140,
	            margin: '0 2 0 2',
	            emptyText: "输入名称按回车检索"    
		    }	
    	],
		items:[{
           xtype:'xapgrid',
           name:'knoeledgeteGrid',
           height:240,
           ifSelect : true,
           selectBy: 'fragmentTplCd',
           CM_JR_Record: [
               {header: '个人知识库编码',dataIndex: 'fragmentTplCd',hidden:true},
               {header: '类别id',dataIndex: 'fragmentTplTypeCd',hidden:true},
               {header: '类别',dataIndex: 'fragmentTplTypeNm',field: 'textfield',type: 'string',width:60},
               {header: '名称',dataIndex: 'fragmentTplNm',field: 'textfield',type: 'string',width:115},
               {dataIndex: 'fragmentTplContent',hidden:true},
               {header: '所属',dataIndex: 'ownerTypeCd',field: 'textfield',type: 'string',width:80}
			]
       }]
	}],   
	
	setData: function(data) {	
		var grid = this.down('xapgrid');
	    grid.setData(data);
	}    
})