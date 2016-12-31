select t.mr_tp_cd ,  t.nm 
,MR_SIGN_LVL_CD 
 from MD_MR_TP t ,MD_MR_TP_CCAT a, MD_MR_TP_CCAT_ITM i
 where t.mr_tp_cd=i.mr_tp_cd and a.mr_tp_ccat_cd=i.mr_tp_ccat_cd 
 /*%if typeCodeList != null  && typeCodeList.size() > 0 */
  and t.mr_tp_cd in /*typeCodeList*/('MRM06.03' )
/*%end */  
  /*%if keyWord != null*/
 and t.nm like /* @contain(keyWord) */'%入%'
 /*%end */
 /*%if dctNsF != null */
 and a.DCT_NS_F = /*dctNsF*/1
/*%end */
group by t.mr_tp_cd ,  t.nm ,MR_SIGN_LVL_CD
