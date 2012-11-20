package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

/**
 * Represents the Binary operations like + - etc.
 * 
 * @author Jan Kurš
 *
 */
public abstract class BinaryOperator implements Operand {
	private Operand firstOperand;
	private Operand secondOperand;

	protected abstract Integer evaluate(Integer val1, Integer val2);
	
	public BinaryOperator(Operand firstOperand, Operand secondOperand)
	{
		setFirstOperand(firstOperand);
		setSecondOperand(secondOperand);
	}
	
	void setFirstOperand(Operand o)
	{
		firstOperand = o;
	}
	void setSecondOperand(Operand o)
	{
		secondOperand = o;
	}
	
	public Operand getFirstOperand()
	{
		return firstOperand;
	}
	
	public Operand getSecondOperand()
	{
		return secondOperand;
	}
	
	public Integer evaluate()
	{
		int val1 = firstOperand.getValue();
		int val2 = secondOperand.getValue();
		
		return evaluate(val1, val2);
	}
	
	public Integer getValue() {
		return this.evaluate();
	}
	
	public InOrderIterator inOrderIterator()
	{
		return new InOrderIterator(this);
	}

	public PostOrderIterator postOrderIterator()
	{
		return new PostOrderIterator(this);
	}
	
}
