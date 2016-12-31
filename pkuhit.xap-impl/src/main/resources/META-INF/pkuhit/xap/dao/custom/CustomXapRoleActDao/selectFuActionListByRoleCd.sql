select mfa.* from xap_role_act xra,xap_role_fu xrf, me_fu_act mfa 
       where xra.role_fu_cd = xrf.role_fu_cd 
             and xra.fu_act_cd = mfa.fu_act_cd
             and xrf.role_cd = /* roleCd */'a'
			 and del_f = 0
