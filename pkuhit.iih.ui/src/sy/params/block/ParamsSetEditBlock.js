Ext.define('iih.sy.params.block.ParamsSetEditBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.field.ComboBoxGrid',
        'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.TextArea'
	],

	alias:'widget.paramsseteditblock',

	layout: {
        type: 'table',
        columns: 1,
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
            	xtype:'xaptextfield',
            	labelWidth:90,
            	labelAlign:'right',
            	name:'nm',
            	fieldLabel:'名称:'
            },{
                xtype:'comboxgrid',
                url: 'param/set/keyword',//科室查询的url
                fieldLabel:'编码:',
                labelWidth:90,
                labelAlign:'right',
                listWidth:280,    //gird的宽度
                name:'code', 
                searchParam: {'id': 'SYSM01'},
                width:245,        //combo的宽度
                valueField : 'code',//科室编码的字段名
                displayField: 'codeName',//科室名称的字段名
                columns: [{              //grid的column配置
                   text: '编码',
                   dataIndex: 'code',
                   width:100
                },{
                   text: '名字',
                   flex:1,
                   dataIndex: 'codeName'
                }],
                callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
                    console.log(newValue);     //本次选择的科室编码
                    console.log(oldValue);     //上次选择的科室编码
                    console.log(record);       //本次选择的科室完整记录
                }     	
            },{
            	xtype:'xaptextfield',
            	labelWidth:90,
            	labelAlign:'right',
            	name:'key',
            	fieldLabel:'标识:'
            },{
            	xtype:'xaptextfield',
            	labelWidth:90,
            	labelAlign:'right',
            	name:'value',
            	fieldLabel:'值:'
            },{
            	xtype:'xaptextarea',
            	labelWidth:90,
            	height:40,
                labelAlign:'right',
                name :'memo',
                fieldLabel:'描述:',
                width:250
        },{
            	xtype:'xaptextfield',
            	labelWidth:90,
            	labelAlign:'right',
            	name:'paramCd',
            	hidden:true,
            	fieldLabel:'参数编码:'
            },{
            	xtype:'xaptextfield',
            	labelWidth:90,
            	labelAlign:'right',
            	name:'updCnt',
            	hidden:true,
            	fieldLabel:'修改次数:'
            }],
            
	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
    
})