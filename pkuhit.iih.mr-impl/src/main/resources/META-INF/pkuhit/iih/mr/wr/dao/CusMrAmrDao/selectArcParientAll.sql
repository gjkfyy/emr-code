select
	amr.EN_PK,
	amr.CUR_DEPT_CD,
	amr.AMR_NO,
	amr.PA_NM,
	amr.SEX_CD,
	amr.AGE,
	amr.RCV_TIME,
	amr.AMR_STA_CD,
	amr.FNSH_TIME,
	amr.CUR_MNG_DCT_ID,
	amr.CUR_MAIN_DI_CD,
	amr.ARC_F,
	ARC_F,
	ARC_TIME
from Mr_Amr amr
where amr.DEL_F='0'  and amr.EN_STA_CD = 'ENM02.04' --出院
	 /*%if currentDeptCode != null && currentDeptCode != "" */
	 and amr.CUR_DEPT_CD = /*currentDeptCode*/'a'  --科室
	   /*%end */
	 /*%if receiveTime != null && receiveTime != "" */
	 and amr.RCV_TIME > to_date(/*receiveTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')  --接诊时间
	    /*%end */
	  /*%if finishTime != null && finishTime != "" */
	 and amr.RCV_TIME < to_date(/*finishTime*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')  --接诊时间
	    /*%end */
	  /*%if amrNo != null && amrNo != ""*/
	 and amr.AMR_NO = /* amrNo */'a' --住院号
	  /*%end */
--	 /*%if amrStaCd=="MRM22.07"*/
--	 and amr.AMR_STA_CD =/* amrStaCd */'a' --病案状态
--	 /*%end */
--	  /*%if amrStaCd=="MRM22.06"*/
--	 and amr.AMR_STA_CD <>/* amrStaCd */'a' --病案状态
--	 /*%end */
	 /*%if checkQa==1*/--terminal_qa_sta_cd='MRM22.08'
	 and amr.TERMINAL_QA_STA_CD ='MRM22.08' --病案状态
	 /*%end*/
	 /*%if checkQa==0*/
	 and (amr.TERMINAL_QA_STA_CD !='MRM22.08'  or TERMINAL_QA_STA_CD is null)--病案状态
	 /*%end */
	 /*%if patientName != null && patientName != ""*/
	 and amr.PA_NM like /* @contain(patientName) */'%X%' --患者姓名
	  /*%end */
	 /*%if arcF != null*/
	 and amr.ARC_F=/*arcF*/0
	  /*%end */
order by amr.RCV_TIME desc