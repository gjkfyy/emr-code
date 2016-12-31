package pkuhit.iih.demo;

import java.lang.reflect.InvocationTargetException;

import org.springframework.transaction.annotation.Transactional;

import xap.sv.annotation.Reference;
//import xap.sv.session.SessionStorage;

public class TestServiceImpl implements TestService {
	
//	@Autowired
//	private TestTbEntityDao dao;
	
//	@Reference
//	SessionStorage ss;

	public TestServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TestModel dbget(String cd) throws IllegalAccessException,
			InvocationTargetException {
//		Session currentSession = ss.getCurrentSession();
		
//		testdb et = dao.selectById(cd);
//		TestModel tm = new TestModel();
//		BeanUtils.copyProperties(tm, et);
//		return tm;
		System.err.println(123);
		return new TestModel();
	}

	@Override
	@Transactional(rollbackFor = { TestException.class })
	public String dbadd(String cd) throws IllegalAccessException,
			InvocationTargetException, TestException {
//		TestTbEntity et = new TestTbEntity();
//		et.setPk(UUID.randomUUID().toString());
//		et.setFdFloat(new BigInteger("15"));
//		et.setFdDate(new Timestamp(System.currentTimeMillis()));
//		et.setFdInt((short) 1);
//		et.setFdStr("test");
//		dao.insertExludeNull(et);
//		// 测试事物
//		if (true) {
//			throw new TestException();
//		}
//		return et.getPk();
		System.err.println(123);
		return null;
	}

}
