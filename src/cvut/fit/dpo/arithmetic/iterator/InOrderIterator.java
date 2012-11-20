package cvut.fit.dpo.arithmetic.iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.elements.CloseBracketOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.OpenBracketOperation;

public class InOrderIterator extends AbstractIterator {

	private enum State {
		LEFT_BRACKET, 
		LEFT_OPERAND, 
		OPERATOR, 
		RIGHT_OPERAND, 
		RIGHT_BRACKET
	}

	/**
	 * Remembers, which ExpressionElement must be printed next
	 * 
	 * @author vanecpav
	 * 
	 */
	private State nextState;
	
	public InOrderIterator(BinaryOperator operator) {
		super(operator);
		this.nextState = State.LEFT_BRACKET;
	}

	@Override
	protected ExpressionElement protectedNext() {
		
		switch (this.nextState) {
		
		case LEFT_BRACKET:
			this.nextState = State.LEFT_OPERAND;
			return new OpenBracketOperation();
			
		case LEFT_OPERAND:
			this.nextState = State.OPERATOR;
			Object firstOperand = operator.getFirstOperand();
			if (firstOperand instanceof BinaryOperator) {
				this.innerIterator = ((BinaryOperator) firstOperand).inOrderIterator();
				return this.innerIterator.next();
			}
			return this.number(firstOperand);
			
		case OPERATOR:
			this.nextState = State.RIGHT_OPERAND;
			return this.operation(operator);
			
		case RIGHT_OPERAND:
			this.nextState = State.RIGHT_BRACKET;
			Object secondOperand = operator.getSecondOperand();
			if (secondOperand instanceof BinaryOperator) {
				this.innerIterator = ((BinaryOperator) secondOperand).inOrderIterator();
				return this.innerIterator.next();
			}
			return this.number(secondOperand);
			
		case RIGHT_BRACKET:
			this.hasNext = false;
			return new CloseBracketOperation();
			
		default:
			break;
		}
		// this code shall never be reached
		return null;
	}

}
