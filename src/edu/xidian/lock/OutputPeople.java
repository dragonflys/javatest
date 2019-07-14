package edu.xidian.lock;

public class OutputPeople extends Thread {
	private Account account;
	private double outputAmount;

	public OutputPeople(String name, Account account, double outputAmount) {
		super(name);
		this.account = account;
		this.outputAmount = outputAmount;
	}

	@Override
	public void run() {
		account.output(outputAmount);
	}
}
