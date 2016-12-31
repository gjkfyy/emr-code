Ext.define('iih.sy.userinfo.action.DeptSaveRoleAction', {
			extend : 'Xap.ej.action.ServiceInvocation',

			requires : [],

			/*
			 * @Override
			 */
			execute : function(context) {
				
				var rb = this.getBlock('result');
				var deptGrid = rb.down('xapgrid[name=deptgrid]'); //获取科室表
				var roleGrid = rb.down('xapgrid[name=rolegrid]') //获取角色表
				var rsDept = deptGrid.getSelectionModel().getSelection(); //获取选中的部门
				var rsRole = roleGrid.getSelectionModel().getSelection();//获取选中角色
		        var reviewform = rb.down('xapform[name=reviewform]'); //获取审签级别
		        var drcdctform = rb.down('xapform[name=drcdctform]'); //默认三级医师
				var deptStore = deptGrid.getStore();//获取业务科室的store
				var roleAll = [];
				
				if(rsDept.length > 0 && rsDept[0].data.organizationCode!=""){
					var selectDeptIndex = deptStore.indexOf(rsDept[0]);//获取选中行的索引		
					//角色
					for(i = 0;i < rsRole.length;i++){
						var obj = new Object();
			        	var role = Ext.Object.merge(obj, rsRole[i].data);
			        	//delete role['id'];
			        	roleAll.push(role);
						console.log(roleAll);
					}
					//审签等级
					var signLvlCdR = reviewform.down('xapradiogroup').items.items;
					var signLvlCd;
		             for(var i=0; i<signLvlCdR.length; i++){
		             	if(signLvlCdR[i].checked == true){
		             		signLvlCd = signLvlCdR[i].inputValue;
		             	}
		             }
					//默认三级医师
					var curDeputyDrcDctId = rsDept[0].data.curDeputyDrcDctId;
					var curDrcDctId = rsDept[0].data.curDrcDctId;
					var modRecord = deptStore.getAt(selectDeptIndex);
					modRecord.set('roleList',roleAll);
					modRecord.set('curDeputyDrcDctId',curDeputyDrcDctId);
					modRecord.set('curDrcDctId',curDrcDctId);
					modRecord.set('signLvlCd',signLvlCd);
				}else{
					roleGrid.getSelectionModel().deselectAll(true); //清空已选中的
					reviewform.getForm().reset();//清空
					drcdctform.getForm().reset();//清空
					var message = '请选择出诊科室！';
					XapMessageBox.info(message);
				}
			}
		});
