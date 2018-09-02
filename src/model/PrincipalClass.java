package model;

import numericSystem.OperationError;
import numericSystem.RationalNumber;

public class PrincipalClass {
	
	public PrincipalClass() {
		
	}
	
	public RationalNumber<Number> addRational(Number n1, Number d1, Number n2, Number d2) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		RationalNumber<Number> b = new RationalNumber<Number>(n2, d2);
		a.addRational(b);
		return a;
	}
	
	public RationalNumber<Number> substractRational(Number n1, Number d1, Number n2, Number d2) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		RationalNumber<Number> b = new RationalNumber<Number>(n2, d2);
		a.substractRational(b);
		return a;
	}
	
	public RationalNumber<Number> multiplyRational(Number n1, Number d1, Number n2, Number d2) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		RationalNumber<Number> b = new RationalNumber<Number>(n2, d2);
		a.multiplyRational(b);
		return a;
	}
	
	public RationalNumber<Number> divideRational(Number n1, Number d1, Number n2, Number d2) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		RationalNumber<Number> b = new RationalNumber<Number>(n2, d2);
		a.divideRational(b);
		return a;
	}
	
	public RationalNumber<Number> simplifyRational(Number n1, Number d1) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		a.simplifyRational();
		return a;
	}
	
	public RationalNumber<Number> rationalInverse(Number n1, Number d1) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		a.rationalInverse();
		return a;
	}
	
	public RationalNumber<Number> squaredRational(Number n1, Number d1) throws OperationError {
		RationalNumber<Number> a = new RationalNumber<Number>(n1, d1);
		a.squaredRational();
		return a;
	}
}
