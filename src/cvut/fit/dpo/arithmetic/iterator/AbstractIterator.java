package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.EmptyOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;

public abstract class AbstractIterator implements Iterator<ExpressionElement> {
	
	protected AbstractIterator innerIterator;
	protected BinaryOperator operator;
	protected boolean hasNext;
	
	public AbstractIterator(BinaryOperator operator) {
		this.operator = operator;
		this.hasNext = true;
		this.innerIterator = null;
	}
	
	protected Number number(Object operand) {
		return new Number(((NumericOperand)operand).getValue());
	}
	
	public boolean hasNext() {
		return this.hasNext;
	}
	
	protected ExpressionElement operation(BinaryOperator operator) {
		return operator.getExpression();
	}
	
	@Override
	public ExpressionElement next() {
		
		if (this.operator instanceof EmptyOperator) {
			// empty operator has only the left element;
			this.hasNext = false;
			return number(this.operator.getFirstOperand());
		}
		
		if (this.innerIterator != null && this.innerIterator.hasNext()) {
			return this.innerIterator.next();
		}
		
		return this.protectedNext();
		
	}
	
	protected abstract ExpressionElement protectedNext();
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
