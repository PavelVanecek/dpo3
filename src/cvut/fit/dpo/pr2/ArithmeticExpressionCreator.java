package cvut.fit.dpo.pr2;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.BinaryOperator;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;


/**
 * Stupid class which can create some {@link ArithmeticExpression}s.
 * 
 * @author Jan Kurš
 *
 */
public class ArithmeticExpressionCreator
{
	private ArithmeticExpressionBuilder expressionBuilder;
	
	/**
	 * Creates 3 - (1 + 2)
	 * 
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression1()
	{
		String input = "3 - (1 + 2)";
		this.expressionBuilder = new ArithmeticExpressionFromInOrderBuilder(input);
		
		this.expressionBuilder.buildExpression();
		
		return this.expressionBuilder.getResult();
	}

	/**
	 * Creates (3 - 1) + 2
	 *
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression2()
	{
		String input = "(3 - 1) + 2";
		this.expressionBuilder = new ArithmeticExpressionFromInOrderBuilder(input);
		this.expressionBuilder.buildExpression();
		
		return this.expressionBuilder.getResult();
	}
	
	/**
	 * Creates any expression from the RPN input. This is nice and
	 * 	universal. 
	 * 
	 * @see http://en.wikipedia.org/wiki/Reverse_Polish_notation
	 * 	
	 * @param input in Reverse Polish Notation
	 * @return {@link ArithmeticExpression} equivalent to the RPN input.
	 */
	public ArithmeticExpression createExpressionFromRPN(String input)
	{
		this.expressionBuilder = new ArithmeticExpressionFromRPNBuilder(input);
		this.expressionBuilder.buildExpression();
		
		return this.expressionBuilder.getResult();
	}
}
