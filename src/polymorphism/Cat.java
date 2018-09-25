package polymorphism;

public class Cat extends Animal implements Ianimal{
	public String name = "毛毛";

	@Override
	public String getName() {
//		System.out.println(super.getName());
		return "猫";
	}
	
	public String zhuaLaoshu(){
		return "抓老鼠";
	}
	
	public static void main(String[] args) {
		Cat cat1 = new Cat();
		System.out.println(cat1.name);			//毛毛
		System.out.println(cat1.getName());		//猫
		System.out.println("&&&&&&&&&&&&");
		Animal ss = new Cat();					//只有method具有多态特性  1.继承 2.重写 3.父类引用指向子类对象
		System.out.println(ss.name);			//动物  field不存在多态
		System.out.println(ss.getName());		//猫
		System.out.println("************");
		Cat ss1 = (Cat) ss;						//强制向下转型（前提是该对象本来就是子类型才可以向下转型）
		System.out.println(ss1.name);			//毛毛
		System.out.println(ss1.getName());		//猫
		System.out.println(ss1.zhuaLaoshu());
		System.out.println("############");
		Animal aa = cat1;						//向上转型（父类引用指向子类对象）
		System.out.println(aa.name);			//动物
		System.out.println(aa.getName());		//猫  多态
	}

	

}
