package edu.xidian.concurrent;

/**
 * 
 * @author wangyanlong
 *
 */
public class TargetRunnable implements Runnable {
	private int i = 0;// 多线程之间可以共享target类的实例属性，因为创建线程对象时传入同一个target实例，
	// 所以多个线程都会执行该target实例的run()，实现线程共享同一个target实例

	@Override
	public synchronized void run() {

		for (; i < 10; i++) {// i++是非原子操作，如果出现多线程同时访问，就会出现线程不安全问题
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		TargetRunnable target = new TargetRunnable();
		Thread thread1 = new Thread(target);
		Thread thread2 = new Thread(target);
		thread1.start();
		thread2.start();

	}
}
