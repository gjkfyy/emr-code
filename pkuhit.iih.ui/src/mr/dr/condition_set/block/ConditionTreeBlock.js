Ext.define('iih.mr.dr.condition_set.block.ConditionTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: ['Xap.ej.element.tree.Tree'],
	
	alias:'widget.conditiontreeblock',

	items: [{
//		title:'检索方案设置',
		xtype: 'xapform',
		name:'defectComplete',
		width:'100%',
		border: 0,
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
	            valign: 'left'
	        }
		},
		items:[{
			xtype:'xapdisplayfield',
			name:'patientName',
			labelAlign : 'right',
			fieldLabel:'条件结构树'
		},{
           xtype:'xaptree',
           name:'conditionTree',
           flex: 1,
           ifSelect:true,
           rootVisible: false
       }]
	}],
	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }	
})