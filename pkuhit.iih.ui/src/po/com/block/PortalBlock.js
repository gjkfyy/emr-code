Ext.define('iih.po.com.block.PortalBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['iih.po.com.view.WorkAreaPageView',
               'iih.po.com.block.FunctionNavigationBlock',
               'iih.po.com.view.TopView',
               'iih.po.com.block.PluginBlock',
               'Xap.ej.element.tab.Panel'],

    alias:'widget.portalblock',
    
    layout: 'border',

    items: [{
        region: 'north',
        xtype: 'topview',
        height: 85
    }, {
        region:'west',
        xtype: 'functionnavigationblock',
        split: true,
        header:true,
        collapsible: true,
        collapseMode: 'undefined',
        width: 250
    }, {
        region: 'center',
        xtype: 'workareapageview',
        layout: 'fit'
    },{
        region: 'south',
        xtype: 'pluginblock',
        pluginId: 2
    }],

    initComponent: function() {
        this.callParent();
    },
    
    addWorkPage: function(config){
        var workarea = this.down('workareapageview');
        var tabId = config.tabId;
        var tabs = workarea.items.items;
        var view = null;
        for (var i = 0; i < tabs.length; i++) {
            var tab = tabs[i];
            if (tab.tabId == tabId) {
                view = tab;
                break;
            }
        };
        if(!view){
            var tabConfig = {
                    xclass: 'iih.po.com.view.WorkPageView',
                    tabId: tabId,
                    title: config.title,
                    closable: true,
                    hideMode:'offsets'
            };
            var view =  Xap.create(tabConfig);
            var workContent = view.getBlock('workContent');
            workContent.removeAll();
            var workView =  Ext.create(config.xclass,config.viewConfig);
            Ext.apply(workView,{itemId:tabId});
            workContent.add(workView);
            if(config.assistantConfig){
                var assistantBlock = view.getBlock('helpContent');
                Ext.apply(assistantBlock,config.assistantConfig);
                var helpContent = assistantBlock.down('xaptabpanel');
                helpContent.removeAll(true);
                
                var plugin = Xap.ej.platform.Plugin;
                var list = plugin.getExtensionPoint('assistant');
                if(list.extensions.length > 0) {
                    for(var i=0;i<list.extensions.length;i++){
                        var item = list.extensions[i];
                        var config = {
                            tabId: item.cd,
                            title: item.text,
                            xclass: item.xclass,
                            isQuery:item.isQuery,
                            haveEncounter:item.haveEncounter
                        };
                        helpContent.add(Ext.create(config));
                    }
                };
                
                var up = helpContent.down('tool[itemId=up]');
                var down = helpContent.down('tool[itemId=down]');
                down.addListener('click', function() {
                    assistantBlock.minimize();
                    up.show();
                    down.hide();
                });
                up.addListener('click', function() {
                    assistantBlock.maximize(300);
                    up.hide();
                    down.show();
                });
                var tbar = helpContent.getTabBar();
                tbar.addListener('dblclick', function(tabBar, e) {
                    if(down.hidden==false){
                       assistantBlock.minimize();
                       up.show();
                       down.hide();
                    }else{
                       assistantBlock.maximize(300);
                       up.hide();
                       down.show();
                    }
                });
                helpContent.addListener('tabchange', function(p,n,o) {
                    var mrCombo = p.down('xapcombobox[itemId=encounterCombox]');
                    mrCombo.setDisabled(!n.haveEncounter);
                    var writeButton = p.down('button[itemId=writeToMrDocButton]');
                    writeButton.setDisabled(!n.haveEncounter);
                    /*var queryButton = p.down('button[itemId=queryButton]');
                    queryButton.setDisabled(!n.isQuery);
                    if(n.isQuery){
                        queryButton.addListener('click', function() {
                            var chain = n.getActionChain('searchwindowpopup');
                            chain.execute();
                        });
                    };*/
                });
                assistantBlock.minimize();
                helpContent.setActiveTab(0);
            }else{
                var assistantBlock = view.getBlock('helpContent');
                assistantBlock.removeAll();
            }
            workarea.add(view).show();
        }else{
            workarea.setActiveTab(view);
            var block = view.getBlock('workContent');
            var items = block.items.items;
            var workView = items[0];
            workView.fireEvent("refreshWorkArea",config);
        };
    }
})