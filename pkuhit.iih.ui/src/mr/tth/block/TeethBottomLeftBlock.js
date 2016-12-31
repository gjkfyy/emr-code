Ext.define('iih.mr.tth.block.TeethBottomLeftBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.TextField',
               'Xap.ej.element.field.Radio'],

    alias:'widget.teethbottomleftblock',
    
    layout: {
        type: 'table',
        columns: 48,
        tableAttrs: { 
            width: '100%',
            cellSpacing: "0",
            cellPadding: "0",
            style:{
                border: '1px solid #b5b8c8'
            }
        },
        tdAttrs: {
            align: 'center'
        }
    },
    
    header:false,
    
    items: [{
        xtype:'xaptextfield',
        name: 'teethItemPk',
        hidden: true
    },{
        xtype:'xaptextfield',
        name: 'teethPk',
        hidden: true
    },{
        xtype:'xaptextfield',
        name: 'teethLocation',
        hidden: true,
        value:'2'
    },{
        xtype:'xaptextfield',
        name: 'colDisabled',
        hidden: true
    }],

    trackResetOnLoad:true,
    
    initComponent: function() {
        this.callParent();
        var me = this;
        //构造【L】行
        var txtCfg = {
            style: { 
                marginBottom: '0px'
            },
            fieldStyle: {
                'text-align': 'center',
                border: 'none',
                backgroundImage: 'none'
            },
            height: 20,
            rowNo: 1,
            hidden: true,
            lcheck: true
        };
        for(var i=1;i<9;i++){
            var cfg = {
                layout: 'fit',
                height: 20,
                colspan: 2,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                },
                colNo: i,
                lColNo: 1
            };
            var div = Ext.create('Ext.container.Container',cfg);
            var cell = Ext.create('Xap.ej.element.field.TextField',txtCfg);
            div.add(cell);
            me.add(div);
            var cfg = {
                layout: 'fit',
                height: 20,
                colspan: 2,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                },
                colNo: i,
                lColNo: 2
            };
            var div = Ext.create('Ext.container.Container',cfg);
            var cell = Ext.create('Xap.ej.element.field.TextField',txtCfg);
            div.add(cell);
            me.add(div);
            var cfg = {
                layout: 'fit',
                height: 20,
                colspan: 2,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                },
                colNo: i,
                lColNo: 3
            };
            var div = Ext.create('Ext.container.Container',cfg);
            var cell = Ext.create('Xap.ej.element.field.TextField',txtCfg);
            div.add(cell);
            me.add(div);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: 'none',
                    backgroundImage: 'none'
                },
                height: 40,
                colspan: 2,
                lText: true,
                rowNo: 2,
                colNo: i,
                lColNo: 1
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: 'none',
                    backgroundImage: 'none'
                },
                height: 40,
                colspan: 2,
                lText: true,
                rowNo: 2,
                colNo: i,
                lColNo: 2
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: 'none',
                    backgroundImage: 'none'
                },
                height: 40,
                colspan: 2,
                lText: true,
                rowNo: 2,
                colNo: i,
                lColNo: 3
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【B】行
        var txtCfg = {
            style: { 
                marginBottom: '0px'
            },
            fieldStyle: {
                'text-align': 'center',
                border: 'none',
                backgroundImage: 'none'
            },
            height: 20,
            rowNo: 3,
            hidden: true,
            bcheck: true
        };
        for(var i=1;i<9;i++){
            var cfg = {
                layout: 'fit',
                height: 20,
                colspan: 2,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                },
                colNo: i,
                bColNo: 1
            };
            var div = Ext.create('Ext.container.Container',cfg);
            var cell = Ext.create('Xap.ej.element.field.TextField',txtCfg);
            div.add(cell);
            me.add(div);
            var cfg = {
                layout: 'fit',
                height: 20,
                colspan: 2,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                },
                colNo: i,
                bColNo: 2
            };
            var div = Ext.create('Ext.container.Container',cfg);
            var cell = Ext.create('Xap.ej.element.field.TextField',txtCfg);
            div.add(cell);
            me.add(div);
            var cfg = {
                layout: 'fit',
                height: 20,
                colspan: 2,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                },
                colNo: i,
                bColNo: 3
            };
            var div = Ext.create('Ext.container.Container',cfg);
            var cell = Ext.create('Xap.ej.element.field.TextField',txtCfg);
            div.add(cell);
            me.add(div);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: 'none',
                    backgroundImage: 'none'
                },
                height: 40,
                colspan: 2,
                bText: true,
                rowNo: 4,
                colNo: i,
                bColNo: 1
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: 'none',
                    backgroundImage: 'none'
                },
                height: 40,
                colspan: 2,
                bText: true,
                rowNo: 4,
                colNo: i,
                bColNo: 2
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: 'none',
                    backgroundImage: 'none'
                },
                height: 40,
                colspan: 2,
                bText: true,
                rowNo: 4,
                colNo: i,
                bColNo: 3
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【BI】行
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderBottom: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 6,
                height: 30,
                rowNo: 5,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 6,
                height: 30,
                rowNo: 5,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【龈缘-CEJ】行
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderBottom: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 6,
                height: 30,
                rowNo: 6,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 6,
                height: 30,
                rowNo: 6,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【PLI】行
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderBottom: '1px dotted #b5b8c8',
                    borderRight: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 2,
                height: 30,
                rowNo: 7,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderBottom: '1px dotted #b5b8c8',
                    borderLeft: '1px dotted #b5b8c8',
                    borderRight: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 2,
                height: 30,
                rowNo: 7,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderBottom: '1px dotted #b5b8c8',
                    borderLeft: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 2,
                height: 30,
                rowNo: 7,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: '1px dotted #b5b8c8',
                    borderRight: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 2,
                height: 30,
                rowNo: 7,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: '1px dotted #b5b8c8',
                    borderLeft: '1px dotted #b5b8c8',
                    borderRight: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 2,
                height: 30,
                rowNo: 7,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { 
                    marginBottom: '0px'
                },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: '1px dotted #b5b8c8',
                    borderLeft: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                colspan: 2,
                height: 30,
                rowNo: 7,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【动度】行
        for(var i=1;i<9;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderRight: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 60,
                colspan: 3,
                rowNo: 8,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderLeft: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 60,
                colspan: 3,
                rowNo: 8,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【溢脓】行
        for(var i=1;i<9;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderBottom: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 6,
                rowNo: 9,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderTop: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 6,
                rowNo: 9,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【角化龈宽】行
        for(var i=1;i<9;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderRight: '1px dotted #b5b8c8',
                    borderBottom: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 2,
                rowNo: 10,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderRight: '1px dotted #b5b8c8',
                    borderLeft: '1px dotted #b5b8c8',
                    borderBottom: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 2,
                rowNo: 10,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderLeft: '1px dotted #b5b8c8',
                    borderBottom: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 2,
                rowNo: 10,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=1;i<9;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderRight: '1px dotted #b5b8c8',
                    borderTop: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 2,
                rowNo: 10,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderRight: '1px dotted #b5b8c8',
                    borderLeft: '1px dotted #b5b8c8',
                    borderTop: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 2,
                rowNo: 10,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    borderLeft: '1px dotted #b5b8c8',
                    borderTop: '1px dotted #b5b8c8',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 2,
                rowNo: 10,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        //构造【FI】行
        for(var i=1;i<4;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 6,
                rowNo: 11,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=4;i<9;i++){
            var cfg = {
                height: 30,
                colspan: 6,
                style:{
                    border: '1px solid #b5b8c8',
                    borderBottom: 'none'
                }
            };
            var container = Ext.create('Ext.container.Container',cfg);
            me.add(container);
        };
        for(var i=1;i<4;i++){
            var cfg = {
                style: { marginBottom: '0px' },
                fieldStyle: {
                    'text-align': 'center',
                    backgroundImage: 'none'
                },
                height: 30,
                colspan: 6,
                rowNo: 11,
                colNo: i
            };
            var text = Ext.create('Xap.ej.element.field.TextField',cfg);
            me.add(text);
        };
        for(var i=4;i<9;i++){
            var cfg = {
                height: 30,
                colspan: 6,
                style:{
                    border: '1px solid #b5b8c8',
                    borderTop: 'none'
                }
            };
            var container = Ext.create('Ext.container.Container',cfg);
            me.add(container);
        };
        var bTexts = this.query('textfield[bText=true]');
        Ext.Array.each(bTexts, function(text){
            var colNo = text.colNo;
            var bColNo = text.bColNo;
            var div = me.down('container[colNo='+colNo+'][bColNo='+bColNo+']');
            var cell = div.down('textfield');
            text.addListener('render', function(t){
                t.getEl().on('dblclick', function(p){   
                    if(cell.getValue()){
                        cell.setValue(null);
                        cell.hide();
                    }else{
                        cell.setValue('●');
                        cell.show();
                    }
                });
                t.getEl().on('contextmenu', function(e){   
                    e.preventDefault();  
                    e.stopEvent();
                    var nodemenu = new Ext.menu.Menu({  
                        floating : true,  
                        items : [{
                            xtype:'xapcheckbox',
                            boxLabel : "全出血",
                            handler : function(c, newValue, oldValue, eOpts) {
                                var cells = me.query('textfield[bcheck=true]');
                                Ext.Array.each(cells, function(cell){
                                    if(newValue){
                                        cell.setValue('●');
                                        cell.show();
                                    }else{
                                        cell.setValue(null);
                                        cell.hide();
                                    }
                                });
                            } 
                        }]
                    });
                    nodemenu.showAt(e.getXY());
                });
            });
            text.addListener('specialkey', function(t,e){
                if (e.getKey() == e.ENTER) {
                    if(cell.getValue()){
                        cell.setValue(null);
                        cell.hide();
                    }else{
                        cell.setValue('●');
                        cell.show();
                    }
                }
            });
        });
        var lTexts = this.query('textfield[lText=true]');
        Ext.Array.each(lTexts, function(text){
            var colNo = text.colNo;
            var lColNo = text.lColNo;
            var div = me.down('container[colNo='+colNo+'][lColNo='+lColNo+']');
            var cell = div.down('textfield');
            text.addListener('render', function(t){
                t.getEl().on('dblclick', function(p){   
                    if(cell.getValue()){
                        cell.setValue(null);
                        cell.hide();
                    }else{
                        cell.setValue('●');
                        cell.show();
                    }
                });
                t.getEl().on('contextmenu', function(e){   
                    e.preventDefault();  
                    e.stopEvent();
                    var nodemenu = new Ext.menu.Menu({  
                        floating : true,  
                        items : [{
                            xtype:'xapcheckbox',
                            boxLabel : "全出血",
                            handler : function(c, newValue, oldValue, eOpts) {
                                var cells = me.query('textfield[lcheck=true]');
                                Ext.Array.each(cells, function(cell){
                                    if(newValue){
                                        cell.setValue('●');
                                        cell.show();
                                    }else{
                                        cell.setValue(null);
                                        cell.hide();
                                    }
                                });
                            } 
                        }]
                    });
                    nodemenu.showAt(e.getXY());
                });
            });
            text.addListener('specialkey', function(t,e){
                if (e.getKey() == e.ENTER) {
                    if(cell.getValue()){
                        cell.setValue(null);
                        cell.hide();
                    }else{
                        cell.setValue('●');
                        cell.show();
                    }
                }
            });
        });
        /*var array = ['fstPdLFst', 'fstPdLSnd', 'fstPdLTrd', 'sndPdLFst', 'sndPdLSnd', 'sndPdLTrd', 'trdPdLFst', 'trdPdLSnd', 'trdPdLTrd', 'fohPdLFst', 'fohPdLSnd', 'fohPdLTrd', 'fihPdLFst', 'fihPdLSnd', 'fihPdLTrd', 'sixPdLFst', 'sixPdLSnd', 'sixPdLTrd', 'svnPdLFst', 'svnPdLSnd', 'svnPdLTrd', 'ethPdLFst', 'ethPdLSnd', 'ethPdLTrd', 'fstPdLFoh', 'fstPdLFih', 'fstPdLSix', 'sndPdLFoh', 'sndPdLFih', 'sndPdLSix', 'trdPdLFoh', 'trdPdLFih', 'trdPdLSix', 'fohPdLFoh', 'fohPdLFih', 'fohPdLSix',
                'fihPdLFoh', 'fihPdLFih', 'fihPdLSix', 'sixPdLFoh', 'sixPdLFih', 'sixPdLSix', 'svnPdLFoh', 'svnPdLFih', 'svnPdLSix', 'ethPdLFoh', 'ethPdLFih', 'ethPdLSix', 'fstPdBFst', 'fstPdBSnd', 'fstPdBTrd', 'sndPdBFst', 'sndPdBSnd', 'sndPdBTrd', 'trdPdBFst', 'trdPdBSnd', 'trdPdBTrd', 'fohPdBFst', 'fohPdBSnd', 'fohPdBTrd', 'fihPdBFst', 'fihPdBSnd', 'fihPdBTrd', 'sixPdBFst', 'sixPdBSnd', 'sixPdBTrd', 'svnPdBFst', 'svnPdBSnd', 'svnPdBTrd', 'ethPdBFst', 'ethPdBSnd', 'ethPdBTrd', 'fstPdBFoh',
                'fstPdBFih', 'fstPdBSix', 'sndPdBFoh', 'sndPdBFih', 'sndPdBSix', 'trdPdBFoh', 'trdPdBFih', 'trdPdBSix', 'fohPdBFoh', 'fohPdBFih', 'fohPdBSix', 'fihPdBFoh', 'fihPdBFih', 'fihPdBSix', 'sixPdBFoh', 'sixPdBFih', 'sixPdBSix', 'svnPdBFoh', 'svnPdBFih', 'svnPdBSix', 'ethPdBFoh', 'ethPdBFih', 'ethPdBSix', 'fstBiFst', 'sndBiFst', 'trdBiFst', 'fohBiFst', 'fihBiFst', 'sixBiFst', 'svnBiFst', 'ethBiFst', 'fstBiSnd', 'sndBiSnd', 'trdBiSnd', 'fohBiSnd', 'fihBiSnd', 'sixBiSnd', 'svnBiSnd',
                'ethBiSnd', 'fstCejFst', 'sndCejFst', 'trdCejFst', 'fohCejFst', 'fihCejFst', 'sixCejFst', 'svnCejFst', 'ethCejFst', 'fstCejSnd', 'sndCejSnd', 'trdCejSnd', 'fohCejSnd', 'fihCejSnd', 'sixCejSnd', 'svnCejSnd', 'ethCejSnd', 'fstPliFst', 'fstPliSnd', 'fstPliTrd', 'sndPliFst', 'sndPliSnd', 'sndPliTrd', 'trdPliFst', 'trdPliSnd', 'trdPliTrd', 'fohPliFst', 'fohPliSnd', 'fohPliTrd', 'fihPliFst', 'fihPliSnd', 'fihPliTrd', 'sixPliFst', 'sixPliSnd', 'sixPliTrd', 'svnPliFst', 'svnPliSnd',
                'svnPliTrd', 'ethPliFst', 'ethPliSnd', 'ethPliTrd', 'fstPliFoh', 'fstPliFih', 'fstPliSix', 'sndPliFoh', 'sndPliFih', 'sndPliSix', 'trdPliFoh', 'trdPliFih', 'trdPliSix', 'fohPliFoh', 'fohPliFih', 'fohPliSix', 'fihPliFoh', 'fihPliFih', 'fihPliSix', 'sixPliFoh', 'sixPliFih', 'sixPliSix', 'svnPliFoh', 'svnPliFih', 'svnPliSix', 'ethPliFoh', 'ethPliFih', 'ethPliSix', 'fstMbFst', 'fstMbSnd', 'sndMbFst', 'sndMbSnd', 'trdMbFst', 'trdMbSnd', 'fohMbFst', 'fohMbSnd', 'fihMbFst', 'fihMbSnd',
                'sixMbFst', 'sixMbSnd', 'svnMbFst', 'svnMbSnd', 'ethMbFst', 'ethMbSnd', 'fstOpFst', 'sndOpFst', 'trdOpFst', 'fohOpFst', 'fihOpFst', 'sixOpFst', 'svnOpFst', 'ethOpFst', 'fstOpSnd', 'sndOpSnd', 'trdOpSnd', 'fohOpSnd', 'fihOpSnd', 'sixOpSnd', 'svnOpSnd', 'ethOpSnd', 'fstKtFst', 'fstKtSnd', 'fstKtTrd', 'sndKtFst', 'sndKtSnd', 'sndKtTrd', 'trdKtFst', 'trdKtSnd', 'trdKtTrd', 'fohKtFst', 'fohKtSnd', 'fohKtTrd', 'fihKtFst', 'fihKtSnd', 'fihKtTrd', 'sixKtFst', 'sixKtSnd', 'sixKtTrd',
                'svnKtFst', 'svnKtSnd', 'svnKtTrd', 'ethKtFst', 'ethKtSnd', 'ethKtTrd', 'fstKtFoh', 'fstKtFih', 'fstKtSix', 'sndKtFoh', 'sndKtFih', 'sndKtSix', 'trdKtFoh', 'trdKtFih', 'trdKtSix', 'fohKtFoh', 'fohKtFih', 'fohKtSix', 'fihKtFoh', 'fihKtFih', 'fihKtSix', 'sixKtFoh', 'sixKtFih', 'sixKtSix', 'svnKtFoh', 'svnKtFih', 'svnKtSix', 'ethKtFoh', 'ethKtFih', 'ethKtSix', 'fstFiFst', 'sndFiFst', 'trdFiFst', 'fstFiSnd', 'sndFiSnd', 'trdFiSnd'];*/
        var array = ['val1', 'val2', 'val3', 'val4', 'val5', 'val6', 'val7', 'val8', 'val9', 'val10', 'val11', 'val12', 'val13', 'val14', 'val15', 'val16', 'val17', 'val18', 'val19', 'val20', 'val21', 'val22', 'val23', 'val24', 'val25', 'val26', 'val27', 'val28', 'val29', 'val30', 'val31', 'val32', 'val33', 'val34', 'val35', 'val36', 'val37', 'val38', 'val39',
                     'val40', 'val41', 'val42', 'val43', 'val44', 'val45', 'val46', 'val47', 'val48', 'val49', 'val50', 'val51', 'val52', 'val53', 'val54', 'val55', 'val56', 'val57', 'val58', 'val59', 'val60', 'val61', 'val62', 'val63', 'val64', 'val65', 'val66', 'val67', 'val68', 'val69', 'val70', 'val71', 'val72', 'val73', 'val74', 'val75', 'val76', 'val77', 'val78', 'val79',
                     'val80', 'val81', 'val82', 'val83', 'val84', 'val85', 'val86', 'val87', 'val88', 'val89', 'val90', 'val91', 'val92', 'val93', 'val94', 'val95', 'val96', 'val97', 'val98', 'val99', 'val100', 'val101', 'val102', 'val103', 'val104', 'val105', 'val106', 'val107', 'val108', 'val109', 'val110', 'val111', 'val112', 'val113', 'val114', 'val115', 'val116', 'val117',
                     'val118', 'val119', 'val120', 'val121', 'val122', 'val123', 'val124', 'val125', 'val126', 'val127', 'val128', 'val129', 'val130', 'val131', 'val132', 'val133', 'val134', 'val135', 'val136', 'val137', 'val138', 'val139', 'val140', 'val141', 'val142', 'val143', 'val144', 'val145', 'val146', 'val147', 'val148', 'val149', 'val150', 'val151', 'val152', 'val153', 'val154',
                     'val155', 'val156', 'val157', 'val158', 'val159', 'val160', 'val161', 'val162', 'val163', 'val164', 'val165', 'val166', 'val167', 'val168', 'val169', 'val170', 'val171', 'val172', 'val173', 'val174', 'val175', 'val176', 'val177', 'val178', 'val179', 'val180', 'val181', 'val182', 'val183', 'val184', 'val185', 'val186', 'val187', 'val188', 'val189', 'val190', 'val191', 'val192',
                     'val193', 'val194', 'val195', 'val196', 'val197', 'val198', 'val199', 'val200', 'val201', 'val202', 'val203', 'val204', 'val205', 'val206', 'val207', 'val208', 'val209', 'val210', 'val211', 'val212', 'val213', 'val214', 'val215', 'val216', 'val217', 'val218', 'val219', 'val220', 'val221', 'val222', 'val223', 'val224', 'val225', 'val226', 'val227', 'val228', 'val229',
                     'val230', 'val231', 'val232', 'val233', 'val234', 'val235', 'val236', 'val237', 'val238', 'val239', 'val240', 'val241', 'val242', 'val243', 'val244', 'val245', 'val246', 'val247', 'val248', 'val249', 'val250', 'val251', 'val252', 'val253', 'val254', 'val255', 'val256', 'val257', 'val258', 'val259', 'val260', 'val261', 'val262', 'val263', 'val264', 'val265'];
        var i = 0; 
        var texts = this.query('textfield[rowNo!=undefined]');
        Ext.Array.each(texts, function(text){
             text.name = array[i];
             i++;
        })
    }
})