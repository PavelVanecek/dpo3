package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public abstract class AbstractIterator implements Iterator<ExpressionElement> {
	
	protected Iterator<ExpressionElement> innerIterator;
	protected BinaryOperator operator;
	protected boolean hasNext;
	
	public AbstractIterator(BinaryOperator operator) {
		this.operator = operator;
		this.hasNext = true;
		this.innerIterator = null;
	}
	
	public boolean hasNext() {
		return this.hasNext;
	}
	
	@Override
	public ExpressionElement next() {
		
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
