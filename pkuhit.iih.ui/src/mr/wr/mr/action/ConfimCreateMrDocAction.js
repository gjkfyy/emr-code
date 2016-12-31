Ext.define('iih.mr.wr.mr.action.ConfimCreateMrDocAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   var grid = this.getBlock('content').ownerCt.ownerCt.getBlock('top').down('xapgrid');
       var rb = grid.getSelectionModel().getSelection(); 
       //病历文书类型
       var typeCode = rb[0].data.mrTypeCode;
       //就诊号
	   var encounterSn = IMER_GLOBAL.encounterSn;
	   var data = {'typeCode':typeCode,'encounterPk':encounterSn};
	   this.prepareOperations(context.operations,data);
	},
    prepareOperations: function(operations,data) {
        var url = 'canCreate';
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
       if(operation.result){
       	   var canCreate = operation.result.data.canCreate;
	       if(canCreate!=1){
	           Ext.Msg.alert('提示','首次病程记录已存在！');
	           return
	       }
       }
       var form= this.getBlock('content').getForm();
       var data =form.getValues();
       if(data==undefined){
           Ext.Msg.alert('提示','请填写必要属性！');
           return
       }
       if(data.mrNm==''){
           Ext.Msg.alert('提示','请填写病历文书名称！');
           return
       }
       if(data.logicSmtDate==''){
           Ext.Msg.alert('提示','请填写业务时间！');
           return
       }
       var grid = this.getBlock('content').ownerCt.ownerCt.getBlock('top').down('xapgrid');
       var rb = grid.getSelectionModel().getSelection(); 
       var typecode = rb[0].data.mrTypeCode;
       if(typecode=='MRM16.19'||typecode=='MRM16.20'){
    	  if(data.higherLvlEmpId==''){
  	         Ext.Msg.alert('提示','请选择上级查房医师！');
  	         return
  	      }
    	  var datakeys= this.getBlock('content').down("xapcombobox[name=higherLvlEmpId]").getStore().data.keys;
    	  //上级查房医师无效下拉框的所有数据value跟传入的对比一致通过
    	  var reg=false;
    	  for (var i = 0; i < datakeys.length; i++) {
			if(datakeys[i]==data.higherLvlEmpId){
				reg=true;
				break;
			}
    	  }
    	  if(reg==false){
   	         Ext.Msg.alert('提示','你选择的上级查房医师无效，请重新选择！');
   	         return
   	      }
       }
       if(rb.length == 0){
            Ext.Msg.alert('提示','请先选一个模板！');
        }else{
            var rbData=rb[0].data;
            if(data && rbData){
                for(var p in rbData){
                    data[p] = rbData[p];
                }
             }
            var higherLvlEmpId = this.getBlock('content').down('[name=higherLvlEmpId]');
            var superiorDoctorName='';
            if(higherLvlEmpId){
            	superiorDoctorName=higherLvlEmpId.rawValue.substring(0,higherLvlEmpId.rawValue.indexOf(' '));
            }
            var medicalRecord={filePk:data.filePk,
            		name:data.mrNm,
            		encounterPk:IMER_GLOBAL.encounterSn,
            		bizTime:data.logicSmtDate,
            		typeCode:data.mrTypeCode,
            		signLevelCode:data.signLevelCode,
            		superiorDoctorId:data.higherLvlEmpId,
            		superiorDoctorName:superiorDoctorName,
            		templeCode:data.code};
            
            var owner = this.getOwner();	
            var properties = owner.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
		    //得到文书编辑器tab
		    /*var workpageview = properties.data.workpageview;
            if(workpageview){
            	workpageview.ownerCt.remove(workpageview);
            }*/
            var canvas = Xap.getCanvas();            
            var config = {
                    xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                    pageTitle: data.mrNm,
                    pageCode:'mrdoceditview',
                    viewConfig:{
                        opType:'new',
                        medicalRecord:medicalRecord
                    },
                    assistantConfig:{
                        tgtObCd: 'MRB02',
                        tgtObPk: null
                    }
            };       
            canvas.fireEvent("addWorkPage",config);             
            this.getOwner().ownerCt.ownerCt.close();
        }
    }       
});
