Ext.define('iih.po.com.view.FunctionNavigationView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: ['Xap.ej.element.tree.Tree',
               'iih.mr.wr.mr.action.CreateMrDocAction'],

    alias:'widget.functionnavigationview',
    
    title: '功能导航栏',

    layout: 'fit',

    xapConfig: {
        blocks: {
            'functiontree': {
                xclass: 'iih.po.com.block.FunctionNavigationBlock'
            }
        },

        actions: {
            'refresh': {
                xclass: 'iih.po.com.action.FunctionTreeInitAction',
                url: 'app/searchPortalMenus',
                blocks: {
                    tree: 'functiontree'
                }
            },
            'selectFunction': {
                xclass: 'iih.po.com.action.SelectFunctionAction',
                blocks: {
                    tree: 'functiontree'
                }
            },
            'createMenu': {
                xclass: 'iih.po.com.action.CreateMenuAction',
                blocks: {
                    tree: 'functiontree'
                }
            },
            'createMr': {
                xclass: 'iih.mr.wr.mr.action.CreateMrDocAction'
            },
            'openMr': {
                xclass: 'iih.mr.wr.mr.action.OpenMrDocAction'
            },
            'mrProperty': {
                xclass: 'iih.mr.wr.mr.action.MrDocPropertyAction'
            }
        },

        chains: {
            'init': ['refresh'],
            'selectFunction': ['selectFunction'],
            'createMenu': ['createMenu'],
            'createMr': ['createMr'],
            'openMr': ['openMr'],
            'mrProperty': ['mrProperty']
        },

        connections: {
            'functiontree': [{
                chain: 'init'
            }]
        }
    },
    
    initComponent : function() {
        var me = this;
        this.callParent();
        this.addEvents("mrTreeRefresh");//为视图添加事件
        this.addListener('mrTreeRefresh', function() {//添加监听事件
            var chain = me.getActionChain('init');
            chain.execute();
        });
    }
})