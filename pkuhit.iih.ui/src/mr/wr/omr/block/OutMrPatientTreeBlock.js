Ext.define('iih.mr.wr.omr.block.OutMrPatientTreeBlock',{
	extend : 'Xap.ej.block.PanelBlock',
	
	requires: [
	           'Xap.ej.element.tree.Tree',
	           'Xap.ej.element.field.Checkbox'
	],
	alias:'widget.outmrdoctreeblock',
	
	autoScroll: true,
	items: [{
		xtype:'xaptree',
		title : '患者列表111',
		name : 'omrDocSortTree',
		border:false,
		ifSelect:true,
		height:180,
		rootVisible: false
	}, {
		xtype : 'xaptree',
		title:'病历文书模板',
		layout : 'fit',
		name : 'omrTempSortTree',
		id:'omrTempSortTree',
		selectBy : 'id',
		rootVisible : false,
		border : 0
	}],
	
	tbar:[{xtype:'button',iconCls: 'icon-Create',text:'新建',method: 'create'},
          {xtype:'button',iconCls: 'icon-Delete',id:'mrDelete',text:'删除',disabled:true,method: 'delete'},
          {xtype:'button',iconCls: 'icon-Property',text:'属性',disabled:true,method: 'property'},
          {xtype:'button',align: 'right',iconCls: 'icon-Create',text:'归档',method: 'complete',hidden:true},
          {xtype:'button',align: 'right',iconCls: 'icon-Delete',text:'取消归档',method: 'cancelComplete',hidden:true},
          {
              xtype: 'container',
              layout: {
                  type: 'hbox',
                  align: 'middle',
                  pack: 'end'
              },
              flex: 1,
              items:[{
                  xtype: 'tool',
                  type: 'refresh',
                  tooltip: '刷新',
                  callback:function(owner,tool){
                      var view = owner.up('outmrwriteview');
                      var chain = view.getActionChain('treeInit');
                      chain.execute({'tempInit':'tempInit'});
                  }
              },{
                  xtype: 'label',
                  width: 5
              },{
                  xtype: 'tool',
                  type: 'left',
                  callback:function(owner,tool){
                      var view = owner.up('outmrwriteview');
                      var block = view.getBlock('left');
                      block.collapse();
                  }
              },{
                  xtype: 'label',
                  width: 5
              }]
          }
    ],
	
    setData: function(data) {
	    var tree = this.down('xaptree[name=omrDocSortTree]');
	    var myobj=eval(data); 
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }
    
})