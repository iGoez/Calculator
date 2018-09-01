package numericSystem;

public interface IRationalNumber <T>{
	
	public void addRational(RationalNumber<Number> rationalToBeAdded) throws OperationError;
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted) throws OperationError;
	public void multiplyRational(RationalNumber<Number> rationalFactor) throws OperationError;
	public void divideRational(RationalNumber<Number> rationalQuocient) throws OperationError;
	public void simplifyRational() throws OperationError;
	public void rationalInverse() throws OperationError;
	public void squaredRational() throws OperationError;
	public Number getNumerator();
	public Number getDenominator();
	public String toString();
	
}
