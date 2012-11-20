package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.elements.AddOperationExpression;
import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

/**
 * Represents + operation
 * 
 * @author Jan Kurš
 * 
 */
public class AddOperator extends BinaryOperator
{

	public AddOperator(Operand firstOperand, Operand secondOperand)
	{
		super(firstOperand, secondOperand);
	}

	@Override
	public ExpressionElement getExpression() {
		return new AddOperationExpression();
	}

	@Override
	public Integer getValue() {
		return getFirstOperand().getValue() + getSecondOperand().getValue();
	}

}
