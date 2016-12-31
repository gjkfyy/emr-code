Ext.define('iih.mr.wr.mr_apply.block.MrApplyGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.mrapplygridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
		autoScroll:true,
		pageSize : 10,
		pageShow : true,
		tools:[{
            xtype: 'button',
            iconCls: 'icon-reset',
            text: '重置',
            action: 'reset',
            handler: function(view,rowIndex,colIndex,e,item ,record) {
				var owner = this.ownerCt.ownerCt.ownerCt.ownerCt;
				var topBlock = owner.getBlock('top');
				var form = topBlock.down('xapform');
				form.getForm().reset();
                var startDate = topBlock.down('xapdatefield[name=timeStart]');
                var endDate = topBlock.down('xapdatefield[name=timeEnd]');
                startDate.setValue(null);
                endDate.setValue(null);
                if(form.getForm().isValid()){
                    var chain = owner.getActionChain('init');
                    chain.execute();
                }
            }
        },{
            xtype: 'button',
            iconCls: 'icon-Search',
            text: '查询',
            action: 'search',
            handler: function(view,rowIndex,colIndex,e,item ,record) {
				var owner = this.ownerCt.ownerCt.ownerCt.ownerCt;
				var topBlock = owner.getBlock('top');
				var form = topBlock.down('xapform');
				if(form.getForm().isValid()){
                    var chain = owner.getActionChain('init');
                    chain.execute();
                }
			}
        },{
			xtype: 'button',
			text : '新增申请',
			method: 'addApply',
			iconCls: 'icon-Create',
			hidden:false,
			handler: function(view,rowIndex,colIndex,e,item ,record) {
				var owner = this.ownerCt.ownerCt.ownerCt.ownerCt;
				var addApplyChain = owner.getActionChain("popAddApply");
				addApplyChain.execute({
					data:record,
					btnName:'add'
				});
			}
		}],
		CM_JR_Record: [
		{ xtype:'xapactioncolumn',
				text:'操作',
				width: 88,
				align:'center',
				defectStore: null,
				items: [
					{
						text:'申请',
						getClass : function(v,m,record) {
							if(record.data.isMedicalWorkDept=="0"){//0-医务科，1-非医务科
								return 'x-hidden';
							}							
						},
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							if(record.data.isMedicalWorkDept=="1" && record.data.applyStatus =='MRM24.01' ){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
//							this.ownerCt.ownerCt.fireEvent('columnClick',record);
							var owner = this.ownerCt.ownerCt.ownerCt.ownerCt;
							var sendApplyChain = owner.getActionChain("popSendApply");
							sendApplyChain.execute({
								data:record,
								btnName:'send'
							});
						}
					},{
						text:'同意',
						getClass : function(v,m,record) {
							if(record.data.isMedicalWorkDept=="1"){
								return 'x-hidden';
							}							
						},
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							if(record.data.isMedicalWorkDept=="0" && record.data.applyStatus =='MRM24.02'){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
//							this.ownerCt.ownerCt.fireEvent('columnClick',record);
							var owner = this.ownerCt.ownerCt.ownerCt.ownerCt;
							var passApplyChain = owner.getActionChain("passApply");
							passApplyChain.execute({
								data:record,
								btnName:'pass'
							});
						}
					},{
						text:'驳回',
						getClass : function(v,m,record) {
							if(record.data.isMedicalWorkDept=="1"){
								return 'x-hidden';
							}							
						},
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							if(record.data.isMedicalWorkDept=="0" && record.data.applyStatus =='MRM24.02'){
								return false;
							}else{
								return true; 
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
//							this.ownerCt.ownerCt.fireEvent('columnClick',record);
							var owner = this.ownerCt.ownerCt.ownerCt.ownerCt;
							var refuseApplyChain = owner.getActionChain("refuseApply");
							refuseApplyChain.execute({
								data:record,
								btnName:'refuse'
							});
						}
					}
				]
			},
			{ header: '主键', dataIndex: 'applyCd',field: 'textfield',type: 'string',hidden:true },
            { header: '是否医务科', dataIndex: 'isMedicalWorkDept',field: 'textfield',type: 'string',hidden:true },
            { header: '状态编码', dataIndex: 'applyStatus',field: 'textfield',type: 'string',hidden:true },
            { header: '申请类型', dataIndex: 'applyTypeCd',field: 'textfield',type: 'string',hidden:true },
            { header: '患者姓名', dataIndex: 'paNm',field: 'textfield',type: 'string',width:60},
            { header: '就诊序号', dataIndex: 'enPk',field: 'textfield',type: 'string',width:60},
            { header: '病案号', dataIndex: 'armNo',field: 'textfield',type: 'string',width:100 },
            { header: '所在科室', dataIndex: 'curDeptNm',field: 'textfield',type: 'string',width:80 },
            { header: '申请医生', dataIndex: 'applyDctNm',field: 'textfield',type: 'string',width:80 },
            { header: '状态', dataIndex: 'applyStatusNm',field: 'textfield',type: 'string',width:60 },
            { header: '申请时间', dataIndex: 'applyTime', width:120, 
				field: {
					xtype: 'datetimefield'
				},
				renderer: function(v){
					if(v){
						v = new Date(v);
						return Ext.util.Format.date(v, 'Y-m-d H:i');
					}
					return v;
				}
			 },
            { header: '申请说明', dataIndex: 'applyDesc',field: 'textfield',type: 'string',width:150 },
            { header: '审批时间', dataIndex: 'approvalTime', width:120, 
				field: {
					xtype: 'datetimefield'
				},
				renderer: function(v){
					if(v){
						v = new Date(v);
						return Ext.util.Format.date(v, 'Y-m-d H:i');
					}
					return v;
				}
			 },
            { header: '审批人', dataIndex: 'approvalDctNm',field: 'textfield',type: 'string',width:60 },
            { header: '审批备注', dataIndex: 'memo',field: 'textfield',type: 'string',width:150 }
        ]
    }],
    setData: function(data) {
    	var grid = this.down('xapgrid');
    	if(grid){
    		if(data){
	    		var dataList = data.dataList;
	    		if(dataList){
			    	var totalList = {"total":data.total,"dataList":dataList};
			    	var pageSize = data.pageSize;
			    	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
			    		grid.setPageData(totalList);	//初始化赋值
			    	}else{
			    		grid.setData(dataList);	//翻页时赋值
			    	}
	        	}else{
	        		var totalList = {"total":data.total,"dataList":data.dataList};
	        		grid.setPageData(totalList);
	        	}
	    	}else{
	    		grid.setData([]);	
	    	}
    	}
	}  
})
