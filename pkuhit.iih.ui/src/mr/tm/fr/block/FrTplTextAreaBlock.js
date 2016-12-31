Ext.define('iih.mr.tm.fr.block.FrTplTextAreaBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextArea'
	],

	alias:'widget.frtpltextareablock',

	layout:{
		type: 'vbox',
        align: 'stretch',
	},
	
	autoScroll : true,
	
	items: [{
			xtype: 'xaptextarea',
			name: 'contentText',
			readOnly:true,
			enableKeyEvents :true,
			margin:'5 10 5 5',
			rows:15,
			renderer : function(value) {
				if(value)
					return '<textarea name=\"FrTplArea\" id=\"contentText1\" rows=\"12\" cols=\"25\" ></textarea>';
			},
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('frtpltextareablock');
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