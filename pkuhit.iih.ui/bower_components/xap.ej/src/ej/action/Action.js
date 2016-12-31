Ext.define('Xap.ej.action.Action', {

    constructor: function() {
        this.callParent(arguments);
        var arg = arguments[0];
        if(arg) {
        	Ext.apply(this, arg);
        }
        this.blocks = {};
    },

    execute:function(){
        Xap.debug('execute action [' + Ext.getClassName(this) + ']');
    },

    addBlock: function(name, block) {
        if(name && block) {
            // TODO log
            this.blocks[name] = block;
        }
    },

    getBlock: function(name) {
        return this.blocks[name];
    },

    getOwner: function() {
        return this.owner;
    }
});