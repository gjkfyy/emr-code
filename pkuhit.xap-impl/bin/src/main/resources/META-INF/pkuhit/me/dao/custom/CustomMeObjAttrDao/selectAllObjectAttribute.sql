select a.* from ME_OBJ_ATTR a
  left join ME_OBJ b 
  on a.obj_cd = b.obj_cd
where
  a.del_f = 0
/*%if keyword != null && keyword != "" */
  and a.NM like /* @contain(keyword) */'%g%'
/*%end */
/*%if type != null && type == "1" */
  and a.mr_use_f = 1 
/*%end */  
/*%if type != null && type == "2" */
  and a.mr_use_f = 0
/*%end */  
order by 
  b.obj_cd,
  a.nm