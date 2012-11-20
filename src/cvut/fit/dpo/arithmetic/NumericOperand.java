package cvut.fit.dpo.arithmetic;

import java.util.Iterator;
import cvut.fit.dpo.arithmetic.elements.Number;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.iterator.SingleValueIterator;

/**
 * Represents number in the arithmetic expression
 * 
 * @author Jan Kurš
 */
public class NumericOperand implements Operand {
	private Integer value;
	
	public NumericOperand(Integer value)
	{
		setValue(value);
	}
	
	public Integer getValue()
	{
		return value;
	}
	
	public void setValue(Integer value)
	{
		this.value = value;
	}
	
	public Iterator<ExpressionElement> inOrderIterator()
	{
		return new SingleValueIterator(this.getValue());
	}

	public Iterator<ExpressionElement> postOrderIterator()
	{
		return new SingleValueIterator(this.getValue());
	}

	@Override
	public ExpressionElement getExpression() {
		return new Number(this.getValue());
	}
	
}
