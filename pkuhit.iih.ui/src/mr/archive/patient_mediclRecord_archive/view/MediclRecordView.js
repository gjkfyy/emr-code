Ext.define('iih.mr.archive.patient_mediclRecord_archive.view.MediclRecordView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.mediclrecordview',
	
	id:'mediclrecordviewid',
	
	requires:[
	   	'Xap.ej.element.grid.column.Date',
	    'Xap.ej.element.field.Checkbox',
	    'Xap.ej.element.button.Button',
		'Xap.ej.element.form.Form',
		'Xap.ej.element.field.DateField', 
		'iih.mr.archive.patient_mediclRecord_archive.block.MediclRecordListBlock',
		'iih.mr.archive.patient_mediclRecord_archive.block.MediclRecordListGridBlock',
		'Xap.ej.element.grid.column.ActionColumn',
		'iih.mr.archive.patient_mediclRecord_archive.action.MediclRecordArchiveFileAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.archive.patient_mediclRecord_archive.block.MediclRecordListBlock',
				height:56
			},
			
			'content':{
				xclass: 'iih.mr.archive.patient_mediclRecord_archive.block.MediclRecordListGridBlock',
				flex:1
			}
		},
		actions: {
			'search': {
				xclass: 'iih.mr.archive.patient_mediclRecord_archive.action.MediclRecordSearchAction',
				url:'mr/search/mrs',
				blocks: {
					content: 'content'
				}
			},
			'mediclRecordarchivefile':{
				xclass:'iih.mr.archive.patient_mediclRecord_archive.action.MediclRecordArchiveFileAction',
				url:'mr/archive/mrArchive',
				blocks: {
					content: 'content'
				}
			},
			'mediclRecordArchiveBtnSta':{
				xclass:'iih.mr.archive.patient_mediclRecord_archive.action.MediclRecordArchiveBtnStaAction',
				blocks: {
					content: 'content'
				}
			},
			'mrconfirmArchive':{
				xclass:'iih.mr.archive.patient_mediclRecord_archive.action.MrConfirmArchiveAction',
				blocks: {
					content: 'content'
				}
			}
		},

		chains: {
			'search': ['search'],
			'mediclRecordarchivefile':['mediclRecordarchivefile'],
			'mediclRecordArchiveBtnSta':['mediclRecordArchiveBtnSta'],
			'mrconfirmArchive':['mrconfirmArchive']
		},

		connections: {
			'content': [
			{//翻页操作
				selector: 'xapgrid',
				event: 'turnpage',
				chain: 'search'
			},{
				selector : 'xapgrid[name=mediclGrid]',
				event : 'selectionchange',
				chain : 'mediclRecordArchiveBtnSta'
			}]
		}
	},
	initComponent : function() {
			this.callParent();
			//this.addEvents("pageRefresh");//为视图添加刷新事
//			this.addListener('pageRefresh', function(){//添加监听事件
//				 var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
//		        var chain = this.getActionChain('search');
//		        var block = this.getBlock('content');
////		        var pageSize = block.pageSize;
//		        if(properties.data == undefined){
//		        	 if(chain) {
//		            chain.execute({});
//		        	}
//		        }else{
//		        	var pageSize = properties.data.pageSize;
//			        var pageNum = properties.data.pageNum;
//			        if(chain) {
//			            chain.execute({
//			            	pageSize:pageSize,
//			            	pageNum:pageNum
//			            });
//			        }
//		        }
//			});
			this.addListener('destroy', function(){
				var patientandmediclrecordview=Ext.getCmp('patientandmediclrecordview');
				var search= patientandmediclrecordview.getActionChain("search");
				search.execute();
			});
		}
})