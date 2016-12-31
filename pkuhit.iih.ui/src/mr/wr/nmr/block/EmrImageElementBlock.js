Ext.define('iih.mr.wr.nmr.block.EmrImageElementBlock',{
    extend : 'Xap.ej.block.Block',

    requires: [
        'Xap.ej.element.grid.Grid',  
        'Xap.ej.element.grid.column.ActionColumn'
    ],

    alias:'widget.nmrgridlistblock',

   // layout: 'fit',

    items: [ {
		xtype : "button",
		name : 'btnNew',
		text : '新建',
		width : 70,
		id:'btnNew', 
		margin : '5 5 5 410'
	},
	{
		xtype : "button",
		name : 'btnModfiy',
		text : '修改',
		width : 70,
		id:'btnModfiy',
		margin : '5 5 5 10'
	},{
    	xtype : 'displayfield',
		name : 'templeName',
		fieldLabel : '',
		labelAlign : 'right',
		anchor : '100% 88%',
		width : 500,
		renderer : function(value) {//Params:  Result:  <textarea id="params" type="text" name="params" cols="70" rows="6"></textarea>
			return ''
			+'<object id="graphicocx" WIDTH="0px" HEIGHT="0px" clsid="{E328A79E-4D6D-44F3-94AF-A9091E1A244C}" TYPE="application/x-itst-activex"></object>'
			;
		}
   },{
		xtype : "button",
		name : 'btnClose',
		text : '确认关闭',
		width : 70,
		id:'btnClose',
		margin : '-15 5 5 495'
	}],

    setData: function(data) {
        var grid = this.down('xapgrid');
        if(grid){
        	grid.setData(data);
        }
    }
});