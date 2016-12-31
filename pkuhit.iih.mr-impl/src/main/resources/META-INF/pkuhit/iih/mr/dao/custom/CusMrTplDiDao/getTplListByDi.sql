select 
MR_TPL_CD ,
DI_CD 
from MR_TPL_DI 
where  DEL_F = 0
     	/*%if diCode != null */
and	 DI_CD =   /*diCode*/'1.01'
		/*%end */