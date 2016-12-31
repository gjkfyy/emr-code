/** 
 *
 * 联想多列下拉框，选中下拉框值时会触发combochange带newValue, oldValue, 和recordData参数;并执行callback函数。
 * @extend: 'Ext.form.field.ComboBox'
 * @author：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.field.ComboBoxGrid', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.comboxgrid',
	requires:[
		'Xap.ej.element.store.Store',
		'Xap.ej.action.IntelligentInputAction'
	],
	/** 
     * @cfg {String} 为该ComboBox指定字典类型。
     */ 
	dictionary: null,
	url: null,
	gridPageSize: 20,
	//是否可编辑
	editable : this.editable||true,
	//ComboBox加载数据方式
	queryMode : 'local',
    //放置到空表单项中的默认文本
    emptyText : this.emptyText||"请输入",
    allowBlank : this.allowBlank||true,
    //如果 allowBlank 校验失败时需要显示的出错信息
    blankText : this.blankText||"必须输入!",
    //当触发器被点击时需要执行的操作。 
    triggerAction : 'all',
	width : 150,
	//联想结果宽度
	listWidth : null,
    displayField : 'text',
    valueField : 'value',
	//点击行数据
	comboRecord : null,
    //隐藏值 只有被展开并选定值时才重置该值
    comboxHiddenValue : null,
	//失去焦点时 赋值
	blurSetValue : false,
	//combo父组件 如果指定 让该父组件抛出事件
    parentXtype : null,
    //查询的字段 默认按照displayField 如果不是searchParam : ['',''],
    searchParam : null,
    tpl : '',
    grid: null,
    //默认显示grid表头
    hideHeaders : false,
    columns: [],
	//键盘监听启用
	enableKeyEvents : true ,
	//设置键按起时进行查询
	listEmptyText: true ,
	//第一次时，先有'steel-id' DOM 再render render以后改为false
	first : true ,
	//用于本地setData
	comboData : null,
	//下拉选择器(picker)的宽度是否要准确地和表单项的宽度一致。默认值是true。
	matchFieldWidth : false,
    
    onSelect : Ext.emptyFn,
	initComponent : function() {
		var me = this;
		//初始化Store 
		this.store = Ext.create('Xap.ej.element.store.Store', {
			fields: [],
			data : [[]]
		});
		
		this.tpl = "<tpl for='.'><div id='steel-"+this.getId()+"'></div></tpl>";
		
		
		//初始化grid
		this.init_grid();
		//如果单列显示结果信息 宽度跟下拉框对齐
		if(me.hideHeaders||!this.listWidth){
			me.matchFieldWidth = true;
		}
		//监听展开事件
		this.on('expand',this.expandEvent,this);
		//监听键盘按下
		this.on('keydown',this.keydownEvent,this);
		this.on('keyup',this.keyup,this);
		//监听change事件
		this.on('change',this.changeEvent,this);
		//监听失去焦点事件
		this.on('blur',this.blurEvent,this);
		this.callParent(arguments);
	},
	/**     
	* 初始化grid
	*/
	init_grid: function() {
		var me = this;
		this.grid = Ext.create('Xap.ej.element.grid.Grid', {
			height : 200,
        	searchBar: true,
        	checkBox : false,
			pageComboxButton: false,
			//分页条的刷新按钮是否显示 
			pageRefreshButton : false,
			hideHeaders : me.hideHeaders,
			gridData : me.gridData,
			CM_JR_Record:me.columns
		});
		//如果非单列显示结果信息 宽度按指定宽度
		if(!me.hideHeaders){
			this.grid.width = me.listWidth;
		}
		//给grid注册rowclick事件
        this.grid.on('itemclick', me.grid_itemclick,this);
		//给grid注册cellkeydown事件
        this.grid.on('cellkeydown', me.grid_cellkeydown,this);
	},
	/**     
	* 给grid注册rowclick事件
	*/
	grid_cellkeydown: function(grid, td, cellIndex, record, tr, rowIndex, e, eOpts) {
		var me = this;
		//处理回车按键 让combox选择选中数据
		if('13'==e.getKey()){
			this.combox_select(record,rowIndex);
		}
	},
	/**     
	* 给grid注册rowclick事件
	*/
	grid_itemclick: function(grid,record,item, rowIndex, e) {
		var me = this;
		this.combox_select(record,rowIndex);
	},
	/**     
	* 让combox选择选中数据
	*/
	combox_select: function(record,rowIndex) {
		var me = this;
		if(me.fireEvent('beforeselect', me, record, rowIndex) !== false){
			me.collapse();
			//me.fireEvent('select', me, record, rowIndex);
			me.callback(record.data[me.valueField],me.comboxHiddenValue,record.raw);
			me.setRecordData(record.data);
		}
	},
	
	/**     
	* 得到选中的值
	*/
	getValue: function() {
		return this.comboxHiddenValue;
	},
	getSubmitValue: function() {
		return this.comboxHiddenValue;
	},
	reset: function() {
		var record = {};
		record[this.valueField] = '';
		record[this.displayField] = '';
		this.setRecordData(record);
	},
    /**     
	* overwrite 
	* 
	*/
	doQuery: function(q, forceAll) {
		//判断是否已展开
    	if(this.isExpanded){
    		this.collapse();
    	}
        this.expand();
		//第一次时，先有'steel-id' DOM 再render
		if(this.first){
			this.grid.render('steel-'+this.getId());
			//判断是否已展开
			if(this.isExpanded){
				this.collapse();
			}
			this.expand();
			this.first = false;
		}
		
	},
	
	/**     
	* 监听展开事件 执行的方法
	* 
	*/
	expandEvent : function(){
		//如果本地setData
		if(this.comboData){
			this.grid.setData(this.comboData);
		};
		var me = this;
		var component = this.getGrid();
		if(!this.getRawValue() && this.getData().length==0){
			if(this.dictionary){
				var searchObject={
					dictionary: this.dictionary,
					searchParam: this.searchParam||[this.displayField],
					searchValue: this.getRawValue()
				};
				if(this.parentXtype){
					this.up(this.parentXtype).fireEvent('combochange',searchObject,this);
				}
			}else{
				var chain = this.getChain();
				var param = {
					'pageSize': this.gridPageSize
				};
				Ext.apply(param,this.searchParam||{});
				chain.execute({
					operations: [],
					params: [param],
					url: this.url,
					callback: function(data) {
						if(data) {
							component.setData(data);
						}
					}
				});
			}
		}
	},
	
	/**     
	* 监听按键 执行的方法
	*/
	keydownEvent : function(me,e){
		//监听按下40键 自动选中第一行
		this.submitQuery = false;
		if(e.getKey()==40){
			var count = this.grid.getStore().getCount();
			if(count>0){
				this.grid.selectFirstRange();
			}
		}
	},
	/**     
	* 监听按键 执行的方法
	*/
	keyup : function(){
		var me = this;
		//如果文本框时，全部值，制空
		if(!this.getRawValue()){
			this.reset();
		}
		if(this.dictionary){
			var searchObject={
				dictionary: this.dictionary,
				searchParam: this.searchParam||[this.displayField],
				searchValue: this.getRawValue()
			};
			if(this.parentXtype){
				this.up(this.parentXtype).fireEvent('combochange',searchObject,this);
			}
		}else{
			this.submitQuery = true;
			setTimeout(function(){
				me.submit();
			},500);
		}
		this.fireEvent('combochange',this);
	},
	
	/**     
	* 监听change事件 执行的方法
	*/
	changeEvent : function( v, newValue, oldValue, eOpts ){
		/*var searchObject={
			dictionary: this.dictionary,
			searchParam: [this.displayField],
			searchValue: this.getRawValue()
		}*/
		//this.fireEvent('inputchange',searchObject);
		//this.fireEvent('combochange',newValue,oldValue,this.getRecord().data,searchObject);
		//this.callback(newValue,oldValue,this.getRecord().data);
		
	},
	
	/**     
	* 监听失去焦点事件 执行的方法
	*/
	blurEvent : function(combo, the, eOpts){
		if(this.blurSetValue){
			combo.comboxHiddenValue = combo.getRawValue();
		}
	},
	
	/**     
	* 得到该grid
	* 
	* @return grid 
	*/
	getGrid : function(){
		return this.grid;
	},
	
	/**     
	* 给该combo赋新值  
	* @param {data} [{},{}] 
	*/
	setData : function(data){
		this.comboData = data;
		this.doQuery();
		this.expand();
	},
	/**     
	* 获取该combo 数据 
	* @param {data} [{},{}] 
	*/
	getData : function(){
		var data = [];
		if(this.getGrid().getData()){
			data = this.getGrid().getData();
		}
		
		return data;
	},
	/**     
	* 该combo改变值后 回调函数 
	* @param {newValue} 
	*/
	callback : function(newValue,oldValue,record){
		
	},
	
	/**     
	* 得到选中行的Record，隐藏值也可以从这里取。
	* export JAVA_LIBRARY_PATH=$HADOOP_HOME/lib/native
	* @return Record 
	*/
	getRecord : function(){
		return this.comboRecord;
	},
	/**     
	* 给该combo赋新Record值  
	* @param {Object} {} 
	*/
	setRecordData : function(record){
		this.comboRecord = record;
		this.comboxHiddenValue = record[this.valueField];
		this.setRawValue(record[this.displayField]);
	},	
	/**     
	* 给该combo赋新值  
	* @param {String}  
	*/
	setValue : function(v){
		//this.callParent(arguments);
        //this.value = v;
		var me = this;
		var component = this.getGrid();
		if(v){
			var chain = this.getChain();
			var param = {
				'id': v
			};
			chain.execute({
				operations: [],
				params: [param],
				url: this.url,
				callback: function(data) {
					if(data && data.length > 0) {
						me.setRecordData(data[0]);
						component.setData(data);
					}
				}
			});
		}
		//this.fireEvent('combochange',this);
        return this;
    },
	
	submit: function() {
		if(this.submitQuery){
			var me = this;
			var component = this.getGrid();
			var chain = this.getChain();
			var param = {
				'keyword': this.getRawValue(),
				'pageSize': this.gridPageSize
			};
			Ext.apply(param,this.searchParam||{});
			chain.execute({
				operations: [],
				params: [param],
				url: this.url,
				callback: function(data) {
					if(data) {
						component.setData(data);
						if(data.length==1)
							me.setRecordData(data[0]);
					}
				}
			});
		}
	},

	getChain: function() {
		if(!this.chain) {
			// TODO 构造函数创建
			this.chain = Xap.create({
				xclass: 'Xap.ej.action.Chain'
			});
			var action = Xap.create({
				xclass: 'Xap.ej.action.IntelligentInputAction'
			});
			this.chain.addAction(action);
		}
		return this.chain;
	}
});