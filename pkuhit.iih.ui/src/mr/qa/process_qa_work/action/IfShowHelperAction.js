Ext.define('iih.mr.qa.process_qa_work.action.IfShowHelperAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires:[
	          'iih.mr.qa.process_qa_work.view.DefectInAndMrEditView',
	          'iih.mr.qa.process_qa_work.view.DefectInAndMrEditAndHelperView'
	         ],
	
	/*
    * @Override
    */
    doExecute: function(context) {
        this.callParent();
        var view = this.getOwner();
        var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
        	record:context.record,
        	event:context.event,
        	typeFlag:context.typeFlag
        });
        var operations = context.operations;
        var url = this.url+'?key=IF_SHOW_HELPER';
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var view = this.getOwner();
        var m = operation.result;
        var item={
        		region: 'center',
        	    xtype: 'defectinandmreditandhelperview'
        	}
        
		if(m.data != null && m.data == '1'){ //显示
			this.getBlock('content').add(item);
			var block = this.getBlock('content').down('defectsinblock');
			var grid = block.down('xapgrid[name=defectingrid]');
			grid.setTitle('');
		}else if(m.data != null && m.data == '0'){ //0 为不显示
			 var itemdefect={
		        		region: 'center',
		        	    xtype: 'defectinAndmreditview'
		        	}
			 this.getBlock('content').add(itemdefect);
	    }
		var chain = view.getActionChain('init');
        chain.execute({
        	'viewflag' :m.data
        });
    }
});