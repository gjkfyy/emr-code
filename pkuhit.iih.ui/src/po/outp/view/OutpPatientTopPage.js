Ext.define('iih.po.outp.view.OutpPatientTopPage', {
	extend: 'iih.po.com.view.TopBase',
	
	requires:['iih.po.com.view.TopBase'],
	
	alias: 'widget.outppatienttoppage',
	
	border: 0,
	
	icon: 'css/images/top/InpatientTop/icon.png',
	
	initComponent: function() {
    	this.title = '定制病例资料管理系统';//FuiLocale.get('title', IemrUser.portal.key);
    	this.info = new Ext.XTemplate(
    			'<table cellSpacing = "0" cellPadding = "0"><tr>',
    			'<td>',
    			'<div class="inpatienttop-border-div">',
				'<table height = "48" border = 0>',
				'<tr align = "left">',
					'<th name="patient">{patientName}</th>',
					'<th>{sexName}&nbsp</th>',
					'<th>{age}&nbsp</th>',
					'<th>{paInsurNm}&nbsp</th>',
				'</tr>',
				'<tr align = "left">',
				    '<td>门诊号：</td>',
				    '<td colspan=3>{amrNo}&nbsp</td>',
				'</tr>',
				'</table>',
				'</div>',
    			'</td>',
    			'<td name="encounter">',
    			'<div class="inpatienttop-border-div" style="margin-left:5px">',
				'<table height = "48" border = 0>',
				'<tr align = "left">',
				    '<td>诊断：</td><td colspan=3>{currentMainDiagnosisName}&nbsp</td>',
				'</tr>',
				'<tr align = "left">',
				    '<td>就诊时间：</td><td>{receiveTime}</td>',
				    '<td>&nbsp就诊次数：</td><td>{encounterCount}&nbsp</td>',
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
				id: 'outpatientTop_info'
			}]
		});
		return container;
	}
});