Ext.define('iih.sy.search.block.HistorySaveBlock',{
	 extend : 'Xap.ej.block.FormBlock',
	    
	    requires: [
	               ],

	    alias:'widget.historysaveblock',
	    id:'historysaveblock',
	    
		layout : {
			type : 'fit'
		},
	    border:false,
		buttons:[{
	            xtype: "button",
	            name: 'confim',
	            method:'confim',
	            text: '确认',
	            disable:true,
	            iconCls: 'icon-OK'
	        },{
	            xtype: "button",
	            name: 'cancel',
	            method:'cancel',
	            text: '取消' ,
	            iconCls: 'icon-cancel' 
	    }],
	    items:[{
	        layout: 'table',
	        columns: 2,
	        border:false,
	        items:[{
	            xtype: 'xaptextfield',
	            padding:'10 0 0 10',
	            name:'conditionData',
	            labelWidth:150,
	            colspan: 2,
	            width:380,
	            fieldLabel:'为本次搜索设置名称保存'
	        }]
	    }]
	})