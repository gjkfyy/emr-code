/** 
 *
 * 表单
 * @extends Ext.form.Panel
 * @author ：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.form.Form', {
	extend: 'Ext.form.Panel',
	alias: 'widget.xapform',
	requires:[
		'Xap.ej.locale.Locale',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.field.ComboBoxGrid'
	],
	gridData:null,
	
	initComponent: function() {
		//初始化参数
		this.inti_param();
		//用于更改表单元素 让grid查询 by zhangdan
		this.on("gridquery",this.gridQuery,this);
		//初始化combo
        this.init_combo(this.items);
        this.callParent(arguments);
		//初始化后给combo赋值
		this.addListener('afterrender',this.set_combox_data);
    },
	/**     
	* 初始化combo
	*/
	init_combo:function(items){
		var me = this;
		Ext.each(items, function (item, index)
		{
			//是否主数据
			if(item.dictionary){
				//是否已存在comboboxs中
				if(me.comboboxs[item.dictionary]){
					items[index] = me.comboboxs[item.dictionary];
				}else{
				    var combo ;
					if('xapcombobox'==item.xtype){
						combo = Ext.create("Xap.ej.element.field.ComboBox", items[index]);
						me.comboboxs[item.dictionary] = combo;
					}else if('comboxgrid'==item.xtype){
						combo = Ext.create("Xap.ej.element.field.ComboBoxGrid", items[index]);
					}
					items[index] = combo;
				}
			}
		});
	},
	/**
	 * 给combobox赋值
	 */
	inti_param : function() {
		// 用于记录combobox
		this.comboboxs = {};
	},	
	/**
	 * 给combobox赋值
	 */
	set_combox_data : function() {
		var xapcomboboxs = this.query("xapcombobox");
		if(xapcomboboxs){
			this.fireEvent('comboxready',this.comboboxs);
		}
		/*var comboData = [ 
			{"value":"1","text":"佚名"},
			{"value":"2","text":"管理员"},
			{"value":"3","text":"编辑"},
			{"value":"4","text":"总编辑"},
			{"value":"5","text":"测试员"}
		];
		console.log('---************----');
		for (var combobox in this.comboboxs){
		console.log(combobox);
			this.comboboxs[combobox].setData(comboData);
		}*/
		
	},	
	/** 
     * 给form赋值
	 * @param {object} 
     */ 
    setData:function(data){
    	var me = this;
    	me.getForm( ).setValues(data);
    },
	/** 
     * 获取form值
	 * @return object 
     */ 
    getData:function(){
    	var me = this;
    	return me.getForm( ).getValues( );
    },
    /** 
     * 根据选择条件查询grid 
     */ 
    gridQuery:function(e){
    	var me = this;
    	//得到form中的值
    	var values = me.getValues();
    	//得到grid
    	var xapgrid = this.up('panel').down('xapgrid');
    	if(!this.gridData){
    		this.gridData = xapgrid.getData();
    	}
    	var newStore = Ext.Array.clone(this.gridData); 
    	Ext.Array.each(this.gridData,function(record, idx) {
    		for(var parm in values ){
    			if(values[parm]!=''){
	    			if(record[parm]!=values[parm]){
	    				Ext.Array.remove(newStore,record); 
	    			}
    			}	
    		}
        },me);
        xapgrid.setData(newStore);
    }
});

/*
 * 范围组件开始值验证
 */
Ext.apply(Ext.form.field.VTypes, {

	requires: ['Xap.ej.locale.Locale'],

	cStartValue: null,
	
	cStartField: null,
	
	startValueText: '开始值不能大于结束值',
	
	startValue: function(value, field) {
    	var me = this;
    	if (this.cStartValue == value && this.cStartField == field) return field.wasValid;
    	field.validateOnBlur = false;
    	this.cStartValue = value;
    	this.cStartField = field;

    	var flag = false;
		var startField = field.ownerCt.items.items[0];
		var endField = field.ownerCt.items.items[2];
    	if (!Ext.isDefined(startField.value) || startField.value == null) {
    		endField.setMinValue(null);
    		return flag;
    	}
		endField.setMinValue(field.value);
    	if (!Ext.isDefined(endField.value) || endField.value == null) return true;
    	if (field.fieldType == 'number') {
    		flag = field.value <= endField.value;
    	} else {
    		flag = field.value.getTime() <= endField.value.getTime();
    	}
    	if (flag) {
    		endField.clearInvalid();
    		endField.wasValid = true;
    	}
    	return flag;
    }
});

/*
 * 范围组件结束值验证
 */
Ext.apply(Ext.form.field.VTypes, {

	requires: ['Xap.ej.locale.Locale'],

	cEndValue: null,
	
	cEndField: null,
	
	endValueText: '结束值不能小于开始值',
	
	endValue: function(value, field) {
    	var me = this;
    	if (this.cEndValue == value && this.cEndField == field) return field.wasValid;
    	field.validateOnBlur = false;
    	this.cEndValue = value;
    	this.cEndField = field;
    	
    	var flag = false;
    	var startField = field.ownerCt.items.items[0];
    	var endField = field.ownerCt.items.items[2];
    	if (!Ext.isDefined(endField.value) || endField.value == null) {
    		startField.setMaxValue(null);
    		return flag;
    	}
    	startField.setMaxValue(field.value);
    	if (!Ext.isDefined(startField.value) || startField.value == null) return true;
    	if (field.fieldType == 'number') {
    		flag = field.value >= startField.value;
    	} else {
    		flag = field.value.getTime() >= startField.value.getTime();
    	}
		if (flag) {
			startField.clearInvalid();
			startField.wasValid = true;
		}
    	return flag;
    }
});