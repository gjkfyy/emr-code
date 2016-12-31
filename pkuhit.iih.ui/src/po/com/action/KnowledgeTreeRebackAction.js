Ext.define('iih.po.com.action.KnowledgeTreeRebackAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var view = this.getOwner();
		var bottom = view.down('knowledgetextareablock');
        //写回病历
        var hisDocPlugin = document.getElementById('iemrEditor');
        var treeNode = context.event.arguments[1];
        if(!Ext.isEmpty(treeNode.data.leaf,false)){
        	if(treeNode.data.leaf){
        		if(!hisDocPlugin.IsReadOnly()){
                    var textArea,area;
                    textArea = bottom.down('xaptextarea[name=fragmentTplContent]');
                    area = textArea.value;
                    if(!Ext.isEmpty(area,false)){
                    	hisDocPlugin.InsertText(area);
                    }
                }
        	}
        }
        
	}
});
