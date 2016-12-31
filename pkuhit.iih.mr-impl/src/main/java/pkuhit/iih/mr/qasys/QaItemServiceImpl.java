package pkuhit.iih.mr.qasys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.dao.auto.entity.QaItm;
import pkuhit.iih.qa.dao.qacustom.CusQaItemnDao;
import pkuhit.iih.qa.old.QaNItem;
import pkuhit.iih.qa.qasys.QaSystemQaItem;
import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class QaItemServiceImpl implements QaItemService {

	@Autowired
	private CusQaItemnDao cusQaItemnDao;

	@Reference
	private DictionaryService dictionnaryService;

	public QaItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public QaSystemQaItem searchById(String id) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QaSystemQaItem> searchBy(QaSystemQaItem condition)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.qasys.QaItemService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<QaNItem> searchByCond(Map condition)
			throws Throwable {
		// 就诊编码 *
		String enTpCd = condition.get("enTpCd").toString();
		// 医疗记录类型编码*
		String mrTemplateCode = condition.get("mrTypeCode").toString();
		// 医疗记录段落类型编码
		String mrSegmentTemplateCode = null;
		if (condition.get("mrSegmemtTypeCode") != null) {
			mrSegmentTemplateCode = condition.get("mrSegmemtTypeCode")
					.toString();
		}

		//List<String> mrTpCds = getMrTpCds(mrTemplateCode);
		String itemFirst = "1";
		String itemSecond = "9";
		// 查询质控项目
		List<QaItm> searchQaSysItems = cusQaItemnDao.searchQaItem(
				itemFirst, itemSecond);
		ArrayResultBuilder<QaNItem> builder = ArrayResultBuilder
				.newArrayResult(QaNItem.class);
		int total = searchQaSysItems.size();
		if (searchQaSysItems.size() > 0) {
			QaNItem[] qaItems = new QaNItem[searchQaSysItems
					.size()];
			for (int i = 0; i < searchQaSysItems.size(); i++) {
				QaItm itm = searchQaSysItems.get(i);
				QaNItem qaItem = new QaNItem();
				// 拷贝属性
				BeanCopyUtil.entityToModel(qaItem, itm, QaSystemQaItem.OBJ_CD,
						dictionnaryService);
/*				BeanCopyUtil.entityToModel(qaItem, itm, QaSystemQaItem.OBJ_CD,
						dictionnaryService);
*/				/*// 使用字典单独为段落赋值
				SimpleItem[] sis = dictionnaryService.getSimpleItems(
						GeneralData.OBJ_CD, itm.getMrSegTpCd());*/
				/*if (sis.length != 0) {
					if (sis[0] != null) {
						qaItem.setQaSystemSegmentName(sis[0].getText());
					}
				}*/
				qaItems[i] = qaItem;
			}
			builder.withData(qaItems);
		}
		ArrayResult<QaNItem> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

/*	*//**
	 * 获取所有父病例文书类型的编码
	 *//*
	public List<String> getMrTpCds(String mrTpCd) {
		List<String> list = new ArrayList<String>();
		MdMrTp parent = cusQaItemnDao.selectParentMrTpByMrTpCd(mrTpCd);
		while (parent != null) {
			list.add(parent.getMrTpCd());
			parent = cusQaItemnDao.selectParentMrTpByMrTpCd(parent
					.getParMrTpCd());
		}
		return list;
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
