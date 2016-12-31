select is_use_ca
from auth_user u
where u.sys_id = 'CIS'
/*%if userId != null */
AND  u.user_id = /*userId*/'16170' 
/*%end */
