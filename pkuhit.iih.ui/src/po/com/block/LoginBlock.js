Ext.define('iih.po.com.block.LoginBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
        'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.DisplayField',
        'iih.po.com.block.PluginBlock',
        'Xap.ej.element.objectview.ObjectView'
	],

	alias:'widget.loginblock',
	
	hidden: true,
	
	bodyStyle: {
		background:'#ffffff',
		border:'1px solid #000000'
	},
	layout: {
		type: 'table',
		tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            align: 'center'
        },
        tdAttrs: {
            valign: 'middle'
        }
	},
	items:[
	   {
		xtype:'panel',
		width:1024,
		height:768,
		layout: {
			type: 'table',
			columns: 16,
			tableAttrs: {
	            border: 0,
	            align: 'right'
	        },
	        tdAttrs: {
	        	width:20,
	            valign: 'middle'
	        }
		},
		bodyStyle:{
			background:'url(css/images/login/login.png) no-repeat'
		},
		items: [
		/*{
			xtype:'panel',
			height:200,
			border:0,
			colspan:16,
			margin:'0 0 0 0'
		},
		
		{
			html:'<div></div>',
			border:0,
			colspan:16,
			margin:'0 0 0 30',
			width:332,
			height:36,
			bodyStyle:{
				fontSize:'36px',
				fontFamily:'微软雅黑',
				fontWeight:'bold',
				color:'#0174B6',
				background:'url(css/images/login/login-title.jpg) no-repeat'
			}
		},*/
		
		{
			xtype:'panel',
			height:15,
			border:0,
			colspan:16,
			margin:'250 0 0 50',
			bodyStyle:'background:#FCFCFC'
			
		},
		
		{
			html:'<div style=\'width:60px;margin:0 10px 0 30px;background:#FCFCFC;color:#7C7C7C;font-weight:bold;font-size:16px;font-family:黑体\'>用户名</div>',
			border:0,
			margin:'0 0 0 30',
			bodyStyle:'background:#FCFCFC'
			
			
		},{
			xtype: 'xaptextfield',
			colspan:15,
			name:'username',
			allowBlank:false,
			height:40,
			width:200,
			margin:'0 0 0 0',
		},{
            xtype: 'xapcombobox',
            colspan:15,
            name:'causer',
            hidden: true,
            allowBlank:false,
            //height:40,
            width:200,
            margin:'0 0 0 0'
        },
		{
			xtype:'panel',
			colspan:16,
			height:15,
			border:0,
			margin:'0 0 0 30',
			bodyStyle:'background:#FCFCFC'
		},
		
		{
			html:'<div style=\'width:50px;margin:0 10px 0 43px;background:#FCFCFC;color:#7C7C7C;font-weight:bold;font-size:16px;font-family:黑体\'>密码</div>',
			border:0,
			margin:'0 0 0 30',
			bodyStyle:'background:#FCFCFC'
		},{
			xtype: 'xaptextfield',
			colspan:15,
			name:'password', 
	        inputType:'password',
	        allowBlank:false, 
	        enableKeyEvents:true,  
	        height:40,
			width:200,
			margin:'0 0 0 0',
		},{
            xtype: 'xaptextfield',
            colspan:15,
            name:'capass', 
            inputType:'password',
            hidden: true,
            allowBlank:false, 
            enableKeyEvents:true,  
            //height:40,
            width:200,
            margin:'0 0 0 0',
        },
        {
            xtype:'panel',
            height:15,
            border:0,
            colspan:16,
            margin:'0 0 0 30',
            bodyStyle:'background:#FCFCFC'
            
        },
		{
			xtype: 'xapcheckboxgroup',
			name: 'rememberCheck',
			vertical: true,
			colspan:16,
			items: [
				{ boxLabel: '记住我的登录信息', name: 'rememberInfo', inputValue: '1' ,style:'height:20px;lineHeight:20px;font-size:18px;color:#7C7C7C'}
			],
			margin:'0 0 0 70'
		},
		
		{
            xtype: 'xapcheckboxgroup',
            name: 'caCheck',
            vertical: true,
            colspan:16,
            //items: [  //lizheng 注释ca登录显示
             //   { boxLabel: 'CA登录', name: 'caLogin', inputValue: '1' ,style:'height:20px;lineHeight:20px;font-size:18px;color:#7C7C7C'}
           // ],
            margin:'0 0 0 70'
        },
		{
			xtype: 'xapdisplayfield',
			fieldLabel: '',
			colspan:16,
			vertical: true,
			name:'showInfo',
			value: '',
			margin:'0 0 0 0'
		},
		
		{
			xtype:'panel',
			height:20,
			border:0,
			colspan:16,
			margin:'0 0 0 30',
			bodyStyle:'background:#FCFCFC'
			
		},
		
		{
			xtype:'button',
	        colspan:12,
	        style:{
	        	width:'201px',
	        	height:'40px',
	        	background:'url(css/images/login/login-button.png) no-repeat'
	        },
	        method: 'login',
	        action:'login',
	        margin:'0 0 0 30'
	        
	    },{
			xtype:'button',
			cls:'button_edit',
	        colspan:4,
	        //iconCls: 'icon-reset',
	        method: 'reset',
	        action:'reset',
	        margin:'0 0 0 30',
	        style:{
	        	width:'95px',
	        	height:'40px',
	        	background:'url(css/images/login/login-reset.png) no-repeat'
	        }
	    },{
            xtype: 'xaptextfield',
            colspan:15,
            name:'randomValue',
            hidden:true
        },{
            xtype: 'xaptextfield',
            colspan:15,
            name:'signValue',
            hidden:true
        },{
            xtype: 'pluginblock',
            pluginId: 1
        }]
	}],

	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }

})