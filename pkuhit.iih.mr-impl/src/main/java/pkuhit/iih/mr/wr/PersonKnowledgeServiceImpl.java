package pkuhit.iih.mr.wr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrFragmentTplDao;
import pkuhit.iih.mr.dao.auto.MrFragmentTplTypeDao;
import pkuhit.iih.mr.dao.auto.entity.MrFragmentTpl;
import pkuhit.iih.mr.dao.auto.entity.MrFragmentTplType;
import pkuhit.iih.mr.wr.dao.CusMrFragmentTplDao;
import pkuhit.iih.mr.wr.dao.CusMrFragmentTplTypeDao;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

public class PersonKnowledgeServiceImpl implements PersonKnowledgeService {

	private static Logger log = LoggerFactory.getLogger(PersonKnowledgeServiceImpl.class);
	
	@Autowired
	CusMrFragmentTplDao cusMrFragmentTplDao;
	
	@Autowired
	MrFragmentTplDao mrFragmentTplDao;
	
	@Autowired
	CusMrFragmentTplTypeDao cusMrFragmentTplTypeDao;
	
	@Autowired
    MrFragmentTplTypeDao mrFragmentTplTypeDao;
	
	@Override
	public SingleResult<MrFragment> create(MrFragment value) throws Throwable {
	    SingleResult<MrFragment> result;
        // 补全数据
	    MrFragmentTpl tpl = new MrFragmentTpl();
        BeanCopyUtil.modelToEntity(tpl, value);
        tpl.setFragmentTplCd(UUIDGenerator.getUUID());
        // 保存到个人知识库表
        mrFragmentTplDao.insert(tpl);
        // 查询最新的医疗记录
        result = this.searchById(tpl.getFragmentTplCd());
        return result;
	}

	@Override
	public SingleResult<MrFragment> delete(String id) throws Throwable {
	    SingleResult<MrFragment> result;
	    //删除
	    MrFragmentTpl tpl = new MrFragmentTpl();
	    tpl.setFragmentTplCd(id);
        mrFragmentTplDao.delete(tpl);
        result = this.searchById(tpl.getFragmentTplCd());
        return result;
	}

	@Override
	public SingleResult<MrFragment> update(MrFragment value) throws Throwable {
	    SingleResult<MrFragment> result;
        //更新
        MrFragmentTpl tpl = mrFragmentTplDao.selectById(value.getFragmentTplCd());
        if(tpl!=null){
            BeanCopyUtil.modelToEntity(tpl, value);
        }
        mrFragmentTplDao.updateExcludeNull(tpl);
        result = this.searchById(tpl.getFragmentTplCd());
        return result;
	}
	
	@Override
	public ArrayResult<MrFragment> search(Map<String, Object> condition) throws Throwable {
	    ArrayResult<MrFragment> result = null;
        ArrayResultBuilder<MrFragment> build = ArrayResultBuilder.newArrayResult(MrFragment.class);
        String userId = (String) condition.get("userId");
        String deptCd = (String) condition.get("deptCd");
        String personal = (String) condition.get("personal");
        String dept = (String) condition.get("dept");
        String inName = (String) condition.get("inName");
        String keyword = (String) condition.get("keyword");
        
        String ownerTypeCd ="";
        if(personal!=null&&dept!=null){
            ownerTypeCd = "all";
        }else if(personal!=null&&dept==null){
            ownerTypeCd = personal;
        }else if(dept!=null&&personal==null){
            ownerTypeCd = dept;
        }else{
            ownerTypeCd = "none";
        }
        
        List<Map<String, Object>> fragmentList = cusMrFragmentTplDao.selectMrFragmentTpl(userId,deptCd,ownerTypeCd,inName,keyword);
        MrFragment[] mrTpls = new MrFragment[fragmentList.size()];
        for (int i = 0; i < fragmentList.size(); i++) {
            MrFragment mrTpl = new MrFragment();
            Map<String, Object> map = fragmentList.get(i);
            BeanCopyUtil.mapToModel(mrTpl, map);
            mrTpls[i] = mrTpl;
        }
        if (mrTpls.length > 0) {
            build.withData(mrTpls);
        }
        result = build.build();
        result.setTotal(mrTpls.length);
        return result;
	}

