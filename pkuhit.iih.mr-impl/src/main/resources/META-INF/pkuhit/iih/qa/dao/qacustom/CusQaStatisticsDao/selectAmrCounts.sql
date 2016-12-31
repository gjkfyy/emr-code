select NM,DEPT_CD ,
       max(case AMRRANKNM when '甲' then AMRNUM ELSE 0 end) as firLevel,
       max(case AMRRANKNM when '乙' then AMRNUM ELSE 0 end) as secdLevel,
       max(case AMRRANKNM when '丙' then AMRNUM ELSE 0 end) as thrdLevel,
       max(case AMRRANKNM when null then AMRNUM ELSE 0 end) as nullLevel
       from (

       select amrNum,amrRankNm,wd.nm,wd.DEPT_CD from (
       select count(*) as amrNum,amr_rank_cd,amrRankNm ,deptnm,dept_cd from
       (
              select m.en_pk,m.cur_dept_cd,wd.nm as deptNm,wd.dept_cd,m.amr_rank_cd,mg.gs_cd,mg.nm as amrRankNm from mr_amr m,ward_dept wd,md_gs mg where m.cur_dept_cd = wd.dept_cd and m.amr_rank_cd = mg.gs_cd
       ) a group by a.amr_rank_cd,a.amrRankNm,a.deptnm,a.dept_cd) b
       right join ward_dept wd  on wd.dept_cd = b.dept_cd ) group by NM,DEPT_CD