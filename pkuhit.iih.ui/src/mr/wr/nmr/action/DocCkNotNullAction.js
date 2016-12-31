Ext.define('iih.mr.wr.nmr.action.DocCkNotNullAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		this.prepareOperations(context.operations);
	},
    
    prepareOperations: function(operations) {
        var url=this.url+'/SYSM01.27';
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var me=this;
		var parms=operation.result.dataList;//病历提交验证非空元素名
		function convertXML(xmlString){
	        var xmlDoc=null;
	        if(!window.DOMParser && window.ActiveXObject){ 
	            var xmlDomVersions = ['MSXML.2.DOMDocument.6.0','MSXML.2.DOMDocument.3.0','Microsoft.XMLDOM'];
	            for(var i=0;i<xmlDomVersions.length;i++){
	                try{
	                    xmlDoc = new ActiveXObject(xmlDomVersions[i]);
	                    xmlDoc.async = false;
	                    xmlDoc.loadXML(xmlString); 
	                    break;
	                }catch(e){
	                }
	            }
	        }
	        else if(window.DOMParser && document.implementation && document.implementation.createDocument){
	            try{
	                domParser = new  DOMParser();
	                xmlDoc = domParser.parseFromString(xmlString, 'text/xml');
	            	}catch(e){
	            }
	        }else{
	            return null;
	        }

	        return xmlDoc;
	    }
		function ckCheckBoxs(nodes){
			var bool=false;
			if(nodes&&nodes.length>0){
				for (var i = 0; i < nodes.length; i++) {
					if(nodes[i]&&(nodes[i].nodeName=='element'||nodes[i].nodeName=='group')){
						if(nodes[i].getAttribute('type')=="CheckBox"){
							if(nodes[i].getAttribute('value')=="true"){
								bool=true;
								break;
							}
						}
					}
				}
			}
			return bool;
		}
		if(parms.length>0 ){
			if(parms[0].value&&parms[0].value!=','){
				var self=this;
				
				var ckNames=parms[0].value.split(',');
				var plugin = document.getElementById('iemrEditor');
				var xmlstr=plugin.ExportXML();
				var xml=convertXML(xmlstr);
				var bodyNodes= xml.getElementsByTagName("body")[0].childNodes;
				var msg="";
				
				for (var i = 0; i < bodyNodes.length; i++) {
					if(bodyNodes[i].nodeName=='element'||bodyNodes[i].nodeName=='group'){
						for (var j = 0; j < ckNames.length; j++) {
							var nm=ckNames[j].trim();
							if(bodyNodes[i].getAttribute('name')==nm){
								if(bodyNodes[i].getAttribute('type')=="Text"){//验证文本元素
									if(bodyNodes[i].childNodes.length==0){//文本无子节点
										if(!bodyNodes[i].getAttribute('display-value').trim()){
											msg+=nm+"、";
										}
									}
								}else if(bodyNodes[i].getAttribute('type')=="Combine"){//group多选 
									if(bodyNodes[i].childNodes.length>0){//多组复选框
										var bool= ckCheckBoxs(bodyNodes[i].childNodes);
										if(!bool){
											msg+=nm+"、";
										}
									}
								}else if(bodyNodes[i].getAttribute('type')=="CheckBox"){//CheckBox
									if(bodyNodes[i].getAttribute('value')=="false"){
										msg+=nm+"、";
									}
								
								}
							}
						}
					}
					
				}
				
				setTimeout(function() {
					if(msg){
						self.getOwner().docCkNotNull=false;
						Ext.Msg.alert("提示","请将【"+msg.substring(0, msg.length-1)+"】填写完整！");
					}
				},600);
			}
		}
    }
});
