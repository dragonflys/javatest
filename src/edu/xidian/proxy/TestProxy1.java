package edu.xidian.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
/**
 * 1 代理类实现代理接口的方法中，只是简单的调用了InvocationHandler的invoke方法，
 * 我们可以在invoke方法中进行一些特殊操作，甚至不调用实现的方法，直接返回。
 * 2 代理类实现了目标类的所有接口并继承了Proxy类，由于java仅支持单继承，
 * 不能再继承其他的类，所以JDK的动态代理不支持对实现类的代理，只支持接口的代理。
 * 3 重写了Object类的equals()、hashCode()、toString()，
 * 它们都只是简单的调用了InvocationHandler的invoke方法，即可以对其进行特殊的操作，也就是说JDK的动态代理还可以代理上述三个方法
 * 4 jdk动态代理的实现过程，首先是调用Proxy类的静态方法newProxyInstanc()生成代理类的实例，
 * 怎么生成代理类实例的哪？newProxyInstance()会调用Proxy类的静态方法getProxyClass()方法生成代理类的class对象，
 * 代理类的clss对象的生成是getProxyClass()方法调用ProxyGenerator类的generateProxyClass()生成代理类的字节码，由字节码加载生成代理类的class对象
 * 
 * @author wangyanlong
 *
 */
public class TestProxy1 {

	@Test
	public void TestProxy() {
		Target target = new Target();
		InvocationHandlerImp invocationHandlerImp = new InvocationHandlerImp(target);
		Service proxy = (Service) Proxy.newProxyInstance(Target.class.getClassLoader(), Target.class.getInterfaces(),
				invocationHandlerImp);
		proxy.delete();
		proxy.update();
	}

	@Test
	public void TeatProxy2() {
		Target target = new Target();
		Service proxy = (Service) Proxy.newProxyInstance(Target.class.getClassLoader(), Target.class.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getName().equals("update")) {
							System.out.println("修改前的动作");
							return method.invoke(target, args);
						} else {
							System.out.println("除了修改方法以外的方法的操作");
							return method.invoke(target, args);
						}
					}
				});

		proxy.delete();
		System.out.println(proxy.toString());//生成的代理类重写了Object类的toString(),equals(),hashCode()它们都只是简单的调用了InvocationHandler的invoke方
		System.out.println(proxy.equals("ff"));//法，即可以对其进行特殊的操作，也就是说JDK的动态代理还可以代理上述三个方法。
		System.out.println(proxy.hashCode());
	}
	/*
	 * 函数式接口（functional interface）中只能包含一个抽象方法，但是可以包含多个default方法和类方法（接口中包含的默认方法和类方法必须有方法体）
	 * lambda表达式的目标类型必须是明确的函数式接口
	 * lambda表达式只能为函数式接口创建对象
	 */
	@Test
	public void TeatProxy3(){
		Target target = new Target();//InvocationHandler接口只有一个抽象的invoke方法，属于函数式接口
		Service proxy = (Service) Proxy.newProxyInstance(Target.class.getClassLoader(), Target.class.getInterfaces(), (Object pro, Method method, Object[] args) -> {
			if (method.getName().equals("delete")) {
				System.out.println("删除前校验");
				Object result = method.invoke(target, args);
				return result;
			}
			return method.invoke(target, args);
		});
		proxy.delete();
		proxy.update();
		
	}

}
