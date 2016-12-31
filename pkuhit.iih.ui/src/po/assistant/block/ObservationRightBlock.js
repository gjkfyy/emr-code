Ext.define('iih.po.assistant.block.ObservationRightBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextArea'
	],

	alias:'widget.observationrightblock',

	layout:{
		type: 'vbox',
        align: 'stretch',
	},
	
	autoScroll : true,
	
	//margin: '5 5 5 0',

	items: [{
			xtype: 'xaptextarea',
			name: 'obImpr',
			labelWidth:80,
			labelAlign:'right',
			fieldLabel:'检查结果',
			readOnly:true,
			margin:'5 15 0 0',
			rows:10,
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('observationrightblock');
					if(center.selectedCmp){
						center.selectedCmp.setFieldStyle({'background-image': 'url("images/form/text-bg.gif")','background-color': 'white'});
						center.selectedCmp=null;
					}
					area.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
					center.selectedCmp = area;
                }
            }
		}/*,{
			xtype: 'xaptextarea',
			name: 'obVal',
			labelWidth:80,
			labelAlign:'right',
			fieldLabel:'测量结果',
			readOnly:true,
			margin:'0 15 0 0',
			rows:3,
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('observationrightblock');
					if(center.selectedCmp){
						center.selectedCmp.setFieldStyle({'background-image': 'url("images/form/text-bg.gif")','background-color': 'white'});
						center.selectedCmp=null;
					}
					area.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
					center.selectedCmp = area;
                }
            }
		},{
			xtype: 'xaptextarea',
			name: 'obFndg',
			labelWidth:80,
			labelAlign:'right',
			fieldLabel:'检查所见',
			readOnly:true,
			margin:'0 15 0 0',
			rows:3,
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('observationrightblock');
					if(center.selectedCmp){
						center.selectedCmp.setFieldStyle({'background-image': 'url("images/form/text-bg.gif")','background-color': 'white'});
						center.selectedCmp=null;
					}
					area.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
					center.selectedCmp = area;
                }
            }
		},{
			xtype: 'xaptextarea',
			name: 'obDi',
			labelWidth:80,
			labelAlign:'right',
			fieldLabel:'检查诊断',
			readOnly:true,
			margin:'0 15 0 0',
			rows:3,
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('observationrightblock');
					if(center.selectedCmp){
						center.selectedCmp.setFieldStyle({'background-image': 'url("images/form/text-bg.gif")','background-color': 'white'});
						center.selectedCmp=null;
					}
					area.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
					center.selectedCmp = area;
                }
            }
		},{
			xtype: 'xaptextarea',
			name: 'adv',
			labelWidth:80,
			labelAlign:'right',
			fieldLabel:'建议',
			margin:'0 15 0 0',
			readOnly:true,
			rows:3,
			listeners:{
				focus : function(area, The, eOpts) {
					var center = this.up('observationrightblock');
					if(center.selectedCmp){
						center.selectedCmp.setFieldStyle({'background-image': 'url("images/form/text-bg.gif")','background-color': 'white'});
						center.selectedCmp=null;
					}
					area.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
					center.selectedCmp = area;
                }
            }
		}*/],

	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
})