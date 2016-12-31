
/** 
 * 自动缺陷列表
 * @author ：yao_lijie
 */
 
Ext.define('iih.mr.qa.process_qa_auto_search.view.QaAutoDefectView',{
	extend: 'Xap.ej.template.BaseTemplate',
	requires: [
	           'Xap.ej.element.grid.Grid', 
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.label.Label',
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.qa.QaStatusGlobal',
	           'Xap.ej.block.GridBlock',
	           'iih.mr.qa.score.block.ScoreFormBlock',
			   'iih.mr.qa.score.action.ScoreItemListSearchAction',
			   'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction'
	],

	alias:'widget.qaautodefectview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.qa.score.block.ScoreFormBlock',
                height: 60
            },
			'bottom': {
				xclass: 'iih.mr.qa.process_qa_auto_search.block.QaAutoDefectListBlock'
			}
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.score.action.ScoreItemListSearchAction',
				url: 'qacustom/dropScoreItems',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			},
			'qaScoreSearch': {
				xclass: 'iih.mr.qa.score.action.QaScoreSearchAction',
				url: 'qacustom/amrScore',
				blocks: {
					condition: 'properties',
					result: 'top'
				}
			}
		},

		chains: {
			'init':['init'],
			'qaScoreSearch':['qaScoreSearch']
		},

		connections: {
			'bottom':[{
				event: 'afterrender',
				chain: 'init'
			}]
		}
	}
})