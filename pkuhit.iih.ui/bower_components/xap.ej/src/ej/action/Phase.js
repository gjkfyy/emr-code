Ext.define('Xap.ej.action.Phase', {
    constructor: function() {
        this.callParent(arguments);
        this.name = '';
        this.actions = [];
    },

    getName: function() {
        return this.name;
    },

    addAction: function(action) {
        this.actions.push(action);
    },

    getActions: function() {
        return this.actions;
    },

    getSize: function() {
        return 0;
    },

    // TODO remove

    execute: function() {
        for(var i = 0; i < this.actions.length; i++) {
            var action = this.actions[i];
            // TODO 如果执行失败应当中断执行
            // TODO try catch
            // TODO 
            // action.execute(context);
            if(action.execute)
                action.execute({});
        }
    }
});