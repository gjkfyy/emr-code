/** 
 * 缺陷录入BLOCK
 * @extends Xap.ej.block.Block
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.process_qa_work.block.FaultInputBlock',{
//	extend : 'Xap.ej.block.Block',
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.faultinputblock',
    
    layout: {
		type: 'table',
		columns: 4,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%'
//            height:76
        },
        tdAttrs: {
            valign: 'left'
        }
	},
    
    buttons:[{
            xtype: "button",
            name: 'save',
            action:'save',
            text: '确认',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            action:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],
    
    items:[{
		xtype: 'xapcheckbox',
		boxLabel : '',
		action: 'associateMr',
		name:'associateMr',
		disabled:false,
		padding:'10 0 8 10'
	},{
    	xtype:'xaptextfield',
		name:'mrTypeName',
		//labelAlign : 'left',
		fieldLabel:'当前文书',
		labelAlign : 'right',
		labelWidth:60,
		width:210,
		padding:'0 10 0 0'
    },{
        xtype:'xapcombobox',
        name:'qaItmFst',
        padding:'10 0 8 0',
        labelWidth:80,
        width:240,
        editable:false,
        allOptions: false,
        labelAlign : 'right',
        fieldLabel:'病案评分类别',
        queryMode: 'local',
        displayField: 'nm',
        valueField: 'fstCd'
    },{
        xtype:'xapcombobox',
        name:'qaItmSnd',
        labelWidth:60,
        width:230,
        value:'ALL',
        editable:false,
        allOptions: true,
        labelAlign : 'right',
        fieldLabel:'二级分类',
        queryMode: 'local',
        displayField: 'nm',
        valueField: 'sndCd'
    },{
    	xtype:'xaptextfield',
		name:'mrCreateUserCode',
		//labelAlign : 'left',
		fieldLabel:'起草人',
		labelWidth:60,
		width:200,
		hidden:true,
		padding:'0 10 0 0'
    },{
    	xtype:'xaptextfield',
		name:'mrCreateDeptCode',
		//labelAlign : 'left',
		fieldLabel:'起草科室',
		labelWidth:60,
		width:200,
		hidden:true,
		padding:'0 10 0 0'
    },{     
    	
    	xtype : 'xapgridblock',
		name : 'faultinputgrid',
//		title:'[入院记录]质控项目',
		colspan : 4,
		height:320,
		rownumShow:true,
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
//	    gridData:[
//		   			{ 'cs':1,'faultSelect': false,'onceDropScore':'xx' },
//		   			{ 'cs':1,'faultSelect': false,'onceDropScore':'tt' }
//		   			
//		   		],
		 		
		CM_JR_Record:[{
			header : '新质控项目编码',
			name: 'qaItmCd',
			dataIndex : 'qaItmCd',
			hidden:true
		},{
			header : '单次扣分值',
			name: 'onceDropScore',
			dataIndex : 'onceDropScore',
			hidden:true
		},{
			header : '累计最大扣分值',
			name: 'maxDropScore',
			dataIndex : 'maxDropScore',
			hidden:true
		},{
			header : '默认整改标志',
			name: 'defaultReformFlag',
			dataIndex : 'defaultReformFlag',
			hidden:true
		},{
			header : '自动质控标志',
			name: 'autoQaFlag',
			dataIndex : 'autoQaFlag',
			hidden:true
		},{
			header : '质控扣分类型名称',
			name: 'qaDropScoreTypeName',
			dataIndex : 'qaDropScoreTypeName',
			hidden:true
		},{
			header : '质控项目类型编码',
			name: 'qaItemTypeCode',
			dataIndex : 'qaItemTypeCode',
			hidden:true
		},{
			header : '质控扣分类型编码',
			name: 'qaDrpScrTpCd',
			dataIndex : 'qaDrpScrTpCd',
			hidden:true
		},/*{
			text : '',
			xtype:'xapcheckcolumn',
			name: 'faultSelect',
			dataIndex : 'faultSelect',
			width:30
			
		},*/{
			header : '评分项目',
			name: 'req',
			dataIndex : 'req',
			width:400
		},{
			header : '扣分标准',
			width:130,
			dataIndex : 'deductDes',
			name: 'deductDes'
		},{
			header : '扣分次数',
			name: 'deductScrTimes',
			dataIndex : 'deductScrTimes',
			flex:1,
			//width:110,
			getEditor:function(record,defaultField ) {
				//质控扣分类型编码为每次的都可编辑,默认值就是1
			   if(record.get('qaDrpScrTpCd')=='QAM02.02'){
				   return {
					   xtype:'rangenumberfield',
					   value: 1,
					   maxValue: 10,
					   minValue: 1,
					   listeners:{
							 change:function(me,newVal,oldVal,eOpts ){
								  var val = me.getValue();
								  var faultGrid = me.up('xapgrid');
								  var selModel=faultGrid.getSelectionModel();
							 	  var record=selModel.getSelection()[0];
								  record.set('deductScrTimes',val);
								  record.set('faultSelect',true);
							 }
					   }
				 };
				  
			   }else{
				   return null;
			   }
	          
            }
		},{header: '自动质控标识',dataIndex: 'autoQaF',name:'autoQaF',width:100,
         	renderer:function(value,metaData,record){
		        if(value ==  "1"){
		        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
		        }else{
		        	return null;
		        }
			}
		}]
    },{
			xtype : 'xaptextarea',
			fieldLabel : '整改说明',
			colspan : 3,
			labelWidth:60,
			labelAlign : 'right',
			padding:'10 0 8 10',
			height:40,
			width: 560,
			name: 'rfmDes',
			dataIndex : 'rfmDes'
		},{
	        xtype:'xapcombobox',
	        name:'rfmUser',
	        margin:'10 0 30 0',
	        labelAlign : 'right',
	        vAlign:'top',
	        labelWidth:60,
	        hidden:!(CONFIG_PARAM.QA_RFMUSER_SELECT && iih.mr.qa.QaStatusGlobal.isNurseRole),
	        editable:false,
	        multiSelect : false, //多选
	        fieldLabel:'整改人',
	        queryMode: 'local',
	        displayField: 'name',
	        valueField: 'employeeId'
	    }]

})