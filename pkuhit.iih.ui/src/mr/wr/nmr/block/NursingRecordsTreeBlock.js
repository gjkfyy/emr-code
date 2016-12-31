Ext.define('iih.mr.wr.nmr.block.NursingRecordsTreeBlock',{
	extend : 'Xap.ej.block.PanelBlock',
	
	requires: [
	           'Xap.ej.element.tree.Tree',
	           'Xap.ej.element.field.Checkbox'
	],
	alias:'widget.nursingrecordstreeblock',

	layout: 'fit',
    
	items: [{
		xtype:'xaptree',
		border:false,
		ifSelect:true,
		autoScroll:true,
		height:245,
		rootVisible: false
	}],
	
	tbar:[{xtype:'button',iconCls: 'icon-Create',text:'新建',method: 'create',name:'insert',disabled:true,hidden:true},
          {xtype:'button',iconCls: 'icon-Delete',id:'mrDelete',text:'删除',disabled:true,method: 'delete',name:'delete',hidden:true},
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
                  name:'refresh',
                  tooltip: '刷新',
                  callback:function(owner,tool){
                      var view = owner.up('nursingrecordsview');
                      var chain = view.getActionChain('refresh');
                      chain.execute();
                  }
              },{
                  xtype: 'label',
                  width: 5
              },{
                  xtype: 'tool',
                  type: 'left',
                  callback:function(owner,tool){
                      var view = owner.up('nursingrecordsview');
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
    
});