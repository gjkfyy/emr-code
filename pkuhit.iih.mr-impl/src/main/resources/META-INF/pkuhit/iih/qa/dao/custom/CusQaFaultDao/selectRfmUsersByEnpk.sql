select distinct(f.RFM_USER_ID),f.RFM_DEPT_CD 
  from QA_FLT f 
where f.DEL_F='0' 
  and f.revision_cd is null
  and f.EN_PK=/*enPk*/'867414'