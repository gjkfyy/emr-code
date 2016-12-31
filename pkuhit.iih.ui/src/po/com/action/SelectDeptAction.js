Ext.define('iih.po.com.action.SelectDeptAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		console.log('----------------SelectDeptAction-------------------');
		var sp = this.getOwner();
    	var app = sp.ownerCt;
    	var layout = app.getLayout();
    	var operations = context.operations;
		var selectBlock = this.getBlock('selectportals');
    	var sp = this.getOwner();
        var button = context;
    	var hosArea,deptCd,portalInfo,portalCd,portalNm;
    	deptCd = button.action;
    	deptNm = button.tooltip;
    	hosArea = IMER_GLOBAL.hospitalArea.code;
    	portalCd = IMER_GLOBAL.portal.code;
    	portalNm = IMER_GLOBAL.portal.name;
    	console.log('deptCd=='+deptCd+'--deptNm=='+deptNm+'--hosArea=='+hosArea+'--portalCd=='+portalCd+'--portalNm=='+portalNm);
    	this.prepareOperations(operations, hosArea, deptCd, portalNm, portalCd);
    	this.callParent();
    },  

	 prepareOperations : function(operations, hosArea, deptCd, portalNm, portalCd) {
		 var condition ='?hosArea='+hosArea+ '&deptCd='+deptCd+'&portalNm='+portalNm+'&portalCd='+portalCd;   
		var url = this.url+condition;
		//url += '/' + hosArea+'/'+deptCd+'/'+portalCd;
		var METHODS = this.getInvocationMethods();
		var operation = {
			url : url,
			mclass : null,
			method : METHODS.METHOD_GET,
			condition : null,
			data : null,
			scope : this,
			success : this.onSuccess,
			fail: this.onFail
		};
		operations.push(operation);
	},

	onSuccess : function(operation) {
		var block = this.getBlock('selectportals');
		var portalInfo = block.down('xapdisplayfield');
		var m = operation.result;
		if(!Ext.isEmpty(m, false)){
			var data = m.data;
			var portalNm = m.portalNm;
			var deptName = m.deptName;
			var deptCd = m.deptCd;
			var loginName = m.loginName;
			var userName = m.userName;
			var portals = m.portals;
			var depts = m.depts;
			if(data=='success'){
				var login = this.getOwner();
				var app = login.ownerCt;
				var layout = app.getLayout();
				var portal = app.down('portalview');
		        var chain = portal.getActionChain('init');
		        var portalSel = app.down('selectportal');
		        var chainPortal = portalSel.getActionChain('selectportals');
		        var chainDept = portalSel.getActionChain('selectdepts');
		        chain.execute();
		        var topview = app.down('topview');
		        //var label = topview.down('label[id=portalName]');
		        var selectPorBtn = topview.down('container[id=selectPorBtn]');
		        var selectDeptBtn = topview.down('container[id=selectDeptBtn]');
		        console.log('-----------dept------------');
		        //console.log(depts);
		        selectPorBtn.removeAll(true);
		        selectDeptBtn.removeAll(true);
		        var items,resultPortal=[],resultDept=[],size,deptSize;
		        if(!Ext.isEmpty(portals, false)){
		        	size = m.size;
		        	if(size>1){
		        		for(var i=0;i<portals.length;i++){
		        			resultPortal[i] = {
	        	            		text: portals[i].nm,
	        	            		tooltip:portals[i].nm,
	        	            		action: portals[i].poCd,
	        	            		handler:function(btn,e){
	        	            			chainPortal.execute(btn);
	        	            		}
	        					};
		        		}
	        			items = Ext.create('Ext.button.Split',{
        					text: portalNm,
							margin: '0 0 0 3',
							menu: Ext.create('Ext.menu.Menu', {
								cls: 'top-base',
								frame: true,
		        				margin: 0,
		        				padding: 0,
						        items: resultPortal
							})
	        			});
		        	}else{
		        		items = Ext.create('Ext.form.Label',{
		        	        forId: 'portalNm',
		        	        text: portalNm,
		        	        margin: '0 0 0 3'
		        		});
		        	}
		        	selectPorBtn.add(items);
			    }
		        if(!Ext.isEmpty(depts, false)){
		        	deptSize = m.deptSize;
		        	if(deptSize>1){
		        		for(var i=0;i<depts.length;i++){
		        			resultDept[i] = {
	        	            		text: depts[i].DEPT_NM,
	        	            		tooltip:depts[i].DEPT_NM,
	        	            		action: depts[i].DEPT_CD,
	        	            		handler:function(btn,e){
	        	            			chainDept.execute(btn);
	        	            		}
	        					};
		        		}
	        			items = Ext.create('Ext.button.Split',{
        					text: deptName,
							margin: '0 5 0 0',
							menu: Ext.create('Ext.menu.Menu', {
								cls: 'top-base',
								frame: true,
		        				margin: 0,
		        				padding: 0,
						        items: resultDept
							})
	        			});
		        	}else{
		        		items = Ext.create('Ext.button.Button',{
		        	        forId: 'deptNm',
		        	        text: deptName,
		        	        margin: '0 5 0 0'
		        		});
		        	}
		        	selectDeptBtn.add(items);
			    }
		        //存储全局用户信息属性
		        IMER_GLOBAL.portal.name = portalNm;
		        IMER_GLOBAL.department.name = deptName;
		        IMER_GLOBAL.department.code = deptCd;
		        IMER_GLOBAL.user.code = userName;
		        IMER_GLOBAL.user.name = loginName;
		        
		        var iemrUser = topview.down('button[id=iemrUser]');
		        iemrUser.setText(loginName);
                layout.setActiveItem(2);
			}else{
				portalInfo.setValue('<font color=red>系统故障!</font>');
			}
		}
	},
	onFail : function(operation) {
		var block = this.getBlock('selectportals');
		var portalInfo = block.down('xapdisplayfield');
		portalInfo.setValue('<font color=red>系统故障!</font>');
	}
});
