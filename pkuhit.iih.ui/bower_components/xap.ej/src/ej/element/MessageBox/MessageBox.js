/** 
 *
 * 弹出框
 * @extends Ext.window.MessageBox
 * @author：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.MessageBox.MessageBox', {
	extend: 'Ext.window.MessageBox',
	
	requires: ['Xap.ej.locale.Locale'],
	
	alias: 'widget.xapmessagebox',
	
	closable: true,
	
	draggable: true,
	
	autoScroll: true,
	
	SUCCESS : Ext.baseCSSPrefix + 'message-box-success',
	
	FAIL : Ext.baseCSSPrefix + 'message-box-fail',
	
	initComponent: function () {
		if (!window.FuiLocale) {
			window.FuiLocale = Ext.create('Xap.ej.locale.Locale');
		}
		this.buttonText = {
			ok: FuiLocale.get('messagebox', 'ok'),
			yes: FuiLocale.get('messagebox', 'yes'),
			no: FuiLocale.get('messagebox', 'no'),
			cancel: FuiLocale.get('messagebox', 'cancel')
		};
		
	    this.callParent();
	    
	    this.addListener('beforeshow', this.atBeforeShow, this);
	    this.addListener('hide', this.atHide, this);
	    this.addListener('show', this.atShow, this);
	},
	
	confirm: function(msg, fn, scope) {
		var cfg = {
			title: FuiLocale.get('messagebox', 'confirm'),
			icon: this.QUESTION,
			msg: msg,
			buttons: this.YESNOCANCEL,
			callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
			scope: scope
		};
		this.show(cfg, arguments);
    },
    
    confirm2: function(msg, fn, scope) {
		var cfg = {
			title: FuiLocale.get('messagebox', 'confirm'),
			icon: this.QUESTION,
			msg: msg,
			buttons: this.YESNO,
			callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
			scope: scope
		};
		this.show(cfg, arguments);
    },
    
    warn: function(msg, fn, scope) {
    	var cfg = {
    		title: FuiLocale.get('messagebox', 'warn'),
    		icon: this.WARNING,
    		msg: msg,
    		buttons: this.OK,
    		callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
    		scope: scope
    	};
    	this.show(cfg, arguments);
    },
    
    info: function(msg, fn, scope) {
    	var cfg = {
       		title: FuiLocale.get('messagebox', 'info'),
       		icon: this.INFO,
       		msg: msg,
       		buttons: this.OK,
       		callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
       		scope: scope
       	};
       	this.show(cfg, arguments);
    },
    
    error: function(msg, fn, scope) {
    	var cfg = {
       		title: FuiLocale.get('messagebox', 'error'),
       		icon: this.ERROR,
       		msg: msg,
       		width: 400,
       		buttons: this.OK,
       		callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
       		scope: scope
       	};
       	this.show(cfg, arguments);
    },
    
    success: function(msg, fn, scope) {
    	var cfg = {
       		title: FuiLocale.get('messagebox', 'success'),
       		icon: this.SUCCESS,
       		msg: msg,
       		buttons: this.OK,
       		callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
       		scope: scope
       	};
       	this.show(cfg, arguments);
    },
    
    fail: function(msg, fn, scope) {
    	var cfg = {
       		title: FuiLocale.get('messagebox', 'fail'),
       		icon: this.FAIL,
       		msg: msg,
       		buttons: this.OK,
       		callback: Ext.isFunction(fn) ? fn : Ext.emptyFn,
       		scope: scope
       	};
       	this.show(cfg, arguments);
    },
    
    wait: function(cfg, title, config){
        if (Ext.isString(cfg)) {
            cfg = {
                title: title,
                msg: cfg,
                closable: false,
                wait: true,
                modal: true,
                minWidth: this.minProgressWidth,
                waitConfig: config
            };
        }
        return this.show(cfg, arguments);
    },
    
    show: function(cfg, params) {
    	if (Ext.isObject(cfg.msg)) {
    		this.detail = cfg.msg.detail;
    		cfg.msg = cfg.msg.message;
    	} else {
    		delete this.detail;
    	}
    	
    	if (params && params.length > 0) {
    		var element = 'workareapageview';
    		var lastArg = params[params.length - 1];
    		if (Ext.isObject(lastArg) && lastArg) {
    			element = lastArg;
    		}
    		cfg.alignEl = element;
    	}
    	
    	return this.callParent([cfg]);
    },
    
    atBeforeShow: function() {
    	var me = this;

    	if (this.detail) {
	    	var dockedItems = this.getDockedItems('toolbar[dock="bottom"]')[0];
	    	dockedItems.add({
	    		xtype: 'button',
	    		itemId: 'detail',
	    		width: 75,
	    		enableToggle: true,
	    		text: FuiLocale.get('messagebox', 'detail') + '︾',
	    		dialogHeight: me.getHeight(),
	    		toggleHandler: function(button, state) {
	    			if (state) {
	    				button.setText(FuiLocale.get('messagebox', 'detail') + '︽');
	    				me.setHeight(button.dialogHeight*2);
	    				me.body.child('.messagebox-detail').setStyle({
	    					width: me.getWidth() - 30 + 'px',
	    					height: button.dialogHeight + 5 + 'px',
	    					top: button.dialogHeight/2 - 10 + 'px',
	    					left: '10px',
	    					display: 'block'
	    				});
	    			} else {
	    				button.setText(FuiLocale.get('messagebox', 'detail') + '︾');
	    				me.body.child('.messagebox-detail').setStyle({
	    					display: 'none'
	    				});
	    				me.setHeight(button.dialogHeight);
	    			}
	    		}
	    	});
    	
    		this.body.appendChild({
    			tag: 'div',
    			cls: 'messagebox-detail',
    			html: this.detail
    		});
    		
    	}
    },
    
    atHide: function() {
    	var me = this;
    	
    	if (this.detail) {
    		var dockedItems = this.getDockedItems('toolbar[dock="bottom"]')[0];
    		dockedItems.remove(dockedItems.getComponent('detail'));
    		this.body.child('.messagebox-detail').remove();
    		delete this.detail;
    	}
    },
    
    atShow: function() {
		this.alignTo(this.cfg.alignEl, 'c-c');
    }
}, function() {
	window.XapMessageBox = Ext.create('Xap.ej.element.MessageBox.MessageBox');
});