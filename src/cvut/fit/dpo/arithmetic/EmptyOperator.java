package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;
import cvut.fit.dpo.arithmetic.iterator.SingleValueIterator;


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
	
	/**
	 * EmptyOperator handles expressions differently
	 */
	public Iterator<ExpressionElement> inOrderIterator()
	{
		return new SingleValueIterator(getValue());
	}

	public Iterator<ExpressionElement> postOrderIterator()
	{
		return new SingleValueIterator(getValue());
	}

}
