select case max(CAST(data_element_cd AS INTEGER))
         when null then
          0
         else
           max(CAST(data_element_cd AS INTEGER))
       end newsn
  from MD_META_ELEMENT
 where regexp_instr(data_element_cd, '[1-9][0-9]*$') != 0