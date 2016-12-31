Ext.define('iih.po.assistant.view.TodoListView', {
    extend : 'Xap.ej.template.BaseTemplate',

    requires : [],

    alias : 'widget.todolistview',

    layout: 'fit',
    
    xapConfig : {
        blocks : {
            'content' : {
                xclass : 'iih.po.assistant.block.TodoListBlock'
            }
        },
        actions: {
            'search': {
                xclass: 'iih.po.assistant.action.TodoListRefreshAction',
                url: 'searchTask',
                blocks: {
                    content: 'content'
                }
            },
            'complete': {
                xclass: 'iih.po.assistant.action.CompleteTaskAction',
                url: 'completeTask',
                blocks: {
                    content: 'content'
                }
            }
        },
        chains: {
            'search': ['search'],
            'complete':['complete']
        },

        connections: {
            'content': [{
                event: 'afterrender',
                chain: 'search'
            }]
        }
    }
});