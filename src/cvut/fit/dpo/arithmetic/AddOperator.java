package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.elements.AddOperation;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

/**
 * Represents + operation
 * 
 * @author Jan Kurš
 * 
 */
public class AddOperator extends BinaryOperator
{

	public AddOperator(Object firstOperand, Object secondOperand)
	{
		super(firstOperand, secondOperand);
	}

	@Override
	protected Integer evaluate(Integer val1, Integer val2)
	{
		return val1 + val2;
	}

	@Override
	public ExpressionElement getExpression() {
		return new AddOperation();
	}

}
