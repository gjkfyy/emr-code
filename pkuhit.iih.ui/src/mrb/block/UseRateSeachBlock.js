Ext.define('iih.mrb.block.UseRateSeachBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: [],

    alias:'widget.userrateseachblock',
    
    layout : {
		type : 'table',
		columns : 8,
		// width: 1024,
		tableAttrs : {
			border : 0,
			cellpadding : 0,
			cellspacing : 1,
			width : '100%',
			height : 60
		},
		tdAttrs : {
			valign : 'left'
		}
	},
    overflowY: 'auto',
    
    border: false,
    
    items: [ {
		xtype : 'xapcombobox',
		name : 'useRateTypeCode',
		action : 'useRateTypeCode',
		colspan :2,
		padding : '10 50 10 50',
		labelWidth : 80,
		labelAlign : 'right',
		width : 200,
//		emptyText : '请选择查询类型',
		value:'doctorType',
		editable : false,
		allOptions : false,
		store : new Ext.data.ArrayStore({
			id : 0,
			fields : [ 'code', // numeric value is the key
			'name' ],
			data : [ [ 'doctorType', '医生' ], [ 'deptType', '科室' ], [ 'hosiptalType', '全院' ] ]
		// data is local
		}),
		fieldLabel : '统计对象',
		queryMode : 'local',
		displayField : 'name',
		valueField : 'code'
	},  {
		xtype : 'xapcombobox',
		name : 'enTypeCode',
		action : 'enTypeCode',
		colspan :2,
		padding : '10 50 10 50',
		labelWidth : 80,
		labelAlign : 'right',
		width : 200,
		//emptyText : '请选择就诊类型',
		value:'ALL',
		editable : false,
		allOptions : false,
		store : new Ext.data.ArrayStore({
			id : 0,
			fields : [ 'code', // numeric value is the key
			'name' ],
			data : [ [ 'ALL', '全部' ], [ 'ORGM02.05', '门诊' ], [ 'ORGM02.01', '住院' ], [ 'ORGM02.06', '急诊' ], [ 'ORGM02.07', '门/急诊' ], [ 'ORGM02.08', '门/急/住' ]  ]
		// data is local
		}),
		fieldLabel : '就诊类型',
		queryMode : 'local',
		displayField : 'name',
		valueField : 'code'

	},{
		xtype : 'xapcombobox',
		name : 'deptCodeList',
		action : 'deptCodeList',
		padding : '10 50 10 50',
		labelWidth : 80,
		width : 200,
		colspan : 2,
		value : 'ALL',
		editable : false,
		allOptions : true,
		labelAlign : 'right',
		fieldLabel : '科室名称',
//		queryMode : 'remote',
		displayField : 'name',
		valueField : 'code'
	}, {
		xtype : 'xapcombobox',
		name : 'doctorCodeList',
		padding : '10 50 10 50',
		labelWidth : 80,
		width : 200,
		colspan : 2,
		value : 'ALL',
		editable : false,
		allOptions : true,
		labelAlign : 'right',
		fieldLabel : '医生名称',
//		queryMode : 'remote',
		displayField : 'name',
		valueField : 'code'
	}, {
		xtype : 'xapdatefield',
		name : 'crtTimeStart',
		fieldLabel : '开始时间',
		width : 200,
		colspan : 2,
		labelWidth :80,
		margin : '10 50 10 50',
		labelAlign : 'right',
		editable : false,
		value : '',
	}, {
		fieldLabel : '结束时间',
		xtype : 'xapdatefield',
		name : 'crtTimeEnd',
		margin : '10 50 10 50',
		width : 200,
		colspan : 6,
		labelWidth : 80,
		labelAlign : 'right',
		editable : false,
		value : '',
	}]
})