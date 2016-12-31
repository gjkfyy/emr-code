Ext.define('iih.mr.tm.mr.view.MrTemplateManageView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [],

	alias:'widget.mrtemplatemanageview',
	layout:'border',
	xapConfig: {
		blocks: {
			'center': {
				xclass: 'iih.mr.tm.mr.view.MrTemplateEditView',
				region:'center',
				flex:1
			},
			'helper': {
			    xclass: 'iih.po.com.view.RightEditView',
			    workscene:'tm',
			    region:'east',
			    split: true,
                collapsible: true,
                collapsed: true,
                header:false,
                width: 250
			}
		},
		
		actions: {},

		chains: {},

		connections: {},
		
	},
	
	initComponent : function() {
		this.callParent();
	}
});