Ext.define('iih.mr.tm.mr.action.OwnerTypeCdChangeAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var rs = this.getBlock('result');   
	     //找到combox的框值
	    var newValue = context.event.arguments[0].value
	    var ownerCd  = rs.down('[name=deptCode]'); 
	    var deptCd,deptNm;
        if(newValue==IMER_CONSTANT.OWNERTYPE_PERSON){
            ownerCd.removeCls("readOnlyCss"); 
            ownerCd.setReadOnly(true);
            deptCd = IMER_GLOBAL.user.code;
            deptNm = IMER_GLOBAL.user.name;
            ownerCd.setRecordData({code:deptCd,name:deptNm});
        }else if(newValue==IMER_CONSTANT.OWNERTYPE_DEPT){
            ownerCd.setReadOnly(false); 
//        	ownerCd.setRecordData({code:null,name:null});
        	deptCd = IMER_GLOBAL.department.code;
            deptNm = IMER_GLOBAL.department.name;
            ownerCd.setRecordData({code:deptCd,name:deptNm});
        }else if(newValue==IMER_CONSTANT.OWNERTYPE_HOS){
            ownerCd.setReadOnly(true); 
            ownerCd.addCls("readOnlyCss");
            deptCd = IMER_GLOBAL.hospitalArea.code;
            deptNm = IMER_GLOBAL.hospitalArea.name;
            ownerCd.setRecordData({code:deptCd,name:deptNm});
        }else{
            return
        }
    
    }
});
