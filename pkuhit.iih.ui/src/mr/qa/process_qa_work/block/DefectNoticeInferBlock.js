Ext.define('iih.mr.qa.process_qa_work.block.DefectNoticeInferBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.defectnoticeinferblock',
	
	buttons:[{
            xtype: "button",
            name: 'send',
            method:'send',
            text: '确认',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],

	items: [{
//		title:'本次质控完成确认',
		xtype: 'xapform',
		name:'defectComplete',
		width:'100%',
//		border: 1,
		layout: {
			type: 'table',
			columns: 3,
			tableAttrs: {
	            border: 0,
	            cellpadding: 5,
	            cellspacing: 1,
	            width: '100%',
	            height:'100%'
	        },
	        tdAttrs: {
	            valign: 'left'
	        }
		},
		items:[{
			xtype: 'xaplabel',
			colspan : 3,
			style: {
    		fontSize:'20px'
			},
			margin:'0 300 0 300',
	    	labelAlign : 'center',
	    	text: '病历整改通知'
		},/*{
			xtype: 'xaptextfield',
	    	name:'curMngDctId',
	    	labelAlign : 'right',
	    	width:230,
	    	hidden:true,
	    	fieldLabel: '接收人编码'
		},{
			xtype: 'xaptextfield',
	    	name:'currentDeptCode',
	    	labelAlign : 'right',
	    	width:230,
	    	hidden:true,
	    	fieldLabel: '接收科室编码'
		},*/{
			xtype:'xaptextfield',
			name:'patientName',
			labelAlign : 'right',
			hidden:true,
			fieldLabel:'患者姓名后台传值'
		},/*{
			xtype: 'xapdisplayfield',
	    	name:'currentManageDoctorName',
	    	labelAlign : 'right',
	    	width:230,
	    	fieldLabel: '接收人'
		},{
			xtype: 'xapdisplayfield',
	    	name:'currentDeptName',
	    	labelAlign : 'right',
	    	width:230,
	    	fieldLabel: '接收科室'
		},*/{
			xtype:'xapdisplayfield',
			name:'patientName1',
			labelAlign : 'right',
			width:250,
			fieldLabel:'患者姓名'
		},{
			xtype: 'xapdisplayfield',
	    	name: 'excuteUserName',
	    	labelAlign : 'right',
	    	fieldLabel: '质控医师'
		},{
			xtype:'xapdisplayfield',
			name:'executeDeptName',
			labelAlign : 'right',
//               colspan:2,
			fieldLabel:'质控科室'
		},{
			xtype:'xapdisplayfield',
			name:'executeEndTime',
			labelAlign : 'right',
			fieldLabel:'通知时间',
			renderer: function(v){
				if(v){
				var times =	parseInt(v);
				v = new Date(times);
				return Ext.util.Format.date(v, 'Y-m-d H:i');
				}else{
					var currTime = new Date();
					return Ext.util.Format.date(currTime, 'Y-m-d H:i');
				}
				
			}
		},{
			xtype:'xapdisplayfield',
			name:'qaTypeName',
			labelAlign : 'right',
			fieldLabel:'质控类别'
		},{
        	   xtype:'xappanel',
        	   width:300,
        	   border:0,
        	   bodyPadding: 5,
        	   layout: 'column',
        	   defaultType: 'rangenumberfield',
        	   items: [{
        	        name: 'reformDeadline',
					method:'reformDeadline',
					fieldLabel:'整改期限',
					labelAlign : 'right',
					margin:'0 0 0 35',
//					width:200,
					value: 3,
					maxValue: 7,
					minValue: 1,
        	        columnWidth: 0.6,
        	        labelWidth:60
        	    },{
        	    	xtype:'xapdisplayfield',
        	        name: 'day',
        	        value:'天',
					margin:'0 0 0 5',
        	        columnWidth: 0.2
        	    }]
           },/*{
			xtype:'rangenumberfield',
			method:'reformDeadline',
			name:'reformDeadline',
			labelAlign : 'right',
			width:230,
			fieldLabel:'整改期限',
			value: 3,
			maxValue: 7,
			minValue: 1
		},{
    	    xtype:'xappanel',
    	    border:0,
    	    bodyPadding: 5,
    	    layout: 'column',
    	    defaultType: 'xapdisplayfield',
    	    items: [{
    	        name: 'day',
    	        value:'天',
    	        columnWidth: 0.65
    	    }]
       },*/{     
    	xtype : 'xapgridblock',
		name : 'faultinputgrid',
		colspan : 3,
		height:325,
		rownumShow:false,
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
		CM_JR_Record:[{
			header : '新质控项目编码',
			name: 'qaItmCd',
			dataIndex : 'qaItmCd',
			hidden:true
		},{
			header : '缺陷名称',
			name: 'req',
			dataIndex : 'req',
			flex:1
		},{
			header : '扣分标准',
			width:60,
			name: 'deductDes',
			dataIndex : 'deductDes'
		},{
			header : '缺陷次数',
			name: 'deductScrTimes',
			dataIndex : 'deductScrTimes',
			width:60
		},{
			header : '文档名称',
			name: 'mrName',
			dataIndex : 'mrName',
			width:180
		},{
			header : '接收人',
			name: 'rfmUserNm',
			dataIndex : 'rfmUserNm',
			width:80
		},{
			header : '接收科室',
			name: 'rfmDeptNm',
			dataIndex : 'rfmDeptNm',
			width:80
		}]
    },{
			xtype : 'xaptextarea',
			fieldLabel : '整改备注',
			colspan : 3,
			labelWidth:80,
			labelAlign : 'right',
			padding:'8 0 8 0',
			height:40,
			width: 700,
			name: 'reformMemo',
			dataIndex : 'reformMemo'
		}]
	}],

    setData : function(data) {
    	if(data){
    		var defectGrid = this.down('xapgridblock');
    		if(data.qaFaultList.dataList){
    			defectGrid.setData(data.qaFaultList.dataList);
    	    }else{
    	    	defectGrid.setData([]); //dataList为空时，置空
    	    }
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})