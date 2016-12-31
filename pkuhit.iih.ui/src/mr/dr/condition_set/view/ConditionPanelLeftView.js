Ext.define('iih.mr.dr.condition_set.view.ConditionPanelLeftView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			
			alias : 'widget.conditionpanelleftview',
			
			requires : [
			        'iih.mr.dr.condition_set.block.ConditionTreeBlock',
					'iih.mr.dr.condition_set.block.ConditionButtonBlock',
					'iih.mr.dr.condition_set.action.ConditionPanelAddAction',
					'iih.mr.dr.condition_set.action.ConditionPanelAddchildAction',
					'iih.mr.dr.condition_set.action.ConditionPanelAddgroupAction',
					'iih.mr.dr.condition_set.action.ConditionPanelAddgroupchildAction',
					'iih.mr.dr.condition_set.action.ConditionPanelDeleteAction',
					'iih.mr.dr.condition_set.action.ConditionPanelChangeupAction',
					'iih.mr.dr.condition_set.action.ConditionPanelChangedownAction'
				],
			
			border: 0,

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.mr.dr.condition_set.block.ConditionTreeBlock',
						width : 300
					},
					'right' : {
						xclass : 'iih.mr.dr.condition_set.block.ConditionButtonBlock',
						width : 100
					}
				},

					actions : {
						'add':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelAddAction',
							blocks: {
								result: 'right'
							}
						},'addchild':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelAddchildAction',
							blocks: {
								result: 'right'
							}
						},'addgroup':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelAddgroupAction',
							blocks: {
								result: 'right'
							}
						},'addgroupchild':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelAddgroupchildAction',
							blocks: {
								result: 'right'
							}
						},'delete':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelDeleteAction',
							url:'dr/delretrievalcond',
							blocks: {
								result: 'right'
							}
						},'changeup':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelChangeupAction',
							url:'dr/retrievalcond/up',
							blocks: {
								result: 'right'
							}
						},'changedown':{
							xclass: 'iih.mr.dr.condition_set.action.ConditionPanelChangedownAction',
							url:'dr/retrievalcond/down',
							blocks: {
								result: 'right'
							}
						},'treeClick': {
			                xclass: 'iih.mr.dr.condition_set.action.MrDocTreeNodeAction',
			                blocks: {
			                	left: 'left',
			                	right: 'right'
			                }
			            }
					},

					chains : {
						'add': ['add'],
						'addchild': ['addchild'],
						'addgroup': ['addgroup'],
						'addgroupchild': ['addgroupchild'],
						'delete': ['delete'],
						'changeup': ['changeup'],
						'changedown': ['changedown'],
		        		'treeClick':['treeClick']
					},

					connections : {
						'right': [{
							selector: 'button[method=add]',
							event: 'click',
							chain: 'add'
						},{
							selector: 'button[method=addchild]',
							event: 'click',
							chain: 'addchild'
						},{
							selector: 'button[method=addgroup]',
							event: 'click',
							chain: 'addgroup'
						},{
							selector: 'button[method=addgroupchild]',
							event: 'click',
							chain: 'addgroupchild'
						},{
							selector: 'button[method=delete]',
							event: 'click',
							chain: 'delete'
						},{
							selector: 'button[method=changeup]',
							event: 'click',
							chain: 'changeup'
						},{
							selector: 'button[method=changedown]',
							event: 'click',
							chain: 'changedown'
						}]
					}
				},
			    
			    initComponent : function() {
			        this.callParent();
			        var me = this;
			        var tree = me.down('[name=conditionTree]');
			        tree.addListener('itemclick', function(v,r,it,i,e,eOpts){
			    		var chain = me.getActionChain('treeClick');
			    		var condCd = r.raw.data.condCd;
			    		var grade = r.raw.data.grade;
			    		var treeBlock = me.ownerCt.down('conditionpanelrightblock');
			    		upcond = treeBlock.down('xaptextfield[name=upcond]');
			    		upcond.setValue(condCd);
			    		gradeO = treeBlock.down('xaptextfield[name=grade]');
			    		gradeO.setValue(grade);
			        });
			    }
		});