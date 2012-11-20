package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;
import cvut.fit.dpo.arithmetic.elements.SubstractOperation;


/**
 * Represents - operation
 * 
 * @author Jan Kurš
 */
public class SubstractOperator extends BinaryOperator
{

	public SubstractOperator(Operand firstOperand, Operand secondOperand)
	{
		super(firstOperand, secondOperand);
	}

	@Override
	public ExpressionElement getExpression() {
		return new SubstractOperation();
	}

	@Override
	public Integer getValue() {
		return getFirstOperand().getValue() - getSecondOperand().getValue();
	}

}
