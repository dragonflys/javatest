package edu.xidian.concurrent;

public class Thread1 extends Thread {

	public Thread1(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " run begin");

		System.out.println(this.getName() + " 线程是否为活动状态" + this.isAlive());
		System.out.println(this.getName() + " 线程是否为中断状态" + this.isInterrupted());
		System.out.println("当前" + Thread.currentThread().getName() + "线程是否为活动状态" + Thread.currentThread().isAlive());
		System.out.println("当前" + Thread.currentThread().getName() + "线程是否为中断状态" + Thread.interrupted());

		System.out.println(Thread.currentThread().getName() + " run end");
	}
}
