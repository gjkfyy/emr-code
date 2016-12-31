select count(*) 
from MR_BASE_TPL 
where 

del_f != 1
  and NM = /*name */'g'
       	/*%if code != null */
	 and mr_base_tpl_cd !=   /*code*/'149'
		/*%end */