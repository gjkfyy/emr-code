select
  CA_SN,
  EMP_ID,
  EN_PK,
  DATA_ID,
  DATA_SN,
  DATA_XML,
  CERT_ID,
  CERT_VALUE,
  CA_DATA,
  TS_DATA,
  CREATE_TIME,
  SYS_CODE,
  MODULE,
  CA_STATE
from
  CA_DATA
where
  CA_SN = /* caSn */'a'
and del_f = 0
