Ext.define('iih.mr.tth.block.TeethBottomTitleBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.TextField',
               'Xap.ej.element.field.Radio'],

    alias:'widget.teethbottomtitleblock',
    
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
        value:'L',
        style: {
            marginTop: '15px'
        },
        tdAttrs: {
            align: 'right',
            height:46
        }
    },{
        value:'PD',
        tdAttrs: {
            align: 'right'
        }
    },{
        value:'B',
        style: {
            marginBottom: '10px'
        },
        tdAttrs: {
            align: 'right',
            height:50
        }
    },{
        value:'BI',
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
        value:'PLI',
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
        value:'溢脓',
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
        value:'FI',
        tdAttrs: {
            align: 'right',
            height:60
        }
    }],

    initComponent: function() {
        this.callParent();
    }
})