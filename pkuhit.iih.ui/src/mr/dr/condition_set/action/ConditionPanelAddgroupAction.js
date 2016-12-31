Ext.define('iih.mr.dr.condition_set.action.ConditionPanelAddgroupAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var owner = this.getOwner();
		var ownerCt = owner.ownerCt;
		var block = ownerCt.getBlock('right');
		var conditionType = block.down('xapcombobox[name=conditionType]');
		conditionType.select("3");
		
		var upcond = block.down('xaptextfield[name=upcond]');
		if(!Ext.isEmpty(upcond, false)){
			var grade = block.down('xaptextfield[name=grade]');
			var gradeV = grade.value;
			grade.setValue(parseInt(gradeV)+1);
		}
    }
});
