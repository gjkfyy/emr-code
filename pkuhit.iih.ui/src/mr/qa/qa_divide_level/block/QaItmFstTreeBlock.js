Ext.define('iih.mr.qa.qa_divide_level.block.QaItmFstTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.qaitmfsttreeblock',
	
	border:0,
	
	items:[{
	        xtype:'xaptree',
	        layout: 'fit',
	        title: '一级分类',
	        name:'QaItmFstTree',
	        ifSelect:true,
	        selectBy: 'id',
	        rootVisible: false,
	        border:0
	}],

	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    this.setDataTree(tree,myobj);
	},
		/**     
	 *  
     * 得到该tree 赋值节点
	 * @param {object} 赋值一个{} 多个[{},{}]
	 * @return Ext.data.NodeInterface
     * 
	 */
	setDataTree:function(tree,node){
		var tempNode;
		if(node){
			tree.getRootNode( ).removeAll();
			if(node instanceof Array){//是[]
				if(node.length > 0){
					tree.addNodeData(node);
				}
			}else{//是{}
				tree.addNodeData(node);
			}
			for(var i=0; i<node.length; i++){
				var singleNode = node[i];
				if(singleNode.id == tree.nodeId){
					tempNode = tree.nodeId;
					break;				
				}
				tempNode = null;
			}
			//如果赋值后选择上次已选节点
			if(tree.ifSelect){
				tree.selectById(tempNode);
			}
		}   	
    },
    getData: function() {
        return null;
    }    
})