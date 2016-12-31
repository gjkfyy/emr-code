Ext.define('iih.po.com.block.FunctionNavigationBlock',{
    extend : 'Xap.ej.element.panel.Panel',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.functionnavigationblock',
    
    title: '功能导航栏555',

    layout: 'accordion',

    items: [],

    setData : function(data,menuCd) {
        var me = this;
        var fstBtn;
        var portal = me.up('portalview');
        me.removeAll();
        Ext.each(data,function(node){
            var panel = Ext.create('Xap.ej.element.panel.Panel',{
                title: node.text,
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                }
            });
            var children = node.children;
            Ext.each(children,function(c){
                var text = '<span style=\'padding-left:5px;font-size:14px;font-weight:800;font-family:微软雅黑;\'>'+c.text+'</span>';
                var button = Ext.create('Ext.button.Button',{
                    code: c.data.code,
                    iconCls: c.data.nmEn,
                    scale: 'large',
                    text: text,
                    textAlign:'left',
                    tooltip: c.text,
                    handler:function(btn,e){
                        var block = btn.up('functionnavigationblock');
                        var btnComponents = block.query('button');
                        Ext.Array.each(btnComponents, function(item) {
                            item.removeCls('menu_button_active');
                        });
                        btn.addCls('menu_button_active');
                        var chain = portal.getActionChain('selectFunction');
                        chain.execute({
                            pageCode: btn.code
                        }); 
                    }
                });
                //if(menuCd == c.data.code)
                //if(!fstBtn)fstBtn = button;
                panel.add(button)
            });
            me.add(panel);
        });
        if(menuCd){
            var panels = me.query('xappanel');
            Ext.each(panels,function(p){
                var buttons = p.query('button');
                Ext.each(buttons,function(b){
                    if(b.code == menuCd){
                        p.expand();
                        b.addCls('menu_button_active');
                        var chain = portal.getActionChain('selectFunction');
                        chain.execute({
                            pageCode: b.code
                        });
                    }
                });
            });
        }else{
            var firstPanel = me.query('xappanel')[0];
            if(firstPanel){
                var firstButton = firstPanel.query('button')[0];
                if(firstButton){
                    firstButton.addCls('menu_button_active');
                    var chain = portal.getActionChain('selectFunction');
                    chain.execute({
                        pageCode: firstButton.code
                    });
                }
            }
        }
    }
        
})