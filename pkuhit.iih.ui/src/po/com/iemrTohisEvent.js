Ext.define('iih.po.com.iemrTohisEvent', {
	extend: "Ext.util.Observable",
	singleton: true,
    constructor: function (value) {
    	this.callParent();
        this.addEvents(
            'diagnosisComit'
        );
    }
});