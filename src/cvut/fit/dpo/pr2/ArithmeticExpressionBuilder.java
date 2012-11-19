package cvut.fit.dpo.pr2;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;

 abstract public class ArithmeticExpressionBuilder {
	 protected ArithmeticExpression expression;
	 protected String buildString;
	 
	 public ArithmeticExpressionBuilder(String string) {
		 this.buildString = string;
		 this.expression = new ArithmeticExpression();
	 }
	 
	 public ArithmeticExpression getResult() {
		 return this.expression;
	 }
	 
	 abstract public void buildExpression();
}
