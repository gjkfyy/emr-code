 select top 2000 ORG_EMP_DEPT_ID,
   EMP_DEPT_CD  empDeptCd,
   WARD_DEPT_CD wardDeptCd,
   EMP_ID     empId,
   SIGN_LVL_CD signLvlCd,
   CUR_DRC_DCT_ID curDrcDctId,
   CUR_DEPUTY_DRC_DCT_ID curDeputyDrcDctId,
   DEL_F        delF,
  FLAG    flag
 from iemr_org_emp_dept
 order by SORT_DATE