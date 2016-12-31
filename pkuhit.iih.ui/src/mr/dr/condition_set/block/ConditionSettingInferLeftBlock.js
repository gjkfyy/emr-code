Ext.define('iih.mr.dr.condition_set.block.ConditionSettingInferLeftBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: ['Xap.ej.element.tree.Tree'],
	
	alias:'widget.conditionsettinginferleftblock',

	layout: 'fit',
	
	items:[{
            xtype:'xapformblock',
            layout: {
    		    type: 'vbox',
    		    align: 'stretch'
    		},
            items:[{           
            	xtype:'xapcombobox',
		        name:'mrDocType',
		        //padding:'10 0 8 40',
		        labelWidth:90,
		        //width:260,
		        editable:false,
		        allOptions: false,
		        fieldLabel:'病历文书类型',
		        queryMode: 'local',
		        displayField: 'nm',
		        valueField: 'xmlFilePk'   
		},{
	           xtype:'xaptree',
	           name:'mrDocTree',
	           flex: 1,
	           ifSelect:true,
	           rootVisible: false
       }]
    }],
       
	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }	
})