Ext.define('iih.mr.qa.order_qa_patient.action.ConfirmOpenAction', {
    extend: 'Xap.ej.action.Action',

    /*
     * @Override
     */
    execute: function(context) {
    	var me = this;
    	
		var owner = this.getOwner();   
		
		var typeFlag = owner.typeFlag;
		
		var topBlock = this.getBlock('result');
	        
	    var enGrid = topBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];
	    
	    var pk = record.data.pk;
	    var patientName = record.data.patientName;
	    var curPatientName = iih.mr.qa.QaStatusGlobal.patient.name;
	     
		var eventName = context.event.name;
	    var topview = owner.up('portalblock').down('topview');//
		var eventNm = topview.eventNm;
		var encounterSn = IMER_GLOBAL.encounterSn;
		var processQaDefectsView;
		var processQaWorkView;
		var items = owner.up().items.items;
		for(var i=0;i<items.length;i++){
			var tabId = items[i].tabId;
			if('processQaDefectsView' == tabId){
				processQaDefectsView = items[i];
			}else if('processQaWorkView' == tabId){
				processQaWorkView = items[i];
			}
		}
		
		if(eventName == 'linkClick'){
			var faultTotal = record.data.faultTotal;
		    if(faultTotal == '' || faultTotal == null){
		    	return;
		    }
		}
	    
		if(eventNm != undefined && eventName != eventNm && encounterSn !=pk && encounterSn !=null){
			
			XapMessageBox.confirm2('当前正在质控【'+curPatientName+'】患者，是否切换至【'+patientName+'】患者？', function(id){
				if(id=='yes'){
					var owner = me.getOwner();
					topview.eventNm = eventName;
				        var chain = owner.getActionChain('defects');
				        if(chain) {
				            chain.execute({
				            	record:record,
				            	event:context.event
				            });
				        }
				        var chain = owner.getActionChain('inProcess');
				        if(chain) {
				            chain.execute({
				            	record:record,
				            	event:context.event,
				            	typeFlag:typeFlag
				            });
				        }
				}
			});
			
		}else{
			if(eventName == 'linkClick' ){
				var owner = me.getOwner();
				topview.eventNm = eventName;
				if(processQaWorkView){
					var chain = owner.getActionChain('inProcess');
				        if(chain) {
				            chain.execute({
				            	record:record,
				            	event:context.event,
				            	typeFlag:typeFlag
				            });
				        }
					}
			        var chain = owner.getActionChain('defects');
			        if(chain) {
			            chain.execute({
			            	record:record,
			            	event:context.event
			            });
			        }
			}else if(eventName == 'itemdblclick'){
				var owner = me.getOwner();
				topview.eventNm = eventName;
				if(processQaDefectsView){
					var chain = owner.getActionChain('defects');
			        if(chain) {
			            chain.execute({
			            	record:record,
			            	event:context.event
			            });
			        }
				}
			        var chain = owner.getActionChain('inOrder');
			        if(chain) {
			            chain.execute({
			            	record:record,
			            	event:context.event,
			            	typeFlag:typeFlag
			            });
			        }
			}
		}
	    
    }
});
