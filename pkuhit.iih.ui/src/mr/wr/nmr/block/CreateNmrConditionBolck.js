Ext.define('iih.mr.wr.nmr.block.CreateNmrConditionBolck',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.grid.column.ActionColumn',
		'Xap.ej.element.grid.Grid',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.field.TextField',
        'Xap.ej.element.radiogroup.RadioGroup',
        'Xap.ej.element.checkboxgroup.CheckboxGroup'
	],

	alias:'widget.createnmrconditionbolck',
	
	layout: {
        type: 'table',
        columns: 9
    },
	items: [{
        xtype:'xapcombobox',
        name:'mrCategoryCode',
        colspan: 3,
        padding:'10 0 0 15',
        margin : '0 0 0 3',
        labelWidth:100,
        width:245,
        editable:false,
        id:'nmrCategoryCode',
        //allOptions: true,
        fieldLabel:'护理文书类型组',
        queryMode: 'local',
//        comboData : [
//         			{"value":"QAM06.02", "name":"一般患者护理记录单"},
//         			{"value":"QAM06.05", "name":"危重患者护理记录单"},
//         			{"value":"QAM06.04", "name":"特殊护理记录单"}
//         		],
        displayField: 'name',
        valueField: 'code'
    },{
        xtype:'xapcombobox',
        name:'typeCode',
        padding:'10 0 0 20',
        labelWidth:80,
        width:260,
        colspan: 3,
        value:'ALL',
        editable:false,
        allOptions: true,
        fieldLabel:'护理文书类型',
        queryMode: 'local',
        displayField: 'name',
        valueField: 'code'
    },{
        xtype: 'xaptextfield',
        padding:'10 0 0 10',
        name:'templateNm',
        labelWidth:80,
        colspan: 3,
        width:220,
        fieldLabel:'模板名称',
        listeners : {
			specialkey : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					var view = this.up('createdocview');
					var initChain = view.getActionChain('init');
					initChain.execute({});
				}
			}
		}
    },{
        xtype: 'xapcheckboxgroup',
        padding:'10 0 0 15',
        name:'personal',
        vertical: true,
        items: [
            { boxLabel: '个人', name: 'personal', inputValue: 'MDM08.03' ,checked:true}
        ]
    },{
        xtype: 'xapcheckboxgroup',
        padding:'10 0 0 10',
        name:'dept',
        vertical: true,
        items: [
            { boxLabel: '护区', name: 'dept', inputValue: 'MDM08.02',checked:true}
        ]
    },{
	      xtype:'comboxgrid',
	      name:'deptCode',
		  url: 'organization/keyword',//科室查询的url
		  listWidth:210,    //gird的宽度
		  width:140,        //combo的宽度
		  valueField : 'code',//科室编码的字段名
		  displayField: 'name',//科室名称的字段名
		  padding:'10 0 0 0',
		  columns: [{              //grid的column配置
			 text: '科室编码',
			 dataIndex: 'code',
			 width:60
		  },{
			 text: '科室',
			 flex:1,
			 dataIndex: 'name'
		  }],
		  callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
		  	  var owner=this.ownerCt.ownerCt;
		      var chain = owner.getActionChain('init');
		      if(chain) {
		          chain.execute({
		          	 newValue:newValue
		          });
		      }
		  }
     },{
        xtype: 'xapcheckboxgroup',
        padding:'10 0 0 10',
        margin : '0 0 0 5',
        name:'all',
        vertical: true,
        items: [
            { boxLabel: '全院', name: 'all', inputValue: 'MDM08.01',checked:true }
        ]
    }]
});