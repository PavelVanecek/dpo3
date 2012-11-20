package cvut.fit.dpo.arithmetic.iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.Operand;
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
			Operand firstOperand = operator.getFirstOperand();
			this.innerIterator = firstOperand.inOrderIterator();
			return this.innerIterator.next();
			
		case OPERATOR:
			this.nextState = State.RIGHT_OPERAND;
			return operator.getExpression();
			
		case RIGHT_OPERAND:
			this.nextState = State.RIGHT_BRACKET;
			Operand secondOperand = operator.getSecondOperand();
			this.innerIterator = secondOperand.inOrderIterator();
			return this.innerIterator.next();
			
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
