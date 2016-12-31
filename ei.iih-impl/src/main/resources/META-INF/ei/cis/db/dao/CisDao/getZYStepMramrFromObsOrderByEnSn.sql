SELECT  *
  FROM VW_EN_STEP_ZY  
 WHERE 1=1
      /*%if enPk != null */
 		AND  EN_PK = /*enPk*/838535 
     /*%end */
     /*%if statusCode != null && statusCode != "" */
 		AND status_code = /*statusCode*/'1' 
     /*%end */
    /*%if orderType != null  && orderType != ""*/
   		AND order_type =  /* orderType */'3' 
    /*%end */
   	/*%if execUnit != null   && execUnit != ""*/
 	  AND exec_unit =  /* execUnit */'4302'
   	/*%end */
	/*%if oderStartTime != null && oderStartTime != ""*/
	 and CONVERT(varchar(100),  resp_time, 20)  >= /*oderStartTime*/'2013-12-30 11:44:24'
	/*%end */
	/*%if orderEndTime != null  && orderEndTime != "" */
	 and CONVERT(varchar(100),  resp_time, 20)  <= /*orderEndTime*/'2013-12-30 11:44:24' 
	/*%end */
