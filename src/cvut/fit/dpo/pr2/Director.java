package cvut.fit.dpo.pr2;

public class Director {
	ArithmeticExpressionBuilder builder;
	String buildString;

	public Director(ArithmeticExpressionBuilder concreteBuilder, String stringToBuild) {
		this.builder = concreteBuilder;
		this.buildString = stringToBuild;
	}
	
	public void build() {
		 if(this.buildString.length() == 0) {
				throw new IllegalArgumentException();
		 }
		 
		 for(int i = 0; i < this.buildString.length(); i++) {
				char ch = this.buildString.charAt(i);
				if(Character.isDigit(ch)) {
					builder.buildDigit(ch);
				} else {
					String operator = Character.toString(ch);					
					if(operator.equals("+")) {
						builder.buildPlus();
					} else if(operator.equals("-")) {
						builder.buildMinus();
					} else if (operator.equals("(") || operator.equals(")")) {
						builder.buildBracket(operator);
					} else if(operator.equals(" ")){ 
						continue;
					} else {
						throw new IllegalArgumentException();
					}
					
				}
		 }
		 
		 builder.buildExpression();
	 }

}
