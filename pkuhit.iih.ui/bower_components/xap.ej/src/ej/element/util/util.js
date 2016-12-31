/** 
 *
 * @author ：chenyajie<chen_yajie@founder.com>
 * ext工具类
 */
/*
*提示提示框
*/
function MsgBoxInfo(InfoText,callback)
{   
	Ext.Msg.show({
		title : '提示',
		msg : InfoText,
		model:true,
		fn:callback,
		buttons : Ext.Msg.OK,
		icon : Ext.Msg.INFO
	});
};
/*
*询问提示框
*/
function MsgBoxQst(MsgText,callback)
{   
	Ext.Msg.show({
		title : '询问',
		msg : MsgText,
		model:true,
		buttons : Ext.Msg.YESNO,
		fn:callback,
		icon : Ext.Msg.QUESTION
	});
};