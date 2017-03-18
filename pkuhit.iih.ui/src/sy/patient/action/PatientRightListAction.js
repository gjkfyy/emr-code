Ext.define('iih.sy.patient.action.PatientRightListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
        var block = this.getBlock('condition');// 当前页面patientLeftListView
        var operations = context.operations;
         var block2 = this.getBlock('result');// 当前页面patientLeftListView
         var grid2=block2.down('xapgrid');
      // 当前页面patientLeftListView
         var grid=block.down('xapgrid');
		//var omrDocEditPage=this.getOwner().getBlock('right');
		var select = grid.getSelectionModel().getSelection();
		var id = select[0].data.patientId;
		 var mrSn='3A28274DC68445F5A16EF8B4FD38B518';
		var data = [{'employeeId':'123',
        'name':'name'
		
		},{'employeeId':'123',
        'name':'name'
		
		}];
		var rec = data;
		//block3.setData(rec);
		console.log('开始--'+rec.toString());
		//var workArea = Ext.getCmp('workareapageview');
	   // var callBack = function(patient){
	   //     var canvas = Xap.getCanvas();
	    //    canvas.fireEvent("updatePatient",{patient:patient});
	  //  };
	   // workArea.callBack = {
	  //      method: callBack,
	   //     params: [rec]
	   // };
	   // var canvas = Xap.getCanvas();
	   // canvas.fireEvent("portalRender2");
	   // var rihgtView = this.getOwner().getBlock('right');// 当前页面patientLeftListView
	
	    //var rightblock = rihgtView.getBlock('content')
	    //rihgtblock.down('xapgrid').setData(rec);
       
    	var url = this.url;
    	url = 'omr/'+mrSn+'?withFile=false';
    	var operation = {
            url: url,
    	    method: 'GET',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation,id);
    },
    onSuccess: function(operation,id) {
    	//operation.
       var block3 = this.getBlock('result').getBlock('content');
    	block3.setData(operation.result);
    	/*
        var block = this.getBlock('result');// 当前页面是UserInfoLeftListView
        block = block.getBlock('content'); 
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        } else {
        	//block.setData(m.data);
        	alert(id);
        	var data = {'patientId':'123',
        				'pk':id,
        				'amrNo':'12',
        				'patientName':'3',
        				'sexName':'3',
        				'age':'3',
        				'receiveTime':'3',
        				'encounterCount':'3',
        				'paInsurNm':'3',
        				'currentMainDiagnosisName':'3'
        				}
        	var rec = data;
			var workArea = Ext.getCmp('workareapageview');
            var callBack = function(patient){
                var canvas = Xap.getCanvas();
                canvas.fireEvent("updatePatient",{patient:patient});
            };
            workArea.callBack = {
                method: callBack,
                params: [rec]
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("portalRender2");
            
        }
    */}
});
