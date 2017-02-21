Ext.define('iih.sy.patient.block.PatientInfoBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [
		   		'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.Checkbox',
		   		'Xap.ej.element.field.DateField',
		   		'Xap.ej.element.field.ComboBoxGrid',
				'Xap.ej.element.form.Form'
		   	],

	alias:'widget.patientinfoblock',
	
	layout: {
		type: 'table',
		columns: 12,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1
        },
        tdAttrs: {
            valign: 'left',
            buttonAlign:'center'
        }
	},
	items: [{
				header : '创建人ID',
				name : 'crtUserId',
				field : 'textfield',
				type : 'string',
				hidden : true
			},{
				header : '创建人科室ID',
				name : 'crtDeptCd',
				field : 'textfield',
				type : 'string',
				hidden : true
			},{
				header : '最后更新人ID',
				name : 'crtDeptCd',
				field : 'textfield',
				type : 'string',
				hidden : true
			},{
				header : '最后更新人科室ID',
				name : 'lastUpdDeptCd',
				field : 'textfield',
				type : 'string',
				hidden : true
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'10 0 0 5',
		        labelWidth:70,
		        fieldLabel:'X片号',
		        width:230,
		        //id:'xpianNo',
		        name:'xpianNo'
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'10 0 0 5',
		        labelWidth:50,
		        fieldLabel:'住院号',
		        width:230,
		        //id:'inpatientNo',
		        name:'inpatientNo'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:6,
				width:10,
				valign: 'left',
				name:'',
				value: ''
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'姓名',
		        width:150,
		       // id:'parentName',
		        name:'patientName'
			},{
	        	xtype:'xapcombobox',
		       // id:'sex',
		        name:'sex',
	            fieldLabel:'性别',
	            padding:'5 0 0 5',
	            colspan: 2,
	            width:150,
	            labelWidth:50,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'1', "value":"男"},
	                 {"code":'0', "value":"女"},
	                 {"code":'-1', "value":"未知性别"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:''
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:40,
		        width:140,
		        name:'parentName',
		        fieldLabel:'父母名'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:50,
		        width:150,
//		        id:'age',
		        name:'age',
		        fieldLabel:'年龄'
			},{
				xtype:'xaptextfield',
				colspan: 4,
				padding:'5 0 0 0',
		        labelWidth:100,
		        width:230,
		        name:'nation',
		        fieldLabel:'民族'
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'胎次',
		        width:230,
		        name:'parity'
			},{
	        	xtype:'xapcombobox',
	            name:'enType',
	            fieldLabel:'婚姻',
				padding:'5 20 0 5',
	            colspan: 3,
		        labelWidth:60,
		        name:'marriage',
		        width:230,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'1', "value":"已婚"},
	                 {"code":'0', "value":"未婚"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:''
			},/*{
				xtype:'xapdatefield',
				colspan: 3,
				padding:'5 20 0 5',
		        labelWidth:60,
		        fieldLabel:'入院日期',
		        width:230,
		        name:'admissionDate',
		        listeners: {
					change: function( v, newValue, oldValue, eOpts ) {
						var startDate = this.up('panel').down('xapdatefield[name=admissionDate]');
						startDate.setMaxValue( this.getValue( ) );
					}
				}
			},*/{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:50,
		        width:150,
		        name:'occupation',
		        fieldLabel:'职业'
			},{
				xtype:'xaptextfield',
				colspan: 4,
				padding:'5 0 0 0',
		        labelWidth:100,
		        width:230,
		        name:'education',
		        fieldLabel:'文化程度'
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'发病年龄',
		        width:230,
		        name:'onsetAge'
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'5 0 0 5',
		        labelWidth:60,
		        fieldLabel:'病因',
		        width:230,
		        name:'pathogeny'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'家族史',
		        width:150,
		        name:'familyHistory'
			},{
				xtype:'xaptextfield',
				colspan: 4,
				padding:'5 0 0 0',
		        labelWidth:100,
		        fieldLabel:'供史者',
		        width:230,
		        name:'provider'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'病史',
		        width:495,
		        name:'medicalHistory'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'治疗史',
		        width:495,
		        name:'treatmentHistory'
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:1020,
		        name:'lumbarSurgeryHistory',
		        fieldLabel:'腰部手术史'
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:1020,
		        name:'orthopedicSurgeryHistory',
		        fieldLabel:'矫形手术史'
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:1020,
		        name:'adress',
		        fieldLabel:'联系地址'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:495,
		        name:'tel',
		        fieldLabel:'手机号码'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 20 0 5',
				width:495,
		        name:'otherContact',
		        labelWidth:100,
		        fieldLabel:'QQ/微信/E-mail'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:70,
		        fieldLabel:'体检',
		        width:150,
		        name:'physicalExam'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:40,
		        fieldLabel:'发育',
		        width:140,
		        name:'growth'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:40,
		        fieldLabel:'营养',
		        width:140,
		        name:'nutrition'
			},{
				xtype:'xaptextfield',
				colspan: 1,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'身高',
		        width:150,
		        name:'height'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel:'',
				colspan:1,
				width:5,
				valign:'left',
				name:'HighUnit',
				value: 'cm'
			},{
				xtype:'xaptextfield',
				colspan: 1,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'体重',
		        width:140,
		        name:'weight'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:1,
//				vertical: true,
				width:10,
				valign: 'left',
				name:'',
				value: 'kg'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:60,
		        fieldLabel:'专科检查',
		        width:160,
		        name:'specialityExam',
		        displayField: 'parentName'
			},{
				xtype:'xapcheckbox',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:70,
		        labelAlign:'right',
		        fieldLabel:'照相',
		        width:150,
		        name:'isPic',
		        displayField: 'parentName'
			},{
				xtype:'xapcheckbox',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:30,
		        labelAlign:'right',
		        fieldLabel:'录像',
		        width:150,
		        name:'isVideo',
		        displayField: 'parentName'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:8,
				name:'',
				value: ''
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 10 5',
		        labelWidth:70,
		        width:1020,
		        name:'otherDiseasesHistory',
		        fieldLabel:'其它疾病史',
		        displayField: 'parentName'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:4,
				width:10,
				valign: 'center',
				name:'',
				value: ''
			},{
				xtype: 'button',
				text: '保存',
				colspan: 2,
				iconCls: 'icon-save',
				action: 'save',
				buttonAlign:'center'
			},{
				xtype: 'button',
				text: '取消',
				colspan: 2,
				iconCls: 'icon-cancel',
				action: 'cancel',
				buttonAlign:'center'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:4,
				width:10,
				valign: 'center',
				name:'',
				value: '',
				hidden : true
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:4,
				width:10,
				valign: 'center',
				id : 'flag',
				name:'flag',
				value: '',
				hidden : true
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				colspan:4,
				width:10,
				valign: 'center',
				id:'patientId',
				name:'patientId',
				value: '',
				hidden : true
			}],
			setData: function(data) {
			    this.callParent(arguments);
			},
		    getData: function() {
		        this.callParent(arguments);
		    }
			
})