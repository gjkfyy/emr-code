Ext.define('iih.mr.qa.qa_divide_level.block.QaItmSndTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.qaitmsndtreeblock',
	
	layout: 'fit',
	
	border:0,
	
	items:[{
	        xtype:'xaptree',
	        layout: 'fit',
	        title: '分类',
	        name:'QaItmSndTree',
	        autoScroll:true,
//	        id: 'sndCd',
	        ifSelect : true,
        	selectBy: 'sndCd',
	        rootVisible: false,
	        border:0
	}],

	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    this.setDataTree(tree,myobj);
	},
	
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
			/*for(var i=0; i<node.length; i++){
				var singleNode = node[i];
				if(singleNode.sndCd == tree.nodeId){
					tempNode = tree.nodeId;
					break;				
				}
				tempNode = null;
			}*/
			//如果赋值后选择上次已选节点
			if(tree.ifSelect){
				if(tree.fstNodeId){
					var root = tree.getRootNode().childNodes;
			        for(var i=0;i<root.length;i++){
			        	if(root[i].raw.sndCd == tree.fstNodeId){
				        	tree.getSelectionModel().select(root[i]);
				        	break;
				        }
			        }
				}else if(tree.sndNodeId){
					var root = tree.getRootNode().childNodes;
					var v = 0;
			        for(var i=0;i<root.length;i++){
			        	var node = root[i].childNodes;
			        	for(var j=0;j<node.length;j++){
				        	if(node[j].raw.sndCd == tree.sndNodeId){
				        		v++;
				        		tree.getSelectionModel().select(node[j]);
				        		node[j].parentNode.expand();
				        		break;
				        	}
				        }
			        }
			        if(v == 0){
			        	tree.getSelectionModel( ).select(0);
			        }
			        
				}else{
					tree.getSelectionModel( ).select(0);
				}
			}
		}   	
    },
    
    getData: function() {
        return null;
    }    
})