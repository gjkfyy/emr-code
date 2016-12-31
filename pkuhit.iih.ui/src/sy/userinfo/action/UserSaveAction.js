Ext.define('iih.sy.userinfo.action.UserSaveAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var formBlock = this.getBlock('result').getBlock('right');
        var image = formBlock.down('imagecomponent');
		var signPictureShow = image.src;
		if(signPictureShow != undefined){
			var signPicture = signPictureShow.substring(22,signPictureShow.length)//图片签名
		}
        var deptGrid = this.getBlock('result').down('xapgrid[name=deptgrid]');
        var reviewform = this.getBlock('result').down('xapform[name=reviewform]'); //获取审签级别
        var drcdctform = this.getBlock('result').down('xapform[name=drcdctform]'); //默认三级医师

        var select = deptGrid.getSelectionModel().getSelection()[0];
        if(select==undefined){
        	var message = '请选择出诊科室！';
            XapMessageBox.info(message);
            return;
        }
        var signLvlCdR = reviewform.down('xapradiogroup').items.items;
        var signLvlCd ;
        for(var i=0; i<signLvlCdR.length; i++){
        	if(signLvlCdR[i].checked==true){
        		signLvlCd = signLvlCdR[i].inputValue;
        	}
        }
        var curDeputyDrcDctIdR = drcdctform.down('comboxgrid[name=curDeputyDrcDctId]');
        var curDeputyDrcDctId = curDeputyDrcDctIdR.comboxHiddenValue;
        var curDrcDctIdR = drcdctform.down('comboxgrid[name=curDrcDctId]');
        var curDrcDctId = curDrcDctIdR.comboxHiddenValue;
        var userBaseInfo = formBlock.getData();
        var deptList = deptGrid.getData(); 
        var userRoleList = [];
        var wardDeptList = [];
    	for(var i in deptList){
    		var dept = deptList[i];
    		var roleList = dept.roleList;
    		for(var j in roleList){
    			 roleList[j]['organizationCode'] = dept.organizationCode;
    		}
    		Array.prototype.push.apply(userRoleList, roleList);
    		//或者 userRoleList.concat(roleList);
		}
    	wardDeptList[0] = {'empDeptCd':select.data.empDeptCd,'signLvlCd':signLvlCd,'curDrcDctId':curDrcDctId,'curDeputyDrcDctId':curDeputyDrcDctId};
	    	
    	var data = {'id':userBaseInfo.hiddenData.id, 'password':userBaseInfo.password, 'statusCode':userBaseInfo.statusCode,'signPicture':signPicture, 'userRoleList':userRoleList, 'wardDeptList':wardDeptList};
    	console.log(data);
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var mclass = null;
    	var operation = {
            url: url + '/' + userBaseInfo.hiddenData.id,
    		mclass: mclass,
    		method: METHODS.METHOD_UPDATE,
    		data : data,
    		scope: this,
    		success: this.onSuccess,
            fail: this.onFail
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');// 当前页面是UserInfoLeftListView
        var deptGrid = block.down('xapgrid[name=deptgrid]');
    	var rowCount = deptGrid.getStore().getCount();
    	var lastrowindex = rowCount-1;//最后一行索引
    	var selectedGrid = deptGrid.getSelectionModel().getSelection()[0];;
    	var rowindex = deptGrid.store.indexOf(selectedGrid);//获得选中的第一项在store内的行号
    	
        var owner = this.getOwner();
        var formBlock = this.getBlock('result').getBlock('right');
        var userBaseInfo = formBlock.getData();
        var contentView = owner.getBlock('top');
        var chain = contentView.getActionChain('userRightList');
    	if(chain) {
        	chain.execute({
        		id: userBaseInfo.hiddenData.id,
        		rowindex:rowindex
        	});
    	}
    	
        XapMessageBox.info("保存成功");
    },
    onFail: function(operation) {
        XapMessageBox.info("保存失败");
    }
});
