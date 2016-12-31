select
  XSV_CD,
  OBJ_CD,
  RT_XSV_CD,
  VER_NO,
  NM,
  DES,
  SHT_NM_EN,
  NM_EN,
  REST_ACT_CD,
  REST_RE,
  AC_AU_F,
  PFM_AU_F
from
  ME_XSV
where
  REST_ACT_CD = /* method */''
and REST_RE = /* restPattern */''
and del_f = 0