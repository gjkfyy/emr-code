select count(*) 
from MR_TPL 
where 
 ORG_CD = /*orgCode*/'SZLH' 
 and del_f != 1
  and NM = /*name */'g'
         	/*%if code != null */
	 and mr_tpl_cd !=   /*code*/'149'
		/*%end */
	/*%if ownDeptCd != null */
	 and own_cd =   /*ownDeptCd*/'149'
	/*%end */	
