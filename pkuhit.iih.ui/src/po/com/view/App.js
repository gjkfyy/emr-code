Ext.define('iih.po.com.view.App', {
	extend: 'Ext.panel.Panel',

	requires: [
	           'iih.po.com.view.Login',
	           'iih.po.com.view.SelectPortal',
	           'iih.po.com.view.PortalView'
	           ],

	alias:'widget.app',
	
	id:'commonappmain',
	
	border: 0,
	
	layout:'card',
	
	items: [{
        id: 'login',
        xtype: 'login'
    },{
        id: 'selectportal',
        xtype: 'selectportal'
    },{
        id: 'portalview',
        xtype: 'portalview'
    }],
    
    initComponent: function() {
    	this.callParent();
    	Ext.getDoc().on('keydown',function(e) {
    		if(e.getKey() == 8 && e.getTarget().type =='text' && !e.getTarget().readOnly){
    	    }else if(e.getKey() == 8 && e.getTarget().type =='textarea' && !e.getTarget().readOnly){
    	    }else if(e.getKey() == 8 && e.getTarget().type =='password' && !e.getTarget().readOnly){
    	    }else if(e.getKey() == 8){    
    	        e.preventDefault();
    	        return false;
    	    }    
        });
    },
    listeners:{
    	afterrender:function(){
    	    var login = this.down('loginblock');
            Xap.ej.Net.open();
            var gui = require('nw.gui');
            var argv = gui.App.argv[0];
            console.log('gui argv is ' + argv);
            if(argv){
                login.hide();//跳转进入
            }else{
                login.show();//正常登录
            }
    	}
    }
})