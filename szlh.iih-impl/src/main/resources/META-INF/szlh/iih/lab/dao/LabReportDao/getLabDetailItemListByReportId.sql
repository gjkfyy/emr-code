select 
MR_LAB_RP_ITM_PK mrLabRpItmPk,
LAB_RP_PK labRpPk,
LAB_ITM_CD labItmCd,
LAB_ITM_NM labItmNm,
LAB_ITM_VAL labItmVal,
MAX_NRML_VAL maxNrmlVal,
MIN_NRML_VAL minNrmlVal,
LAB_ITM_UNIT_CD labItmUnitCd,
LAB_ITM_UNIT_NM labItmUnitNm,
REFERENCE_RANGE referRange
from VW_LAB_RP_ITM
where 
LAB_RP_PK =/* labRpPk */39