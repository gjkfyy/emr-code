Ext.define('iih.mr.di.action.InDiagnosisInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],

    doExecute: function(context) {
    	this.showLoading();
    	var block = this.getBlock('content');
    	var flag = context.flag;
    	if(flag=='1'){
    		block.flag ='1';
    	}
    	var curEnPk = IMER_GLOBAL.encounterSn;
		var enPk = context.enPk;
        if(enPk==undefined){
        	enPk = IMER_GLOBAL.encounterSn;
        }
        var form = block.down('xapform[name=diForm]');
        var value = form.getValues();
        var diInGrid = block.down('xapgrid');
		//子诊断按钮
		var sonDi = diInGrid.down('button[method=sonDi]');
		//编辑按钮
		var editDi = diInGrid.down('button[method=editDi]');
		//删除按钮
		var delDi = diInGrid.down('button[method=delDi]');
        if(curEnPk != enPk){
        	form.setVisible(false);
        	sonDi.setDisabled(true);
			editDi.setDisabled(true);
			delDi.setDisabled(true);
        }else{
        	form.setVisible(true);
        }
        block.enPk = enPk;
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
	     	this.prepareOperations(operations,enPk);
    },

    prepareOperations: function(operations,enPk) {
//    	var enSn = IMER_GLOBAL.encounterSn; //就诊序号
//    	var enSn = '863581';
        var url = this.url+ '/' + enPk;;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
                url: url ,
        		mclass: null,
        		method: 'get',
        		condition: null,
        		scope: this,
        		success: this.onSuccess
        	};
    	operations.length = 0;
    	operations.push(operation);
},
   
    onSuccess: function(operation){
        var block = this.getBlock('content');
        var form = block.down('xapform');
        if(block.flag =='1'){
            var formData = {
            		addDescr: undefined,
            			diCd: undefined,
            			diEmpNm: undefined,
            			diNm: undefined,
            			diSn: undefined,
            			diTime: undefined,
            			diTypeCd: undefined,
            			diTypeNm: undefined,
            			icdCd: undefined,
            			mainF: "0",
            			memo: undefined,
            			parDiSn: undefined
            	}; 
            var diCd = block.down('comboxgrid[name=diCd]');
    	    diCd.setRecordData({value:'',text:''}); 
    	    var showInfo = block.down('xapdisplayfield[name=showInfo]');
    	    showInfo.setValue('');
    	    form.setTitle('诊断新增');
            form.getForm().setValues(formData);
        }
        var grid = block.down('xapgrid[name=diListGrid]');
        var m = operation.result;
        for(var i=0;i<m.length;i++){
        	var diTypeCd = m[i].diTypeCd;
        	var parDiSn = m[i].parDiSn;
        	if(diTypeCd =='01' && parDiSn != null){
        			m[i].diTypeNm = '&nbsp &nbsp 入院诊断';
            }else if(diTypeCd =='02' && parDiSn != null){
            		m[i].diTypeNm = '&nbsp &nbsp 出院诊断';
            }else if(diTypeCd =='03' && parDiSn != null){
            		m[i].diTypeNm = '&nbsp &nbsp 补充诊断';
            }
        }
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	grid.setData(m);
        	console.log(m);
        }
    }
});
