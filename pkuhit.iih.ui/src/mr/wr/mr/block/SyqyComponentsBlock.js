Ext.define('iih.mr.wr.mr.block.SyqyComponentsBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.objectview.ObjectView'],

    alias:'widget.mrdoceditblock',

    layout: 'fit',
    items: [{
		xtype : 'displayfield',
		name : 'templeName',
		fieldLabel : '',
		labelAlign : 'right',
		anchor : '100% 88%',
		width : 230,
		height:230,
		renderer : function(value) {
			return "<object clsid=\"{A318A9AC-E75F-424C-9364-6B40A848FC6B}\"  TYPE=\"application/x-itst-activex\" width=\"0\" height=\"0\" id=\"zkonline\" ></object>";
		}
	}]
})