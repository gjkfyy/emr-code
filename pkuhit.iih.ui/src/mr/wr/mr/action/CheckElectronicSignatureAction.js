Ext.define('iih.mr.wr.mr.action.CheckElectronicSignatureAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    /*
     * @Override
     */
    execute: function(context,callback) {
        this.prepareOperations(operations,callback);
        /*var certId = plugin.CA_GetCertId();
        if (userName == '') {
            FuiMessageBox.confirm2('未检测到电子签章， 使用文字签章？', function(btn) {
                if (btn == 'yes') {
                    callback(pojoUser.employee.employeeNm);
                }
            });
        } else {
            if (pojoUser.employee.employeeNm == userName) {
                var picPngStr = plugin.CA_GetPicPNG();
                if (picPngStr.length < 1) {
                    FuiMessageBox.confirm2('无法获得电子签章， 使用文字签章？', function(btn) {
                        if (btn == 'yes') {
                            picPngStr = pojoUser.employee.employeeNm;
                            callback(pojoUser.employee.employeeNm);
                        }
                    });
                } else {
                    picPngStr = '\n';//使用电子签名的时候，传空字符串给编辑器，编辑器会从Ukey拿到签名图片
                    callback(picPngStr);
                }
            } else {
                Ext.MessageBox.alert('提示', '当前用户【' + pojoUser.employee.employeeNm + '】与电子签章用户【' + userName + '】不一致，无法提交!');
            }
        }*/
    },
    prepareOperations: function(operations) {
        var url = 'userInfo';
        var operation = {
                url: url,
                method: 'get',
                condition: condition,
                scope: this,
                success: this.onSuccess
                // fail: this.onFail
            };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getOwner().getBlock('condition');
        var mrTypeCd=block.down('[name=mrTypeCd]');
//        console.log(mrTypeCd);
//        console.log(operation.result);
        if(operation.result){
            mrTypeCd.setData(operation.result);
            mrTypeCd.expand();
        }
    }
});
