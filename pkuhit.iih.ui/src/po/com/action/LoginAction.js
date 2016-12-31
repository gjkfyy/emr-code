Ext.define('iih.po.com.action.LoginAction', {
	extend: 'Xap.ej.action.LoginAction',

	url: 'xap_login',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
    	this.callParent();
    	var operations = context.operations;
    	var loginBlock = this.getBlock('lvblock');
    	var data = loginBlock.getForm().getValues();
    	var sp = this.getOwner();
    	if((data!=undefined)||(data!=null)){
    		data = loginBlock.getForm().getValues();
    	}else{
    		data = null;
    	}
    	var name,pass,showInfo;
    	if(!Ext.isEmpty(data, false)){
    		name = data.username;
    		pass = data.password;
    		showInfo = loginBlock.down('xapdisplayfield');
    		//进行前台登录框验证
    		if(Ext.isEmpty(name, false)){
    			showInfo.setValue('<font color=red>用户名不能为空!</font>');
    			return null;
    		}else{
	    		if(Ext.isEmpty(pass, false)){
	    			showInfo.setValue('<font color=red>密码不能为空!</font>');
	    			return null;
	    		}else{
	    			//用户登录后台验证
	    			context.data = data;
	    			context.data.username = data.username;
	    		}
    		}
    	}
    	return true;
    },

	onLoginSuccess : function(info) {
	    IMER_GLOBAL.user.code = info.userId;
        IMER_GLOBAL.user.name = info.userName;
		var login = this.getOwner();
		var app = login.ownerCt;
		var layout = app.getLayout();
		if(Ext.isEmpty(IMER_GLOBAL.portal.code, false)){
		    var portal = app.down('selectportal');
	        var chain = portal.getActionChain('init')
			chain.execute();
			layout.setActiveItem(1);
		}else{
		    var portal = app.down('portalview');
            var chain = portal.getActionChain('init')
			chain.execute({
			    hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
	            hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
	            departmentCode:IMER_GLOBAL.department.code,
	            departmentName:IMER_GLOBAL.department.name,
	            portalCode:IMER_GLOBAL.portal.code,
	            portalName:IMER_GLOBAL.portal.name
		    });
			layout.setActiveItem(2);
		}
		
		var loginBlock = this.getBlock('lvblock');
		var data = loginBlock.getForm().getValues();
		if(data.rememberInfo){
		    var expires = new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 30)); //30天
	        Ext.util.Cookies.set('userId', data.username, expires);
	        Ext.util.Cookies.set('password', data.password, expires);
		}else{
		    Ext.util.Cookies.clear('userId');
		    Ext.util.Cookies.clear('password');
		}
	},

	onLoginFailure : function(error) {
		var block = this.getBlock('lvblock');
		var showInfo = block.down('xapdisplayfield');
		var errorText = null;
		if(error) {
			errorText = error.desc;
		}
		if(!errorText) {
			// TODO 系统故障描述应该也从框架得到
			errorText = '系统故障';
		}
		showInfo.setValue('<font color=red>' + errorText + '</font>');
	}
});
