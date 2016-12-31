Ext.define('iih.mr.tm.mr.block.MrTemplatePropertyEditViewBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.field.ComboBoxGrid',
        'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.TextArea'
	],

	alias:'widget.mrtemplatepropertyeditviewblock',

	layout: {
        type: 'table',
        columns: 2,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            width: '100%'
        },
        tdAttrs: {
            valign: 'left'
        }
    },
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认',
        iconCls: 'icon-OK'
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        text: '取消',
        iconCls: 'icon-cancel'
    }],
	items: [   
            {           
                xtype: "xaptextfield",
                name: 'enTypeCode',
                hidden:true
            },{           
                xtype: "xaptextfield",
                name: 'xmlFilePk',
                hidden:true
            },{           
                xtype: "xaptextfield",
                name: 'customerData',
                hidden:true
            },{           
                xtype: "xaptextfield",
                name: 'dctNsF',
                hidden:true
            },{           
                xtype: "xaptextfield",
                name: 'verMrTplKc',
                hidden:true
            },{           
	            xtype: "xapcombobox",
                labelWidth:90,
                labelAlign:'right',
	            name: 'mrTypeCd',
                allOptions:false,
                editable: false,	            
	            fieldLabel: '病历文书类型',
	            displayField: 'name',		            
	            valueField: 'code'/*,
	            listeners :{
                    'beforerender':function(){
                    	var view = this.ownerCt.ownerCt;
                    	var initChain = view.getActionChain('mrTypeCdInit');
   						initChain.execute();
                    }
	            }*/
	            //dictionary:'MRM16'            
            },{
	            xtype:'xapcombobox',
                labelWidth:60,
                labelAlign:'right',
                name:'baseTemplateCode',
	            fieldLabel:'基础模板:',
                allOptions:false,
                editable: false,    
	            displayField: 'name',		            
	            valueField: 'code',
	            listeners :{
                    'beforerender':function(){
                    	var view = this.ownerCt.ownerCt;
                    	 var initChain = view.getActionChain('baseTplInit');
   						 initChain.execute();
   						//debugger;
                    }
	            }
            },{
                xtype:'xaptextfield',
                labelWidth:90,
                labelAlign:'right',
                name:'mrTplNm',
                fieldLabel:'模板名称:'
            },{
            	xtype:'comboxgrid',
                labelWidth:60,
                labelAlign:'right',
                anchor: "90%",
                width:220,
                name:'diCds', 
                method:'dept',
                fieldLabel:'适用病种:',
                valueField : 'value',
                searchParam :['keyword'],
                columns: [{
                    text: '科室编码',
                    dataIndex: 'value',
                    hidden:true
                },{
                    text: '适用病种编码',
                    flex:1,
                    dataIndex: 'text'
                }],
                displayField: 'text',
                dictionary:'diagnosisCdLoad',
                parentXtype:'mrtemplatepropertyeditviewblock',
                callback:function(newValue,oldValue,record){
                	//this.setRecordData({keyword:record.text,code:record.value});
                }
            },{
                xtype:'xapcombobox',
                labelWidth:90,
                labelAlign:'right',
                name:'ownerTypeCode',
                fieldLabel:'模板所属类别:',   
                //editable: false,    
                /*comboData : [
  		                    {"ownerTypeCode":"MDM08.01", "name":"全院"},
  		                    {"ownerTypeCode":"MDM08.02", "name":"科室"},
  		                    {"ownerTypeCode":"MDM08.03", "name":"个人"}
  	            ],*/
 		        displayField: 'name',
 		        valueField: 'ownerTypeCode'/*
                dictionary:'MDM08'  */           
            },{
                xtype:'comboxgrid',
                url: 'organization/keyword',//科室查询的url
                fieldLabel:'模板所属:',
                labelWidth:60,
                labelAlign:'right',
                listWidth:320,    //gird的宽度
                name:'deptCode', 
                width:220,        //combo的宽度
                valueField : 'code',//科室编码的字段名
                displayField: 'name',//科室名称的字段名
                columns: [{              //grid的column配置
                   text: '科室编码',
                   dataIndex: 'code',
                   width:150
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
	            xtype:'xapcombobox',
                labelWidth:90,
                labelAlign:'right',
                name:'signLevelCode',
	            fieldLabel:'审签级别:',
	            comboData : [
	 		                    {"signLevelCode":"MRM02.01", "name":"无需审签"},
	 		                    {"signLevelCode":"MRM02.02", "name":"一级审签"},
	 		                    {"signLevelCode":"MRM02.03", "name":"二级审签"},
	 		                    {"signLevelCode":"MRM02.04", "name":"三级审签"}
	 	            ],
                allOptions:false,
                editable: false,    
	            displayField: 'name',		            
	            valueField: 'signLevelCode'
            },{
            	xtype:'xaptextarea',
            	labelWidth:60,
            	height:40,
                labelAlign:'right',
                name :'description',
                fieldLabel:'描述:',
                width:250
        },{
        	xtype: 'xapdisplayfield',
			fieldLabel: '',
			colspan:2,
			vertical: true,
			name:'msgInfo',
			value: '',
			margin:'0 0 0 0'
    }],
    
      initComponent: function() {
    	  var tabItems = this.items[9];
          if(CONFIG_PARAM.MR_TPL_OWNER_TYPE){
        	  tabItems.comboData = this.createOwnerType();
          }else{
        	  tabItems.comboData = this.createOwnerType1();
          }
          this.callParent();
      },
      
      createOwnerType: function() {
          var comboData = [
	            {"ownerTypeCode":"MDM08.01", "name":"全院"},
	            {"ownerTypeCode":"MDM08.02", "name":"科室"},
	            {"ownerTypeCode":"MDM08.03", "name":"个人"}
            ];
          return comboData;
      },
      createOwnerType1: function() {
          var comboData = [
	            {"ownerTypeCode":"MDM08.01", "name":"全院"},
	            {"ownerTypeCode":"MDM08.02", "name":"科室"}
            ];
          return comboData;
      },
    
	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
    
})