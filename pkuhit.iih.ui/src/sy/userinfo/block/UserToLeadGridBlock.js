Ext.define('iih.sy.userinfo.block.UserToLeadGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [
	   		'Xap.ej.element.grid.Grid'
	   	],

	alias:'widget.usertoleadgridblock',

    items:  [{
//       title: '用户列表',
       xtype:'xapgrid',
       pageShow : true,
       selType:'checkboxmodel',
  CM_JR_Record: [      
                { header: '人员ID', dataIndex: 'empId',field: 'textfield',type: 'string',flex:1},
                { header: '姓名', dataIndex: 'nm',field: 'textfield',type: 'string',flex:1 },
                { header: '性别', dataIndex: 'sexCd',field: 'textfield',type: 'string',flex:1 },
                { header: '行政科室', dataIndex: 'execDeptCd' ,field: 'textfield',type: 'string',flex:1},
                { header: '职称', dataIndex: 'occupationNm' ,field: 'textfield',type: 'string',flex:1}
        ],
   gridData:{
   	 'results':[
                   { 'empId': '1001', "nm":"李时珍", "sexCd":"男", "execDeptCd":"消化内科", "occupationNm":"住院医生" },
                   { 'empId': '1002', "nm":"华佗", "state":"男", "execDeptCd":"骨科" , "occupationNm":"住院医生" },
                   { 'empId': '1003', "nm":"孙思邈", "sexCd":"女", "execDeptCd":"骨伤科", "occupationNm":"住院医生"  }
               ]
}
    },{
    	xtype: 'xapform',
		width:'100%',
		dockedItems: [{
		    xtype: 'toolbar',
		    dock: 'bottom',
		    layout: {
				type: 'hbox',
				pack: 'end'
			},
		    items: [
		        { xtype: 'xapbutton', text: '导入',name: 'toLead',method: 'toLead'}
		    ]
		}]
	}] ,                   
        setData: function(data) {
        	if(data){
        		var grid = this.down('xapgrid');
    			grid.setData(data);
        	}
    	}               
})
