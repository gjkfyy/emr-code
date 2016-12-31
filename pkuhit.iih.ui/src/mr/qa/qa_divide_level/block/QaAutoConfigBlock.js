/** 
 * 自动质控时限规则BLOCK
 * @extends Xap.ej.block.Block
 * @author ：yao_lijie
 */
var me;
Ext.define('iih.mr.qa.qa_divide_level.block.QaAutoConfigBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.qaautoconfigblock',
    
    border:0,
   
    items: [{
        xtype:'xapform',
        title:'自动质控项配置',
        tools:[{
        xtype:'xapcombobox',
        labelAlign : 'right',
        name:'qaItmTpCd',
		fieldLabel:'质控项目类别',
		editable:false,
		margin:'0 800 0 0',
		width:180,
//		value:'QAM06.02',
		comboData : [
			{"value":"QAM06.02", "text":"时限性"},
			{"value":"QAM06.05", "text":"频率性"},
			{"value":"QAM06.04", "text":"完整性"},
			{"value":"QAM06.03", "text":"依赖性"}
		]
			}
		],
        border:false, 
        items:[{
        	xtype:'xapform',
        	name:'timeAuto',
//        	hidden:true,
        	formType:'1',
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
	            name: 'saveTime',
	            action:'saveTime',
	            text: '保存',
	            iconCls: 'icon-OK'
	        }/*,{
	            xtype: "button",
	            name: 'cancel',
	            action:'cancel',
	            text: '取消' ,
	            iconCls: 'icon-cancel' 
	    }*/],
	    
	    items:[{
	        xtype:'xaptextfield',
	        name:'qaItmConfigCd',
			fieldLabel:'自动配置项编码',
			hidden:true
	    },{
	        xtype:'xaptextfield',
	        name:'qaItmCd',
			fieldLabel:'质控项目编码',
			hidden:true
	    },{
	    	xtype:'xaptextfield',
	        name:'req',
	        width:400,
	        labelAlign : 'right',
			fieldLabel:'规则名称',
			allowBlank:false,
			margin:'10 0 0 0',
			readOnly:true
	    },{
	        xtype:'xapcombobox',
	        name:'mrTypes',
	        margin:'10 0 0 0',
	        labelAlign : 'right',
	        colspan: 3,
	        editable:false,
	        multiSelect : true, //多选
	        fieldLabel:'文书类型',
	        queryMode: 'local',
	        displayField: 'name',
	        valueField: 'code',
	        id:"mrTypesTip"
	    },{
	    	xtype:'xaptextfield',
	        name:'memo',
	        width:400,
	        labelAlign : 'right',
			fieldLabel:'规则描述',
			allowBlank:false,
			margin:'10 0 0 0'
	    },{
	        xtype:'xapcombobox',
	        labelAlign : 'right',
	        name:'eventTypeCode',
			fieldLabel:'事件类型',
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
				{"value":"01", "text":"入院（入科）"},
				{"value":"02", "text":"出院（出科）"},
	//			{"value":"03", "text":"手术"},
				{"value":"04", "text":"转科"},
				{"value":"05", "text":"病情稳定"},
				{"value":"06", "text":"病情危急"},
				{"value":"07", "text":"病情危重"},
	//			{"value":"08", "text":"抢救"},
				{"value":"09", "text":"死亡"},
				{"value":"11", "text":"会诊申请医嘱"},
				{"value":"02,09", "text":"出院/死亡"},
				{"value":"03,10", "text":"手术"}
			]
	    },{
	        xtype:'xapnumberfield',
	        margin:'10 0 0 0',
	        name:'deadHours',
			fieldLabel:'规则运算值',
			labelAlign : 'right',
			maxValue: 100,
			minValue: 0
	    },{
	        xtype:'xapcombobox',
	        labelAlign : 'right',
	        name:'unit',
			fieldLabel:'单位',
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
				{"value":"time", "text":"小时"},
				{"value":"day", "text":"天"}
			]
	    },{
			xtype: 'xapradiogroup',
			fieldLabel:'是否启用',
			margin:'10 0 10 40',
			items: [
				{boxLabel: '是', name: 'useFlag',width:85, inputValue: '1'},
				{boxLabel: '否', name: 'useFlag', width:85,inputValue: '0',checked: true}
			]
		},{
	        xtype:'xapcombobox',
	        labelAlign : 'right',
	        name:'mrOpType',
			fieldLabel:'文书操作类型',
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
				{"value":"01", "text":"提交"},
				{"value":"02", "text":"主治医师审核"}
			]
	    },{
	        xtype:'xapnumberfield',
	        margin:'0 0 10 0',
	        name:'reTimeRemind',
			fieldLabel:'剩余时间提醒值',
			labelAlign : 'right',
			maxValue: 100,
			minValue: 0
	    },{
			xtype: 'xapdisplayfield',
			fieldLabel: '',
			colspan:16,
			vertical: true,
			name:'showInfo',
			value: '',
			margin:'0 50 10 80'
		}]
	        	
    },{
        	xtype:'xapform',
        	name:'frequencyAuto',
        	formType:'2',
        	hidden:true,
        	layout: {
			type: 'table',
			columns: 12,
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
	            name: 'saveFrequency',
	            action:'saveFrequency',
	            text: '保存',
	            iconCls: 'icon-OK'
	        }],
	    
	    items:[{
	        xtype:'xaptextfield',
	        name:'qaItmConfigCd',
			fieldLabel:'自动配置项编码',
			hidden:true
	    },{
	        xtype:'xaptextfield',
	        name:'qaItmCd',
			fieldLabel:'质控项目编码',
			hidden:true
	    },{
	    	xtype:'xaptextfield',
	    	colspan: 6,
	        name:'req',
	        width:400,
	        labelAlign : 'right',
			fieldLabel:'规则名称',
			allowBlank:false,
			margin:'10 0 0 0',
			readOnly:true
	    },{
	        xtype:'xapcombobox',
	        colspan: 6,
	        name:'mrTypes',
	        margin:'10 0 0 0',
	        labelAlign : 'right',
	        editable:false,
	        multiSelect : true, //多选
	        fieldLabel:'文书类型',
	        queryMode: 'local',
	        displayField: 'name',
	        valueField: 'code',
	        id:"mrTypesTip1"
	    },{
	    	xtype:'xaptextfield',
	    	colspan: 6,
	        name:'memo',
	        width:400,
	        labelAlign : 'right',
			fieldLabel:'规则描述',
			allowBlank:false,
			margin:'10 0 0 0'
	    },{
	        xtype:'xapcombobox',
	        colspan: 6,
	        labelAlign : 'right',
	        name:'eventTypeCode',
			fieldLabel:'事件类型',
//			multiSelect : true, //多选
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
				{"value":"01", "text":"入院（入科）"},
				{"value":"02", "text":"出院（出科）"},
	//			{"value":"03", "text":"手术"},
				{"value":"04", "text":"转科"},
				{"value":"05", "text":"病情稳定"},
				{"value":"06", "text":"病情危急"},
				{"value":"07", "text":"病情危重"},
	//			{"value":"08", "text":"抢救"},
				{"value":"09", "text":"死亡"},
				{"value":"11", "text":"会诊申请医嘱"},
				{"value":"02,09", "text":"出院/死亡"},
				{"value":"03,10", "text":"手术"}
			]
	    },{
	        xtype:'xapdisplayfield',
	        vertical: true,
	        margin:'10 0 0 0',
			fieldLabel:'规则运算值',
			width:70,
			labelAlign : 'right'
	    },{
			xtype: 'xapdisplayfield',
			margin:'10 0 0 0',
			fieldLabel: '',
			vertical: true,
			value:'频率'
		},{
	        xtype:'xapradio',
	        margin:'10 0 0 0',
	        vertical: true,
	        checked : true,
	        name:'qaRlTpCd',
	        inputValue: '01',
			labelAlign : 'left'
	    },{
	        xtype:'xapnumberfield',
	        name:'repNum',
	         margin:'10 0 0 0',
	         width:100,
	        vertical: true,
			maxValue: 100,
			minValue: 0,
			labelAlign : 'left'
	    },{
	        xtype:'xapdisplayfield',
	        margin:'10 0 0 0',
//	        width:250,
	        vertical: true,
			fieldLabel:'',
			labelAlign : 'left',
			value:'天/次'
	    },{
	        xtype:'xapdisplayfield',
	        margin:'10 200 0 0',
	        vertical: true
	    },{
	        xtype:'xapdisplayfield',
	        colspan:6,
	        vertical: true
	    },{
	        xtype:'xapdisplayfield',
	        width:110,
	        vertical: true
	    },{
			xtype: 'xapdisplayfield',
			margin:'10 0 0 0',
			fieldLabel: '',
			vertical: true,
			value:'连续'
		},{
	        xtype:'xapradio',
	        margin:'10 0 0 0',
	        vertical: true,
	        name:'qaRlTpCd',
	        inputValue: '02',
			labelAlign : 'right'
	    },{
	        xtype:'xapnumberfield',
	        margin:'10 0 0 0',
	        width:100,
	        name:'conNum',
	        vertical: true,
			fieldLabel:'',
			labelAlign : 'left'
	    },{
	        xtype:'xapdisplayfield',
	        vertical: true,
			fieldLabel:'',
			margin:'10 0 0 0',
			labelAlign : 'left',
			value:'天'
	    },{
	        xtype:'xapdisplayfield',
	        margin:'10 200 0 0',
	        vertical: true
	    },{
	        xtype:'xapdisplayfield',
	        colspan:6,
	        vertical: true
	    },{
			xtype: 'xapradiogroup',
			colspan:6,
			fieldLabel:'是否启用',
			margin:'10 0 10 40',
			items: [
				{boxLabel: '是', name: 'useFlag',width:85, inputValue: '1'},
				{boxLabel: '否', name: 'useFlag', width:85,inputValue: '0',checked: true}
			]
		},{
	        xtype:'xapcombobox',
	        colspan:6,
	        labelAlign : 'right',
	        name:'mrOpType',
			fieldLabel:'文书操作类型',
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
				{"value":"01", "text":"提交"},
				{"value":"02", "text":"主治医师审核"}
			]
	    },{
			xtype: 'xapdisplayfield',
			fieldLabel: '',
			colspan:16,
			vertical: true,
			name:'showInfo',
			value: '',
			margin:'10 50 10 80'
		}]
    },{
        	xtype:'xapform',
        	name:'integrityAuto',
        	hidden:true,
        	formType:'3',
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
	            name: 'saveIntegrity',
	            action:'saveIntegrity',
	            text: '保存',
	            iconCls: 'icon-OK'
	        }],
	    
	    items:[{
	        xtype:'xaptextfield',
	        name:'qaItmConfigCd',
			fieldLabel:'自动配置项编码',
			hidden:true
	    },{
	        xtype:'xaptextfield',
	        name:'qaItmCd',
			fieldLabel:'质控项目编码',
			hidden:true
	    },{
	    	xtype:'xaptextfield',
	        name:'req',
	        width:400,
	        labelAlign : 'right',
			fieldLabel:'规则名称',
			allowBlank:false,
			margin:'10 0 0 0',
			readOnly:true
	    },{
	        xtype:'xapcombobox',
	        name:'mrTypes',
	        margin:'10 0 0 0',
	        labelAlign : 'right',
	        editable:false,
	        multiSelect : true, //多选
	        fieldLabel:'文书类型',
	        queryMode: 'local',
	        displayField: 'name',
	        valueField: 'code',
	        id:"mrTypesTip2"
	    },{
	    	xtype:'xaptextfield',
	        name:'memo',
	        width:400,
	        labelAlign : 'right',
			fieldLabel:'规则描述',
			allowBlank:false,
			margin:'10 0 0 0'
	    },{
	        xtype:'xapcombobox',
	        labelAlign : 'right',
	        name:'eventTypeCode',
			fieldLabel:'事件类型',
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			comboData : [
				{"value":"01", "text":"入院（入科）"},
				{"value":"02", "text":"出院（出科）"},
	//			{"value":"03", "text":"手术"},
				{"value":"04", "text":"转科"},
				{"value":"05", "text":"病情稳定"},
				{"value":"06", "text":"病情危急"},
				{"value":"07", "text":"病情危重"},
	//			{"value":"08", "text":"抢救"},
				{"value":"09", "text":"死亡"},
				{"value":"11", "text":"会诊申请医嘱"},
				{"value":"02,09", "text":"出院/死亡"},
				{"value":"03,10", "text":"手术"}
			]
	    },{
	        xtype:'xapcombobox',
	        name:'jobTitleCd',
	        margin:'10 0 0 0',
	        labelAlign : 'right',
	        editable:false,
	        multiSelect : true, //多选
	        fieldLabel:'医师职称',
	        value : "",
	        comboData : [
	        	{"value":"", "text":"无"},
				{"value":"MRM20.01", "text":"住院医师"},
				{"value":"MRM20.02", "text":"主治医师"},
				{"value":"MRM20.03", "text":"副主任医师"},
				{"value":"MRM20.04", "text":"主任医师"}
			]
//	        dictionary:'MRM20'
	    },{
	        xtype:'xapcombobox',
	        labelAlign : 'right',
	        name:'dctOpTpCd',
			fieldLabel:'医师操作类型',
			editable:false,
			allowBlank:false,
			margin:'10 0 0 0',
			value:'',
			comboData : [
				{"value":"", "text":"无"},
				{"value":"01", "text":"提交"},
				{"value":"02", "text":"查房"}
			]
	    },{
			xtype: 'xapradiogroup',
			fieldLabel:'是否启用',
			margin:'10 0 10 40',
			items: [
				{boxLabel: '是', name: 'useFlag',width:85, inputValue: '1'},
				{boxLabel: '否', name: 'useFlag', width:85,inputValue: '0',checked: true}
			]
		},{
			xtype: 'xapdisplayfield',
			fieldLabel: '',
			vertical: true,
			name:'showInfo',
			value: '',
			margin:'10 50 10 80'
		}]
	        	
    
    },{

    	xtype:'xapform',
    	name:'dependentAuto',
    	hidden:true,
    	formType:'3',
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
            name: 'saveDependent',
            action:'saveDependent',
            text: '保存',
            iconCls: 'icon-OK'
        }],
    
    items:[{
        xtype:'xaptextfield',
        name:'qaItmConfigCd',
		fieldLabel:'自动配置项编码',
		hidden:true
    },{
        xtype:'xaptextfield',
        name:'qaItmCd',
		fieldLabel:'质控项目编码',
		hidden:true
    },{
    	xtype:'xaptextfield',
        name:'req',
        width:400,
        labelAlign : 'right',
		fieldLabel:'规则名称',
		allowBlank:false,
		margin:'10 0 0 0',
		readOnly:true
    },{
        xtype:'xapcombobox',
        name:'mrTypes',
        margin:'10 0 0 0',
        labelAlign : 'right',
        editable:false,
        multiSelect : true, //多选
        fieldLabel:'文书类型',
        queryMode: 'local',
        displayField: 'name',
        valueField: 'code',
        id:"mrTypesTip3"
    },{
    	xtype:'xaptextfield',
        name:'memo',
        width:400,
        labelAlign : 'right',
		fieldLabel:'规则描述',
		allowBlank:false,
		margin:'10 0 0 0'
    },{
		xtype: 'xapradiogroup',
		fieldLabel:'是否启用',
		margin:'10 0 10 40',
		items: [
			{boxLabel: '是', name: 'useFlag',width:85, inputValue: '1'},
			{boxLabel: '否', name: 'useFlag', width:85,inputValue: '0',checked: true}
		]
	},{
        xtype:'xapcombobox',
        colspan:6,
        labelAlign : 'right',
        name:'mrOpType',
		fieldLabel:'文书操作类型',
		editable:false,
		allowBlank:false,
		margin:'10 0 0 0',
		comboData : [
			{"value":"01", "text":"提交"},
			{"value":"02", "text":"主治医师审核"},
			{"value":"03", "text":"新建"}
		]
    },{
		xtype: 'xapdisplayfield',
		fieldLabel: '',
		vertical: true,
		name:'showInfo',
		value: '',
		margin:'10 50 10 80'
	}]
        	


    }]
}],
initComponent: function() {
    this.callParent(arguments);
	//当指定控件有显示不全时，自动出现tip提示
	this.addListener('afterrender',this.tip);
},
tip : function(){
	Ext.create('Ext.tip.ToolTip', {
        target: 'mrTypesTip',
        anchor: 'buttom',
//        minWidth :0,
//        maxWidth:500,
//        width: 160,
        anchorOffset: 30,
        trackMouse: true,
    	listeners: {
			beforeshow: function updateTipBody(tip) {
				var textTip = Ext.getCmp('mrTypesTip');
				var value = textTip.rawValue;
				tip.update(value);				
			}
		}
      
    });
    Ext.create('Ext.tip.ToolTip', {
        target: 'mrTypesTip1',
        anchor: 'buttom',
//        minWidth :0,
//        maxWidth:500,
//        width: 160,
        anchorOffset: 30,
        trackMouse: true,
    	listeners: {
			beforeshow: function updateTipBody(tip) {
				var textTip = Ext.getCmp('mrTypesTip1');
				var value = textTip.rawValue;
				tip.update(value);				
			}
		}
      
    });
    Ext.create('Ext.tip.ToolTip', {
        target: 'mrTypesTip2',
        anchor: 'buttom',
//        minWidth :0,
//        maxWidth:500,
//        width: 160,
        anchorOffset: 30,
        trackMouse: true,
    	listeners: {
			beforeshow: function updateTipBody(tip) {
				var textTip = Ext.getCmp('mrTypesTip2');
				var value = textTip.rawValue;
				tip.update(value);				
			}
		}
      
    });
    Ext.create('Ext.tip.ToolTip', {
    	target: 'mrTypesTip3',
    	anchor: 'buttom',
//        minWidth :0,
//        maxWidth:500,
//        width: 160,
    	anchorOffset: 30,
    	trackMouse: true,
    	listeners: {
    		beforeshow: function updateTipBody(tip) {
    			var textTip = Ext.getCmp('mrTypesTip3');
    			var value = textTip.rawValue;
    			tip.update(value);				
    		}
    	}
    
    });
}
})