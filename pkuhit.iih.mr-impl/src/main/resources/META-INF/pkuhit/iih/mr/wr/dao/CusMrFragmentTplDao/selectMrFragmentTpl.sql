select 
  m.fragment_tpl_cd,
  m.fragment_tpl_content,
  m.fragment_tpl_type_cd,
  (select md.nm from md_gs md where md.gs_cd = m.owner_type_cd) owner_type_cd,
  m.owner_cd,
  (select t.fragment_tpl_type_nm from mr_fragment_tpl_type t where t.fragment_tpl_type_cd = m.fragment_tpl_type_cd) fragment_tpl_type_nm,
  m.fragment_tpl_nm,
  m.crt_user_id
from mr_fragment_tpl m
where 
m.del_f = '0'
/*%if ownerTypeCd == "all" */
   and ((m.owner_type_cd = 'MDM12.02' and m.owner_cd = /*deptCd*/'4309')
    or (m.owner_type_cd = 'MDM12.03' and m.owner_cd = /*userId*/'004910'))
/*%end */
/*%if ownerTypeCd == "dept" */
   and (m.owner_type_cd = 'MDM12.02' and m.owner_cd = /*deptCd*/'4309')
/*%end */
/*%if ownerTypeCd == "personal" */
   and (m.owner_type_cd = 'MDM12.03' and m.owner_cd = /*userId*/'004910')
/*%end */
/*%if ownerTypeCd == "none" */
   and 1=2
/*%end */
/*%if inName != null && inName != "" */
   and (m.fragment_tpl_nm like /*@contain(inName)*/'%%' or lower(m.spell_no) like  /*@contain(inName)*/'%%' or upper(m.spell_no) like  /*@contain(inName)*/'%%')
/*%end */
/*%if keyword != null && keyword != "" */
   and m.FRAGMENT_TPL_CONTENT like /*@contain(keyword)*/'%%'
/*%end */
order by m.crt_time desc