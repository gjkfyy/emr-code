Ext.define('iih.po.com.action.KnowledgeTextRebackAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		var view = this.getOwner();
		var bottom = view.down('knowledgetextareablock');
        //写回病历
        var hisDocPlugin = document.getElementById('iemrEditor');
        
        if(!hisDocPlugin.IsReadOnly()){
            var textArea,area;
            textArea = bottom.down('xaptextarea[name=fragmentTplContent]');
            area = textArea.value;
            if(!Ext.isEmpty(area,false)){
            	hisDocPlugin.InsertText(area);
            }
        }
	}
});
