package ei.iih.db.cfg;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AssOrMzBeforAdvice implements MethodBeforeAdvice 
{
    /**
     * 构造器
     */
    public AssOrMzBeforAdvice() {
        // TODO Auto-generated constructor stub
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method
     * , java.lang.Object[], java.lang.Object)
     */
    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATASOURCE_ASS_OR_MZ);
//      System.out.println("------------------- 设置数据源"
//              + CustomerContextHolder.getCustomerType());

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
