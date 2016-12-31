select mf.* from XAP_ROLE_FU xrf,me_fu mf where xrf.fu_cd = mf.fu_cd
  xrf.ROLE_CD = /* roleCd */'a'
and del_f = 0
