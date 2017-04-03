Ext.define('iih.mr.wr.mr.action.MrDocEditAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	requires: ['iih.mr.block.editor.MrDocEditBlock'],
	/*
	* @Override
	*/
	execute: function(context) {
	    Ext.useShims=true;
	    var zKOnlineCd=Ext.getCmp('zKOnlineCd');
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	IMER_GLOBAL.editing=1;
    	var printable=this.getOwner().ownerCt.printable;
    	if(printable==undefined){
			printable=this.getOwner().printable;
		}else{
			this.getOwner().printable=printable;
		} 
    	var mrWriteView=this.getOwner().ownerCt;
    	if(mrWriteView.itemId=='mrdoceditview'){
    		this.getOwner().medicalRecord=mrWriteView.medicalRecord;
        	this.getOwner().mrSn=mrWriteView.mrSn;
        	this.getOwner().mrTpCcatCd=mrWriteView.mrTpCcatCd;
        	this.getOwner().opType=mrWriteView.opType;
    	}
    	var opType=this.getOwner().opType;
    	if(opType!=undefined){
            if(opType=='new'){//创建新病历
            	if(CONFIG_PARAM.FINGERPRINT_BUTTON_SHOW&&zKOnlineCd){
            		zKOnlineCd.show();
                }
            	var rs = this.getBlock('content');   
    			this.addEditorEvent(rs);
            	this.showProgress();//显示进度条
                var filePk=this.getOwner().medicalRecord.filePk;//得到模板文件pk
//                alert(filePk);
                this.addPrepareOperations(operations,filePk);
            }else if(opType=='open'){//打开已有病历
            	if(CONFIG_PARAM.FINGERPRINT_BUTTON_SHOW&&zKOnlineCd){
            		zKOnlineCd.show();
                }
            	var rs = this.getBlock('content');   
    			this.addEditorEvent(rs);
            	this.showProgress();//显示进度条
                var mrSn=this.getOwner().mrSn;//得到文书pk
                var a=new Date();
                console.log('%c'+a+':'+a.getMilliseconds()+'毫秒     开始调用后台服务获取【'+mrSn+'】的文件......','color: #86CC00; background-color: black; font-size: 20px; padding: 3px;');
                this.openPrepareOperations(operations, mrSn);
            }else if(opType=='readonly'){//只读浏览病历
            	if(printable!=undefined&&printable==true){
            		this.showProgress();//显示进度条
                	this.mrMode=4;
            	}else{
            		this.mrMode=3;
            	}
            	var mrTpCcatCd=this.getOwner().mrTpCcatCd;//得到医疗记录类型组pk
            	var mrSn=this.getOwner().mrSn;//得到文书pk
           	 	if(mrSn){
           	 		this.readPrepareOperations(operations, mrSn);
           	 	}else if(mrTpCcatCd){
           	 		if(printable!=undefined&&printable==true){
           	 		}else{
           	 			this.showProgress();//显示进度条
           	 		}
           	 		this.readPrepareOperations2(operations, mrTpCcatCd);
           	 	}     
            }
        }
    },
    openPrepareOperations: function(operations, mrSn) {
        var url = this.url+'/'+mrSn+'?withFile=true';
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onOpenSuccess
        };
        operations.push(operation);
    },
    readPrepareOperations: function(operations, mrSn) {
    	var url = 'mrfile/'+mrSn;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onReadSuccess
        };
        operations.push(operation);
    },
    readPrepareOperations2: function(operations, mrTpCcatCd) {
    	var encounterSn = IMER_GLOBAL.encounterSn;
    	if(this.getOwner().encounterSn){
    		encounterSn=this.getOwner().encounterSn;
    	} 
    	var encounterSelectCombox=Ext.getCmp('encounterSelectCombox');
    	if(encounterSelectCombox){
    		encounterSn=encounterSelectCombox.getValue();
    	}
    	var url='mrs'+'?withFile=1&encounterPk='+encounterSn+'&mrTypeCustomCode='+mrTpCcatCd;
    	if(this.getOwner().ownerCt.printerPortal){
    		url+='&mrType=MRM04.01';
    	}
//    	var url = 'mrs'+'/'+mrSn+'?withFile=true';
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onReadSuccess2
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
//        var self=this;
        var medicalRecord=operation.result.data;
        var fileData=medicalRecord.fileData;
        var a=new Date();
        console.log('%c'+a+':'+a.getMilliseconds()+'毫秒     得到后台返回【'+medicalRecord.mrPk+'】的文件：'+fileData.substring(0,20),'color: #86CC00; background-color: black; font-size: 20px; padding: 3px;');
        var mrDocEditPage=this.getOwner();
        mrDocEditPage.medicalRecord=medicalRecord;
        this.getOwner().ownerCt.medicalRecord=medicalRecord;
        //调用老孟提供的接口,在TOP页上显示诊断信息
//        this.refreshTop(medicalRecord);
        
//        console.log(mrDocEditPage.medicalRecord);
        //根据medicalRecord属性判断当前用户是否要用编辑模式打开
        var readonlyF=false;
        if(medicalRecord.canEdit&&1==medicalRecord.canEdit){
        	readonlyF=false;
        }
        //初始化编辑器参数
        var params={
                'objectId':'iemrEditor',
                'sstream':medicalRecord.fileData,
                'mr_mode':1,//编辑器打开模式，1为书写模式，2为模板编辑模式，3为浏览模式
                'readonly':readonlyF,//是否以只读方式打开文档
                'callBackAction':'editorCallBackAction'//编辑器加载完成后要执行的回调Action
        };
        //将编辑器插入当前page
        this.insertWriter(mrDocEditPage,params);
    },
    
    onReadSuccess: function(operation) {
        var self=this;
        var mrDocEditPage=self.getOwner();
        mrDocEditPage.medicalRecord=operation.result.data;
        mrDocEditPage.fireEvent('editorOpened', operation.result.data);
//        console.log(mrDocEditPage.medicalRecord);
        var params={
                'objectId':'iemrEditorRead',
                'sstream':operation.result.data.fileData,
                'mr_mode':this.mrMode,
                'readonly':true,
                'callBackAction':'editorCallBackAction'
        };
        self.insertWriter(mrDocEditPage,params);
    },
    
    onReadSuccess2: function(operation) {
        var self=this;
        var mrDocEditPage=self.getOwner();
        var mrs=operation.result.dataList;
        mrDocEditPage.mrs=mrs;
        mrDocEditPage.fireEvent('editorOpened', operation.result.dataList);
//        console.log(mrDocEditPage.medicalRecord);
        if(mrs&&mrs.length>0){
        	var params={
                    'objectId':'iemrEditorRead',
                    'sstream':mrs[0].fileData,
                    'mr_mode':1,
                    'readonly':false,
                    'hidden':true,
                    
                    'callBackAction':'mergeAll'
            };
            self.insertWriter(mrDocEditPage,params);
        }
        
    },
    addPrepareOperations: function(operations,filePk) {
        var url = 'mr/basefile/'+filePk;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onAddSuccess
        };
        operations.push(operation);
    },
    onAddSuccess: function(operation) {
        var self=this;
        var data=operation.result.data;
        var mrDocEditPage=self.getOwner();
        var params={
                'objectId':'iemrEditor',
                'sstream':data.odtFile,
                'mr_mode':1,
                'readonly':'false',
                'callBackAction':'editorCallBackAction'
        };
        this.insertWriter(mrDocEditPage,params);
    },
    
    refreshTop:function(medicalRecord){
    	
    	 var canvas = Xap.getCanvas();
         canvas.fireEvent("updatePatient",{patient:medicalRecord.amr});
    }
    
});
