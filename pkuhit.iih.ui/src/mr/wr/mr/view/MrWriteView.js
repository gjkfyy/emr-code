Ext.define('iih.mr.wr.mr.view.MrWriteView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [],

	alias:'widget.mrwriteview',
	id:'mrwriteview',
	layout:'border',
	xapConfig: {
		blocks: {
			'content': {
				xclass: 'iih.mr.wr.mr.view.MrDocEditView',
				region:'center',
				flex:1
			},
			'helper': {
			    xclass: 'iih.po.com.view.RightEditView',
			    workscene:'mr',
			    region:'east',
			    split: true,
                collapsible: true,
                collapsed: true,
                header:false,
                width: 250
			}
		},
		actions: {
			'emrSave': {
                xclass: 'iih.mr.wr.mr.action.MrDocSaveAction',
                url: 'mr',
                blocks: {
                    content: 'content'
                }
            }
		},
		chains: {
			'doSave': ['emrSave'],
		}
	},
	hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }
});