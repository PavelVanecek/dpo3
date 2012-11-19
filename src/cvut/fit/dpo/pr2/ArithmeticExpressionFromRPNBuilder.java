package cvut.fit.dpo.pr2;

import java.util.Stack;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.EmptyOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;

public class ArithmeticExpressionFromRPNBuilder extends ArithmeticExpressionBuilder{
	Stack<Object> stack = new Stack<Object>();
	
	public ArithmeticExpressionFromRPNBuilder(String input) {
		super(input);
	}

	@Override
	public void buildExpression() {
		if(this.buildString.length() == 0) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < this.buildString.length(); i++) {
			char ch = this.buildString.charAt(i);
			if(Character.isDigit(ch)) {
				NumericOperand operand = new NumericOperand(Character.getNumericValue(ch));
				this.stack.push(operand);
			} else {
				String operator = Character.toString(ch);
				if(operator.equals("+")) {
					Object op1 = this.stack.pop();
					Object op2 = this.stack.pop();
					
					AddOperator addOperator = new AddOperator(op2, op1);
					this.stack.push(addOperator);
				} else if(operator.equals("-")) {
					Object op1 = this.stack.pop();
					Object op2 = this.stack.pop();
					
					SubstractOperator subtractOperator = new SubstractOperator(op2,op1);
					this.stack.push(subtractOperator);
				} else if(!operator.equals(" ")){
					throw new IllegalArgumentException();
				}
				
			}
		}
		Object operator = this.stack.pop();
		if(operator instanceof BinaryOperator) {
			this.expression.setRoot((BinaryOperator) operator);
		} else {
			BinaryOperator op = new EmptyOperator(operator, new NumericOperand(0));
			this.expression.setRoot(op);
		}
		
	}

}