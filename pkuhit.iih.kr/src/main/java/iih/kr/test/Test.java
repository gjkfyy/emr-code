package iih.kr.test;

import iih.kr.db.cs.dao.KrDao;
import iih.kr.db.cs.entity.DiSuiteModelEntity;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		ApplicationContext app = new FileSystemXmlApplicationContext("src/main/resources/iih.kr.context.xml");
		
/*		KrDao dao = (KrDao)app.getBean("krDaoImpl");
		List<DiSuiteModelEntity> l = new ArrayList();;//dao.selectKrEntities("keshi", "keshi1", "00");
		System.out.println(l.size());*/
		
//		TutorialService service = new TutorialService();
//		EmployeeService1 service2 = (EmployeeService1) app.getBean("employeeService");
//		Employee e = new Employee();
//		e.setId(2);
//		e.setName("test");
//		e.setVersion(2);
//		service2.update(e);
	}

}
