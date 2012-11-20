package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;


public class EmptyOperator extends BinaryOperator {

	public EmptyOperator(Operand firstOperand, Operand secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	protected Integer evaluate(Integer val1, Integer val2) {
		return val1;
	}

	@Override
	public Integer getValue() {
		return this.getFirstOperand().getValue();
	}

	@Override
	public ExpressionElement getExpression() {
		return new Number(getValue());
	}

}
