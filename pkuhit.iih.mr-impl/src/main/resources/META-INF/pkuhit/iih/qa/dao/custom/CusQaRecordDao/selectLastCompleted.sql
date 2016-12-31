select 
	QA_PK,
	EXEC_END_TIME,
	EXEC_USER_ID,
	EXEC_DEPT_CD 
	from
	(
		select 
			qa.QA_PK,
			qa.EXEC_END_TIME,
			qa.EXEC_USER_ID,
			qa.EXEC_DEPT_CD,
			row_number() over (order by qa.EXEC_END_TIME desc) rn
				from QA qa
				where qa.CMPL_F=1
        		and qa.EXEC_END_TIME is not null
				/*%if enPk != null && enPk != "" */
				and qa.EN_PK=/*enPk*/'a'
  				/*%end */
				/*%if qaTypeCode != null && qaTypeCode != "" */
				and qa.QA_TY_CD=/*qaTypeCode*/'a'
  				/*%end */
				and qa.DEL_F=0
	)
	where rn=1
