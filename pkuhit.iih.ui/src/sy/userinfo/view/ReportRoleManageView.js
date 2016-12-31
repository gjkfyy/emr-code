Ext.define('iih.sy.userinfo.view.ReportRoleManageView', {          
	   extend: 'Xap.ej.template.BaseTemplate',
    alias: 'widget.reportrolemanageview',                  
    requires:[
            'iih.sy.userinfo.view.ReportRoleContentView',
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
    				xclass:'iih.sy.userinfo.view.ReportRoleContentView',
    				flex:1	
    			},
    			'bottom':{
    				xclass: 'Xap.ej.block.ToolbarBlock',
    				items: [{
    					xtype: 'xapbutton',
    					text: '保存',
    					action: 'savereport',
    					keyBinding: { 
							key: 's', 
							ctrl: true, 
							alt: true
						}, 
    					iconCls: 'icon-save',
    					padding : '0 30 0 0'
    				}],
    				height:30
    			}
    		},
    		
    		actions: {
    			'savereport': {
    				xclass:'iih.sy.userinfo.action.ReportSaveAction',
    				url: '/role/savereport',
    				blocks: {
    					condition: 'properties',
    					result: 'top'
    				}
    			}    			
    		},

    		chains: {
    			'savereport':['savereport']    			
    		},

    		connections: {
    			'bottom':[{
    				selector:'xapbutton[action=savereport]',
    				event: 'click',
    				chain: 'savereport'
    			}]
    		} 
    	}  	
});