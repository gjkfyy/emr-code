Ext.define('iih.mr.qa.doctor_self_score.view.DoctorScoreWorkView',{
	extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',

	requires: [
	    'Xap.ej.element.grid.column.CheckColumn',
	    'Xap.ej.element.grid.Grid', 
        'Xap.ej.element.field.Checkbox',
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.button.Button',
        'Xap.ej.element.label.Label',
        'Xap.ej.element.grid.column.CheckColumn',
        'Xap.ej.element.grid.column.ActionColumn',
	    'Xap.ej.element.grid.column.Date',
	    'Xap.ej.block.GridBlock',
	    'iih.mr.qa.doctor_self_score.block.DoctorScoreFormBlock',
	    'iih.mr.qa.doctor_self_score.block.DoctorScoreItemListBlock',
	    'iih.mr.qa.doctor_self_score.action.ScoreItemListSearchAction',
	    'iih.mr.qa.doctor_self_score.action.QaScoreSearchAction'
	    
	],

	alias:'widget.doctorscoreworkview',
 
	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.qa.doctor_self_score.block.DoctorScoreFormBlock',
                height: 60
            },
			'bottom': {
				xclass: 'iih.mr.qa.doctor_self_score.block.DoctorScoreItemListBlock'
				
			}
		},

		actions: {
			'init': {
				xclass: 'iih.mr.qa.doctor_self_score.action.ScoreItemListSearchAction',
				url: 'qacustom/qaAuto',
				//url: 'qacustom/dropdoctor_self_scoreItems',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			},
			'qaScoreSearch': {
				xclass: 'iih.mr.qa.doctor_self_score.action.QaScoreSearchAction',
				url: 'qacustom/amrScore',
				//url: 'http://172.18.73.65:8083/scored/amr',
				blocks: {
					condition: 'properties',
					result: 'top'
				}
			}
		},

		chains: {
			'init':['init'],
			'qaScoreSearch':['qaScoreSearch']
			
		},

		connections: {
			'top': [/*{
				event: 'afterrender',
				chain: 'init'
			},*/
			],
			'bottom': [/*{
				event: 'afterrender',
				chain: 'init'
			 }
			*/]
		}
	},
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
		    //var owner = this.getOwner();
	        /*var chainGrid = this.getActionChain('refresh');
	        if(chainGrid) {
	            chainGrid.execute();
	        };*/
	        var chainInit = this.getActionChain('init');
	        if(chainInit) {
	        	chainInit.execute();
	        }
		});
	}
})