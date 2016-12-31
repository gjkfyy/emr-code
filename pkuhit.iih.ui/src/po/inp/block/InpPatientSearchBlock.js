Ext.define('iih.po.inp.block.InpPatientSearchBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.CustomTrigger'],

    alias:'widget.inppatientsearchblock',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    border: 0,
    
    padding: '3 2 3 2',

    items: [{
        xtype: 'xaptrigger',
        name: 'inpsearch',
        onTriggerClick: function() {
            var view = this.up('inppatientnavigationview');
            var chain = view.getActionChain('searchPatient');
            chain.execute();
        },
        emptyText: '请输入床位号'
    },{
        layout: {
            type: 'hbox',
            align: 'stretch'
        },
        border: 0,
        items: [{
            xtype: 'splitbutton',
            name: 'group',
            text: '我的患者',
            flex: 1
        },{
            xtype: 'splitbutton',
            name: 'sort',
            width: 30
        }]
    }],
    
    createGroupMenu: function(me){
        var group = this.down('splitbutton[name=group]');
        return Ext.create('Ext.menu.Menu', {
            items: [{name: 'minePatient',text: '我的患者', checked: true, group: 'patient', value: 1},
                    {name: 'deptPatient',text: '科室患者', checked: false, group: 'patient', value: 2},
                    {name: 'tranfPatient',text: '转科患者', checked: false, group: 'patient', value: 3}],
            listeners: {
                click: function(menu, item, e) {
                    group.setText(item.text);
                    var view = me.up('inppatientnavigationview');
                    var chain = view.getActionChain('searchPatient');
                    chain.execute();
                }
            }
        })
    },
    
    createSortMenu: function(me){
        return Ext.create('Ext.menu.Menu', {
            items: [{name: 'currentBedCode',text: '床位号', checked: true, group: 'sort'},
                    {name: 'patientName',text: '患者姓名', checked: false, group: 'sort'},
                    {name: 'patientId',text: '住院号', checked: false, group: 'sort'}],
            listeners: {
                click: function(menu, item, e) {
                    var view = me.up('inppatientnavigationview');
                    var list = view.down('dataview');
                    var store = list.getStore();
                    store.sort(item.name);
                }
            }
        })
    },
    
    setData : function(data) {
        this.callParent(arguments);
    },
    
    getData : function() {
        var me = this;
        var trigger = me.down('xaptrigger');
        var group;
        var components = me.down('splitbutton[name=group]').menu.items.items;
        Ext.Array.each(components, function(item) {
            if(item.checked)
                group = item.value;
        });
        var sort;
        var components = me.down('splitbutton[name=sort]').menu.items.items;
        Ext.Array.each(components, function(item) {
            if(item.checked)
                sort = item.name;
        });
        var formData = {
            keyword: trigger.value,
            groupType: group,
            sort: sort
        };
        return formData;
    },
    
    initComponent: function() {
        this.callParent();
        var me = this;
        var group = this.down('splitbutton[name=group]');
        group.menu = this.createGroupMenu(me);
        var sort = this.down('splitbutton[name=sort]');
        sort.menu = this.createSortMenu(me);
    }
})