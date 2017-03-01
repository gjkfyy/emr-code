Ext.define('iih.sy.patient.action.CreateOmrDocAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: ['iih.sy.patient.view.CreateOmrView'],
	defaultConfig: {
	    width: 800,
	    height: 600,
	    layout : 'fit',
	    modal: true
	},	
	/*
	* @Override
	*/
	execute: function(context) {
		var block = this.getBlock('result');
		var me=this;
		var grid=block.down('xapgrid');
		var omrDocEditPage=this.getOwner().getBlock('right');
		var select = grid.getSelectionModel().getSelection();
		var workpageview = this.getOwner().ownerCt.items.items[1];
		var ccatCode = '';
		if(select.length>0&&select[0].raw&&select[0].raw.mrTypeCustomCode){
			ccatCode = select[0].raw.mrTypeCustomCode;
		}else if(select.length>0){
			ccatCode = select[0].raw.id;
		};
		var opType=context.opType;
		var title='新建病历';
		if(opType&&'reSelectTemp'==opType){
			title='重新选择模板';
		}
    	var config = {
    	    modal: true,           
    		width: 850,
    		height:550,
    		title :title,
    		contentConfig: {
    			xtype: 'createomrview',
    			initChain: {
    				name: 'init',
    				context: {
    					id:ccatCode,
    					opType:opType,
    					omrDocEditPage:omrDocEditPage,
    					workpageview:workpageview
    				}
    			}
    		}
    	};
		me.createWindow(config,context);
    },
    
    createWindow:function(context,context2){
        if(this.viewConfig) {
            var config = this.viewConfig;
            Xap.create(config).show();
        }
        else if(context && context.contentConfig && context.contentConfig.xtype) {
            // TODO xtype?
            var windowConfig = Ext.apply({}, this.defaultConfig);
            if(context.width) {
                windowConfig.width = context.width;
                context.width = null;
            }
            if(context.height) {
                windowConfig.height = context.height;
                context.height = null;
            }
            if(context.title) {
                windowConfig.title = context.title;
                context.title = null;
            }

            // 弹出窗口
            var window = Ext.create('Ext.window.Window', windowConfig);

            var contentConfig = context.contentConfig;
            var initChainConfig = contentConfig.initChain;
            contentConfig.initChain = null;
            
            window.add(contentConfig);
            var createmrblock=Ext.getCmp('createmrblock');
            var url = this.url+'/'+IMER_CONSTANT.CSA_ENABLE;
            var operation = {
                    url: url,
                    method: 'get',
                    scope: this,
                    success: function(result){
                    	var dataList=result.result.dataList;
                    	var csaEnable='0';//默认不启用组套
                    	if(dataList.length==1){
                    		csaEnable=dataList[0].value;
                    	}
                    	if('1'!=csaEnable){
                			createmrblock.items.items[0].remove(0);
                		}
                        window.show();
                        // 调用初始化Action
                        if(initChainConfig) {
                            var content = window.down(contentConfig.xtype);
                            var chain = content.getActionChain(initChainConfig.name);
                            if(chain) {
                                var ctx = initChainConfig.context || {};
                                ctx.parentWindow = window;
                                chain.execute(ctx);
                            }
                        }
                    }
                };
            context2.operations.push(operation);
        }
    }
});
