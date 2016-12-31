select 
  m.FRAGMENT_TPL_CD,
  m.FRAGMENT_TPL_CONTENT,
  m.FRAGMENT_TPL_TYPE_CD,
  (select md.nm from md_gs md where md.gs_cd = m.owner_type_cd) owner_type_cd,
  m.owner_cd,
  (select t.fragment_tpl_type_nm from mr_fragment_tpl_type t where t.fragment_tpl_type_cd = m.fragment_tpl_type_cd) fragment_tpl_type_nm,
  m.FRAGMENT_TPL_NM,
  m.CRT_USER_ID
from MR_FRAGMENT_TPL m
where 
m.del_f = '0'
/*%if ownerCd != null && ownerCd != ""  */
   and m.OWNER_CD = /*ownerCd*/'4309'
/*%end */
/*%if keyword != null && keyword != "" */
   and m.FRAGMENT_TPL_CONTENT like /*@contain(keyword)*/'%%'
/*%end */
/*%if fragmentTplTypeCd != null && fragmentTplTypeCd != "" */
   and m.FRAGMENT_TPL_TYPE_CD = /*fragmentTplTypeCd*/'aa'
/*%end */
order by m.CRT_TIME desc