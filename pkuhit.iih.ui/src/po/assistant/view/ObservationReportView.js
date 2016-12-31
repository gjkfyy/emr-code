/**
 * 功能名称：智能助手-检查报告 author：liulei
 */
Ext.define('iih.po.assistant.view.ObservationReportView', {
	extend : 'Xap.ej.stl.view.BorderTemplate',

	requires : [ 
	             'iih.po.assistant.action.ObservationLeftListAction',
	             'iih.po.assistant.action.ObservationRightAction',
//	             'iih.po.assistant.action.ObservationRightHandleTextAction'
	             ],

	alias : 'widget.observationreportview',

	xapConfig : {
		blocks : {
			'west' : {
				xclass : 'iih.po.assistant.block.ObservationLeftListBlock',
				header : false,
				width : 320
			},
			'center' : {
				xclass : 'iih.po.assistant.block.ObservationRightBlock',
				flex : 1
			}
		},
		actions : {
			'west' : {
				xclass : 'iih.po.assistant.action.ObservationLeftListAction',
				url : 'obs/reports',
				blocks : {
					west : 'west'
				}
			},
			'center' : {
				xclass : 'iih.po.assistant.action.ObservationRightAction',
				blocks : {
					center : 'center',
					west : 'west'
				}
			}/*,
			'handleText' : {
				xclass : 'iih.po.assistant.action.ObservationRightHandleTextAction',
				blocks : {
					center : 'center'
				}
			}*/
		},

		chains : {
			'west' : [ 'west' ],
			'center' : [ 'center' ]/*,
			'handleText' : [ 'handleText' ]*/
		},

		connections : {
			'west' : [ /*{// 加载数据
				event : 'afterrender',
				chain : 'west'
			},*/ {// 加载数据
				selector : 'xapgrid[name=observationLeftList]',
				event : 'cellclick',
				chain : 'center'
			} ]/*,
			'center' : [ {// 加载数据
				selector : 'xaptextarea',
				event : 'focus',
				chain : 'handleText'
			}]*/
		}
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("writeMrDoc");// 为视图添加事件
		this.addListener('writeMrDoc', function() {// 添加监听事件
			// 写回病历
			var hisDocPlugin = document.getElementById('iemrEditor');
			var block = this.down('observationrightblock');
			var textArea = block.selectedCmp;
			var tmp;
			if(textArea!=undefined && !Ext.isEmpty(textArea, false)){
				tmp = textArea.value;
				if(!Ext.isEmpty(tmp, false)){
					hisDocPlugin.InsertText(tmp);
				}
			}else{
				var message = '请先选记录再进行写回！';
	            XapMessageBox.info(message);
			}
		});
		//增加就诊切换的查询
		this.addEvents("changeEncounter");//为视图添加刷新事件
        this.addListener('changeEncounter', function(enPk){//添加监听事件
            //查询action
        	var chain = this.getActionChain('west');
        	chain.execute({
        		'enPk':enPk
        	});
        });
	}

})