package cvut.fit.dpo.arithmetic.iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.Operand;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

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
			Operand firstOperand = operator.getFirstOperand();
			this.innerIterator = firstOperand.postOrderIterator();
			return this.innerIterator.next();
			
		case RIGHT_OPERAND:
			nextState = State.OPERATOR;
			Operand secondOperand = operator.getSecondOperand(); 
			this.innerIterator = secondOperand.postOrderIterator();
			return this.innerIterator.next();
			
		case OPERATOR:
			this.hasNext = false;
			return operator.getExpression();
		default:
			break;
		}
		// in theory unreachable code
		return null;
	}

}
