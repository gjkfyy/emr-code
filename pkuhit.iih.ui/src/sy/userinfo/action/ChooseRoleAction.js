Ext.define('iih.sy.userinfo.action.ChooseRoleAction', {
			extend : 'Xap.ej.action.ServiceInvocation',

			requires : [],

			/*
			 * @Override
			 */
			execute : function(context) {
//				this.callParent();
				var rb = this.getBlock('result');
				var roleList = context.event.arguments[1].data.roleList; //获取科室表
				var deptGrid = rb.down('xapgrid[name=deptgrid]') //获取科室表
				var roleGrid = rb.down('xapgrid[name=rolegrid]') //获取角色表
		        var reviewform = rb.down('xapform[name=reviewform]'); //获取审签级别
		        var drcdctform = rb.down('xapform[name=drcdctform]'); //默认三级医师
				var roleData = roleGrid.getData();
				roleGrid.getSelectionModel().deselectAll(true); //清空已选中的
				reviewform.getForm().reset();//清空
				drcdctform.getForm().reset();//清空
				if(roleList.length > 0){
					for (i = 0; i < roleList.length; i++) {
						for(j=0;j<roleData.length;j++){
							if(roleList[i].roleCode == roleData[j].roleCode){
								roleGrid.getSelectionModel().select(j,true,true);//角色挨个选中
								roleData[j].code = roleList[i].code;
								//roleData[j].startUsetTime = roleList[i].startUsetTime;
								//roleData[j].stopUsetTime = roleList[i].stopUsetTime;
							}
						}
					}
				}
				var select = deptGrid.getSelectionModel().getSelection()[0];
				//deptGrid.searchParam = {'deptCd': IMER_GLOBAL.department.code};
				var curDeputyDrcDct = rb.down('comboxgrid[name=curDeputyDrcDctId]');
				curDeputyDrcDct.searchParam = {'deptCd': IMER_GLOBAL.department.code};
				var curDrcDct = rb.down('comboxgrid[name=curDrcDctId]');
				curDrcDct.searchParam = {'deptCd': IMER_GLOBAL.department.code};
				if(select){
				    curDeputyDrcDct.searchParam = {'deptCd': select.data.organizationCode};
				    curDrcDct.searchParam = {'deptCd': select.data.organizationCode};
					var signLvlCdR = reviewform.down('xapradiogroup').items.items;
		             for(var i=0; i<signLvlCdR.length; i++){
		             	if(signLvlCdR[i].inputValue==select.data.signLvlCd){
		             		signLvlCdR[i].checked = true;
		             		signLvlCdR[i].setValue(true);
		             	}
		             }
		            drcdctform.setData(select.data);
				}
			}
		});
