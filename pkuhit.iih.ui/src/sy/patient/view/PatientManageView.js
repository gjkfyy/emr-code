Ext.define('iih.sy.patient.view.PatientManageView', {          
	   extend: 'Xap.ej.template.BaseTemplate',
    //extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    alias: 'widget.patientmanageview',                  
    requires:[
            'iih.sy.patient.view.PatientContentView',
            'iih.sy.patient.action.PopupUserToLeadAction',
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
    				xclass:'iih.sy.patient.view.PatientContentView',
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