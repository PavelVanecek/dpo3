package cvut.fit.dpo.pr2;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;

/**
 * Stupid class which can create some {@link ArithmeticExpression}s.
 * 
 * @author Jan Kurš
 *
 */
public class ArithmeticExpressionCreator
{
	
	/**
	 * Creates 3 - (1 + 2)
	 * 
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression1()
	{
		String input = "3 - (1 + 2)";
		
		ArithmeticExpressionFromInOrderBuilder concretebuilder = new ArithmeticExpressionFromInOrderBuilder();
		Director director = new Director(concretebuilder, input);
		director.build();		
		return concretebuilder.getResult();
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
		ArithmeticExpressionFromInOrderBuilder concretebuilder = new ArithmeticExpressionFromInOrderBuilder();
		Director director = new Director(concretebuilder, input);
		director.build();		
		return concretebuilder.getResult();
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
		ArithmeticExpressionFromRPNBuilder concretebuilder = new ArithmeticExpressionFromRPNBuilder();
		Director director = new Director(concretebuilder, input);
		director.build();		
		return concretebuilder.getResult();
	}
}
