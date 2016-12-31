
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


Ext.define('Xap.ej.element.grid.customization.JobGrid', {
    extend: 'Xap.ej.element.grid.Grid',
    alias: 'widget.jobgrid',
	
	initComponent: function() {
		var me = this;
		//初始化列
		this.init_CM_JR_Record(this.CM_JR_Record);
		
        this.callParent(arguments);
    },
    /**     
	* 初始化复选框
	*/
	init_CM_JR_Record:function(CM_JR_Record){
		var xapactioncolumn = { 
			xtype:'xapactioncolumn',
			text:'状态',
			width : 40,
			items: [
				{
					icon:'img/error.png',
					getClass : function(view,m,record) {
						if(record.data.data>record.data.jobdata){
							return 'x-hidden';
						}else if((record.data.jobdata-record.data.data)>2999999999){
							return 'x-hidden';
						}
					}
				},{
					icon:'img/exclamation.png',
					getClass : function(view,m,record) {
						if(record.data.data>record.data.jobdata){
							return 'x-hidden';
						}else if((record.data.jobdata-record.data.data)<3000000000){
							return 'x-hidden';
						}
					}	
				}
			]
		};
		CM_JR_Record.unshift(xapactioncolumn);
		CM_JR_Record.push({ header: 'jobdata', dataIndex: 'jobdata', xtype: 'xapdatecolumn' /*,    hidden: true*/});
    },    
});
