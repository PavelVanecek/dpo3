package cvut.fit.dpo.pr2;
/**
 * @author povalpet
 * pattern Builder
 */
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
	 abstract protected void buildPlus();
	 abstract protected void buildMinus();
	 abstract protected void buildDigit(char ch);
	 abstract protected void buildBracket(String bracket);
	 
	 protected void parse() {
		 if(this.buildString.length() == 0) {
				throw new IllegalArgumentException();
		 }
		 
		 for(int i = 0; i < this.buildString.length(); i++) {
				char ch = this.buildString.charAt(i);
				if(Character.isDigit(ch)) {
					this.buildDigit(ch);
				} else {
					String operator = Character.toString(ch);					
					if(operator.equals("+")) {
						this.buildPlus();
					} else if(operator.equals("-")) {
						this.buildMinus();
					} else if (operator.equals("(") || operator.equals(")")) {
						this.buildBracket(operator);
					} else if(operator.equals(" ")){ 
						continue;
					} else {
						throw new IllegalArgumentException();
					}
					
				}
		 }
	 }
}
