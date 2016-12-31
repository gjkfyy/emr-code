Ext.define('iih.mr.wr.mr.view.MrDocEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: [],
    alias: 'widget.mrdoceditview',
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.block.editor.MrDocEditBlock',
                flex: 1
            }
        },

        actions: {
            'init': {
                xclass: 'iih.mr.wr.mr.action.MrDocEditAction',
                url:'mr',
                blocks: {
                    content: 'content'
                }
            }, 
            'openMrDoc': {
                xclass: 'iih.mr.wr.mr.action.OpenMrAction',
                url: 'mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrCmdDispatch': {
                xclass: 'iih.mr.action.editor.EmrCmdDispatchAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrSave': {
                xclass: 'iih.mr.wr.mr.action.MrDocSaveAction',
                url: 'mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrReadOnly': {
                xclass: 'iih.mr.wr.mr.action.MrReadonlyAction',
                url: 'locked/mr'
            },
            'emrEdit':{
            	xclass:'iih.mr.wr.mr.action.MrDocCanEditAction',
            	url:'locked/mr'
            },
            'emrDocProperty': {
                xclass: 'iih.mr.wr.mr.action.MrDocPropertyAction',
                url: 'mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrSubmit':{
                xclass: 'iih.mr.wr.mr.action.MrCheckUserCaAction',
                url: '/signUser',
                blocks: {
                    content: 'content'
                }
            },
            'showLoginWin':{
                xclass: 'iih.mr.wr.mr.action.MrShowLoginWinAction',
                //url: '/signUser',
                blocks: {
                    content: 'content'
                }
            },
            'checkUserRole':{
                xclass: 'iih.mr.wr.mr.action.CheckUseRoleAction',
                url: 'mr/xapUserCheckMrSubmit',
                blocks: {
                    content: 'content'
                }
            },
            'emrSubmit2': {
                xclass: 'iih.mr.wr.mr.action.MrDocSubmitAction',
                url: 'submit/mr',
                blocks: {
                    content: 'content'
                }
            },
            /*'emrPrint':{
                xclass: 'iih.mr.wr.mr.action.MrPrintAction',
                blocks: {
                    content: 'content'
                }
            },*/
            'approvePost': {
                xclass: 'iih.mr.wr.mr.action.MrDocApprovePostAction',
                url: 'approve/mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrRevoke': {
                xclass: 'iih.mr.wr.mr.action.MrDocRevokeAction',
                url: 'submit/mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrApprove2': {
                xclass: 'iih.mr.wr.mr.action.MrDocApproveAction',
                url: 'signUser',
                blocks: {
                    content: 'content'
                }
            },
            'emrApprove': {
           	 	xclass: 'iih.mr.wr.mr.action.MrCheckUserCaAction',
           	 	url: '/signUser',
           	 	blocks: {
           	 		content: 'content'
           	 	}
            },
            'emrStartApprove':{
            	xclass: 'iih.mr.wr.mr.action.MrDocStartApproveAction',
                url: 'startApprove/mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrSignDispose':{
            	xclass: 'iih.mr.wr.mr.action.MrSignDisposeAction',
                url: 'signUser',
                blocks: {
                    content: 'content'
                }
            },
            'emrReject': {
                xclass: 'iih.mr.wr.mr.action.MrDocRejectAction',
                url: 'rejected/mr/',
                blocks: {
                    content: 'content'
                }
            },
            'emrAuditRevoke': {
                xclass: 'iih.mr.wr.mr.action.MrDocAuditRevokeAction',
                url: 'approve/mr',
                blocks: {
                    content: 'content'
                }
            },
            'emrSaveAsTemplate': {
                xclass: 'iih.mr.wr.mr.action.MrDocSaveAsTemplateAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrRefreshMacro': {
                xclass: 'iih.mr.wr.mr.action.RefreshMacroAction',
                url:'macroElement',
                blocks: {
                    content: 'content'
                }
            },
            'emrRefreshMrDocValue': {
                xclass: 'iih.mr.wr.mr.action.RefreshMrDocValueAction',
                url:'mrDocValue',
                blocks: {
                    content: 'content'
                }
            },
            'emrRefreshDiagnosis': {
                xclass: 'iih.mr.wr.mr.action.RefreshMrDiagnosisAction',
                url:'diagnosises',
                blocks: {
                    content: 'content'
                }
            },
            'editorCallBackAction': {
                xclass: 'iih.mr.wr.mr.action.EditorCallBackAction',
                url:'signUser',
                blocks: {
                    content: 'content'
                }
            },
            'disabledOfficeToolBarAction': {
                xclass: 'iih.mr.wr.mr.action.DisabledOfficeToolBarAction',
                url:'current_user',
                blocks: {
                    content: 'content'
                }
            },
            'emrNeatPrint': {
                xclass: 'iih.mr.wr.mr.action.MrDocNeatPrintAction',
                url: 'mr_doc_file',
                blocks: {
                    content: 'content'
                }
            },
            'emrPrintSelected': {
                xclass: 'iih.mr.wr.mr.action.SelectedPrintAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrContinuePrint': {
                xclass: 'iih.mr.wr.mr.action.MrContinuePrintAction',
                url: 'mrs/for/continue/print',
                blocks: {
                    content: 'content'
                }
            },
            'emrSelectContinuePrint': {
                xclass: 'iih.mr.wr.mr.action.MrSelectContinuePrintAction',
                url: 'mrs',
                blocks: {
                    content: 'content'
                }
            },
            'emrEditorOperator': {
                xclass: 'iih.mr.action.editor.EmrEditorOperatorAction'
            },
            'emrRefreshValues':{
            	xclass: 'iih.mr.wr.mr.action.RefreshValuesAction',
            	url: 'allValue',
                blocks: {
                    content: 'content'
                }
            },
            'mergeAll':{
            	xclass: 'iih.mr.wr.mr.action.MergeAllAction',
                blocks: {
                    content: 'content'
                }
            },
            'closeProgress':{
            	xclass: 'iih.mr.wr.mr.action.CloseProgressAction',
                blocks: {
                    content: 'content'
                }
            },
            'emrPrint':{
            	xclass: 'iih.mr.wr.mr.action.PrintAction',
            	url:'mr/checkMrPrint',
                blocks: {
                    content: 'content'
                }
            },
            'mrbPrint':{
            	xclass: 'iih.mr.wr.mr.action.AddPrintCountAction',
            	url:'mr/updateMrPrintCount',
                blocks: {
                    content: 'content'
                }
            },
            
            'emrExportXML':{
            	xclass: 'iih.mr.wr.mr.action.EmrEmrExportXMLAction',
                blocks: {
                    content: 'content'
                }
            }
            ,'showHyperlink':{
            	xclass: 'iih.mr.action.editor.ShowHyperlinkWindowAction',
            	blocks: {
                     content: 'content'
                }
            },
            'emrHyperlink':{
            	xclass: 'iih.mr.action.editor.EmrHyperlinkAction',
                blocks: {
                    content: 'content'
                }
            },
            'mrPrintOPLog':{
                xclass: 'iih.mr.wr.omr.action.OmrPrintOpLogAction',
                url: 'omr/print/log',
                blocks: {
                    content: 'content'
                }
        }
       },

        chains: {
            'init': ['init'],
            'emrExportXML':['emrExportXML'],
            'openMrDoc': ['openMrDoc'],
            'emrPrint': ['emrPrint'],
            'emrPrintSelected':['emrPrintSelected'],
            'emrCmdDispatch': ['emrCmdDispatch'],
            'emrSave': ['emrSave'],
            'closeProgress': ['closeProgress'],
            'doSave': ['emrSave'],
            'emrReadOnly': ['emrReadOnly'],
            'emrEdit': ['emrEdit'],
            'mergeAll': ['mergeAll'],
            'emrDocProperty': ['emrDocProperty'],
            'emrSubmit':['checkUserRole'],
            'emrSubmit1':['emrSubmit'],
            'showLoginWin':['showLoginWin'],
            'emrSubmit2':['emrSubmit2'],
            'emrPrint':['emrPrint'],
            'emrApprove2':['emrApprove2'],
            'mrSubmit':['mrSubmit'],
            'emrSignDispose':['emrSignDispose'],
            'emrRevoke':['emrRevoke'],
            'emrStartApprove':['emrStartApprove'],
            'emrApprove':['checkUserRole'],
            'emrReject':['emrReject'],
            'emrAuditRevoke':['emrAuditRevoke'],
            'emrSaveAsTemplate':['emrSaveAsTemplate'],
            'emrRefreshMacro':['emrRefreshMacro'],
            'emrRefreshReference':['emrRefreshMrDocValue'],
            'emrRefreshValues':['emrRefreshValues'],
            'emrRefreshMrDocValue':['emrRefreshMrDocValue'],
            'emrRefreshDiagnosis':['emrRefreshDiagnosis'],
            'disabledOfficeToolBarAction':['disabledOfficeToolBarAction'],
            'editorCallBackAction':['editorCallBackAction'],
            'emrNeatPrint':['emrNeatPrint'],
            'emrContinuePrint':['emrContinuePrint'],
            'approvePost':['approvePost'],
            'emrSelectContinuePrint':['emrSelectContinuePrint'],
            'showHyperlink':['showHyperlink'],
            'emrHyperlink':['emrHyperlink'],
            'checkUserRole':['checkUserRole'],
            'mrbPrint':['mrbPrint'],
            'mrPrintOPLog':['mrPrintOPLog']
        },

        connections: {
            'content': [{
                selector: 'button[method=editorEvent]',
                event: 'editorEvent',
                chain: 'emrCmdDispatch'
            }, {
                event: 'afterrender',
                chain: 'init'
            }]
        }
    },
    
    initComponent : function() {
        var me = this;
        this.callParent();
        var canvas = Xap.getCanvas();
        this.relayEvents(canvas, ['refreshWorkArea']);
        this.addListener('refreshWorkArea', function(config) {
            var mrSn = config.viewConfig.mrSn;
            var chain = me.getActionChain('openMrDoc');
//            chain.execute({mrSn:mrSn});
        });
    },
    
    hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }
})