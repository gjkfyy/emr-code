select m.*
/*%if mrAmr != null && mrAmr != "" */
,am.CUR_DEPT_INTO_TIME 
,am.ill_sta_cd
/*%end */
/*%if orgEmp != null && orgEmp != "" */
,e.job_title_cd
/*%end */
from
mr m 
/*%if mrAmr != null && mrAmr != "" */
left join mr_amr am on m.en_pk = am.en_pk 
/*%end */
/*%if xapUser != null && xapUser != "" */
left join XAP_USER u on m.submit_cd = u.user_id

/*%if orgEmp != null && orgEmp != "" */
left join org_emp e on e.emp_id = u.emp_id
/*%end */
/*%end */
where m.en_pk = /*enPk*/'870013'
and m.del_f = 0
/*%if mrAmr != null && mrAmr != "" */
and (am.del_f = 0 or am.del_f is null)
/*%end */
/*%if xapUser != null && xapUser != "" */
and (u.del_f = 0 or u.del_f is null)
/*%end */
/*%if orgEmp != null && orgEmp != "" */
and (e.del_f = 0 or e.del_f is null)
/*%end */