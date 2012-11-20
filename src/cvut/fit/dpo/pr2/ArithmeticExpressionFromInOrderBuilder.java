package cvut.fit.dpo.pr2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ArithmeticExpressionFromInOrderBuilder extends
		ArithmeticExpressionBuilder {
	
	Stack<Object> stack = new Stack<Object>();
	Queue<Object> queue = new LinkedList<Object>();
		
	public ArithmeticExpressionFromInOrderBuilder() {
		super();
	}

	@Override
	public void buildExpression() {
		while(!stack.isEmpty()) {
			this.queue.add(stack.pop());
		}
		String s = "";
		while(!this.queue.isEmpty()) {
			s += (String) queue.remove();
		}			
		
		ArithmeticExpressionFromRPNBuilder builder = new ArithmeticExpressionFromRPNBuilder();
		Director director = new Director(builder, s);
		director.build();
		this.expression = builder.getResult();
	}

	@Override
	public void buildPlus() {
		this.stack.add("+");		
	}

	@Override
	public void buildMinus() {
		this.stack.add("-");			
	}

	@Override
	public void buildDigit(char ch) {
		String number = Character.toString(ch);
		queue.add(number);
	}

	@Override
	public void buildBracket(String bracket) {
		if(bracket.equals(")"))  this.queue.add(stack.pop());	
	}

}
