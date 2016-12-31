Ext.define('iih.mr.wr.nmr.view.CreateImageElementView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['iih.mr.wr.nmr.block.EmrImageElementBlock',
	           'iih.mr.wr.nmr.action.ImageElementCreateAction',
	           'iih.mr.wr.nmr.action.ImageElementEditAction',
	           'iih.mr.wr.nmr.action.CloseImageElement'],

	alias:'widget.createimageelementview',
	id:'createimageelementview',
	layout : {
		type: 'vbox',
		align : 'stretch'
	},
	xapConfig: {
		blocks: {
			'content':{
				xclass: 'iih.mr.wr.nmr.block.EmrImageElementBlock',
			}
		},
		
		actions: {
            'createImage':{
            	xclass:'iih.mr.wr.nmr.action.ImageElementCreateAction',
            	blocks: {
 		            content: 'content'
 		        }
            },
            'updateImage':{
            	xclass:'iih.mr.wr.nmr.action.ImageElementEditAction',
            	blocks: {
 		            content: 'content'
 		        }
            },
            'closeImage':{
            	xclass:'iih.mr.wr.nmr.action.CloseImageElement',
            	blocks: {
 		            content: 'content'
 		        }
            },
		},
		
		chains: {
		    'createImage':['createImage'],
		    'updateImage':['updateImage'],
		    'closeImage':['closeImage']
		},

		connections: {
			'content':[{
            	selector: 'button[name=btnNew]',
                event: 'click',
                chain: 'createImage'
            },{
            	selector: 'button[name=btnModfiy]',
                event: 'click',
                chain: 'updateImage'
            },{
            	selector: 'button[name=btnClose]',
                event: 'click',
                chain: 'closeImage'
            }
			]
			
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