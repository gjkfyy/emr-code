Ext.define('iih.mr.dr.retrieval.block.DataRetrievalSearchBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.dataretrievalsearchblock',
	
	border: 0,

	items: [{
		xtype: 'xapform',
	layout: {
		type: 'table',
		columns: 5,
		tableAttrs: {
            border: 0,
            cellpadding: 1,
            cellspacing: 1,
            width: '100%',
            height:86
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items:[{
		xtype:'xaptextfield',
        name:'amrNo',
        labelWidth:60,
        labelAlign:'right',
        margin:'0 0 10 10',
        fieldLabel:'病案号'
	},{
		xtype:'xaptextfield',
        name:'amrNo',
        labelWidth:100,
        labelAlign:'right',
        margin:'0 0 10 10',
        fieldLabel:'患者姓名'
	},{
			xtype:'xapdatefield',
		    name:'crtTimeStart',
		    fieldLabel:'入院时间',
		    labelWidth:60,
		    labelAlign:'right',
			margin:'0 0 0 80'
		},{
			xtype: 'xapdisplayfield',
      		width:10,
      		value:'~'
		},{
			xtype:'xapdatefield',
			name:'crtTimeEnd',
			margin:'0 160 0 10',
			labelAlign:'right'
		},{
			xtype:'comboxgrid',
			margin:'0 0 10 10',
			name:'deptCd',
			method:'deptCd',
			url: 'organization/keyword',//科室查询的url
			fieldLabel:'所在科室',
        	labelAlign:'right',
			labelWidth : 60,
			listWidth:230,    //gird的宽度
			width:210,        //combo的宽度
			valueField : 'code',//科室编码的字段名
			displayField: 'name',//科室名称的字段名
			columns: [{              //grid的column配置
			   text: '科室编码',
			   dataIndex: 'code',
			   width:80
			},{
			   text: '科室',
			   flex:1,
			   dataIndex: 'name'
			}]
		},{
		xtype:'xaptextfield',
        name:'amrNo',
        labelWidth:100,
        labelAlign:'right',
        margin:'0 0 10 10',
        fieldLabel:'出院病情'
	},{
			xtype:'xapdatefield',
		    name:'crtTimeStart',
		    fieldLabel:'出院时间',
		    width:210,  
		    labelWidth:60,
		    labelAlign:'right',
			margin:'0 0 0 80'
		},{
			xtype: 'xapdisplayfield',
      		width:10,
      		value:'~'
		},{
			xtype:'xapdatefield',
			margin:'0 160 0 10',
			name:'crtTimeEnd',
			labelAlign:'right'
		}]
	}]
})