Ext.define('iih.po.com.view.PortalView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: ['Xap.ej.locale.Locale','Xap.ej.element.MessageBox.MessageBox','iih.mr.qa.process_qa_work.action.QaWorkUserAcAction'],

    alias:'widget.portalview',

    layout: 'fit',
    
    id:'portalview',
    
    border: 0,

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.com.block.PortalBlock'
            }
        },

        actions: {
            'refresh': {
                xclass: 'iih.po.com.action.PortalInitAction',
                blocks: {
                    portal: 'content'
                }
            },
            'savePatient': {
                xclass: 'iih.po.com.action.SavePatientAction',
                url: 'savePatient',
                blocks: {
                    portal: 'content'
                }
            },
            'saveDept': {
                xclass: 'iih.po.com.action.SaveDeptAction',
                url: 'saveDepartment',
                blocks: {
                    portal: 'content'
                }
            },
            'updatePatient': {
                xclass: 'iih.po.com.action.UpdatePatientAction',
                blocks: {
                    portal: 'content'
                }
            },
            'addWorkAreaPage': {
                xclass: 'iih.po.com.action.AddWorkAreaPageAction',
                blocks: {
                    portal: 'content'
                }
            },
            'closeWorkPage': {
                xclass: 'iih.po.com.action.CloseWorkPageAction',
                blocks: {
                    portal: 'content'
                }
            },
            'openWorkPage': {
                xclass: 'iih.po.com.action.RefreshWorkPageAction',
                blocks: {
                    portal: 'content'
                }
            },
            'functionRefresh': {
                xclass: 'iih.po.com.action.FunctionTreeInitAction',
                url: 'poral/menus',
                blocks: {
                    portal: 'content'
                }
            },
            'selectFunction': {
                xclass: 'iih.po.com.action.SelectFunctionAction',
                blocks: {
                    portal: 'content'
                }
            },
            'patientPop': {
                xclass: 'iih.po.com.action.PatientPopAction',
                blocks: {
                    portal: 'content'
                }
            },
            'InpPatientPop': {
                xclass: 'iih.po.inp.action.InpPatientPopAction',
                blocks: {
                    portal: 'content'
                }
            },
            'refreshMsg': {
                xclass: 'iih.po.com.action.MessageRefreshAction',
                url: 'message/read',
                blocks: {
                    portal: 'content'
                }
            },
            'messagePop': {
                xclass: 'iih.po.com.action.MessagePopAction',
                blocks: {
                    portal: 'content'
                }
            },
            'getPatient': {
                xclass: 'iih.po.com.action.GetPatientInfoAndCallbackAction',
                url: 'mr/ens',
                blocks: {
                	portal: 'content'
                }
            },
            'qaWorkUserAcAction': {
				url:'/user/roles',
				xclass: 'iih.mr.qa.process_qa_work.action.QaWorkUserAcAction',
				blocks: {
					content:'result'
				}
			}
        },

        chains: {
            'init': ['saveDept','refresh'],
            'savePatient': ['savePatient'],
            'updatePatient': ['updatePatient'],
            'addWorkAreaPage': ['addWorkAreaPage'],
            'closeWorkPage': ['closeWorkPage'],
            'openWorkPage': ['openWorkPage'],
            'functionRefresh': ['functionRefresh'],
            'selectFunction': ['selectFunction'],
            'patientPop': ['patientPop'],
            'InpPatientPop': ['InpPatientPop'],
            'refreshMsg': ['refreshMsg'],
            'messagePop': ['messagePop'],
            'getPatient': ['getPatient'],
            'qaWorkUserAcAction': ['qaWorkUserAcAction']
        },

        connections: {
            'content': [{
                event: 'activate',
                chain: 'refreshMsg'
            }]
        }
    },
    
    initComponent : function() {
        var me = this;
        this.callParent();
        var canvas = Xap.getCanvas();
        this.relayEvents(canvas, ['addWorkPage']);
        this.addListener('addWorkPage', function(config) {
            var chain = me.getActionChain('addWorkAreaPage');
            chain.execute(config);
        });
        this.relayEvents(canvas, ['updatePatient']);
        this.addListener('updatePatient', function(config) {
            var chain = me.getActionChain('updatePatient');
            chain.execute(config);
        });
        this.relayEvents(canvas, ['portalRender']);
        this.addListener('portalRender', function() {
            var chain = me.getActionChain('closeWorkPage');
            chain.execute();
        });
        this.relayEvents(canvas, ['portalRender2']);
        this.addListener('portalRender2', function() {
            var chain = me.getActionChain('openWorkPage');
            chain.execute();
        });
    }
})