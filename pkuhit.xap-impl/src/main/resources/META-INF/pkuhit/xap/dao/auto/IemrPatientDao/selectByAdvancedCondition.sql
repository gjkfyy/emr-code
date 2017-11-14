select  distinct p.* from iemr_patient p  
left join  mr on  p.inpatient_no = mr.en_pk
left join   iemr_xml on iemr_xml.file_pk = mr.file_pk
left join xap_bizfile on  xap_bizfile.file_pk = mr.file_pk
where 1=1 
/*%if patientName != null */
 and  p.patient_name like /*@contain(patientName)*/'%g%'
/*%end */ 
 /*%if ring != null */
 and  p.ring like /*@contain(ring)*/'%g%'
/*%end */ 
 /*%if treatmentPlan != null */
 and  p.treatment_plan like /*@contain(treatmentPlan)*/'%g%'
/*%end */ 
 /*%if combined != null */
 and  p.combined like /*@contain(combined)*/'%g%'
/*%end */ 
/*%if admissionDateStart != null */ 
 and p.admission_date >= to_date(/*admissionDateStart*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
/*%end */ 
/*%if admissionDateEnd != null */ 
 and p.admission_date <= to_date(/*admissionDateEnd*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
/*%end */ 
 /*%if inpatientNoStart != null */ 
 and p.inpatient_no > /*inpatientNoStart*/'12'
/*%end */ 
 /*%if inpatientNoEnd != null */ 
 and p.inpatient_no < /*inpatientNoEnd*/'100'
/*%end */ 
 /*%if sex != null */ 
 and p.sex = /*sex*/'0'
/*%end */ 
 /*%if birthdayEnd != null */ 
 and p.age >= sysdate - to_date(/*birthdayEnd*/'2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
/*%end */ 
 /*%if birthdayStart != null */ 
 and p.age <= sysdate - to_date(/*birthdayStart*/'2015-01-05 00:00:00','yyyy-mm-dd hh24:mi:ss') 
/*%end */ 
 /*%if tel != null */ 
 and p.tel = '110'
/*%end */ 
 /*%if age != null */ 
 and p.age like /* @contain(age) */'%g%'
/*%end */ 
 /*%if address != null */ 
 and p.adress like /* @contain(address) */'%g%'
/*%end */ 
 /*%if diagnosis != null */ 
 and p.diagnosis like /* @contain(diagnosis) */'%g%'
 /*%end */ 
 
 /*%if itemValuesList != null   && itemValuesList.size() > 0 */  
  and (
  /*%for condition : itemValuesList */
    (iemr_xml.iemr_key = substr(/*condition*/'MR.M.013.D.3|36',0,INSTR(/*condition*/'MR.M.013.D.3|36','|')-1) and iemr_xml.iemr_value like
   	 CASE WHEN
   	 substr(/*condition*/'MR.M.013.D.3|36',INSTR(/*condition*/'MR.M.013.D.3|36','|')+1)='*' THEN iemr_xml.iemr_value
   	 ELSE 
   	 substr(/*condition*/'MR.M.013.D.3|36',INSTR(/*condition*/'MR.M.013.D.3|36','|')+1)
   	 END
    )
    /*%if condition_has_next */
  /*# "or" */
    /*%end */
/*%end*/
    )
  /*%end*/

 and p.del_f = 0
