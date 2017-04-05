/**
 * 系统管理top页面
 * 创建人:白斌
 * 时间:2013-04-15
 * 日志:
 * 		2013-04-15		新建
 */
Ext.define('iih.po.com.view.NoPatientTopPage', {
	extend: 'iih.po.com.view.TopBase',
	
	requires:['iih.po.com.view.TopBase'],
	
	alias: 'widget.nopatienttoppage',
	
	border: 0,
	
	icon: 'css/images/top/InpatientTop/icon.png',
	
	initComponent: function() {
		this.title = '病例管理系统';//FuiLocale.get('title', IemrUser.portal.key);
    	
    	this.callParent();
    },
    
    getExtraContent: function() {
		return Ext.create('Ext.container.Container', {
		    id: 'extraContent',
		    flex: 1,
			border: false,
			baseCls: '',
			cls: 'topHeader',
			margin: '0 0 0 50px',
			items: [{
				xtype: 'image',
				height: 50,
				src: 'css/images/top/TopBase/logo.png'
			}]
		});
	}
});