Ext.define('iih.mr.di.action.Util',{
	singleton: true,
    cascadeTransfer : function(treeDatas, nodeHandler, inChildNodeName, scope){
		console.log('typeof treeDatas=',typeof treeDatas);
		var me = this, 
			inChildNodeName = inChildNodeName || 'children',
	        scope = scope || this;
	   
		var _traverse = function(inNode) {
			if (nodeHandler.apply(scope, [inNode]) != false) {
				var items = inNode[inChildNodeName] || [], len = items.length;
				if (len == 0) return;

		        for (var i=0; i<len; i++) {
		          
		          _traverse.apply(scope, [items[i]]);
		        }
		      }
		 };
		 if(this.isArray(treeDatas)){
			 var i=0,len=treeDatas.length;
			 for(;i<len;i++){
				 _traverse.apply(scope, [treeDatas[i]]);
			 }
		 }else{
			 _traverse.apply(scope, [treeDatas]);
		 }
		
		
			
		return treeDatas;
	 },
	 cascadeTransferToNew: function(inJsonTree, nodeHandler,scope, inChildNodeName, outChildNodeName){
	    console.log(typeof inJsonTree);
		var me = this, inChildNodeName = inChildNodeName || 'children',
	      outChildNodeName = outChildNodeName || 'children',
	      scope = scope || me,
	      outData;
	      
			
		var _traverse = function(inNode, outNode) {
			//outNode=outNode||{};
			if (nodeHandler.apply(scope, [inNode, outNode]) != false) {
				var items = inNode[inChildNodeName] || [], 
					len = items.length;
				if (len == 0) return outNode;

				outNode[outChildNodeName] = [];
		        for (var i=0; i<len; i++) {
		          outNode[outChildNodeName][i] = {};
		          _traverse.apply(scope, [items[i], outNode[outChildNodeName][i]]);
		        }
		        return outNode;
		      }
			  
		    };
		    
		if(this.isArray(inJsonTree)){
			 var i=0,len=inJsonTree.length;
			 outData=[];
			 for(;i<len;i++){
				 outData[outData.length]= _traverse.apply(scope, [ inJsonTree[i] , {} ] );
			 }
		 }else{
			 outData = {};
			 _traverse.apply(scope, [inJsonTree, outData]);
		 }	
		return outData;
	 },
	 isArray:function (obj) {   
	   return Object.prototype.toString.call(obj) === '[object Array]';    
	 },
	
	 get: function(field) {
        return this[field];
     },
     
     /*
      * datas: 原数据，
      * nodes： 新数据，
      * */
     filterArry:function(datas,nodes){
     	
   	  for(var i=0;i<datas.length;i++){
   		  
   		  for(var j=0;j<nodes.length;j++){
			  
			      if(datas[i].data){
				      
			    	  if((datas[i].data.diCd == nodes[j].diCd)&&(datas[i].data.stopUseF == 0)){
   				  
   				              Ext.Array.remove(nodes,nodes[j]);
   			             }
						
						if(datas[i].childNodes.length>0){
   				  
   				          for(var m=0;m<datas[i].childNodes.length;m++){
   					  
   				        	 if(nodes.length>0){
   				        		 if((nodes[j].diCd == datas[i].childNodes[m].data.diCd) && (datas[i].childNodes[m].data.stopUseF==0)){
   	   						         Ext.Array.remove(nodes,nodes[j]);
   	   					          }
   				        	 }
   				        }
   			      }
					  
				  }else{
				  
					  if((datas[i].diCd == nodes[j].diCd) && (datas[i].stopUseF ==0)){
   				  
   				       Ext.Array.remove(nodes,nodes[j]);
   			       }
					   
					   if(datas[i].children){
					       if(datas[i].children.length>0){
   				  
   				             for(var m=0;m<datas[i].children.length;m++){
   					  
   				            	if(nodes.length>0){
   				            		   
   				            		if((nodes[j].diCd == datas[i].children[m].diCd) && (datas[i].children[m].stopUseF==0)){
     						              Ext.Array.remove(nodes,nodes[j]);
     					               }
   				            	}
   				            	
   				             }
   			            }
					  }
				  }  
   		  }
   	  }
   	  
   	  return nodes;
    },
    
    commitFilterArry:function(datas,nodes){
    	
    	
    	for(var i=0;i<datas.length;i++){
    		 
   	     Xap.debug(i+"   ----ppppppppp");
   	    
   	    if(datas[i].data){
   		  
   		   if((i+1)<datas.length){
   		   
   		         if((datas[i].data.diCd == datas[i+1].data.diCd)&&(datas[i].data.stopUseF == 0)){
    				  
   				          if(datas[i].data.diSn==''){
   						     Ext.Array.remove(datas,datas[i]);
   						  }else{
   						    Ext.Array.remove(datas,datas[i+1]);
   						  }
    				              
   							  
    			    }

   		
   			    		  
   	  			          if(datas[i].childNodes.length>0){
   	  	     				  
   	   				          for(var m=0;m<datas[i].childNodes.length;m++){
   	   					  
   	   				        	if((datas[i+1].data.diCd == datas[i].childNodes[m].data.diCd) && (datas[i].childNodes[m].data.stopUseF==0)){
   								   
   								      if(datas[i+1].data.diSn==''){
   									      Ext.Array.remove(datas,datas[i+1]);
   									  }else{
   									      Ext.Array.remove(datas,datas[i]);
   									  }
   	   						           
   							
   	   					         }
   	   				         }
   	   			          }else if(datas[i+1].childNodes.length>0){
   						  
   						       for(var m=0;m<datas[i+1].childNodes.length;m++){
   	   					  
   	   				        	if((datas[i].data.diCd == datas[i+1].childNodes[m].data.diCd) && (datas[i+1].childNodes[m].data.stopUseF==0)){
   								   
   								      if(datas[i+1].data.diSn==''){
   									      Ext.Array.remove(datas,datas[i+1]);
   									  }else{
   									      Ext.Array.remove(datas,datas[i]);
   									  }
   	   						           
   							
   	   					         }
   	   				         }
   						  }
   			    	  
   		   }
   		
   		  
   		}else{
   		
   		     Xap.debug("-------------------");
   		 }
   	 }
    	
    	  return datas;
  	  /*for(var i=0;i<datas.length;i++){
 		  
 		  for(var j=0;j<nodes.length;j++){
			  
			      if(datas[i].data){
				      
			    	  if((datas[i].data.diCd == nodes[j].data.diCd)&&(datas[i].data.stopUseF == 0) && (datas[i].data.diSn=='')){
 				  
 				              Ext.Array.remove(datas,datas[j]);
 			             }
						
			    	  if(datas[i].childNodes){
			    		  
	  			          if(datas[i].childNodes.length>0){
	  	     				  
	   				          for(var m=0;m<datas[i].childNodes.length;m++){
	   					  
	   				        	if((nodes[j].data.diCd == datas[i].childNodes[m].data.diCd) && (datas[i].childNodes[m].data.stopUseF==0) && (datas[i].data.diSn=='')){
	   						           Ext.Array.remove(datas,datas[j]);
	   					         }
	   				         }
	   			          }
			    	  }
						
					  
				  }else{
				  
					  if((datas[i].diCd == nodes[j].diCd) && (datas[i].stopUseF ==0) &&(datas[i].diSn=='')){
 				  
 				             Ext.Array.remove(datas,datas[j]);
 			           }
					   
					   if(datas[i].children){
					       if(datas[i].children.length>0){
 				  
 				             for(var m=0;m<datas[i].children.length;m++){
 					  
 				            	if((nodes[j].diCd == datas[i].children[m].diCd) && (datas[i].children[m].stopUseF==0) && (datas[i].children[m].diSn=='')){
 						              Ext.Array.remove(datas,datas[j]);
 					               }
 				              }
 			              }
					   }
						
						
				  
				  }  
 		  }
 	  }*/
 	  
 	
    }
});
 