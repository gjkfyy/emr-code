
/** 
 *
 * UtilGrid
 * @class Xap.ej.element.grid.customization.UtilGrid
 * @extends Xap.ej.element.grid.Grid
 * @author ：chenyajie<chen_yajie@founder.com>
 *
 *## example flowgrid
 *
 *     @example 
 *     Ext.onReady(function() {							
 				
 *     });							
 * 
 * 
 **/


Ext.define('Xap.ej.element.grid.customization.UtilGrid', {
    extend: 'Xap.ej.element.grid.Grid',
    alias: 'widget.utilgrid',
	/**
	 * @cfg {boolean} 
	 * 是否显示写回病历按钮
	 */
	echo : true,
	/**
	 * @cfg {boolean} 
	 * 是否显示高级查询按钮
	 */
	search : true,
	initComponent: function() {
		var me = this;
		//初始化按钮
		this.init_tbar();
		
        this.callParent(arguments);
    },
    /**     
	* 初始化按钮
	*/
	init_tbar:function(){
		var me = this;
		var tbar = [];
		tbar.push('->');
		if(me.echo){
			tbar.push({
				xtype: "button",
				text: '写回病历'
			});
		}
		if(me.search){
			tbar.push({
				xtype: "button",
				text: '高级查询'
			});
		}
		this.tbar = tbar;
    },    
});
