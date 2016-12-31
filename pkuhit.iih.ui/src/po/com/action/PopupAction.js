Ext.define('iih.po.com.action.PopUpAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.po.com.view.OtherOmrView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var blockTitle = '其他病历';
		var helpContent = this.getBlock('helpContent');
		var encounterCombox = helpContent.down('xapcombobox[itemId=encounterCombox]');
		var encounterComboxValue = encounterCombox.rawValue//: "2014-02-04 09:14_门诊"
		var enTypes = encounterComboxValue.split('_')[1];
		if(CONFIG_PARAM.OUT_MR_COUNT == true){
			var enType = enTypes.split('(')[0];
		}else{
			var enType = enTypes;
		}
		
		if('门诊' == enType){
			enType = '1';
		}else{
			enType = '0';//住院
		}
		var encounterSn = encounterCombox.value;
		
		var config = {
				title:blockTitle,
				width: 970,
	    		height:510,
	    		contentConfig: {
	    			xtype: 'otheromrview',
	    			workpageview:owner,
	    			encounterSn:encounterSn,
	    			enType:enType
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})