Ext.define('iih.mr.kr.csm.action.CSMDisuiteViewreadyAction', {
	extend: 'Xap.ej.action.Action',
	requires:[],
	
	execute: function(context) {
	
	   
	
	   var me = this;
	   var owner = me.getOwner();
	   var block = me.getBlock('topblock');
       var ownerTypeCombox = block.down('xapcombobox[action=ownerType]');
       var ownerCombox = block.down('xapcombobox[action=owner]');
       var categoryCombox = block.down('xapcombobox[action=category]');
       
       var diGrid = block.down('xapgrid[action=digrid]');
       var diStore = diGrid.getStore();
       
       var mrGrid = block.down('xapgrid[action=mrgrid]');
       
       
       var par = owner.viewConfig;
       
      
       
       //新增和删除按钮
      // var insertDiBtn = diGrid.down('button[action=insertDiBtn]');
       var delDiBtn = diGrid.down('button[action=delDiBtn]');
       
       
       /*insertDiBtn.on('click',function(btn){
    	   var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
    	   disuiteOpAction.execute({type:'1'});
       });*/
       
       delDiBtn.on('click',function(btn){
    	   var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
    	   disuiteOpAction.execute({type:'2'});
       });
       
       mrGrid.on('afterrender',function(){
    	   
    	 //模板新增和删除按钮
           var insertMrBtn =  mrGrid.down('button[action=insertMrBtn]');
           var delMrBtn =  mrGrid.down('button[action=delMrBtn]');
           
    	   insertMrBtn.on('click',function(btn){
        	   var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
        	   disuiteOpAction.execute({type:'3'});
           });
           
           delMrBtn.on('click',function(btn){
        	   var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
        	   disuiteOpAction.execute({type:'4'});
           });
       });
       
           var ownerCode;
	       var ownerType;
	       var enTypeCode = 'ENM01.01';
	       var diSuiteTypeCode=''; //组套分类编码
     
	   //判断是编辑还是新建
       if(par.typeFlag == 2){
    	   
    	   if(par.data.ownerType=='MDM08.02'){
    		   
    		   var index = 0;
    		   ownerTypeCombox.selectAt(0);
    		   var arr = iih.mr.kr.csm.action.Util.deptArr;
    		   for(var i=0;i<arr.length;i++){
    			    if(par.data.ownerCode==arr[i].value){
    			    	index = i;
    			    	break;
    			    }
    		   }
    		   ownerCombox.setData(iih.mr.kr.csm.action.Util.deptArr);
    		   ownerCombox.selectAt(index);
    	   }else{
    		   ownerTypeCombox.selectAt(1);
    		   me.setownercombox(ownerCombox);
    	   }
    	   
    	   var comboxgrid = block.down('comboxgrid[action=disute]');
    	   comboxgrid.setRawValue(par.data.diNm);
    	   //comboxgrid.setValue(par.data.diCode);
    	   ownerCode = par.data.ownerCode;
    	   ownerType = par.data.ownerType;
    	   diSuiteTypeCode = par.data.diSuiteTypeCode;
    	   
    	   me.initEditDiMr(me);
    	   
       }else{
    	   
             var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
	    	 disuiteOpAction.execute({type:'1'});
           
   	       /*ownerTypeCombox.selectAt(0);//默认选择科室
           ownerCombox.setData(iih.mr.kr.csm.action.Util.deptArr);
           ownerCombox.selectAt(0);//默认选择第一个科室*/
	    	 
	    	 diSuiteTypeCode = par.data.diSuiteTypeCode;
             
             //默认选择当前所选择的科室
		     if(par.data.ownerType=='MDM08.02'){
		    		   
		    		   var index = 0;
		    		   ownerTypeCombox.selectAt(0);
		    		   var arr = iih.mr.kr.csm.action.Util.deptArr;
		    		   for(var i=0;i<arr.length;i++){
		    			    if(par.data.ownerCode==arr[i].value){
		    			    	index = i;
		    			    	break;
		    			    }
		    		   }
		    		   ownerCombox.setData(iih.mr.kr.csm.action.Util.deptArr);
		    		   ownerCombox.selectAt(index);
		    		   
		    		   ownerCode = ownerCombox.value;
		    	       ownerType='MDM08.02';
		    		   
		    	   }else{
		    		   ownerTypeCombox.selectAt(1);
		    		   me.setownercombox(ownerCombox);
		    		   
		    		   ownerCode = ownerCombox.value;
		    	       ownerType='MDM08.03';
		    	   }  
       }
       
          
       
       
	   var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
     
       
        properties.setData({
	    	ownerCode:ownerCode,
	    	ownerType:ownerType,
	    	enTypeCode:enTypeCode,
	    	diSuiteTypeCode:diSuiteTypeCode
	     });
    	
        me.initCategory(me);
      
        //所属分类监听
        ownerTypeCombox.on('change',function(com){
        	  
        	   if(com.value == 'MDM08.02'){
        		   
        		   ownerCombox.setData(iih.mr.kr.csm.action.Util.deptArr);
        	       ownerCombox.selectAt(0);//默认选择第一个科室
        		   
        	   }else{
        		
        		   me.setownercombox(ownerCombox);
        	   }
        	   
        	   properties.setData({
	       	    	ownerCode:ownerCombox.value,
	       	    	ownerType:com.value,
	       	    	enTypeCode:enTypeCode
       	        });
        	   
        	   me.initCategory(me);
        });
        
        ownerCombox.on('select',function(com){
        	
        	if(ownerTypeCombox.value=='MDM08.02'){
        		
        		 properties.setData({
 	       	    	ownerCode:com.value,
 	       	    	ownerType:ownerTypeCombox.value,
 	       	    	enTypeCode:enTypeCode
        	       });
         	   
         	   me.initCategory(me);
        	}
        });
       
        var bottomblock = me.getBlock('bottomblock');
        var confirmBtn = bottomblock.down('xapbutton[action=confirm]');
        var closeBtn = bottomblock.down('xapbutton[action=close]');
        
        confirmBtn.on('click',function(){
        	 var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
       	     disuiteOpAction.execute({type:'5'});
        });
        
        closeBtn.on('click',function(){
       	     var disuiteOpAction = me.getOwner().getActionChain("disuiteOpAction");
      	     disuiteOpAction.execute({type:'6'});
       });
       
    },
    

   initCategory:function(me){
    	
    	 var categoryAction = me.getOwner().getActionChain("categoryAction");
         categoryAction.execute();
    },
    
    setownercombox:function(ownerCombox){
    	
    	   var comdata = [];
		   var model = {
                 'text':IMER_GLOBAL.user.name,
                 'value':IMER_GLOBAL.user.code,
               };
		   comdata.push(model);
		   ownerCombox.setData(comdata);
	       ownerCombox.selectAt(0);
    },
    
    initEditDiMr:function(me){
    	 var diSearchAction = me.getOwner().getActionChain("disuiteDiSearchAction");
    	 diSearchAction.execute();
    	 
    	 var mrSearchAction = me.getOwner().getActionChain("disuiteMrSearchAction");
    	 mrSearchAction.execute();
    	 
    	 
    }
   
});
