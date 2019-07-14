package edu.xidian.proxy;

public class Target implements Service {

	@Override
	public void update() {
		System.out.println("修改信息操作。。。。");
	}

	@Override
	public void delete() {
		System.out.println("执行删除操作。。。");
	}

}
