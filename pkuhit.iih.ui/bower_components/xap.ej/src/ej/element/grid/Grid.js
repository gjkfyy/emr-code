
/** 
* @class Xap.ej.element.grid.Grid
* @extends Ext.grid.Panel 
* @author ：chenyajie<chen_yajie@founder.com>
* 该面板为Ext.grid.Panel派生而来，因此可以传入所有符合Ext.grid.Panel的配置选项和方法
*
*## example xapGrid
*
*     @example
*      Ext.create('Ext.panel.Panel', {
*         title: 'Panel',
*         items: [{
*           xtype: 'xapGrid',
*			url: '',// 本地数据用gridData
*      		CM_JR_Record: [
*      			{ header: '姓名',  dataIndex: 'name', field: 'textfield' ,     type: 'string'},
* 	     		{ header: 'Email', dataIndex: 'email', flex: 1,     type: 'string',
* 	     			field: {
* 	     				xtype: 'textfield',
* 		     			vtype: 'email',
* 		     			allowBlank: false
* 		     		}
* 	     		},
* 	     		{ header: 'Phone', dataIndex: 'phone',     type: 'string' }
* 	     	]
*         }],
*          renderTo: Ext.getBody()
*      });
* 
*/ 


Ext.define('Xap.ej.element.grid.Grid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.xapgrid',
	requires:[
		'Xap.ej.element.store.Store',
		'Xap.ej.element.field.ComboBox',
		'Xap.ej.element.field.ComboBoxGrid'
	],
	/** 
     * @cfg {String} 为该grid指定id，默认'xapGridId'。
     */ 
	xapId : 'xapGridId',
	/** 
     * @cfg {boolean} 'true'使用溢出：'自动'的组件布局元素，并在必要时自动显示滚动条， 'false'溢出的内容。
     */ 
	autoScroll : true,
	/** 
     * @cfg {String} 为该grid指定url,数据将根据url远程获取。
     */ 
	url : null,
	/**
	 * @cfg {object} 
	 *  记录行id
	 */
	nodeId: null,
	 
	/**
	 * @cfg {string} 
	 *  根据行id选中行
	 */
	selectBy: 'id',	
	/**
	 * @cfg {string} 
	 *  multi,simple,single；默认为单选single
	 */
	mode: 'single',
	/**
	 * @cfg {boolean} 
	 *  如果值为true，则只用点击checkbox列才能选中此条记录
	 */
	checkOnly: false,
	/**
	 * @cfg {boolean} 
	 *  编辑时保持选中状态 false: 不保持
	 */
	isEditKeepSelect: true,
	/**
	 * @cfg {number} 
	 *  每页显示行数
	 */
	pageSize : 10,
	/**
	 * @cfg {number} 
	 *  总页码
	 */
	pageCount : 0,
	/**
	 * @cfg {number} 
	 *  当前页码
	 */
	currentPage : 1,
	/**
	 * @cfg {boolean} 
	 *  是否setData后选中行
	 */
	ifSelect: true,
	/** 
     * @cfg {boolean} 是否显示分页 false 不显示
     */ 
	pageShow : false,
	/** 
     * @cfg {boolean} 是否显示复选框
     */ 
	checkboxShow : false,
	/** 
     * @cfg {boolean} 是否显示全选复选框
     */ 
	showHeaderCheckbox : true,
	/** 
     * @cfg {boolean} 自动生成数字，为每行提供编号的列。 是否显示 false: 不显示
     */ 
	rownumShow : true,
	
	/** 
     * @cfg {String} 为该grid指定本地数据 total总条数 dataList结果集
	 * {'total':4,'dataList':[
	 * { 'name': 'Lisa',  "email":"lisa@simpsons.com",  "personNumber":"555-111-1"  },
	 * { 'name': 'Bart',  "email":"bart@simpsons.com",  "personNumber":"555-222-2" },
	 * { 'name': 'Homer', "email":"home@simpsons.com",  "personNumber":"555-222-3"  },
	 * { 'name': 'Marge', "email":"marge@simpsons.com", "personNumber":"555-222-4"  }
	 * ]}
     */ 
	gridData : null,
	
	/** 
     * @cfg {String} modle
     */
	ModleClass : null,
	
	/** 
     * @cfg {Object} 用于创建Modle和store
     */
	CM_JR_Record : null,
	
	/** 
     * @cfg {Object} 顶部按钮
     */
	topButton : [],
	
	initComponent: function() {
		//this.tbar = this.tools;
		//this.tools = this.tbar;
		//this.tbar = null;
		//初始化参数
		this.inti_param();	
		//初始化列表栏
		if (this.CM_JR_Record) {
			this.init_SM_CM_DS();
		}
		//初始化复选框
		if (this.checkboxShow) {
			this.init_selModel();
		}
		//初始化右键菜单
		this.addListener('itemcontextmenu',this.bandContextMenu);
		//单元格点击事件
		this.addListener('cellclick',this.cell_click);
		//行点击事件
		this.addListener('itemclick',this.item_click);
		//用于右键菜单
		this.topButton = this.tbar;
        this.callParent(arguments);
		//初始化后给combo赋值
		this.addListener('afterrender',this.set_combox_data);
		//当列有显示不全时，自动出现tip提示
		this.addListener('afterrender',this.show_cell_toolTip);
    },
	/**     
     * 根据行id选中行
	 * @param {String} 
	 */
	selectById:function(nodeId){
		if(nodeId){
			var r = this.getStore().find( this.selectBy, nodeId, 0, false, true, true );
			this.getSelectionModel( ).select(r);
		}
		
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
		this.fireEvent('comboxready',this.comboboxs);
		  /** 
		var comboData = [ 
			{"value":"1","text":"佚名"},
			{"value":"2","text":"管理员"},
			{"value":"3","text":"编辑"},
			{"value":"4","text":"总编辑"},
			{"value":"5","text":"测试员"}
		];
		
		
		if(this.comboboxs.combo){
			this.comboboxs.combo.setData(comboData);
		}
		if(this.comboboxs.myname){
			this.comboboxs.myname.setData(comboData);
		}
		if(this.comboboxs.QAM01){
		console.log(this.comboboxs);
		this.down('xapcombobox[t_dictionary=QAM01]').setData(this.comboboxs.QAM01.getData());
			//this.comboboxs.QAM01.setData(comboData);
		}
		
		var gridData =[
			{ 'xname': 'Lisa', 'name': '1', 'myname': '2',  "email":"lisa@simpsons.com",  "personNumber":"555-111-1"  },
			{ 'xname': 'Lisa','name': '2', 'myname': '3',  "email":"bart@simpsons.com",  "personNumber":"555-222-2" },
			{ 'xname': 'Lisa','name': '3', 'myname': '2',  "email":"bart@simpsons.com",  "personNumber":"555-222-2" },
			{ 'xname': 'Lisa','name': '4', 'myname': '1', "email":"marge@simpsons.com", "personNumber":"555-222-4"  }
		];
		this.setData(gridData);
		*/
	},
	
	/**
	 * 自动出现tip提示
	 */
	show_cell_toolTip : function() {
		var view = this.getView();
		this._toolTip = Ext.create('Ext.tip.ToolTip', {
			target: view.getEl(),
			delegate: '.x-grid-cell',
			trackMouse: true,
			renderTo: Ext.getBody(),
			listeners: {
				beforeshow: function updateTipBody(tip) {
					var td = tip.triggerElement;
					var tr = td.parentElement;
					var index = Ext.fly(tr).query('.x-grid-cell').indexOf(td);
					if(!view.ownerCt)return false;
					var column = view.getHeaderAtIndex(index);
					var width = column.getWidth();
					var measure = Ext.util.TextMetrics.measure(td, Ext.fly(td).getHTML());
					if(column.isCheckerHd)return false;
					if (column.xtype == 'xapdatecolumn' && measure.width >= width) {
						var record = view.getRecord(tr);
						var value = record.get(column.dataIndex);
						value = new Date(value);
						tip.update(Ext.util.Format.date(value, 'Y-m-d H:i'));
					}else if (measure.width >= width) {
						var record = view.getRecord(tr);
						tip.update(record.get(column.dataIndex));
					}else {
						return false;
					}
				}
			}
		});
	},

	/**     
	* 初始化复选框
	*/
	init_selModel:function(colButton){
		var me = this;
		this.selModel = Ext.create('Ext.selection.CheckboxModel', {
			showHeaderCheckbox : this.showHeaderCheckbox,
			injectCheckbox : 1,
			mode:me.mode,//multi,simple,single；默认为多选multi
			checkOnly:me.checkOnly//如果值为true，则只用点击checkbox列才能选中此条记录
		});
    },
	/**     
	* 行点击事件
	*/
	item_click:function(view, record,item,index,e,eOpts){
		//记录点击行的id
		this.nodeId = record.data[this.selectBy];
		//如果编辑时保持选中状态
		if(this.isEditKeepSelect&&this.isEditSelect){
			this.getSelectionModel().select(this.records,true,true);
			this.isEditSelect = false;
		};
    },
	/**     
	* 单元格点击事件
	*/
	cell_click:function(view, td, cellIndex, record, tr, rowIndex, e, eOpts){
		//点击单元格列
		var index =cellIndex;
		if(this.checkboxShow&&index>0){
			index--;
		};
		//如果是超链接 点击抛出事件
		if(this.columns[index].alink){
			var target=e.getTarget();
            if(e.getTarget().tagName.toLowerCase() == 'a')
				this.fireEvent('linkClick',record.data);
		}
		//console.log(cellIndex);
		//console.log(this.checkboxShow);
		//var plugin = this.getPlugin();
		
		//console.log(this.columns);
		//record.beginEdit();
		//console.log(this.getPlugin().startEdit(1,4));
		//this.getPlugin().startEdit(rowIndex,cellIndex-3);
		//debugger;
		//return false;
		//this.startEditing( 1 , 4 );
    },
	/**     
	* 
	* 绑定右键菜单
	* 
	*/
	bandContextMenu:function(menutree,record,items,index,e){
    	var me = this;			
		e.preventDefault();  
		e.stopEvent();
		//var leaf = record.data.leaf;
		var items = [];
		if(this.topButton){
			Ext.Array.forEach(this.topButton,function(button,index,array){
				//过滤掉右键隐藏按钮和流程按钮
				if(!button.rightButtonHidden&&!button.process){
					var rightButton =me.getRightButton(button,record);
					items.push(rightButton);
				}
			});
		}
		//加入流程按钮
		if(record.get('processTask')){
			//重置tbar button按钮可用性
			this.resetTbar(me,record);
			//遍历task
			Ext.Array.forEach(record.get('processTask').executingTask,function(task,index,array){ 
				//根据task查询到要显示的流程按钮
				console.log(task);
				var rightButton = me.getRightButtonByTask(task,record);
				items.push(rightButton);
			})
		}
		//判断是否配置菜单项
		if(this.contextmenu){
			Ext.Array.forEach(this.contextmenu,function(button,index,array){ 
				var rightButton =me.getRightButton(button,record);
				items.push(rightButton);
			});
		}
		if(items.length){
			var nodemenu = new Ext.menu.Menu({  
				floating:true,  
				items:items
			});	
			nodemenu.showAt(e.getXY());  
		}
		
    },
	/**     
	* 
	* 指定某行某列可编辑
	* 行列从0开始
	*/
	startEdit:function(rowIndex,cellIndex){		
		this.getPlugin().startEdit(rowIndex,cellIndex);
    },
	/**     
	* 添加超链接样式
	*/
	renderer_Link:function(value){
		return "<a class='link' href='#'>"+value+"</a>";
    },
	/**
	 * 初始化超链接样式
	 */
	init_Link : function() {
		var me = this;
		for (var i = 0; i < this.CM_JR_Record.length; i++) {
			var  record = this.CM_JR_Record[i];
			//如果是超链接，添加超链接样式
			if(record.alink){
				record.renderer = me.renderer_Link;
			}
			
		}
		
	},
	/**
	 * 初始化columns
	 */
	init_CM : function() {
		//初始化combo
		this.init_combo(this.CM_JR_Record);
		//添加超链接样式
		this.init_Link(this.CM_JR_Record);
		//初始化columns
		var columns = Ext.Array.clone(this.CM_JR_Record); // 克隆数组
		//是否显示序号
		if(this.rownumShow){
			columns.unshift({ header: "序号" ,width : 35 , xtype: "rownumberer"}); 
		}
		
		Ext.Array.forEach(columns,function(column,index,array){		
			//添加 menuDisabled 属性
			column.menuDisabled = true;
		});
		
		this.columns = columns;
		
	},
	/**
	 * 初始化列表栏
	 */
	init_SM_CM_DS : function() {
		var me = this;
		//初始化columns
		this.init_CM();
		//定义modle
		var gridModel ;
		if(this.ModleClass){
			gridModel = this.ModleClass;
		}else{
			//初始化'Ext.data.Model'
			var fields = new Array(); 
			for (var i = 0; i < this.CM_JR_Record.length; i++) {
				var  record = this.CM_JR_Record[i];
				if(record.dataIndex){
					var rec={
						name: record.dataIndex,  
						mapping : record.mappingField || record.dataIndex,
						type: record.type || ''
					}
					fields.push(rec);
				}
				
			}
			//初始化Model
			Ext.define( 'gridModel', {
				extend: 'Ext.data.Model',
				fields: fields
			});	
			gridModel = 'gridModel';
		}
		
		//初始化Store
		if(this.url){
			this.store = Ext.create('Xap.ej.element.store.Store', {
				//autoLoad: true,
				model: gridModel,
				proxy: {
					type: 'ajax',
					url: this.url,
					pageSize: this.pageSize || 10,
					reader: {
						type: 'json',
						root: 'dataList',
						totalProperty: 'total',
						successProperty : 'success'
					}
				}
			});
		}else{
			var gridDataDefault = {'dataList':[]};
			if(this.gridData){
				gridDataDefault = this.gridData;
			}
			this.store = Ext.create('Xap.ej.element.store.Store', {
				model: gridModel,
				data:gridDataDefault,
				pageSize: this.pageSize || 10,
				proxy: {
					type: 'memory',
					reader: {
						type: 'json',
						root: 'dataList',
						totalProperty: 'total'
					}
				}
			});
		}
		//初始化分页信息
		if(this.pageShow){
			this.bbar = [
				{text: '首页',pageName: 'first',disabled : true,
					handler: function() {
						me.currentPage=1;
						me.setDisabled_up_page(true);
						me.setDisabled_down_page(false);
						me.turn_page(1);
					}
				},
				{text: '上一页',pageName: 'back',disabled : true,
					handler: function() {
						me.currentPage--;
						if(me.currentPage==1){
							me.setDisabled_up_page(true);
						}
						me.setDisabled_down_page(false);
						me.turn_page(me.currentPage);
					}
				},
				'-','-',
				{xtype: "label",text: '没有数据！',pageName: 'info'},
				'-','-',
				{text: '下一页',pageName: 'forward',disabled : true,
					handler: function() {
						var pageCount = me.pageCount;
						me.currentPage++;
						if(me.currentPage==pageCount){
							me.setDisabled_down_page(true);
						}
						me.setDisabled_up_page(false);
						me.turn_page(me.currentPage);
					}
				},
				{text: '末页',pageName: 'last',disabled : true,
					handler: function() {
						var pageCount = me.pageCount;
						me.currentPage = pageCount;
						me.setDisabled_down_page(true);
						me.setDisabled_up_page(false);
						me.turn_page(me.currentPage);
					}
				}
				
				
			];
			
			/*this.bbar = Ext.create('Ext.PagingToolbar', {   
				store: this.store,   
				displayInfo: true, 
				emptyMsg: '没有数据',			
				//displayMsg: '显示 {0} - {1} 条，共计 {2} 条',   
				displayMsg: ' ',   
				beforePageText: '第',
				afterPageText: '页/共{0}页'
				}  
			)*/
		}
		
		
	},
	/**     
	* 翻页
	*/
	turn_page:function(currentPage){
		this.set_page_info(currentPage);
		this.fireEvent('turnpage',currentPage,this.pageSize);
	},
	/**     
	* 翻页
	*/
	set_page_info:function(currentPage){
		if(currentPage){
			this.down('label[pageName=info]')
				.setText('第'+currentPage+'页/共'+this.pageCount+'页');
		}else{
			this.down('label[pageName=info]').setText('没有数据！');
		}
	},
	/**     
	* 设置向下翻页可用性
	*/
	setDisabled_down_page:function(  disabled ){
		this.down('button[pageName=forward]').setDisabled(disabled);
		this.down('button[pageName=last]').setDisabled(disabled);
	},
	/**     
	* 设置向上翻页可用性
	*/
	setDisabled_up_page:function(  disabled ){
		this.down('button[pageName=first]').setDisabled(disabled);
		this.down('button[pageName=back]').setDisabled(disabled);
	},
	/**     
	* 赋值分页数据
	*/
	setPageData:function( data ){
		var me = this;
		if(data.total>0){
			var pageCount = Math.ceil(data.total/me.pageSize);
			me.pageCount = pageCount;
			if(pageCount>1){
				me.setDisabled_down_page(false);
			}else{
				me.setDisabled_down_page(true);
			}
			me.setDisabled_up_page(true);
			me.currentPage = 1;
			me.set_page_info(1);
			me.setData(data.dataList);
		}else{
			me.setDisabled_down_page(true);
			me.setDisabled_up_page(true);
			me.set_page_info(null);
			me.setData([]);
		}
	},
	/**     
	* 初始化combo
	*/
	init_combo:function(columns){
		var me = this;
		//字典下拉框赋值	
		Ext.Array.forEach(columns,function(column,index,array){		
			//过滤掉非主数据
			if(column.dictionary){
				if(me.comboboxs[column.dictionary]){
					Ext.apply(column,{
						field:me.comboboxs[column.dictionary],
						renderer: function(value, cellmeta, record,rowIndex,colIndex,store){
							return this.rendererData(value,me.comboboxs[column.dictionary]);
						}	
					});
				}else{
					var combo = Ext.create("Xap.ej.element.field.ComboBox", column);					
					Ext.apply(column,{
						field:combo,
						renderer: function(value, cellmeta, record,rowIndex,colIndex,store){
							return this.rendererData(value,combo);
						}	
					});
					//var combobox ={};
					me.comboboxs[column.dictionary] = combo;
					
				}
			}
		});
		//tools 字典下拉框赋值	
		if(me.tools){
			Ext.Array.forEach(me.tools,function(tool,index,array){		
				//过滤掉非主数据
				if(tool.dictionary){
					if(!me.comboboxs[tool.dictionary]){
						var combo = Ext.create("Xap.ej.element.field.ComboBox", tool);					
						me.comboboxs[tool.dictionary] = combo;
					}
				}
			});
		}
		//tbar 字典下拉框赋值	
		if(me.tbar){
			Ext.Array.forEach(me.tbar,function(bar,index,array){		
				//过滤掉非主数据
				if(bar.dictionary){
					if(!me.comboboxs[bar.dictionary]){
						var combo = Ext.create("Xap.ej.element.field.ComboBox", bar);					
						me.comboboxs[bar.dictionary] = combo;
					}
				}
			});
		}
		
    },
	
	/**     
	* 组件右键按钮
	*/
	getRightButton:function(button,record){
		var me = this;
		var rightButton ={
			text : button.text,
			method : button.method,
			disabled: button.disabled,
			handler : function() { 
				//得到tbar
				var toolbar = me.getTopToolbar();
				//触发事件
				var tbarButton = toolbar.down("button[method="+button.method+"]");
				tbarButton.fireEvent('click');
				//console.log(tbarButton);
				//触发事件
				me.fireEvent('contextmenuclick',button.method,record);
			}
		}
		return rightButton;
    },
	
	/**     
	* 根据task查询到要显示的流程按钮
	*/
	getRightButtonByTask:function(task,record){
		var me = this ;
		var rightButton = {};
		Ext.Array.forEach(this.topButton,function(button,index,array){ 
			//过滤掉右键隐藏按钮和流程按钮
			if(button.method==task.method){
				rightButton =me.getRightButton(button,record);
			}
		});
		return rightButton;
    },
    
	/**     
	* 得到该grid的ModleClass
	* 
	* @return ModleClass 
	*/
	getModleClass:function(){
    	var store = this.getStore();
		var mClass = store.model.getName( );
		return mClass;
    },
    
	/**     
	* 得到该grid的数据
	* @return object [{},{}] 
	*/
	getData:function(){
    	var store = this.getStore();
		return store.getData();
    },
	/**     
	* 给该grid赋新值  
	* @param {object} 
	* [{},{}] 
	*/
	setData:function(data){
    	if(data){
			var store = this.getStore();
			store.setData(data);

			//如果赋值后选择上次已选节点
			if(this.ifSelect){
				this.selectById(this.nodeId);
			}
		}
    },
	/**     
	* 给该grid 创建主数据 对应显示值
	*/
	rendererData : function(value,combo){
		var record = combo.findRecord(combo.valueField, value);
		if(record){
			return record.get(combo.displayField);
		}
		return value;
		
	},
	/** 
     * 得到该grid toolbar
	 * @return Ext.toolbar.Toolbar
     */ 
	getTopToolbar:function(){
		return this.down('toolbar');
    },
    /** 
     * 刷新grid
     */ 
    refresh:function(){
    	this.getView().refresh();
    },

	selectFirstRange:function(){
		this.getSelectionModel( ).select(0);
	}
        
});