
/** 
 *
 * @extends Ext.grid.plugin.CellEditing
 * 
 * @author chenyajie<chen_yajie@founder.com>
 **/

Ext.define('Xap.ej.element.grid.plugin.CellEditing', {
	extend : 'Ext.grid.plugin.CellEditing',
	alias : ['widget.xapcellediting'],
	clicksToEdit: 1,
	listeners: {
		/*edit:function(editor, e){ 
			if(e.grid.isEditKeepSelect){
				e.grid.getSelectionModel().select(e.grid.records,true,true);
			};
		},*/
		beforeedit:function(editor, e){ 
			e.grid.records = e.grid.getSelectionModel( ).getSelection();
			e.grid.isEditSelect = true;
		}
	}
});
