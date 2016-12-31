package pkuhit.xap.ru;

import java.lang.reflect.InvocationTargetException;
import java.util.List;



public interface RuleEnginService{
	public List<?> getList() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException;

}
