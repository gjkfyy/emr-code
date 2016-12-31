Ext.define("iih.po.com.hisLoginIemrUtil", {
	     singleton: true, 
	     
	    
         
         
         
	autoLogin:function(conn,data){
	    window.focus();	  	 
	    var app = Ext.getCmp('commonappmain');
            var layout = app.getLayout();
            layout.setActiveItem(2);
            // conn网络连接，可以使用方法conn.send(d)向外界发送数据，数据格式是字符串或者JSON对象
            console.log('connection: ');
            console.log(conn);
            // 接受的数据
            console.log('data: ');
            console.log(data);
            var token = data.data.token;
            var userCd,uuid,pwd,portalCd,hosArea,deptCd,enSn,docSn,patientId,optFlag;
            var temp=[];
            console.log(token);
            if(!Ext.isEmpty(token, false)){
                temp = token.split("|");
                patientId = data.patientId;
                
                var loginView = app.down('login');
                var callBack = function(temp){
                    userCd = temp[0];
                    pwd = temp[1]||'1234';
                    uuid = temp[1];
                    portalCd = temp[2];
                    hosArea = temp[3];
                    deptCd = temp[4];
                    enSn = temp[6];
                    docSn = temp[7];
                    userId = temp[10];
                    var name = this.down('xaptextfield[name=username]');
                    var pass = this.down('xaptextfield[name=password]');
                    name.setValue(userCd);
                    pass.setValue(pwd);
                    IMER_GLOBAL.user.code = userId;
                    IMER_GLOBAL.user.name = userId;
                    IMER_GLOBAL.hospitalArea.code = hosArea||'SZLH';
                    IMER_GLOBAL.hospitalArea.name = hosArea;
                    IMER_GLOBAL.department.code = deptCd;
                    IMER_GLOBAL.department.name = deptCd;
                    IMER_GLOBAL.portal.code = portalCd;
                    IMER_GLOBAL.portal.name = portalCd;
                    if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_9 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10)
                        IMER_GLOBAL.encounterSn = enSn;
                    else
                        IMER_GLOBAL.encounterSn = null;
                    
					var chainLogin = this.getActionChain('autologin');
                    chainLogin.execute({
						'userCd':userId,
						'portalCd':portalCd,
						'hosArea':hosArea||'PKUHIT',
						'deptCd':deptCd,
						'encounterSn':IMER_GLOBAL.encounterSn
					});
                };
                var workarea = app.down('xaptabpanel[id=workareapageview]');
                workarea.callBack = {
                    method: callBack,
                    scope: loginView,
                    params: [temp]
                };
                workarea.closePages = null;
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender");
            }else{
            	console.log('token is empty.');
            }
         }         
         
         
       
  });