select case max(CAST(value_code AS INTEGER))
         when null then
          0
         else
           max(CAST(value_code AS INTEGER))
       end newsn
  from MD_META_ELEMENT_VALUE
 where del_f != 1
 /*%if dataElementCd != null && dataElementCd != "" */
	and DATA_ELEMENT_CD = /*dataElementCd*/'184'
/*%end */