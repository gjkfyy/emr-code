Ext.define('iih.mr.dr.condition_set.view.ConditionSettingInferView', {
			extend : 'Xap.ej.stl.view.LeftRightContainerTemplate',
			
			alias : 'widget.conditionsettinginferview',
			
			requires : [
			    'iih.mr.dr.condition_set.block.ConditionSettingInferLeftBlock',
			    'iih.mr.dr.condition_set.block.ConditionSettingInferRightBlock',
			    'iih.mr.dr.condition_set.action.ConditionSettingInferLeftInitAction', 
			    'iih.mr.dr.condition_set.action.ConditionSettingInferLeftInitTreeAction',
			    'iih.mr.dr.condition_set.action.MrDocTreeNodeAction'
			],

			xapConfig : {
				blocks : {
					'left' : {
						xclass : 'iih.mr.dr.condition_set.block.ConditionSettingInferLeftBlock',
						width : 300
					},
					'right' : {
						xclass : 'iih.mr.dr.condition_set.block.ConditionSettingInferRightBlock',
						flex : 1
					}
				},

				actions : {
					'init':{
						xclass: 'iih.mr.dr.condition_set.action.ConditionSettingInferLeftInitAction',
						url:'dr/template',
						blocks: {
							result: 'left'
						}
					},
					'initTree':{
						xclass: 'iih.mr.dr.condition_set.action.ConditionSettingInferLeftInitTreeAction',
						url:'dr/mrdoc/tree',
						blocks: {
							result: 'left'
						}
					},
					'treeClick': {
		                xclass: 'iih.mr.dr.condition_set.action.MrDocTreeNodeAction',
		                blocks: {
		                	left: 'left',
		                	right: 'right'
		                }
		            }
				},

				chains : {
					'init': ['init'],
					'initTree': ['initTree'],
		        	'treeClick':['treeClick']
				},

				connections : {
					'left': [{
						event: 'afterrender',
						chain: 'init'
					},{
		                selector: 'xapcombobox[name=mrDocType]',
		                event: 'change',
		                chain: 'initTree'
		            }]
				}
			},
		    
		    initComponent : function() {
		        this.callParent();
		        var me = this,clickNtime,clickOtime,ctime,textArea,area,content;
		        me.clicktime = '';
		        var tree = me.down('[name=mrDocTree]');
		        tree.addListener('itemclick', function(v,r,it,i,e,eOpts){
		    		var chain = me.getActionChain('treeClick');
		    		var leftBlock = me.down('conditionsettinginferleftblock');
		    		var mrDocType = leftBlock.down('xapcombobox[name=mrDocType]');
		    		var mrPk = mrDocType.value;
		    		var docType = r.raw.data.docType;
		    		var elemPath = r.raw.data.elemPath;
		    		var nodeType = r.raw.data.nodeType;
		    		var isLeaf = r.raw.data.isLeaf;//1叶子  0非叶子
		    		var leaf = r.raw.leaf;
		    		var rightBlock = me.down('conditionsettinginferrightblock');
		    		clickNtime = new Date();
//		        	if(!Ext.isEmpty(me.clicktime,false)){
//		        		clickOtime = me.clicktime;
//		        		ctime = clickNtime-clickOtime;
//		        		me.clicktime = clickNtime;
//		        		if(ctime<500){//双击触发
		        			if(isLeaf==1 || nodeType=="group"){//叶子节点
		        				content = r.raw.text;
		        				constraintObject = rightBlock.down('xaptextarea[name=constraintObject]');
		        				constraintObject.setValue(content);
		        				var conditionTypeC = rightBlock.down('xapcombobox[name=conditionType]').value;
		        		    	if(Ext.isEmpty(conditionTypeC, false)){
		        		    		conditionType = rightBlock.down('xapcombobox[name=conditionType]');
				                    conditionType.select("2");
		        		    	}
//		                        conditionType.selectAt(1);
		                        elemPathO = rightBlock.down('xaptextfield[name=elemPath]');
		                        elemPathO.setValue(elemPath);
		                        mrPkO = rightBlock.down('xaptextfield[name=mrPk]');
		                        mrPkO.setValue(mrPk);
		                        docTypeO = rightBlock.down('xaptextfield[name=docType]');
		                        docTypeO.setValue(docType);
		            		}
//		        		}
//		        	}
		        });
		    }
		});