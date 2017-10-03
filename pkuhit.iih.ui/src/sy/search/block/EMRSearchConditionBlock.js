Ext.define('iih.sy.search.block.EMRSearchConditionBlock', {
	extend : 'Xap.ej.block.FormBlock',
	requires: [
		   		'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.Checkbox',
		   		'Xap.ej.element.field.DateField',
		   		'Xap.ej.element.field.ComboBoxGrid',
				'Xap.ej.element.form.Form',
				'Xap.ej.element.label.Label',
				'Xap.ej.element.grid.Grid'
		   	],

	alias : 'widget.emrsearchconditionblock',
	id:'emrsearchconditionblock',

//	layout : {
//		type:'vbox',
//        align: 'stretch'
//	},
	
	width : '99%',
	
	layout: {
		type: 'table',
		columns: 12,
		border:false,
		tableAttrs: {
            border: 0,
            width : '986',
            cellpadding: 0,
            cellspacing: 1
        },
        tdAttrs: {
            valign: 'left',
            buttonAlign:'center'
        }
	},

	items : [ {
		xtype : 'fieldset',
		title : '住院',
		colspan: 5,
		defaultType : 'textfield',
		layout : 'column',
		items : [{
            xtype: 'fieldcontainer',
            fieldLabel: '入院日期',
            labelWidth:60,
            layout: 'table',
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xapdatefield',
              name:'admissionDateStart',
              labelAlign:'left',
              width:120,
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xapdatefield',
            	name:'admissionDateEnd',
            	labelAlign:'left',
            	width:120,
            	editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '住院号',
            colspan: 5,
            labelWidth:60,
            layout: 'column',
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'inpatientNoStart',
              colspan: 2,
              labelAlign:'left',
              width:120,
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xaptextfield',
            	name:'inpatientNoEnd',
              	colspan: 2,
            	labelAlign:'left',
            	width:120,
            	editable:false
            }]
        },{
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		name:'',
        		padding:'5 0 0 0',
        		value: ''
          }]
	},{
		xtype : 'fieldset',
		title : '患者',
		colspan: 7,
		defaultType : 'textfield',
		layout : 'column',
		items : [{
            xtype: 'fieldcontainer',
            fieldLabel: '姓名',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.2,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'patientName',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '性别',
            labelWidth:40,
            layout: 'hbox',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 10',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
        		xtype:'xapcombobox',
     	       // id:'sex',
     	        name:'sex',
                flex: 1,
                comboData : [
                     {"code":'-1', "value":"不限"},
         			 {"code":'1', "value":"男"},
                      {"code":'0', "value":"女"}
                 ],
                 displayField: 'value',
                 valueField: 'code',
                 allowBlank:true,
                 editable:false,
                 value:'-1'
     		}]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '出生日期',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.5,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 10',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xapdatefield',
              name:'birthdayStart',
              flex: 1,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xapdatefield',
            	name:'birthdayEnd',
                flex: 1,
            	labelAlign:'left',
            	editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '联系电话',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.45,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'tel',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '身份证号',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.5,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 10',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'idCardNo',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '地址',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.95,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'address',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        }]
	},{
		xtype : 'fieldset',
		title : '高级检索项',
		colspan: 12,
		defaultType : 'textfield',
		layout : 'column',
		items : [{
            xtype: 'fieldcontainer',
            fieldLabel: '诊断',
            labelWidth:80,
            layout: 'hbox',
            labelAlign:'right',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'diagnosis',
              flex: 1,
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '治疗目标',
            labelWidth:80,
            layout: 'hbox',
            labelAlign:'right',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'treatmentGoal',
              flex: 1,
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '治疗方案',
            labelWidth:60,
            layout: 'hbox',
            labelAlign:'right',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'treatmentPlan',
              flex: 1,
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '环式外固定',
            labelWidth:70,
            layout: 'hbox',
            labelAlign:'right',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'ring',
              flex: 1,
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '组合式外固定',
            labelWidth:80,
            layout: 'hbox',
            labelAlign:'right',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'combined',
              flex: 1,
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            name: 'jcxm',
            fieldLabel: '检查项目',
            labelWidth:80,
            layout: 'vbox',
            labelAlign:'right',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
            	xtype: 'fieldcontainer',
            	layout: 'hbox',
            	defaultType: 'textfield',
                defaults: {
                    hideLabel: 'true'
                },
                items : [{
        			xtype: 'xaplabel',
        			margin:'4 10 0 0',
        	    	labelAlign:'right',
        	    	text: '项目名'
        		},{
        	        xtype:'xapcombobox',
        	        labelAlign : 'right',
        			margin:'0 32 0 0',
    				name:'mr_element',
    				editable:false,
        			allOptions:false,
    				queryMode: 'local',
    				width:120,
    				displayField: 'nm',
    				valueField: 'mrShareElementCd'
        	    },{
        			xtype: 'xaplabel',
        			margin:'4 30 0 10',
        	    	labelAlign : 'right',
        	    	labelWidth:180,
        	    	text: '值'
        		},{
                    xtype: 'xaptextfield',
                    name:'examItem',
                    flex: 1,
                    labelAlign:'right',
                    width:155,
                    editable:false
                  },{
    				xtype: 'xapbutton',
    				text: '',
    				name: 'addItem',
    				iconCls: 'icon-Create',
    				margin:'0 5 0 10',
    				colspan: 1,
    				iconCls: 'icon-Create',
    				valign : 'center',
    		        listeners: {
    					click: function( v, newValue, oldValue, eOpts ) {
    						var block=Ext.getCmp('emrsearchconditionblock');
    						var data = block.down('xapcombobox[name=mr_element]').getData();
    						var jcxm = this.up('fieldcontainer[name=jcxm]');//items
    						block.addItem(jcxm);
    					}
    				}
    			}]

            }]
        }]
	}],
	test: function(){
		alert(123);
	},
	addItem : function (container,mrElementValue,examItemValue){
		var timestamp = new Date().getTime();
		var block=Ext.getCmp('emrsearchconditionblock');
		var data = block.down('xapcombobox[name=mr_element]').getData();
		
		var item = Ext.create('Ext.form.FieldContainer', {
        	layout: 'hbox',
        	defaultType: 'textfield',
            defaults: {
                hideLabel: 'true'
            },
            items : [{
    			xtype: 'xaplabel',
    			margin:'4 10 0 0',
    	    	labelAlign : 'left',
    	    	text: '项目名'
    		},{
    	        xtype:'xapcombobox',
    	        labelAlign : 'right',
    			margin:'0 32 0 0',
				name:'mr_element_'+timestamp,
				editable:false,
    			allOptions:false,
				queryMode: 'local',
				width:120,
				displayField: 'nm',
				valueField: 'mrShareElementCd'
    	    },{
    			xtype: 'xaplabel',
    			margin:'4 30 0 10',
    	    	labelAlign : 'left',
    	    	text: '值'
    		},{
                xtype: 'xaptextfield',
                name:'examItem_'+timestamp,
                flex: 1,
                labelAlign:'right',
                value : examItemValue,
                width:155,
                editable:false
              },{
				xtype: 'xapbutton',
				text: '',
				name: 'addItem',
				iconCls: 'icon-Create',
				margin:'0 5 0 10',
				colspan: 1,
				iconCls: 'icon-Create',
				valign : 'center',
				action: '',
		        listeners: {
					click: function( v, newValue, oldValue, eOpts ) {
						var block=Ext.getCmp('emrsearchconditionblock');
						var data = block.down('xapcombobox[name=mr_element]').getData();
						var jcxm = this.up('fieldcontainer[name=jcxm]');//items
						block.addItem(jcxm);
					}
				}
			},{
				xtype: 'xapbutton',
				text: '',
				name: 'delItem',
				iconCls: 'icon-Create',
				margin:'0 5 0 5',
				colspan: 1,
				iconCls: 'icon-Delete',
				valign : 'center',
				action: '',
		        listeners: {
					click: function( v, newValue, oldValue, eOpts ) {
						var block=Ext.getCmp('emrsearchconditionblock');
						var jcxm = this.up('fieldcontainer[name=jcxm]');//items
						
						var container = this.ownerCt.getLayout().owner;
						var selector = 'fieldcontainer[id='+container.id+']';
						var item = jcxm.down(selector);
						jcxm.remove(item);
					}
				}
			}]
		});
		item.down('xapcombobox').setData(data);
		item.down('xapcombobox').setValue(mrElementValue);
		container.add(item);
	}
})
