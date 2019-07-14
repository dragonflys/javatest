package edu.xidian.synchronizeee;

public class OutputMoneyThread extends Thread {
	private Account account;
	private double outputAmount;

	public OutputMoneyThread(String name, Account account, double outputAmount) {
		super(name);
		this.account = account;
		this.outputAmount = outputAmount;
	}

	@Override
	public void run() {
		account.output(outputAmount);
	}
}
