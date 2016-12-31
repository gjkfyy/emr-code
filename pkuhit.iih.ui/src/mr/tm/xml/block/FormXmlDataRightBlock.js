Ext.define('iih.mr.tm.xml.block.FormXmlDataRightBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.field.DisplayField'
	           ],
	
	alias:'widget.formxmldatarightblock',
	layout: 'fit',
	items:[{
    	xtype:'xapform',
    	layout: {
    		    type: 'vbox',
    		    align: 'stretch'
    		},
    	height:50,
    	items:[{
    		xtype: 'xapdisplayfield',
    		fieldLabel: '值域定义',
    		width: 160,
    		vertical: true,
    		name:'dataElementNm',
    		labelWidth:70,
            labelAlign:'right',
    		value: '',
    		margin:'0 5 0 5'
    	},{
    		xtype: 'xapdisplayfield',
    		fieldLabel: '值域编码',
    		width: 160,
    		vertical: true,
    		name:'dataElementCd',
    		labelWidth:70,
            labelAlign:'right',
    		value: '',
    		margin:'0 5 0 5'
    	},{
        	xtype:'xapgrid',
        	flex:1,
            border:false,
            name:'dataValueGrid',
            ifSelect : true,
            selectBy: 'valueCode',
            autoScroll:true,
    		pageSize : 25,
    		pageShow : false,
            CM_JR_Record:[
            	{header: '值含义',dataIndex: 'valueDisplay',field: 'textfield',type: 'string',flex:1},
    	        {header: '值',dataIndex: 'valueCode',field: 'textfield',type: 'string',flex:1},
    	        {header: 'cd',dataIndex: 'dataElementValueCd',field: 'textfield',type: 'string',hidden:true}
            ]
        }]
    }],

    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        iconCls: 'icon-OK',
        text: '确认',
        handler:function(btn,e){
            var view = btn.up('formxmldataview');
            var dataElementCd = view.down('xapdisplayfield[name=dataElementCd]');
            var dataElementNm = view.down('xapdisplayfield[name=dataElementNm]');
            var sourceView = view.sourceView;
            var mrElementNm = sourceView.down('xaptextfield[name=mrElementNm]');
            var valueType = sourceView.down('xapcombobox[name=valueType]');
            var mrElementTypeName = sourceView.down('xapcombobox[name=mrElementTypeName]');
            var dataResource = sourceView.down('xaptextfield[name=dataResource]');
            var deCd = sourceView.down('xaptextfield[name=deCd]');
            if(!Ext.isEmpty(dataElementNm.value,false)){
            	mrElementNm.setValue(dataElementNm.value);
                dataResource.setValue(dataElementCd.value);
                if(mrElementTypeName.value==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME4 || mrElementTypeName.value==IMER_CONSTANT.MR_ELEMENT_TYPE_NAME5){
                	valueType.setValue('dictionary');
                }
                var grid = view.down('xapgrid[name=dataValueGrid]');
                var records = grid.getStore().data.items;
                var custormRange = sourceView.down('xapgrid[name=custormRange]');
                var deCdShow = sourceView.down('xapdisplayfield[name=deCdShow]');
                deCdShow.setValue(dataElementCd.value);
                deCd.setValue(dataElementCd.value);
                var store = custormRange.getStore();
                var name = '',value = '',data = {};
                if(records.length>0){
                	for(var i=0;i<records.length;i++){
                		name = records[i].data.valueDisplay;
                		value = records[i].data.valueCode;
                		data.name = name;
                		data.value = value;
                		store.add(data);
                	}
                }                
            }else{
//            	mrElementNm.setValue('');
                dataResource.setValue('');
            }
            var win = this.up('window');
            win.close();
        }
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        iconCls: 'icon-cancel',
        text: '取消',
        handler:function(btn,e){
            var win = this.up('window');
            win.close();
        }
    }],
    
	setData: function(data) {
        var grid = this.down('xapgrid[name=dataValueGrid]');
        var dataList = data.dataList;
        if(dataList){
        	grid.setData(dataList);
        }else{
        	grid.setData({});
        }
    },
    getData: function() {
        return null;
    },
    initComponent: function() {
        this.callParent();
    }
    
})