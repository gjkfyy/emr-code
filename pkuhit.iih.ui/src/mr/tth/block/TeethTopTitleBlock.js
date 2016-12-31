Ext.define('iih.mr.tth.block.TeethTopTitleBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.TextField',
               'Xap.ej.element.field.Radio'],

    alias:'widget.teethtoptitleblock',
    
    layout: {
        type: 'table',
        columns: 1,
        tableAttrs: { 
            width: '100%',
            cellSpacing: "0",
            cellPadding: "0"
        }
    },
    
    //border:0,
    
    header:false,

    defaults: { 
        xtype:'displayfield'
    },
    
    items: [{
        value:'FI',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'角化龈宽',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'溢脓',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'动度',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'PLI',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'龈缘-CEJ',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'BI',
        tdAttrs: {
            align: 'right',
            height:60
        }
    },{
        value:'B',
        style: {
            marginTop: '15px'
        },
        tdAttrs: {
            align: 'right',
            height:50
        }
    },{
        value:'PD',
        tdAttrs: {
            align: 'right'
        }
    },{
        value:'L',
        style: {
            marginBottom: '10px'
        },
        tdAttrs: {
            align: 'right',
            height:46
        }
    }],

    initComponent: function() {
        this.callParent();
    }
})