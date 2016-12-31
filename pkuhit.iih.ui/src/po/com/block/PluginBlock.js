Ext.define('iih.po.com.block.PluginBlock', {
    extend: 'Ext.container.Container',

    requires: [],

    alias:'widget.pluginblock',
    
    border: 0,
    
    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    initComponent: function() {
        if(CONFIG_PARAM.CA_SUBJECT == 1){
            if(this.pluginId == 1){
                this.items = [{
                    width:0,
                    height:0,
                    html:'<embed id=bj_ca_xtx type=application/x-xtx-axhost clsid={3F367B74-92D9-4C5E-AB93-234F8A91D5E6} event_OnUsbkeyChange=OnUsbKeyChange width=1 height=1 />'
                },{
                    width:0,
                    height:0,
                    html:'<embed id=bj_ca_dsvs type=application/x-xtx-axhost clsid={DA4B155C-F991-46C8-896D-2305B364CAA7} width=1 height=1 />'
                },{
                    width:0,
                    height:0,
                    html:'<embed id=bj_ca_pic type=application/x-xtx-axhost clsid={3BC3C868-95B5-47ED-8686-E0E3E94EF366} width=1 height=1 />'
                }];
            }else{
                this.items = [{
                    width:0,
                    height:0,
                    html:'<embed id=bj_ca_xtx2 type=application/x-xtx-axhost clsid={3F367B74-92D9-4C5E-AB93-234F8A91D5E6} event_OnUsbkeyChange=OnUsbKeyChange width=1 height=1 />'
                },{
                    width:0,
                    height:0,
                    html:'<embed id=bj_ca_dsvs2 type=application/x-xtx-axhost clsid={DA4B155C-F991-46C8-896D-2305B364CAA7} width=1 height=1 />'
                },{
                    width:0,
                    height:0,
                    html:'<embed id=bj_ca_pic2 type=application/x-xtx-axhost clsid={3BC3C868-95B5-47ED-8686-E0E3E94EF366} width=1 height=1 />'
                }];
            }
        }
        if(CONFIG_PARAM.CA_SUBJECT == 2){
            if(this.pluginId == 1){
                this.items = [{
                    width:0,
                    height:0,
                    html:'<embed id="net_ca" hidden="true" type="application/x-netcapki"/>'
                }];
            }else{
                this.items = [{
                    width:0,
                    height:0,
                    html:'<embed id="net_ca" hidden="true" type="application/x-netcapki"/>'
                }];
            }
        }
        this.callParent();
    }
})