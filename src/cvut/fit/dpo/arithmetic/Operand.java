package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public interface Operand {
	
	public Integer getValue();
	public ExpressionElement getExpression();
	public Iterator<ExpressionElement> inOrderIterator();
	public Iterator<ExpressionElement> postOrderIterator();

}
