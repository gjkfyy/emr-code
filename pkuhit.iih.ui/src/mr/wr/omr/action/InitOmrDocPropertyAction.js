Ext.define('iih.mr.wr.omr.action.InitOmrDocPropertyAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		 var block = this.getOwner().getBlock('content');
		var logicSmtDate=block.down('[name=logicSmtDate]');
        logicSmtDate.setValue(new Date());
	    if(this.getOwner().ownerCt.ownerCt==undefined){//从病历文书属性进来
	        if(undefined!=context.mrSn){
	            if(context.from=='editor'){//从编辑器打开属性
	                var block = this.getOwner().getBlock('content');
	                var close=block.down('button[name=close]');
	                close.setVisible(false);
	                var confim=block.down('button[name=confim]');
	                confim.setVisible(false);
	                var higherLvlEmpId=block.down('[name=higherLvlEmpId]');
	                higherLvlEmpId.setReadOnly(true);
	                var mrNm=block.down('[name=mrNm]');
	                mrNm.setReadOnly(true);
	            }else{//从病历文书列表打开属性
	                this.setReadonly();
	            }
	            this.getOwner().mrPk=context.mrSn;
	            this.initMrDocProperty(context.operations,context.mrSn);
	        }
	    }else{//从新建病历文书进来
	        this.initHigherLvlEmpId(context.operations);
	    }
    },
    initHigherLvlEmpId: function(operations) {
        var url = this.url+'?deptCd='+IMER_GLOBAL.department.code;
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	
        var block = this.getOwner().getBlock('content');
        var higherLvlEmpId=block.down('[name=higherLvlEmpId]');
        if(operation.result.data&&operation.result.data.supDoctors){
            higherLvlEmpId.setData(operation.result.data.supDoctors);
        }
    },
    initMrDocProperty: function(operations,mrSn) {
        var url = 'mr/'+mrSn+'?withFile=false';
        var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSearchSuccess
        };
        operations.push(operation);
    },
    onSearchSuccess: function(operation) {
        var block = this.getOwner().getBlock('content');
        var logicSmtDate=block.down('[name=logicSmtDate]');
        logicSmtDate.setValue(operation.result.data.bizTime);
        var mrNm=block.down('[name=mrNm]');
        mrNm.setValue(operation.result.data.name);
        var higherLvlEmpId=block.down('[name=higherLvlEmpId]');
        var jobTitleCd=block.down('[name=jobTitleCd]');
        var typeCode = operation.result.data.typeCode;
        if("MRM16.19"==typeCode||"MRM16.20"==typeCode){
            higherLvlEmpId.setValue(operation.result.data.higherLvlEmpId);
            jobTitleCd.setValue(operation.result.data.jobTitleCd);
        }/*else{
            higherLvlEmpId.setVisible(false);
            jobTitleCd.setVisible(false);
        }*/
    },
    setReadonly: function() {
        var block = this.getOwner().getBlock('content');
        var higherLvlEmpId=block.down('[name=higherLvlEmpId]');
        higherLvlEmpId.setReadOnly(true);
        var mrNm=block.down('[name=mrNm]');
        mrNm.setReadOnly(true);
        var logicSmtDate=block.down('[name=logicSmtDate]');
        logicSmtDate.setReadOnly(true);
        var cancel=block.down('button[name=cancel]');
        cancel.setVisible(false);
        var confim=block.down('button[name=confim]');
        confim.setVisible(false);
        var confimUpPro=block.down('button[name=confimUpPro]');
        confimUpPro.setVisible(false);
    }
});
