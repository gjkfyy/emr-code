/** 
 *
 * @extends Ext.tree.Panel
 * @author ：chenyajie<chen_yajie@founder.com>
 * 该面板为Ext.tree.Panel派生而来，因此可以传入所有符合Ext.grid.Panel的配置选项和方法
 * 异步加载时请求url携带节点id参数为node
 *## example xaptree
 *
 *     @example
 *	    	Ext.create('Ext.panel.Panel', {					
 *	    		bodyPadding: 5,  // Don't want content to crunch against the borders				
 *	    		height: 400,				
 *	    		width: 900 ,				
 *	    		title: 'Panel',				
 *	    		items: [{				
 *	    			xtype: 'xaptree',			
 *	    			//为该tree指定数据源			
 *	    			treeData:[			
 *	    				{ text: "北京", leaf: true },		
 *	    				{ text: "上海", expanded: true, children: [		
 *	    					{ text: "虹口", leaf: true },	
 *	    					{ text: "高桥", leaf: true}	
 *	    				] },		
 *	    				{ text: "河北", leaf: true }		
 *	    			]			
 *	    		}],				
 *	    		renderTo: Ext.getBody()				
 *	    	});					
 *
 *
 */

Ext.define('Xap.ej.element.tree.Tree', {
    extend: 'Ext.tree.Panel',
	requires : [
		'Xap.ej.block.LayeredBlock'
	],

	//mixins : ['Xap.ej.block.LayeredBlock'],
	
    alias: 'widget.xaptree',

	/**
	 * @cfg {object} treeData
	 * 为该tree指定数据源
	 */
	treeData : null,
	

	/**
	 * @cfg {boolean} 
	 * false 不显示根节点
	 */
	rootVisible: false,
	
	/**
	 * @cfg {object} 
	 *  记录节点id
	 */
	nodeId: null,
	
	/**
	 * @cfg {string} 
	 *  根据节点id选中节点
	 */
	selectBy: 'id',
	/**
	 * @cfg {boolean} 
	 *  是否setData后选中节点
	 */
	ifSelect: true,
	/**
	 * @cfg {string} 
	 *  根节点id
	 */
	rootId: '0',
	/**
	 * @cfg {string} 
	 *  请求数据的url
	 */
	url: '',
	/**
	 * @cfg {Array} 
	 *  通过此参数添加节点属性
	 */
	treeFields: [ ],
	/**
	 * @cfg {Array} 
	 *  默认节点属性
	 */
	defaultFields : [ {
			name : 'id',
			type : 'string'
		}, {
			name : 'text',
			type : 'string'
		}, {
			name : 'leaf',
			type : 'boolean'
	}],
	/**
	 * @cfg {object} contextmenu
	 *
	 * 为该tree 配置右键菜单项
	 * contextmenu: [
	 *      {text:'节点按钮',method:'method1'},
	 *		{text:'非叶子节点按钮',leaf:false,method:'method2'},
	 *		{text:'叶子节点按钮',leaf:true,method:'method3'}
	 *	]
	 *
	 * text 方法名称    leaf：为空（节点都显示）、false（非叶子节点显示）、true（叶子节点显示）  method触发的方法
	 */
	contextmenu : null,
	
	
	initComponent: function() {
		var me = this;
		//初始化treeStore
		me.init_store();
		//初始化右键菜单
		if (this.contextmenu) {
			this.addListener('itemcontextmenu',this.bandContextMenu); 
		}
        this.callParent(arguments);
		//行点击事件
		this.addListener('itemclick',this.item_click);
		//展开事件监听
		this.addListener('beforeitemexpand',this.beforeitemexpand_click);
		
        //this.initBlock();
		
    },
	/**     
	* 初始化treeStore
	*/
	beforeitemexpand_click:function(node){
		if(!node.hasChildNodes( )){
			this.fireEvent('treeitemexpand',node);
		}
		
	},
	/**     
	* 初始化treeStore
	*/
	init_store:function(){
		var me = this;
		//初始化treeStore
		if (this.treeData) {
			this.store = Ext.create('Ext.data.TreeStore', {
				root: {
					expanded: true,
					children: this.treeData
				}
			});
		}/*else{
			var fields = Ext.Array.merge(defaultFields,treeFields);
			var treeModel = Ext.create('Ext.data.Model', {
				fields : fields
			});
			this.store = Ext.create('Ext.data.TreeStore', {
				model: treeModel,
				proxy: {
					type: 'ajax',
					url: me.url
				},
				reader: {
					type: 'json'
				},
				folderSort: true,
				sorters: [{
					property: 'text',
					direction: 'ASC'
				}],
				root: {
					id: me.rootId,
					text: '根节点',
					expanded: false
				}
			});
		};*/
    },
	/**     
	* 节点点击事件
	*/
	item_click:function(view, record,item,index,e,eOpts){
		//记录点击节点的id
		this.nodeId = record.data['id'];
    },
	/**     
	 *  
     * 得到该tree增加节点
	 * @param {object} 增加一个{} 多个[{},{}]
	 * @return Ext.data.NodeInterface
     * 
	 */
	addNodeData:function(node){
    	return this.getRootNode( ).appendChild(node);
    },
	
	/**     
	 *  
     * 得到该tree 赋值节点
	 * @param {object} 赋值一个{} 多个[{},{}]
	 * @return Ext.data.NodeInterface
     * 
	 */
	setData:function(node){
		if(node){
			this.getRootNode( ).removeAll();
			if(node instanceof Array){//是[]
				if(node.length > 0){
					this.addNodeData(node);
				}
			}else{//是{}
				this.addNodeData(node);
			}
			//如果赋值后选择上次已选节点
			if(this.ifSelect){
				this.selectById(this.nodeId);
			}
		}   	
    },
	/**     
     * 根据节点id选中节点
	 * @param {String} 
	 */
	selectById:function(nodeId){
		if(nodeId){
			var r = this.getStore().getNodeById(nodeId);
			this.getSelectionModel( ).select(r);
		}else{
			this.getSelectionModel( ).select(0);
		}
    	
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
		var leaf = record.data.leaf;
		//判断是否配置菜单项
		if(this.contextmenu){
			var menuLength = this.contextmenu.length;
			var items = [];
			for( var i =0;i<menuLength;i++){
				if(this.contextmenu[i].leaf == leaf ||this.contextmenu[i].leaf == null){
					//执行的方法
					var method = me.contextmenu[i].method;
					Ext.apply(this.contextmenu[i], {
						handler : function() { 
							console.log('fireEvent:contextmenuclick--method:'+method);
							//触发事件
							me.fireEvent('contextmenuclick',method,record);
						}
					});
					items.push(this.contextmenu[i]);
				}
			}
			var nodemenu = new Ext.menu.Menu({  
				floating:true,  
				items:items
			});	
			nodemenu.showAt(e.getXY()); 
		}
    }
	
        
});



