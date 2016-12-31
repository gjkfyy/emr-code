Ext.define('iih.sy.userinfo.block.UserInfoLeftBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [
		   		'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.ComboBoxGrid',
				'Xap.ej.element.form.Form'
		   	],

	alias:'widget.userinfoleftblock',
	layout: {
		type: 'table',
		columns: 2,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1
//            width: '100%',
//            height:73
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items: [
	    {
			xtype:'xaptextfield',
			width:140,
	        name:'userId',
	        labelWidth:60,
	        margin:'14 0 8 0',
	        labelAlign:'right',
	        fieldLabel:'用户ID',
	        listeners:{
	        	specialkey : function(field, e) {  
	                if (e.getKey() == Ext.EventObject.ENTER) {  
	                    var view = this.up('userinfoleftlistview');
						var initChain = view.getActionChain('init');
						initChain.execute({}); 
	                }  
	            }
	        }
		},{
			xtype:'xaptextfield',
			width:150,
	        name:'name',
	        labelWidth:60,
	        margin:'14 0 8 0',
	        labelAlign:'right',
	        fieldLabel:'用户名',
	        listeners:{
	        	specialkey : function(field, e) {  
	                if (e.getKey() == Ext.EventObject.ENTER) {  
	                    var view = this.up('userinfoleftlistview');
						var initChain = view.getActionChain('init');
						initChain.execute({}); 
	                }  
	            }
	        }
			
		},/*{ //辅助录入
	        xtype:'comboxgrid',
	        anchor: "90%",
	        width:140,
	        padding:'0 0 0 0',
	        name: 'curDeptNm',
			dataIndex : 'curDeptNm',
	        method:'dept',
	        fieldLabel:'所属科室',
	        labelWidth : 60,
			labelAlign : 'right',
	        valueField : 'value',
	        columns: [{
	            text: '科室编码',
	            dataIndex: 'value',
	            hidden:true
	        },{
	            text: '科室',
	            dataIndex: 'text'
	        }],
	        displayField: 'text',
	        serchParam:['keyword'],
	        parentXtype:'userinfoleftblock',
	        dictionary:'ownerCdLoad'
	 },*/{
			xtype:'comboxgrid',
			url: 'organization/keyword',//科室查询的url
	        anchor: "90%",
			listWidth:210,    //gird的宽度
			width:140,        //combo的宽度
	        padding:'0 0 0 0',
	        name: 'curDeptNm',
			dataIndex : 'curDeptNm',
	        method:'dept',
	        fieldLabel:'所属科室',
	        labelWidth : 60,
			labelAlign : 'right',
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
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
			    console.log(newValue);     //本次选择的科室编码
			    console.log(oldValue);     //上次选择的科室编码
			    console.log(record);       //本次选择的科室完整记录
			}
		},{
			xtype: "xapcombobox",
			width:150,
			name: 'statusCd',
			labelWidth:60,
	        labelAlign:'right',
			fieldLabel:'用户状态',
			dictionary:'XAPM01'
	}]
})