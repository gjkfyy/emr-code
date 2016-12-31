Ext.define('iih.mr.qa.qa_work_assistant.view.DiagnosisHelperView', {
	extend : 'Xap.ej.template.BaseTemplate',
	
	alias:'widget.diagnosishelperview',

	requires:[
		'iih.po.assistant.block.DiagnosisHelperBlock',
		'iih.po.assistant.action.DiagnosisHelperInitAction'
	],
	
	layout:'fit',

	xapConfig: {
		blocks: {
			'list': {
				xclass: 'iih.mr.qa.qa_work_assistant.block.DiagnosisHelperBlock'
			}
		},
		actions: {
			'refresh': {
				xclass: 'iih.po.assistant.action.DiagnosisHelperInitAction',
				url: 'diagnosises',
				blocks: {
					result: 'list'
				}
			}
		},

		chains: {
			'refresh': ['refresh']
		},

		connections: {
			'list': [/*{
				event: 'afterrender',
				chain: 'refresh'
			}*/]
		}
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("changeEncounter");//为视图添加刷新事件
        this.addListener('changeEncounter', function(enPk){//添加监听事件
            var chainTree = this.getActionChain('refresh');
	        if(chainTree) {
	            chainTree.execute({
	            	enPk:enPk
	            });
	        }
        });
        this.addEvents("writeMrDoc");// 为视图添加事件
		this.addListener('writeMrDoc', function() {// 添加监听事件
			// 写回病历
			var hisDocPlugin = document.getElementById('iemrEditor');
			var block = this.down('diagnosishelperblock');
			if( hisDocPlugin != null &&  block != null){
			  if(!hisDocPlugin.IsReadOnly()){
				  var grid = block.down('xapgrid');
			      var selModel = grid.getSelectionModel();
			      var tmp ="";
			      var  isNotSelectedFirstRecord = false ;
			      for(var j =0 ; j< grid.store.data.length ;j++){

			    	  if(selModel.isSelected(j))
			    		  {
					    	  if(isNotSelectedFirstRecord){
					    		  tmp = tmp + "，";
					    	  }
					    	  tmp = tmp + grid.store.data.items[j].raw.longDiNm ;
					    	  isNotSelectedFirstRecord = true ;
			    		  }
		          }
			      //var rb = grid.getSelectionModel().getSelection(); 
			      hisDocPlugin.InsertText(tmp);
			    }else{
				   
			    }
		    }
		});
	}
})