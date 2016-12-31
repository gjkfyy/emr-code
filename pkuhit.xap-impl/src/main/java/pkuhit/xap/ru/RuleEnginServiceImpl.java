package pkuhit.xap.ru;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.util.Clone;
import xap.ru.engin.item.Item;
import xap.ru.engin.item.build.RuleItemBuilder;
import xap.sv.component.LifeCycleComponent;
import xap.sv.util.Ordered;

public class RuleEnginServiceImpl implements RuleEnginService,LifeCycleComponent, Ordered {
	
	@Autowired
	RuleItemBuilder ruleItemBuilder;
	
	public List<Item<Object>> list ;
	
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		URL location = null;
		location = this.getClass().getResource(
		        "/qa.auto.item.xml");
//		location = ClassLoader.getSystemResource("qa.auto.item.xml");
		List<Item<Object>> list = ruleItemBuilder.resolve(location);
		setList(list);
	}

	@Override
	public void onDestory() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Item<Object>> getList() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		List<Item<Object>> cloneList = new ArrayList<Item<Object>>();
		cloneList = (List<Item<Object>>) Clone.clone(list, 4);
		return cloneList;
	}

	public synchronized void setList(List<Item<Object>> list) {
		this.list = list;
	}


}
