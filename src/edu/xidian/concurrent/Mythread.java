package edu.xidian.concurrent;

public class Mythread extends Thread {
	private int i;// 每次创建一个新线程都必须创建一个新的MyThread实例，MyThread实例之间相互独立，i是实例属性，实线程例之间不能共享

	@Override
	public synchronized void run() {// 这里就算使用synchronized()也不影响，因为每个线程实例之间没有共享同一资源，每个线程各自访问自己的MyThread实例

		for (; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		Mythread thread1 = new Mythread();
		Mythread thread2 = new Mythread();
		thread1.start();
		thread2.start();
	}

}