	@Override
	public SingleResult<MrFragment> searchById(String id) throws Throwable {
        SingleResult<MrFragment> result;
        SingleResultBuilder<MrFragment> builder = SingleResultBuilder.newSingleResult(MrFragment.class);
        Map<String, Object> map = cusMrFragmentTplDao.selectById(id);
        MrFragment mrFragment = new MrFragment();
        if(map!=null){
            BeanCopyUtil.mapToModel(mrFragment, map);
        }
        builder.withData(mrFragment);
        result = builder.build();
        return result;
	}

    @Override
    public ArrayResult<MrFragmentType> searchType(Map<String, String> condition) throws Throwable
    {
        ArrayResult<MrFragmentType> result = null;
        ArrayResultBuilder<MrFragmentType> build = ArrayResultBuilder.newArrayResult(MrFragmentType.class);
        String userId = (String) condition.get("userId");
        List<Map<String, Object>> typeList = cusMrFragmentTplTypeDao.selectMrFragmentTplType(userId);
        MrFragmentType[] types = new MrFragmentType[typeList.size()];
        for (int i = 0; i < typeList.size(); i++) {
            MrFragmentType type = new MrFragmentType();
            Map<String, Object> map = typeList.get(i);
            BeanCopyUtil.mapToModel(type, map);
            types[i] = type;
        }
        if (types.length > 0) {
            build.withData(types);
        }
        result = build.build();
        result.setTotal(types.length);
        return result;
    }

    @Override
    public void updateAndAddType(Map<String, Object> condition) throws Throwable
    {
        //保存新增和修改数据
        List<Map<String, String>> typeList = (List<Map<String, String>>)condition.get("updateData");
        if(typeList!=null){
            for(int i=0;i<typeList.size();i++){
                String typeCd = typeList.get(i).get("fragmentTplTypeCd");
                String typeNm = typeList.get(i).get("fragmentTplTypeNm");
                if("".equals(typeCd)){
                    //补全数据
                    MrFragmentTplType tpltype = new MrFragmentTplType();
                    tpltype.setFragmentTplTypeCd(UUIDGenerator.getUUID());
                    tpltype.setFragmentTplTypeNm(typeNm);
                    //保存到个人知识库表
                    mrFragmentTplTypeDao.insert(tpltype);
                }else{
                    MrFragmentTplType tpltype = mrFragmentTplTypeDao.selectById(typeCd);
                    if(tpltype!=null){
                        tpltype.setFragmentTplTypeNm(typeNm);
                    }
                    mrFragmentTplTypeDao.updateExcludeNull(tpltype);
                }
            }
        }
        //保存删除数据
        List<Map<String, String>> deleteList = (List<Map<String, String>>)condition.get("deleteData");
        if(deleteList!=null){
            for(int i=0;i<deleteList.size();i++){
                String typeCd = deleteList.get(i).get("fragmentTplTypeCd");
                MrFragmentTplType tplType = new MrFragmentTplType();
                tplType.setFragmentTplTypeCd(typeCd);
                mrFragmentTplTypeDao.delete(tplType);
            }
        }
    }

    @Override
    public void deleteType(String id) throws Throwable
    {
        //删除
        MrFragmentTplType tplType = new MrFragmentTplType();
        tplType.setFragmentTplTypeCd(id);
        mrFragmentTplTypeDao.delete(tplType);
    }
    
