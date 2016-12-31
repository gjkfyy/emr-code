Ext.define('iih.mr.qa.order_qa_patient.block.OrderQAPatientListBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.orderqapatientlistblock',
	
	border: 0,

	items: [{
		title: '医嘱质控患者查询',
		xtype: 'xapform',
	layout: {
		type: 'table',
		columns: 3,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%',
            height:56
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items:[
	    {
			xtype:'comboxgrid',
			margin:'10 0 10 0',
			name:'curDeptNm',
			method:'curDeptNm',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'科室',
			labelAlign : 'right',
			labelWidth : 50,
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
				var view = this.up('deptqapatientlistview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					curDeptNm:newValue
				});
			    /*console.log(newValue);     //本次选择的科室编码
			    console.log(oldValue);     //上次选择的科室编码
			    console.log(record);       //本次选择的科室完整记录
*/			}
	},{
		xtype:'xaptextfield',
//		width:140,
        name:'amrNo',
        labelWidth:50,
        labelAlign:'right',
        fieldLabel:'住院号',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('deptqapatientlistview');
					var initChain = view.getActionChain('search');
					initChain.execute({}); 
                }  
            }
        }
	},{
		xtype:'xaptextfield',
//		width:140,
        name:'patientName',
        labelWidth:60,
        labelAlign:'right',
        fieldLabel:'患者姓名',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('deptqapatientlistview');
					var initChain = view.getActionChain('search');
					initChain.execute({}); 
                }  
            }
        }
	}]
	}]
})