Ext.define('iih.po.com.block.SpecialCharacterBlock', {
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.grid.Grid'],

    alias:'widget.specialcharacterblock',

    layout: 'fit',
    
    border: 0,
    
    flex: 1,

    items: [{
        xtype:'xapgrid',
        layout: 'fit',
        border:false,
        rownumShow:false,
        flex:1,
        selModel:new Ext.selection.CellModel(),
        CM_JR_Record: [{
            header:'1',
            dataIndex:'fst',
            flex:1
        },{
            header:'2',
            dataIndex:'snd',
            flex:1
        },{
            header:'3',
            dataIndex:'thd',
            flex:1
        }],
        listeners: {
            celldblclick:function( grid, td, cellIndex, record, tr, rowIndex, e, eOpts ) {
                var text;
                if(cellIndex > 1)
                    text=record.get('thd');
                else if(cellIndex > 0)
                    text=record.get('snd');
                else
                    text=record.get('fst');
                var hisDocPlugin=document.getElementById('iemrEditor');
                if(!hisDocPlugin.IsReadOnly()){
                    hisDocPlugin.InsertText(text);
                }
            }
        }
    }],
    
    initComponent: function() {
        this.callParent();
    }
});