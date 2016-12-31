/**
 * Created by guo_zhongbao on 2015/1/20.
 * datagrid表的行点击，选择或取消选择一行时触发事件
 */
Ext.define('iih.mr.tm.fr.action.FrTplRowclickAction', {
    extend: 'Xap.ej.action.Action',
    execute: function (context) {
        var datagrid = this.getBlock('result');
        var checkmodel = datagrid.getSelectionModel();
        var count1 = checkmodel.getCount();
        var selectedItemArr = datagrid.getSelectionModel().getSelection();
        var count = selectedItemArr.length ;
        var btnUpgradeStatus = false ; //升级
        var btnOpenStatus = false ;//打开
        var btnPropertyStatus = false ;//属性
        var btnDeleteStatus = false ;//删除
        var btnActivateStatus = false ;//启用
        var btnDeactivateStatus = false ;//停用
        if(count == 0){
        	
        }else{
            if(count == 1){
            	var item = selectedItemArr[0].raw;
            	if(item.canUpgrade){
            		btnUpgradeStatus = true ;//升级
            	}
            	if(item.canDelete){
            		btnDeleteStatus = true ;//升级
            	}
            	if(item.canActivated){
            		btnActivateStatus = true ;//升级
            	}
            	if(item.canStop){
            		btnDeactivateStatus = true ;//升级
            	}
                btnOpenStatus = true ;//打开
                btnPropertyStatus = true ;//属性
            }else{
                btnDeleteStatus = true ;//删除
                btnActivateStatus = true ;//启用
                btnDeactivateStatus = true ;//停用
                for(var i = 0 ; i < count ; i++ ){
                    var item = selectedItemArr[i].raw ;
                	if( btnDeleteStatus && ('0' == item.canDelete)){
                		btnDeleteStatus = false ;//删除
                	}
                	if( btnActivateStatus && ('0' == item.canActivated)){
                		btnActivateStatus = false ;//启用
                	}
                	if( btnDeactivateStatus && ('0' == item.canStop)){
                		btnDeactivateStatus = false ;//停用
                	}
                }
            }
        }
        var activatestatus = {
        		'btnUpgradeStatus':btnUpgradeStatus,
        		'btnOpenStatus':btnOpenStatus,
        		'btnPropertyStatus':btnPropertyStatus,
        		'btnDeleteStatus':btnDeleteStatus,
        		'btnActivateStatus':btnActivateStatus,
        		'btnDeactivateStatus':btnDeactivateStatus
        };
        var defectinAndmreditview = this.getOwner(); 	
        var chain = defectinAndmreditview.getActionChain('btnstatus');
        if(chain) {
                chain.execute({'activatestatus':activatestatus});
        }
    }
});
