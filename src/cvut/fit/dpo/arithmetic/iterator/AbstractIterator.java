package cvut.fit.dpo.arithmetic.iterator;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;
import cvut.fit.dpo.arithmetic.elements.AddOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.Number;
import cvut.fit.dpo.arithmetic.elements.SubstractOperation;

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
		
		if (operator instanceof AddOperator) {
			return new AddOperation();
		}
		if (operator instanceof SubstractOperator) {
			return new SubstractOperation();
		}

		// EmptyOperator or unrecognized element
		// if (element instanceof EmptyOperator)
		return new ExpressionElement() {

			@Override
			public String stringValue() {
				return "";
			}
		};

	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
