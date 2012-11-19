package cvut.fit.dpo.arithmetic;

public class EmptyOperator extends BinaryOperator {

	public EmptyOperator(Object firstOperand, Object secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	protected Integer evaluate(Integer val1, Integer val2) {
		return val1;
	}

}
