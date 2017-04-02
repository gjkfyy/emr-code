Ext.define('iih.po.com.action.TopInitAction', {
    extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
    patientInfo: null,
    execute: function(context) {
    	this.callParent();
    	var view = this.getOwner();
    	var portal = view.up('portalview');
    	var workArea = portal.down('xaptabpanel[id=workareapageview]');
    	var top = this.getBlock('tview');
        top.removeAll(true);
    	this.patientInfo = context.patientInfo;
        if(this.patientInfo){
        	console.log(this.patientInfo);
            IMER_GLOBAL.encounterSn = this.patientInfo.pk;
            IMER_GLOBAL.patientId = this.patientInfo.patientId;
            IMER_GLOBAL.amrNo = this.patientInfo.inpatientNo;
            IMER_GLOBAL.encounterCount = this.patientInfo.encounterCount;
            IMER_GLOBAL.mainDiCd = this.patientInfo.currentMainDiagnosisCode;
            if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1001 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_4 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_6 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10){
                item = Xap.create('iih.po.com.view.PatientTopPage');
                var model = Ext.create('iih.po.model.PatientModel',this.patientInfo);
                var content = item.info.apply(model.getData());
                var info = Ext.getCmp('inpatientTop_info');
            }else{
                item = Xap.create('iih.po.outp.view.OutpPatientTopPage');
                var model = Ext.create('iih.po.model.PatientModel',this.patientInfo);
                var content = item.info.apply(model.getData());
                var info = Ext.getCmp('outpatientTop_info');
            };
            info.update(content);
        }else{
            item = Xap.create('iih.po.com.view.NoPatientTopPage');
            IMER_GLOBAL.encounterSn = null;
            IMER_GLOBAL.patientId = null;
            IMER_GLOBAL.mainDiCd = null;
            IMER_GLOBAL.amrNo =null;
        }
        top.add(item);
        
        var switchBtn = top.down('container[name=switchBtn]');
        switchBtn.removeAll();
        //病历管理
        var mrmBtn = Ext.create('Ext.button.Button',{
            name: 'mrmBtn',
            iconCls: 'icon-docMgr',
            scale: 'large',
            text: '病历管理',
            tooltip: '病历管理',
            margin: '20 20 5 0',
            handler:function(btn,e){
                var top = this.up('topview');
                var chain = top.getActionChain('topBaseButtons');
                chain.execute({
                    action: 'docMgr'
                });
            }
        });
        switchBtn.add(mrmBtn);
        
        //模板管理
        var templetBtn = Ext.create('Ext.button.Button',{
            name: 'templetBtn',
            iconCls: 'icon-templateMgr',
            scale: 'large',
            text: '病历模板管理',
            tooltip: '病历模板管理',
            margin: '20 20 5 0',
            handler:function(btn,e){
                var top = this.up('topview');
                var chain = top.getActionChain('topBaseButtons');
                chain.execute({
                    action: 'templateMgr'
                });
            }
        });
        switchBtn.add(templetBtn);
        
        //随访管理
        var fumBtn = Ext.create('Ext.button.Button',{
            name: 'fumBtn',
            iconCls: 'icon-followUpMgr',
            scale: 'large',
            text: '随访管理',
            style:'font-size:14px', 
            tooltip: '随访管理',
            margin: '20 20 5 0',
            handler:function(btn,e){
                var top = this.up('topview');
                var chain = top.getActionChain('topBaseButtons');
               /* chain.execute({
                    action: 'minimum'
                });*/
            }
        });
        switchBtn.add(fumBtn);
        
        //随访管理
        var searchBtn = Ext.create('Ext.button.Button',{
            name: 'searchBtn',
            iconCls: 'icon-query',
            scale: 'large',
            text: '高级检索',
            style:'font-size:14px', 
            tooltip: '高级检索',
            margin: '20 20 5 0',
            handler:function(btn,e){
                var top = this.up('topview');
                var chain = top.getActionChain('topBaseButtons');
                chain.execute({
                    action: 'seniorQuery'
                });
            }
        });
        switchBtn.add(searchBtn);
        
        
        /*//患者与功能切换按钮
        if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_6){
            var patientBtn = Ext.create('Ext.button.Button',{
                name: 'switchPatient',
                //disabled:(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2),
                iconCls: 'icon-Patient',
                scale: 'large',
                text: '患者12',
                tooltip: '患者12',
                margin: '20 20 5 0',
                handler:function(btn,e){
                    if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2){
                        var patientChain = portal.getActionChain('patientPop');
                        patientChain.execute();
                    }else{
                        var callBack = function(){
                            IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_2;
                            var chain = this.getActionChain('init');
                            chain.execute({
                                hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                                hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                                departmentCode:IMER_GLOBAL.department.code,
                                departmentName:IMER_GLOBAL.department.name,
                                portalCode:IMER_GLOBAL.portal.code,
                                portalName:IMER_GLOBAL.portal.name
                            });
                        };
                        workArea.callBack = {
                            method: callBack,
                            scope: portal,
                            params: []
                        };
                        workArea.closePages = null;
                        var canvas = Xap.getCanvas();
                        canvas.fireEvent("portalRender");
                    }
                }
            });
            switchBtn.add(patientBtn);
            var functionBtn = Ext.create('Ext.button.Button',{
                name: 'switchFunction',
                //disabled:(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_6),
                iconCls: 'icon-Function',
                scale: 'large',
                text: '功能',
                tooltip: '功能',
                margin: '20 20 5 0',
                handler:function(btn,e){
                    if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2){
                        var callBack = function(){
                            IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_6;
                            var chain = this.getActionChain('init');
                            chain.execute({
                                hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                                hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                                departmentCode:IMER_GLOBAL.department.code,
                                departmentName:IMER_GLOBAL.department.name,
                                portalCode:IMER_GLOBAL.portal.code,
                                portalName:IMER_GLOBAL.portal.name
                            });
                        };
                        workArea.callBack = {
                            method: callBack,
                            scope: portal,
                            params: []
                        };
                        workArea.closePages = null;
                        var canvas = Xap.getCanvas();
                        canvas.fireEvent("portalRender");
                    }
                }
            });
            switchBtn.add(functionBtn);
        };
        if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10){
            var patientBtn = Ext.create('Ext.button.Button',{
                name: 'switchPatient',
                iconCls: 'icon-Patient',
                scale: 'large',
                text: '患者',
                tooltip: '患者',
                margin: '20 20 5 0',
                handler:function(btn,e){
                    var patientChain = portal.getActionChain('patientPop');
                    patientChain.execute();
                }
            });
            switchBtn.add(patientBtn);
        };
        if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7){
            var patientBtn = Ext.create('Ext.button.Button',{
                name: 'switchPatient',
                //disabled:(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2),
                iconCls: 'icon-Patient',
                scale: 'large',
                text: '患者111',
                tooltip: '患者111',
                margin: '20 20 5 0',
                handler:function(btn,e){
                    if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7){
                       var patientChain = portal.getActionChain('InpPatientPop');
                       patientChain.execute();
                    }else{
                        var callBack = function(){
                            IMER_GLOBAL.portal.code = IMER_CONSTANT.PORTAL_CD_2;
                            var chain = this.getActionChain('init');
                            chain.execute({
                                hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                                hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                                departmentCode:IMER_GLOBAL.department.code,
                                departmentName:IMER_GLOBAL.department.name,
                                portalCode:IMER_GLOBAL.portal.code,
                                portalName:IMER_GLOBAL.portal.name
                            });
                        };
                        workArea.callBack = {
                            method: callBack,
                            scope: portal,
                            params: []
                        };
                        workArea.closePages = null;
                        var canvas = Xap.getCanvas();
                        canvas.fireEvent("portalRender");
                    }
                }
            });
            switchBtn.add(patientBtn);
        };*/
        //患者照片
        var photoArea = top.down('container[name=photoArea]');
        if(photoArea && this.patientInfo){
            var src = this.patientInfo.sex == '1'?'css/images/man.png':'css/images/woman.png';
            photoArea.removeAll();
            var photoBtn = Ext.create('Ext.Img',{
                cls: 'inpatienttop-border-div',
                src: src,
                height: 50,
                width: 60
            });
            photoArea.add(photoBtn);
        }
        //top显示院区
    	var hospitalArea = view.down('button[name=orgName]');
    	hospitalArea.setText(IMER_GLOBAL.hospitalArea.name);
    	//top显示门户
    	var portalChain = view.getActionChain("searchPortal");
    	portalChain.execute();
    	//top显示科室
    	var deptChain = view.getActionChain("searchDepartment");
    	deptChain.execute();
    	//top显示登录用户
    	var userBtn = view.down('button[name=iemrUser]');
        userBtn.setText(IMER_GLOBAL.user.name);
        //刷新消息区域
        var task_checkMessage;//任务变量
        task_checkMessage = {
            run: function(){
                if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10){
                    var chain = portal.getActionChain('refreshMsg');
                    chain.execute();
                }
            },//执行任务时执行的函数
            interval: 30000//任务间隔，毫秒为单位，这里是30秒
        };
        Ext.TaskManager.start(task_checkMessage);//启动任务
        //添加最小化大按钮
       /* var minBtn = Ext.create('Ext.button.Button',{
            name: 'minBtn',
            iconCls: 'icon-minimum',
            scale: 'large',
            text: '最小化222',
            tooltip: '最小化',
            margin: '20 20 5 0',
            handler:function(btn,e){
                var top = this.up('topview');
                var chain = top.getActionChain('topBaseButtons');
                chain.execute({
                    action: 'minimum'
                });
            }
        });
        switchBtn.add(minBtn);*/
    }
});