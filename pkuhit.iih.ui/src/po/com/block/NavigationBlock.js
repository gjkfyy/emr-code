Ext.define('iih.po.com.block.NavigationBlock', {
    extend : 'Xap.ej.element.tab.Panel',

    requires: [],

    alias:'widget.navigationblock',

    layout: 'fit',
    
    tabBar: {
        layout: {
            type: 'hbox',
            align: 'stretch'
        }
    },
    
    initComponent: function() {
        this.callParent();
        var me = this;
        var bar = me.getTabBar();
        bar.add({
            xtype: 'container',
            layout: {
                type: 'hbox',
                pack: 'end'
            },
            flex: 1,
            items:[{
                xtype: 'tool',
                type:'left',
                handler: function(event, toolEl, header, tool) {
                    var panel = header.ownerCt.ownerCt;
                    panel.collapse();
                }
            }]
        });
    },
    
    maximize: function() {
        this.setHeight(150);
    },
    
    minimize: function() {
        this.setHeight(32);
    },
})