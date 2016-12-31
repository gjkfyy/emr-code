/**
 * 门户TOP页面
 * 创建人：白斌
 * 时间：2013-04-15
 * 日志：
 * 		2013-04-15		新建
 */
Ext.define('iih.po.com.view.TopPage', {
	extend: 'Xap.ej.block.Block',
	
	requires:[
	          'iih.po.com.view.NoPatientTopPage',
	          'iih.po.com.view.PatientTopPage'
	          ],
	
	alias: 'widget.toppage',
	
	border: 0,
	
	baseCls: 'page-head',
	
	layout: 'fit',
	
	initComponent: function() {
		this.items = [{
		    xtype: 'nopatienttoppage'
		}];
    	
    	this.callParent();
    },
    
    setDepartmentData: function(results){
        var data = results.dataList;
        var selectDeptBtn = this.down('container[name=selectDeptBtn]');
        var portal = this.up('portalview');
        var workArea = portal.down('xaptabpanel[id=workareapageview]');
        var portalInit = portal.getActionChain('init');
        if(!Ext.isEmpty(data, false)){
            var resultDept=[],items,deptNm;
            if(data.length>1){
                for(var i=0;i<data.length;i++){
                    if(data[i].code == IMER_GLOBAL.department.code)
                        deptNm = data[i].name;
                        IMER_GLOBAL.department.name = deptNm;
                        resultDept[i] = {
                            name: data[i].code,
                            text: data[i].name,
                            group: 'topDept',
                            checked: (data[i].code == IMER_GLOBAL.department.code)
                        };
                };
                items = Ext.create('Ext.button.Button',{
                    name: 'topDept',
                    text: deptNm,
                    border:0,
                    menu: Ext.create('Ext.menu.Menu', {
                        items: resultDept,
                        frame: true,
                        margin: 0,
                        cls: 'top-base',
                        padding: 0,
                        frame: true,
                        listeners: {
                            click: function(menu, item, e) {
                                var button = menu.ownerButton;
                                var callBack = function(item){
                                    var portal = this.up('portalview');
                                    var chain = portal.getActionChain('init');
                                    this.setText(item.text);
                                    IMER_GLOBAL.department.code = item.name;
                                    chain.execute({
                                        hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                                        hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                                        departmentCode:IMER_GLOBAL.department.code,
                                        departmentName:item.text,
                                        portalCode:IMER_GLOBAL.portal.code,
                                        portalName:IMER_GLOBAL.portal.name
                                    });
                                };
                                workArea.callBack = {
                                    method: callBack,
                                    scope: button,
                                    params: [item]
                                };
                                workArea.closePages = null;
                                var canvas = Xap.getCanvas();
                                canvas.fireEvent("portalRender");
                            }
                        }
                    })
                });
            }else{
                items = Ext.create('Ext.button.Button',{
                    name: 'topDept',
                    cls: 'top-base',
                    border:0,
                    text: data[0].name
                });
                IMER_GLOBAL.department.name = data[0].name;
            };
            selectDeptBtn.removeAll();
            selectDeptBtn.add(items);
        }
    },
    
    setPortalData: function(data){
        var selectPorBtn = this.down('container[name=selectPorBtn]');
        var portal = this.up('portalview');
        var workArea = portal.down('xaptabpanel[id=workareapageview]');
        var portalInit = portal.getActionChain('init');
        if(!Ext.isEmpty(data, false)){
            var resultPortal=[],items;
            if(data.length>1){
                for(var i=0;i<data.length;i++){
                    resultPortal[i] = {
                        name: data[i].code,
                        text: data[i].name,
                        group: 'topPortal',
                        checked: (data[i].code == IMER_GLOBAL.portal.code)
                    };
                    if(data[i].code == IMER_GLOBAL.portal.code)
                        IMER_GLOBAL.portal.name = data[i].name;
                };
                items = Ext.create('Ext.button.Button',{
                    name: 'topPortal',
                    text: IMER_GLOBAL.portal.name,
                    border:0,
                    menu: Ext.create('Ext.menu.Menu', {
                        items: resultPortal,
                        frame: true,
                        margin: 0,
                        padding: 0,
                        cls: 'top-base',
                        frame: true,
                        listeners: {
                            click: function(menu, item, e) {
                                var button = menu.ownerButton;
                                var callBack = function(item){
                                    var portal = this.up('portalview');
                                    var chain = portal.getActionChain('init');
                                    this.setText(item.text);
                                    IMER_GLOBAL.portal.code = item.name;
                                    chain.execute({
                                        hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                                        hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                                        departmentCode:IMER_GLOBAL.department.code,
                                        departmentName:IMER_GLOBAL.department.name,
                                        portalCode:IMER_GLOBAL.portal.code,
                                        portalName:item.text
                                    });
                                };
                                workArea.callBack = {
                                    method: callBack,
                                    scope: button,
                                    params: [item]
                                };
                                workArea.closePages = null;
                                var canvas = Xap.getCanvas();
                                canvas.fireEvent("portalRender");
                            }
                        }
                    })
                });
            }else{
                items = Ext.create('Ext.button.Button',{
                    name: 'topPortal',
                    cls: 'top-base',
                    border:0,
                    text: data[0].name
                });
                IMER_GLOBAL.portal.name = data[0].name;
            }
            selectPorBtn.removeAll();
            selectPorBtn.add(items);
        }
    }
	
});