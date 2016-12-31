Ext.define('iih.mr.wr.omr.view.OmrTemplateSelectView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.wr.mr.block.WrTemplateListBlock',
	    'iih.mr.wr.mr.block.MrTemplateSearchConditionBlock',
		'iih.mr.wr.omr.action.OmrTemplateSearchAction',
		'iih.mr.wr.omr.action.OmrTypeSearchAction',
		'iih.mr.wr.omr.action.OmrCustClaSearchAction',
		'iih.mr.wr.omr.action.CheckChangeAction'
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
                xclass: 'iih.mr.wr.mr.block.MrTemplateSearchConditionBlock',
                height:85
            },
			'result': {
				xclass: 'iih.mr.wr.mr.block.WrTemplateListBlock'
				//height:250
			}
		},

		actions: {
		    'init':{
		        xclass:'iih.mr.wr.omr.action.OmrTemplateSearchAction',
		        url:'mr/tpl/template/create',
		        blocks:{
		            result:'result',
		            condition:'condition'
		        }
		    },
		    'select':{
                xclass:'iih.mr.wr.omr.action.OmrTemplateSelectAction',
                url:'mr/dataBaseTime',
                blocks:{
                    result:'result'
                }
            },
            'confim':{
                xclass:'iih.mr.wr.omr.action.OmrTemplateDblclickAction'
            },
            'initMrCustCla':{ 
                xclass:'iih.mr.wr.omr.action.OmrCustClaSearchAction',
                url:'mr/create/init',

                blocks:{
                    result:'condition'
                }
            },
            'searchMrType':{
                xclass:'iih.mr.wr.omr.action.OmrTypeSearchAction',
                url:'mrtypes',
                blocks:{
                    result:'condition'
                }
            },
            'checkChange':{
                xclass:'iih.mr.wr.omr.action.CheckChangeAction',
                blocks:{
                    result:'condition'
                }
            },
            'enterPress':{
                xclass:'iih.mr.wr.mr.action.EnterPressAction',
                blocks:{
                    result:'condition'
                }
            }
		},

		chains: {
		    'init':['init'],
		    'select':['select'],
		    'confim':['confim'],
		    'creatMrDoc':['creatMrDoc'],
		    'initMrCustCla':['initMrCustCla'],
		    'searchMrType':['searchMrType'],
		    'checkChange':['checkChange'],
		    'enterPress':['enterPress']
		},

		connections: {
		    'result':[/*{
		        event:'afterrender',
		        chain:'init'
		    },*/{
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
            }]
		}
	}
})