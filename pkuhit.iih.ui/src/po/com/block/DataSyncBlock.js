Ext.define('iih.po.com.block.DataSyncBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.datasyncblock',

    layout: 'fit',
    
    border:false,
    
    tbar:[{
        xtype: 'button',
        text: '同步就诊',
        tooltip: '同步就诊',
        iconCls: 'icon-syncEn',
        action: 'syncEn'
    },{
        xtype: 'button',
        text: '同步科室/人员',
        tooltip: '同步科室/人员',
        iconCls: 'icon-syncDept',
        action: 'syncDept'
    },{
        xtype: 'button',
        text: ' 同步诊断',
        tooltip: '同步诊断',
        iconCls: 'icon-syncDi',
        action: 'syncDi'
    },{
        xtype: 'button',
        text: '同步病区ip配置',
        tooltip: '同步病区ip配置',
        iconCls: 'icon-syncDi',
        action: 'importNisWardConfig'
    }],
    
    initComponent: function() {
        var me = this;
        me.callParent();
    }
})