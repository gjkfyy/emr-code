Ext.define('iih.mrb.block.MrbPatientListBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [],

	alias : 'widget.mrbpatientlistblock',

	border : 0,

	layout : {
		type : 'table',
		columns : 9,
		// width: 1024,
		tableAttrs : {
			border : 0,
			cellpadding : 0,
			cellspacing : 1,
			width : '100%',
			height : 80
		},
		tdAttrs : {
			valign : 'left'
		}
	},
	items : [ {
		xtype : 'xapcombobox',
		name : 'enTypeCode',
		action : 'enTypeCode',
		colspan :2,
		padding : '10 50 10 50',
		labelWidth : 80,
		labelAlign : 'right',
		width : 200,
		emptyText : '请选择就诊类型',
		editable : false,
		allOptions : false,
		store : new Ext.data.ArrayStore({
			id : 0,
			fields : [ 'code', // numeric value is the key
			'name' ],
			data : [ [ 'ALL', '全部' ], [ 'ORGM02.05', '门/急诊' ], [ 'ORGM02.01', '住院' ] ]
		// data is local
		}),
		fieldLabel : '就诊类型',
		queryMode : 'local',
		displayField : 'name',
		valueField : 'code'
	}, {
		xtype : 'comboxgrid',
		name : 'curDeptNm',
		colspan :2,
		method : 'curDeptNm',
		url : 'organization/keyword',// 科室查询的url
		fieldLabel : '科室',
		margin : '10 85 10 0',
		labelAlign : 'right',
		labelWidth : 80,
		listWidth : 230, // gird的宽度
		width : 200, // combo的宽度
		valueField : 'code',// 科室编码的字段名
		displayField : 'name',// 科室名称的字段名
		columns : [ { // grid的column配置
			text : '科室编码',
			dataIndex : 'code',
			width : 80
		}, {
			text : '科室',
			flex : 1,
			dataIndex : 'name'
		} ],
		listeners : {
			specialkey : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					var view = this.up('searchpatientencountview');

					var initChain = view.getActionChain('search');
					initChain.execute({});
				}
			}
		},
		callback : function(newValue, oldValue, record) { // 在grid选择记录后的回调函数
			var view = Ext.getCmp('searchpatientencountview');
			console.log('view');
			console.log(view);
			var initChain = view.getActionChain('searchDoctorByDeptList');
			initChain.execute({
				'newValue' : newValue
			});
		}
	}, {
		xtype : 'xapcombobox',
		name : 'doctorCodeList',
		padding : '10 0 0 0',
		labelWidth : 80,
		width : 200,
		colspan : 3,
		//queryMode : 'remote',
		value : 'ALL',
		editable : false,
		allOptions : true,
		labelAlign : 'right',
		fieldLabel : '医生名称',
		displayField : 'name',
		valueField : 'code'
	}, {
		xtype : 'xaptextfield',
		name : 'mobile',
		colspan : 2,
		fieldLabel : '手机号码',
		width : 200,
		labelWidth : 80,
		listeners : {
			specialkey : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					var view = this.up('searchpatientencountview');
					var chain = view.getActionChain('search');
					chain.execute({});
				}
			}
		}
	} , {
		xtype : 'xapcombobox',
		name : 'enCardTypeCode',
		action : 'enCardTypeCode',
		colspan : 3,
		padding : '10 0 0 15',
		labelWidth : 80,
		width : 180,
		labelAlign : 'right',
		editable : false,
		hidden : true,
		allOptions : false,
		value : "ALL",
		store : new Ext.data.ArrayStore({
			id : 0,
			fields : [ 'code', // numeric value is the key
			'name' ],
			data : [ [ 'ALL', '全部' ], [ '01', '普通号' ], [ '02', '专家号' ] ]
		// data is local
		}),
		fieldLabel : '就诊号别',
		queryMode : 'local',
		displayField : 'name',
		valueField : 'code'
	}, {
		xtype : 'xaptextfield',
		name : 'patientName',
		width : 200,
		labelWidth : 80,
		colspan : 2,
		queryMode : 'local',
		margin : '10 50 10 50',
		fieldLabel : '患者姓名',
		listeners : {
			specialkey : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					var view = this.up('searchpatientencountview');
					var initChain = view.getActionChain('search');
					initChain.execute({});
				}
			}
		}
	}, {
		xtype : 'xapdatefield',
		name : 'crtTimeStart',
		fieldLabel : '开始时间',
		width : 200,
		colspan : 2,
		labelWidth :80,
		margin : '10 15 10 40',
		labelAlign : 'right',
		editable : false,
		value : '',
		margin : '10 0 10 0'
	}, {
		fieldLabel : '结束时间',
		xtype : 'xapdatefield',
		name : 'crtTimeEnd',
		margin : '10 15 10 0',
		width : 200,
		colspan : 2,
		labelWidth : 80,
		labelAlign : 'right',
		editable : false,
		value : '',
	}, {
		xtype : 'radiogroup',
		margin : '10 50 10 30',
		colspan :5,
		name : 'checkArchive',
		vertical : true,
		fieldLabel : '出院',
		labelAlign : 'right',
		labelWidth : 40,
		items : [ {
			boxLabel : '未归档',
			name : 'checkArchive',
			inputValue : 'MRM22.06',
			checked : true,
			width : 60
		}, {
			boxLabel : '已归档',
			name : 'checkArchive',
			inputValue : 'MRM22.07',
			width : 60
		} ]
	}

	, {
		fieldLabel : '查号类型',
		xtype : 'xapcombobox',
		name : 'conditionTypeCode',
		action : 'conditionTypeCode',
		colspan :2,
		padding : '10 90 10 50',
		labelWidth : 80,
		width : 200,
		value : "icdCard",
		labelAlign : 'right',
		editable : false,
		allOptions : false,
		store : new Ext.data.ArrayStore({
			id : 0,
			fields : [ 'code', // numeric value is the key
			'name' ],
			data : [ [ 'icdCard', '身份证号' ], [ 'amrNo', '就诊/住院号' ], [ 'paId', '患者Id' ] ]
		// data is local\

		}),
		queryMode : 'local',
		displayField : 'name',
		valueField : 'code'
	}

	, {
		fieldLabel : '唯一号',
		xtype : 'xaptextfield',
		width : 200,
		name : 'conditionCode',
		labelWidth : 80,
		colspan : 2,
		labelAlign : 'right',
		margin : '10 0 10 0',
		listeners : {
			specialkey : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					var view = this.up('searchpatientencountview');
					var initChain = view.getActionChain('search');
					initChain.execute({});
				}
			}
		}
	},{
        xtype:'xapcombobox',
        name:'mrTypes',
        margin:'10 0 10 0',
        colspan : 2,
        labelWidth : 80,
        labelAlign : 'right',
        editable:false,
        multiSelect : true, //多选
        fieldLabel:'文书类型',
        queryMode: 'local',
        displayField: 'name',
        valueField: 'code',
        id:"mrTypesTip"
    }],
    initComponent: function() {
        this.callParent(arguments);
    	//当指定控件有显示不全时，自动出现tip提示
    	this.addListener('afterrender',this.tip);
    },
	tip : function(){
		Ext.create('Ext.tip.ToolTip', {
	        target: 'mrTypesTip',
	        anchor: 'buttom',
	        anchorOffset: 30,
	        trackMouse: true,
	    	listeners: {
				beforeshow: function updateTipBody(tip) {
					var textTip = Ext.getCmp('mrTypesTip');
					var value = textTip.rawValue;
					tip.update(value);				
				}
			}
	      
	    });
	}
});