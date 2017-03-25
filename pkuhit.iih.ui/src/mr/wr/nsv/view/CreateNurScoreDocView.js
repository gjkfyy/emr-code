Ext.define('iih.mr.wr.nsv.view.CreateNurScoreDocView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
	           'iih.mr.wr.nmr.action.SearchNmrTypeAction',
	           'iih.mr.wr.nsv.action.NurScoreTemplateSearchAction',
	           'iih.mr.wr.nsv.action.ConfimCreateNurScoreDocAction'
	   	],

	alias:'widget.createnurscoredocview',
	id:'createnurscoredocview',
	layout : {
		type: 'vbox',
		align : 'stretch'
	},
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.wr.nsv.block.NurScoreConditionBolck',
				height:85
			},
			'content':{
				xclass: 'iih.mr.wr.nsv.block.NurScoreGridListBlock'
			},
			'bottom':{
				xclass: 'iih.mr.wr.nsv.block.NurScorePropertyBlock'
			}
		},
		
		actions: {
		    'init':{
		        xclass:'iih.mr.wr.nsv.action.NurScoreTemplateSearchAction',
		        url:'mr/tpl/template/canuse',
		        blocks:{
		            result:'result',
		            condition:'condition',
		            bottom:'bottom'
		        }
		    },
		    'select':{
                xclass:'iih.mr.wr.nmr.action.NmrTemplateSelectAction',
                url:'mr/dataBaseTime',
                blocks:{
                    result:'result',
                    condition:'condition',
                    bottom:'bottom'
                }
            },
            'confim':{
                xclass:'iih.mr.wr.nsv.action.ConfimCreateNurScoreDocAction',
                url:'mr_doc_file',
                blocks:{
                    content:'content'
                }
            },
            'initMrCustCla':{ 
                xclass:'iih.mr.wr.nsv.action.InitNurScoreConditionAction',
                url:'mr/create/init',
                blocks:{
                    result:'condition'
                }
            },
            'searchMrType':{
                xclass:'iih.mr.wr.nmr.action.SearchNmrTypeAction',
                url:'mrtypes',
                blocks:{
                    result:'condition'
                }
            },
            'enterPress':{
                xclass:'iih.mr.wr.mr.action.EnterPressAction',
                blocks:{
                    result:'condition'
                }
            },
            'cancel':{
            	xclass: 'iih.mr.wr.nmr.action.NmrCloseCreateAction',
            	 blocks: {
 		            content: 'content'
 		        }
            },
            'checkChange':{
            	xclass:'iih.mr.wr.nmr.action.CheckChangeAction',
            	blocks: {
 		            content: 'condition'
 		        }
            }
		},

		chains: {
		    'init':['init'],
		    'docInit':['docInit'],
		    'select':['select'],
		    'confim':['confim'],
		    'creatMrDoc':['creatMrDoc'],
		    'initMrCustCla':['initMrCustCla'],
		    'searchMrType':['searchMrType'],
		    'enterPress':['enterPress'],
			'cancel':['cancel'],
			'checkChange':['checkChange']
		},

		connections: {
			'condition': [{
				event: 'afterrender',
				chain: 'initMrCustCla'
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
                selector: 'xapcheckboxgroup[name=all]',
                event: 'change',
                chain: 'checkChange'
            }
            
			],
			'content':[{
            	selector: 'xapgrid',
                event: 'itemdblclick',
                chain: 'confim'
            },{
            	selector: 'xapgrid',
                event: 'itemclick',
                chain: 'select'
            }
			],
			'bottom':[
				{
	                selector: 'button[name=cancel]',
	                event: 'click',
	                chain: 'cancel'
	            },{
	            	selector: 'button[name=confimUpPro]',
	                event: 'click',
	                chain: 'confim'
	            }]
				
			
		}
	},
	hasEdit: function() {
        var plugin = document.getElementById('iemrEditor');
        if (plugin != undefined &&plugin.valid&&plugin.IsModified()) {
            return true;
        } else {
            return false;
        }
    }
});