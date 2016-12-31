/** 
 * 报表查询条件
 * @author ：cheng_feng
 */

Ext.define('iih.mr.qa.qa_reports.block.ReportConditionBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [
           'Xap.ej.element.field.DateField',
           'Xap.ej.element.button.Button',
		   'Xap.ej.element.field.ComboBox',
           'Xap.ej.element.field.DisplayField'
	],

    alias:'widget.reportconditionblock', 
    
    layout: 'hbox',
    
    items: [
      	  {
      		xtype: 'xapdatefield',
      		width:260,
      		name:'beginTime',
      		fieldLabel:'归档时间',
      		labelAlign:'center',
      		dateFormate:'yyyy-MM-dd',//yyyy-MM-dd HH:mm:ss
      		margin:'10 20 0 30'
      	},{
      		xtype: 'xapdisplayfield',
      		name:'intervalSymbol',
      		width:20,
      		value:'~',
      		margin:'10 0 0 0'
      	},{
      		xtype: 'xapdatefield',
      		name:'endTime',
      		width:150,
      		dateFormate:'yyyy-MM-dd',
      		margin:'10 20 0 0'
      	},{
      		xtype: 'xapdisplayfield',
      		name:'paramType',
      		width:60,
      		value:'',
      		margin:'10 0 0 30'//上右下左
      	},{
      		xtype: 'xapcombobox',
      		name:'paramValue',
      		width:150, 
      		valueField:'code',
      		displayField:'name',
      		margin:'10 0 0 0'
      	},{
			xtype:'comboxgrid',
			url: 'organization/keyword',//科室查询的url
	        anchor: "90%",
			listWidth:210,    //gird的宽度
			width:200,        //combo的宽度
	        padding:'0 0 0 0',
	        margin:'10 20 0 10',
	        name: 'curDeptNm',
			dataIndex : 'curDeptNm',
	        method:'dept',
	        fieldLabel:'所属科室',
	        labelWidth : 60,
			labelAlign : 'right',
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
			columns: [{              //grid的column配置
			   text: '科室编码',
			   dataIndex: 'code',
			   width:60
			},{
			   text: '科室',
			   flex:1,
			   dataIndex: 'name'
			}],
			callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
			    console.log(newValue);     //本次选择的科室编码
			    console.log(oldValue);     //上次选择的科室编码
			    console.log(record);       //本次选择的科室完整记录
			}
		 },{
      		xtype: 'xapbutton',
      		width:50,
            name: 'openBios',
            method:'openBios',
      		text:'预览',
      		margin:'10 20 0 0'
      	}]
})