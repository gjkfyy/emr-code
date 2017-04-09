Ext.define('iih.po.com.PortalPlugin', {
	extend: 'Xap.ej.platform.Plugin',

	requires: ['Xap.ej.Net'],

	pluginConfig: {
		extensions: {
			'iih.po.workbench.view': [],
			'functionlist': [{
                cd:'XAPM07.05',
                baseMenu: true,
                text:'病历文书一览',
                xclass:'iih.mr.wr.mr.view.MrDocListView',
                viewConfig:{}
             },{
                 cd:'XAPM07.118',
                 baseMenu: true,
                 text:'护理评分',
                 xclass:'iih.mr.wr.nsv.view.NurScoreWriteView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.123',
                 baseMenu: true,
                 text:'病历超时申请',
                 xclass:'iih.mr.qa.qa_apply.view.QaApplyListView',
                 viewConfig:{
	                 roleFlag: 1,
	                 applyType:'MRM25.01'
                 }
              },{
                 cd:'XAPM07.125',
                 baseMenu: true,
                 text:'病历超时管理',
                 xclass:'iih.mr.qa.qa_apply.view.QaApplyListView',
                 viewConfig:{
	                 roleFlag: 2,
	                 applyType:'MRM25.01'
                 }
              },{
                 cd:'XAPM07.127',
                 baseMenu: true,
                 text:'归档撤回申请',
                 xclass:'iih.mr.wr.mr_apply.view.MrApplyListView',
                 viewConfig:{
	                 roleFlag: 1,
	                 applyType:'MRM25.02'
                 }
              },{
                 cd:'XAPM07.126',
                 baseMenu: true,
                 text:'归档撤回管理',
                 xclass:'iih.mr.wr.mr_apply.view.MrApplyListView',
                 viewConfig:{
	                 roleFlag: 2,
	                 applyType:'MRM25.02'
                 }
              },{
                 cd:'XAPM07.104',
                 baseMenu: true,
                 text:'病历文书一览',
                 xclass:'iih.mr.wr.mr.view.MrDocListView',
                 viewConfig:{
                	 openType:true
                     }
              },{
                 cd:'XAPM07.06',
                 baseMenu: true,
                 text:'诊断查询',
                 xclass:'iih.po.assistant.view.DiagnosisHelperView',
                 //xclass:'iih.mr.di.view.InDiagnosisView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.92',
                 baseMenu: true,
                 text:'诊断录入',
                 xclass:'iih.mr.di.view.InDiagnosisView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.07',
                 baseMenu: true,
                 text:'既往病历',
                 xclass:'iih.po.assistant.view.MrDocHelperView',
                 haveEncounter:true,
                 viewConfig:{
                	 printable:false
                 }
             },{
                 cd:'XAPM07.08',
                 baseMenu: true,
                 text:'医嘱查询',
                 xclass:'iih.po.assistant.view.OrderListView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.09',
                 baseMenu: true,
                 text:'检查信息',
                 xclass:'iih.po.assistant.view.ObservationReportView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.10',
                 baseMenu: true,
                 text:'检验信息',
                 xclass:'iih.po.assistant.view.LabReportView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.11',
                 baseMenu: true,
                 text:'生命体征',
                 xclass:'iih.po.assistant.view.VitalSignHelperView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.12',
                 baseMenu: true,
                 text:'个人知识库',
                 xclass:'iih.po.assistant.view.PersonKnowledgeView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.21',
                 baseMenu: true,
                 text:'环节整改通知',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 viewConfig:{
                 	typeFlag: 1
                 }
             },{
                 cd:'XAPM07.43',
                 baseMenu: true,
                 text:'终末整改通知',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 viewConfig:{
                 	typeFlag: 2
                 }
             },{
                 cd:'XAPM07.49',
                 baseMenu: true,
                 text:'科室整改通知',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 viewConfig:{
                 	typeFlag: 3
                 }
             },{
            	 cd:'XAPM07.115',
            	 baseMenu: true,
            	 text:'医嘱整改通知',
            	 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
            	 viewConfig:{
            		 typeFlag: 4
            	 }
             },{
                 cd:'XAPM07.22',
                 baseMenu: true,
                 text:'审签一览',
                 xclass:'iih.mr.wr.mr.view.MrSignListView',
                 viewConfig:{}
             },{
                cd:'XAPM07.23',
                baseMenu: true,
                text:'基础模板管理',
                resource: true,
                objcd: 'MRK01',
                xclass:'iih.mr.tm.bas.view.BasTemplateListView',
                viewConfig:{}
             },{
                 cd:'XAPM07.24',
                 baseMenu: true,
                 text:'组合元素模板管理',
                 resource: true,
                 objcd: 'MRK06',
                 xclass:'iih.mr.tm.gro.view.GroupElementSearchView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.27',
                 baseMenu: true,
                 text:'病历模板管理',
                 resource: true,
                 objcd: 'MRK02',
                 xclass:'iih.mr.tm.mr.view.MrTemplateListView',
                 viewConfig:{
                     enTypeCode: 'ENM01.04',
                     dctNsF:'1'
                 }
             },/*{
                 cd:'XAPM07.100',
                 baseMenu: true,
                 text:'护理模板管理',
                 resource: true,
                 xclass:'iih.mr.tm.mr.view.MrTemplateListView',
                 viewConfig:{
                     enTypeCode: 'ENM01.04',
                     emrPrintSelected:'false',
                     dctNsF:'0'
                 }
             },{
                 cd:'XAPM07.83',
                 baseMenu: true,
                 text:'片段模板管理',
                 resource: true,
                 xclass:'iih.mr.tm.fr.view.FrTplListView'
             },*/{
                 cd:'XAPM07.32',
                 baseMenu: true,
                 text:'环节质控患者列表',
                 xclass:'iih.mr.qa.process_qa_patient.view.InProcessQAPatientListView',
                 viewConfig:{
                     typeFlag: 1
                 }
              },{
                  cd:'XAPM07.33',
                  baseMenu: true,
                  text:'环节质控追踪',
                  xclass:'iih.mr.qa.process_qa_track.view.ProcessQaNotificationView',
                  viewConfig:{
                      typeFlag: 1
                  }
              },{
                  cd:'XAPM07.98',
                  baseMenu: true,
                  text:'病案检索',
                  xclass:'iih.mr.dr.retrieval.view.DataRetrievalListView'
                  /*,
                  viewConfig:{
                      typeFlag: 1
                  }*/
              },{
                  cd:'XAPM07.99',
                  baseMenu: true,
                  text:'条件设置',
                  xclass:'iih.mr.dr.plan.view.PlanListView'/*,
                  viewConfig:{
                      typeFlag: 2
                  }*/
              },{
                  cd:'XAPM07.67',
                  baseMenu: true,
                  text:'环节质控工作查询',
                  xclass:'iih.mr.qa.process_qa_search.view.InProcessWorkSearchView',
                  viewConfig:{
                      typeFlag: 1
                  }
              },{
                  cd:'XAPM07.71',
                  baseMenu: true,
                  text:'自动质控查询',
                  xclass:'iih.mr.qa.dept_qa_auto_search.view.QaAutoSearchView',
                  viewConfig:{
                      typeFlag: 1
                  }
              },{
                 cd:'XAPM07.45',
                 baseMenu: true,
                 text:'待科室质控患者列表',
                 xclass:'iih.mr.qa.dept_qa_patient.view.DeptQAPatientListView',
                 viewConfig:{
                     typeFlag: 5
                 }
              },{
                 cd:'XAPM07.47',
                 baseMenu: true,
                 text:'评分患者列表',  //科室质控
                 xclass:'iih.mr.qa.score.view.ScoreQAPatientListView',
                 viewConfig:{
                     typeFlag: 2
                 }
              },{
                 cd:'XAPM07.35',
                 baseMenu: true,
                 text:'终末质控患者列表',
                 xclass:'iih.mr.qa.terminal_qa_patient.view.TerminalQAPatientListView',
                 viewConfig:{
                     typeFlag: 2
                 }
             },{
                 cd:'XAPM07.36',
                 baseMenu: true,
                 text:'终末质控追踪',
                 xclass:'iih.mr.qa.process_qa_track.view.ProcessQaNotificationView',
                 viewConfig:{
                     typeFlag: 2
                 }
             },{
                 cd:'XAPM07.46',
                 baseMenu: true,
                 text:'科室质控追踪',
                 xclass:'iih.mr.qa.process_qa_track.view.ProcessQaNotificationView',
                 viewConfig:{
                     typeFlag: 3
                 }
             },{
            	 cd:'XAPM07.114',
            	 baseMenu: true,
            	 text:'医嘱质控患者列表',
            	 xclass:'iih.mr.qa.order_qa_patient.view.OrderQAPatientListView',
            	 viewConfig:{
            		 typeFlag: 6
            	 }
             },{
                 cd:'XAPM07.56',
                 baseMenu: true,
                 text:'质控报表',
                 xclass:'iih.mr.qa.qa_reports.view.QaReportsListView',
                 viewConfig:{
                     typeFlag: 3
                 }
             },{
                 cd:'XAPM07.37',
                 baseMenu: true,
                 text:'评分患者列表',//终末质控
                 xclass:'iih.mr.qa.score.view.ScoreQAPatientListView',
                 viewConfig:{
                     typeFlag: 1
                 }
             },{
                 cd:'XAPM07.54',
                 baseMenu: true,
                 text:'质控设置',
                 xclass:'iih.mr.qa.qa_divide_level.view.QaItmWorkView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.41',
                 baseMenu: true,
                 text:'用户角色管理',
                 xclass:'iih.sy.userinfo.view.UserInfoManageView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.1001',
                 baseMenu: true,
                 text:'患者管理',
                 xclass:'iih.sy.patient.view.PatientManageView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.1002',
                 baseMenu: true,
                 text:'高级检索',
                 xclass:'iih.sy.search.view.AdvancedSearchView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.74',
                 baseMenu: true,
                 text:'报表角色管理',
                 xclass:'iih.sy.userinfo.view.ReportRoleManageView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.73',
                 baseMenu: true,
                 text:'系统参数设置',
                 xclass:'iih.sy.params.view.ParamsSetListView',
                 viewConfig:{}
             },{
            	 cd:'XAPM07.13',
            	 baseMenu: true,
            	 text:'质量自评',
            	 xclass:'iih.mr.qa.doctor_self_score.view.DoctorScoreWorkView',
            	 viewConfig:{}
             },{
            	 cd:'XAPM07.122',
            	 baseMenu: true,
            	 text:'病案首页',
            	 xclass:'iih.mr.qa.pat_case.view.PatCaseView',
            	 viewConfig:{}
             },{
            	 cd:'XAPM07.59',
            	 baseMenu: true,
            	 text:'待书写文书',
            	 xclass:'iih.mr.qa.need_write_mr.view.MrListView',
            	 viewConfig:{}
             },{
                 cd:'XAPM07.61',
                 baseMenu: true,
                 text:'诊断管理',
                 xclass:'iih.po.assistant.view.DiagnosisHelperView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.62',
                 baseMenu: true,
                 text:'既往病历',
                 xclass:'iih.po.assistant.view.MrDocHelperView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.63',
                 baseMenu: true,
                 text:'医嘱查询',
                 xclass:'iih.po.assistant.view.OrderListView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.64',
                 baseMenu: true,
                 text:'检查信息',
                 xclass:'iih.po.assistant.view.ObservationReportView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.65',
                 baseMenu: true,
                 text:'检验信息',
                 xclass:'iih.po.assistant.view.LabReportView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.66',
                 baseMenu: true,
                 text:'生命体征',
                 xclass:'iih.po.assistant.view.VitalSignHelperView',
                 haveEncounter:true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.58',
                 baseMenu: true,
                 text:'数据同步',
                 xclass:'iih.po.com.view.DataSyncView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.69',
                 baseMenu: true,
                 text:'病历书写',
                 xclass:'iih.mr.wr.omr.view.OutMrWriteView',
                 viewConfig:{},
                 assistantConfig:{}
             },/*{
                 cd:'XAPM07.70',
                 baseMenu: true,
                 text:'门诊模板管理',
                 xclass:'iih.mr.tm.mr.view.MrTemplateListView',
                 viewConfig:{
                     enTypeCode:'ENM01.01',
                     dctNsF:'1'
                 }
             },*/{
                 cd:'XAPM07.81',
                 baseMenu: true,
                 text:'病历书写',
                 xclass:'iih.mr.wr.omr.view.OutMrWriteView',
                 viewConfig:{},
                 itemView:{
                     cd:'XAPM07.82'
                 },
                 assistantConfig:{}
             },{
                 cd:'XAPM07.82',
                 text:'诊断录入',
                 xclass:'iih.mr.di.view.OutDiagnosisView',
                 isItem: true,
                 viewConfig:{}
             },{
                 cd:'XAPM07.88',
                 text:'组套维护',
                 xclass:'iih.mr.kr.csm.view.CSMKRView',
                 baseMenu: true,
                 viewConfig:{},
                 itemView:{
                     cd:'XAPM07.89'
                 }
             },{
                 cd:'XAPM07.89',
                 text:'组套分类',
                 xclass:'iih.mr.kr.csm.view.CSMCategoryView',
                 isItem: true,
                 viewConfig:{}
             },{
            	 cd:'XAPM07.59',
            	 baseMenu: true,
            	 text:'待书写文书',
            	 xclass:'iih.mr.qa.need_write_mr.view.MrListView',
            	 viewConfig:{}
             },{
                 cd:'XAPM07.91',
                 baseMenu: true,
                 text:'既往病历',
                 xclass:'iih.po.assistant.view.MrDocHelperView',
                 haveEncounter:true,
                 viewConfig:{
                	 printable:true
                 }
             },{
                 cd:'XAPM07.85',
                 baseMenu: true,
                 text:'病历文书类型组设置',
                 xclass:'iih.mr.wr.mr.view.MrTypeCcatView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.86',
                 baseMenu: true,
                 text:'病历文书类型设置',
                 xclass:'iih.mr.wr.mr.view.MrTypeView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.93',
                 baseMenu: true,
                 text:'共享元素设置',
                 xclass:'iih.mr.wr.mr.view.MrShareElementView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.105',
                 baseMenu: true,
                 text:'牙齿及牙周组织检查',
                 xclass:'iih.mr.tth.view.TeethExamView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.96',
                 baseMenu: true,
                 text:'护理记录',
                 xclass:'iih.mr.wr.nmr.view.NursingRecordsView',
                 assistantConfig:{},
                 viewConfig:{}
             },{
                 cd:'XAPM07.107',
                 baseMenu: true,
                 text:'上传病历',
                 xclass:'iih.mr.archive.patient_mediclRecord_archive.view.PatientView',
                 viewConfig:{}
             },{
            	 cd:'XAPM07.102',
                 baseMenu: true,
                 text:'护理记录',
                 xclass:'iih.mr.wr.nmr.view.NursingRecordsView',
                 viewConfig:{}
             },{
                 cd:'XAPM07.121',
                 baseMenu: true,
                 text:'工作量统计',
                 xclass:'iih.mr.qa.qa_reports.view.QaReportsListView',
                 viewConfig:{
                     typeFlag: 1
                 }
             },{
            	 cd:'XAPM07.109',
                 baseMenu: true,
                 text:'病历打印',//自助机
                 xclass:'iih.po.assistant.view.MrDocHelperView',
                 haveEncounter:true,
                 viewConfig:{
                	 printable:true,
                	 printTimesLimit:true,
                	 printerPortal:true
                 }
             },
             {
                 cd:'XAPM07.131',
                 baseMenu: true,
                 text:'环节整改通知',//护士工作站portal用
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 viewConfig:{
                 	typeFlag: 1
                 }
             },{
                 cd:'XAPM07.133',
                 baseMenu: true,
                 text:'终末整改通知',//护士工作站portal用
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 viewConfig:{
                 	typeFlag: 2
                 }
             },{
                 cd:'XAPM07.134',
                 baseMenu: true,
                 text:'科室整改通知',//护士工作站portal用
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 viewConfig:{
                 	typeFlag: 3
                 }
             },{
                 cd:'XAPM07.132',
                 baseMenu: true,
                 text:'审签一览',//护士工作站portal用
                 xclass:'iih.mr.wr.mr.view.MrSignListView',
                 viewConfig:{
                	 nursePortal:true
                 }
             },
             {
                 cd:'conditionInitView',
                 xclass:'iih.mr.dr.condition_set.view.ConditionView',
                 editorInside: true,
                 closable:true
             },
             {
                 cd:'conditionSettingInitView',
                 xclass:'iih.mr.dr.condition_set.view.ConditionSettingView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'mrdoceditview',
                 //xclass:'iih.mr.wr.mr.view.MrDocEditView',
                 xclass:'iih.mr.wr.mr.view.MrWriteView',
                 editorInside: true,
                 closable:true,
                 assistantConfig:{}
             },{
                 cd:'mrbastpleditview',
                 xclass:'iih.mr.tm.bas.view.BasTemplateEditView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'frtpleditview',
                 xclass:'iih.mr.tm.fr.view.FrTplEditView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'mrtpleditview',
                 //xclass:'iih.mr.tm.mr.view.MrTemplateEditView',
                 xclass:'iih.mr.tm.mr.view.MrTemplateManageView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'processQaDefectsView',
                 xclass:'iih.mr.qa.process_qa_patient.view.ProcessQaDefectsView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'processQaWorkView',
                 xclass:'iih.mr.qa.process_qa_work.view.QaWorkView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'terminalQaWorkView',
                 xclass:'iih.mr.qa.process_qa_work.view.QaWorkView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'deptQaWorkView',
                 xclass:'iih.mr.qa.process_qa_work.view.QaWorkView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'processQaDefectSearchView',
                 xclass:'iih.mr.qa.process_qa_search.view.ProcessQaDefectView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'qaAutoDefectView',
                 xclass:'iih.mr.qa.dept_qa_auto_search.view.QaAutoDefectView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'processQaDefectView',
                 xclass:'iih.mr.qa.process_qa_track.view.ProcessQaDefectView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'terminalQaDefectView',
                 xclass:'iih.mr.qa.process_qa_track.view.ProcessQaDefectView',
                 closable:true
             },{
                 cd:'departmentQaDefectView',
                 xclass:'iih.mr.qa.process_qa_track.view.ProcessQaDefectView',
                 closable:true
             },{
                 cd:'processRfmDefectView',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmDefectView',
                 editorInside: true,
                 closable:true
                
             },{
                 cd:'terminalRfmDefectView',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmDefectView',
                 editorInside: true,
                 closable:true
                
             },{
                 cd:'deptRfmDefectView',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmDefectView',
                 editorInside: true,
                 closable:true
                
             },
             {
                 cd:'scoreworkview',
                 xclass:'iih.mr.qa.score.view.ScoreWorkView',
                 editorInside: true,
                 closable:true
                
             },
             {
                 cd:'qareportview',
                 xclass:'iih.mr.qa.qa_reports.view.QaReportView',
                 closable:true
             },
             {
                 cd:'qareportwithoutconditionview',
                 xclass:'iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
                 closable:true
             },
             {
                 cd:'processqadefectview',
                 xclass:'iih.mr.qa.process_qa_search.view.ProcessQaDefectView',
                 editorInside: true,
                 closable:true
             },
             {
                 cd:'qaAutoConfigView',
                 xclass:'iih.mr.qa.qa_divide_level.view.QaAutoConfigView',
                 editorInside: true,
                 closable:true
             },
             {
                 cd:'qaMrConfigView',
                 xclass:'iih.mr.qa.qa_mr.view.QaMrConfigView',
                 editorInside: true,
                 closable:true
             },
             {
                 cd:'orderQaWorkView',
                 xclass:'iih.mr.qa.order_qa_work.view.OrderQaWorkView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'orderRfmdefectview',
                 xclass:'iih.mr.qa.order_qa_reform.view.OrderRfmDefectView',
                 editorInside: true,
                 closable:true
             },{
                 cd:'teethreportview',
                 xclass:'iih.mr.tth.view.TeethReportView',
                 closable:true
             }
             
             ,{
                 cd:'XAPM07.111',
                 baseMenu: true,
                 text:'病案查询',
                 xclass:'iih.mrb.view.SearchPatientEncountView',
                 viewConfig:{
                	 printable:true,
                	 managementPortal:true
                	
                 }
             }
             ,{
                 cd:'XAPM07.112',
                 baseMenu: true,
                 text:'使用率统计',
                 xclass:'iih.mrb.view.UserRateView',
                 viewConfig:{}
             }
             ,{
                 cd:'XAPM07.137',
                 baseMenu: true,
                 text:'数据元素管理',
                 xclass:'iih.masterdata.dataelement.dimensioncode.view.DictGeneralListView',
                 viewConfig:{}
             }
             ],
             'assistant': [{
                 cd:'diagnosis_helper',
                 text:'诊断',
                 xclass:'iih.po.assistant.view.DiagnosisHelperView',
                 isQuery:false,
                 haveEncounter:true
             },{
                 cd:'mr_doc_helper',
                 text:'病历文书',
                 xclass:'iih.po.assistant.view.MrDocHelperView',
                 isQuery:false,
                 haveEncounter:true
             },{
                 cd:'mr_order_list',
                 text:'医嘱',
                 xclass:'iih.po.assistant.view.OrderListView',
                 isQuery:false,
                 haveEncounter:true
             },{
                 cd:'mr_observation',
                 text:'检查报告',
                 xclass:'iih.po.assistant.view.ObservationReportView',
                 isQuery:false,
                 haveEncounter:true
             },{
                 cd:'mr_lab',
                 text:'检验报告',
                 xclass:'iih.po.assistant.view.LabReportView',
                 isQuery:false,
                 haveEncounter:true
             },{
                 cd:'vital_sign_helper',
                 text:'生命体征',
                 xclass:'iih.po.assistant.view.VitalSignHelperView',
                 isQuery:true,
                 haveEncounter:true
             },{
                 cd:'personal_knowledge_helper',
                 text:'个人知识库',
                 xclass:'iih.po.assistant.view.PersonKnowledgeView',
                 isQuery:false,
                 haveEncounter:true
             }/*,{
                 cd:'todo_helper',
                 text:'任务/问题一览',
                 xclass:'iih.mr.qa.process_qa_reform.view.ProcessRfmNotificationView',
                 isQuery:false,
                 haveEncounter:false
             }*/]
		}
	},

    init: function() {/*
        // 监听网络数据
        Xap.ej.Net.on('data', function(conn, data) {
            var app = Ext.getCmp('commonappmain');
            var layout = app.getLayout();
            layout.setActiveItem(2);
            // conn网络连接，可以使用方法conn.send(d)向外界发送数据，数据格式是字符串或者JSON对象
            console.log('connection: ');
            console.log(conn);
            // 接受的数据
            console.log('data: ');
            console.log(data);
            var token = data.data.token;
            var userCd,uuid,pwd,portalCd,hosArea,deptCd,enSn,docSn,patientId;
            var temp=[];
            console.log(token);
            if(!Ext.isEmpty(token, false)){
                temp = token.split("|");
                patientId = data.patientId;
                
                var loginView = app.down('login');
                var callBack = function(temp){
                    userCd = temp[0];
                    pwd = temp[9]||'MTIzNA==';
                    uuid = temp[1];
                    portalCd = temp[2];
                    hosArea = temp[3];
                    deptCd = temp[4];
                    enSn = temp[6];
                    docSn = temp[7];
                    userId = temp[10];
                    var name = this.down('xaptextfield[name=username]');
                    var pass = this.down('xaptextfield[name=password]');
                    name.setValue(userCd);
                    pass.setValue(pwd);
                    IMER_GLOBAL.user.code = userId;
                    IMER_GLOBAL.user.name = userId;
                    IMER_GLOBAL.hospitalArea.code = hosArea||'SZLH';
                    IMER_GLOBAL.hospitalArea.name = hosArea;
                    IMER_GLOBAL.department.code = deptCd;
                    IMER_GLOBAL.department.name = deptCd;
                    IMER_GLOBAL.portal.code = portalCd;
                    IMER_GLOBAL.portal.name = portalCd;
                    if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_7 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8 ||  IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_9)
                        IMER_GLOBAL.encounterSn = enSn;
                    else
                        IMER_GLOBAL.encounterSn = null;
                    
					var chainLogin = this.getActionChain('autologin');
                    chainLogin.execute({
						'userCd':userId,
						'portalCd':portalCd,
						'hosArea':hosArea||'PKUHIT',
						'deptCd':deptCd,
						'encounterSn':IMER_GLOBAL.encounterSn
					});
                };
                var workarea = app.down('xaptabpanel[id=workareapageview]');
                workarea.callBack = {
                    method: callBack,
                    scope: loginView,
                    params: [temp]
                };
                workarea.closePages = null;
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender");
            }else{
            	console.log('token is empty.');
            }
        });
    */}
})