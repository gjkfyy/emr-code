Ext.define('iih.po.assistant.block.VitalSignHelperSearchBlock',{
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.DateField'],

    alias:'widget.VitalSignHelperSearchBlock',

    layout: {
    	type: 'table',
        columns: 3,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            width: '100%'
        },
        tdAttrs: {
            valign: 'center'
        }
    },

    items: [{
		xtype : 'tbspacer', //插入的空填充
		width : 400,
		colspan:3,
		height:20
	},{
        xtype: 'xapdatefield',
//        autoScroll:true,
        name:'beginTime',
        labelWidth:60,
        labelAlign:'right',
        editable:false,
        fieldLabel:'采集时间'
    },{
	  	xtype: 'xapdisplayfield',
		fieldLabel: '',
		vertical: true,
		name:'fenge',
		value: '~',
		margin:'0 0 0 0'
  },{
    	xtype: 'xapdatefield',
//      autoScroll:true,
    	name:'endTime',
    	labelWidth:60,
    	labelAlign:'right',
    	margin:'0 10 0 0',
    	editable:false
    },{
	  	xtype: 'xapdisplayfield',
		fieldLabel: '',
		colspan:3,
		vertical: true,
		name:'msgInfo',
		value: '',
		margin:'0 0 0 0'
  }],
    buttons:[{
        xtype: "button",
        name: 'Search',
        method:'Search',
        text: '查询'
    },{
        xtype: "button",
        name: 'Cancel',
        method:'Cancel',
        text: '关闭'    
    }],
	setData: function(data) {
	    alert("ok");
	    this.callParent(arguments);
	    
	    var date = this.down('xapdatefield');
	    var curDate = new Date();
		curDate = curDate.getTime();
		date = curDate;
		alert(curDate);
	    
	},
    getData: function() {
        this.callParent(arguments);
    }
});