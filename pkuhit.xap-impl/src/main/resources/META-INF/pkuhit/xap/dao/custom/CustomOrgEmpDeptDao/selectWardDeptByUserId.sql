select 
  wd.DEPT_CD,
  wd.WARD_CD,
  wd.ORG_CD,
  wd.DEPT_TP_CD,
  wd.NM,
  oed.EMP_DEPT_CD,
  oed.SIGN_LVL_CD,
  oed.CUR_DRC_DCT_ID,
  oed.CUR_DEPUTY_DRC_DCT_ID,
  wd.MEMO,
  wd.SORT_NO,
  wd.SPELL_NO,
  wd.WUBI_NO
from ORG_EMP_DEPT oed ,WARD_DEPT wd 
where oed.EMP_ID = /* userId */'004910' 
	and oed.WARD_DEPT_CD = wd.DEPT_CD
	and oed.del_f='0'
order by wd.DEPT_CD