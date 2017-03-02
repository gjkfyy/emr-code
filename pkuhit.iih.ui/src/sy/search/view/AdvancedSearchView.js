Ext.define('iih.sy.search.view.AdvancedSearchView', {          
	   extend: 'Xap.ej.template.BaseTemplate',
    //extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    alias: 'widget.advancedsearchview',                  
    requires:[
      		'Xap.ej.stl.view.PlaceHolderBlock',
      		'Xap.ej.block.ToolbarBlock',
      		'Xap.ej.block.Block',
      		'Xap.ej.element.button.Button'
      	],
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    xapConfig: {
    		blocks: {
    			'top':{ 
    				xclass:'iih.sy.search.view.SearchContentView',
    				flex:1	
    			}
    		},
    		
    		actions: {
    				
    		},

    		chains: {
    			 			
    		},

    		connections: {
    			
    		} 
    	}  	
});