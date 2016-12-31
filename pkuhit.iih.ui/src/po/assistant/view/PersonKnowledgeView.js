Ext.define('iih.po.assistant.view.PersonKnowledgeView',{
	extend : 'Xap.ej.stl.view.BorderTemplate',

	requires: ['iih.po.assistant.action.CreateMrKnowledgeAction',
			   'iih.po.assistant.action.PersonKnoeledgeSearchAction'],
	
	alias:'widget.personknowledgeview',
	
	xapConfig: {
		blocks: {
			'west': {
				xclass: 'iih.po.assistant.block.MrKnowledgeBlock'						
			},
			'center':{
				xclass: 'iih.po.assistant.block.PersonKnowledgePropertyBlock'
			}
		},
		actions: {	
			'init': {
                xclass: 'iih.po.assistant.action.PersonKnoeledgeSearchAction',
				url: 'knowledges',
				blocks: {
				   result:'west'
				}           
			},
		    'select':{
                xclass:'iih.po.assistant.action.FragmentGridclickAction',
                url:'mr',
                blocks:{
                    west:'west',
				    center:'center'
                }
            },
		    'getSelect':{
                xclass:'iih.po.assistant.action.GetSelectFragmentTplAction',
                blocks:{
                    west:'west'
                }
            },
		    'delete':{
                xclass:'iih.po.assistant.action.DeleteFragmentTplAction',
                url:'knowledge',
                blocks:{
                    west:'west'
                }
            },
		    'edit':{
                xclass:'iih.po.assistant.action.CreateMrKnowledgeAction',
                blocks:{
                    west:'west'
                }
            },
            'checkChange':{
                xclass:'iih.po.assistant.action.FragmentCheckChangeAction'/*,
                blocks:{
                    west:'west'
                }*/
            },
            'enterPress':{
                xclass:'iih.mr.wr.mr.action.EnterPressAction',
                blocks:{
                    result:'condition'
                }
            }
            
		},
		chains: {	
			'init': ['init'],
			'select': ['select'],
			'delete': ['delete'],
			'getSelect': ['getSelect'],
			'edit': ['edit'],
			'checkChange': ['checkChange'],
			'enterPress':['enterPress']
		},

		connections: {
			'west': [/*{
				event: 'afterrender',
				chain: 'checkChange'//checkChange中有对复选框初始化的操作(初始化为至少选择一个)，然后调用init初始化
			},*/{
				selector: 'xapgrid',
                event: 'itemclick',
                chain: 'select'
            },{
                selector: 'xapcheckbox[name=personal]',
                event: 'change',
                chain: 'checkChange'
            },{
                selector: 'xapcheckbox[name=dept]',
                event: 'change',
                chain: 'checkChange'
            },{
                selector: 'xaptrigger[name=fragmentTplNm]',
                event: 'onTriggerClick',
                chain: 'init'
			},{
                selector: 'xaptrigger[name=fragmentTplNm]',
                event: 'specialkey',
                chain: 'enterPress'//回车键检索
            }],
			'center': [{
				selector: 'button[method=create]',
				event: 'click',
				chain: 'edit'//新建
			},{
				selector: 'button[method=delete]',
				event: 'click',
				chain: 'getSelect'//得到选择对象，后执行删除操作
			},{
				selector: 'button[method=edit]',
				event: 'click',
				chain: 'edit'//编辑
			}]		
		}
	},
   	initComponent : function() {
		this.callParent();
		var me = this;
		this.addEvents("writeMrDoc");//为视图添加事件
		this.addListener('writeMrDoc', function(){//添加监听事件
			//写回病历
			var hisDocPlugin=document.getElementById('iemrEditor');
			if(!hisDocPlugin.IsReadOnly()){
				var centerBlock = this.getBlock('center');
				var value = centerBlock.down('xaptextarea').value;
				var ta=centerBlock.down('xaptextarea').inputEl.dom;
				var s=ta.selectionStart;
				var e=ta.selectionEnd;
				var text=value.substring(s,e);
				var westBlock = this.getBlock('west');
				var grid = westBlock.down('xapgrid');
				var records = grid.getSelectionModel().getSelection();
				if(records.length>0||text.length>0||value.length>0){
					if(text.length>0){
						hisDocPlugin.InsertText(text);
					}else{
						hisDocPlugin.InsertText(value);
					}
				}else{
					XapMessageBox.info("请选择一条记录！");

//					Ext.Msg.alert("提示","请选择一条记录！");
				}
			}
		});
		this.addEvents("changeEncounter");//为视图添加刷新事件
        this.addListener('changeEncounter', function(enPk){//添加监听事件
            //查询action
            var chain = me.getActionChain('init');
            chain.execute({
                'enPk':enPk
            });
        });
	}
})