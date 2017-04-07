Ext.define('iih.po.com.view.WorkPageView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: ['Xap.ej.element.tab.Panel',
               'Xap.ej.element.radiogroup.RadioGroup'],
    
    alias:'widget.workpageview',
    
    layout: 'border',
    
    xapConfig: {
        blocks: {
            'workContent': {
                xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
                region: 'center',
                layout: 'fit',
                border: false,
                padding: '1 1 1 1',
                flex:1
            },
            'helpContent': {
                xclass: 'iih.po.com.block.AssistantBlock',
                region: 'south',
                split: {
                    border: true,
                    collapseOnDblClick: false,
                    style: 'background:#f1f1f1;border-color:#d0d0d0;color:black;font-size:12px;font-size:normal;border-width:0;border-style:solid'
                },
                header: false,
                layout: 'fit',
                border: false,
                padding: '1 1 1 1',
              
                height:0
            }
        },

        actions: {
            'assistantInit': {
                xclass: 'iih.po.com.action.AssistantInitAction',
                url: 'mr/ens',
                blocks:{
                    helpContent: 'helpContent'
                }
            },
            'ifShowBtn':{
            	xclass: 'iih.po.com.action.IfShowBtnAction',
            	url: 'param/set/getflagbykey',
                blocks:{
                    helpContent: 'helpContent'
                }
            },
            'otherOmrImplWay':{
            	xclass: 'iih.po.com.action.OtherOmrImplWayAction',
            	url: 'param/set/getflagbykey',
                blocks:{
                    helpContent: 'helpContent'
                }
            },
            'otherOmr':{
            	xclass: 'iih.po.com.action.PopUpAction',
                blocks: {
                    helpContent: 'helpContent'
                }
            },
            'changeEnType':{
            	xclass: 'iih.po.com.action.ChangeEnTypeAction',
                blocks: {
                    helpContent: 'helpContent'
                }
            }
        },

        chains: {
            'assistantInit':['assistantInit'],
            'ifShowBtn':['ifShowBtn'],
            'otherOmrImplWay':['otherOmrImplWay'],
            'otherOmr':['otherOmr'],
            'changeEnType':['changeEnType']
        },

        connections: {
            'helpContent': [{
                selector: 'combo[itemId=encounterCombox]',
                event: 'afterrender',
                chain: 'assistantInit'
            },{
                selector: 'combo[name=enType]',
                event: 'change',
                chain: 'changeEnType'
            }]
        }
    },
    
    initComponent : function() {
        this.callParent();
        this.addEvents("refreshWorkArea");
        var block = this.getBlock('helpContent');
        this.addListener('refreshWorkArea', function(parms) {
            //console.log(block);
            //console.log(parms);
        });
    }
})