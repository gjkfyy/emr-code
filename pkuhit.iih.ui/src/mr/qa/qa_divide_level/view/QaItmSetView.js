/** 
 * 质控项目设置（新增、编辑）视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaItmSetView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qaitmsetview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'Xap.ej.element.field.RangeNumberField',
	          'iih.mr.qa.QaStatusGlobal',
	          'iih.mr.qa.qa_divide_level.block.QaItmSetBlock',
	          'iih.mr.qa.qa_divide_level.action.QaItmFstCobSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSndCobSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSetSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmVaidatorAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmSaveAction',
	          'iih.mr.qa.process_qa_work.action.FaultInputCloseAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaItmSetBlock',
				height:220
			}
		},
		actions:{
			'initQaItmFst':{ 
                xclass:'iih.mr.qa.qa_divide_level.action.QaItmFstCobSearchAction',
                url:'qaitmfst',
                blocks:{
                    content: 'content'
                }
            },
            'searchQaItmSnd':{
                xclass:'iih.mr.qa.qa_divide_level.action.QaItmSndCobSearchAction',
                url:'itmsnd',
                blocks:{
                    content:'content'
                }
            },
            'init':{ 
                xclass:'iih.mr.qa.qa_divide_level.action.QaItmSetSearchAction',
                url:'qaitm/set',
                blocks:{
                    content: 'content'
                }
            },
			'vaidator':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmVaidatorAction',
				url:'qaitm/vaidator',
				blocks: {
				    content: 'content'
				}
			},
			'saveQaItm':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmSaveAction',
				url:'qaitm/save',
				blocks: {
				    content: 'content'
				}
			},
			'closeQaItm':{
				xclass: 'iih.mr.qa.process_qa_work.action.FaultInputCloseAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'initQaItmFst':['initQaItmFst'],
			'init':['init'],
			'searchQaItmSnd':['searchQaItmSnd'],
			'vaidator':['vaidator'],
			'saveQaItm':['saveQaItm'],
			'closeQaItm':['closeQaItm']
		},
		connections:{
			'content':[/*{
                event:'afterrender',
                chain:'init'
            },*/{
                selector: 'xapcombobox[name=fstCd]',
                event: 'change',
                chain: 'searchQaItmSnd'
            },{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'vaidator'
			},{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'closeQaItm'
			}/*,{
				selector: 'xaptextfield[name=nm]',
				event: 'blur',
				chain: 'vaidatorNm'
			}*/]
		}
	}
})