package edu.xidian.init;


/**
 *
 * 触发类初始化的5种情况：
 * 1.new创建实例对象时，操作该类的static变量或static方法时
 * 2.使用反射操作该类对应的class对象时
 * 3.初始化一个类时，如果其父类未被初始化，先触发其父类初始化
 * 4.当JVM启动时，会先初始化包含main()方法的类
 * 5.如果MethodHandler实例最后的解析结果为REF_getStatic,REF_putStatic,REF_invokeStatic的方法句柄
 *   并且这个方法句柄所对应的类没有进行初始化，则需要先触发其初始化
 *
 *
 * 类的生命周期包括7个阶段：
 * 1.加载：将class文件加载到内存
 * 2.验证：验证class文件中包含的数据符合JVM的要求，并且不会危害虚拟机的安全
 * 3.准备：为类在方法区分配内存空间，并将类的静态变量初始化为系统零值
 * 4.解析：将符号引用转换为直接引用
 * 5.初始化：执行应用程序自定义的类初始化语句
 * 6.使用
 * 7.卸载：无用的类才会被卸载，无用的类满足3条件，1，该类的所有对象都已被回收，2，该类所对应的类加载器已被回收，3，该类所对应的class对象没有在任何地方被引用
 *
 * 实例初始化
 * 先初始化父类中定义的字段，然后执行父类构造器，在初始化子类中定义的字段，再执行子类构造器
 *
 *
 *
 */
class Parent
{
    private static int ps = 1;
    private int pv = 4444;

    static
    {
        ps = 2;
        System.out.println("parent static init block   " + ps);
    }

    {
        System.out.println("parent init block   " + pv);
    }

    Parent()
    {
        System.out.println("parent constructor");
    }

}

class Child extends Parent
{
    private static int cs = 3;
    private int cv = 8;

    static
    {
        cs = 4;
        System.out.println("child static init block " + cs);
    }

    {
        System.out.println("child init block  " + cv);
    }

    Child()
    {
        System.out.println("child constructor");
    }

}

public class TestClassInit
{
    public static void main(String[] args)
    {
        new Child();
        new Child();
    }
}