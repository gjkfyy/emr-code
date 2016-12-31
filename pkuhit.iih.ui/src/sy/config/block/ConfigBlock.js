Ext.define('iih.sy.config.block.ConfigBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.configblock',
    
    layout: {
		type: 'table',
		columns: 4,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%'
//            height:76
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	buttons:[{
        xtype: "button",
        name: 'save',
        action:'save',
        text: '保存',
        iconCls: 'icon-OK'
    },{
        xtype: "button",
        name: 'cancel',
        action:'cancel',
        text: '取消' ,
        iconCls: 'icon-cancel' 
    }],
    
    items:[
    {
		xtype: 'xapgridblock',
		title: '出诊科室排序',
		//autoScroll:true,
		/*plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],*/
		tools:[{
	        xtype:"button",
	        text:"上移",
	        width:50,
	        id:"leftupbutton",
	        handler: function() {
	        	var empDeptGrid = this.up("xapgridblock");
	            var records = empDeptGrid.getSelectionModel().getSelection();
	            var array = [];
	            for(var i in records){
	                var record = records[i];
	                array[i] = record;
	            }

	            var arrIndexs = [];//存储排序之前的索引，下面进行重新排序
	            var tempIndex = [];//存储排序之前的索引，不进行重新排序，用来获得行数据
	            for(var i in array){//存储索引
	                if(!isNaN(i)){
	                    var record = array[i];
	                    var index = empDeptGrid.getStore().indexOf(record);  
	                    arrIndexs[i] = index;
	                    tempIndex[i] = index;
	                }else{
	                    break;
	                }
	            }

	            //冒泡排序法对索引值进行重新排序
	            var temp = 0;
	            for (var i = 0; i < arrIndexs.length; i++){
	                for (var j = 0; j < arrIndexs.length - i; j++){
	                    if (arrIndexs[j] > arrIndexs[j + 1]){
	                        temp = arrIndexs[j + 1];
	                        arrIndexs[j + 1] = arrIndexs[j];
	                        arrIndexs[j] = temp;
	                    }
	                }
	            }

	            var selectIndex = [];//存储刷新界面后处于选中状态的行的索引
	            for(var k=0;k<arrIndexs.length;k++){
	                var index = arrIndexs[k];
	                for(var j in tempIndex){//遍历临时数组，获取到索引值对应的原始行数据数组所在的索引位置
	                    if(!isNaN(j)){
	                        if(tempIndex[j] == index){
	                            var dataIndex = j;
	                        }
	                    }else{
	                        break;
	                    }
	                }
	                var record = records[dataIndex];

	                selectIndex[k] = index-1;
	                if (index > 0) {  
	                	empDeptGrid.getStore().removeAt(index);  
	                	empDeptGrid.getStore().insert(index - 1, record);  
	                    empDeptGrid.refresh();   
	                    empDeptGrid.getSelectionModel().select(index - 1);
	                }else{
	                    Ext.MessageBox.alert("提示","已经到了第一行！");
	                    break;
	                } 
	            }

	        }
	    },{
	        xtype:"button",
	        text:"下移",
	        width:50,
	        id:"leftdownbutton",

	        handler: function() {  
	        	var empDeptGrid = this.up("xapgridblock");
	            var records = empDeptGrid.getSelectionModel().getSelection();
	            var array = [];
	            for(var i in records){
	                var record = records[i];
	                array[i] = record;
	            }

                var arrIndexs = [];
                var tempIndex = [];
                for(var i in array){
                    if(!isNaN(i)){
                        var record = array[i];
                        var index = empDeptGrid.getStore().indexOf(record);
                        arrIndexs[i] = index;
                        tempIndex[i] = index;
                    }else{
                        break;
                    }
                }
                //冒泡排序法对索引值进行重新排序
                var temp = 0;
                for (var i = 0; i < arrIndexs.length; i++){
                    for (var j = 0; j < arrIndexs.length - i; j++){
                        if (arrIndexs[j] > arrIndexs[j + 1]){
                            temp = arrIndexs[j + 1];
                            arrIndexs[j + 1] = arrIndexs[j];
                            arrIndexs[j] = temp;
                        }
                    }
                }

                var selectIndex = [];
                for(var i=arrIndexs.length-1;i>=0;i--){
                    var index = arrIndexs[i];
                    for(var j in tempIndex){
                        if(!isNaN(j)){
                            if(tempIndex[j] == index){
                                var dataIndex = j;
                            }
                        }else{
                            break;
                        }
                    }
                    var record = records[dataIndex];

                    selectIndex[i] = index+1;
                    if (index < empDeptGrid.getStore().getCount() - 1) {
                    	empDeptGrid.getStore().removeAt(index);
                    	empDeptGrid.getStore().insert(index + 1, record);
                        empDeptGrid.refresh();// 刷新行号
                        empDeptGrid.getSelectionModel().select(index + 1);
                    }else{
                        Ext.MessageBox.alert("提示","已经到了最后一行！");
                        break;
                    }
                }
	            

	         }
	    
	    }],
		CM_JR_Record: [
		           { header: '出诊科室主键', dataIndex: 'code', hidden: true},
                   { header: '出诊科室编码', dataIndex: 'wardDeptCode', hidden: true},
                   { header: '出诊科室', dataIndex: 'deptName',flex:1, hidden: false}
                  
		]
	}],
	setData: function(data) {
		
		var grid = this.down('xapgrid');
		if(data.dataList){
			grid.setData(data.dataList);
		}else{
			grid.setData([]);
		}
	},

})