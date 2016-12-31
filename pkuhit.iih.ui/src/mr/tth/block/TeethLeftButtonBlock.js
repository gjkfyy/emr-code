Ext.define('iih.mr.tth.block.TeethLeftButtonBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: [],

    alias:'widget.teethleftButtonblock',
    
    layout: {
        type: 'table',
        columns: 48,
        tableAttrs: { 
            width: '100%',
            cellSpacing: "0",
            cellPadding: "0"
        },
        tdAttrs: {
            align: 'center'
        }
    },
    
    //border:0,
    
    header:false,

    defaults: { 
        xtype:'button',
        scale:'medium',
        width:30,
        style: {
            marginBottom: '2px' 
        }
    },
    
    items: [{
        text:'8',
        colspan: 6,
        colNo:1,
        block:'teethtopleftblock'
    },{
        text:'7',
        colspan: 6,
        colNo:2,
        block:'teethtopleftblock'
    },{
        text:'6',
        colspan: 6,
        colNo:3,
        block:'teethtopleftblock'
    },{
        text:'5',
        colspan: 6,
        colNo:4,
        block:'teethtopleftblock'
    },{
        text:'4',
        colspan: 6,
        colNo:5,
        block:'teethtopleftblock'
    },{
        text:'3',
        colspan: 6,
        colNo:6,
        block:'teethtopleftblock'
    },{
        text:'2',
        colspan: 6,
        colNo:7,
        block:'teethtopleftblock'
    },{
        text:'1',
        colspan: 6,
        colNo:8,
        block:'teethtopleftblock'
    },{
        text:'8',
        colspan: 6,
        colNo:1,
        block:'teethbottomleftblock'
    },{
        text:'7',
        colspan: 6,
        colNo:2,
        block:'teethbottomleftblock'
    },{
        text:'6',
        colspan: 6,
        colNo:3,
        block:'teethbottomleftblock'
    },{
        text:'5',
        colspan: 6,
        colNo:4,
        block:'teethbottomleftblock'
    },{
        text:'4',
        colspan: 6,
        colNo:5,
        block:'teethbottomleftblock'
    },{
        text:'3',
        colspan: 6,
        colNo:6,
        block:'teethbottomleftblock'
    },{
        text:'2',
        colspan: 6,
        colNo:7,
        block:'teethbottomleftblock'
    },{
        text:'1',
        colspan: 6,
        colNo:8,
        block:'teethbottomleftblock'
    }],

    initComponent: function() {
        this.callParent();
        var me = this;
        var buttons = this.query('button');
        Ext.Array.each(buttons, function(item){
            item.addListener('render', function(b){
                b.on('click', function(button){
                    var view = button.up('teethexamview');
                    var blockStr = button.block;
                    var block = view.down(blockStr);
                    var colNo = button.colNo;
                    var texts = block.query('textfield[colNo='+colNo+']');
                    Ext.Array.each(texts, function(t){
                        if(t.disabled){
                            t.setDisabled(false);
                        }else{
                            t.setValue(null);
                            t.setDisabled(true);  
                        }
                    });
                    var divs = block.query('container[colNo='+colNo+']');
                    Ext.Array.each(divs, function(d){
                        var t = d.down('textfield');
                        if(t.disabled){
                            d.getEl().dom.style.border = '1px solid #b5b8c8';
                            d.getEl().dom.style.borderBottom = 'none';
                            t.setDisabled(false);
                        }else{
                            t.setValue(null);
                            t.hide();
                            d.getEl().dom.style.border = 'none';
                            t.setDisabled(true);  
                        }
                    });
                    var colDisabled = block.down('xaptextfield[name=colDisabled]');
                    var colStr = colDisabled.getValue();
                    var colValue = colStr.substr(colNo-1,1);
                    console.log(colValue);
                    if(colValue == '1'){
                        colStr = colStr.substr(0,colNo-1) + '0' + colStr.substr(colNo,colStr.length-colNo);
                    }else{
                        colStr = colStr.substr(0,colNo-1) + '1' + colStr.substr(colNo,colStr.length-colNo);
                    };
                    console.log(colStr);
                    colDisabled.setValue(colStr);
                });
            });
        });
    }
})