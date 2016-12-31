Ext.define('iih.mr.wr.nsv.block.NurScoreDocTreeBlock',{
	extend : 'Xap.ej.block.PanelBlock',
	
	requires: [
	           'Xap.ej.element.tree.Tree',
	           'Xap.ej.element.field.Checkbox'
	],
	alias:'widget.outmrdoctreeblock',

	layout: 'fit',
    
	items: [{
		xtype:'xaptree',
		border:false,
		ifSelect:true,
		autoScroll:true,
		height:245,
		rootVisible: false
	}],
	
	tbar:[{xtype:'button',iconCls: 'icon-Create',text:'新建',method: 'create'},
          {xtype:'button',iconCls: 'icon-Delete',text:'删除',disabled:true,method: 'delete'},
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
                      var view = owner.up('nurscorewriteview');
                      var chain = view.getActionChain('treeInit');
                      chain.execute();
                  }
              },{
                  xtype: 'label',
                  width: 5
              },{
                  xtype: 'tool',
                  type: 'left',
                  callback:function(owner,tool){
                      var view = owner.up('nurscorewriteview');
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
	    var tree = this.down('xaptree');
	    var myobj=eval(data); 
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }
    
})