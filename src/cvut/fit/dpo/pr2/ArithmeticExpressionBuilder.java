package cvut.fit.dpo.pr2;
/**
 * @author povalpet
 * pattern Builder
 */
import cvut.fit.dpo.arithmetic.ArithmeticExpression;

 abstract public class ArithmeticExpressionBuilder {
	 protected ArithmeticExpression expression;
	 
	 public ArithmeticExpressionBuilder() {
		 this.expression = new ArithmeticExpression();
	 }
	 
	 public ArithmeticExpression getResult() {
		 return this.expression;
	 }
	 
	 abstract public void buildExpression();
	 abstract public void buildPlus();
	 abstract public void buildMinus();
	 abstract public void buildDigit(char ch);
	 abstract public void buildBracket(String bracket);
	 
	 
}
