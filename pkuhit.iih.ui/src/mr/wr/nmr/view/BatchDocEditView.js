Ext.define('iih.mr.wr.nmr.view.BatchDocEditView', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [],
	alias : 'widget.batchdoceditview',
	layout : 'fit',
	id : 'batchdoceditview',
	xapConfig : {
		blocks : {
			'content' : {
				xclass : 'iih.mr.block.editor.MrDocEditBlock',
				flex : 1
			}
		},

		actions : {
			'init' : {
				xclass : 'iih.mr.wr.nmr.action.BatchDocInitAction',
				url : 'nmr',
				blocks : {
					bottom : 'bottom'
				}
			},
			'openMrDoc' : {
				xclass : 'iih.mr.wr.mr.action.OpenMrAction',
				url : 'omr',
				blocks : {
					content : 'content'
				}
			},
			'emrCmdDispatch' : {
				xclass : 'iih.mr.action.editor.EmrCmdDispatchAction',
				blocks : {
					content : 'content'
				}
			},
			'emrEditorOperator' : {
				xclass : 'iih.mr.action.editor.EmrEditorOperatorAction'
			},
			'emrSave' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocSaveAction',
				url : 'nmr',
				// url: 'http://127.0.0.1:8081/mr',
				blocks : {
					content : 'content'
				}
			},
			'emrDocProperty' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocPropertyAction',
				url : 'nmr',
				blocks : {
					content : 'content'
				}
			},
			'emrSubmit1' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocSubmitAction',
				url : 'submit/nmr',
				blocks : {
					content : 'content'
				}
			},
			'emrSignDispose' : {
				xclass : 'iih.mr.wr.mr.action.MrSignDisposeAction',
				url : 'signUser',
				blocks : {
					content : 'content'
				}
			},
			'emrRevoke' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocRevokeAction',
				url : 'submit/nmr',
				blocks : {
					content : 'content'
				}
			},
			'emrReject' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocRejectAction',
				url : 'rejected/nmr/',
				blocks : {
					content : 'content'
				}
			},
			'emrRefreshMacro' : {
				xclass : 'iih.mr.wr.nmr.action.RefreshMacroAction',
				url : 'macroElement',
				blocks : {
					content : 'content'
				}
			},
			'emrImageLibraries' : {
				xclass : 'iih.mr.wr.nmr.action.ShowEmrImageAction',
				url : 'param',
				blocks : {
					content : 'content'
				}
			},
			'emrStartApprove' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocStartApproveAction',
				url : 'startApprove/nmr',
				blocks : {
					content : 'content'
				}
			},
			'emrApprove' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocApproveAction',
				url : '/signUser',
				blocks : {
					content : 'content'
				}
			},
			'approvePost' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocApprovePostAction',
				url : 'approve/nmr',
				blocks : {
					content : 'content'
				}
			},
			'emrAuditRevoke' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocAuditRevokeAction',
				url : 'approve/nmr',
				blocks : {
					content : 'content'
				}
			},
			'disabledOfficeToolBarAction' : {
				xclass : 'iih.mr.wr.nmr.action.BatchDisabledOfficeToolBarAction',
				url : 'param',
				blocks : {
					content : 'content'
				}
			},
			'editorCallBackAction' : {
				xclass : 'iih.mr.wr.nmr.action.BatchEditorCallBackAction',
				url : 'param',
				blocks : {
					content : 'content'
				}
			},
			'emrPrint' : {
				xclass : 'iih.mr.wr.nmr.action.BatchPrintAction',
				blocks : {
					content : 'content'
				}
			},
			'emrExportXML' : {
				xclass : 'iih.mr.wr.mr.action.EmrEmrExportXMLAction',
				blocks : {
					content : 'content'
				}
			},
			'emrHyperlink' : {
				xclass : 'iih.mr.action.editor.EmrHyperlinkAction',
				blocks : {
					content : 'content'
				}
			},
			'showHyperlink' : {
				xclass : 'iih.mr.action.editor.ShowHyperlinkWindowAction',
				blocks : {
					content : 'content'
				}
			},
			'emrPrintSelected' : {
				xclass : 'iih.mr.wr.mr.action.SelectedPrintAction',
				blocks : {
					content : 'content'
				}
			},
			'saveDocProgressBar' : {
				xclass : 'iih.mr.wr.nmr.action.NmrDocProgressBarAction',
				blocks : {
					content : 'content'
				}
			},
			'emrSplData' : {
				xclass : 'iih.mr.wr.nmr.action.emrSplFmPkAction',
				url : 'spl/nmr',
				blocks : {
					content : 'content'
				}
			},
			'nmrUseSign' : {
				xclass : 'iih.mr.wr.nmr.action.NmrUseSignAction',
				url : 'mrSign/user',
				blocks : {
					content : 'content'
				}
			}
		},

		chains : {
			'init' : [ 'init' ],
			'emrExportXML' : [ 'emrExportXML' ],
			// 'openMrDoc': ['openMrDoc'],
			// 'emrRefreshOutpatientDisposal':['emrRefreshOutpatientDisposal'],
			'emrSignDispose' : [ 'emrSignDispose' ],
			'emrRevoke' : [ 'emrRevoke' ],
			'emrSubmit' : [ 'nmrUseSign' ],
			'emrSubmit1' : [ 'emrSubmit1' ],
			'emrStartApprove' : [ 'emrStartApprove' ],
			'emrApprove' : [ 'emrApprove' ],
			'approvePost' : [ 'approvePost' ],
			'emrReject' : [ 'emrReject' ],
			'emrAuditRevoke' : [ 'emrAuditRevoke' ],
			'upPro' : [ 'upPro' ],
			'emrCmdDispatch' : [ 'emrCmdDispatch' ],
			'emrSave' : [ 'saveDocProgressBar' ],
			'emrPrint' : [ 'emrPrint' ],
			'emrRefreshMacro' : [ 'emrRefreshMacro' ],
			'disabledOfficeToolBarAction' : [ 'disabledOfficeToolBarAction' ],
			'editorCallBackAction' : [ 'editorCallBackAction' ],
			'emrHyperlink' : [ 'emrHyperlink' ],
			'emrNeatPrint' : [ 'emrNeatPrint' ],
			'showHyperlink' : [ 'showHyperlink' ],
			'emrDocProperty' : [ 'emrDocProperty' ],
			'emrPrintSelected' : [ 'emrPrintSelected' ],
			'emrImageLibraries' : [ 'emrImageLibraries' ],
			'emrSplData' : [ 'emrSplData' ],
			'saveDocProgressBar' : [ 'emrSave' ]
		},

		connections : {
			'content' : [ {
				selector : 'button[name=editorEvent]',
				event : 'editorEvent',
				chain : 'emrCmdDispatch'
			} ]
		}
	},

	initComponent : function() {
		var me = this;
		this.callParent();
		var canvas = Xap.getCanvas();
		this.relayEvents(canvas, [ 'refreshWorkArea' ]);
		this.addListener('refreshWorkArea', function(config) {
			var mrSn = config.viewConfig.mrSn;
			var chain = me.getActionChain('openMrDoc');
			// chain.execute({mrSn:mrSn});
		});
	},

	hasEdit : function() {
		var plugin = document.getElementById('iemrEditor');
		if (plugin != undefined && plugin.valid && plugin.IsModified()) {
			return true;
		} else {
			return false;
		}
	}
});