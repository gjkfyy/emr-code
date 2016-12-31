/** 
 * 
 * @extends Ext.form.CheckboxGroup
 * 按钮 
 * @author ：chenyajie<chen_yajie@founder.com>
 */ 
Ext.define('Xap.ej.element.checkboxgroup.CheckboxGroup', {
	extend: 'Ext.form.CheckboxGroup',
	alias: 'widget.xapcheckboxgroup',
	/** 
     * @cfg {Boolean} 是否根据选择的单选框查询表格数据。
     */
	isGridQuery:false,

	initComponent: function() {
		if(this.isGridQuery){
			this.on("change",this.checkBoxClick,this);
		}
        this.callParent(arguments);
    },
    /** 
     * 触发表格查询事件
     */ 
    checkBoxClick:function(){
    	this.up('xapform').fireEvent("gridquery");
    }
});