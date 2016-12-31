Ext.define('iih.sy.userinfo.block.RoleLeftGridBlock', {
			extend : 'Xap.ej.block.Block',

			requires : ['Xap.ej.element.grid.Grid'],

			alias : 'widget.roleleftgridblock',

			layout : {
				type : 'table',
				border : '0',
				columns : 1,
				tableAttrs : {
					border : 0,
					cellpadding : 5,
					cellspacing : 1,
					width : '100%'
				},
				tdAttrs : {
					valign : 'left'
				}
			},

			items : [{
				title : '角色列表',
				xtype : 'xapgrid',
				rownumShow : false,
				height : 560,
				CM_JR_Record : [{
					header : '角色ID',
					dataIndex : 'code',
					field : 'textfield',
					type : 'string',
					hidden : true
				}, {
					header : '角色名称',
					dataIndex : 'name',
					field : 'textfield',
					type : 'string',
					flex : 1
				}]
			}],
			setData : function(data) {
				if (data) {
					var grid = this.down('xapgrid');
					if (grid) {
						if (data.dataList == null) {
							grid.setData([]);
						} else {
							grid.setData(data.dataList);
						}
					}
				}
			}
		})
