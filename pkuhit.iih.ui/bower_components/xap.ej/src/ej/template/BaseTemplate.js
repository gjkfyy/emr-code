Ext.define('Xap.ej.template.BaseTemplate', {
    extend: 'Xap.ej.block.Block',

    requires: ['Xap.ej.config.Configable'],

    alias: 'widget.xapbasetemplate',

    border: 0,

    mixins: ['Xap.ej.config.Configable'],

    initBlock: function() {
        this.callParent();
        this.actions = {};
        this.chains = {};
        this.blocks = {};
        if(this.doCheckXapConfig) {
            this.doCheckXapConfig();
        }
        this.doXapConfig();
    }
});
