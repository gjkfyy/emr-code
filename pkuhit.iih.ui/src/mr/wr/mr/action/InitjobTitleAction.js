Ext.define('iih.mr.wr.mr.action.InitjobTitleAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var owner=this.getOwner();
		if(owner.xtype=="mrdocpropertyeditview"){//从病历文书属性编辑页面进来
			//得到医疗记录名称
			var mr=this.getOwner().mr;
			if(owner.init!=1){
				var block = this.getOwner().getBlock('content');
			    var mrDocNm=mr.templeName;
		        var higherLvlEmpId = block.down('[name=higherLvlEmpId]');
		        var mrNm = block.down('[name=mrNm]');
		        var higherLvlEmpNm = higherLvlEmpId.getRawValue();
		        //拼接病历标题
		        mrNm.setRawValue(higherLvlEmpNm+" "+mrDocNm);
			}else{
				this.getOwner().init=0;
			}
			
		}else{//从新建病历页面进来
			//得到医疗记录名称
			var rb = this.getOwner().ownerCt.getBlock('top').getBlock('result');
	        var grid = rb.down('xapgrid'); 
	        var selected=grid.getSelectionModel().getSelection();
	        var mrDocNm=selected[0].data.name;
	        
		    var block = this.getOwner().getBlock('content');
	        var higherLvlEmpId = block.down('[name=higherLvlEmpId]');
	        var mrNm = block.down('[name=mrNm]');
	        
	        /*var arr = higherLvlEmpId.value.split("-");
	        var jobTitleNm = arr[1];*/
	        var higherLvlEmpNm = higherLvlEmpId.getRawValue();
	        //jobTitleCd.setRawValue(jobTitleNm);
	        //拼接病历标题
	        mrNm.setRawValue(higherLvlEmpNm+" "+mrDocNm);
		}
		
    }
});
