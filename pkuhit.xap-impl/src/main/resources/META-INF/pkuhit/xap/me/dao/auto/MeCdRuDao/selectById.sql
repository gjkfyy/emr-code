select
  OBJ_ATTR_CD,
  ORG_CD,
  FST_MAX_CD,
  SND_MAX_CD,
  TRD_MAX_CD,
  FST_FMT,
  SND_FMT,
  TRD_FMT,
  FST_BIT,
  SND_BIT,
  TRD_BIT,
  MAX_LVL,
  PREFIX
from
  ME_CD_RU
where
  OBJ_ATTR_CD = /* objAttrCd */'a'
and del_f = 0
