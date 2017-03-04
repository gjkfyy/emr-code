Ext.define('iih.mr.action.editor.EmrEditorOperatorAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    requires: ['Xap.ej.element.objectview.ObjectView'],
    /**
     * 将指定page中增加编辑器组件
     * 
     * @param page
     *            需要加入编辑器组件的page
     * @param params.objectId
     *            编辑器组件Id params.sstream 文档base64编码 params.mr_mode 编辑器打开模式 1：书写
     *            2：模板编辑 3：浏览 params.readonly 只读标识 'true':只读 'false'：非只读
     */
    insertWriter: function(page, params) {
        Ext.useShims=true;
		var self = this;
		var initEditor = function(o){
			
			var p = document.getElementById(params.objectId);
			p.tagName='AA';
			var b=new Date();
			console.log('%c'+b+':'+b.getMilliseconds()+'毫秒     编辑器加载完毕...','color: #86CC00; background-color: black; font-size: 20px; padding: 3px;');
			//编译器增加监听
			self.addOfficeEvent(p,page);
			//报错2014-12-6，田玉岩修改
			if(params.callBackAction){
				var callBackAction = page.getActionChain(params.callBackAction);
				if(callBackAction){
					callBackAction.execute();
				}
			}
		};
        var items = [{
            xtype: 'objectview',
            border:0,
            padding: '0 0 0 0',
            region: 'center',
            object: {
                id: params.objectId,
                type: 'application/x-founderoffice',
                width: '100%',
                height: '100%'
            },
            param: [{
                name: 'sstream',
                value: params.sstream
            }, {
                name: 'mr_mode',
                value: params.mr_mode
            }, {
                name: 'readonly',
                value: params.readonly
            }, {
                name: 'hidden',
                value: params.hidden
            }],
			afterRender: initEditor
        }];
        var a=new Date();
        console.log('%c'+a+':'+a.getMilliseconds()+'毫秒     开始将编辑器加载到当前页面,初始化参数如下：','color: #86CC00; background-color: black; font-size: 20px; padding: 3px;');
        console.log(items);
        page.insert(0, items);
        setTimeout(function() {
        	 var plugin = document.getElementById(items[0].object.id);
    		 if(plugin != null){
    	        if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7){//浏览病历不可粘贴（六院）
    	        	plugin.OfficeCommand(".Founder:CopyDisable");
    	        }else{
    	        	plugin.OfficeCommand(".Founder:CopyEnable");
    	        }
    		 }
        }, 500);
       
    },

    /**
     * 给编辑器增加事件，该事件触发后，会给隐藏按钮editorEvent触发editorEvent事件
     * 
     * @param object
     *            事件宿主对象
     * @param page
     *            宿主对象所在page
     */
    addOfficeEvent: function(object, page) {
        object.addEventListener('OfficeEvent', function(url) {
        	console.log('--------点击'+url+'--------');
            var button = page.down('[name=editorEvent]');
            button.fireEvent('editorEvent', url);
        });
        object.addEventListener('OfficeEventArgs', function(url,arg) {
        	console.log('--------点击'+url+'--------');
            var button = page.down('[name=editorEvent]');
            button.fireEvent('editorEvent', url,arg);
        });
    },
    
    /**
     * 给隱藏按鈕增加事件
     * 
     * @param page
     *            宿主对象所在page
     */
    addEditorEvent: function(page) {
        var editorEvent = page.down('button[name=editorEvent]');
        editorEvent.addEvents('editorEvent');
    },

    /**
     * 关闭进度条
     */
    closeProgress: function() {
        setTimeout(function() {
            Ext.MessageBox.hide();
        }, 200);
    },

    /**
     * 显示进度条
     */
    showProgress: function() {
        Ext.MessageBox.show({
            title: '请稍候',
            msg: '正在加载病历编辑器组件...',
//            progressText: '正在加载病历编辑器组件...',
            width: 300,
            progress: true,
            closable: false,
            modal: true,
            animateTarget: 'mb6'
        });

        var setRate = function(intCount) {
            return function() {
                if (intCount != 50) {
                    var i = intCount / 49;
                    Ext.MessageBox.updateProgress(i, Math.round(99 * i) + '% 已完成');
                }
            };
        };
        for ( var i = 1; i < 50; i++) {
            setTimeout(setRate(i), i * 20);
        }

    }
});
