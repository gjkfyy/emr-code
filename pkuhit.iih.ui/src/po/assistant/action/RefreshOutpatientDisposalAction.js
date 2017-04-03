Ext.define('iih.po.assistant.action.RefreshOutpatientDisposalAction', {
	extend:  'Xap.ej.action.ServiceInvocation' ,
    
    doExecute: function(context) {
		var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	var data=this.getWriteStr();
    	this.data=data;
    	var hisDocPlugin=document.getElementById('iemrEditor');
		if(hisDocPlugin){
			if(data&&((data.chuzhi&&data.chuzhi.length>0)||(data.chufang&&data.chufang.length>0))){
				if(!hisDocPlugin.IsBlankLine()){
					Ext.MessageBox.show({
						title: '提示',
						msg: '当前位置不允许插入处方或处置，请回车，在新行中尝试插入!',
						buttons: Ext.MessageBox.OK,
						icon:'warning'
					});
				return;
				}
				this.prepareOperations(operations);
    		}
		}else{
			Ext.MessageBox.show({
				title: '提示',
			        msg: '未得到编辑器插件,请重新打开病历重试!',
			        buttons: Ext.MessageBox.OK,
			        icon:'warning'
			    });
		}
	},
	prepareOperations: function(operations) {
		var url = this.url;
	    var METHODS = this.getInvocationMethods();
		var operation = {
	        url: url,
			mclass: null,
			method: METHODS.METHOD_GET,
			condition: null,
			scope: this,
			success: this.onSuccess,
	        fail: this.onFail
		};
		operations.push(operation);
	},

	onSuccess: function(operation) {
		var temp=operation.result.data;
		var data=this.data;
		this.refreshOutpatientDisposal(data, temp);
	},
	onFail: function(operation) {
	},
    refreshOutpatientDisposal:function(data,mrTemplateModel){
    	function trim(str) {
            if (typeof str == "string") {
                str = str.replace(/^(\s|\u00A0)+/, '');
                for ( var i = str.length - 1; i >= 0; i--) {
                    if (/\S/.test(str.charAt(i))) {
                        str = str.substring(0, i + 1);
                        break;
                    }
                }
            }
            return str;
        };
    	var hisDocPlugin=document.getElementById('iemrEditor');
    	var tabList = hisDocPlugin.GetTables();
		var hasPresionGrid = 0;//0为无处方表格，1为有空表格，2为有处方数据的表格
    	var hasDisposalGrid = 0;
		if(tabList){                	    		
			for(var i=0;i<tabList.length;i++){
				if("门诊处方表"==tabList[i]){
					var content=hisDocPlugin.ExportTable("门诊处方表");
					if(content&&content.length>0){
						hasPresionGrid=2;
					}else{
						hasPresionGrid=1;
					}
				}else if("门诊处置表"==tabList[i]){
					var content=hisDocPlugin.ExportTable("门诊处置表");
					content=trim(content);
					if(content&&content.length>0){
						hasDisposalGrid=2;
					}else{
						hasDisposalGrid=1;
					}
				}
			}
		}
		if(data.chuzhi&&data.chufang&&data.chufang.length>0){
			if(hasDisposalGrid==0&&hasPresionGrid==0){//如果即没有处置表也没有处方表则插入占位表并执行刷新
				hisDocPlugin.InsertFromString(mrTemplateModel.prescriptionAndDisposeSignFile,0);//插入门诊处方及处置占位小模板
				hisDocPlugin.RefreshSpecifyTable('门诊处置表',1, data.chuzhi);
				console.log('--------1'+data.chufang);
	    		hisDocPlugin.ImportPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
			}else{
				if(hasDisposalGrid!=2&&hasPresionGrid!=2){
					if(hasDisposalGrid==0){
						hisDocPlugin.InsertFromString(mrTemplateModel.disposeSignFile,0);//插入门诊处置占位小模板
					}else if(hasPresionGrid==0){
						hisDocPlugin.InsertFromString(mrTemplateModel.prescriptionSignFile,0);//插入门诊处方占位小模板
					}
					console.log('-------2-'+data.chufang);
					hisDocPlugin.ImportPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
					hisDocPlugin.RefreshSpecifyTable('门诊处置表',1, data.chuzhi);
				}else{
					console.log('hasDisposalGrid='+hasDisposalGrid+'，hasPresionGrid='+hasPresionGrid);
					if(hasDisposalGrid==2&&hasPresionGrid==2){
						console.log('------3--'+data.chufang);
						console.log('------3--'+data.chuzhi);
						hisDocPlugin.AppendTableRow('门诊处置表',1, data.chuzhi,true);
						hisDocPlugin.AppendPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
					}else{
						if(hasDisposalGrid==2){
							hisDocPlugin.AppendTableRow('门诊处置表',1, data.chuzhi,true);
						}else if(hasDisposalGrid==0){
							console.log('hasDisposalGrid='+hasDisposalGrid);
							hisDocPlugin.InsertFromString(mrTemplateModel.disposeSignFile,0);//插入门诊处置占位小模板
							hisDocPlugin.RefreshSpecifyTable('门诊处置表',1, data.chuzhi);
						}else{
							hisDocPlugin.RefreshSpecifyTable('门诊处置表',1, data.chuzhi);
						}
						if(hasPresionGrid==2){
							console.log('hasPresionGrid='+hasPresionGrid);
							console.log('-------4-'+data.chufang);
							hisDocPlugin.AppendPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
						}else if(hasPresionGrid==0){
							console.log('-------5-'+data.chufang);
							hisDocPlugin.InsertFromString(mrTemplateModel.prescriptionSignFile,0);//插入门诊处方占位小模板
							hisDocPlugin.ImportPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
						}else{
							console.log('-------6-'+data.chufang);
							hisDocPlugin.ImportPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
						}
					}
				}
			}
	    }else{
	    	if(data.chuzhi){
	    		if(hasDisposalGrid==0||hasDisposalGrid==1){
	    			if(hasDisposalGrid==0){
		    			hisDocPlugin.InsertFromString(mrTemplateModel.disposeSignFile,0);//插入门诊处置占位小模板
		    		}
	    			hisDocPlugin.RefreshSpecifyTable('门诊处置表',1, data.chuzhi);
	    		}else if(hasDisposalGrid==2){
	    			hisDocPlugin.AppendTableRow('门诊处置表',1, data.chuzhi,true);
	    		} 
	    	}else if(data.chufang&&data.chufang.length>0){
	    		if(hasPresionGrid==0||hasPresionGrid==1){
	    			if(hasPresionGrid==0){
	    				hisDocPlugin.InsertFromString(mrTemplateModel.prescriptionSignFile,0);//插入门诊处方占位小模板
		    		}
	    			console.log('--------'+data.chufang);
	    			hisDocPlugin.ImportPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
	    		}else if(hasPresionGrid==2){
	    			console.log('--------'+data.chufang);
	    			hisDocPlugin.AppendPrescription('门诊处方表',mrTemplateModel.prescriptionFile,data.chufang,true);
	    		} 
	    	}
	    }
		hisDocPlugin.RemoveBlankPreTable('门诊处方表');
		hisDocPlugin.RemoveBlankPreTable('门诊处置表');
		hisDocPlugin.GotoMark("DOC_END");
    },
    getWriteStr:function(){
		var block = this.getBlock('orderlist');
    	var grid=block.down('xapgrid');
    	var re=grid.getSelectionModel().getSelection();
    	if(re&&re.length>0){
    		var records = new Array(0);
    		var selectRecords = re;
    		var len=re.length;
    		for(var j=0;j<len;j++){
	    		var minNum = selectRecords[0].raw.number;
	    		var minRow = 0;
	    		for(var i=0;i<selectRecords.length;i++){
	    		    if(selectRecords[i].raw.number<minNum){
	    		    	minNum = selectRecords[i].raw.number;
	    		    	minRow = i;
	    		    }
	    		}
	    		records.push(selectRecords[minRow]);
	    		selectRecords.splice(minRow, 1);
    		}
    		for(or in records){
    			for(or2 in records){
    				if(records[or].raw.orPk==records[or2].raw.parOrPk){
    					records[or].raw.parOrPk=records[or].raw.orPk;
    				}
    			}
    		}
    		
    		//数组 装处方数据
			var prescriptionsStr = new Array(0);
			//josn 装处方数据
			var all = null;
    		for(var i=0;i<records.length;i++){
				var orderTypeCd=records[i].raw.orTpCd;
				//处方
				orderTypeCd = orderTypeCd.replace(/(^\s*)|(\s*$)/g, ""); 
				if(orderTypeCd=='1'){
					orderTypeCd = '01';
				}else if(orderTypeCd=='3'){
					orderTypeCd = '02';
				}else if(orderTypeCd=='5'){
					orderTypeCd = '03';
				}else if(orderTypeCd=='6'){
					orderTypeCd = '04';
				}
				if(orderTypeCd=='04'){
					var specifDosage=records[i].raw.dosage;//+records[i].raw.dosageUnitNm;
					if(!specifDosage){
						specifDosage='&nbsp';
					}
					
					var orNoteNm=records[i].raw.orNoteNm;
					if(!(orNoteNm&&orNoteNm.length>0)){
						orNoteNm='&nbsp';
					}
					var routeNm=records[i].raw.routeNm;
					if(!routeNm){
						routeNm='&nbsp';
					}
					var amount=records[i].raw.amount;
					if(!amount){
						amount='&nbsp';
					}
					if(records[i].raw.takeAmountUnitNm){
						amount=amount+records[i].raw.takeAmountUnitNm;
					}
					var freqNm=records[i].raw.freqNm;
					if(!freqNm){
						freqNm='&nbsp';
					}
					//增加门诊处方，分组
					var prescriptionStr = 'yp_zl_name\n'+records[i].raw.svNm+'\nspeci_dosage\n'+specifDosage+
					'\nfrename\n'+freqNm+'\nyz_supply\n'+routeNm+
					'\nspecification\n'+records[i].raw.spec+'\nmz_charge_group\n'+orNoteNm+
					'\ndrug_amount\n'+amount;
					if(records[i].raw.parOrPk!=null&&records[i].raw.parOrPk!=undefined&&records[i].raw.parOrPk!=''&&records[i].raw.parOrPk!='0'){
						prescriptionStr=prescriptionStr+'\ngroup\n'+records[i].raw.parOrPk;
					}else{
						prescriptionStr=prescriptionStr+'\ngroup\n&nbsp';
					}
					
					prescriptionsStr.push(prescriptionStr);
				}else if(orderTypeCd=='01'||orderTypeCd=='02'||orderTypeCd=='03'){
					//处置（包括检验，检查，诊疗）
					if(all == null){
			    		  all = records[i].raw.svNm;
			    		  if("03"==records[i].raw.orTpCd){//03为门诊诊疗，可能有单位，需要特殊处理
			    			  var orderExecFreqNm='';
			    			  if(records[i].raw.freqNm !=undefined&& records[i].raw.freqNm!=null){
			    					orderExecFreqNm=records[i].raw.freqNm;
			    			  }
			    			  all = all+'          '+orderExecFreqNm;
			    		  }
			    	  }else{
			    		  all = all + '\n' + records[i].raw.svNm;
			    		  if("03"==records[i].raw.orTpCd){
			    			  var orderExecFreqNm='';
			        		  if(records[i].raw.freqNm!=undefined&&records[i].raw.freqNm!=undefined){
			        			  orderExecFreqNm=records[i].raw.freqNm;
			        		  }
			        		  all = all + '          '+orderExecFreqNm;
			    		  }
			    	  }
				 }
  			}
		    return  {'chufang':prescriptionsStr,'chuzhi':all};
    	}else{
    		//todo 加弹出框页面会卡死掉
    		Ext.MessageBox.show({
    		    title: '提示',
    		    msg: '请选择要写回病历的条目！',
    		    buttons: Ext.MessageBox.OK,
    		    fn: function(){},
    		    icon: 'warning'
    		});
    		return false;
    	}
    }
});
