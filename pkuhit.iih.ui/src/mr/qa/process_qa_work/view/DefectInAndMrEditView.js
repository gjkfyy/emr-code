/** 
 * 集成编辑器和缺陷一览视图
 * @extends Xap.ej.stl.view.TopBottomContainerTemplate
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.view.DefectInAndMrEditView',{
    extend: 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.defectinAndmreditview', 
	   
	requires:[
	          'iih.mr.qa.process_qa_work.block.DefectsInBlock',
	          'iih.mr.qa.process_qa_work.block.QaMrEditBlock',
	          'iih.mr.qa.process_qa_work.action.DefectInViewreadyAction',
	          'iih.mr.qa.process_qa_work.action.PopupFaultInputViewAction',
	          'iih.mr.qa.process_qa_work.action.PopupDefectNoticeInferViewAction',
	          'iih.mr.qa.process_qa_work.action.DefectInDeleteAction',
	          'iih.mr.qa.process_qa_work.action.DefectInSaveAction',
	          'iih.mr.qa.process_qa_work.action.DefectInSearchAction',
	          'iih.mr.qa.process_qa_work.action.DefectsInItemClickAction'
	          ],
	          
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig:{
		blocks: {
			'top':{
				xclass: 'iih.mr.qa.process_qa_work.block.QaMrEditBlock',
				flex:1
			},
			'bottom':{
				xclass: 'iih.mr.qa.process_qa_work.block.DefectsInBlock',
				height:180
			}
		},
		actions:{
			
			'defectsInViewreadyAction': {
				xclass: 'iih.mr.qa.process_qa_work.action.DefectInViewreadyAction',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'popupFaultInputViewAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.PopupFaultInputViewAction',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'popupDefectNoticeInferViewAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.PopupDefectNoticeInferViewAction',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'editDefectAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.PopupEditDefectAction',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'deleteDefectsAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.DefectInDeleteAction',
				url:'qacustom/fault',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'saveDefectsAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.DefectInSaveAction',
				url:'/di/sens',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'searchDefectsAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.DefectInSearchAction',
				//url:'dm-mr/qa/faults',
				url:'qacustom/faults',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			},
			'itemClickAction':{
				xclass: 'iih.mr.qa.process_qa_work.action.DefectsInItemClickAction',
				blocks: {
					bottomcontent: 'bottom',
					topcontent:'top'	
				}
			}
		},
		chains:{
			
			'defectsInViewreadyAction':['defectsInViewreadyAction'],
			'popupFaultInputViewAction':['popupFaultInputViewAction'],
			'popupDefectNoticeInferViewAction':['popupDefectNoticeInferViewAction'],
			'editDefectAction':['editDefectAction'],
			'deleteDefectsAction':['deleteDefectsAction'],
			'saveDefectsAction':['saveDefectsAction'],
			'searchDefectsAction':['searchDefectsAction'],
			'itemClickAction':['itemClickAction']
		},
		connections:{
			
			'bottom':[{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'defectsInViewreadyAction'
			},{
				selector : 'xapgrid',
				event: 'itemclick',
				chain: 'itemClickAction'
			},{
                selector: 'xapgrid',
                event: 'linkClick',
                chain: 'itemClickAction'
            }
			]
		}
	}
})