Ext.define('iih.po.assistant.action.ObservationRightHandleTextAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	execute: function(context) {
		console.log('---------------- ObservationRightHandleTextAction -------------------');
		this.callParent();
        var center = this.getBlock('center');
        //console.log(center);
        var texts = center.down('xaptextarea');
        //console.log(texts);
        var eve = context.event;
        //console.log(eve);
        var textarea = eve.arguments[0];
        //console.log(textarea);
        textarea.setFieldStyle({'background-image': 'none','background-color': '#D9D9D9'});
//    	this.selectedCmp = cmp;
    }
});
