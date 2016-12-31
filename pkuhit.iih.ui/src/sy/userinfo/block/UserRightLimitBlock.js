var widthRate = 0.87
Ext.define('iih.sy.userinfo.block.UserRightLimitBlock', {
			extend : 'Xap.ej.block.FormBlock',

			requires : ['Xap.ej.element.field.ComboBox',
					'Xap.ej.element.field.ComboBoxGrid',
					'Xap.ej.element.form.Form'],

			alias : 'widget.userrightlimitblock',
			layout : {
				type : 'table',
				columns : 1,
				tableAttrs : {
					border : 0,
					cellpadding : 0,
					cellspacing : 1
					// width: '100%',
					// height:73
				},
				tdAttrs : {
					valign : 'left'
				}
			},
			items : [{
						xtype : 'xapcombobox',
//						labelWidth : 100,
//						labelAlign : 'right',
						name : 'prescribeLimit',
						fieldLabel : '处方权'
//						dictionary : 'DIM003'
//						width : 300 * widthRate

					}, {
						xtype : 'xapcombobox',
						labelWidth : 100,
						fieldLabel : '毒麻药权限'
					}, {
						xtype : 'xapcombobox',
						name : 'antibioticLimit',
						fieldLabel : '抗生素适用权限'
					}, {
						xtype : 'xapcombobox',
						name : 'operationRank',
						fieldLabel : '手术等级'
					}]
		})