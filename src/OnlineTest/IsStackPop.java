package OnlineTest;

import java.util.Stack;

public class IsStackPop {
	public boolean isStackPop(int[] push, int[] pop) {
		if (push == null || pop == null) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		for (int i = 0; i < push.length; i++) {
			stack.push(push[i]);

			while (!stack.isEmpty() && stack.peek() == pop[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.isEmpty();
	}
}
