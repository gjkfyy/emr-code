Ext.define('iih.mr.wr.nsv.action.NurScoreDocEditAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	requires: ['iih.mr.block.editor.MrDocEditBlock'],
	/*
	* @Override
	*/
	execute: function(context) {
	    Ext.useShims=true;
	    var a=Ext.getCmp('nurscorewriteview');
	    var b=a.ownerCt.ownerCt;
	    b.ownerCt.hideMode='offsets';
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var opType=this.getOwner().opType;
    	if(opType!=undefined){
    		var rs = this.getBlock('content');   
    		if(opType!='readonly'){
    			this.addEditorEvent(rs);
            	this.showProgress();//显示进度条
    		}
            if(opType=='new'){//创建新病历
                var filePk=this.getOwner().medicalRecord.filePk;//得到模板文件pk
                this.addPrepareOperations(operations,filePk);
            }else if(opType=='newFromPastMr'){
                var mrDocEditPage=this.getOwner();
                var params={
                        'objectId':'iemrEditor',
                        'sstream':this.getOwner().fileData,
                        'mr_mode':4,
                        'readonly':'false',
                        'callBackAction':'editorCallBackAction'
                };
                this.insertWriter(mrDocEditPage,params);
            	
            }else if(opType=='reSelectMr'){
                var mrDocEditPage=this.getOwner();
                mrDocEditPage.opType='reSelect';
                var params={
                        'objectId':'iemrEditor',
                        'sstream':this.getOwner().fileData,
                        'mr_mode':4,
                        'readonly':'false',
                        'callBackAction':'editorCallBackAction'
                };
                this.insertWriter(mrDocEditPage,params);
            	
            }else if(opType=='reSelectTemp'){
                var mrDocEditPage=this.getOwner();
                mrDocEditPage.opType='reSelect';
                var tempFilePk=mrDocEditPage.tempFilePk;//得到模板文件pk
                this.reSelectTempPrepareOperations(operations,tempFilePk);
            	
            }else if(opType=='open'){//打开已有病历
                var mrSn=this.getOwner().mrSn;//得到文书pk
                var a=new Date();
                console.log('%c'+a+':'+a.getMilliseconds()+'毫秒     开始调用后台服务获取【'+mrSn+'】的文件......','color: #86CC00; background-color: black; font-size: 20px; padding: 3px;');
                this.openPrepareOperations(operations, mrSn);
            }else if(opType=='merge'){//打开已有病历
            	var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
            	reSelectTempBtn.setDisabled(true);
                this.openAllPrepareOperations(operations);
            }else if(opType=='readonly'){//只读浏览病历
                var mrTpCcatCd=this.getOwner().mrTpCcatCd;//得到医疗记录类型组pk
                var mrSn=this.getOwner().mrSn;//得到文书pk
                if(mrSn){
                	this.readPrepareOperations(operations, mrSn);
                }else if(mrTpCcatCd){
                	this.showProgress();//显示进度条
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
    openAllPrepareOperations: function(operations) {
    	var encounterSn = IMER_GLOBAL.encounterSn;
        var url = 'omrs'+'?encounterPk='+encounterSn+'&withFile=true&merge=true';
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onOpenAllSuccess
        };
        operations.push(operation);
    },
    readPrepareOperations: function(operations, mrSn) {
    	var url = this.url+'/'+mrSn+'?withFile=true';
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
    	var url='mrs'+'?withFile=1&encounterPk='+encounterSn+'&mrTypeCustomCode='+mrTpCcatCd;
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
//      var self=this;
    	var medicalRecord=operation.result.data;
    	var fileData=medicalRecord.fileData;
    	var a=new Date();
    	console.log('%c'+a+':'+a.getMilliseconds()+'毫秒     得到后台返回【'+medicalRecord.mrPk+'】的文件：'+fileData.substring(0,20),'color: #86CC00; background-color: black; font-size: 20px; padding: 3px;');
    	var mrDocEditPage=this.getOwner();
    	mrDocEditPage.medicalRecord=medicalRecord;
      
    	//根据medicalRecord属性判断当前用户是否要用编辑模式打开
    	var readonlyF=false;
//    	if(medicalRecord.canEdit&&1==medicalRecord.canEdit){
//    		readonlyF=false;
//    	}
    	//初始化编辑器参数
    	var params={
    			'objectId':'iemrEditor',
    			'sstream':medicalRecord.fileData,
    			'mr_mode':4,//编辑器打开模式，1为书写模式，2为模板编辑模式，3为浏览模式
    			'readonly':readonlyF,//是否以只读方式打开文档
    			'callBackAction':'editorCallBackAction'//编辑器加载完成后要执行的回调Action
    	};
    	//将编辑器插入当前page
    	this.insertWriter(mrDocEditPage,params);
    },
    onOpenAllSuccess: function(operation) {
    	var mrList=operation.result.dataList;
    	var mrDocEditPage=this.getOwner();
    	mrDocEditPage.mrList=mrList;
    	if(mrList&&mrList.length>0){
    		var mrFirst=mrList[0];
    		//初始化编辑器参数
        	var params={
        			'objectId':'iemrEditor',
        			'sstream':mrFirst.fileData,
        			'mr_mode':4,//编辑器打开模式，1为书写模式，2为模板编辑模式，3为浏览模式
        			'readonly':false,//是否以只读方式打开文档
        			'hidden':true,
        			'callBackAction':'mergeAllMr'//编辑器加载完成后要执行的回调Action
        	};
        	//将编辑器插入当前page
        	this.insertWriter(mrDocEditPage,params);
    	}else{
    		this.closeProgress();
    		XapMessageBox.info('没有需要合并的病历!');
    	}
    },
    
    onReadSuccess: function(operation) {
        var self=this;
        var mrDocEditPage=self.getOwner();
        mrDocEditPage.medicalRecord=operation.result.data;
        mrDocEditPage.fireEvent('editorOpened', operation.result.data);
        var params={
                'objectId':'iemrEditorRead',
                'sstream':operation.result.data.fileData,
                'mr_mode':3,
                'readonly':true,
                'callBackAction':'closeProgress'
        };
        self.insertWriter(mrDocEditPage,params);
    },
    
    onReadSuccess2: function(operation) {
        var self=this;
        var mrDocEditPage=self.getOwner();
        var mrs=operation.result.dataList;
        mrDocEditPage.mrs=mrs;
        mrDocEditPage.fireEvent('editorOpened', operation.result.dataList);
        if(mrs.length>0){
        	var params={
                    'objectId':'iemrEditorRead',
                    'sstream':mrs[0].fileData,
                    'mr_mode':4,
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
    reSelectTempPrepareOperations: function(operations,filePk) {
        var url = 'mr/basefile/'+filePk;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onReSelectTempSuccess
        };
        operations.push(operation);
    },
    addPrepareOperationsFromPastMr: function(operations,filePk) {
        var url = 'mr/file/'+filePk;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onAddSuccessFromPastMr
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
                'mr_mode':4,
                'readonly':'false',
                'callBackAction':'editorCallBackAction'
        };
        this.insertWriter(mrDocEditPage,params);
    },
    onReSelectTempSuccess: function(operation) {
        var self=this;
        var data=operation.result.data;
        var mrDocEditPage=self.getOwner();
        var params={
                'objectId':'iemrEditor',
                'sstream':data.odtFile,
                'mr_mode':4,
                'readonly':'false',
                'callBackAction':'editorCallBackAction'
        };
        this.insertWriter(mrDocEditPage,params);
    },
    onAddSuccessFromPastMr: function(operation) {
        var self=this;
        var pasrMr=operation.result.data;
        var mrDocEditPage=self.getOwner();
        var params={
                'objectId':'iemrEditor',
                'sstream':pasrMr.fileData,
                'mr_mode':4,
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
