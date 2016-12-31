Ext.define('iih.mr.wr.mr.view.MrLoginWinView', {
    extend: 'Xap.ej.template.BaseTemplate',

    requires: ['iih.mr.wr.mr.action.MrLoginUseCheckAction','iih.mr.wr.mr.action.LoginUserInitAction'],

    alias: 'widget.mrloginwinview',
    id:'mrloginwinview',
    layout: 'fit',
    xapConfig: {
        blocks: {
            'content': {
                xclass: 'iih.mr.wr.mr.block.MrLoginWinBlock',
                flex: 1
            }
        },

        actions: {
            'confim': {
                xclass: 'iih.mr.wr.mr.action.MrLoginUseCheckAction',
                url:'user/roles/mrCheckSubmitUser',
                blocks: {
                    content: 'content'
                }
            },'init': {
                xclass: 'iih.mr.wr.mr.action.LoginUserInitAction',
                url:'',
                blocks: {
                    content: 'content'
                }
            }
        },

        chains: {
            'confim': ['confim'],
            'init':['init']
        },

        connections: {
            'content': [{
                selector: 'button[method=confim]',
                event: 'click',
                chain: 'confim'
            }
            ,{
                event: 'afterrender',
                chain: 'init'
            }
            
            ]
        }
    }
})