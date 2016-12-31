Ext.define('iih.mr.qa.qa_work_assistant.block.VitalSignHelperBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.grid.Grid'],
    alias:'widget.vitalsignhelperblock',

//    layout: 'fit',

    items: [/*{
        itemId: 'queryButton',
        xtype: 'button',
        height:20,
        width:60,
        margin:'1 0 1 880',
        text: '高级查询',
        handler : function() {
        	var block = this.up('assistantblock');
        	if(block == undefined){
        		var view = this.up().up();
        		var chain = view.getActionChain('searchwindowpopup');
                chain.execute();
        	}else{
        		var tab = block.down('xaptabpanel').getActiveTab();
            	if(tab){
            		var chain = tab.getActionChain('searchwindowpopup');
                    chain.execute();
            	}
        	}
        	       	
        }
    },*/{
        xtype: 'xapgrid',
//		checkboxShow:true,
        autoScroll:true,
        mode: "multi",
        //mode: "simple",
        showHeaderCheckbox:true,
        CM_JR_Record : [
            {header : '采集时间',dataIndex : 'acquisitionDate',/*hidden:true,*/field : 'textfield',type : 'string',flex : 1/*,hidden:true*/},
        	{header : '体温(℃)',dataIndex : 'temper',field : 'textfield',type : 'string',flex : 1},
        	{header : '脉搏(次/分)',dataIndex : 'pulse',field : 'textfield',type : 'string',flex : 2},
        	{header : '呼吸(次/分)',dataIndex : 'breathe',field : 'textfield',type : 'string',flex : 1},
        	{header : '收缩压(mmHg)',dataIndex : 'systolicPress',field : 'textfield',type : 'string',flex : 2},
        	{header : '舒张压(mmHg)',dataIndex : 'diastolicPress',field : 'textfield',type : 'string',flex : 1},
        	{header : '腹围',dataIndex : 'circumference',field : 'textfield',type : 'string',flex : 1},
        	{header : '血糖',dataIndex : 'bldSugar',field : 'textfield',type : 'string',flex : 1},
    	]/*,
    	gridData:{
			'results':[
				{ 'acquisitionDate': '系统管理员', "bodyTemperature":"20(℃)",'pulse':"20" ,'breathe':"30",'systolicPressure':"150",'diagstolicPressure':"200"}
			]
        }*/
    }],
    setData : function(data) {
        var grid = this.down('xapgrid');
        if(data.dataList!=null)
        {
	        for(var i=0;i<data.dataList.length;i++)
	        {
	        	tmpString = data.dataList[i].acquisitionDate;
	        	var newacquisitionDate ="";
	        	
	        	if(tmpString!=null&&tmpString!="")
	        	{
	        		newacquisitionDate = tmpString.substring(0,16);//取值到分钟
	        	}
	        	data.dataList[i].acquisitionDate = newacquisitionDate;
	        }
        }
        grid.setData(data.dataList);
        //alert("blocksetdata")
    }
});