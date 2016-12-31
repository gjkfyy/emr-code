/**
 * 功能名称：智能助手-检验报告 author：liulei
 */
Ext.define('iih.po.assistant.view.LabReportView', {
	extend : 'Xap.ej.stl.view.BorderTemplate',

	requires : [],

	alias : 'widget.labreportview',

	xapConfig : {
		blocks : {
			'west' : {
				xclass : 'iih.po.assistant.block.LabReportLeftListBlock',
				header : false,
				width : 320
			},
			'center' : {
				xclass : 'iih.po.assistant.block.LabReportRightListBlock',
				flex : 1
			}
		},
		actions : {
			'west' : {
				xclass : 'iih.po.assistant.action.LabReportLeftListAction',
				url : 'lab/rep/reports',
				blocks : {
					west : 'west'
				}
			},
			'center' : {
				xclass : 'iih.po.assistant.action.LabReportRightListAction',
				url : 'lab/rep/report/items',
				blocks : {
					center : 'center',
					west : 'west'
				}
			}
		},

		chains : {
			'west' : [ 'west' ],
			'center' : [ 'center' ]
		},

		connections : {
			'west' : [/*{// 加载数据
				event : 'afterrender',
				chain : 'west'
			},*/ {// 加载数据
				selector : 'xapgrid[name=labReportLeftList]',
				event : 'cellclick',
				chain : 'center'
			} ]
		}
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("writeMrDoc");// 为视图添加事件
		this.addListener('writeMrDoc', function() {// 添加监听事件
			// 写回病历
			var hisDocPlugin = document.getElementById('iemrEditor');
			var block = this.down('labreportrightlistblock');
			var grid = block.down('xapgrid');
			var selModel = grid.getSelectionModel();
			var records = selModel.getSelection();
			
			var tmp = "",item;
			for ( var j = 0; j < records.length; j++) {
				tmp = tmp + records[j].get('labItmNm')+"  ";
				tmp = tmp + records[j].get('labItmVal');
				item = records[j].get('labItmCompare');
				tmp = tmp + records[j].get('labItmUnitNm');
				/*if(!Ext.isEmpty(item,false)){
					if(item!='-'){
						if(item.indexOf('↓')!=-1){
							tmp = tmp + ' ↓';
						}else if(item.indexOf('↑')!=-1){
							tmp = tmp + ' ↑';
						}
						
					}
				}*/
				if(j<(records.length-1)){
					tmp = tmp + " ，";
				};
			}
			if (!Ext.isEmpty(tmp, false)) {
				hisDocPlugin.InsertText(tmp);
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