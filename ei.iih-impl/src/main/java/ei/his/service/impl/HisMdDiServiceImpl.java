package ei.his.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ei.his.db.dao.HisMdDiDao;
import ei.his.db.dao.auto.entity.HisMdDi;


@Service
public class HisMdDiServiceImpl implements HisMdDiService {

	@Autowired
	private HisMdDiDao dao;

	/**
	 * 构造器
	 */
	public HisMdDiServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<HisMdDi> selectHisDiags() {
		List<HisMdDi> test = dao.selectHisMdDi();
		// TODO Auto-generated method stub
		return test;
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
