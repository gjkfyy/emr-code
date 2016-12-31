select
  MR_PK,
  EN_PK,
  MR_TPL_CD,
  FILE_PK,
  NM,
  MR_TP_CD,
  ENCOUNTER_SN,
  MR_STA_CD,
  MR_QA_STA_CD,
  COMPLETED_F,
  SIGN_LVL_CD,
  BIZ_TIME,
  SUP_DCT_ID,
  SUBMIT_CD,
  SUBMIT_DATE,
  DEPT_CD,
  TREAT_DOCTOR_CD,
  MAST_DOCTOR_CD,
  MAST_DOCTOR_DATE,
  DIR_DOCTOR_CD,
  DIR_DOCTOR_DATE,
  MEMO,
  SORT_NO,
  SPELL_NO,
  WUBI_NO,
  UPD_CNT,
  CRT_TIME,
  CRT_USER_ID,
  CRT_DEPT_CD,
  LAST_UPD_TIME,
  LAST_UPD_DEPT_CD,
  LAST_UPD_USER_ID,
  DEL_F,
  CA_FILE_PK,
  ARC_F,
  XML_FILE_PK,
  TXT_FILE_PK,
  PRINT_COUNT,
  XML_CVET_F
from
  MR
where
  EN_PK = /* enPk */'a'
and del_f ='0'
 and XML_CVET_F='0' --未转换二维表的数据
 
 
