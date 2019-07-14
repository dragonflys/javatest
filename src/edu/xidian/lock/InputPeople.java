package edu.xidian.lock;

public class InputPeople extends Thread {
	private Account account;
	private double inputAmount;

	public InputPeople(String name, Account account, double inputAmount) {
		super(name);
		this.account = account;
		this.inputAmount = inputAmount;
	}

	@Override
	public void run() {
		account.input(inputAmount);
	}
}
