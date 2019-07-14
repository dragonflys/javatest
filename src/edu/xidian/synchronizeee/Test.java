package edu.xidian.synchronizeee;

public class Test {
	public static void main(String[] args) {
		Account account = new Account(0);
		new InputMoneyThread("#存款者1#", account, 100).start();
		new InputMoneyThread("#存款者2#", account, 100).start();
		new InputMoneyThread("#存款者3#", account, 100).start();
		new InputMoneyThread("#存款者4#", account, 100).start();
		new InputMoneyThread("#存款者5#", account, 100).start();
		new InputMoneyThread("#存款者6#", account, 100).start();
		new InputMoneyThread("#存款者7#", account, 100).start();
		new OutputMoneyThread("取款者甲", account, 100).start();
		new OutputMoneyThread("取款者乙", account, 100).start();
		new OutputMoneyThread("取款者丙", account, 100).start();
		new OutputMoneyThread("取款者丁", account, 100).start();
		new OutputMoneyThread("取款者一", account, 100).start();
		new OutputMoneyThread("取款者二", account, 100).start();
		new OutputMoneyThread("取款者三", account, 100).start();
	}
}
