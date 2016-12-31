/** 
 * 自动质控时限规则视图
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.view.QaAutoConfigView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.qaautoconfigview', 
	
	requires:[
	          'Xap.ej.block.ToolbarBlock',
	   		  'Xap.ej.element.button.Button',
	   		  'Xap.ej.element.grid.plugin.CellEditing',
	          'Xap.ej.element.grid.column.CheckColumn',
	          'Xap.ej.element.grid.column.Number',
	          'Xap.ej.element.field.NumberField',
	          'Xap.ej.block.GridBlock',
	          'Xap.ej.element.field.RangeNumberField',
	          'Xap.ej.element.field.Radio',
	          'iih.mr.qa.QaStatusGlobal',
	          'iih.mr.qa.qa_divide_level.block.QaAutoConfigBlock',
	          'iih.mr.qa.qa_divide_level.action.QaAutoConfigInitAction',
	          'iih.mr.qa.qa_divide_level.action.MrTypeSearchAction',
	          'iih.mr.qa.qa_divide_level.action.QaAutoConfigSaveAction',
	          'iih.mr.qa.qa_divide_level.action.QaItmTypeAction'
	          ],
	
	xapConfig:{         
		blocks: {
			'content':{
				xclass: 'iih.mr.qa.qa_divide_level.block.QaAutoConfigBlock'
			}
		},
		actions:{
            'init':{ 
                xclass:'iih.mr.qa.qa_divide_level.action.QaAutoConfigInitAction',
                url:'qaitm/autoconfig',
                blocks:{
                    content: 'content'
                }
            },
			'searchMrType':{
				xclass: 'iih.mr.qa.qa_divide_level.action.MrTypeSearchAction',
				url:'mrtypes',
				blocks: {
				    content: 'content'
				}
			},
			'saveQaRule':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaAutoConfigSaveAction',
				url:'qaautoitm/save',
				blocks: {
				    content: 'content'
				}
			},
			'qaItmTypeChain':{
				xclass: 'iih.mr.qa.qa_divide_level.action.QaItmTypeAction',
				blocks: {
				    content: 'content'
				}
			},
			/*'createRule':{
				xclass: 'iih.mr.qa.qa_divide_level.action.CreateRuleAction',
				blocks: {
				    content: 'content'
				}
			},*/
			'judgeDocOpType':{
				xclass: 'iih.mr.qa.qa_divide_level.action.JudgeDocOpTypeAction',
				blocks: {
				    content: 'content'
				}
			}
		},
		chains:{
			'init':['init'],
			'searchMrType':['searchMrType'],
			'saveQaRule':['saveQaRule'],
			'qaItmTypeChain':['qaItmTypeChain'],
//			'createRule':['createRule'],
			'judgeDocOpType':['judgeDocOpType']
		},
		connections:{
			'content':[{
                event:'afterrender',
                chain:'qaItmTypeChain'
            },/*{
                selector: 'xapcombobox[name=eventTypeCodeF]',
                event: 'change',
                chain: 'createRule'
			},*/{
                selector: 'xapcombobox[name=jobTitleCd]',
                event: 'change',
                chain: 'judgeDocOpType'
			},{
				selector: 'button[action=saveTime]',
				event: 'click',
				chain: 'saveQaRule'
			},{
				selector: 'button[action=saveFrequency]',
				event: 'click',
				chain: 'saveQaRule'
			},{
				selector: 'button[action=saveIntegrity]',
				event: 'click',
				chain: 'saveQaRule'
			},{
				selector: 'button[action=saveDependent]',
				event: 'click',
				chain: 'saveQaRule'
			}
			]
		}
	}
})