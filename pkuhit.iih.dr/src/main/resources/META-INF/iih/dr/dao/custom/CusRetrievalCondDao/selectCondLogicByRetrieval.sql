select 
	c.COND_CD,
	c.COND_NAME,
	c.REL_TYPE,
	c.COND_TYPE,
	c.VAL_NAME,
	c.GRADE,
	c.UPCOND,
	c.VAL_CODE, 
	c.LOGIC, 
	r.COND_TEXT,
	r.EN_PK,
  	r.MR_PK,
	case when c.logic='like' 
       then case when r.cond_text like '%'||c.val_code||'%' then 'true' else 'false' end 
    when c.logic='in' 
       then case when r.cond_text in (c.val_code) then 'true' else 'false' end 
    when c.logic='='
       then case when r.cond_text = c.val_code then 'true' else 'false' end
    when c.logic='>'
       then case when r.cond_text > c.val_code then 'true' else 'false' end
    when c.logic='<'
       then case when r.cond_text < c.val_code then 'true' else 'false' end
    when c.logic='>='
       then case when r.cond_text >= c.val_code then 'true' else 'false' end
    when c.logic='<='
       then case when r.cond_text <= c.val_code then 'true' else 'false' end
    when c.logic='!='
       then case when r.cond_text != c.val_code then 'true' else 'false' end
    end  RESULTVALUE
from IEMR_RETRIEVAL_COND c
left join IEMR_RETRIEVAL_RESULT r on r.COND_CD=c.COND_CD
where
  c.DEL_F = 0
  /*%if retrievalCd != null && retrievalCd != "" */
  and r.RETRIEVAL_CD = /* retrievalCd */'a'
  /*%end */
  /*%if enPk != null && enPk != "" */
  and r.EN_PK = /* enPk */'a'
  /*%end */
  order by c.COND_NO
