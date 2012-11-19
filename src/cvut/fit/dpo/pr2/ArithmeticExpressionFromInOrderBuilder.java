package cvut.fit.dpo.pr2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ArithmeticExpressionFromInOrderBuilder extends
		ArithmeticExpressionBuilder {
	
	Stack<Object> stack = new Stack<Object>();
	Queue<Object> queue = new LinkedList<Object>();
	
	public ArithmeticExpressionFromInOrderBuilder(String string) {
		super(string);
	}

	@Override
	public void buildExpression() {
		if(this.buildString.length() == 0) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < this.buildString.length(); i++) {
			char ch = this.buildString.charAt(i);
			if(Character.isDigit(ch)) {
				String number = Character.toString(ch);
				queue.add(number);
			} else {
				String operator = Character.toString(ch);
				if(operator.equals("+") || operator.equals("-")) {
					this.stack.add(operator);
				} else if(operator.equals(")")) {
					this.queue.add(stack.pop());
				}
			}
			
		}
		
		while(!stack.isEmpty()) {
			this.queue.add(stack.pop());
		}
		String s = "";
		while(!this.queue.isEmpty()) {
			s += (String) queue.remove();
		}
		
		ArithmeticExpressionFromRPNBuilder builder = new ArithmeticExpressionFromRPNBuilder(s);
		builder.buildExpression();
		
		this.expression = builder.getResult();
	}

}
