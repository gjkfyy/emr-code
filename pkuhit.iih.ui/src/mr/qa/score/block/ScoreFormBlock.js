Ext.define('iih.mr.qa.score.block.ScoreFormBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextField',
		'Xap.ej.element.field.TextArea',
        'Xap.ej.element.field.DateField',
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.field.DisplayField'
	],

	alias:'widget.scoreformblock',

	layout:{
        type: 'table',
        columns: 8,
        tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 0,
            height:60,
            width: '100%'
        },
        tdAttrs: {
            valign: 'middle',
            align:'right'
            
        }},
        items: [
                { 
                   xtype:'xapdisplayfield',
  	               name:'score',
  	               columnWidth:1,
  	               labelAlign : 'right',
  	               fieldLabel:'病案得分'
  	               
                },{
	               xtype:'xapdisplayfield',
	               name:'lvl',
	               columnWidth:4,
	               labelAlign : 'right',
	               fieldLabel:'等级'
	           },{
	               xtype:'xapdisplayfield',
	               name:'qaDivideLevelCd',
	               width:100,
	               fieldLabel:'',
	               value:'',
	               hidden:true
	           },{
                   xtype:'tbspacer',
                   width:800
	           }],

	setData: function(data) {
        this.callParent(arguments);
    },
    getData: function() {
        this.callParent(arguments);
    }
})