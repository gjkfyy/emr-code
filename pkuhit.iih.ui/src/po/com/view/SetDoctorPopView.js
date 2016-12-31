Ext.define('iih.po.com.view.SetDoctorPopView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires: [],

    alias:'widget.setdoctorpopview',
    
    border: 0,
    
    layout: 'fit',

    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.po.com.block.SetDoctorPopBlock'
            }
        },

        actions: {
            'init': {
                xclass: 'iih.po.com.action.SetDoctorInitAction',
                blocks: {
                    content: 'content'
                }
            },
            'save': {
                xclass: 'iih.po.com.action.SetDoctorSaveAction',
                url: 'setDoctor',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'init': ['init'],
            'save': ['save']
        },

        connections: {
            'content': [{
                selector: 'button[name=confim]',
                event: 'click',
                chain: 'save'
            }]
        }
    }
})