select 
hospital_code hospitalCode,				  --医院编码
hospital_name hospitalName, 			  --医院名称
room_no roomNo,							  --房间号
age,									  --年龄
rtrim(ltrim(patient_id))	patientId,
rtrim(ltrim(legal_name))	legalName,    --姓名
rtrim(ltrim(social_no))		socialNo,     --身份证号
gender						gender,       --性别编码
gender_txt					genderTxt,    --性别
marital_status_code		    maritalStatusCode,--婚姻编码
marital_txt					maritalTxt,   --婚姻
birth_time					birthTime,    --出生日期
blood_type					bloodType,    --血型
race_code 					raceCode,     --民族代码
race_name 					raceName,     --民族
citizen_code 				citizenCode,  --国籍编码
citizen_name 				citizenName,  --国籍
birth_place 				birthPlace,   --出生地编码
birth_place_name			birthPlaceName, --出生地名称
occupation_code 			occupationCode,--职业编码 
occupation_name 			occupationName,--职业
patient_address 			patientAddress,--病人现住址
address 					address,       --住址
tel_addr 					telAddr,       --联系电话
relation_name 				relationName,  --联系人姓名
relation_code               relationCode,  --联系人关系编码
relation_code_nm			relationCodeNm,--关系名称
response_type 				responseType,  --医保类型
response_name 				responseName,  --医保名称
enc_type					encType,       --就诊类型
patient_no					patientNo,     --住院号/门诊号
enc_id						encId,         --就诊号
effective_b 				effectiveB,    --入院时间
admission_responsible_party admissionResponsibleParty, --入院科室编码
admiss_ward 				admissWard,	   --入院病区编码
admitter 					admitter,      --入院医生 
activity_b 					activityB,     --入科时间
ryzd 						ryzd,		   --入院诊断编码
ryzdmc 						ryzdmc,        --入院诊断名称
org_id 						orgId,         --科室编码
org_name 					orgName,       --科室名称
ward_code					wardCode,      --病区编码
ward 						ward,          --病区名称
bed                         bed,           --床号
attender                    attender,      --主管医生
nurser						nurser,        --主管护士
dept_director 				deptDirector,  --科室主任
activity_e                  activityE,     --出科时间
effective_e 				effectiveE,    --出院时间
discharge_responsible_party dischargeResponsibleParty,--出院科室
dis_ward                    disWard,       --出院病区
discharger                  discharger,    --出院医生
cyzd 						cyzd,          --出院诊断编码
cyzdmc 						cyzdmc,        --出院诊断名称
in_visit_times              inVisitTimes,  --住院次数
nurse_level                 nurseLevel,    --护理级别
nurse_level_name 			nurseLevelName --护理级别名称

from VW_PA_FOR_XML
where 
1=1
/*%if patientId != null && patientId != ""  */
 and patient_id = /*patientId*/'a'
/*%end */
 /*%if inVisitTimes != null && inVisitTimes != ""  */
 and in_visit_times = /*inVisitTimes*/'a'
/*%end */
 /*%if outVisitTimes != null && outVisitTimes != ""  */
 and in_visit_times = /*outVisitTimes*/'a'
/*%end */
 /*%if enPk != null && enPk != ""  */
 and enc_id = /*enPk*/'a'
/*%end */
