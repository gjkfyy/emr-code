Ext.define('Xap.ej.element.container.BorderViewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    autoscroll: false,
    items:[
        {
        	id: 'maintop',
	        region: 'north',
	        html: '<h1 class="x-panel-header">Top Page</h1>',
	        border: false,
	        margins: '2 2 0 2'
	    }, {
	    	id: 'mainleft',
	        region: 'west',
	        collapsible: true,
	        split: true,	
	        width: 150,
	        margins: '0 0 2 2',
	        html: '<h1 class="x-panel-header">left</h1>'
	    }, {
	    	id: 'mainbottom',
	        region: 'south',
	        html: 'Information goes here',
	        border: false,
	        height: 0,
	        minHeight: 0
	    }, {
	    	id: 'mainright',
	        region: 'east',
	        collapsible: false,
	        border: false,
	        split: false,
	        width: 0
	    }, {
	    	id: 'mainworkarea',
	        region: 'center',
	        layout:'fit',
	        margins: '0 2 2 0',
	        minWidth: 600
	    }
    ],
    	
    initComponent: function() {
//    	alert(2);
//    	Ext.Msg.alert('Status', 'Viewport');
        this.callParent();
    }
});