package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 
 * @author wangyanlong
 *
 */
public class InvocationHandlerImp implements InvocationHandler{
	private Target target;
	
	public InvocationHandlerImp(Target target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("delete")) {
			System.out.println("删除前执行的方法！！！！");
			Object result = method.invoke(target, args);
			return result;
		}else {
			method.invoke(target, args);
			System.out.println("修改成功");
			return null;
		}
		
		
		
		
	}

}
