Ext.define('iih.mr.di.block.InDiagnosisBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],

    alias:'widget.indiagnosisblock',
    
    border:0,
   
    items: [{
        title: '诊断列表',
        xtype: 'xapgrid',       
        height:350,
        name:'diListGrid',
        ifSelect : true,
        selectBy: 'diSn',

        tools:[{
           xtype:'button',
           text:'子诊断',
           method: 'sonDi',
           margin:'0 0 0 10',
           disabled:true
       	},{
           xtype:'button',
           text:'编辑',
           method: 'editDi',
           margin:'0 0 0 10',
           disabled:true
       	},{
           xtype:'button',
           text:'删除',
           method: 'delDi',
           margin:'0 0 0 10',
           disabled:true
       	}],
//        height:550,
        CM_JR_Record: [
        	 {header: '诊断主键',dataIndex: 'diSn',field: 'textfield' ,type: 'string',hidden:true},
        	 {header: '父诊断主键',dataIndex: 'parDiSn',field: 'textfield' ,type: 'string',hidden:true},
        	 {header: '主诊断',dataIndex: 'mainF',field: 'textfield' ,type: 'string',hidden:true},
        	 {header: '诊断类别编码',dataIndex: 'diTypeCd',field: 'textfield' ,type: 'string',width:150,hidden:true},
        	 {header: '诊断编码',dataIndex: 'diCd',field: 'textfield' ,type: 'string',flex:1,hidden:true},
             {header: '诊断类别',dataIndex: 'diTypeNm',field: 'textfield' ,type: 'string',width:150},
             {header: '诊断名称',dataIndex: 'diNm',field: 'textfield' ,type: 'string',flex:1},
             {header: 'ICD编码',dataIndex: 'icdCd',field: 'textfield' ,type: 'string',width:150},
             {header: '诊断内容',dataIndex: 'addDescr',field: 'textfield' ,type: 'string',flex:1},
             {header: '诊断描述',dataIndex: 'memo',field: 'textfield' ,type: 'string',flex:1},
             {header: '诊断医师',dataIndex: 'diEmpNm',field: 'textfield' ,type: 'string',width:150},
             {header: '诊断时间',dataIndex: 'diTime',xtype: 'xapdatecolumn',width:150}
        ]
    },{
    	xtype:'xapform',   
    	trackResetOnLoad:true,
    	height:200,
    	title: '诊断新增',
    	name:'diForm',
    	layout: {
		type: 'table',
		columns: 2,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%'
//            height:76
        },
        tdAttrs: {
            valign: 'left'
        }
	},
    
	    buttons:[{
	            xtype: "button",
	            name: 'saveDi',
	            action:'saveDi',
	            text: '保存',
	            iconCls: 'icon-OK'
	        },{
	            xtype: "button",
	            name: 'cancel',
	            action:'cancel',
	            text: '取消',
	            iconCls: 'icon-cancel'
	        }],
	    
	    items:[{
	    	xtype:'xaptextfield',
	        name:'diSn',
	        width:260,
	        labelAlign : 'right',
			fieldLabel:'诊断主键',
			margin:'10 0 0 0',
			hidden:true
	    },{
	    	xtype:'xaptextfield',
	        name:'parDiSn',
	        width:260,
	        labelAlign : 'right',
			fieldLabel:'父诊断编码',
			margin:'10 0 0 0',
			hidden:true
	    },{
	        xtype:'xapcombobox',
	        labelAlign : 'right',
	        name:'diTypeCd',
			fieldLabel:'诊断类别',
			editable:false,
//			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
			 			{"value":"01", "text":"入院诊断"},
			 			{"value":"02", "text":"出院诊断"},
			 			{"value":"03", "text":"补充诊断"}
			 		]
	    },{
	    	xtype:'comboxgrid',
			margin:'10 0 0 0',
			name:'diCd', 
            method:'diCd',
//			url: 'di/asistantInput',
			labelAlign : 'right',
//			labelWidth : 50,
			listWidth:230,    //gird的宽度
			width:260,        //combo的宽度
            fieldLabel:'诊断名称',
			valueField : 'value',
            searchParam :['keyword'],
            columns: [{
                text: '科室编码',
                dataIndex: 'value',
                hidden:true
            },{
                text: '诊断名称',
                flex:1,
                dataIndex: 'text'
            }],
            displayField: 'text',
            dictionary:'diagnosisCdLoad',
            parentXtype:'indiagnosisblock',
            setValue:function(v){
            	this.value = v;
            },
            callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
				var view = this.up('indiagnosisview');
				var showIcdChain = view.getActionChain('showIcd');
				showIcdChain.execute({
					record:record
				});
			}
	},{
  		xtype: 'datetimefield',
  		width:260,
  		name:'diTime',
  		fieldLabel:'诊断日期',
  		labelAlign : 'right',
  		margin:'10 0 0 0'
	},{
    	xtype:'xaptextfield',
        name:'icdCd',
        width:260,
        labelAlign : 'right',
		fieldLabel:'ICD编码',
		margin:'10 0 0 0',
		readOnly:true
    },{
    	xtype:'xaptextfield',
        name:'addDescr',
        width:260,
        labelAlign : 'right',
		fieldLabel:'诊断内容',
		margin:'10 0 0 0'
    },{
    	xtype:'xaptextfield',
        name:'memo',
        width:260,
        labelAlign : 'right',
		fieldLabel:'诊断描述',
		margin:'10 0 0 0'
    },{
			xtype: 'xapradiogroup',
			name:'mainFgroup',
			fieldLabel:'主诊断标志',
			margin:'10 0 10 30',
			items: [
				{boxLabel: '是', name: 'mainF',width:85, inputValue: '1'},
				{boxLabel: '否', name: 'mainF', width:85,inputValue: '0',checked: true}
			]
		},{
			xtype: 'xapdisplayfield',
			fieldLabel: '',
			vertical: true,
			name:'showInfo',
			value: '',
			margin:'10 0 10 50'
		}]

    }],
    
    setData : function(data) {
        var grid = this.down('xapgrid');
        if(grid){
        	if(data){
        		grid.setData(data);
	        }else{
	        	grid.setData({});
	        }
        }
    }
	
});