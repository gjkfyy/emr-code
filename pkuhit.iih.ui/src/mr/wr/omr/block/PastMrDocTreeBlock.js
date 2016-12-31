Ext.define('iih.mr.wr.omr.block.PastMrDocTreeBlock',{
	extend : 'Xap.ej.block.PanelBlock',
	
	requires: [
	           'Xap.ej.element.tree.Tree',
	           'Xap.ej.element.field.Checkbox'
	],
	alias:'widget.outmrdoctreeblock',

	layout: 'fit',
	
	items: [{
		xtype:'xaptree',
		border:true,
		ifSelect:true,
		autoScroll:true,
		height:400,
		rootVisible: false
	}],
	
	tbar:[
	      {
	            itemId: 'encounterCombox',
	            xtype: 'xapcombobox',
	            emptyText: '请选择就诊',
	            labelAlign: 'right',
	            editable:false,
	            maxWidth: 300,
	            flex:1,
	            allowBlank: true,
	            forceSelection: true/*,
	            listeners:{
	                change : function(combo,newValue,oldValue) {
	                    var block = combo.up('assistantblock');
	                    var tabpanel = block.down('xaptabpanel');
	                    var tabs = tabpanel.items.items;
	                    for (var i = 0; i < tabs.length; i++) {
	                        var tab = tabs[i];
	                        tab.refresh = false;
	                    };
	                    var tab = tabpanel.getActiveTab();
	                    tab.fireEvent("changeEncounter",newValue);
	                    tab.refresh = true;
	                }
	            }*/
	        }
    ],
	
    setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data); 
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    },
    setEncouterData: function(data){
        var combo = this.down('xapcombobox[itemId=encounterCombox]');
        if(combo){
            combo.clearValue();
            if(data){
                var array = new Array();
                Ext.each(data,function(rec){
                    if(rec){
                        var time = Ext.Date.parse(rec.currentDeptIntoTime, 'time');
                        var value = Ext.Date.format(time, 'Y-m-d H:i');
                        //var value = Ext.util.Format.date(rec.currentDeptIntoTime, "Y-m-d H:i:s");
                        value = value + '_';
                        value = value + rec.encounterTypeName;
                        if(rec.currentMainDiagnosisName){
                            value = value + '_';
                            value = value + rec.currentMainDiagnosisName;
                        }
                        array.push({'text':value,'value':rec.pk});
                    }
                });
                combo.setData(array);
                //var record = combo.getStore().getAt(0);
                //combo.select(record);
                combo.setValue(IMER_GLOBAL.encounterSn);
            }
        }
    }
    
})