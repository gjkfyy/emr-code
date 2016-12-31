Ext.define('iih.mr.dr.plan.block.PlanInferBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.planinferblock',
	
	buttons:[{
            xtype: "button",
            name: 'save',
            method:'save',
            text: '保存',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],

	items: [{
		xtype: 'xapform',
		name:'defectComplete',
		width:'100%',
		border: 1,
		layout: {
			type: 'table',
			columns: 2,
			tableAttrs: {
	            border: 0,
	            cellpadding: 5,
	            cellspacing: 1,
	            width: '100%',
	            height:'100%'
	        },
	        tdAttrs: {
	            valign: 'left'
	        }
		},
		items:[{
			xtype:'xaptextfield',
			name:'retrievalNm',
			labelAlign : 'right',
			colspan : 2,
			width:300,
			fieldLabel:'检索方案名称'
		},{
			xtype:'xapdisplayfield',
//			name:'ownType',
			labelAlign : 'right',
			fieldLabel:'检索方案所属'
		},{
			xtype: 'xapradiogroup',
			border: 1,
			labelAlign : 'left',
			width:210, 
			method:'inOrOut',
			margin:'0 210 0 -55',
			items: [
				{boxLabel: '全院', name: 'ownTpCd',width:85, inputValue: 'MDM12.01',checked: true},
				{boxLabel: '科室', name: 'ownTpCd', width:85,inputValue: 'MDM12.02'}
			]
		},{
			xtype:'comboxgrid',
			margin:'10 30 10 0',
			name:'deptCd',
			method:'deptCd',
			colspan : 2,
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'检索科室',
			labelAlign : 'right',
			labelWidth : 100,
			listWidth:230,    //gird的宽度
			width:300,        //combo的宽度
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
			columns: [{              //grid的column配置
			   text: '科室编码',
			   dataIndex: 'code',
			   width:80
			},{
			   text: '科室',
			   flex:1,
			   dataIndex: 'name'
			}]/*,
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('plansearchview');
				var initChain = view.getActionChain('init');
				initChain.execute({
					curDeptNm:newValue
				});
		   }*/
		},{
	        xtype:'comboxgrid',
	        margin:'10 30 10 0',
	        name:'responsibleCd',
	        fieldLabel:'负责人',
	        url: 'employee',
			colspan : 2,
	        labelAlign : 'right',
			labelWidth : 100,
			listWidth:230,    //gird的宽度
			width:300, 
	        valueField : 'id',
	        displayField: 'name',
//	        searchParam: {'deptCd': IMER_GLOBAL.department.code},
	        columns: [{
	           text: '人员id',
	           dataIndex: 'id',
	           width:70
	        },{
	           text: '医师姓名',
	           flex:1,
	           dataIndex: 'name'
	        }]/*,
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('plansearchview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					responsibleCd:newValue
				});
			}*/
	    },{
			xtype : 'xaptextarea',
			fieldLabel : '检索方案关键字',
			labelWidth:100,
			colspan : 2,
			labelAlign : 'right',
			padding:'8 0 8 0',
			height:80,
			width: 600,
			name: 'retrievalKey',
			dataIndex : 'retrievalKey'
		},{
			xtype : 'xaptextarea',
			fieldLabel : '备注',
			colspan : 2,
			labelWidth:100,
			labelAlign : 'right',
			padding:'8 0 8 0',
			height:80,
			width: 600,
			name: 'memo',
			dataIndex : 'memo'
		}]
	}],

    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})