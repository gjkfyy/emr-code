/** 
 *
 * 
 * @author ：chenyajie<chen_yajie@founder.com>
 * 消息工具类
 *
 */
Ext.define('Xap.ej.util.MsgUtil', {
	singleton: true,
	/*
	*消息提示框
	*/
	MsgBoxInfo: function (InfoText,callback) {
		Ext.Msg.show({
			title : '提示',
			msg : InfoText,
			model:true,
			fn:callback,
			buttons : Ext.Msg.OK,
			icon : Ext.Msg.INFO
		}); 
    },
	/*
	*询问提示框
	*/
	MsgBoxQst: function (MsgText,callback) {
		Ext.Msg.show({
			title : '询问',
			msg : MsgText,
			model:true,
			buttons : Ext.Msg.YESNO,
			fn:callback,
			icon : Ext.Msg.QUESTION
		});
    }

});
