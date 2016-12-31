Ext.define('iih.mr.kr.csm.block.CSMTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [
	           'Xap.ej.element.grid.Grid',
	           'Xap.ej.element.field.Radio',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.tree.FilterTree'
	           ],
	alias:'widget.csmtreeblock',
	border: 0,
    items:  [{
    	xtype:'xappanel',
    	border:0,
    	padding:'10 0 5 0',
    	layout: {
			type: 'table',
			columns: 3,
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
	    	 xtype:'xapradio',
	    	 boxLabel: '科室', 
	    	 action: 'ownerTypeDept', 
	    	 inputValue: 'MDM08.02',
	    	 name:'ownerType',
	    	 checked:true
	        
	    },{
	    	xtype: "xapcombobox",
			action:'dept',
			disabled:false
	    },{
	    	 xtype:'xapradio',
	    	 boxLabel: '个人', 
	    	 action: 'ownerTypePerson', 
	    	 inputValue: 'MDM08.03',
	    	 name:'ownerType',
	    	 
	    }]
    },/*{
    	xtype:'xappanel',
    	padding:'10 0 0 0',
    	border:0,
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
			fieldLabel: '组套分类',
			labelWidth:55,
			action:'krtype',
			emptyText:'分类1',
			value:'001',
			width:197,
			disabled:false
	    },{
	    	xtype: 'xapbutton',
			text: '查询',
			action: 'searchBtn',
	    }]
    },*/{
    	// xtype:'xaptree',
    	 xtype:'filtertree',
         action:'csmtree',
         border:0,
         flex: 1,
         rootVisible: false,
         collapsible: false,//是否可以折叠
		 split: true,
		 autoScroll: true,  //滚动条
		 height:510,
		 tbar:[{
		            xtype: 'trigger',
			        onTriggerClick: function () {
			            this.setValue('');
			            this.ownerCt.ownerCt.ownderCt.down("filtertree").clearFilter();
			        },
			        width:'100%',
			        //fieldLabel: '组套分类',
			        emptyText:'组套分类中文快速检索功能',
			        enableKeyEvents: true,
			        listeners: {
			            keyup: {
			                fn: function (field, e) {
			                    if (Ext.EventObject.ESC == e.getKey()) {
			                        field.onTriggerClick();
			                    } else {
			                        var filtercontent = Ext.util.Format.trim(this.getRawValue());
			                    	var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
							    	if(reg.test(filtercontent)){
							    		this.ownerCt.ownerCt.filterBy(filtercontent, 'text');
							    	}else {
							    		this.ownerCt.ownerCt.filterBy(filtercontent, 'code');
							    	}
			                    }
			                }
			            }
			        }
		    }]
    }],
    setData : function(data) {
    	var cstree = this.down('xaptree[action=csmtree]');
    	if(!data[0]){
    		cstree.getRootNode( ).removeAll();
    		return;    	
    	}
        var csmModels = [];
        for(var i in data){
        	var csmmodel = Ext.create('iih.mr.kr.csm.model.CSMModel',[])
        	var singleData = data[i];
        	if(singleData.children){
        		var child = singleData.children;
        		
        		for(j=0;j<child.length;j++){
        			//child[j]['text']=child[j].text;
        			child[j]['expand']='true';
        			child[j]['leaf']='true';
        			var testchildmodel = Ext.create('iih.mr.kr.csm.model.CSMModel',child[j]);
        			child[j] = testchildmodel;       		   
        		}   
        		
        		//singleData['text']=singleData.name;
        		singleData['expand']='true';
        		singleData['leaf']='false';
        		var testmodel = Ext.create('iih.mr.kr.csm.model.CSMModel',singleData);
        		csmModels.push(testmodel);
        		
        	}else{
        		
        		var testmodel = Ext.create('iih.mr.kr.csm.model.CSMModel',singleData);
				csmModels.push(testmodel);
        	}
        	
        }
        cstree.setData(csmModels);
    },
    
    removeData:function(){
    	var cstree = this.down('xaptree[action=csmtree]');
    	
        cstree.getRootNode( ).removeAll();
    	
    }
  
})
