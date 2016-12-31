 	 	Ext.define('iih.mr.tm.xml.block.FormXmlEditBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextArea',
		'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.NumberField',
        'Xap.ej.element.field.DateField',
        'Xap.ej.element.field.DisplayField',
        'Xap.ej.element.datetimefield.DateTimeField',
        'Xap.ej.element.grid.Grid',
        'Xap.ej.element.tab.Panel',
        'Xap.ej.element.button.Button'
	],

	alias:'widget.formxmleditblock',

	layout: {
        type: 'table',
        columns: 2,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            width: '220'
        },
        tdAttrs: {
            valign: 'left'
        }
    },
    
	autoScroll : true,
	
	items: [{
        xtype:'xapcombobox',
        name:'mrElementTypeName',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'类型',
        comboData : [
//             {"code":'', "value":"请选择"},
			 {"code":'Text', "value":"文本"},
             {"code":'DateTime', "value":"时间"},
             {"code":'Number', "value":"数字"},
             {"code":'SingleSelect', "value":"单选"},
             {"code":'MultiSelect', "value":"多选"},
             {"code":'Link', "value":"签名"}             
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:false,
        editable:false,
        value:''
    },{
        xtype:'xaptextfield',
        name:'mrElementNm',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'名称',
        allowBlank:false,
        blankText:'请输入名称！'
    },{
        xtype:'xaptextfield',
        name:'dataResource',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'数据元',
        allowBlank:true,
        readOnly:true,
        blankText:'请输入内容！'
    },{
        xtype:'button',
        name:'search',
        method:'search',
        iconCls:'icon-Search',
        text: ' 检索'
    },{
    	xtype: 'xapdisplayfield',
		fieldLabel: '日期格式化',
		labelAlign:'right',
		width: 330,
        labelWidth:70,
		vertical: true,
		colspan:2,
		name:'formatInfo',
		value: 'YYYY年 MM月 DD日  hh时 mm分',
		margin:'0 0 0 0'
    },{
        xtype:'xapcombobox',
        name:'showFormat',
        width: 260,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'时间格式',
        colspan:2,
        comboData : [
//             {"code":'', "value":"请选择"},
             {"code":'YYYY-MM-DD hh:mm', "value":"YYYY-MM-DD hh:mm"},
             {"code":'YYYY/MM/DD hh:mm', "value":"YYYY/MM/DD hh:mm"},
             {"code":'YYYY.MM;hh:mm', "value":"YYYY.MM;hh:mm"},
             {"code":'YYYY-MM-DD', "value":"YYYY-MM-DD"},
             {"code":'YYYY/MM/DD', "value":"YYYY/MM/DD"},
             {"code":'YYYY年MM月DD日', "value":"YYYY年MM月DD日"},
             {"code":'YYYY年MM月DD日 hh时mm分', "value":"YYYY年MM月DD日 hh时mm分"},
             {"code":'YYYY-M-D h时m分', "value":"YYYY-M-D h时m分"},
             {"code":'YYYY.MM.DD', "value":"YYYY.MM.DD"},
             {"code":'hh:mm', "value":"hh:mm"}
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:true,
        editable:true,
        value:''
    },{
    	xtype:'xapdisplayfield',
		name:'dateTimeValueShow',
		colspan:2,
		fieldLabel:'格式预览',
		width: 330,
        labelWidth:70,
        labelAlign:'right',
		padding:'0 0 0 0'
	},{
        xtype:'xapcombobox',
        name:'precision',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'小数点位数',
        colspan:2,
        comboData : [
             {"code":'', "value":"请选择"},
             {"code":'1', "value":"1"},
             {"code":'2', "value":"2"},
             {"code":'2', "value":"3"},
             {"code":'2', "value":"4"}
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:true,
        editable:false,
        value:''
    },{
        xtype:'xaptextfield',
        name:'minValue',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'值域范围',
        allowBlank:true,
        blankText:'请输入数值！'
    },{
        xtype:'xaptextfield',
        name:'maxValue',
        width: 100,
        labelWidth:10,
        labelAlign:'right',
        fieldLabel:'~',
        labelSeparator:'',
        allowBlank:true,
        blankText:'请输入数值！'
    },{
        xtype:'xaptextfield',
        name:'normalMinValue',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'正常值范围',
        allowBlank:true,
        blankText:'请输入数值！'
    },{
        xtype:'xaptextfield',
        name:'normalMaxValue',
        width: 100,
        labelWidth:10,
        labelAlign:'right',
        fieldLabel:'~',
        labelSeparator:'',
        allowBlank:true,
        blankText:'请输入数值！'
    },/*{
        xtype:'xapnumberfield',
        name:'textLong',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'字符长度',
        allowBlank:true,
        blankText:'请输入数值！'
    },{
    	xtype: 'xapdisplayfield',
		width: 160,
		vertical: true,
		name:'textUnit',
		value: '字符',
		margin:'0 0 0 0'
    },*/{
        xtype:'xapcombobox',
        name:'valueType',
        width: 160,
        labelWidth:70,
        labelAlign:'right',
        fieldLabel:'值域类型',
        comboData : [
             {"code":'', "value":"请选择"},
             {"code":'dictionary', "value":"字典值域"},
             {"code":'custom', "value":"自定义值域"}
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:true,
        editable:false,
        value:''
    },{
    	xtype: 'xapdisplayfield',
		width: 160,
		vertical: true,
		name:'deCdShow',
		value: '',
		margin:'0 0 0 0'
    },{
		 title:'',
		 colspan:2,
		 name:'custormPanel',
		 border:0,
		 items:[{
			  title:'值域',
		      xtype: 'xapgrid',
		      action:'valuegrid',
		      name:'custormRange',
		      height:170,
		      width:'420',
		      autoScroll:true,
			  checkboxShow:true,
			  mode:'multi',
			  showHeaderCheckbox:true,
		      selType: 'cellmodel',
		      plugins: [
				   Ext.create('Ext.grid.plugin.CellEditing', {
						 clicksToEdit: 1
			       })
		        ],
			  margin:'0 0 0 25',
			  tools:[{
				   xtype:'button',
				   text:'新增',
				   action:'addVaBtn',
				   iconCls: 'icon-Create',
				   handler: function(b,e) {
                       var grid = b.up('xapgrid[name=custormRange]');
                       console.log(grid);
                       var store = grid.getStore();
                       var n = store.getCount();
                       var data = {};
                       data.name ='';
                       data.value ='';
                       store.add(data);
                   }
			  },{
				   xtype:'button',
				   text:'删除',
				   action:'delVaBtn',
				   iconCls: 'icon-Delete',
				   handler:function(b,e){
                       var grid = b.up('xapgrid[name=custormRange]');
                       console.log(grid);
                       var store = grid.getStore();
                       var rows = grid.getSelectionModel().getSelection();
                       var msg = '最少选择一条信息，进行删除!';
                       if(rows.length==0){
                    	   XapMessageBox.info(msg);
                       }else{
                    	   Ext.MessageBox.confirm('提示框', '您确定要进行该操作？',function(btn){
		                       if(btn=='yes'){
			                       if(rows){
				                       for (var i = 0; i < rows.length; i++) {
					                       store.remove(rows[i]);
				                       }
			                       }
		                       }
	                       });
                       }
				   }
			  }],
			  CM_JR_Record:[{
		            	 header: '值含义', 
		            	 dataIndex: 'name',
		            	 editor: 'textfield' , 
		            	 width:120,
		            	 
		             },{
		            	 header: '值', 
		            	 dataIndex: 'value',
		            	 editor: 'textfield' ,
		            	 width:40
		             },{
		            	 header: '显示', 
		            	 dataIndex: 'thumbnail',
		            	 editor: 'textfield' , 
		            	 flex:1
		             }],
		 	}]
	},{
        xtype:'xaptextfield',
        name:'descriptions',
        hidden:true
    },{
        xtype:'xaptextfield',
        name:'deCd',
        hidden:true
    },{
        xtype:'xaptextfield',
        name:'id',
        hidden:true
    },{
        xtype:'xaptextfield',
        name:'dateTimeValue',
        hidden:true
    }],
	
	buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认',
        iconCls: 'icon-OK'/*,
        handler:function(btn,e){
        	//提交树信息
            var form = this.up('formxmleditblock');
            if(form.isValid()){
                var view = this.up('formxmlview');
                var chain = view.getActionChain('save');
                chain.execute();
            }
        }*/
    },{
        xtype: "button",
        name: 'save',
        method:'save',
        text: '保存',
        iconCls: 'icon-save'
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        text: '取消',
        iconCls: 'icon-cancel',
        handler:function(btn,e){
            var win = this.up('window');
            win.close();
            var plugin = document.getElementById('iemrEditor'); 
            plugin.EnableOCX(true);//设置编辑器可用
        }
    },{
        xtype: "button",
        name: 'reset',
        method:'reset',
        text: '重置',
        iconCls: 'icon-reset'
    }],

	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
})