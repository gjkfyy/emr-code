Ext.define('iih.mr.qa.process_qa_search.block.InProcessWorkSearchBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.inprocessworksearchblock',
	
	border: 0,

	items: [{
//		title: '质控工作查询',
		xtype: 'xapform',
	layout: {
		type: 'table',
		columns: 5,
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
			xtype:'xapdatefield',
		    name:'crtTimeStart',
		    fieldLabel:'质控日期',
		    labelWidth:60,
		    labelAlign:'right',
			margin:'0 -80 0 10'
		},{
			xtype: 'xapdisplayfield',
//      		name:'intervalSymbol',
      		width:20,
      		value:'~',
			margin:'0 0 0 10'
		},{
			xtype:'xapdatefield',
			name:'crtTimeEnd',
			labelAlign:'right',
			margin:'0 10 0 -10'
		},/*{
			xtype:'xaptextfield',
	        name:'crtUserNm',
	        labelWidth:60,
	        labelAlign:'right',
	        fieldLabel:'质控医师',
	        margin:'0 0 0 10',
	        listeners:{
	        	specialkey : function(field, e) {  
	                if (e.getKey() == Ext.EventObject.ENTER) {  
	                    var view = this.up('inprocessworksearchview');
						var initChain = view.getActionChain('search');
						initChain.execute({}); 
	                }  
	            }
	        }
		},*/{
	        xtype:'comboxgrid',
	        margin:'0 10 0 10',//margin:'10 100 10 150',
	        name:'crtUserNm',
	        fieldLabel:'质控医师/护士',
	        url: 'employee',
	        labelAlign : 'right',
			labelWidth : 100,
			listWidth:230,    //gird的宽度
			width:210, 
	        valueField : 'id',
	        displayField: 'name',
	        hidden:true,
	        searchParam: {'deptCd': IMER_GLOBAL.department.code},
	        columns: [{
	           text: '人员id',
	           dataIndex: 'id',
	           width:70
	        },{
	           text: '医师/护士姓名',
	           flex:1,
	           dataIndex: 'name'
	        }],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('inprocessworksearchview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					crtUserNm:newValue
				});
			   }
	    },{
	        xtype:'comboxgrid',
	        name:'currentManageDoctorName',
	        margin:'0 10 0 10',//margin:'0 100 10 150',
	        fieldLabel:'整改医师/护士',
	        url: 'employee',
	        labelAlign : 'right',
			labelWidth : 100,
			listWidth:230,    //gird的宽度
			width:210, 
	        valueField : 'id',
	        displayField: 'name',
	        searchParam: {'deptCd': IMER_GLOBAL.department.code},
	        columns: [{
	           text: '人员id',
	           dataIndex: 'id',
	           width:70
	        },{
	           text: '医师/护士姓名',
	           flex:1,
	           dataIndex: 'name'
	        }],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('inprocessworksearchview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					currentManageDoctorName:newValue
				});
			  }
	    },
			{
				xtype:'xaptextfield',
		        name:'amrNo',
		        labelWidth:50,
		        labelAlign:'right',
		        margin:'0 10 0 10',//margin:'0 0 10 10',
		        fieldLabel:'住院号',
		        listeners:{
		        	specialkey : function(field, e) {  
		                if (e.getKey() == Ext.EventObject.ENTER) {  
		                    var view = this.up('inprocessworksearchview');
							var initChain = view.getActionChain('search');
							initChain.execute({}); 
		                }  
		            }
		        }
			},{
			xtype:'comboxgrid',
			margin:'10 70 10 0',
			name:'curDeptNm',
			method:'curDeptNm',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'质控科室',
			labelAlign : 'right',
			hidden:true,
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
				var view = this.up('inprocessworksearchview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					curDeptNm:newValue
				});
			   }
		},/*{
			xtype: 'xapdisplayfield',
			width:230
		},*/
		
		{
			xtype:'xapdatefield',
		    name:'rfmTimeStart',
		    fieldLabel:'整改日期',
		    labelWidth:60,
		    labelAlign:'right',
		    margin:'0 -80 0 10'
		},{
			xtype: 'xapdisplayfield',
//      		name:'intervalSymbol',
      		width:20,
      		value:'~',
			margin:'0 0 0 10'
		},{
			xtype:'xapdatefield',
			name:'rfmTimeEnd',
			labelAlign:'right',
			margin:'0 10 0 -10'
		}/*{
			xtype:'xaptextfield',
	        name:'currentManageDoctorName',
	        labelAlign : 'right',
			labelWidth : 60,
			listWidth:230,    //gird的宽度
			width:210, 
	        fieldLabel:'整改医师',
	        margin:'0 0 10 10',
	        listeners:{
	        	specialkey : function(field, e) {  
	                if (e.getKey() == Ext.EventObject.ENTER) {  
	                    var view = this.up('inprocessworksearchview');
						var initChain = view.getActionChain('search');
						initChain.execute({}); 
	                }  
	            }
	        }
		},*/]
	}]
})