Ext.define('iih.mr.tth.view.TeethExamView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [],
    
	alias:'widget.teethexamview',
	
	layout: 'fit',
	
	xapConfig: {
		blocks: {
            'content': {
                xclass: 'iih.mr.tth.block.TeethExamBlock'
            }
		},
        actions: {
            'init': {
                xclass: 'iih.mr.tth.action.TeethExamInitAction',
                url: 'teeth/search',
                blocks: {
                    content: 'content'
                }
            },
            'save': {
                xclass: 'iih.mr.tth.action.TeethExamSaveAction',
                url: 'teeth/save',
                blocks: {
                    content: 'content'
                }
            },
            'delete': {
                xclass: 'iih.mr.tth.action.TeethExamDeleteAction',
                url: 'teeth/delete',
                blocks: {
                    content: 'content'
                }
            }
        },  
        chains: {
            'init': ['init'],
            'save': ['save'],
            'doSave': ['save'],
            'delete': ['delete']
        },
        connections: {
            'content':[{
                event: 'afterrender',
                chain: 'init'
            },{
                selector: 'button[action=save]',
                event: 'click',
                chain: 'save'
            },{
                selector: 'toolbar button[method=create]',
                event: 'click',
                chain: 'save'
            }]
        }
	},
	initComponent : function() {
		this.callParent();
		var me = this;
		this.addEvents("contentRefresh");//为视图添加刷新事件
        this.addListener('contentRefresh', function(){//添加监听事件
            if(this.hasEdit()){
                var workPage = me.up('workareapageview');
                workPage.showConfirm(function() {
                    page = me;
                    workPage.callControllerMethod(page, function(page) {
                        var view = page.up('portalview');
                        var chain = view.getActionChain('openWorkPage');
                        if(chain) {
                            chain.execute({});
                        };
                    });
                }, function() {
                    var view = me.up('portalview');
                    var chain = view.getActionChain('openWorkPage');
                    if(chain) {
                        chain.execute({});
                    };
                }, function() {
                });
            }else{
                var view = me.up('portalview');
                var chain = view.getActionChain('openWorkPage');
                if(chain) {
                    chain.execute({});
                }; 
            }
        });
		this.addEvents("selectEncounter");//为视图添加刷新事件
        this.addListener('selectEncounter', function(enPk){//添加监听事件
            this.initPage();
        });
	},
	hasEdit: function() {
        var tl = this.down('teethtopleftblock');
        var tr = this.down('teethtoprightblock');
        var bl = this.down('teethbottomleftblock');
        var br = this.down('teethbottomrightblock');
        var ct = this.down('teethcontentblock');
        if(tl.isDirty() || tr.isDirty() || bl.isDirty() || br.isDirty() || ct.isDirty())
            return true;
        return false;
    },
    initPage: function() {
        var chain = this.getActionChain('init');
        if(chain) {
            chain.execute();
        }
    }
});