Ext.define('iih.sy.patient.view.OmrTemplateSelectView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.sy.patient.block.WrTemplateListBlock',
	    'iih.sy.patient.block.MrTemplateSearchConditionBlock',
		'iih.sy.patient.action.OmrTemplateSearchAction',
		'iih.sy.patient.action.OmrTypeSearchAction',
		'iih.sy.patient.action.OmrCustClaSearchAction',
		'iih.sy.patient.action.CheckChangeAction'
	],

	alias:'widget.omrtemplateselectview',

	layout : {
		type: 'vbox',
		align : 'stretch'
	},
	height:335,
	xapConfig: {
		blocks: {
		    'condition': {
                xclass: 'iih.sy.patient.block.MrTemplateSearchConditionBlock',
                height:60
            },
			'result': {
				xclass: 'iih.sy.patient.block.WrTemplateListBlock'
				//height:250
			}
		},

		actions: {
		    'init':{
		        xclass:'iih.sy.patient.action.OmrTemplateSearchAction',
		        url:'mr/tpl/template/create',
		        blocks:{
		            result:'result',
		            condition:'condition'
		        }
		    },
		    'initMrCustCla':{ 
                xclass:'iih.sy.patient.action.OmrCustClaSearchAction',
                url:'mr/create/init',

                blocks:{
                    result:'condition'
                }
            },
            'select':{
                xclass:'iih.sy.patient.action.OmrTemplateSelectAction',
                url:'mr/dataBaseTime',
                blocks:{
                    result:'result'
                }
            },
            'confim':{
                xclass:'iih.sy.patient.action.OmrTemplateDblclickAction'
            },
            'enterPress':{
                xclass:'iih.sy.patient.action.EnterPressAction',
                blocks:{
                    result:'condition'
                }
            }/*,
		    'select':{
                xclass:'iih.sy.patient.action.OmrTemplateSelectAction',
                url:'mr/dataBaseTime',
                blocks:{
                    result:'result'
                }
            },
            'confim':{
                xclass:'iih.sy.patient.action.OmrTemplateDblclickAction'
            },
            'initMrCustCla':{ 
                xclass:'iih.sy.patient.action.OmrCustClaSearchAction',
                url:'mr/create/init',

                blocks:{
                    result:'condition'
                }
            },
            'searchMrType':{
                xclass:'iih.sy.patient.action.OmrTypeSearchAction',
                url:'mrtypes',
                blocks:{
                    result:'condition'
                }
            },
            'checkChange':{
                xclass:'iih.sy.patient.action.CheckChangeAction',
                blocks:{
                    result:'condition'
                }
            },
            'enterPress':{
                xclass:'iih.sy.patient.action.EnterPressAction',
                blocks:{
                    result:'condition'
                }
            }*/
		},

		chains: {
		    'init':['init'],
		    'initMrCustCla':['initMrCustCla'],
		    'select':['select'],
		    'confim':['confim'],
		    'enterPress':['enterPress']/*,
		    'select':['select'],
		    'confim':['confim'],
		    'creatMrDoc':['creatMrDoc'],
		    'initMrCustCla':['initMrCustCla'],
		    'searchMrType':['searchMrType'],
		    'checkChange':['checkChange'],
		    'enterPress':['enterPress']*/
		},

		connections: {
			'result':[{
		        event:'afterrender',
		        chain:'init'
		    },{
                selector: 'xapgrid',
                event: 'itemclick',
                chain: 'select'
            },{
            	selector: 'xapgrid',
                event: 'itemdblclick',
                chain: 'confim'
            }],
			'condition':[{
                event:'afterrender',
                chain:'initMrCustCla'
            },{
                selector: 'xaptextfield[name=templateNm]',
                event: 'specialkey',
                chain: 'enterPress'
            }]
		    /*'result':[{
		        event:'afterrender',
		        chain:'init'
		    },{
                selector: 'xapgrid',
                event: 'itemclick',
                chain: 'select'
            },{
            	selector: 'xapgrid',
                event: 'itemdblclick',
                chain: 'confim'
            }],
            'condition':[{
                event:'afterrender',
                chain:'initMrCustCla'
            },{
                selector: 'xapcombobox[name=mrCategoryCode]',
                event: 'change',
                chain: 'searchMrType'
            },{
                selector: 'xapcombobox[name=typeCode]',
                event: 'change',
                chain: 'init'
            },{
                selector: 'xapcheckboxgroup[name=personal]',
                event: 'change',
                chain: 'checkChange'
            },{
                selector: 'xapcheckboxgroup[name=dept]',
                event: 'change',
                chain: 'checkChange'
            },{
                selector: 'comboxgrid[name=deptCode]',
                event: 'change',
                chain: 'init'
            },{
                selector: 'xapcheckboxgroup[name=all]',
                event: 'change',
                chain: 'checkChange'
            },{
                selector: 'xaptextfield[name=templateNm]',
                event: 'specialkey',
                chain: 'enterPress'
            }]*/
		}
	}
})