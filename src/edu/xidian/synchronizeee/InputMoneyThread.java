package edu.xidian.synchronizeee;

public class InputMoneyThread extends Thread {
	private Account account;
	private double inputAmount;

	public InputMoneyThread(String name, Account account, double inputAmount) {
		super(name);
		this.account = account;
		this.inputAmount = inputAmount;
	}

	@Override
	public void run() {
		account.input(inputAmount);
	}
}
