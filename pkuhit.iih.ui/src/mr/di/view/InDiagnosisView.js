Ext.define('iih.mr.di.view.InDiagnosisView',{
    extend : 'Xap.ej.template.BaseTemplate',
	alias:'widget.indiagnosisview',
	id:'indiagnosisview',
	requires:[
		        'Xap.ej.element.field.ComboBox',
				'Xap.ej.element.field.Checkbox',
				'Xap.ej.element.radiogroup.RadioGroup',
				'Xap.ej.element.checkboxgroup.CheckboxGroup',
				'Xap.ej.element.form.Form',
				'Xap.ej.element.grid.Grid',
				'Xap.ej.element.label.Label',
				'Xap.ej.element.datetimefield.DateTimeField',
				'Xap.ej.element.grid.column.Date',
				'Xap.ej.element.grid.column.CheckColumn',
		        'iih.mr.di.block.InDiagnosisBlock',
				'iih.mr.di.action.InDiagnosisShowIcdAction',
				'iih.mr.di.action.InDiagnosisSaveAction',
				'iih.mr.di.action.InDiagnosisInitAction',
				'iih.mr.di.action.InDiagnosisSonDiAction',
				'iih.mr.di.action.InDiagnosisEditFormAction',
				'iih.mr.di.action.InDiagnosisDelAction'
	          ],
	
	xapConfig:{
	
		blocks: {
			   'content':{
				   xclass: 'iih.mr.di.block.InDiagnosisBlock'
			   }
		  },
		actions:{
			'inDiagnosisViewreadyAction':{
				xclass: 'iih.mr.di.action.InDiagnosisViewreadyAction',
				blocks: {
					content: 'content'
				}
			},
			'init':{
				xclass: 'iih.mr.di.action.InDiagnosisInitAction',
				url:'di/in/initGrid',
				blocks: {
					content: 'content'
				}
			},
			'saveDi':{
				xclass: 'iih.mr.di.action.InDiagnosisSaveAction',
				url:'di/in/save',
				blocks: {
					content: 'content'
				}
			},
			'cancel':{
				xclass: 'iih.mr.di.action.InDiagnosisCancelAction',
				blocks: {
					content: 'content'
				}
			},
			'showIcd':{
				xclass: 'iih.mr.di.action.InDiagnosisShowIcdAction',
				blocks: {
					content: 'content'
				}
			},
			'editDi':{
				xclass: 'iih.mr.di.action.InDiagnosisEditFormAction',
				blocks: {
					content: 'content'
				}
			},
			'sonDi':{
				xclass: 'iih.mr.di.action.InDiagnosisSonDiAction',
				url:'di/in/son',
				blocks: {
					content: 'content'
				}
			},
			'delDi':{
				xclass: 'iih.mr.di.action.InDiagnosisDelAction',
				url:'di/in/del',
				blocks: {
					content: 'content'
				}
			},
			'judgeBtn':{
				xclass: 'iih.mr.di.action.InDiagnosisJudgeBtnAction',
				blocks: {
					content: 'content'
				}
			}
		},
		 chains:{
			 'inDiagnosisViewreadyAction':['inDiagnosisViewreadyAction'],
			 'doSave':['saveDi'],
			 'saveDi':['saveDi'],
			 'cancel':['cancel'],
			 'init':['init'],
			 'showIcd':['showIcd'],
			 'sonDi':['sonDi'],
			 'editDi':['editDi'],
			 'delDi':['delDi'],
			 'judgeBtn':['judgeBtn']
			},
		 connections:{
			 'content':[/*{
				 event: 'afterrender',
				 chain: 'init'
			 },*/{
				 selector: 'xapgrid',
				 event: 'viewready',
				 chain: 'inDiagnosisViewreadyAction'
			 },{
	                selector: 'button[action=saveDi]',
	                event: 'click',
	                chain: 'saveDi'
			 },{
	                selector: 'button[action=cancel]',
	                event: 'click',
	                chain: 'cancel'
			 },{
	                selector: 'xapgrid',
	                event: 'itemdblclick',
	                chain: 'editDi'
			 },{
	                selector: 'xapgrid',
	                event: 'itemclick',
	                chain: 'judgeBtn'
			 }]
		 }
    },
    initComponent : function() {
		this.callParent();
		var me = this;
		 this.addEvents("changeEncounter");//为视图添加刷新事件
         this.addListener('changeEncounter', function(enPk){//添加监听事件
             //查询action
        	 var chain = me.getActionChain('init');
        	 chain.execute({
        	     'enPk':enPk
        	 });
         });

	},
	
	 hasEdit: function() {
		 var me =this;
		 var block = this.down('indiagnosisblock');
		 var form = block.down('xapform');
		 var value =form.getForm().getValues();
		 var dirty = form.isDirty();
//		 var dirty = this.dirty;
       if (dirty) {
           return true;
       } else {
           return false;
       }
   }
})