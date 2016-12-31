 Ext.define("iih.po.com.hisToiemrUtil", {
	     singleton: true, 
	     
	     ownerType:'',
	     
	     ownerCode:'',
	     
	     diCode:'',
	     
	     diName:'',
	     
	     hisMessage:'',
	     
	     setOwnerTypeCd:'',
	     
	     medicalTempletes:[],
	     
	     medicalTempleOpen:false,
	 
	     statics: {
        	 ownerType:'',
        	 ownerCode:''
         },
         
	    setGloeVar:function(ownerType,ownerCode){
       	  this.ownerType = ownerType;
       	  this.ownerCode = ownerCode;
       	 // alert(this.ownerType+"   "+this.ownerCode);
         },
         
        setStaticGloeVar:function(ownerType,ownerCode){
          	  this.statics().ownerType = ownerType;
          	  this.statics().ownerCode = ownerCode;
          	
         },
         
         
        getStaticOwnerType: function(){
             return this.statics().ownerType; 
        },
        
        getStaticOwnerCode: function(){
            return this.statics().ownerCode; 
        },
         
         getOwnerType:function(){
       	   return this.ownerCode;
         },
         
         getOwnerCode:function(){
        	return this.ownerCode;  
         },
         
         
         refreshOrder:function(xmlstring){
        	 

        	 
			     if (window.ActiveXObject)
				  {
					  var xmlobject =new ActiveXObject("Microsoft.XMLDOM");
					  xmlobject.async="false";
					  xmlobject.loadXML(xmlstring);
				  }
				else
				  {
					  var parser=new DOMParser();
					  var xmlobject =parser.parseFromString(xmlstring,"text/xml");
				  }
				  
				 var root = xmlobject.getElementsByTagName('message')[0];
		
				 var objects = root.getElementsByTagName("object");
				 
				 
				 var codeFn = objects[0].getAttribute("code");
				 
				
				 console.log('codeFn......'+codeFn);
				
				 
			  
        	
        	 if(codeFn =='ORDER'){
        		//提交打印病历
    			 var temp = data.token.split("|");
    			 var enPk=temp[1];
    			 if(enPk==IMER_GLOBAL.encounterSn){
    				var outmrwriteview = Ext.getCmp('outmrwriteview');
    				var right=outmrwriteview.getBlock('right');
    				var emrPrint = right.getActionChain('emrPrint');
    				emrPrint.execute();
    			 }
        		
			 }
         },
         
         finish:function(data){
		     //刷新处方处置，提交并打印病历
			 var temp = data.token.split("|");
			 var enPk=temp[1];
			 var showIemr=temp[2];
			 if(showIemr==1){
				 window.focus();
			 }
			 if(enPk==IMER_GLOBAL.encounterSn){
				var outmrwriteview = Ext.getCmp('outmrwriteview');
				var right=outmrwriteview.getBlock('right');
				var emrRefreshOutpatientDisposal = right.getActionChain('emrRefreshOutpatientDisposal');
				emrRefreshOutpatientDisposal.execute({submitF:1});
			 }
         },
     
         common:function(conn, data){
             console.log('here is common!');
             var temp = data.data.token.split("|");
             var optFlag = temp[9];
             var enPk=temp[6];
             console.log('optFlag is ' + optFlag);
             if(optFlag){//诊毕
                IMER_GLOBAL.mr.encounterIsOver = optFlag;
                if(enPk==IMER_GLOBAL.encounterSn){
                    this.encounterOver();
                    
                }else{
                    iih.po.com.hisLoginIemrUtil.autoLogin(conn,data);
                }
             }else{
                window.focus();
                iih.po.com.hisLoginIemrUtil.autoLogin(conn,data);
             }
         },
         
         encounterOver:function(){
            if(CONFIG_PARAM.OMR_EN_OVER_IS_FOCUS == 1){
                window.focus();
            };
            var outmrwriteview = Ext.getCmp('outmrwriteview');
            var right=outmrwriteview.getBlock('right');
            var emrRefreshDiagnosis=right.getActionChain("emrRefreshDiagnosis");
            emrRefreshDiagnosis.execute();
            
            var submitF = null;
            if(IMER_GLOBAL.mr.encounterIsOver == 1){//已经诊毕
                submitF = 1;
            }
            var emrRefreshOutpatientDisposal = right.getActionChain('emrRefreshOutpatientDisposal');
            emrRefreshOutpatientDisposal.execute({'submitF':submitF});
         },
         
         getHisMessage:function(xmlstring){
        	 
        	  if (window.ActiveXObject)
			  {
				  var xmlobject =new ActiveXObject("Microsoft.XMLDOM");
				  xmlobject.async="false";
				  xmlobject.loadXML(xmlstring);
			  }
			else
			  {
				  var parser=new DOMParser();
				  var xmlobject =parser.parseFromString(xmlstring,"text/xml");
			  }
			  
			 var root = xmlobject.getElementsByTagName('message')[0];
	
			 var objects = root.getElementsByTagName("object");		
			 
			 var hisMessage = objects[0].getAttribute("proc");
			 
			 /*if(hisMessage!=undefined){
				 iih.kr.cs.csa.glove.GloveVar.hisMessage = hisMessage;
			 }*/
         },
         
         
         
         getIemrMessage:function(){
        	 Ext.MessageBox.show({
                 title:'提示',
                 msg:'HIS MZCPR 消息接收服务异常，请到【医生工作台】界面手动刷新',
                 icon : Ext.Msg.INFO,
                 buttons : Ext.Msg.OK
             });
         }
       
  });
 
     