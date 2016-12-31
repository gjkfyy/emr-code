Ext.define('iih.mr.tm.gro.view.GroupElementChooseEditView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: [
               'iih.mr.block.editor.MrDocEditBlock', 
               'iih.mr.tm.gro.action.GroupChooseEditThroughAction',
               'iih.mr.tm.gro.action.GroupChooseEditCancelBtnAction',
               'iih.mr.tm.gro.action.GroupElementChooseEditAction'/*, 
               'iih.mr.action.editor.EmrCmdDispatchAction', 
               'iih.mr.action.editor.EmrEditorOperatorAction'*/
               ],

    alias: 'widget.groupelementchooseeditview',
    
    layout: {
        type : 'vbox',
        align : 'stretch'
    },

    xapConfig: {
        blocks: {
            'top': {
                xclass: 'iih.mr.block.editor.MrDocEditBlock',
                layout: 'fit',
                border: false,
                padding: '1 1 1 1',
                flex:1
            },
            'bottom':{
            	xclass: 'iih.mr.tm.gro.block.GroupChooseBottomBlock',
//            	layout: 'fit',
                border: 0,
                padding: '1 1 1 1',
                header: false,
                height:80
            }
        },


        actions: {
           'init': {
                xclass: 'iih.mr.tm.gro.action.GroupElementChooseEditAction',
                url: 'mr/basefile',
                blocks: {
                	top: 'top'
                }
            },
            'throughBtn': {
                xclass: 'iih.mr.tm.gro.action.GroupChooseEditThroughAction',
                url: 'mr/basefile',
                blocks: {
                	bottom: 'bottom'
                }
            },
            'cancelBtn': {
                xclass: 'iih.mr.tm.gro.action.GroupChooseEditCancelBtnAction',
                //url: 'mr/basefile',
                blocks: {
                	bottom: 'bottom'
                }
            }
            /*, 
            'emrCmdDispatch': {
                xclass: 'iih.mr.action.editor.EmrCmdDispatchAction',
                blocks: {
                	top: 'top'
                }
            },
            'emrEditorOperator': {
                xclass: 'iih.mr.action.editor.EmrEditorOperatorAction'
            }*/
        },

        chains: {
            'init': ['init'],
            'throughBtn': ['throughBtn'],
            'cancelBtn': ['cancelBtn']/*,
            'emrCmdDispatch': ['emrCmdDispatch'],*/
        },

        connections: {
            'top': [/*{
                selector: 'button[method=editorEvent]',
                event: 'editorEvent',
                chain: 'emrCmdDispatch'
            },*/ {
                event: 'afterrender',
                chain: 'init'
            }],
            'bottom':[{
	            	selector: 'button[method=throughBtn]',
	                event: 'click',
	                chain: 'throughBtn'
             	},{
             		selector: 'button[method=cancelBtn]',
	                event: 'click',
	                chain: 'cancelBtn'
             }]
        }
    }
})