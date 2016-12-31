Ext.define('iih.po.com.block.KnowledgeTextAreaBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextArea'
	],

	alias:'widget.knowledgetextareablock',

	layout:{
		type: 'vbox',
        align: 'stretch',
	},
	
	autoScroll : true,
	
	//margin: '5 5 5 0',

	items: [{
			xtype: 'xaptextarea',
			name: 'fragmentTplContent',
//			labelWidth:80,
//			labelAlign:'right',
//			fieldLabel:'',
			readOnly:true,
			enableKeyEvents :true,
			margin:'5 10 5 5',
			rows:12,
			renderer : function(value) {
				if(value)
					return '<textarea name=\"knowledgeArea\" id=\"fragmentTplContent1\" rows=\"12\" cols=\"25\" ></textarea>';
			},
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('knowledgetextareablock');
					if(center.selectedCmp){
						center.selectedCmp.setFieldStyle({'background-image': 'url("images/form/text-bg.gif")','background-color': 'white'});
						center.selectedCmp=null;
					}
					area.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
					center.selectedCmp = area;
                }
            }
		}],

	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
})