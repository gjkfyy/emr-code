Ext.define('iih.po.com.block.SelectPortalBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.field.TextField',
		'Xap.ej.element.field.DisplayField',
		'Xap.ej.element.field.ComboBox'
	],

	alias:'widget.selectportalblock',

	bodyStyle: 'background:#FFFFFF;',
	layout: {
		type: 'table',
		columns: 3,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            align: 'center'
        },
        tdAttrs: {
            valign: 'middle'
        }
	},
	
	items:[
	   {
		xtype:'panel',
		width:1024,
		height:768,
		bodyStyle: {
			background:'url(css/images/portal/select_portal_bg.png) no-repeat',
			//marginTop:'40px',
			border:0
		},
		layout: {
			type: 'vbox',
			
		},

		items: [
			{
				xtype:'container',
				width:500,
				height:50,
				name:'selectButtons1',
				border:0,
				margin:'50px 0 0 50px',
				layout: {
					type: 'table',
					columns: 6,
					//width: 1024,
					tableAttrs: {
			            border: 0,
			            cellpadding: 0,
			            cellspacing: 0,
			            //width: '100%',
						align: 'left'
			        },
			        tdAttrs: {
			            valign: 'middle'
			        }
				},
				items:[
					{
						xtype: 'label',
						text: '院区',
						colspan: 1,
						margin:'0 20 0 0',
						style:{
							color:'#ffffff',
							fontSize:'16px',
							fontFamily:'黑体',
							fontWeight:'800'
						}
					},{
						xtype: 'xapcombobox',
						name: 'hosArea',
						colspan: 2,
						width:150,
						height:22,
						margin:'2 40 0 0',
						forceSelection:true,
						editable:false,
						style:{'text-align':'center','line-height':'18px'}
					},{
						xtype: 'label',
						text: '科室',
						colspan: 1,
						margin:'0 20 0 0',
						style:{
							width:50,
							color:'#ffffff',
							fontSize:'16px',
							fontFamily:'黑体',
							fontWeight:'800'
						}
					},{
						xtype:'xapcombobox',
						name: 'dept',
						width:150,
						height:22,
						colspan: 2,
						margin:'2 0 0 0',
						forceSelection:true,
						editable:false,
						style:{'text-align':'center','line-height':'18px'}
					},{
						xtype: 'xapdisplayfield',
						fieldLabel: '',
						colspan: 6,
						vertical: true,
						name:'portalInfo',
						value: ''
					}
				]
			},{
				xtype:'container',
				width:600,
				height:370,
				name:'selectButtons',
				conspan:3,
				border:0,
				layout: {
					type: 'table',
					columns: 3,
					//width: 1024,
					tableAttrs: {
			            border: 0,
			            cellpadding: 0,
			            cellspacing: 0,
			            //width: '100%',
						align: 'left'
			        },
			        tdAttrs: {
			            valign: 'top'
			        }
				}		
			},{
				xtype:'container',
				width:100,
				height:80,
				name:'backButtons',
				conspan:3,
				border:0,
				layout: {
					type: 'table',
					columns: 3,
					//width: 1024,
					tableAttrs: {
			            border: 0,
			            cellpadding: 0,
			            cellspacing: 0,
			            //width: '100%',
						align: 'right'
			        },
			        tdAttrs: {
			            valign: 'top'
			        }
				}		
			}
		]
	},
	{bodyStyle: 'background:#DDECFF;',border:0}],
	
	setDepartmentData: function(data){
	    var combo = this.down('xapcombobox[name=dept]');
	    if(data && data.dataList){
            var array = new Array();
            Ext.each(data.dataList,function(rec){
                if(rec)
                    array.push({'text':rec.name,'value':rec.code});
            });
            combo.setData(array);
            var record = combo.getStore().getAt(0);
            combo.select(record);
        }else{
            combo.clearValue();
        }
	},
	
	setPortalData: function(data){
	    var view = this.up('selectportal');
        var portallist = this.down('container[name=selectButtons]');
        var backbutton = this.down('container[name=backButtons]');
        var chain = view.getActionChain('enterPortal');
        if(data){
            portallist.removeAll(true);
            for(var i=0;i<data.length;i++){
                var item = Ext.create('Ext.button.Button',{
                    cls: data[i].shortEnglishName,
                    tooltip:data[i].name,
                    height: 130,
                    width: 130,
                    margin: '15 0 0 50',
                    border:0,
                    action: data[i].code,
                    handler:function(btn,e){
                        chain.execute(btn);
                    }
                });
                portallist.add(item);
            }
        }
        
        var back = Ext.create('Ext.button.Button',{
            cls: 'BACK_LOGIN',
            tooltip: locale.login.back,
            height: 100,
            width: 100,
            margin: '10 0 0 60',
            action: 'back',
            border:0,
            handler:function(btn,e){
                var logout = Xap.create({
                    xclass: 'iih.po.com.action.LogoutAction'
                });
                Xap.runAction(logout);
            }
        });
        backbutton.removeAll(true);
        backbutton.add(back);
    }	
})