select
DEPT_SN deptSn,
WARD_SN wardSn,
WARD_NM wardNm,
ORDER_START_TIME orderStartTime,
ORDER_DAYS orderDays,
KF_START_TIME kfStartTime,
KF_DAYS kfDays,
FKF_START_TIME fkfStartTime,
FKF_DAYS fkfDays,
FEE_ORDER_SN feeOrderSn,
BASE_GROUP baseGroup,
WZ_GROUP_LIST wzGroupList,
INFUSION_FLAG infusionFlag,
IP_LIST ipList,
ENABLE_FLAG enableFlag,
OWE_LIMIT oweLimit,
LONG_ORDER_WIDTH longOrderWidth,
ONCE_ORDER_WIDTH onceOrderWidth,
AUTO_BUILD autoBuild,
INFUSION_FLAG2 infusionFlag2
from VW_NIS_WARD_CONFIG 
--where IP_LIST like /*@contain(ip)*/'%ip%'