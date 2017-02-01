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
            valign: 'left'
        }
	},
	items: [{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'10 0 0 5',
		        labelWidth:70,
		        fieldLabel:'X片号',
		        width:495,
		        id:'xpianNo',
		        name:'xpianNo'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'10 0 0 5',
		        labelWidth:50,
		        fieldLabel:'住院号',
		        width:495,
		        id:'inpatientNo',
		        name:'inpatientNo'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'姓名',
		        width:150,
		        id:'patientName',
		        name:'patientName'
			},{
	        	xtype:'xapcombobox',
	        	id:'sex',
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
		        id:'parentName',
		        name:'parentName',
		        fieldLabel:'父母名'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:50,
		        width:150,
		        id:'age',
		        name:'age',
		        fieldLabel:'年龄'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:30,
		        width:140,
		        id:'nation',
		        name:'nation',
		        fieldLabel:'民族'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:30,
		        fieldLabel:'胎次',
		        width:140,
		        id:'parity',
		        name:'parity'
			},{
	        	xtype:'xapcombobox',
	            name:'enType',
	            fieldLabel:'婚姻',
	            padding:'5 0 0 5',
	            colspan: 3,
	            width:150,
	            id:'marriage',
		        name:'marriage',
	            labelWidth:70,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'1', "value":"已婚"},
	                 {"code":'0', "value":"未婚"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:false,
	            editable:false,
	            value:''
			},{
				xtype:'xapdatefield',
				colspan: 3,
				padding:'5 20 0 5',
		        labelWidth:60,
		        fieldLabel:'入院日期',
		        width:230,
		        id:'admissionDate',
		        name:'admissionDate',
		        listeners: {
					change: function( v, newValue, oldValue, eOpts ) {
						var startDate = this.up('panel').down('xapdatefield[name=admissionDate]');
						startDate.setMaxValue( this.getValue( ) );
					}
				}
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:50,
		        width:150,
		        id:'occupation',
		        name:'occupation',
		        fieldLabel:'职业'
			},{
				xtype:'xaptextfield',
				colspan: 4,
				padding:'5 0 0 0',
		        labelWidth:100,
		        width:230,
		        id:'education',
		        name:'education',
		        fieldLabel:'文化程度'
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'发病年龄',
		        width:230,
		        id:'onsetAge',
		        name:'onsetAge'
			},{
				xtype:'xaptextfield',
				colspan: 3,
				padding:'5 0 0 5',
		        labelWidth:60,
		        fieldLabel:'病因',
		        width:230,
		        id:'pathogeny',
		        name:'pathogeny'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'家族史',
		        width:150,
		        id:'familyHistory',
		        name:'familyHistory'
			},{
				xtype:'xaptextfield',
				colspan: 4,
				padding:'5 0 0 0',
		        labelWidth:100,
		        fieldLabel:'供史者',
		        width:230,
		        id:'provider',
		        name:'provider'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 0 0 5',
		        labelWidth:70,
		        fieldLabel:'病史',
		        width:495,
		        id:'medicalHistory',
		        name:'medicalHistory'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'治疗史',
		        width:495,
		        id:'treatmentHistory',
		        name:'treatmentHistory'
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:1020,
		        id:'lumbarSurgeryHistory',
		        name:'lumbarSurgeryHistory',
		        fieldLabel:'腰部手术史'
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:1020,
		        id:'orthopedicSurgeryHistory',
		        name:'orthopedicSurgeryHistory',
		        fieldLabel:'矫形手术史'
			},{
				xtype:'xaptextfield',
				colspan: 12,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:1020,
		        id:'adress',
		        name:'adress',
		        fieldLabel:'联系地址'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 20 0 5',
		        labelWidth:70,
		        width:495,
		        id:'tel',
		        name:'tel',
		        fieldLabel:'手机号码'
			},{
				xtype:'xaptextfield',
				colspan: 6,
				padding:'5 20 0 5',
				width:495,
				id:'otherContact',
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
		        id:'physicalExam',
		        name:'physicalExam'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:40,
		        fieldLabel:'发育',
		        width:140,
		        id:'growth',
		        name:'growth'
			},{
				xtype:'xaptextfield',
				colspan: 2,
				padding:'5 20 0 5',
		        labelWidth:40,
		        fieldLabel:'营养',
		        width:140,
		        id:'nutrition',
		        name:'nutrition'
			},{
				xtype:'xaptextfield',
				colspan: 1,
				padding:'5 0 0 5',
		        labelWidth:50,
		        fieldLabel:'身高',
		        width:150,
		        id:'height',
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
		        id:'weight',
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
		        id:'specialityExam',
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
		        id:'isPic',
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
		        id:'isVideo',
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
		        id:'otherDiseasesHistory',
		        name:'otherDiseasesHistory',
		        fieldLabel:'其它疾病史',
		        displayField: 'parentName'
			},{
				xtype: 'button',
				text: '保存',
				colspan: 6,
				iconCls: 'icon-save',
				action: 'save'
			},{
				xtype: 'button',
				text: '取消',
				colspan: 6,
				iconCls: 'icon-cancel',
				action: 'cancel'
			}]
			
			
			
	        
	        /*
	        {
			xtype: 'button',
			text: '新建患者',
			margin:'5 0 5 0',
			iconCls: 'icon-Create',
			valign : 'left',
			action : 'newPatient'
			handler:function(btn,e){
				var patientForm = new Ext.FormPanel({
					url: 'patient',
					method:'post',
					items: [{}]
				})
				
    			var win=new Ext.Window({
    				width:1050,
    				height:500,
    				title:'新建患者',
    				closable:true,
    				layout:'table',//布局方式
    				maximizable:true,
//    				minimizable:true,
    				closeAction:'hide',
    				constrainHeader:true,
    				//constrain:true,
    				defaultButton:0,
    				resizable:true,
    				resizeHandles:'se',
    				modal:true,
    				plain:true,
    				animateTarget:'target',
    				items:[patientForm],
    				buttons:[
    					{
    						text:'保存',
    						iconCls: 'icon-save',
    						action:'save',
    						handler:function(){
    							patientForm.getForm().submit({ 
    			                    success:function(){  
    			                        Ext.Msg.alert('消息',"成功");  
    			                    },  
    			                    failure:function(){  
    			                        Ext.Msg.alert('消息','失败');  
    			                    }  
    			                });
    							
    							var data = {};
    					       	data.patientName = Ext.getCmp("patientName").getValue();
    					       	
    							alert(patientForm);	
    							return;
    							var operations = this.getForm();
    							var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
    							// 患者信息
    							var data = {};
    					       	data.patientName = Ext.getCmp("patientName").getValue();
    					       	
    							var operation = {
    						            url: 'patient',
    						            mclass: null,
    						            method: METHODS.METHOD_CREATE,
    						            condition: null,	
    						            data:data,
    						    		scope: this,
    						    		success: this.onSuccess
    						    };
    						    operations.length = 0;
    						    patientForm.push(operation);
    						    
    						}
    					},{
    						text:'取消',
    						iconCls: 'icon-cancel',
    						handler:function(){
    							win.close();	
    						}
    					}	 
    				]
    								   
    			});	
    			
    			win.show();
    		}*/
})