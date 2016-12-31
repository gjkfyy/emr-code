Ext.define('iih.po.com.view.WorkAreaPageView', {
	extend: 'Xap.ej.element.tab.Panel',

	requires: [],

	alias:'widget.workareapageview',

	layout: 'fit',
	
	id: 'workareapageview',
	
	defaults: {
	  border: false  
	},

    items: [],
    
    tabBar: {
       height: 28
    },

    initComponent: function() {
    	this.callParent();
    },
    
    getMainPage: function(itemId) {
        var view;
        var mainPage;
        Ext.each(this.items.items,function(tab){
            if(itemId == tab.tabId){
                view = tab;
            }
        });
        if(view){
            mainPage = view.down('container[itemId='+itemId+']');
            if(!mainPage)
                return view;
        }
        return mainPage;
    },
    
    showConfirm: function(yesCallback, noCallback, cancelCallback) {
        var me = this;
        XapMessageBox.confirm('是否保存对当前页面的修改？',
            function(btn, text){
                if (btn == 'yes') {
                    return me.callMethod(yesCallback, me);
                } else if (btn == 'no') {
                    return me.callMethod(noCallback, me);
                } else if (btn == 'cancel') {
                    return me.callMethod(cancelCallback, me);
                }
            },me
        );
    },
    
    callMethod: function(method, scope, params) {
        if (Ext.isFunction(method)) {
            return method.apply(scope || window, Array.prototype.slice.call(params || [], 0));
        }
    },
    
    callControllerMethod: function(owner,callBack) {
        if (!owner) {
            return;
        }
        var chain = owner.getActionChain('doSave');
        if(chain){
            chain.callBack = callBack;
            chain.execute();
        }
    },
    
    listeners: {
        beforeremove: function(tabPanel, tab, e) {
            if (tab.ensureRemove) {
                return;
            };
            var page = tabPanel.getMainPage(tab.tabId);
            if (tabPanel.getActiveTab() != tab) {
                tab.ensureRefresh = false;
                tabPanel.setActiveTab(tab);
            };
            if(page.hasEdit && Ext.isFunction(page.hasEdit)){
                if(page.hasEdit()){
                    tabPanel.showConfirm(function() {
                        page._removeTab = tab;
                        page._tabPanel = tabPanel;
                        tabPanel.callControllerMethod(page, function(page) {
                            page._removeTab.ensureRemove = true;
                            page._tabPanel.remove(page._removeTab);
                        });
                    }, function() {
                        tab.ensureRemove = true;
                        tabPanel.remove(tab);
                    }, function() {
                        tabPanel.callBack = null;
                        tabPanel.closePages = null;
                        tabPanel.closeWorkPage = false;
                    });
                    return false;
                }
            }
        },
        remove: function(tabPanel, tab, e) {
            if(tabPanel.closeWorkPage){
                if(tabPanel.closePages){
                    tabPanel.closePages.splice(0,1);
                };
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender");
            };
            if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_4 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_6){
                if(tab.closable){
                    var portal = tabPanel.up('portalview');
                    var top = portal.down('topview');
                    var topChain = top.getActionChain('init');
                    topChain.execute();
                } 
            }
        },
        tabchange: function(tabPanel, newCard, oldCard, e) {
            if(!tabPanel.closeWorkPage){
                var mainPage;
                if(newCard.haveAssistant)
                    mainPage = this.getMainPage(newCard.tabId);
                else
                    mainPage = newCard;
                if(mainPage)
                    mainPage.fireEvent("pageRefresh");
            }
        }
    }
})