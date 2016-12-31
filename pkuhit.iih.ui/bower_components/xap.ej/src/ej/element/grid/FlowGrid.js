
/** 
 *
 * 流程grid
 * @class Xap.ej.element.grid.FlowGrid
 * @extends Xap.ej.element.grid.Grid
 * @author ：chenyajie<chen_yajie@founder.com>
 *
 *## example flowgrid
 *
 *     @example 
 *     Ext.onReady(function() {							
 *     	Ext.create('Ext.panel.Panel', {						
 *     		title: 'Panel',					
 *     		items: [{					
 *     			xtype: 'flowgrid',				
 *     			title: 'flowgrid',				
 *     			//url: 'MyGrid.json',				
 *     			processInfo: [				
 *     				{xtype: "button",text: '新建',method: 'create',handler: function() {console.log('click create');}},			
 *     				{xtype: "button",text: '保存',process: true,method: 'save'},			
 *     				{xtype: "button",text: '提交',process: true,method: 'submit'}			
 *     			],				
 *     			CM_JR_Record: [				
 *     				{ header: '姓名',  dataIndex: 'name', field: 'textfield' ,     type: 'string'},			
 *     				{ header: 'Email', dataIndex: 'email', flex: 1,     type: 'string'},			
 *     				{ header: '编号', dataIndex: 'personNumber',     type: 'string' }			
 *     			],				
 *     			gridData : {'results':[				
 *     				{ 'name': 'Lisa',  "email":"lisa@simpsons.com",  "personNumber":"555-111-1"  ,			
 *     					processTask:{		
 *     						processId:'',	
 *     						executingTask:[	
 *     							{name:'',method:'save',id:''}
 *     						]	
 *     					}		
 *     				},			
 *     				{ 'name': 'Bart',  "email":"bart@simpsons.com",  "personNumber":"555-222-2" },			
 *     				{ 'name': 'Homer', "email":"home@simpsons.com",  "personNumber":"555-222-3"  ,			
 *     					processTask:{		
 *     						processId:'',	
 *     						executingTask:[	
 *     							{name:'',method:'save',id:''},{name:'',method:'submit',id:''}
 *     						]	
 *     					}		
 *     				},			
 *     				{ 'name': 'Lisa',  "email":"lisa@simpsons.com",  "personNumber":"555-111-1"  ,			
 *     					processTask:{		
 *     						processId:'',	
 *     						executingTask:[	
 *     							{name:'',method:'submit',id:''}
 *     						]	
 *     					}		
 *     				},			
 *     				{ 'name': 'Bart',  "email":"bart@simpsons.com",  "personNumber":"555-222-2" },			
 *     				{ 'name': 'Marge', "email":"marge@simpsons.com", "personNumber":"555-222-4"  }			
 *     			]},				
 *     							
 *     			height: 300,				
 *     			width: 900				
 *     		}],					
 *     		renderTo: Ext.getBody()					
 *     	});						
 *     });							

 * 
 * 
 **/


