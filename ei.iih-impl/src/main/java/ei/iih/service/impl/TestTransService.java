
package ei.iih.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ei.iih.db.dao.auto.entity.MdDi;
import ei.iih.db.dao.custom.MdDiDao;



@Service
public class TestTransService {

	@Autowired
	MdDiDao mdDiDao;

	/**
	 * 构造器
	 */
	public TestTransService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void test() {
		List<MdDi> testIemr = mdDiDao.selectMdDi();
		System.out.println("iemr=======================size is "+testIemr.size());
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
