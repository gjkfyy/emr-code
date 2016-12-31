Ext.define('iih.mr.di.view.OutDiagnosisView',{
    extend : 'Xap.ej.template.BaseTemplate',
	alias:'widget.outdiagnosisview',
	id:'outdiagnosisview',
	requires:[
	          'iih.mr.di.block.OutDiagnosisBlock',
	          'iih.mr.di.action.OutDiagnosisViewreadyAction',
	          'iih.mr.di.action.OutDiagnosisMoveAction',
	          'iih.mr.di.action.OutDiagnosisInitAction',
	          'iih.mr.di.action.OutDiagnosisSaveAction',
	          'iih.mr.di.action.OutDiagnosisDelAction',
	          'iih.mr.di.action.OutDiagnosisItemClickAction',
	          'iih.mr.di.action.OutDiagnosisParamAction'
	          ,'iih.mr.di.action.OutDiagnosisPageCloseAction'
	        
	          ],
	
	xapConfig:{
	
		blocks: {
			   'content':{
				   xclass: 'iih.mr.di.block.OutDiagnosisBlock'
			   }
		  },
		actions:{
            'outDiagnosisPageCloseAction': {
                xclass: 'iih.mr.di.action.OutDiagnosisPageCloseAction',
                url:'param',
                blocks: {
                    content: 'content'
                }
            },
            
			'outDiagnosisViewreadyAction': {
				xclass: 'iih.mr.di.action.OutDiagnosisViewreadyAction',
				blocks: {
					content: 'content'
				}
			},
			'outDiagnosisMoveAction':{
				xclass: 'iih.mr.di.action.OutDiagnosisMoveAction',
				blocks: {
					content: 'content'
				}
			},
			'outDiagnosisInitAction':{
				xclass: 'iih.mr.di.action.OutDiagnosisInitAction',
				//url:'xxx',
				blocks: {
					content: 'content'
				}
			},
			'outDiagnosisSaveAction':{
				xclass: 'iih.mr.di.action.OutDiagnosisSaveAction',
				url:'/di/ens',
				blocks: {
					content: 'content'
				}
			},
			'outDiagnosisDelAction':{
				xclass: 'iih.mr.di.action.OutDiagnosisDelAction',
				url:'/di/ens/del',
				blocks: {
					content: 'content'
				}
			},
			'outDiagnosisItemClickAction':{
				xclass: 'iih.mr.di.action.OutDiagnosisItemClickAction',
				blocks: {
					content: 'content'
				}
			},
			'outDiagnosisParamAction':{
				xclass: 'iih.mr.di.action.OutDiagnosisParamAction',
				url:'/param',
				blocks: {
					content: 'content'
				}
			}
		
			
		 },
		 chains:{
			 'outDiagnosisViewreadyAction': ['outDiagnosisViewreadyAction'],
			 'outDiagnosisMoveAction': ['outDiagnosisMoveAction'],
			 'outDiagnosisInitAction': ['outDiagnosisInitAction'],
			 'outDiagnosisSaveAction': ['outDiagnosisSaveAction'],
			 'doSave': ['outDiagnosisSaveAction'],
			 'outDiagnosisDelAction': ['outDiagnosisDelAction'],
			 'outDiagnosisItemClickAction': ['outDiagnosisItemClickAction'],
			 'outDiagnosisParamAction': ['outDiagnosisParamAction']
			, 'outDiagnosisPageCloseAction':[ 'outDiagnosisPageCloseAction']
			
		 },
		 connections:{
			 'content':[{
				 selector: 'treepanel',
				 event: 'viewready',
				 chain: 'outDiagnosisViewreadyAction'
			 },{
				 selector: 'treepanel',
				 event: 'itemclick',
				 chain: 'outDiagnosisItemClickAction'
			 }]
		 }
    },
  hasEdit: function() {
        var treepanel = this.down('diagnosisfiltertree');
        var flag = false;
        var modifiedRecords = treepanel.getStore().getModifiedRecords();
        Ext.each(modifiedRecords,function(rec){
              if(rec.isModified('diNm')){
                  flag = rec.isModified('diNm');
              }
        });
        return flag;
    },
    //datas为数组
    csaInsertDiagnosis:function(datas){
    	 var tree = this.down('diagnosisfiltertree');
    	 var rootNode = tree.getRootNode();
  	     var selModel=tree.getSelectionModel();
  	     var index = rootNode.childNodes.length - 1;
	  	 for(var i=0;i<datas.length;i++){
			   rootNode.insertChild(index,datas[i]);
			   index++;
			}
	  	 
	  	var diagnosisParamchain = this.getActionChain("outDiagnosisParamAction");
	  	diagnosisParamchain.execute(); 

	  	this.data = datas;
    },
    initComponent:function(){
    	 this.callParent();
         var me = this;
         this.addEvents('outDiagnosisEvent');//添加切换TAB页切换保存的事件
         this.addListener('outDiagnosisEvent',function(){
        	 var diagnosisSavechain = this.getActionChain("outDiagnosisSaveAction");
  		     diagnosisSavechain.execute();
         });
         
         /*var canvas = Xap.getCanvas();
         this.relayEvents(canvas, ['updatePatient']);
         this.addListener('updatePatient', function(config) {
        	 var diagnosischain = this.getActionChain('outDiagnosisInitAction');
  	         if(diagnosischain) {
  	        	 var diagnosisAction = diagnosischain.getActionByClass('iih.mr.di.action.OutDiagnosisInitAction');
  	             diagnosisAction.url = '/di/'+IMER_GLOBAL.encounterSn+'/dis?orgCode='+IMER_GLOBAL.hospitalArea.code;
  	             diagnosischain.execute();
  	         }
         });*/
         
         this.addEvents("pageRefresh");//为视图添加刷新事件
         this.addListener('pageRefresh', function(){
        	 //添加监听事件
        	 console.log('OutDiagnosisView.pageRefresh is empty method');
        
        });
         this.addEvents("selectEncounter");//为视图添加刷新事件
         this.addListener('selectEncounter', function(){
        	 //添加监听事件
        	 console.log('OutDiagnosisView.selectEncounter is running');
         	var diagnosischain = this.getActionChain('outDiagnosisInitAction');
 	        if(diagnosischain) {
 	        	 var diagnosisAction = diagnosischain.getActionByClass('iih.mr.di.action.OutDiagnosisInitAction');
 	             diagnosisAction.url = '/di/'+IMER_GLOBAL.encounterSn+'/dis?orgCode='+IMER_GLOBAL.hospitalArea.code;
 	             diagnosischain.execute();
 	        }
        
        	 });
    }
})