Ext.define('Xap.ej.element.grid.FlowGrid', {
    extend: 'Xap.ej.element.grid.Grid',
    alias: 'widget.flowgrid',
	requires:[
		'Xap.ej.element.grid.column.ActionColumn'
	],
	/**
	 * @cfg {String} xapId
	 * 为该grid指定id
	 */
	xapId : 'xapFilterGridId',
	/** 
     * @cfg {boolean} 是否显示复选框
     */ 
	checkboxShow : true,
	/**
	 * @cfg {Number} 
	 * 为该grid指定列按钮总宽度
	 */
	buttonWidth : null,
	
	/**
	 * @cfg {boolean} 
	 * 列按钮默认不显示
	 */
	isColButtonShow : false,
	
	/**
	 * @cfg {object} processInfo
	 * 配置流程按钮
	 * exp：
	 * [
	 *	 	{text: '新建',method: 'create'},
	 *		{text: '保存',process: true,method: 'save'},
	 *		{text: '修改',process: true,method: 'edit',columnHidden:true},
	 *		{text: '提交',process: true,method: 'submit'}
	 *	]
	 *  text: 按钮名称 ,process: 标示是否流程控制 ,method: 要执行的方法名称,columnHidden:true 在按钮列隐藏
	 */
	processInfo : null,
	
	
	/** 
     * 
	 * 点击流程task按钮，触发tasksubmit事件
     */ 
	fireTasksubmit:function(method,record){
	    var taskObj = {};
	    var ptask = record.processTask;
	    if(record instanceof Ext.data.Model) {
	    	ptask = record.get('processTask');
	    }
		if(ptask){
			taskObj.processId = ptask.processId;
			//遍历task
			Ext.Array.forEach(ptask.executingTask,function(task,index,array){ 
				if(method==task.method){
					Ext.apply(taskObj,task);
				}
			})
		}
		this.fireEvent('tasksubmit',method,record,taskObj);
    },
	/**     
	* 给该grid赋新值  
	* @param {object} [{},{}] 
	*/
	setData:function(data){
    	this.callParent(arguments);
    	this.disableTbarTask();
    },
	/**     
	* 把所有流程按钮置灰
	*  
	*/
	disableTbarTask:function(){
    	//得到tbar
		var toolbar = this.getTopToolbar();
		//task按钮全不可用
		var taskButtons = toolbar.query("[process=true]");
		Ext.each(taskButtons, function (button, index)
		{
			button.setDisabled( true );
		});
    },
	/**     
	* 行点击事件
	* @param {data} [{},{}] 
	*/
	onItemClick:function( view, record, item, index, e, eOpts ){
    	var me = this;
		//取消全选
		this.getSelectionModel().deselectAll( );
		//选中当前点击行
		this.getSelectionModel().select( index );
		//重置tbar button按钮可用性
		this.resetTbar(me,record);
    },
	/**     
	* 
	*  重置tbar button按钮可用性
	* @param {me} this
	* @param {record} record
	* 
	*/
	resetTbar:function(me,record){
		//把所有流程按钮置灰
		this.disableTbarTask();
    	//得到tbar
		var toolbar = me.getTopToolbar();
		//根据选择的列 让task可用
		if(record.get('processTask')){
			//遍历task
			Ext.Array.forEach(record.get('processTask').executingTask,function(task,index,array){ 
				toolbar.query("[method="+task.method+"]")[0].setDisabled( false );
			})
		}
    },
	
	/**     
	* 初始化tbar
	*/
	init_tbar:function(colButton){
		var me = this;
		var tbar = [];
		Ext.Array.forEach(this.processInfo,function(button,index,array){ //单纯的遍历数组 
			if(button.process){//task流程控制按钮
				tbar.push({
					xtype: button.xtype,
					text: button.text,
					process: button.process,//标示是否流程控制
					disabled: button.process,
					method: button.method,//执行的方法名称
					handler: function() {
						me.fireTasksubmit(button.method,me.getSelectionModel().getSelection( )[0].getData());
					}
				});
			}else{
				tbar.push({
					xtype: button.xtype,
					text: button.text,
					method: button.method,//执行的方法名称
					handler: button.handler
				});
			}
			//组建列按钮
			if(button.process&&!button.columnHidden){
				colButton.push({
					text: button.text,
					method: button.method,//执行的方法名称
					isDisabled  : function(v, rowIndex ,colIndex ,item , record) {
					
						if(record.get('processTask')){
							var disabled = true;
							//遍历task
							Ext.Array.forEach(record.get('processTask').executingTask,function(task,index,array){ 
								if(task.method==button.method){
									disabled = false;
								}
							})
							return disabled;
						}else{
							return true;
						}
					},
					handler: function(view,rowIndex,colIndex,e,item ,record) {
						me.fireTasksubmit(button.method,record);
					}
				});
			}
		});
		this.tbar = tbar;
	
    },
	/**     
	* 初始化列按钮及组件新CM
	*/
	init_ColumnButton:function(colButton){
		//初始化列按钮及组件新CM
		if(colButton.length > 0){
			//如果没有指定列宽，自动计算
			if(!this.buttonWidth){
				var length = 0;
				Ext.Array.forEach(colButton,function(button,index,array){
					length += button.text.length;
				});
				this.buttonWidth = 25 * length;
			}
			var xapactioncolumn = {  
				xtype:'xapactioncolumn',
				width:this.buttonWidth,
				text:'操作',
				items: colButton
			};
			var CM_JR_Record_new = [];
			CM_JR_Record_new.push(xapactioncolumn);
			Ext.Array.forEach(this.CM_JR_Record,function(record,index,array){ 
				CM_JR_Record_new.push(record);
			});
			this.CM_JR_Record= CM_JR_Record_new;
		}
    },
	
	initComponent: function() {
		var me = this;
		//增加task隐藏列
		this.CM_JR_Record.push({ header: 'processTask',  dataIndex: 'processTask' ,hidden:true});
		//grid加入列按钮
		var colButton  = [];
		//初始化tbar
		if (this.processInfo) {
			this.init_tbar(colButton);
		};
		//初始化列按钮及组件新CM
		if (this.isColButtonShow) {
			this.init_ColumnButton(colButton);
		};
		
		
        this.callParent(arguments);
        //监听行点击事件
		this.on("itemclick", this.onItemClick, this);
    }
        
});
