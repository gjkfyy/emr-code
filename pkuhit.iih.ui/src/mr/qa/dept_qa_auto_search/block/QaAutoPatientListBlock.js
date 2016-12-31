Ext.define('iih.mr.qa.dept_qa_auto_search.block.QaAutoPatientListBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.qaautopatientlistblock',
	
	border: 0,

	items: [{
//		title: '环节质控患者查询',
		xtype: 'xapform',
	layout: {
		type: 'table',
		border:0,
		columns: 9,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%' ,
            	height: 76
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items:[{
		xtype:'xaptextfield',
		colspan:3,
//		width:140,
        name:'amrNo',
        labelWidth:50,
        labelAlign:'right',
        fieldLabel:'住院号',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('qaautodefectview');
					var initChain = view.getActionChain('init');
					initChain.execute({}); 
                }  
            }
        }
	},{
		xtype:'xaptextfield',
		colspan:3,
//		width:140,
        name:'patientName',
        labelWidth:60,
        labelAlign:'right',
        fieldLabel:'患者姓名',
//        margin:'10 0 0 10',
        listeners:{
        	specialkey : function(field, e) {  
                if (e.getKey() == Ext.EventObject.ENTER) {  
                    var view = this.up('qaautodefectview');
					var initChain = view.getActionChain('init');
					initChain.execute({}); 
                }  
            }
        }
	},{
        xtype:'xapcombobox',
        name:'mrTypes',
//        margin:'10 0 0 0',
        labelAlign : 'right',
        colspan: 3,
//        editable:false,
//        multiSelect : true, //多选
        fieldLabel:'文书类型',
        queryMode: 'local',
        displayField: 'name',
        valueField: 'code',
		callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
			var view = this.up('qaautodefectview');
			var initChain = view.getActionChain('init');
			initChain.execute({
				curDeptNm:newValue
			});
		}
    }/*{
        xtype: 'xapdatefield',
	      name:'beginTime',
	      labelWidth:60,
	      width:180,
	      margin:'0 -80 0 10',
	      labelAlign:'right',
	      editable:false,
	      fieldLabel:'完成时间'
	  },{
		  	xtype: 'xapdisplayfield',
			fieldLabel: '',
			labelWidth:30,
			vertical: true,
			name:'fenge',
			value: '~',
			margin:'0 60 0 0'
	},{
	  	xtype: 'xapdatefield',
	  	name:'endTime',
	  	labelWidth:60,
	  	width:120,
	  	labelAlign:'left',
	  	margin:'0 0 0 0',
	  	editable:false
	  }*/]
	}]
})