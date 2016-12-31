Ext.define('iih.mr.archive.patient_mediclRecord_archive.block.PatientListBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [],

	alias : 'widget.patientlistblock',

	border : 0,

		layout : {
			type : 'table',
			columns : 5,
			// width: 1024,
			tableAttrs : {
				border : 0,
				cellpadding : 0,
				cellspacing : 1,
				width : '100%',
				height : 56
			},
			tdAttrs : {
				valign : 'left'
			}
		},
		items : [ {
			xtype : 'comboxgrid',
			name : 'curDeptNm',
			method : 'curDeptNm',
			url : 'organization/keyword',// 科室查询的url
			fieldLabel : '科室',
			margin:'10 50 10 60',
			labelAlign : 'right',
			labelWidth : 50,
			listWidth : 230, // gird的宽度
			width : 205, // combo的宽度
			valueField : 'code',// 科室编码的字段名
			displayField : 'name',// 科室名称的字段名
			columns : [ { // grid的column配置
				text : '科室编码',
				dataIndex : 'code',
				width : 80
			}, {
				text : '科室',
				flex : 1,
				dataIndex : 'name'
			} ],
			listeners : {
				specialkey : function(field, e) {
					if (e.getKey() == Ext.EventObject.ENTER) {
						var view = this.up('patientview');
						var initChain = view.getActionChain('search');
						initChain.execute({});
					}
				}
			},
			callback : function(newValue, oldValue, record) { // 在grid选择记录后的回调函数
				var view = this.up('patientview');
				var initChain = view.getActionChain('search');
				initChain.execute({
					newValue:newValue
				 });
				}
		}, 
		{
			xtype : 'xapdatefield',
			name : 'crtTimeStart',
			fieldLabel : '入院日期',
			labelWidth : 60,
			margin:'10 15 10 50',
			labelAlign : 'right',
			editable : false,
			value:'',
			margin : '10 0 10 0'
		}, {
			xtype : 'xapdisplayfield',
			// name:'intervalSymbol',
			margin : '10 10 10 10',
			value : '~'
		}, {
			xtype : 'xapdatefield',
			name : 'crtTimeEnd',
			margin:'10 15 10 15',
			editable : false,
			value:'',
			labelAlign : 'right'
		}, {
			xtype : 'xaptextfield',
			// width:140,
			name : 'amrNo',
			labelWidth : 50,
			labelAlign : 'right',
			margin:'10 50 10 50',
			fieldLabel : '住院号',
			listeners : {
				specialkey : function(field, e) {
					if (e.getKey() == Ext.EventObject.ENTER) {
						var view = this.up('patientview');
						var initChain = view.getActionChain('search');
						initChain.execute({});
					}
				}
			}
		}, {
			xtype : 'xaptextfield',
			name : 'patientName',
			labelWidth : 60,
			labelAlign : 'right',
			margin : '10 50 10 50',
			fieldLabel : '患者姓名',
			listeners : {
				specialkey : function(field, e) {
					if (e.getKey() == Ext.EventObject.ENTER) {
						var view = this.up('patientview');
						var initChain = view.getActionChain('search');
						initChain.execute({});
					}
				}
			}
		} 
//		,{
//	        xtype:'xapcombobox',
//	        name:'gsCd',
//	        colspan:2,
//	        labelWidth : 60,
//	        margin : '10 50 10 0',
//			labelAlign : 'right',
//	        editable:false,
//	        allOptions: false,
//	        fieldLabel:'病案状态',
//	        dictionary:'MRM22'
//	    }
		,{
	        xtype: 'radiogroup',
	        margin : '10 50 10 10',
	        colspan:2,
	        name:'checkQa',
	        vertical: true,
	        fieldLabel : '是否已质控',
	        labelWidth : 70,
	        items: [
	            {boxLabel: '已质控', name: 'qaF', inputValue: '1',checked:true,width:60},
	            { boxLabel: '未质控', name: 'qaF', inputValue:'0',width:60}
	        ]
	    }
		,{
	        xtype: 'radiogroup',
	        margin : '10 50 10 10',
	        colspan:1,
	        name:'checkArc',
	        vertical: true,
	        fieldLabel : '是否已归档',
	        labelWidth : 70,
	        items: [
	            {boxLabel: '未归档', name: 'arcF', inputValue: '0',checked:true,width:60},
	            { boxLabel: '已归档', name: 'arcF', inputValue:'1',width:60}
	        ]
	    }
		,{
			xtype : 'button',
			text : '选中上传',
			name : 'uploadFileBtn',
			height : 35,
			iconCls: 'icon-archive',
			width : 80,
			margin : '10 50 10 105',
			align : 'right',
			disabled:true,
			hidden:true,
			handler: function() {
				var view=this.up('patientview');
				var patientListArchive = view.getActionChain("patientListArchive");
				patientListArchive.execute();
			}	
		}]
//	} ]
});