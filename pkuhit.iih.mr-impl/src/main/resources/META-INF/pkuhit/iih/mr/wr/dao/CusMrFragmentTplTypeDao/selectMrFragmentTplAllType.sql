select 
t.fragment_tpl_type_cd, 
t.fragment_tpl_type_nm

from mr_fragment_tpl_type t
where t.DEL_F = '0'
order by t.CRT_TIME desc