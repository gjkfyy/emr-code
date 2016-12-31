Ext.define('iih.sy.userinfo.block.ReportRightGridBlock', {
			extend : 'Xap.ej.block.Block',

			requires : ['Xap.ej.element.grid.Grid'],

			alias : 'widget.reportrightgridblock',

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
				title : '报表列表',
				xtype : 'xapgrid',
				rownumShow : true,
				mode : 'multi',
				checkOnly : true,
				height : 560,
				selType : 'cellmodel',
				checkboxShow : true,
				plugins : [ Ext.create('Xap.ej.element.grid.plugin.CellEditing') ],
				CM_JR_Record : [{
					header : '报表ID',
					dataIndex : 'reportCd',
					field : 'textfield',
					type : 'string',
					hidden : true
				}, {
					header : '报表名称',
					dataIndex : 'reportName',
					field : 'textfield',
					type : 'string',
					flex : 1
				}, {
					header : '报表描述',
					dataIndex : 'reportDes',
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
