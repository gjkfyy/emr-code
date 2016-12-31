Ext.define("iih.mr.di.block.DiagnosisFilterTree", {
	extend: 'Xap.ej.element.tree.FilterTree',
	requires:[
      'Xap.ej.element.tree.FilterTree',
      'Xap.ej.element.field.ComboBoxGrid',
      'Xap.ej.element.field.ComboBox',
      'Xap.ej.element.field.TextField',
      'Xap.ej.element.button.Button',
	],
    alias: 'widget.diagnosisfiltertree',
    rootVisible: false,
    autoScroll : true,
	border : false,
	margins : '0 0 -1 1',
	lines:false,
	height:'100%',
	width:'100%',
	fields:['diEmpCd','diSn','diNm','diCd','icdCd',{name:'tocheck',type:'bool'},{name:'suspected',type:'bool'},'addDescr','diEmpNm','diTime','setOwnerTypeCd','setOwnerCd'],
	columns:{
		 defaults: {
		   sortable: false
	      },
	     items:[{
	    	 xtype: 'treecolumn',
         	 text: '诊断名称',
             width: 250,                
             dataIndex:'diNm',
             anchor: "90%",
              renderer:function(value,metaData,record ){
      		    return record.get('diNm');	//diSn
           	 },
             getEditor:function(record,defaultField ){
			    	 if(record.get('diSn'))
		        		 return null;
		        	 else{
		        		 var editor =  new Ext.grid.CellEditor({
		                     floating: true,
		                     editorId: this.getItemId(),
		                     field: {
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
			        				displayField: 'label',
			        				setValue:function(){
			        				},
			        	           // searchParam :{'id':'diagnosisCdLoad'},
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
			        			      var tree = this.ownerCt.grid;
			        			      var datas =  tree.getRootNode().childNodes;
			        			     
			        			      var b = false;
			        			      for(var i=0;i<datas.length;i++){
			        			    	   
			        			    	  if((datas[i].data.diCd == record.value)){    					
		    						        	 b = true;
		    						        	 break;
		    						         }
			        			      }
			        			      
			        			      if(b){
			        			    	  var selModel=tree.getSelectionModel();
			    	         			    var recordRow=selModel.getSelection()[0];
											if(!recordRow.get('diSn')){
									            recordRow.set('diSn','');
												recordRow.set('diCd','');
												recordRow.set('icdCd','');
												recordRow.set('diNm','');
									         }
			    	         			  editor.field.setRecordData({});
			        			    	  XapMessageBox.info('重复录入!');
			        			    	    
			        			    	  
			        			      }else{
			        			    	    var selModel=tree.getSelectionModel();
			    	         			    var recordRow=selModel.getSelection()[0]
			        			    	    recordRow.set('diNm',record.label);
			    						    recordRow.set('diCd',record.value);
			    						    recordRow.set('diSn','');
			    						    if(record.icd=='NULL'){
												   recordRow.set('icdCd','');
												}else{
												recordRow.set('icdCd',record.icd);
											}
			        			      }
			        		     },
			        		     listeners:{
			        		    	 blur:function(com,the,opt){
			        		    	    var tree = this.ownerCt.grid;
			        		    	    var selModel=tree.getSelectionModel();
		    	         				var recordRow=selModel.getSelection()[0];
		    	         				console.log(recordRow.get('diNm'));
										if(!recordRow.get('diSn')){
										    recordRow.set('diSn','');
										}
										if(com.rawValue){
//										  recordRow.set('icdCd','');
//										  recordRow.set('diCd','');    
//										  recordRow.set('diNm','');
//										  com.rawValue='';
//										  com.value='';
//										  com.comboxHiddenValue='';
//										}else{
											var owner = tree.ownerCt.ownerCt;
											var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
											properties.setData({
									  	    	// action:'insertBtn'
												 action:'newRowOnButtom'
									  	     });
											 var outDiagnosisMoveChain = owner.getActionChain("outDiagnosisMoveAction");
											 outDiagnosisMoveChain.execute();
										}
			        		         }
			        		     }
			        		 }
			        	 });
		        		 var startEditTemp = editor.startEdit;
		        		 editor.startEdit = function(el, value,context) {
		        			 startEditTemp.apply(this,arguments);
		        			 var record = context.record;
		        			 var field = this.field;
		        			 var rec = {
     		        			"label":record.get("diNm"),
     		        			"value":record.get("diCd"),
     		        			"icd":record.get("icdCd"),
     		        		 }
		        			 field.setRecordData(rec);
		        		 }
		        		 editor.on("complete",function(ed){
		        		 },editor);
		        		 return editor;
		        	 }
	         }
	     },{
        	 header: '诊断编码',
             dataIndex: 'diCd',
             width: "9%",
             sortable: false,
             stopSelection: false
         },
         {
             header:'ICD编码',
             dataIndex: 'icdCd',
             width: "9%",
             sortable: false           
         },{
        	  header: '待查',
	          dataIndex: 'tocheck',
	          width: "5%",
	          sortable: false,
	          stopSelection: false,
	          renderer:function(value,metaData,record ){
        	 
	        		var check = record.get('tocheck')
	            	var b = false;
	            	var diSN = record.get('diSn');
	            	if(/.*[\u4e00-\u9fa5]+.*$/.test(diSN)){
	            		diSN = '';
	            	}else{
	            		diSN = record.get('diSn');
	            	}
	            	
	            	if(diSN!=''){
	        	    	if(check){
	        	    		return "<input type='checkbox' name='tocheck' disabled='disabled' checked />"
	        	    	}else{
	        	    		return "<input type='checkbox' name='tocheck' disabled='disabled'/>";
	        	    	}
	        	    	
	        	    }else if((diSN=='') && check){
	        	    	return "<input type='checkbox' name='tocheck' checked />";
						
	        	    }else{
						return "<input type='checkbox' name='tocheck' />";
					}
              }
         },{
        	  header: '疑似',
	          dataIndex: 'suspected',
	          width: "5%",
	          stopSelection: false,
	          renderer:function(value,metaData,record ){
        	 
		     	    var check = record.get('suspected')
		         	var b = false;
		         	var diSN = record.get('diSn');
		         	if(/.*[\u4e00-\u9fa5]+.*$/.test(diSN)){
		         		diSN = '';
		         	}else{
		         		diSN = record.get('diSn');
		         	}
		         	
		         	if(diSN!=''){
		     	    	if(check){
		     	    		return "<input type='checkbox' name='suspected' disabled='disabled' checked />"
		     	    	}else{
		     	    		return "<input type='checkbox' name='suspected' disabled='disabled'/>";
		     	    	}
		     	    	
		     	    }else if((diSN=='') && check){
		     	    	return "<input type='checkbox' name='suspected' checked />";
							
		     	    }else{
							return "<input type='checkbox' name='suspected' />";
						}
		      		
		       }
         },{
        	 header:'补充说明',
             dataIndex:'addDescr',
             width:"8%",
             sortable: false,
             getEditor:function(record,defaultField ) {
            	 
            	 var diSN = record.get('diSn');
            	 if(/.*[\u4e00-\u9fa5]+.*$/.test(diSN)){
	            		diSN = '';
	            	}else{
	            		diSN = record.get('diSn');
	            	}
            	 
            	 if(diSN!='')
            		 return null;
            	 else{
            		 return Ext.create('Xap.ej.element.field.TextField');
            	 }
             }
         },{
        	 header:'诊断医生',
             dataIndex: 'diEmpNm',
             width:"8%",
             sortable: false
         },{
        	 text: '诊断日期',     
	         dataIndex: 'diTime',   
	         sortable: false,
	         renderer:function(value,metaData,record ){
	         	
	        	 if(value!=''){
						return Ext.Date.format(new Date(value),'Y/m/d');
					 }else{
						return '';
					}		
	          }
         },{
        	 header:'类别',
             dataIndex: 'setOwnerTypeCd',
             width:0,
             hidden:true,
             sortable: false 
         }]
	
    },
    plugins: [
	    {
	      ptype: 'cellediting',
	   	  clicksToEdit:1
	    }
    ],
    tools : [
		{
	 	   xtype:'xapbutton',
		   text:'↓',
		   action:'movedown'
	   },
	   {
	       xtype: 'tbspacer',        
	       width: 10
	   },
	   {
		   xtype:'xapbutton',
		   text:'↑',
		   action:'moveup' 
	   },
	   {
	       xtype: 'tbspacer',        
	       width: 10
	   },
	   /*{
		   xtype:'xapbutton',
		   text:'→',
		   action:'tochild'
	   },
	   {
	       xtype: 'tbspacer',        
	       width: 10
	   },
	   {
		   xtype:'xapbutton',
		   text:'←',
		   action:'toparent'
	   },*/
       {
	       xtype: 'tbspacer',        
	       width: 40
	   },
	   {
	 	   xtype:'xapbutton',
		   text:'插入',
		   action:'insertBtn',
		   iconCls: 'icon-Create',
		  
	   },
	   {
	       xtype: 'tbspacer',        
	       width: 10
	   },
	   {
		   xtype:'xapbutton',
		   text:'提交',
		   disabled:false,
		   action:'commitBtn',
		   iconCls: 'icon-OK',
	   },
	   {
	       xtype: 'tbspacer',        
	       width: 10
	   },
	   {
		   xtype:'xapbutton',
		   text:'删除',
		   disabled:false,
		   action:'deleteBtn',
		   id:'deleteBtn',
		   iconCls: 'icon-Delete',
	   }
     ]
});