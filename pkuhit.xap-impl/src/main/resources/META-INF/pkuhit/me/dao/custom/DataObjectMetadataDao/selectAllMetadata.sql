select mo.OBJ_CD       as OBJECT_CD,
       moa.OBJ_ATTR_CD as ATTRIBUTE_CD,
       MO.TAB_NM       as TABLE_NAME,
       MOA.NM          as ATTRIBUTE_TEXT,
       moa.SHT_NM_EN   as COLUMN_NAME,
       moa.NM_EN       as ATTRIBUTE_NAME,
       moa.PK_F        as PRIMARY_KEY_FLAG,
       MO.COM_MD_F     as COMMON_MD_FLAG,
       MO.CACHE_F      as CACHE_FLAG
  from ME_OBJ mo, ME_OBJ_ATTR moa
 where mo.OBJ_CD = moa.OBJ_CD
 and mo.del_f=0
 and moa.del_f=0