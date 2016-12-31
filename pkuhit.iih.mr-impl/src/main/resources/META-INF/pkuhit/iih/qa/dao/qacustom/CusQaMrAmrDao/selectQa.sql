select crt_user_id
  from (select crt_user_id, last_upd_time, en_pk, qa_ty_cd,del_f
          from qa
         order by last_upd_time desc)
 where rownum < 2
      /*%if enPk != null && enPk != "" && enPk != "undefined" */
   and EN_PK = /*enPk*/'a'
      /*%end */
      /*%if qaTypeCode != null && qaTypeCode != "" */
   and QA_TY_CD = /*qaTypeCode*/'a'
      /*%end */
   and DEL_F = 0
