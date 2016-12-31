Ext.define('iih.mr.kr.csm.block.CSMShareBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [],
	alias:'widget.csmshareBlock',
	border: 0,
    items:  [{
    	    xtype: "xapcombobox",
		    action:'dept',
		    fieldLabel:'待共享科室',
		    labelAlign:'right',
		    disabled:false,
		    padding:'10 0 5 0',
    },{
    	 xtype: 'xapgrid',
         action:'deptgrid',
         checkboxShow:true,
         title:'共享科室',
         height:330,
         mode:'multi',
         selectBy:'checked',
	  	 autoScroll:true,
	  	 CM_JR_Record:[
	               {header: '共享科室', dataIndex: 'checked',hidden:true},
	               {header: '科室编码', dataIndex: 'deptCode',hidden:true},
	               {header: '科室名称', dataIndex: 'deptName',width:200}
	  	    ]
    }]
  
})
