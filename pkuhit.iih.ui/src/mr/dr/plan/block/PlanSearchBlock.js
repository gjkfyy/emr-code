Ext.define('iih.mr.dr.plan.block.PlanSearchBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.plansearchblock',
	
	border: 0,

	items: [{
		xtype: 'xapform',
	layout: {
		type: 'table',
		columns: 3,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%',
            height:86
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items:[{
		xtype:'xaptextfield',
        name:'retrievalNm',
        labelWidth:100,
        labelAlign:'right',
        margin:'0 0 10 10',
        fieldLabel:'检索方案名称',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('plansearchview');
					var initChain = view.getActionChain('search');
					initChain.execute({}); 
                }  
            }
        }
	},{
		xtype: 'xapradiogroup',
		border: 1,
	    fieldLabel:'方案所属',
	    labelAlign : 'right',
		method:'inOrOut',
		margin:'0 0 0 5',
		items: [
			{boxLabel: '全院', name: 'ownTpCd',width:85, inputValue: 'MDM08.01'/*,checked: true*/},
			{boxLabel: '科室', name: 'ownTpCd', width:85,inputValue: 'MDM08.02'}
		]
	},{
	        xtype:'comboxgrid',
	        margin:'10 70 10 0',
	        name:'responsibleCd',
	        fieldLabel:'负责人',
	        url: 'employee',
	        labelAlign : 'right',
			labelWidth : 60,
			listWidth:230,    //gird的宽度
			width:210, 
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
					crtUserNm:newValue
				});
			}*/
	    },{
			xtype:'xaptextfield',
	        name:'retrievalKey',
	        labelWidth:100,
	        labelAlign:'right',
	        margin:'0 0 10 10',
	        fieldLabel:'检索关键字',
	        listeners:{
	        	specialkey : function(field, e) {  
	                if (e.getKey() == Ext.EventObject.ENTER) {  
	                    var view = this.up('plansearchview');
						var initChain = view.getActionChain('search');
						initChain.execute({}); 
	                }  
	            }
	        }
		},{
			xtype:'comboxgrid',
			margin:'10 0 10 45',
			name:'deptCd',
			method:'deptCd',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'检索科室',
			labelAlign : 'right',
			labelWidth : 60,
			listWidth:230,    //gird的宽度
			width:210,        //combo的宽度
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
			}],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('plansearchview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					curDeptNm:newValue
				});
			   }
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		}]
	}]
})