Ext.define('iih.po.com.action.UpdatePatientAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['iih.po.com.view.PatientTopPage'],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    var view = this.getOwner();
        var top = view.down('topview');
        var patient = context.patient;
        if(patient && patient.pk){
            var operations = context.operations;
            var url = 'iemrPatient/' + patient.pk;
            var mclass = null;
            param = {
                'id': patient.pk
            };
            var METHODS = this.getInvocationMethods();
            var operation = {
                url: url,
                mclass: mclass,
                params: [param],
                method: METHODS.METHOD_GET,
                scope: this,
                success: this.onSuccess
            };
            operations.push(operation);
        }else{
            IMER_GLOBAL.encounterSn = null;
            IMER_GLOBAL.patientId = null;
            IMER_GLOBAL.mainDiCd = null;
            IMER_GLOBAL.amrNo=null;
            var chain = top.getActionChain('init');
            chain.execute();
        }
    },
    
    onSuccess: function(operation){
        var m = operation.result;
        var view = this.getOwner();
        var top = view.down('topview');
        if(m){
            var patient = m.data;
            console.log(patient);
            
            IMER_GLOBAL.encounterOldSn = IMER_GLOBAL.encounterSn;
            IMER_GLOBAL.encounterSn = patient.patientId;
            IMER_GLOBAL.patientId = patient.patientId;
            IMER_GLOBAL.amrNo = patient.inpatientNo;
            IMER_GLOBAL.mainDiCd = "x345672";
            IMER_GLOBAL.patientName = patient.patientName;
            
            if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2){
                var info = Ext.getCmp('inpatientTop_info');
                var model = Ext.create('iih.po.model.PatientModel',patient);
            }else{
                var info = Ext.getCmp('outpatientTop_info');
                var model = Ext.create('iih.po.model.PatientModel',patient);
            };
            if(info){
                var content = item.info.apply(model.getData());
                console.log(content);
                info.update(content);
                //患者照片
                var photoArea = top.down('container[name=photoArea]');
                if(photoArea){
                    var src = patient.sex == '1'?'css/images/man.png':'css/images/woman.png';
                    photoArea.removeAll();
                    var photoBtn = Ext.create('Ext.Img',{
                        cls: 'inpatienttop-border-div',
                        src: src,
                        height: 50,
                        width: 60
                    });
                    photoArea.add(photoBtn);
                }
            }else{
                var chain = top.getActionChain('init');
                chain.execute({
                    'patientInfo': patient
                });  
            }
        };
        var workarea = view.down('workareapageview');
        var enContainer = workarea.down('container[name=enContainer]');
        if(enContainer){
            var encounterCombox = enContainer.down('xapcombobox[itemId=encounterCombox]');
            if(encounterCombox){
                var action = Xap.create({
                    xclass: 'iih.po.com.action.AssistantInitAction'
                });
                action.combo = encounterCombox;
                Xap.runAction(action);
            }
        };
        var tabs = workarea.items.items;
        for (var i = 0; i < tabs.length; i++) {
            var tab = tabs[i];
            var page = workarea.getMainPage(tab.tabId);
            page.fireEvent("pageRefresh");
            page.fireEvent("selectEncounter");
            var helpBlock = tab.down('assistantblock');
            if(helpBlock){
                var chain = tab.getActionChain('assistantInit');
                chain.execute();
            }
        };
    }
});