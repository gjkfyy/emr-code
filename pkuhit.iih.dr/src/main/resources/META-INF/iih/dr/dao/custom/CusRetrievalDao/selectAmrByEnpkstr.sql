select
  a.EN_PK as EN_PK,
  a.PA_ID as PA_ID,
  a.PA_NM as PA_NM,
  a.SEX_CD as SEX_CD,
  s.NM as SEX_NM,
  a.AGE as AGE,
  a.AMR_NO as AMR_NO,
  a.CUR_DEPT_CD as CUR_DEPT_CD,
  d.NM as CUR_DEPT_NM,
  a.CUR_DEPT_INTO_TIME as CUR_DEPT_INTO_TIME,
  a.FNSH_TIME as FNSH_TIME,
  a.CUR_MAIN_DI_CD as CUR_MAIN_DI_CD,
  di.NM as CUR_MAIN_DI_NM,
  a.ILL_STA_CD as ILL_STA_CD,
  i.NM as ILL_STA_NM,
  a.MEMO as MEMO
from
  MR_AMR a
  left join WARD_DEPT d on a.CUR_DEPT_CD=d.DEPT_CD
  left join MD_GS s on s.GS_CD=a.SEX_CD
  left join MD_GS i on i.GS_CD=a.ILL_STA_CD
  left join MD_DI di on di.DI_CD=a.CUR_MAIN_DI_CD
where
  a.DEL_F = 0
  /*%if enPkList != null */
  and a.EN_PK in /* enPkList */('1','2','3')
  /*%end */
