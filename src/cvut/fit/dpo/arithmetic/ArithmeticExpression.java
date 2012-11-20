package cvut.fit.dpo.arithmetic;

import java.util.Iterator;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class ArithmeticExpression
{
	private BinaryOperator root;
	
	public Integer evaluate()
	{
		return root.evaluate();
	}
	
	public void setRoot(BinaryOperator root)
	{
		this.root = root;
	}

	/**
	 * {@link #root} field getter.
	 * 
	 * @deprecated Do not provide access to the inner representation
	 */
	public BinaryOperator getRoot()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Should be implemented.
	 * 
	 * @return Iterator<ExpressionElement>
	 */
	public Iterator<ExpressionElement> getInOrderIterator()
	{
		return this.root.inOrderIterator();
	}

	/**
	 * Should be implemented
	 * 
	 * TODO
	 * 
	 * @return
	 */
	public Iterator<ExpressionElement> getPostOrderIterator()
	{
		return this.root.postOrderIterator();
	}

}
