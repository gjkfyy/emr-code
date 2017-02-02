/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.sy.patient.action.PatientDocAction', {
extend: 'Xap.ej.action.Action',

	requires: ['iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
	           'iih.sy.patient.block.PatientRightBlock'
	           ],
	
	execute: function(context) {
		alert(111);
		var me = this;
		
		var owner = this.getOwner();   
		
		var topBlock = this.getBlock('result');
	    
	    var enGrid = topBlock.down('xapgrid');
	    
	    var tabs = Ext.widget('tabpanel', {
	        renderTo: 'baseInfo',
	        resizeTabs: true,
	        enableTabScroll: true,
	        width: 900,
	        height: 550,
	        defaults: {
	            autoScroll: true,
	            bodyPadding: 1
	        },
	        items: [{
	            title: 'Tab 1',
	            iconCls: 'tabs',
	            html: 'Tab Body<br/>4444<br/>',
	            closable: true
	        }],
	        plugins: Ext.create('Ext.ux.TabCloseMenu', {
	            extraItemsTail: [
	                '-',
	                {
	                    text: 'Closable',
	                    checked: true,
	                    hideOnClick: true,
	                    handler: function (item) {
	                        currentItem.tab.setClosable(item.checked);
	                    }
	                },
	                '-',
	                {
	                    text: 'Enabled',
	                    checked: true,
	                    hideOnClick: true,
	                    handler: function(item) {
	                        currentItem.tab.setDisabled(!item.checked);
	                    }
	                }
	            ],
	            listeners: {
	                beforemenu: function (menu, item) {
	                    var enabled = menu.child('[text="Enabled"]'); 
	                    menu.child('[text="Closable"]').setChecked(item.closable);
	                    if (item.tab.active) {
	                        enabled.disable();
	                    } else {
	                        enabled.enable();
	                        enabled.setChecked(!item.tab.isDisabled());
	                    }

	                    currentItem = item;
	                }
	            }
	        })
	    
	    })
	    /*
	    var selModel = enGrid.getSelectionModel();
	    
	    var record = selModel.getSelection()[0];

	    var reportCd = record.data.reportCd;
	    var reportName = record.data.reportName;
	    var event = context.event;
	    
	    var workareapageview = owner.ownerCt;
	    var reportview = workareapageview.items.items[1];
	    if(reportview){
	    	workareapageview.remove(reportview);
	    }
	    
	    var pageCode = 'qareportwithoutconditionview';
//	    var pageCode = 'qareportview';
	    var pageTitle = reportName;
	    
	    var viewConfig = {
	    	reportRecord:record,
	    	reportCd: reportCd,
	    	reportName:reportName
	    }
	    
        if(event) {
            var config = {
            	pageCode: pageCode,
            	pageTitle: pageTitle,
                xclass: 'iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
//                xclass: 'iih.mr.qa.qa_reports.view.QaReportView',
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("addWorkPage",config);
        };*/
    }
});