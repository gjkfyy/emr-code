Ext.define('iih.mr.tth.block.TeethExamBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['iih.mr.tth.view.TeethTopExamView',
               'iih.mr.tth.view.TeethButtonView',
               'iih.mr.tth.view.TeethBottomExamView',
               'iih.mr.tth.block.TeethContentBlock'],

    alias:'widget.teethexamblock',
    
    layout:{
        type:'vbox',
        align:'stretch'
    },
    
    overflowY: 'auto',
    
    border: false,
    
    items: [{
        xtype:'teethtopexamview',
        height:550
    },{
        xtype:'teethbuttonview',
        border:0,
        height:70
    },{
        xtype:'teethbottomexamview',
        height:550
    },{
        xtype:'teethcontentblock',
        height:130
    }],
    
    tbar:[{
        xtype:'button',iconCls: 'icon-save',text:'保存',method: 'create'
    },{
        xtype:'button',iconCls: 'icon-Delete',text:'删除',method: 'delete',disabled: true,
        handler: function(btn, e){
            var view = btn.up('teethexamview'); 
            XapMessageBox.confirm2('是否确认删除？',
                function(btn, text){
                    if (btn == 'yes') {
                        var chain = view.getActionChain('delete');
                        chain.execute();
                    }
                }
            );
        }
    },{
        xtype:'button',iconCls: 'icon-Open',text:'打印',method: 'print',disabled: true,
        handler: function(btn, e){
            var view = btn.up('teethexamview');
            var enPk = view.down('xaptextfield[name=enPk]').getValue();
            var viewConfig = {
                enPk:enPk
            };
            var config = {
                pageCode: 'teethreportview',
                pageTitle: '牙齿及牙周组织检查表',
                xclass: 'iih.mr.tth.view.TeethReportView',
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("addWorkPage",config);
        }
    }],

    initComponent: function() {
        this.callParent();
        var me = this;
        var tl = me.down('teethtopleftblock');
        var tr = me.down('teethtoprightblock');
        var bl = me.down('teethbottomleftblock');
        var br = me.down('teethbottomrightblock');
        var index = 1;
        var texts = me.query('textfield[hidden!=true][bcheck!=true][lcheck!=true][bText!=true][lText!=true]');
        index = this.setIndex(texts, index, false, false);
        texts = tl.query('textfield[bText=true]');
        index = this.setIndex(texts, index, false, true);
        texts = tr.query('textfield[bText=true]');
        index = this.setIndex(texts, index, false, true);
        texts = tl.query('textfield[lText=true]');
        index = this.setIndex(texts, index, true, true);
        texts = tr.query('textfield[lText=true]');
        index = this.setIndex(texts, index, true, true);
        texts = bl.query('textfield[lText=true]');
        index = this.setIndex(texts, index, true, true);
        texts = br.query('textfield[lText=true]');
        index = this.setIndex(texts, index, true, true);
        texts = bl.query('textfield[bText=true]');
        index = this.setIndex(texts, index, true, false);
        texts = br.query('textfield[bText=true]');
        index = this.setIndex(texts, index, true, false);
    },
    
    setIndex : function(texts, index, up, down) {
        var me = this;
        Ext.Array.each(texts, function(text){
            text.tabIndex = index;
            index++;
            text.addListener('specialkey', function(t,e){
                if (e.getKey() == e.LEFT) {
                    //var prevIndex = text.tabIndex - 1;
                    //var prev = me.down('textfield[tabIndex='+prevIndex+']');
                    //if(prev) prev.focus();
                    me.getFocusObject(text.tabIndex, -1);
                };
                if (e.getKey() == e.RIGHT) {
                    //var nextIndex = text.tabIndex + 1;
                    //var next = me.down('textfield[tabIndex='+nextIndex+']');
                    //if(next) next.focus();
                    me.getFocusObject(text.tabIndex, 1);
                };
                if(up){
                    if (e.getKey() == e.UP) {
                        var nextIndex = text.tabIndex - 48;
                        var next = me.down('textfield[tabIndex='+nextIndex+']');
                        if(next) next.focus();
                    }
                };
                if(down){
                    if (e.getKey() == e.DOWN) {
                        var nextIndex = text.tabIndex + 48;
                        var next = me.down('textfield[tabIndex='+nextIndex+']');
                        if(next) next.focus();
                    }
                };
            })
        });
        return index;
    },
    
    getFocusObject: function(tabIndex,dire) {
        var o = this.down('textfield[tabIndex='+(tabIndex+dire)+']');
        if(o){
            if(o.disabled){
                this.getFocusObject(tabIndex+dire,dire);
            }else{
                o.focus();
            } 
        }
    },
    
    /*setData: function(data) {
        if (Ext.isObject(data)) {
            if (data.teethExamItemArray && data.teethExamItemArray.length > 3) {
                var tl = this.down('teethtopleftblock');
                tl.setData(data.teethExamItemArray[0]);
                var tr = this.down('teethtoprightblock');
                tr.setData(data.teethExamItemArray[1]);
                var bl = this.down('teethbottomleftblock');
                bl.setData(data.teethExamItemArray[2]);
                var br = this.down('teethbottomrightblock');
                br.setData(data.teethExamItemArray[3]);
                var checkTexts = this.query('textfield[bcheck=true]');
                Ext.Array.each(checkTexts, function(text){
                    if(text.getValue() == '●') 
                        text.show();
                    else
                        text.hide();
                });
                var checkTexts = this.query('textfield[lcheck=true]');
                Ext.Array.each(checkTexts, function(text){
                    if(text.getValue() == '●') 
                        text.show()
                    else
                        text.hide();
                });
            };
            var content = this.down('teethcontentblock');
            content.setData(data);
            
            var delButton = this.down('button[method=delete]');
            var text = this.down('xaptextfield[name=teethPk]');
            var pk = text.getValue();
            if(pk)
                delButton.setDisabled(false);
            else
                delButton.setDisabled(true);
        }
    }*/
    
    setData: function(data) {
        if (Ext.isObject(data)) {
            if (data.teethExamItemArray && data.teethExamItemArray.length > 3) {
                var tl = this.down('teethtopleftblock');
                var tlData = data.teethExamItemArray[0];
                this.setItemData(tl, tlData);
                var tr = this.down('teethtoprightblock');
                var trData = data.teethExamItemArray[1];
                this.setItemData(tr, trData);
                var bl = this.down('teethbottomleftblock');
                var blData = data.teethExamItemArray[2];
                this.setItemData(bl, blData);
                var br = this.down('teethbottomrightblock');
                var brData = data.teethExamItemArray[3];
                this.setItemData(br, brData);
                var checkTexts = this.query('textfield[bcheck=true]');
                Ext.Array.each(checkTexts, function(text){
                    if(text.getValue() == '●') 
                        text.show();
                    else
                        text.hide();
                });
                var checkTexts = this.query('textfield[lcheck=true]');
                Ext.Array.each(checkTexts, function(text){
                    if(text.getValue() == '●') 
                        text.show()
                    else
                        text.hide();
                });
            }
            var content = this.down('teethcontentblock');
            content.setData(data);
            
            var delButton = this.down('button[method=delete]');
            var prtButton = this.down('button[method=print]');
            var text = this.down('xaptextfield[name=teethPk]');
            var pk = text.getValue();
            if(pk){
                delButton.setDisabled(false);
                prtButton.setDisabled(false);
            }else{
                delButton.setDisabled(true);
                prtButton.setDisabled(true);
            }
        }
    },
    
    setItemData: function(block, data){
        //block.setData(data);
        var texts = block.query('textfield[rowNo!=undefined]');
        if(data.valueStr){
            var dataArray = data.valueStr.split(';');
            var values = this.createValues(dataArray);
            var i = 0;
            Ext.Array.each(texts, function(text){
                //text.setValue(dataArray[i]);
                Ext.apply(data,values);
                i++;
            });
        }else{
            var values = this.createValues(null);
            Ext.Array.each(texts, function(text){
                //text.setValue(null);
                Ext.apply(data,values);
            });
        };
        block.setData(data);
        for(var i=0;i<data.colDisabled.length;i++){
            var colValue = data.colDisabled.substr(i, 1);
            var texts = block.query('textfield[colNo='+(i+1)+']');
            Ext.Array.each(texts, function(t){
                if(colValue == '0'){
                    t.setDisabled(false);
                }else{
                    //t.setValue(null);
                    t.setDisabled(true);  
                }
            });
            var divs = block.query('container[colNo='+(i+1)+']');
            Ext.Array.each(divs, function(d){
                var t = d.down('textfield');
                if(colValue == '0'){
                    d.getEl().dom.style.border = '1px solid #b5b8c8';
                    d.getEl().dom.style.borderBottom = 'none';
                    t.setDisabled(false);
                }else{
                    //t.setValue(null);
                    t.hide();
                    d.getEl().dom.style.border = 'none';
                    t.setDisabled(true);  
                }
            });
        }
    },
    
    createValues: function(dataArray){
        if(dataArray){
            var values = {
                    'val1': dataArray[0],
                    'val2': dataArray[1],
                    'val3': dataArray[2],
                    'val4': dataArray[3],
                    'val5': dataArray[4],
                    'val6': dataArray[5],
                    'val7': dataArray[6],
                    'val8': dataArray[7],
                    'val9': dataArray[8],
                    'val10': dataArray[9],
                    'val11': dataArray[10],
                    'val12': dataArray[11],
                    'val13': dataArray[12],
                    'val14': dataArray[13],
                    'val15': dataArray[14],
                    'val16': dataArray[15],
                    'val17': dataArray[16],
                    'val18': dataArray[17],
                    'val19': dataArray[18],
                    'val20': dataArray[19],
                    'val21': dataArray[20],
                    'val22': dataArray[21],
                    'val23': dataArray[22],
                    'val24': dataArray[23],
                    'val25': dataArray[24],
                    'val26': dataArray[25],
                    'val27': dataArray[26],
                    'val28': dataArray[27],
                    'val29': dataArray[28],
                    'val30': dataArray[29],
                    'val31': dataArray[30],
                    'val32': dataArray[31],
                    'val33': dataArray[32],
                    'val34': dataArray[33],
                    'val35': dataArray[34],
                    'val36': dataArray[35],
                    'val37': dataArray[36],
                    'val38': dataArray[37],
                    'val39': dataArray[38],
                    'val40': dataArray[39],
                    'val41': dataArray[40],
                    'val42': dataArray[41],
                    'val43': dataArray[42],
                    'val44': dataArray[43],
                    'val45': dataArray[44],
                    'val46': dataArray[45],
                    'val47': dataArray[46],
                    'val48': dataArray[47],
                    'val49': dataArray[48],
                    'val50': dataArray[49],
                    'val51': dataArray[50],
                    'val52': dataArray[51],
                    'val53': dataArray[52],
                    'val54': dataArray[53],
                    'val55': dataArray[54],
                    'val56': dataArray[55],
                    'val57': dataArray[56],
                    'val58': dataArray[57],
                    'val59': dataArray[58],
                    'val60': dataArray[59],
                    'val61': dataArray[60],
                    'val62': dataArray[61],
                    'val63': dataArray[62],
                    'val64': dataArray[63],
                    'val65': dataArray[64],
                    'val66': dataArray[65],
                    'val67': dataArray[66],
                    'val68': dataArray[67],
                    'val69': dataArray[68],
                    'val70': dataArray[69],
                    'val71': dataArray[70],
                    'val72': dataArray[71],
                    'val73': dataArray[72],
                    'val74': dataArray[73],
                    'val75': dataArray[74],
                    'val76': dataArray[75],
                    'val77': dataArray[76],
                    'val78': dataArray[77],
                    'val79': dataArray[78],
                    'val80': dataArray[79],
                    'val81': dataArray[80],
                    'val82': dataArray[81],
                    'val83': dataArray[82],
                    'val84': dataArray[83],
                    'val85': dataArray[84],
                    'val86': dataArray[85],
                    'val87': dataArray[86],
                    'val88': dataArray[87],
                    'val89': dataArray[88],
                    'val90': dataArray[89],
                    'val91': dataArray[90],
                    'val92': dataArray[91],
                    'val93': dataArray[92],
                    'val94': dataArray[93],
                    'val95': dataArray[94],
                    'val96': dataArray[95],
                    'val97': dataArray[96],
                    'val98': dataArray[97],
                    'val99': dataArray[98],
                    'val100': dataArray[99],
                    'val101': dataArray[100],
                    'val102': dataArray[101],
                    'val103': dataArray[102],
                    'val104': dataArray[103],
                    'val105': dataArray[104],
                    'val106': dataArray[105],
                    'val107': dataArray[106],
                    'val108': dataArray[107],
                    'val109': dataArray[108],
                    'val110': dataArray[109],
                    'val111': dataArray[110],
                    'val112': dataArray[111],
                    'val113': dataArray[112],
                    'val114': dataArray[113],
                    'val115': dataArray[114],
                    'val116': dataArray[115],
                    'val117': dataArray[116],
                    'val118': dataArray[117],
                    'val119': dataArray[118],
                    'val120': dataArray[119],
                    'val121': dataArray[120],
                    'val122': dataArray[121],
                    'val123': dataArray[122],
                    'val124': dataArray[123],
                    'val125': dataArray[124],
                    'val126': dataArray[125],
                    'val127': dataArray[126],
                    'val128': dataArray[127],
                    'val129': dataArray[128],
                    'val130': dataArray[129],
                    'val131': dataArray[130],
                    'val132': dataArray[131],
                    'val133': dataArray[132],
                    'val134': dataArray[133],
                    'val135': dataArray[134],
                    'val136': dataArray[135],
                    'val137': dataArray[136],
                    'val138': dataArray[137],
                    'val139': dataArray[138],
                    'val140': dataArray[139],
                    'val141': dataArray[140],
                    'val142': dataArray[141],
                    'val143': dataArray[142],
                    'val144': dataArray[143],
                    'val145': dataArray[144],
                    'val146': dataArray[145],
                    'val147': dataArray[146],
                    'val148': dataArray[147],
                    'val149': dataArray[148],
                    'val150': dataArray[149],
                    'val151': dataArray[150],
                    'val152': dataArray[151],
                    'val153': dataArray[152],
                    'val154': dataArray[153],
                    'val155': dataArray[154],
                    'val156': dataArray[155],
                    'val157': dataArray[156],
                    'val158': dataArray[157],
                    'val159': dataArray[158],
                    'val160': dataArray[159],
                    'val161': dataArray[160],
                    'val162': dataArray[161],
                    'val163': dataArray[162],
                    'val164': dataArray[163],
                    'val165': dataArray[164],
                    'val166': dataArray[165],
                    'val167': dataArray[166],
                    'val168': dataArray[167],
                    'val169': dataArray[168],
                    'val170': dataArray[169],
                    'val171': dataArray[170],
                    'val172': dataArray[171],
                    'val173': dataArray[172],
                    'val174': dataArray[173],
                    'val175': dataArray[174],
                    'val176': dataArray[175],
                    'val177': dataArray[176],
                    'val178': dataArray[177],
                    'val179': dataArray[178],
                    'val180': dataArray[179],
                    'val181': dataArray[180],
                    'val182': dataArray[181],
                    'val183': dataArray[182],
                    'val184': dataArray[183],
                    'val185': dataArray[184],
                    'val186': dataArray[185],
                    'val187': dataArray[186],
                    'val188': dataArray[187],
                    'val189': dataArray[188],
                    'val190': dataArray[189],
                    'val191': dataArray[190],
                    'val192': dataArray[191],
                    'val193': dataArray[192],
                    'val194': dataArray[193],
                    'val195': dataArray[194],
                    'val196': dataArray[195],
                    'val197': dataArray[196],
                    'val198': dataArray[197],
                    'val199': dataArray[198],
                    'val200': dataArray[199],
                    'val201': dataArray[200],
                    'val202': dataArray[201],
                    'val203': dataArray[202],
                    'val204': dataArray[203],
                    'val205': dataArray[204],
                    'val206': dataArray[205],
                    'val207': dataArray[206],
                    'val208': dataArray[207],
                    'val209': dataArray[208],
                    'val210': dataArray[209],
                    'val211': dataArray[210],
                    'val212': dataArray[211],
                    'val213': dataArray[212],
                    'val214': dataArray[213],
                    'val215': dataArray[214],
                    'val216': dataArray[215],
                    'val217': dataArray[216],
                    'val218': dataArray[217],
                    'val219': dataArray[218],
                    'val220': dataArray[219],
                    'val221': dataArray[220],
                    'val222': dataArray[221],
                    'val223': dataArray[222],
                    'val224': dataArray[223],
                    'val225': dataArray[224],
                    'val226': dataArray[225],
                    'val227': dataArray[226],
                    'val228': dataArray[227],
                    'val229': dataArray[228],
                    'val230': dataArray[229],
                    'val231': dataArray[230],
                    'val232': dataArray[231],
                    'val233': dataArray[232],
                    'val234': dataArray[233],
                    'val235': dataArray[234],
                    'val236': dataArray[235],
                    'val237': dataArray[236],
                    'val238': dataArray[237],
                    'val239': dataArray[238],
                    'val240': dataArray[239],
                    'val241': dataArray[240],
                    'val242': dataArray[241],
                    'val243': dataArray[242],
                    'val244': dataArray[243],
                    'val245': dataArray[244],
                    'val246': dataArray[245],
                    'val247': dataArray[246],
                    'val248': dataArray[247],
                    'val249': dataArray[248],
                    'val250': dataArray[249],
                    'val251': dataArray[250],
                    'val252': dataArray[251],
                    'val253': dataArray[252],
                    'val254': dataArray[253],
                    'val255': dataArray[254],
                    'val256': dataArray[255],
                    'val257': dataArray[256],
                    'val258': dataArray[257],
                    'val259': dataArray[258],
                    'val260': dataArray[259],
                    'val261': dataArray[260],
                    'val262': dataArray[261],
                    'val263': dataArray[262],
                    'val264': dataArray[263],
                    'val265': dataArray[264]
            }
        }else{
            var values = {
                    'val1': null,
                    'val2': null,
                    'val3': null,
                    'val4': null,
                    'val5': null,
                    'val6': null,
                    'val7': null,
                    'val8': null,
                    'val9': null,
                    'val10': null,
                    'val11': null,
                    'val12': null,
                    'val13': null,
                    'val14': null,
                    'val15': null,
                    'val16': null,
                    'val17': null,
                    'val18': null,
                    'val19': null,
                    'val20': null,
                    'val21': null,
                    'val22': null,
                    'val23': null,
                    'val24': null,
                    'val25': null,
                    'val26': null,
                    'val27': null,
                    'val28': null,
                    'val29': null,
                    'val30': null,
                    'val31': null,
                    'val32': null,
                    'val33': null,
                    'val34': null,
                    'val35': null,
                    'val36': null,
                    'val37': null,
                    'val38': null,
                    'val39': null,
                    'val40': null,
                    'val41': null,
                    'val42': null,
                    'val43': null,
                    'val44': null,
                    'val45': null,
                    'val46': null,
                    'val47': null,
                    'val48': null,
                    'val49': null,
                    'val50': null,
                    'val51': null,
                    'val52': null,
                    'val53': null,
                    'val54': null,
                    'val55': null,
                    'val56': null,
                    'val57': null,
                    'val58': null,
                    'val59': null,
                    'val60': null,
                    'val61': null,
                    'val62': null,
                    'val63': null,
                    'val64': null,
                    'val65': null,
                    'val66': null,
                    'val67': null,
                    'val68': null,
                    'val69': null,
                    'val70': null,
                    'val71': null,
                    'val72': null,
                    'val73': null,
                    'val74': null,
                    'val75': null,
                    'val76': null,
                    'val77': null,
                    'val78': null,
                    'val79': null,
                    'val80': null,
                    'val81': null,
                    'val82': null,
                    'val83': null,
                    'val84': null,
                    'val85': null,
                    'val86': null,
                    'val87': null,
                    'val88': null,
                    'val89': null,
                    'val90': null,
                    'val91': null,
                    'val92': null,
                    'val93': null,
                    'val94': null,
                    'val95': null,
                    'val96': null,
                    'val97': null,
                    'val98': null,
                    'val99': null,
                    'val100': null,
                    'val101': null,
                    'val102': null,
                    'val103': null,
                    'val104': null,
                    'val105': null,
                    'val106': null,
                    'val107': null,
                    'val108': null,
                    'val109': null,
                    'val110': null,
                    'val111': null,
                    'val112': null,
                    'val113': null,
                    'val114': null,
                    'val115': null,
                    'val116': null,
                    'val117': null,
                    'val118': null,
                    'val119': null,
                    'val120': null,
                    'val121': null,
                    'val122': null,
                    'val123': null,
                    'val124': null,
                    'val125': null,
                    'val126': null,
                    'val127': null,
                    'val128': null,
                    'val129': null,
                    'val130': null,
                    'val131': null,
                    'val132': null,
                    'val133': null,
                    'val134': null,
                    'val135': null,
                    'val136': null,
                    'val137': null,
                    'val138': null,
                    'val139': null,
                    'val140': null,
                    'val141': null,
                    'val142': null,
                    'val143': null,
                    'val144': null,
                    'val145': null,
                    'val146': null,
                    'val147': null,
                    'val148': null,
                    'val149': null,
                    'val150': null,
                    'val151': null,
                    'val152': null,
                    'val153': null,
                    'val154': null,
                    'val155': null,
                    'val156': null,
                    'val157': null,
                    'val158': null,
                    'val159': null,
                    'val160': null,
                    'val161': null,
                    'val162': null,
                    'val163': null,
                    'val164': null,
                    'val165': null,
                    'val166': null,
                    'val167': null,
                    'val168': null,
                    'val169': null,
                    'val170': null,
                    'val171': null,
                    'val172': null,
                    'val173': null,
                    'val174': null,
                    'val175': null,
                    'val176': null,
                    'val177': null,
                    'val178': null,
                    'val179': null,
                    'val180': null,
                    'val181': null,
                    'val182': null,
                    'val183': null,
                    'val184': null,
                    'val185': null,
                    'val186': null,
                    'val187': null,
                    'val188': null,
                    'val189': null,
                    'val190': null,
                    'val191': null,
                    'val192': null,
                    'val193': null,
                    'val194': null,
                    'val195': null,
                    'val196': null,
                    'val197': null,
                    'val198': null,
                    'val199': null,
                    'val200': null,
                    'val201': null,
                    'val202': null,
                    'val203': null,
                    'val204': null,
                    'val205': null,
                    'val206': null,
                    'val207': null,
                    'val208': null,
                    'val209': null,
                    'val210': null,
                    'val211': null,
                    'val212': null,
                    'val213': null,
                    'val214': null,
                    'val215': null,
                    'val216': null,
                    'val217': null,
                    'val218': null,
                    'val219': null,
                    'val220': null,
                    'val221': null,
                    'val222': null,
                    'val223': null,
                    'val224': null,
                    'val225': null,
                    'val226': null,
                    'val227': null,
                    'val228': null,
                    'val229': null,
                    'val230': null,
                    'val231': null,
                    'val232': null,
                    'val233': null,
                    'val234': null,
                    'val235': null,
                    'val236': null,
                    'val237': null,
                    'val238': null,
                    'val239': null,
                    'val240': null,
                    'val241': null,
                    'val242': null,
                    'val243': null,
                    'val244': null,
                    'val245': null,
                    'val246': null,
                    'val247': null,
                    'val248': null,
                    'val249': null,
                    'val250': null,
                    'val251': null,
                    'val252': null,
                    'val253': null,
                    'val254': null,
                    'val255': null,
                    'val256': null,
                    'val257': null,
                    'val258': null,
                    'val259': null,
                    'val260': null,
                    'val261': null,
                    'val262': null,
                    'val263': null,
                    'val264': null,
                    'val265': null    
            }
        }
        return values;
    },
    
    getData: function(encounterSn){
        var me = this;
        var datasArr = [];
        var tl = me.down('teethtopleftblock');
        var tlData = this.getItemData(tl);
        datasArr.push(tlData);
        var tr = me.down('teethtoprightblock');
        var trData = this.getItemData(tr);
        datasArr.push(trData);
        var bl = me.down('teethbottomleftblock');
        var blData = this.getItemData(bl);
        datasArr.push(blData);
        var br = me.down('teethbottomrightblock');
        var brData = this.getItemData(br);;
        datasArr.push(brData);
        var content = me.down('teethcontentblock');
        var enPk = content.down('xaptextfield[name=enPk]');
        enPk.setValue(encounterSn?encounterSn:IMER_GLOBAL.encounterSn);
        var examDoctorCd = content.down('xaptextfield[name=examDoctorCd]');
        examDoctorCd.setValue(IMER_GLOBAL.user.code);
        var data = content.getData();
        Ext.apply(data,{
            'TeethExamItemArray': datasArr
        });
        var bleeding = me.query('xaptextfield[value=●]');
        var bTexts = me.query('xaptextfield[bText=true]');
        var valueCount = 0;
        Ext.Array.each(bTexts, function(text){
            if(text.getValue())
                valueCount++;
        });
        var lTexts = me.query('xaptextfield[lText=true]');
        var lValue = 0;
        Ext.Array.each(lTexts, function(text){
            if(text.getValue())
                valueCount++;
        });
        Ext.apply(data,{
            'bleeding': bleeding.length,
            'blValueCount': valueCount
        });
        return data;
    },
    
    getItemData: function(block){
        var data = {};
        var itemPk = block.down('xaptextfield[name=teethItemPk]').getValue();
        var pk = block.down('xaptextfield[name=teethPk]').getValue();
        var location = block.down('xaptextfield[name=teethLocation]').getValue();
        var colStr = block.down('xaptextfield[name=colDisabled]').getValue();
        var texts = block.query('textfield[rowNo!=undefined]');
        var valueStr = '';
        Ext.Array.each(texts, function(text){
            valueStr = valueStr + text.getValue() + ';';
        });
        Ext.apply(data,{
            'teethItemPk': itemPk,
            'teethPk': pk,
            'teethLocation': location,
            'colDisabled': colStr,
            'valueStr': valueStr
        });
        return data;
    }
})