Ext.define('iih.po.assistant.action.MrDocHelperTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
		var owner = this.getOwner();
		var printBtn = owner.getBlock('left').down('button[method=print]');
		if(undefined!=owner.tab && owner.tabId == 'mr_doc_helper'){
			printBtn.show();
		}else{
			printBtn.hide();
		}
		this.getOwner().getBlock('right').mrTpCcatCd=null;
	    this.showLoading();
        var operations = context.operations;  
        var printable=this.getOwner().printable;
        if(printable){
        	var encounterSelectCombox=Ext.getCmp('encounterSelectCombox');
        	var ens=encounterSelectCombox.getData();
        	var ens2=new Array();
        	for(i in ens){
        		if(ens[i].text.indexOf('住院')>0){
        			
        		}else{
        			ens2.push(ens[i]);
        		}
        	}
        	encounterSelectCombox.setData(ens2);
//        	encounterSelectCombox.setValue(ens2[0].value);
        }
        var enPk = context.enPk;
        var printable = context.printable;
        this.getOwner().printable=printable;
        if(enPk==undefined){
        	enPk = IMER_GLOBAL.encounterSn;
        }
        var url = ""; 
        if(this.getOwner().printerPortal){
        	url = this.url+"?encounterPk="+enPk+'&showAllCourse=1&mrType=MRM04.01'; 
        }else{
        	url = this.url+"?encounterPk="+enPk+'&showAllCourse=1'; 
        }
//        alert(url);
//        console.log(url+'============');
        var mclass = null;        
        var operation = {
            url: url,
            mclass: mclass,
            method: 'get',
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);  
    }, 

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var right = this.getOwner().getBlock('right');
        var objView=right.down("objectview");
			if(objView){
				right.remove(objView);
			}
        var m = operation;
        if(m.result.data.children){
        	block.setData(m.result.data.children);
        }else{
        	block.setData([]);
        	right.mrSn='';
        	if(this.getOwner().managementPortal){
        		Ext.Msg.alert('提示','本次就诊无病历！');
        		this.getOwner().ownerCt.close();
        	}
        }
        
    }  
});