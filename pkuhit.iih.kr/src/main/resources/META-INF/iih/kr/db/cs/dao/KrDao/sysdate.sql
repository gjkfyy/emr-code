select systimestamp,
       to_char(systimestamp, 'yyyy-mm-dd hh24:mi:ss.ff3') as systsStr,
       to_char(systimestamp, 'yyyy-mm-dd hh24:mi:ss') as sysdateStr
  from dual;