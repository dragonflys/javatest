package edu.xidian.lock;

public class Test {
	public static void main(String[] args) {
		Account account = new Account(0);
		new OutputPeople("取款者甲", account, 500).start();
		new OutputPeople("取款者乙", account, 300).start();
		new OutputPeople("取款者丙", account, 100).start();
		new OutputPeople("取款者丁", account, 100).start();

		new InputPeople("#存款者1#", account, 100).start();
		new InputPeople("#存款者2#", account, 100).start();
		new InputPeople("#存款者3#", account, 100).start();
		new InputPeople("#存款者4#", account, 200).start();
		new InputPeople("#存款者5#", account, 100).start();
		new InputPeople("#存款者6#", account, 500).start();
		new InputPeople("#存款者7#", account, 100).start();

	}
}
