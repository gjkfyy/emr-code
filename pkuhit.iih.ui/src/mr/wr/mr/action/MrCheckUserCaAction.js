Ext.define('iih.mr.wr.mr.action.MrCheckUserCaAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    requires:['iih.po.com.BJCAUtil','iih.po.com.NetCAUtil'],
    /*
     * @Override
     */
    mrCheckUserCaAction:'',
    execute: function(context) {
    	mrCheckUserCaAction=this;
        var operations = context.operations;
        if(!operations) {
            return;
        }
        
        var method=context.method;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        if(method=='emrSubmit'){
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',false);
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave',false);
        }
        this.getOwner().cmdName=method;
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var url=this.url;
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
    	var me=mrCheckUserCaAction;
    	var loginId=mrCheckUserCaAction.getOwner().loginId;
    	var name=mrCheckUserCaAction.getOwner().name;
    	var signPicture=mrCheckUserCaAction.getOwner().signPicture;
    	var user=operation.result.data;
    	var isUseCa = user.isUseCa; //cis是否使用ca
    	var certID = IMER_GLOBAL.certID;
    	if(loginId&&name){
    		user.loginId=loginId;
    		user.name=name;
    		user.signPicture=signPicture;
    		user.practiceDoctor='1';
    	}
    	if('1'==user.useCa){
    		var plugin = document.getElementById('iemrEditor');
    		var userName=plugin.CA_GetUserName();
    		if(userName==''){
    			if(isUseCa == '1'){
    				 Ext.MessageBox.alert('提示', '请插入CA!');
    			}else{
    				XapMessageBox.confirm2('未检测到电子签章， 使用文字签章？', function(id){
        				if(id=='yes'){
        					me.exceAction({user:user});
        				}else{
        					me.enable();
        				}
        			}
    				);
    			}
            }else{
            	if(user.name==userName){
        	        if(CONFIG_PARAM.CA_SUBJECT == 1){
        	        	if(certID == ""){
        	        		Ext.MessageBox.alert('提示', '请用ca方式登录！');
        	        	}else{
        	        		var picPngStr=iih.po.com.BJCAUtil.GetKeyPic();
        	        		if(picPngStr.length<1){
                                FuiMessageBox.confirm2('无法获得电子签章， 使用文字签章？', function(btn) {
                                    if (btn == 'yes') {
                                    	me.exceAction({user:user});
                                    }else{
                                    	me.enable();
                                    }
                                });
                            }else{
                            	user.name= '\n';//使用电子签名的时候，传空字符串给编辑器，编辑器会从Ukey拿到签名图片
                            	pic=picPngStr;
                            	this.exceAction({
                            		user:user,
                            		pic:pic
                            		});
                            }
            				
        	        	}
        	        }
            		else{
            			var picPngStr=plugin.CA_GetPicPNG();
            			if(picPngStr.length<1){
                            FuiMessageBox.confirm2('无法获得电子签章， 使用文字签章？', function(btn) {
                                if (btn == 'yes') {
                                	me.exceAction({user:user});
                                }else{
                                	me.enable();
                                }
                            });
                        }else{
                        	user.name= '\n';//使用电子签名的时候，传空字符串给编辑器，编辑器会从Ukey拿到签名图片
                        	pic=picPngStr;
                        	this.exceAction({
                        		user:user,
                        		pic:pic
                        		});
                        }
            		}
                        
                }else{
                	var action='提交';
                	var method = mrCheckUserCaAction.getOwner().cmdName;
                	if('emrApprove'==method){
                		action='审签';
                	}
                	me.enable();
                    Ext.MessageBox.alert('提示', '当前用户【'+user.name+'】与电子签章用户【'+userName+'】不一致，无法'+action+'!');
                }
            }
    	}else{
    		me.exceAction({user:user});
    	}
    },
    exceAction:function(data){
    	var method = mrCheckUserCaAction.getOwner().cmdName;
//        console.log('--------'+method+'--------');
        method=method+'2';
        var owner = mrCheckUserCaAction.getOwner();
        var chain = owner.getActionChain(method);
        if(chain) {
            chain.execute(data);
        }
    },
    enable:function(){
    	var method = mrCheckUserCaAction.getOwner().ownerCt.cmdName;
    	if(method=='emrSubmit'){
        	var plugin = document.getElementById('iemrEditor');
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',false);
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave',false);
        }
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave',true);
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取用户信息失败!');
    }
});
