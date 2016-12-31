Ext.define('iih.mr.dr.condition_set.block.ConditionButtonBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.conditionbuttonblock',

	border: 0,
		
	items: [{
		xtype: 'xapform',
		name:'defectComplete',
		width:'100%',
		border: 0,
		valign: 'middle',
		layout: {
			type: 'table',
			columns: 1,
			tableAttrs: {
	            border: 0,
	            cellpadding: 5,
	            cellspacing: 1,
	            width: '100%',
	            height:'100%'
	        },
	        tdAttrs: {
	            valign: 'center'
	        }
		},
		items:[{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
			xtype : 'tbspacer', //插入的空填充
			width : 50
		},{
            xtype: "button",
            name: 'add',
            method:'add',
            text: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
            maxWidth:'80'
        },{
            xtype: "button",
            name: 'addchild',
            method:'addchild',
            text: '&nbsp;&nbsp;&nbsp;&nbsp;++&nbsp;&nbsp;&nbsp;&nbsp;',
            maxWidth:'80'
   		},{
            xtype: "button",
            name: 'addgroup',
            method:'addgroup',
            text: '&nbsp;&nbsp;&nbsp;（）&nbsp;&nbsp;&nbsp;',
            width:'80'
   		},{
            xtype: "button",
            name: 'addgroupchild',
            method:'addgroupchild',
            text: '（（））',
            width:'80'
   		},{
            xtype: "button",
            name: 'delete',
            method:'delete',
            text: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
            width:'80'
   		},{
            xtype: "button",
            name: 'changeup',
            method:'changeup',
            text: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↑&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
            width:'80'
   		},{
            xtype: "button",
            name: 'changedown',
            method:'changedown',
            text: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
            width:'80'
   		}]
	}],

    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})