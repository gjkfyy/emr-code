Ext.define('iih.mr.qa.qa_divide_level.action.CreateRuleAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* 当事件类型为多选时，动态的添加规则运算值（暂时不做多选）
	*/
	execute: function(context) {
		var owner = this.getOwner();
		var workAreaView = owner.up();
		var beforeLn = workAreaView.beforeLn;
		var beforeQaItmCd = workAreaView.beforeQaItmCd;
		var block = this.getBlock('content');
		var frequencyAuto = block.down('xapform[name=frequencyAuto]');
		var data = frequencyAuto.getData();
		var qaItmCd = data.qaItmCd;
		var eventTypeCodeF = frequencyAuto.down('xapcombobox[name=eventTypeCodeF]');
		var eventTypeName = frequencyAuto.down('xapdisplayfield[name=eventTypeName]');
		var eventTypeCode = eventTypeCodeF.getValue();
		var eventTypeCodeLength = eventTypeCode.length;
		var test = eventTypeCodeLength -1;
		var eventTypeCodeFNames = eventTypeCodeF.rawValue;
		var eventTypeCodeFName = eventTypeCodeFNames.split(',');
		if(beforeQaItmCd == undefined){ //判断是否为同一条质控项
			workAreaView.beforeQaItmCd = qaItmCd;
		}else if(beforeQaItmCd != qaItmCd){
			beforeLn = undefined;
		}
		if(beforeLn == undefined){ //判断初始化赋值
			if(eventTypeCodeLength>1){
				eventTypeName.setValue(eventTypeCodeFName[0]);
				for(var i=1;i<eventTypeCodeLength;i++){
					var blankdisplayfield0 = Ext.create("Xap.ej.element.field.DisplayField", {
								 vertical: true
						});
					var eventTypeNamei = Ext.create("Xap.ej.element.field.DisplayField", {
							xtype:'xapdisplayfield',
							margin:'10 0 0 0',
							vertical: true,
							fieldLabel: '',
							name:'eventTypeName'+'i',
							value:''
						});
					eventTypeNamei.setValue(eventTypeCodeFName[i])
					var numberfield = Ext.create("Xap.ej.element.field.NumberField", {
							margin:'10 0 0 0',
					        width:100,
					        vertical: true,
							fieldLabel:'',
							labelAlign : 'left'
						});
					var displayfield = Ext.create("Xap.ej.element.field.DisplayField", {
							margin:'10 0 0 0',
					        vertical: true,
							fieldLabel:'',
							labelAlign : 'left',
							value:'天/次'
						});
					var blankdisplayfield = Ext.create("Xap.ej.element.field.DisplayField", {
								colspan:8,
								 vertical: true
						});
					var blankdisplayfield1 = Ext.create("Xap.ej.element.field.DisplayField", {
								 vertical: true
						});
						
					frequencyAuto.insert(14,blankdisplayfield0);
					frequencyAuto.insert(15,eventTypeNamei);
					frequencyAuto.insert(16,numberfield);
					frequencyAuto.insert(17,displayfield);
					frequencyAuto.insert(18,blankdisplayfield);
					frequencyAuto.insert(19,blankdisplayfield1);
				}
			}else{
				eventTypeName.setValue(eventTypeCodeFName);
			}
			workAreaView.beforeLn = eventTypeCodeLength;
		}else{
			if(beforeLn>eventTypeCodeLength){ //减少一个
				/*if(eventTypeCodeLength <= 1){
					var eventTypeName1 = frequencyAuto.down('xapdisplayfield[name=eventTypeName1]');
					eventTypeName.setValue(eventTypeCodeFName[0]);
				}else{
					eventTypeName.setValue(eventTypeCodeFName[0]);
					eventTypeNamei.setValue('')
				}*/
				
				frequencyAuto.removeDocked(blankdisplayfield0,true);
				frequencyAuto.remove(eventTypeName1);
				frequencyAuto.remove(numberfield);
				frequencyAuto.remove(displayfield);
				frequencyAuto.remove(blankdisplayfield);
				frequencyAuto.remove(blankdisplayfield1);
				workAreaView.beforeLn = eventTypeCodeLength;
			}else{ //添加一个
				var blankdisplayfield0 = Ext.create("Xap.ej.element.field.DisplayField", {
							 vertical: true
					});
				var eventTypeName1 = Ext.create("Xap.ej.element.field.DisplayField", {
						margin:'10 0 0 0',
						vertical: true,
						fieldLabel: '',
						name:'eventTypeName',
						value:''
					});
				eventTypeName1.setValue(eventTypeCodeFName[eventTypeCodeLength -1]);
				var numberfield = Ext.create("Xap.ej.element.field.NumberField", {
						margin:'10 0 0 0',
				        width:100,
				        name:'number',
				        vertical: true,
						fieldLabel:'',
						labelAlign : 'left'
					});
				var displayfield = Ext.create("Xap.ej.element.field.DisplayField", {
						margin:'10 0 0 0',
				        vertical: true,
						fieldLabel:'',
						labelAlign : 'left',
						value:'天/次'
					});
				var blankdisplayfield = Ext.create("Xap.ej.element.field.DisplayField", {
							colspan:8,
							 vertical: true
					});
				var blankdisplayfield1 = Ext.create("Xap.ej.element.field.DisplayField", {
							 vertical: true
					});
				frequencyAuto.insert(14,blankdisplayfield0);
				frequencyAuto.insert(15,eventTypeName1);
				frequencyAuto.insert(16,numberfield);
				frequencyAuto.insert(17,displayfield);
				frequencyAuto.insert(18,blankdisplayfield);
				frequencyAuto.insert(19,blankdisplayfield1);
				
				workAreaView.beforeLn = eventTypeCodeLength;
			}
		}
		workAreaView.beforeQaItmCd = qaItmCd;
	}
});