    @Override
	public SingleResult<Map<String,Object>> searchTree(Map<String, String> condition) {
    	SingleResult<Map<String,Object>> result = new SingleResult<Map<String,Object>>();
        String keyword = (String) condition.get("keyword");
        
		// 返回结果map
		Map<String,Object> mapResult = new HashMap<String,Object>();
		mapResult.put("text", "root");
		
		Session session = Session.get();
		//科室和个人2个树节点
		String userId = session.getUserId(),deptId = session.getDeptId(),userNm = "个人",deptNm = "科室";
		
		List<Map<String,Object>> firstChild = new ArrayList<Map<String,Object>>();
		Map<String,Object> mfirstChild = null;
		
		mfirstChild = new HashMap<String,Object>();
		mfirstChild.put("id", deptId);
		mfirstChild.put("text", deptNm);
		mfirstChild.put("content", "content_"+deptNm);
		
		List<Map<String,Object>> mSecondMaps = new ArrayList<Map<String,Object>>(),mThirdMaps = null;
		//科室的类型
		List<Map<String, Object>> deptList = cusMrFragmentTplTypeDao.selectMrFragmentTplAllType();
		//个人的类型
		List<Map<String, Object>> typeList = cusMrFragmentTplTypeDao.selectMrFragmentTplType(userId);
		Map<String,Object> secondMap = null,thirdMap = null;
		String fragmentTplTypeCd = null,fragmentTplTypeNm=null,fragmentTplCd=null,fragmentTplNm=null,fragmentTplContent=null;
		List<Map<String, Object>> knowledgeList = null;
		
		if (null != deptList && deptList.size() > 0) {
			for (int i = 0; i < deptList.size(); i++) {
				fragmentTplTypeCd = (String)deptList.get(i).get("FRAGMENT_TPL_TYPE_CD");
				fragmentTplTypeNm = (String)deptList.get(i).get("FRAGMENT_TPL_TYPE_NM");
				
				knowledgeList = cusMrFragmentTplDao.selectMrFragmentTplByCondition(deptId, keyword, fragmentTplTypeCd);
				mThirdMaps = new ArrayList<Map<String,Object>>();
				if(null != knowledgeList && knowledgeList.size() > 0){
					//判断该类型下是否有数据
					secondMap = new HashMap<String,Object>();
					secondMap.put("id","dept_"+fragmentTplTypeCd);
					secondMap.put("text",fragmentTplTypeNm);
					secondMap.put("content","content_"+fragmentTplTypeNm);
					for (int j = 0; j < knowledgeList.size(); j++) {
						thirdMap = new HashMap<String,Object>();
						fragmentTplCd = (String)knowledgeList.get(j).get("FRAGMENT_TPL_CD");
						fragmentTplNm = (String)knowledgeList.get(j).get("FRAGMENT_TPL_NM");
						fragmentTplContent = (String)knowledgeList.get(j).get("FRAGMENT_TPL_CONTENT");
						thirdMap.put("id", fragmentTplCd);
						thirdMap.put("text",fragmentTplNm);
						thirdMap.put("content",fragmentTplContent);
						thirdMap.put("leaf",true);
						mThirdMaps.add(thirdMap);
					}
					secondMap.put("children", mThirdMaps);
					mSecondMaps.add(secondMap);
				}/*else{
					secondMap.put("leaf", true);
				}*/
			}
			mfirstChild.put("children", mSecondMaps);
		}/*else{
			mfirstChild.put("leaf", true);
		}*/
		firstChild.add(mfirstChild);
		
		mfirstChild = new HashMap<String,Object>();
		mfirstChild.put("id", userId);
		mfirstChild.put("text", userNm);
		mfirstChild.put("content", "content_"+userNm);
		List<Map<String,Object>> mUserSecondMaps = new ArrayList<Map<String,Object>>(),mUserThirdMaps = null;
		if (null != typeList && typeList.size() > 0) {
			for (int i = 0; i < typeList.size(); i++) {
				fragmentTplTypeCd = (String)typeList.get(i).get("FRAGMENT_TPL_TYPE_CD");
				fragmentTplTypeNm = (String)typeList.get(i).get("FRAGMENT_TPL_TYPE_NM");
				
				knowledgeList = cusMrFragmentTplDao.selectMrFragmentTplByCondition(userId, keyword, fragmentTplTypeCd);
				mUserThirdMaps = new ArrayList<Map<String,Object>>();
				if(null != knowledgeList && knowledgeList.size() > 0){
					secondMap = new HashMap<String,Object>();
					secondMap.put("id","user_"+fragmentTplTypeCd);
					secondMap.put("text",fragmentTplTypeNm);
					secondMap.put("content","content_"+fragmentTplTypeNm);
					for (int j = 0; j < knowledgeList.size(); j++) {
						thirdMap = new HashMap<String,Object>();
						fragmentTplCd = (String)knowledgeList.get(j).get("FRAGMENT_TPL_CD");
						fragmentTplNm = (String)knowledgeList.get(j).get("FRAGMENT_TPL_NM");
						fragmentTplContent = (String)knowledgeList.get(j).get("FRAGMENT_TPL_CONTENT");
						thirdMap.put("id", fragmentTplCd);
						thirdMap.put("text",fragmentTplNm);
						thirdMap.put("content",fragmentTplContent);
						thirdMap.put("leaf", true);
						mUserThirdMaps.add(thirdMap);
					}
					secondMap.put("children", mUserThirdMaps);
					mUserSecondMaps.add(secondMap);
				}/*else{
					secondMap.put("leaf", true);
				}*/
			}
			mfirstChild.put("children", mUserSecondMaps);
		}/*else{
			mfirstChild.put("leaf", true);
		}*/
		firstChild.add(mfirstChild);
		
		mapResult.put("children",firstChild );

		result.setData(mapResult);
		return result;
	}
    
    
    

}
