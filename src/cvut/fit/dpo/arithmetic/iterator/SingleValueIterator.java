package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;
import cvut.fit.dpo.arithmetic.elements.Number;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class SingleValueIterator implements Iterator<ExpressionElement> {
	
	private boolean hasNext;
	private ExpressionElement element;
	
	public SingleValueIterator(Integer value) {
		this.element = new Number(value);
		this.hasNext = true;
	}

	@Override
	public boolean hasNext() {
		return this.hasNext;
	}

	@Override
	public ExpressionElement next() {
		this.hasNext = false;
		return this.element;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
