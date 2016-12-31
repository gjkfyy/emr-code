/** 
 *链接
 * @extends Xap.ej.element.button.Button
 * @author ：chenyajie<chen_yajie@founder.com>
 *
 *
 */
Ext.define('Xap.ej.element.linkbutton.LinkButton', {
	extend: 'Xap.ej.element.button.Button',
	alias: 'widget.linkbutton',
	
	text: 'linkButton',
    url:'http://www.baidu.com',
    handler: function() {
        
		window.location.href = url;
		//var httpAdapter = window.ActiveXObject ? new ActiveXObject("Microsoft.XMLHTTP") : new XMLHttpRequest();
	
	   // httpAdapter.Open("POST",'http://www.baidu.com', false); alert('You clicked the linkButton111111111111!');
	    //httpAdapter.SetRequestHeader ("Content-Type","text/xml; charset=gb2312");
		//alert('You clicked the linkButton222222222222222!');
	    //httpAdapter.SetRequestHeader ("SOAPAction","http://www.baidu.com"); 
		//alert('You clicked the linkButton33333333333333!');
	   // httpAdapter.Send(''); 
		//alert('You clicked the linkButton444444444444!');
	    //return httpAdapter;
    }
});