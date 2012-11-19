package cvut.fit.dpo.arithmetic;

import cvut.fit.dpo.arithmetic.iterator.InOrderIterator;
import cvut.fit.dpo.arithmetic.iterator.PostOrderIterator;

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
	public InOrderIterator getInOrderIterator()
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
	public PostOrderIterator getPostOrderIterator()
	{
		return this.root.postOrderIterator();
	}

}
