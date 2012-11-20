package cvut.fit.dpo.arithmetic.iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;

public class PostOrderIterator extends AbstractIterator {
	
	private enum State {
		LEFT_OPERAND,
		RIGHT_OPERAND,
		OPERATOR
	}
	
	private State nextState;
	
	public PostOrderIterator(BinaryOperator operator) {
		super(operator);
		this.nextState = State.LEFT_OPERAND;
	}

	@Override
	public ExpressionElement protectedNext()	{
		
		switch (this.nextState) {
		
		case LEFT_OPERAND:
			nextState = State.RIGHT_OPERAND;			
			Object firstOperand = operator.getFirstOperand();
			if (firstOperand instanceof BinaryOperator) {
				this.innerIterator = ((BinaryOperator) firstOperand).postOrderIterator();
				return this.innerIterator.next();
			}
			// now, return the left again
			return this.number(firstOperand);
			
		case RIGHT_OPERAND:
			nextState = State.OPERATOR;
			Object secondOperand = operator.getSecondOperand(); 
			if (secondOperand instanceof BinaryOperator) {
				this.innerIterator = ((BinaryOperator) secondOperand).postOrderIterator();
				return this.innerIterator.next();
			}
			return new Number(((NumericOperand) secondOperand).getValue());
			
		case OPERATOR:
			this.hasNext = false;
			return operation(operator);
		default:
			break;
		}
		// in theory unreachable code
		return null;
	}

}
