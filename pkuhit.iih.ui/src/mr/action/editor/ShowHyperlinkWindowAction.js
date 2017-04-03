Ext.define('iih.mr.action.editor.ShowHyperlinkWindowAction', {
	extend : 'Xap.ej.action.PopAction',

	requires : [ 'iih.mr.archive.patient_mediclRecord_archive.view.MediclRecordView' ],

	execute : function(context) {
		var id = context.id;
		if(id == 'MR.M.014.D.1' ||id == 'MR.M.014.D.2' ||id == 'MR.M.014.D.3'){
			var plugin = document.getElementById('iemrEditor');
			var DeWin=Ext.getCmp("mddiWin");
	    	if(DeWin){
	    		console.info("关闭已经打开的");
	    		DeWin.close();
	    	}
	    	
			var win = new Ext.window.Window({
				id:'mddiWin',
				//title : title,
				plain: true, 
				header: false, 
				border: false, 
				closable: false, 
				frame:false,
				modal : true,
				width : 180,
				minHeight:33,
				height : 33,
				draggable : false, // 不允许拖拽
				resizable : false, // 不允许改变窗口大小
				closable : true, // 不显示关闭按钮
				collapsible : false, // 显示折叠按钮
				//modal : true,
				//layout : 'fit',
				x:context.x-50,
				y:context.y,
				items : [{
					id:'DiSelectId',
					xtype : 'comboxgrid',
					name : 'curDeptNm',
					method : 'curDeptNm',
					 style:'float:left',
					url : 'mr/md/shareElementDict/'+context.id,
					listWidth : 230, // gird的宽度
					width : 120, // combo的宽度
					valueField : 'code',// 科室编码的字段名
					displayField : 'name',// 科室名称的字段名
					columns : [ { // grid的column配置
						text : '编码',
						dataIndex : 'code',
						width : 80
					}, {
						text : '名称',
						flex : 1,
						dataIndex : 'name'
					} ],
					callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
						this.focus();
					  },
					listeners : {
						specialkey : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								var select= Ext.getCmp("DiSelectId").comboRecord;
					        	if(plugin){
					        		plugin.ImportExternalElem(select.name,select.code);
					        		Ext.getCmp("mddiWin").close();
						        	plugin.EnableOCX(true);
					        	}
							}
						}
						 
//						blur : function() {
//							var view = Ext.getCmp('mddiWin');
//							view.close();
//						}
					}
					
				},{
		            xtype: "button",
		            name: 'editorEvent',
		            //tooltip:'确认',
		            style:'float:left',
		            margin:'0 0 0 2',
		            iconCls:'icon-mdDiOk',
		            width:22,
			        height:22,
			        handler:function(){
			        	//获去选中值赋值
			        	var select= Ext.getCmp("DiSelectId").comboRecord;
			        	if(plugin){
			        		plugin.ImportExternalElem(select.name,select.code);
			        		Ext.getCmp("mddiWin").close();
				        	plugin.EnableOCX(true);
			        	}

			        }
		        },{
		            xtype: "button",
		            margin:'0 0 0 2',
		            //tooltip:'关闭',
		            iconCls:'icon-mdDiClose',
		            style:'float:left;margin-letf:5px;',
		            width:22,
			        height:22,
			        handler:function(){
			        	Ext.getCmp("mddiWin").close();
			        	plugin.EnableOCX(true);
			        }
		        } ]
			});
			plugin.EnableOCX(false);
			win.show();
		}else{
			var plugin = document.getElementById('iemrEditor');
			if(context.id == 'MR.M.014.D.4'){
				plugin.RemoveNamedElement('有无糖尿病病史');
			}else if(context.id == 'MR.M.014.D.5'){
				plugin.RemoveNamedElement('有无心脏病病史');
			}else if(context.id == 'MR.M.014.D.6'){
				plugin.RemoveNamedElement('有无脑血管疾病病史');
			}
			var String = '    其他情况：与本次疾病虽无紧密关系，但仍需治疗的其他疾病情况，可在现病史后另起一段予以记录。';
			var isString =['其他情况：'];
			var result = plugin.FindWordsFirst(isString);
			if(result == ''){
				plugin.GotoSection('现病史',true);
				if(plugin.IsBlankLine()){
					plugin.InsertText(String);
				}else{
					plugin.InsertText('\n' +String);
				}
			}
		}
	}
});
