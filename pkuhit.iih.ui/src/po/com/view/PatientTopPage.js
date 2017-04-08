/**
 * 一体化住院医生工作平台TOP页面
 * 创建人：白斌
 * 时间：2013-04-15
 * 日志：
 * 		2013-04-15		新建
 */
Ext.define('iih.po.com.view.PatientTopPage', {
	extend: 'iih.po.com.view.TopBase',
	
	requires:['iih.po.com.view.TopBase'],
	
	alias: 'widget.patienttoppage',
	
	border: 0,
	
	icon: 'css/images/top/InpatientTop/icon.png',
	
	initComponent: function() {
    	this.title = '病例管理系统';//FuiLocale.get('title', IemrUser.portal.key);
    	this.info = new Ext.XTemplate(
    			'<table cellSpacing = "0" cellPadding = "0"><tr>',
    			'<td>',
    			'<div class="inpatienttop-border-div">',
				'<table height = "48" border = 0>',
				'<tr align = "left">',
					'<th name="patient" colspan=2>{patientName}</th>',
					'<th>&nbsp{sexValue}</th>',
					'<th>{age}&nbsp</th>',
				'</tr>',
				'<tr align = "left">',
				    '<td colspan=4>手机号：{tel}</td>',
				'</tr>',
				'</table>',
				'</div>',
    			'</td>',
    			'<td name="encounter">',
    			'<div class="inpatienttop-border-div" style="margin-left:5px">',
				'<table height = "48" border = 0>',
				'<tr align = "left">',
				    '<td>入院诊断：</td><td colspan=3>{diagnosis}&nbsp</td>',
				'</tr>',
				'<tr align = "left">',
				    '<td>住院号：</td><td>{inpatientNo}</td>',
				    '<td>&nbsp入院日期：</td><td>{admissionDate}&nbsp</td>',
                '</tr>',
				'</table>',
				'</div>',
    			'</td>',
				'</tr></table>'
		);
    	this.callParent();
    },
	
	getExtraContent: function() {
		var container = Ext.create('Ext.container.Container', {
			baseCls: 'page-head',
			flex: 1,
			layout: {
				type: 'hbox',
				align: 'middle'
			},
			defaults: {
				margins: '0 0 0 5',
			},
			defaultType: 'container',
			items: [{
			    name: 'photoArea',
			    border: 0,
                baseCls: '',
                defaults: {
                    border: false
                },
                items: []
			},{
				width: 1000,
				height: 50,
				id: 'inpatientTop_info'
			}]
		});
		return container;
	}
});