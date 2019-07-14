package edu.xidian.concurrent;

public class Test {
	public static void main(String[] args) {
		System.out.println("main thread run");
		Thread1 target1 = new Thread1("thread1");// target1虽然是一个线程实例，但是其并没有启动，所以处于非活动状态
		Thread th1 = new Thread(target1, "th1");// 将线程trget1对象中的run()交由线程th1实例进行调用
		th1.start();
		th1.interrupt();// 中断th1线程

		Thread1 target2 = new Thread1("thread2");
		Thread th2 = new Thread(target2, "th2");
		th2.start();
		th2.interrupt();// 中断th2线程
		System.out.println("main thread end");
	}
}
