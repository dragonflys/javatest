package edu.xidian.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private double balance;// 余额
	private final double CAPACITY = 1000.0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public Account(double balance) {
		this.balance = balance;
	}

	// 只有先获取资源的锁的线程才能执行，而其他的线程只能在锁池中等待正在执行的线程执行完成
	public void output(double outputAmount) {
		lock.lock();
		try {
			while (outputAmount > balance) {
				System.out.println("余额不足！取款失败");
				try {
					condition.await();// await方法，只有拥有锁的线程才能执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName() + "取钱" + outputAmount);
			balance -= outputAmount;
			System.out.println("余额为 " + balance);
			condition.signalAll();// 唤醒在该资源上等待的所有线程
		} finally {
			lock.unlock();
		}

	}

	public void input(double inputAmount) {
		lock.lock();
		try {
			while (inputAmount + balance > CAPACITY) {
				System.out.println("超出账户的容量，存款失败！");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " 存款" + inputAmount);
			balance += inputAmount;
			System.out.println("余额为 " + balance);
			condition.signalAll();
		} finally {
			lock.unlock();
		}

	}

}
