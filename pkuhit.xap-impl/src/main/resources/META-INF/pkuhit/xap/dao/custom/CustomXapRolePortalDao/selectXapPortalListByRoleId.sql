select xp.*
	from XAP_ROLE_PORTAL xrp,Xap_Portal xp 
	where xrp.portal_cd = xp.portal_cd 
	and xrp.role_cd = /* roleCd */'a'
	and del_f = 0
