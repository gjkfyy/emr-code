/**
 *   功能名称：智能助手-医嘱
 *   author：liulei
 */
Ext.define('iih.mr.qa.qa_work_assistant.view.OrderListView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.po.assistant.action.OrderListInitAction',
	           'iih.po.assistant.action.OrderCheckchangeAction'
	           ],

	alias:'widget.orderlistview',
	
	layout:'fit',

	xapConfig: {
		blocks: {
		    'orderlist': {
		    	xclass: 'iih.mr.qa.qa_work_assistant.block.OrderListBlock'
            }
		},
		actions: {
			'init': {
				xclass: 'iih.po.assistant.action.OrderListInitAction',
				url:'orders',
				blocks:{
					orderlist: 'orderlist'
				}
			},
			'checkChange': {
				xclass: 'iih.po.assistant.action.OrderCheckchangeAction',
//				url:'orders',
				blocks:{
					orderlist: 'orderlist'
				}
			},
			'refreshOutpatientDisposal': {
				xclass: 'iih.po.assistant.action.RefreshOutpatientDisposalAction',
				url:'mr/tpl/outdisposal',
				blocks:{
					orderlist: 'orderlist'
				}
			},
			'refreshInpOrder': {
				xclass: 'iih.po.assistant.action.RefreshInpOrderAction',
				url:'param',
				blocks:{
					orderlist: 'orderlist'
				}
			}
		},

		chains: {
			'init':['init'],
			'refreshOutpatientDisposal':['refreshOutpatientDisposal'],
			'refreshInpOrder':['refreshInpOrder'],
			'checkChange':['checkChange']
		},

		connections: {
			'orderlist': [{
                selector: 'xapcheckboxgroup[name=longterm]',
                event: 'change',
                chain: 'checkChange'
            },{
                selector: 'xapcheckboxgroup[name=temporary]',
                event: 'change',
                chain: 'checkChange'
            }]
		}
	},	
	
	initComponent : function() {

		this.callParent();
		var me = this;
		 this.addEvents("writeMrDoc");//为视图添加事件
		 this.addListener('writeMrDoc', function() {//添加监听事件
		        //写回病历
			 var hisDocPlugin=document.getElementById('iemrEditor');
			 var block = this.getBlock('orderlist');
			  if( hisDocPlugin != null &&  block != null){
				  if(!hisDocPlugin.IsReadOnly()){
					  if('XAPM06.08'==IMER_GLOBAL.portal.code||'XAPM06.01'==IMER_GLOBAL.portal.code){
						  //门诊书写时医嘱需要特殊处理
						  var refreshOutpatientDisposal = this.getActionChain('refreshOutpatientDisposal');
						  refreshOutpatientDisposal.execute();
					  }else{
						  //住院书写时医嘱需要特殊处理
						  var refreshInpOrder = this.getActionChain('refreshInpOrder');
						  refreshInpOrder.execute();
						  /*
						  var grid = block.down('xapgrid');
					         var selModel = grid.getSelectionModel();
					         var records = selModel.getSelection();
					         console.log('---------------------------');
					         console.log(records);
							 var tmp ="";
				             for(var j=0; j<records.length;j++){
				            	   //tmp = tmp + records[j].get('longOrNm');
				            	   //tmp = tmp + records[j].get('groupFlag');
				            	   //tmp = tmp + records[j].get('orTpNm');
				            	    if(j>0){
				            	    	tmp = tmp +'，'
				            	    }
				            	   tmp = tmp+' ' + records[j].get('svNm');
				            	   tmp = tmp+' ' + records[j].get('dosage');
				            	   tmp = tmp +' '+ records[j].get('freqNm');
				            }
							 //var rb = grid.getSelectionModel().getSelection(); 
				             hisDocPlugin.InsertText(tmp);
				             */
					  }
				  }else{
					   //只读状态不响应
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