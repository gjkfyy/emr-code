Ext.define('iih.mr.qa.qa_apply.block.QaApplySearchBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.qaapplysearchblock',
	
	border: 0,

	items: [{
	xtype: 'xapform',
	layout: {
		type: 'table',
		columns: 4,
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
	        name:'enPk',
	        labelWidth:60,
	        labelAlign:'right',
	        margin:'0 0 10 0',
	        fieldLabel:'就诊序号'
		},{
	        xtype:'comboxgrid',
//	        margin:'10 100 10 150',
	        name:'dctNm',
	        fieldLabel:'医师姓名',
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
	        }],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('qaapplylistview');
				var initChain = view.getActionChain('init');
				initChain.execute({
					crtUserNm:newValue
				});
			   }
	    },{
			xtype:'comboxgrid',
//			margin:'10 70 10 0',
			name:'curDeptNm',
			method:'curDeptNm',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'病人所在科室',
			labelAlign : 'right',
			labelWidth : 80,
			listWidth:230,    //gird的宽度
			width:230,        //combo的宽度
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
				var view = this.up('qaapplylistview');
				var initChain = view.getActionChain('init');
				initChain.execute({
					curDeptNm:newValue
				});
			   }
		},{
			xtype : "xapcombobox",
			name : 'applyStatus',
            labelAlign:'right' ,
            allOptions:false,  
            editable: false,    
			width:210,
			labelWidth : 60,
			fieldLabel : "申请状态",
			displayField : 'name',
			valueField : 'code',
			comboData : [
                {"code":"MRM24.01", "name":"新建"},
                {"code":"MRM24.02", "name":"提交"},
                {"code":"MRM24.03", "name":"通过"},
                {"code":"MRM24.04", "name":"驳回"}
            ]
		},{
			xtype:'xapdatefield',
		    name:'timeStart',
		    fieldLabel:'申请时间',
		    labelWidth:60,
		    labelAlign:'right'
		},{
			xtype:'xapdatefield',
		    fieldLabel:"到",
		    labelWidth:60,
			name:'timeEnd',
			labelAlign:'right'
		}/*,{
			xtype: 'xapdisplayfield',
      		width:300
		},{
			xtype: 'xapdisplayfield',
      		width:300
		}*//*,{
	        xtype: 'xaptoolbarblock',
	        height: 25,
	        width:116,
	        items: [{
	            xtype: 'button',
	            iconCls: 'icon-reset',
	            text: '重置',
	            action: 'reset',
	            handler:function(btn,e){
	                var block = btn.up('qaapplysearchblock');
	                var form = block.down('xapform');
	                form.getForm().reset();
	                var startDate = block.down('xapdatefield[name=timeStart]');
	                var endDate = block.down('xapdatefield[name=timeEnd]');
	                startDate.setValue(null);
	                endDate.setValue(null);
	                var view = btn.up('qaapplylistview');
	                var block = btn.up('qaapplysearchblock');
	                var form = block.down('xapform');
	                if(form.getForm().isValid()){
	                    var chain = view.getActionChain('init');
	                    chain.execute();
	                }
	            }
	        },{
	            xtype: 'button',
	            iconCls: 'icon-Search',
	            text: '查询',
	            action: 'search',
	            handler:function(btn,e){
	                var view = btn.up('qaapplylistview');
	                var block = btn.up('qaapplysearchblock');
	                var form = block.down('xapform');
	                if(form.getForm().isValid()){
	                    var chain = view.getActionChain('init');
	                    chain.execute();
	                }
	            }
	        }]
	    }*/]
	}]
})