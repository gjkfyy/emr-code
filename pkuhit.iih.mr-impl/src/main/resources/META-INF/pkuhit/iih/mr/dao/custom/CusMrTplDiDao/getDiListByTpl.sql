select 
MR_TPL_DI_CD,
MR_TPL_CD ,
DI_CD 
from MR_TPL_DI 
where DEL_F = 0
     	/*%if mrTemplateCode != null */
and	 MR_TPL_CD =   /*mrTemplateCode*/'1.01'
		/*%end */