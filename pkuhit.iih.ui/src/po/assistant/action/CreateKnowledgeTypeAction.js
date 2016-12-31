Ext.define('iih.po.assistant.action.CreateKnowledgeTypeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
    	var block = this.getOwner().getBlock('list');
    	//得到返回结果、填充数据
        var grid=block.down('xapgrid');
        //定义model
        Ext.define('FragmentTpl', {
	        extend: 'Ext.data.Model',
	        fields: ['fragmentTplTypeCd','fragmentTplTypeNm']
	    });
	    //创建record
        var record = Ext.create('FragmentTpl', {
            fragmentTplTypeCd:'',
            fragmentTplTypeNm:''
        });
        var store = grid.getStore();//得到grid的store
        //新建类别插入第一行
        store.insert(0, record);
        //刷新试图，行号重新排序
        grid.getView().refresh();
        //开启可编辑功能
        grid.getPlugin().startEdit(0,1);
	}
});