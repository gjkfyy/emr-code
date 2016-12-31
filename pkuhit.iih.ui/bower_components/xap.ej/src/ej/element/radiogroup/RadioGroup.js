/** 
 *单选框列表
 * @extends Ext.form.RadioGroup
 * @author ：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.radiogroup.RadioGroup', {
	extend: 'Ext.form.RadioGroup',
	alias: 'widget.xapradiogroup',
	/** 
     * @cfg {Boolean} 是否根据选择的单选框查询表格数据。
     */
	isGridQuery:false,

	initComponent: function() {
		if(this.isGridQuery){
			this.on("change",this.radioclick,this);
		}
        this.callParent(arguments);
    },
    /** 
     * 触发表格查询事件
     */ 
    radioclick:function(){
    	this.up('xapform').fireEvent("gridquery");
    }
});