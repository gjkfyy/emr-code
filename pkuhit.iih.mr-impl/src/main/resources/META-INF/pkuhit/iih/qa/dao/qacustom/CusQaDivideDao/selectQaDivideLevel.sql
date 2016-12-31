select  t.qa_divide_level_cd,
t.min_scr,
t.max_scr,
t.lvl
from QA_DIVIDE_LEVEL t where t.del_f = 0
order by t.qa_divide_level_cd