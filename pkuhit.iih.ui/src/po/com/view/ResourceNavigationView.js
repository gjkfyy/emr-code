Ext.define('iih.po.com.view.ResourceNavigationView', {
    extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.resourcenavigationview',

    title: '资源',
    
    border: 0,

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.po.com.block.ResourceSearchBlock',
                height: 30,
                border: 0
            },
            'bottom': {
                xclass: 'iih.po.com.block.ResourceTreeBlock',
                border: 0
            }
        },

        actions: {
            'init': {
                xclass: 'iih.po.com.action.ResourceTreeInitAction',
                blocks: {
                    tree: 'bottom'
                }
            },
            'resourceClick': {
                xclass: 'iih.po.com.action.ResourceClickAction',
                blocks: {
                    tree: 'bottom'
                }
            },
            'resourceExpand': {
                xclass: 'iih.po.com.action.ResourceExpandAction',
                blocks: {
                    tree: 'bottom'
                }
            },
            'createMenu': {
                xclass: 'iih.po.com.action.CreateMenuAction',
                blocks: {
                    tree: 'bottom'
                }
            }
        },

        chains: {
            'init': ['init'],
            'resourceClick': ['resourceClick'],
            'createMenu': ['createMenu'],
            'resourceExpand': ['resourceExpand']
        },

        connections: {
            'bottom': [{
                selector: 'xaptree[name=basTree]',
                event: 'itemclick',
                chain: 'resourceClick'
            },{
                selector: 'xaptree[name=mrTree]',
                event: 'itemclick',
                chain: 'resourceClick'
            },{
                selector: 'xaptree[name=grpTree]',
                event: 'itemclick',
                chain: 'resourceClick'
            },{
                selector: 'xaptree[name=basTree]',
                event: 'itemcontextmenu',
                chain: 'createMenu'
            },{
                selector: 'xaptree[name=mrTree]',
                event: 'itemcontextmenu',
                chain: 'createMenu'
            },{
                selector: 'xaptree[name=grpTree]',
                event: 'itemcontextmenu',
                chain: 'createMenu'
            },{
                //selector: 'xaptree[name=mrTree]',
                //event: 'treeitemexpand',
                chain: 'resourceExpand'
            }]
            
        }
    },
    
    initComponent : function() {
        var me = this;
        this.callParent();
        this.addEvents("resourceRefresh");//为视图添加事件
        this.addListener('resourceRefresh', function() {//添加监听事件
            var chain = me.getActionChain('init');
            chain.execute({
                objcd:me.objcd
            });
        });
    }
})