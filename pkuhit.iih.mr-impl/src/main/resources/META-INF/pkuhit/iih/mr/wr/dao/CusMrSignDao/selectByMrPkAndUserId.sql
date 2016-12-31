select *
  from mr_sign m
 where m.del_f = '0'
   and m.mr_pk = /*mrPk*/'a'
   and m.sign_user_id = /*userId*/'a'
