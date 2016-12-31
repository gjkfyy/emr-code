select ORG_ID, ORG_CD orgCd,
  ORG_TP_CD  orgTpCd ,
  NM  nm,
  DES des,
  SHT_NM shtNm,
  ALIAS_NM  aliasNm,
  DIST_CD distCd ,
  SUBDIST_NM subdistNm,
  ZIP_NO zipNo,
  TEL_NO telNo,
  SPELL_NO spellNo,
  DEL_F    delF,
  FLAG  flag
from iemr_org
order by SORT_DATE