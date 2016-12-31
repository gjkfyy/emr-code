package pkuhit.xap.me;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.dao.auto.MeCdRuDao;
import pkuhit.xap.dao.auto.entity.MeCdRu;



public class MeCdRuServiceImpl implements MeCdRuService {

	
	@Autowired
	MeCdRuDao  meCdRuDao;
	
	@Override
	public synchronized MeCdRuId selectById(String id) {
		// TODO Auto-generated method stub
		MeCdRu meCdRu = new MeCdRu();
		meCdRu = meCdRuDao.selectById(id);
		MeCdRuId meCdRuId = new MeCdRuId();
		String meId =  getMeCdReId(meCdRu);
		meCdRuId.setId(meId);
		 return meCdRuId;
	}

	
	 /**
	  * 
	  * 1.特殊型1：如【功能】的编码：
      *   PKUHIT.XAP.010200
	  *   PKUHIT.IIH.MR.010000
	  *   如【服务】
	  *   XSV.MRK02.CRT
	  * 2.特殊型2：如【数据元素】
	  *    本身的“数据对象编码”+层级编码。
	  * 3.通用型：如【病历文书类型自定义分类】【病历文书类型】等知识库类的数据对象
	  *    通用的规则：
	  *    “病历文书类型自定义分类”的“数据对象编码”+层级编码。
	  * 4.自定义型：【人员】【用户】【组织机构】【诊断】【领域】编码自定义, 一般使用医院的编号或是英文简称。
      * 5.混合型：【通用主数据结构】除了使用本身的“数据对象编码”+层级编码，还有一部分是自定义的。如领域编码，直接使用XAP英文简称等
	  * 此方法只使用与 3   ，其他 todo
	  * getMeCdReId
	  * @param meCdRu
	  * @return  String
	 * @throws Exception 
	  */
	private String getMeCdReId(MeCdRu meCdRu) {
		
		String id = "";
		if(meCdRu != null){
			String objAttrCd = meCdRu.getObjAttrCd();
			int index  = objAttrCd.indexOf(".");
			if(index > 0){
				objAttrCd = objAttrCd.substring(0,index);
			} 
			String maxLvl = meCdRu.getMaxLvl();
			
			if(maxLvl != null){
				if(maxLvl.equals("1")){
				 String fstMaxCd = meCdRu.getFstMaxCd();	
				 int num = Integer.valueOf(fstMaxCd);
				 num = num+1;
				 String fstBit = meCdRu.getFstBit();
				 fstMaxCd = String.format("%0"+fstBit+"d", num); 
				// id = meCdRu.getOrgCd()+"."+objAttrCd+"."+fstMaxCd;
				 id = objAttrCd+"."+fstMaxCd;
				 meCdRu.setFstMaxCd(fstMaxCd);
				}
				if(maxLvl.equals("2")){
					 String fstMaxCd = meCdRu.getFstMaxCd();
					 String sndMaxCd = meCdRu.getSndMaxCd();
					 int first = Integer.valueOf(fstMaxCd);
					 int second = Integer.valueOf(sndMaxCd);
					 first = first+1;
					 second = second+1;
					 String fstBit = meCdRu.getFstBit();
					 String sndBit = meCdRu.getSndBit();
					 
					 fstMaxCd = String.format("%0"+fstBit+"d", first); 
					 sndMaxCd = String.format("%0"+sndBit+"d", second);
					 //id =  meCdRu.getOrgCd()+"."+objAttrCd+"."+fstMaxCd+"."+sndMaxCd;			
					 id =  objAttrCd+"."+fstMaxCd+"."+sndMaxCd;			
					 meCdRu.setFstMaxCd(fstMaxCd);	
					 meCdRu.setSndMaxCd(sndMaxCd);
				}
				if(maxLvl.equals("3")){
					 String fstMaxCd = meCdRu.getFstMaxCd();
					 String sndMaxCd = meCdRu.getSndMaxCd();
					 String threeMaxCd = meCdRu.getTrdMaxCd();
					 int first = Integer.valueOf(fstMaxCd);
					 int second = Integer.valueOf(sndMaxCd);
					 int three = Integer.valueOf(threeMaxCd);
					 first = first+1;
					 second = second+1;
					 three = three+1;
					 String fstBit = meCdRu.getFstBit();
					 String sndBit = meCdRu.getSndBit();
					 String threeBit = meCdRu.getTrdBit();
					 
					 fstMaxCd = String.format("%0"+fstBit+"d", first); 
					 sndMaxCd = String.format("%0"+sndBit+"d", second);
					 threeMaxCd = String.format("%0"+threeBit+"d", three);
					 //id =  meCdRu.getOrgCd()+"."+objAttrCd+"."+fstMaxCd+"."+sndMaxCd +"."+threeMaxCd;
					 id =  objAttrCd+"."+fstMaxCd+"."+sndMaxCd +"."+threeMaxCd;
					 meCdRu.setFstMaxCd(fstMaxCd);
					 meCdRu.setSndMaxCd(sndMaxCd);
					 meCdRu.setTrdMaxCd(threeMaxCd);
				}
				meCdRuDao.updateExcludeNull(meCdRu);
				return id;
			}	 
		}
		return null;
	}
}
