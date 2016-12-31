/**
 * Created by guo_zhongbao on 2015/1/20.
 * datagrid表的行点击，选择或取消选择一行时触发事件
 */
Ext.define('iih.mr.tm.mr.action.MrTemplateRowclickAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function (context) {
        var datagrid = this.getBlock('result').down('mrtemplatelistblock');
        var checkmodel = datagrid.getSelectionModel();
        var count1 = checkmodel.getCount();
        var selectedItemArr = datagrid.getSelectionModel().getSelection();
        var count = selectedItemArr.length ;
        /*var btnupgradeStatus  = false ;//升级
        var btnsubmitStatus  = false ;//提交
        var btnverifyStatus  = false ;//审核通过
        var btnrejectStatus  = false ;//驳回
        var btncancleVerifyStatus  = false ;// 取消审核
        var btnissueStatus  = false ;// 发布*/
        var btnopenStatus  = false ;//打开
        var btndeleteStatus  = false ;//删除
        var btnpropertyStatus  = false ;// 属性
        var btndisableStatus  = false ;//停用
        var btnenableStatus  = false ;//启用
        var btndefaultStatus  = false ;//默认模板
        if(count == 0){
        	
        }else{
            if(count == 1){
            	var item = selectedItemArr[0].raw;
            	if(item.canUpdate=='1'){
            		btnpropertyStatus = true ;//属性
            	}
            	/*if(item.canSubmit=='1'){
            		btnsubmitStatus = true ;//提交
            	}
            	if(item.canUpgrade=='1'){
            		btnupgradeStatus = true ;//升级
            	}
            	if( '1' == item.canReview){
            		btnverifyStatus = true ;//审核通过
            	}
            	if( '1' == item.canReject){
            		btnrejectStatus = true ;//驳回
            	}
            	if( '1' == item.canCancelReview){
            		btncancleVerifyStatus = true ;//取消审核
            	}
            	if( '1' == item.canPublish){
            		btnissueStatus = true ;//发布
            	}*/
            	if( '1' == item.canDelete){
            		btndeleteStatus = true ;//删除
            	}
            	if( '1' == item.canStop){
            		btndisableStatus = true ;//停用
            	}
            	if( '1' == item.canActivated ||  '1' == item.canSubmit ){
            		btnenableStatus = true ;//启用
            	}
            	if( '1' == item.canStop ){
            		btndefaultStatus = true ;//默认模板
            	}
            	btnopenStatus = true ;//打开
            	//btnpropertyStatus = true ;//属性
            }else{
            	/*btnsubmitStatus = true ;//提交
                btnverifyStatus  = true ;//审核通过
                btnrejectStatus  = true ;//驳回
                btncancleVerifyStatus  = true ;// 取消审核
                btnissueStatus  = true ;// 发布*/
                btndeleteStatus = true ;//删除
                btndisableStatus  = true ;//停用
                btnenableStatus  = true ;//启用
                btndefaultStatus = true ;//默认模板
                for(var i = 0 ; i < count ; i++ ){
                    var item = selectedItemArr[i].raw ;
                    /*if( btnsubmitStatus && ('0' == item.canSubmit)){
                		btnsubmitStatus = false ;//提交
                	}
                	if( btnverifyStatus && ('0' == item.canReview)){
                		btnverifyStatus = false ;//审核通过
                	}
                	if( btnrejectStatus && ('0' == item.canReject)){
                		btnrejectStatus = false ;//驳回
                	}
                	if( btncancleVerifyStatus && ('0' == item.canCancelReview)){
                		btncancleVerifyStatus = false ;//取消审核
                	}
                	if( btnissueStatus && ('0' == item.canPublish)){
                		btnissueStatus = false ;//发布
                	}*/
                	if( btndeleteStatus && ('0' == item.canDelete)){
                		btndeleteStatus = false ;//删除
                	}
                	if( btndisableStatus && ('0' == item.canStop)){
                		btndisableStatus = false ;//停用
                	}
                	if( btnenableStatus && ('0' == item.canActivated)){
                		btnenableStatus = false ;//启用
                	}
                	if( btnpropertyStatus &&  ('0' == item.canUpdate) ){
                		btnpropertyStatus = false ;//属性
                	}
                }
            }
        }
        var activatestatus = {
        		/*'btnupgradeStatus':btnupgradeStatus,
        		'btnsubmitStatus':btnsubmitStatus,
        		'btnverifyStatus':btnverifyStatus,
        		'btnrejectStatus':btnrejectStatus,
        		'btncancleVerifyStatus':btncancleVerifyStatus,
        		'btnissueStatus':btnissueStatus,*/
        		'btndeleteStatus':btndeleteStatus,
        		'btnpropertyStatus':btnpropertyStatus,
        		'btnopenStatus':btnopenStatus,
        		'btndisableStatus':btndisableStatus,
        		'btnenableStatus':btnenableStatus,
        		'btndefaultStatus':btndefaultStatus
        };
        var defectinAndmreditview = this.getOwner(); 	
        var chain = defectinAndmreditview.getActionChain('btnstatus');
        if(chain) {
                chain.execute({'activatestatus':activatestatus});
        }
    }
});
