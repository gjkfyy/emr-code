Ext.define('iih.mr.tth.view.TeethTopExamView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [],
    
	alias:'widget.teethtopexamview',
	
	layout:{
	  type:'hbox',
	  align:'stretch'
	},

	xapConfig: {
		
		blocks: {
		    'title': {
                xclass: 'iih.mr.tth.block.TeethTopTitleBlock',
                border:0,
                style: {
                    marginTop: '1px',
                    marginRight: '1px',
                    marginBottom: '1px',
                    marginLeft: '0px'
                },
                width:50
            },
			'left': {
		        xclass: 'iih.mr.tth.block.TeethTopLeftBlock',
		        border:0,
		        style: {
                    marginTop: '1px',
                    marginRight: '3px',
                    marginBottom: '1px',
                    marginLeft: '1px'
                },
		        flex:1
            },
            'right': {
                xclass: 'iih.mr.tth.block.TeethTopRightBlock',
                border:0,
                style: {
                    marginTop: '1px',
                    marginRight: '1px',
                    marginBottom: '1px',
                    marginLeft: '3px'
                },
                flex:1
            }
		},
        actions: {},  
        chains: {},
        connections: {}
	},
	initComponent : function() {
		this.callParent();
	}
});