select * 
from MR_GE 
where 
  del_f != 1
/*%if orgCode != null*/
  and ORG_CD = /*orgCode*/'SZLH'
/*%end */
/*%if rootCode != null*/
  and rt_mr_eg_cd = /*rootCode*/'MRM06.03'
/*%end */  
order by crt_time  desc, rt_mr_eg_cd 