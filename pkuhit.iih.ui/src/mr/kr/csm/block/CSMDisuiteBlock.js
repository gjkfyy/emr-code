Ext.define('iih.mr.kr.csm.block.CSMDisuiteBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [
	           'Xap.ej.element.grid.Grid',
	           'Xap.ej.element.tab.Panel',
	           'Xap.ej.element.button.Button',
	           ],
	alias:'widget.csmdisuiteblock',
	border: 0,
    items:  [{
		    	xtype:'xappanel',
		    	action:'disute',
		    	border:0,
		    	padding:'10 0 5 0',
		    	layout: {
					type: 'table',
					columns: 2,
					tableAttrs: {
			            border: 0,
			            cellspacing: 1,
			            width: '100%'
			        },
			        tdAttrs: {
			            valign: 'left'
			        }
			    },
			    items:[{
			    	   xtype: "xapcombobox",
					   action:'ownerType',
					   fieldLabel:'所属分类',
					   labelAlign:'right',
					   comboData:[			
					       {"value":'MDM08.02', "text":"科室"},		
					       {"value":"MDM08.03", "text":"个人"}		
					    ] 
			    },{
			    	   xtype: "xapcombobox",
					   action:'owner',
					   fieldLabel:'组套所属',
					   labelAlign:'right',
			    },{
			    	   xtype: "xapcombobox",
					   action:'category',
					   fieldLabel:'组套分类',
					   labelAlign:'right',
			    },{
			    	action:'disute',
					xtype:'comboxgrid',
       				url: 'di/asistantInput',
       				labelAlign : 'right',
       			    fieldLabel:'组套名称',
       				listWidth:230,    
       				width:255, 
       				valueField : 'value',
       				displayField:'label',
       	            columns: [{
       	                    text: '诊断编码',
       	                    dataIndex: 'value',
       	                    hidden:true
       	                },{
       	                    text: '诊断名称',
       	                    flex:1,
       	                    dataIndex: 'label'
       	                },
       	                {
       	                    text: 'ICD编码',
       	                    flex:1,
       	                    dataIndex: 'icd',
       	                    hidden:true
       	                }],
       	             callback : function(newValue,oldValue,record){  
			    	      var owner = Ext.getCmp('csmdisuiteview');
			    	      var categoryCombox = owner.down('xapcombobox[action=category]');
			    	      var  effect = owner.getActionChain('categoryEffectAction');
			    	      var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
			    	      properties.data.diCode = newValue;
			    	      properties.data.diSuiteTypeCode = categoryCombox.value;
			    	      effect.execute();
			    	      
			    	      if(owner.viewConfig.typeFlag == 1){
			    	    	  
			    	    	  var diGrid = owner.down('xapgrid[action=digrid]');
			    	    	  var diStore = diGrid.getStore();
			    	    	  var insertModel = Ext.create('iih.mr.kr.csm.model.DIModel',{
			    				   icdCode:record.icd,
			    				   diName:record.label,
			    				   diCode:record.value
			    			   });
			    			   var index = diStore.data.length;
			    			   diStore.insert(0,[insertModel]);
			    	      }
			         }
			    }]
            },{
    	        xtype:'xaptabpanel',
    	       
		    	items:[{
		    		 title:'诊断',
		    		 items:[{
					      xtype: 'xapgrid',
					      action:'digrid',
					      plugins: [
								   Ext.create('Ext.grid.plugin.CellEditing', {
										 clicksToEdit: 1
							       })
					         ],
					      height:260,
						  autoScroll:true,
						  checkboxShow:true,
						  mode:'multi',
						  showHeaderCheckbox:true,
						  tools:[{
							    action:'disuteD',
								xtype:'comboxgrid',
			       				url: 'di/asistantInput',
			       				labelAlign : 'right',
			       			    fieldLabel:'诊断',
			       				listWidth:230,    
			       				width:255, 
			       				valueField : 'value',
			       				displayField:'label',
			       	            columns: [{
			       	                    text: '诊断编码',
			       	                    dataIndex: 'value',
			       	                    hidden:true
			       	                },{
			       	                    text: '诊断名称',
			       	                    flex:1,
			       	                    dataIndex: 'label'
			       	                },
			       	                {
			       	                    text: 'ICD编码',
			       	                    flex:1,
			       	                    dataIndex: 'icd',
			       	                    hidden:true
			       	                }],
			       	             callback : function(newValue,oldValue,record){  
						    	      var owner = Ext.getCmp('csmdisuiteview');
						    	      var categoryCombox = owner.down('xapcombobox[action=category]');
						    	      var  effect = owner.getActionChain('categoryEffectAction');
						    	      var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
						    	      properties.data.diCode = newValue;
						    	      properties.data.diSuiteTypeCode = categoryCombox.value;
						    	      effect.execute();
						    	      
						    	      
				    	      
					    	      if(owner.viewConfig.typeFlag == 1){
					    	    	  
					    	    	  
					    	    	  var diGrid = owner.down('xapgrid[action=digrid]');
					    	    	  var diStore = diGrid.getStore();
		            	                var datas = diStore.getData();
		            	                var b =false;
		            	                for(var i=0;i<datas.length-1;i++){
		            	                	
		            	                	if(datas[i].diCode==record.value){
		            	                		b=true;
		            	                		break;
		            	                	}
		            	                }  
		            	                if(b){ 
		            	                
		            	                	XapMessageBox.info('重复录入!');
		            	                	
		            	                }else{
		            	                	  var insertModel = Ext.create('iih.mr.kr.csm.model.DIModel',{
							    				   icdCode:record.icd,
							    				   diName:record.label,
							    				   diCode:record.value
							    			   });
							    			   var index = diStore.data.length;
							    			   diStore.insert(0,[insertModel]);
		            	                }
					    	    	  
					    	    	
					    	    	  /*var insertModel = Ext.create('iih.mr.kr.csm.model.DIModel',{
					    				   icdCode:record.icd,
					    				   diName:record.label,
					    				   diCode:record.value
					    			   });
					    			   var index = diStore.data.length;
					    			   diStore.insert(0,[insertModel]);*/
					    	      }
				         }
						  },{
							  xtype: 'label',
					            width: 5
						  },/*{
							   xtype:'xapbutton',
							   text:'新增',
							   action:'insertDiBtn',
							   iconCls: 'icon-Create'
						  },*/{
							    xtype: 'label',
					            width: 5
						  },{
							   xtype:'xapbutton',
							   text:'删除', 
							   action:'delDiBtn',
							 iconCls: 'icon-Delete',
						  }],
						  CM_JR_Record:[
					            
					             {
					            	 header: '诊断(模板)', 
					            	 dataIndex: 'diName',
					            	 width:200,
					            	 /*editor:{
					          
				            	    	xtype:'comboxgrid',
				        				margin:'10 0 10 0',
				        				name:'diCds', 
				        	            method:'dept',
				        				url: 'di/asistantInput',
				        				
				        				labelAlign : 'right',
				        				labelWidth : 50,
				        				listWidth:230,    
				        				width:210, 
				        				valueField : 'label',
				        			
				        	            columns: [{
				        	                    text: '诊断编码',
				        	                    dataIndex: 'value',
				        	                    hidden:true
				        	                },{
				        	                    text: '诊断名称',
				        	                    flex:1,
				        	                    dataIndex: 'label'
				        	                },
				        	                {
				        	                    text: 'ICD编码',
				        	                    flex:1,
				        	                    dataIndex: 'icd'
				        	                }],
				        	                callback : function(newValue,oldValue,record){
					            	                var diGrid = this.ownerCt.grid;
					            	                var diStore = diGrid.getStore();
					            	                var datas = diStore.getData();
					            	                var b =false;
					            	                for(var i=0;i<datas.length-1;i++){
					            	                	
					            	                	if(datas[i].diCode==record.value){
					            	                		b=true;
					            	                		break;
					            	                	}
					            	                }  
					            	                if(b){ 
					            	                	this.op =true;
					            	                    this.setRawValue('');
					            	                    this.comboRecord.label = '';
			            	                	    	this.comboxHiddenValue = '';
					            	                	XapMessageBox.info('重复录入!');
					            	                	
					            	                }else{
					            	                	this.op =false;
					            	                    var selModel=diGrid.getSelectionModel();
						    	         			    var recordRow=selModel.getSelection()[0];
						    	         			   recordRow.set('icdCode',record.icd);
						    	         			   recordRow.set('diCode',record.value);
					            	                }
					            	                
			            	                },
			            	                listeners:{
			            	                	blur:function(com,the,opt){
			            	                	  var diGrid = this.ownerCt.grid;
			            	                	  var diStore = diGrid.getStore();
			            	                	  var index = diStore.data.length;
			            	                	  var selModel=diGrid.getSelectionModel();
					    	         			    var recordRow=selModel.getSelection()[0];
					    	         			    
			            	                	    if(recordRow.data.icdCode!=''){
			            	                	    	  var owner = this.ownerCt.grid.ownerCt.ownerCt.ownerCt.ownerCt;
				            	                	      var disuiteOpAction = owner.getActionChain("disuiteOpAction");
				            	                   	      disuiteOpAction.execute({type:'1'});
			            	                	    }else{
			            	                	    	
			            	                	    	
			            	                	    	this.comboRecord.label = '';
			            	                	    	this.comboxHiddenValue = '';
			            	                	    }
			            	                	
			            	                    }
			            	                }
					                  }*/
					             },
					             {
					            	 header: 'ICD编码', 
					            	 dataIndex: 'icdCode',
					            	 width:100
					             },{
					            	 header: '编码编码', 
					            	 dataIndex: 'diCode',
					            	 hidden:true,
					            	 width:100
					             }
						    ],
						 
			       
		    		 }]
		    	},{
		    		title:'模板',
		    		items:[{
				          xtype: 'xapgrid',
				          action:'mrgrid',
				          height:300,
					  	  autoScroll:true,
					      mode:'multi',
					      checkboxShow:true,
					      tools:[{
							   xtype:'xapbutton',
							   text:'新增',
							   action:'insertMrBtn',
							   iconCls: 'icon-Create'
						  },{
							    xtype: 'label',
					            width: 5
						  },{
							   xtype:'xapbutton',
							   text:'删除',
							   action:'delMrBtn',
							   iconCls: 'icon-Delete',
						  }],
					  	  CM_JR_Record:[
					               {header: '模板ID', dataIndex: 'mrTemplateCode',hidden:true},
					               {header: '病历模板', dataIndex: 'mrTemplateName',width:200},
					               {header: '所属编码', dataIndex: 'ownerCode',width:100,hidden:true},
					               {header: '所属类型', dataIndex: 'ownerType',width:100,hidden:true},
					               {header: '所属分类', dataIndex: 'ownerTypeName',width:100,hidden:false},
					               {header: '所属', dataIndex: 'ownerName',width:100,hidden:false},
					  	    ]
			    
			         
		    		}]
		    	}]
    
    }]
  
})
