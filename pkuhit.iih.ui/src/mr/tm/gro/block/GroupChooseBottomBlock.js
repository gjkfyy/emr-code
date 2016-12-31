Ext.define('iih.mr.tm.gro.block.GroupChooseBottomBlock', {
	extend: 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.checkboxgroup.CheckboxGroup'
	           ],

	alias:'widget.groupelementchooseblock',
	
	id:'groupchoosebottomblock',
	
	border: 1,
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	items: [{
			html:'组合元素实例化属性:',
			border:0,
			margin:'0 0 0 5'
		},{
			xtype: 'xapcheckboxgroup',
			vertical: true,
			name:'throughCheck',
			margin:'0 0 0 15',
			items: [
				{ boxLabel: '不可删除', name: 'throughCheck1', inputValue: '1' },
				{ boxLabel: '不显示外框', name: 'throughCheck2', inputValue: '2' },
				{ boxLabel: '不可打印', name: 'throughCheck3', inputValue: '3' }
			]
		}],
		bbar: [
			'->',
			{
				xtype: 'button',
				name:'throughBtn',
				method:'throughBtn',
				text:'插入'
			},{
				xtype: 'button',
				name:'cancelBtn',
				method:'cancelBtn',
				text:'取消'
			}],

	setData: function(data) {
	    this.callParent(arguments);
	},
	getData: function() {
	    this.callParent(arguments);
	}
})