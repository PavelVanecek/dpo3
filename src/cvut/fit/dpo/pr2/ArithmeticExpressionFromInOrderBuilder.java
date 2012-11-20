package cvut.fit.dpo.pr2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ArithmeticExpressionFromInOrderBuilder extends
		ArithmeticExpressionBuilder {
	
	Stack<Object> stack = new Stack<Object>();
	Queue<Object> queue = new LinkedList<Object>();
	
	ArithmeticExpressionFromRPNBuilder builder;
	
	public ArithmeticExpressionFromInOrderBuilder(String string) {
		super(string);
	}

	@Override
	public void buildExpression() {
		this.parse();		
		while(!stack.isEmpty()) {
			this.queue.add(stack.pop());
		}
		String s = "";
		while(!this.queue.isEmpty()) {
			s += (String) queue.remove();
		}	
		
		builder = new ArithmeticExpressionFromRPNBuilder(s);
		builder.buildExpression();
		
		this.expression = builder.getResult();
	}

	@Override
	protected void buildPlus() {
		this.stack.add("+");		
	}

	@Override
	protected void buildMinus() {
		this.stack.add("-");			
	}

	@Override
	protected void buildDigit(char ch) {
		String number = Character.toString(ch);
		queue.add(number);
	}

	@Override
	protected void buildBracket(String bracket) {
		if(bracket.equals(")"))  this.queue.add(stack.pop());	
	}

}
