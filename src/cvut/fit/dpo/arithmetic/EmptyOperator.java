package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;

public class EmptyOperator extends BinaryOperator {

	public EmptyOperator(Object firstOperand, Object secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	protected Integer evaluate(Integer val1, Integer val2) {
		return val1;
	}

	@Override
	public ExpressionElement getExpression() {
		return new Number((Integer) this.getFirstOperand());
	}

}
