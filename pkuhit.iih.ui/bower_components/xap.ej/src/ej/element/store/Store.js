/** 
 * 基本Store
 * @extends Ext.data.Store
 * @author ：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.store.Store', {
	extend: 'Ext.data.Store',
	alias: 'widget.xapstore',
	
	/**     
	* 得到该Store的数据
	* @return object [{},{}] 
	*/
	getData:function(){
		var arr = [];
		this.each(function(record) {
			arr.push(record.getData());
		});
		return arr;
    },
	/**     
	* 给该Store赋新值  
	* @param {data} [{},{}] 
	*/
	setData:function(data){
		this.loadData(data);
    }
});