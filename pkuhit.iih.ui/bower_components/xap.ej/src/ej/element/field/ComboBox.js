/** 
 *
 * 下拉列表
 * @extend: 'Ext.form.field.ComboBox'
 * @author：chenyajie<chen_yajie@founder.com>
 *
 *## example xapcombobox
 *     @example 
 *     xtype: 'xapcombobox',			
 *     dictionary: 'sex',			
 *     comboData: [			
 *          {"value":"1", "text":"男"},		
 *          {"value":"2", "text":"女"}		
 *     ]			
 *	
 *
 */
 

Ext.define('Xap.ej.element.field.ComboBox', {
	extend: 'Ext.form.field.ComboBox',
	alias: 'widget.xapcombobox',
	requires:[
		'Xap.ej.element.store.Store'
	],
	/** 
     * @cfg {String} 为该ComboBox指定字典类型。
     */ 
	dictionary: null,
	
	/** 
     * @cfg {String} 为该ComboBox指定默认值。
     */ 
	comboVal: null,
	
	/** 
     * @cfg {object} 指定本地数据集
	 * [
	 * {"value":"AL", "text":"Alabama"},
	 * {"value":"AZ", "text":"Arizona"}
	 * ]
     */ 
	comboData : [],
	
	/** 
     * @cfg {String} ComboBox加载本地数据
     */
	queryMode: 'local',
	/** 
     * @cfg {boolean} 全部选项
     */
	allOptions: false,
	/** 
     * @cfg {String} 相关的数据域名称绑定到ComboBox。
     */
	displayField: 'text',
	/** 
     * @cfg {String} 相关的数据值名称绑定到ComboBox。
     */
	valueField: 'value',
	/** 
     * @cfg {Boolean} 是否根据选择的单选框查询表格数据。
     */
	isGridQuery:false,
	
	initComponent: function() {
		//显示全部选项
		if(this.comboData&&this.allOptions){
			var allOption = {};
			allOption[this.displayField] = "全部";
			allOption[this.valueField] = "ALL";
			//console.log( Ext.Array.contains(Ext.Array.pluck(this.comboData,this.valueField),"ALL"));
			this.data = Ext.Array.clone(this.comboData);
			this.data.unshift(allOption);
			
		}else{
			this.data = Ext.Array.clone(this.comboData);
		}
		
		if(!this.store){
			//初始化Store
			this.initStore();
		};
		if(this.isGridQuery){
			this.on("change",this.comboBoxChange,this);
		}
        this.callParent(arguments);
		
        this.on("afterrender",this.after_render,this);
		
    },
	/** 
     * 初始化完成
     */ 
    after_render:function(boolean){
    	if(this.comboVal){
			this.value = this.comboVal;
		}
    },
	/** 
     * 如果只读时，设置样式为灰色
     */ 
    setReadOnly:function(boolean){
    	this.callParent(arguments);
		if(boolean){
			this.addCls("readOnlyCss");
		}else{
			this.removeCls("readOnlyCss");
		};
    },
	/** 
     * 触发表格查询事件
     */ 
    comboBoxChange:function(){
    	this.up('xapform').fireEvent("gridquery",this);
    },
	/**     
	* 初始化Store 
	* @param {object} [{},{}] 
	*/
	initStore:function(){
		var fields = [this.displayField,this.valueField];
		this.store = Ext.create('Xap.ej.element.store.Store', {
			fields: fields,
			data : this.data
		});
    },
	/**     
	* 选中第几个
	* @param {number} 
	*/
	selectAt:function(num){
		this.select(this.getStore().getAt(num));
    },
	/**     
	* 根据value选中
	* @param {string}
	*/
	selectByValue:function(val){
		this.select(this.getStore().findRecord(this.valueField,val));	
    },
	/**     
	* 给该ComboBox赋新值  
	* @param {object} [{},{}] 
	*/
	setData:function(data){
		if(this.allOptions){
			var allOption = {};
			allOption[this.displayField] = "全部";
			allOption[this.valueField] = "ALL";
			data.unshift(allOption);
		}
    	this.store.setData(data);
		if(this.comboVal){
			this.selectByValue(this.comboVal);
		}
    },
	/**     
	* 获得该ComboBox所有值  
	* @return {object} [{},{}] 
	*/
	getData:function(){
		var data=this.store.getData();
		if(this.allOptions){
			var redata=data.shift();
		}
    	return data;
    }
});