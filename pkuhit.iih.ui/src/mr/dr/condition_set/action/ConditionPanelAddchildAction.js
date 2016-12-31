Ext.define('iih.mr.dr.condition_set.action.ConditionPanelAddchildAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var owner = this.getOwner();
		var ownerCt = owner.ownerCt;
		var block = ownerCt.getBlock('right');
		var upcond = block.down('xaptextfield[name=upcond]');
		var upcondV = upcond.value;
		if(upcondV==undefined || Ext.isEmpty(upcondV, false)){
			XapMessageBox.info('请选择一个父条件！');
			return;
		}
		
		var conditionType = block.down('xapcombobox[name=conditionType]');
		conditionType.select("2");
		
		var grade = block.down('xaptextfield[name=grade]');
		var gradeV = grade.value;
		grade.setValue(parseInt(gradeV)+1);
    }
});
