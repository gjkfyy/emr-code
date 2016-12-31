select c.ca_sn
  from ca_data c
 where 1=1
 /*%if mrPk != null && mrPk != "" */
and c.data_id=/*mrPk*/'a'
/*%end */