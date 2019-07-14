package edu.xidian.synchronizeee;

/**
 * 两个人对同一账户进行操作，交替进行存款取款
 * 
 * @author wangyanlong
 *
 */
public class Account {
	private double balance;// 余额
	private boolean flag;

	public Account(double balance) {
		this.balance = balance;
	}

	// synchronized方法无需显式指定同步监视器，其同步监视器是this，即调用该同步方法的对象。
	// 线程进入同步方法前必须先获取对同步监视器的锁定
	public synchronized void output(double outputAmount) {
		while (!flag) {
			try {
				this.wait();// wait方法是同步监视器的方法，使执行该同步方法的当前线程发生等待并释放对同步监视器的锁定
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "取钱" + outputAmount);
		balance = balance - outputAmount;
		System.out.println("余额为 " + balance);
		flag = false;
		notifyAll();// 唤醒在该同步监视器上等待的所有线程

	}

	public synchronized void input(double inputAmount) {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 存款" + inputAmount);
		balance = balance + inputAmount;
		System.out.println("余额为 " + balance);
		flag = true;
		notifyAll();

	}

}
