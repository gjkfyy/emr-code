Ext.define('iih.po.com.action.AutoLoginAction', {
	extend: 'Xap.ej.action.LoginAction',

	url: 'xap_login',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
    	this.callParent();
		var userCd = context.userCd;
		var portalCd = context.portalCd;
		var hosArea = context.hosArea;
		var deptCd = context.deptCd;
		var encounterSn = context.encounterSn;
		var patientId = context.patientId;
		IMER_GLOBAL.user.code = userCd;
		IMER_GLOBAL.user.name = userCd;
		IMER_GLOBAL.hospitalArea.code = hosArea||'PKUHIT';
		IMER_GLOBAL.hospitalArea.name = hosArea;
		IMER_GLOBAL.department.code = deptCd;
		IMER_GLOBAL.department.name = deptCd;
		IMER_GLOBAL.portal.code = portalCd;
		IMER_GLOBAL.portal.name = portalCd;
		IMER_GLOBAL.encounterSn = encounterSn;
		IMER_GLOBAL.patientId = patientId;
		IMER_GLOBAL.cardId=context.cardId;

    	var operations = context.operations;
    	var loginBlock = this.getBlock('lvblock');
    	var data = loginBlock.getForm().getValues();
    	var sp = this.getOwner();
    	if((data!=undefined)||(data!=null)){
    		data = loginBlock.getForm().getValues();
    	}else{
    		data = null;
    	};
    	var login = this.getOwner();
        var app = login.ownerCt;
        var layout = app.getLayout();
    	var name,pass,showInfo;
    	if(!Ext.isEmpty(data, false)){
    		name = data.username;
    		pass = data.password;
    		showInfo = loginBlock.down('xapdisplayfield');
    		//进行前台登录框验证
    		if(Ext.isEmpty(name, false)){
    			showInfo.setValue('<font color=red>用户名不能为空!</font>');
    			layout.setActiveItem(0);
    			return null;
    		}else{
	    		if(Ext.isEmpty(pass, false)){
	    			showInfo.setValue('<font color=red>密码不能为空!</font>');
	    			layout.setActiveItem(0);
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
		    this.initPortal();
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
	    var login = this.getOwner();
	    var app = login.ownerCt;
        var layout = app.getLayout();
        layout.setActiveItem(0);
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
	},
	
	initPortal: function() {
	    var login = this.getOwner();
        var app = login.ownerCt;
        var chain = this.getChain();
        var param = {
            'id': IMER_GLOBAL.hospitalArea.code
        };
        var url = 'organization/' + IMER_GLOBAL.hospitalArea.code;
        chain.execute({
            operations: [],
            params: [param],
            url: url,
            callback: function(data) {
                IMER_GLOBAL.hospitalArea.name = data.name;
                var enTypeCode; 
                if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8){ 
                            enTypeCode = 'ENM01.01'; 
                  }else{ 
                           enTypeCode = 'ENM01.04'; 
                  } 
                param = { 
                       'id': IMER_GLOBAL.encounterSn
                     ,  'enTypeCode':enTypeCode 
                 };
                var patientOrCardId="";
                if(IMER_GLOBAL.encounterSn)
                    url = '/mr/amr/getfromthird/'  + IMER_GLOBAL.encounterSn;
                else{
					if(IMER_GLOBAL.cardId!='undefined'){
						patientOrCardId=IMER_GLOBAL.cardId;
					}else{
						patientOrCardId=IMER_GLOBAL.patientId;
					}
                	url = '/mr/patient/' + patientOrCardId;
                }
                chain.execute({
                    operations: [],
                    params: [param],
                    url: url,
                    callback: function(data) {
                        var portal = app.down('portalview');
                        var initChain = portal.getActionChain('init')
                        initChain.execute({
                            hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                            hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                            departmentCode:IMER_GLOBAL.department.code,
                            departmentName:IMER_GLOBAL.department.name,
                            portalCode:IMER_GLOBAL.portal.code,
                            portalName:IMER_GLOBAL.portal.name,
                            patient:data
                        });
                    }
                });
            }
        });
	},
	
	getChain: function() {
        if(!this.chain) {
            // TODO 构造函数创建
            this.chain = Xap.create({
                xclass: 'Xap.ej.action.Chain'
            });
            var action = Xap.create({
                xclass: 'Xap.ej.action.IntelligentInputAction'
            });
            this.chain.addAction(action);
        }
        return this.chain;
    }
	
});
