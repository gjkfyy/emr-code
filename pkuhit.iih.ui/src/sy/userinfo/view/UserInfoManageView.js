Ext.define('iih.sy.userinfo.view.UserInfoManageView', {          
	   extend: 'Xap.ej.template.BaseTemplate',
    //extend: 'Xap.ej.stl.view.TopBottomContainerTemplate',
    alias: 'widget.userinfomanageview',                  
    requires:[
            'iih.sy.userinfo.view.UserInfoContentView',
            'iih.sy.userinfo.action.PopupUserToLeadAction',
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
    				xclass:'iih.sy.userinfo.view.UserInfoContentView',
    				flex:1	
    			},
    			'bottom':{
    				xclass: 'Xap.ej.block.ToolbarBlock',
    				items: [{
    					xtype: 'xapbutton',
    					text: '保存',
    					action: 'saveuser',
    					keyBinding: { 
							key: 's', 
							ctrl: true, 
							alt: true
						}, 
    					iconCls: 'icon-save',
    					padding : '0 30 0 0'
    				}],
    				/*xtype: 'Xap.ej.block.xaptoolbarblock',
					items: [{
					    xtype: 'button',
					    iconCls: 'icon-Search',
					    text: '查询',
					    action: 'search'
					}],*/
    				height:30
    			}
    		},
    		
    		actions: {
    			'saveuser': {
    				xclass:'iih.sy.userinfo.action.UserSaveAction',
    				url: 'user',
    				blocks: {
    					condition: 'properties',
    					result: 'top'
    				}
    			}    			
    		},

    		chains: {
    			'saveuser':['saveuser']    			
    		},

    		connections: {
    			'bottom':[{
    				selector:'xapbutton[action=saveuser]',
    				event: 'click',
    				chain: 'saveuser'
    			}]
    		} 
    	}  	
});