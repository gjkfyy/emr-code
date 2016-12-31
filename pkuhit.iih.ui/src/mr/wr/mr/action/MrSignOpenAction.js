Ext.define('iih.mr.wr.mr.action.MrSignOpenAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
	execute: function(context) {
		var mrPk = '';
		var name = '';
		var statusCode = '';
		var encounterPk = '';
		var patientId = '';
		var arguments = context.event.arguments;
		if(context.event.name=="itemdblclick"){
			mrPk = arguments[1].raw.mrPk;
	        name = arguments[1].raw.name;
	        statusCode = arguments[1].raw.statusCode;
	        encounterPk = arguments[1].raw.encounterPk;
	        patientId = arguments[1].raw.patientId;
		}else{
			mrPk = arguments[0].mrPk;
	        name = arguments[0].name;
	        statusCode = arguments[0].statusCode;
	        encounterPk = arguments[0].encounterPk;
	        patientId = arguments[0].patientId;
		}
        
        //需要进行赋值,吴国成修改
        IMER_GLOBAL.encounterSn = encounterPk;
        IMER_GLOBAL.patientId = patientId;
        
        //当文书状态为已提交(MRM04.02),已二级审签时(MRM04.04)
        /*var workpageview = this.getOwner().ownerCt.items.items[1];
        if(workpageview){
        	var mrSn = workpageview.blocks.workContent.items.items[0].mrSn;
        	if(mrSn!=mrPk){
        		workpageview.ownerCt.remove(workpageview);//blocks.workContent.items.items[0].ownerCt.remove(workpageview.blocks.workContent.items.items[0]);
        	}
        }*/
        /*if(statusCode=='MRM04.02'||statusCode=='MRM04.04'){
        	var owner = this.getOwner();   
			//储存画面间参数
		    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        properties.setData({
	        	mrPk:mrPk,
	        	name:name 
	        });
	        this.prepareOperations(context.operations,mrPk);
        }else{*/
        //console.info(this.getOwner());
        	if(undefined!=mrPk){
	        	var canvas = Xap.getCanvas();
		        var config = {
	                pageCode: 'mrdoceditview',
	                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
	                pageTitle: name,
	                viewConfig:{
	                    mrSn:mrPk,
	                    opType:'open',
	                    nursePortal:this.getOwner().nursePortal
	                },
	                assistantConfig:{
	                    tgtObCd: 'MRB02',
	                    tgtObPk: mrPk
	                }
		        };       
		        canvas.fireEvent("addWorkPage",config);
	        }
        /*}*/
    },
     prepareOperations: function(operations,mrPk) {
         var url = this.url+'/'+mrPk;
         var operation = {
             url: url,
             method: 'post',
             scope: this,
             success: this.onSuccess
         };
         operations.push(operation);
     },
     onSuccess: function(operation) {
     	var owner=this.getOwner();	
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		//树节点选择病历分类编号
		var mrPk = properties.data.mrPk;
		var name = properties.data.name;
		if(undefined!=mrPk){
        	var canvas = Xap.getCanvas();
	        var config = {
                pageCode: 'mrdoceditview',
                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                pageTitle: name,
                viewConfig:{
                    mrSn:mrPk,
                    opType:'open'
                },
                assistantConfig:{
                    tgtObCd: 'MRB02',
                    tgtObPk: mrPk
                }
	        };       
	        canvas.fireEvent("addWorkPage",config);
        }
     }
});
