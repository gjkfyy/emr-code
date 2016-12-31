Ext.define('iih.mr.wr.mr.view.MrTemplateSelectView',{
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
	    'iih.mr.wr.mr.block.WrTemplateListBlock',
	    'iih.mr.wr.mr.block.MrTemplateSearchConditionBlock',
		'iih.mr.wr.mr.action.MrTemplateSearchAction',
		'iih.mr.wr.mr.action.SearchMrTypeAction',
		'iih.mr.wr.mr.action.MrCustClaSearchAction',
		'iih.mr.wr.mr.action.CheckChangeAction'
	],

	alias:'widget.mrtemplateselectview',

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
		        xclass:'iih.mr.wr.mr.action.MrTemplateSearchAction',
		        url:'mr/tpl/template/canuse',
		        blocks:{
		            result:'result',
		            condition:'condition'
		        }
		    },
		    'select':{
                xclass:'iih.mr.wr.mr.action.MrTemplateSelectAction',
                url:'mr/dataBaseTime',
                blocks:{
                    result:'result'
                }
            },
            'confim':{
                xclass:'iih.mr.wr.mr.action.MrTemplateDblclickAction'
            },
            'initMrCustCla':{ 
                xclass:'iih.mr.wr.mr.action.MrCustClaSearchAction',
                url:'mr/create/init',

                blocks:{
                    result:'condition'
                }
            },
            'searchMrType':{
                xclass:'iih.mr.wr.mr.action.SearchMrTypeAction',
                url:'mrtypes',
                blocks:{
                    result:'condition'
                }
            },
            'doubleClickQuality':{
                xclass: 'iih.mr.wr.mr.action.DbClickItemQualityAction',
                //url: 'qaCheckCreateMr/mr',
                blocks: {
                    content: 'content'
                }
            },
            'checkChange':{
                xclass:'iih.mr.wr.mr.action.CheckChangeAction',
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
		    'doubleClickQuality':['doubleClickQuality'],
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
                chain: 'doubleClickQuality'
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
                chain: 'init'
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