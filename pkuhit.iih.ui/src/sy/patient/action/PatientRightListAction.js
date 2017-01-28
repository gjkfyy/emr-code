Ext.define('iih.sy.patient.action.PatientRightListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		this.showLoading();
    	this.callParent();
    	var id;
    	var rowindex;
        var block = this.getBlock('result');// 当前页面是UserInfoLeftListView
    	if(context.event!=undefined){
    		 id = context.event.arguments[1].data.id;		//用户ID
    	}else{
    		 id = context.id;
    		 block.rowindex = context.rowindex;
    	}
        var operations = context.operations;
    	if(!operations) {
    		 return;
    	}
    	var url = this.url;
    	url += '/'+id;
    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('result');// 当前页面是UserInfoLeftListView
        var bfString = 'data:image/png;base64,';
        var deptGrid = block.down('xapgrid[name=deptgrid]');
        var roleGrid = block.down('xapgrid[name=rolegrid]'); //获取角色表
        var reviewform = block.down('xapform[name=reviewform]'); //获取审签级别
        var drcdctform = block.down('xapform[name=drcdctform]'); //默认三级医师
        console.log(deptGrid);
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        } else {
            block.setData(m.data);
        }
        var signPicture = m.data.signPicture;
        /*if(m.data.signPicture == null || m.data.signPicture == ''){
        	showSignPic.setSrc();
        }else{
        	var signPictureShow = bfString+signPicture;
            showSignPic.setSrc(signPictureShow);
        }
        deptGrid.getSelectionModel().deselectAll();
        var rowindex = block.rowindex;
        if(rowindex!=undefined){
        	deptGrid.getSelectionModel().select(rowindex,false,true);
        }else{
        	deptGrid.getSelectionModel().select(0,false,true);
        }
        var select = deptGrid.getSelectionModel().getSelection()[0];
        console.dir(select);
        if(select){
        	 deptGrid.fireEvent('comboxclick',deptGrid, select, null,0, null, null);
        	 deptGrid.searchParam = {'deptCd': IMER_GLOBAL.department.code};
        	 var signLvlCdR = reviewform.down('xapradiogroup').items.items;
             for(var i=0; i<signLvlCdR.length; i++){
             	if(signLvlCdR[i].inputValue==select.data.signLvlCd){
             		signLvlCdR[i].checked = true;
             		signLvlCdR[i].setValue(true);
             	}
             }
             drcdctform.setData(select.data);
        }else{
        	
    		 var r = {'deptCode' : '','deptName' : '','roleList' : [],'empDeptCd':'','signLvlCd':'','curDrcDctId':'','curDeputyDrcDctId':''};
        	 deptGrid.getStore().insert(0, r);
        	 
			 roleGrid.getSelectionModel().deselectAll(true); //清空已选中的	
			 reviewform.getForm().reset();//清空
			 drcdctform.getForm().reset();//清空
        }*/
    }
});
