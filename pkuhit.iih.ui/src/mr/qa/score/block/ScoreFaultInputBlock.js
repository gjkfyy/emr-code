/** 
 * 缺陷录入BLOCK
 * @extends Xap.ej.block.Block
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.score.block.ScoreFaultInputBlock',{
//	extend : 'Xap.ej.block.Block',
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.scorefaultinputblock',
    
    layout: {
		type: 'table',
		columns: 2,
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
        xtype:'xapcombobox',
        name:'qaItmFst',
        padding:'10 0 8 40',
        labelWidth:80,
        width:260,
        editable:false,
        allOptions: false,
        fieldLabel:'病案评分类别',
        queryMode: 'local',
        displayField: 'nm',
        valueField: 'fstCd'
    },{
        xtype:'xapcombobox',
        name:'qaItmSnd',
        labelWidth:60,
        width:260,
        value:'ALL',
        editable:false,
        allOptions: true,
        fieldLabel:'二级分类',
        queryMode: 'local',
        displayField: 'nm',
        valueField: 'sndCd'
    },{     
    	
    	xtype : 'xapgridblock',
		name : 'faultinputgrid',
		colspan : 2,
		height:320,
		rownumShow:true,
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
		 		
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
		},{
			header : '评分项目',
			name: 'req',
			dataIndex : 'req',
			width:400
		},{
			header : '扣分标准',
			width:100,
			dataIndex : 'deductDes',
			name: 'deductDes'
		},{
			header : '扣分次数',
			name: 'deductScrTimes',
			dataIndex : 'deductScrTimes',
			flex:1,
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
		}]
    },{
			xtype : 'xaptextarea',
			fieldLabel : '扣分说明',
			colspan : 2,
			labelWidth:80,
			labelAlign : 'right',
			padding:'10 0 8 10',
			height:40,
			width: 600,
			name: 'rfmDes',
			dataIndex : 'rfmDes'
		}]

})