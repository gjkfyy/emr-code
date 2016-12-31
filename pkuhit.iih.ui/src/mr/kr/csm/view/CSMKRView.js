Ext.define('iih.mr.kr.csm.view.CSMKRView', {              
    extend: 'Xap.ej.template.BaseTemplate',
    alias: 'widget.csmkrview',
    id:'csmkrview',
	requires:[
	         'iih.mr.kr.csm.view.CSMKRContentView'
	          ],
    xapConfig:{
	 
	     blocks: {
	
		       'content':{
		                 xclass:'iih.mr.kr.csm.view.CSMKRContentView',
	               }
           }
      }
})   