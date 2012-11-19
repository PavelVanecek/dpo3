package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;

public abstract class AbstractIterator implements Iterator<ExpressionElement> {
	
	protected AbstractIterator innerIterator = null;
	protected BinaryOperator operator;
	
	public AbstractIterator(BinaryOperator operator) {
		this.operator = operator;
	}
	
	protected Number number(Object operand) {
		return new Number(((NumericOperand)operand).getValue());
	}
	
	protected ExpressionElement operation(BinaryOperator operator) {
		return operator.getExpression();
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
