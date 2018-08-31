package numericSystem;

public class RationalNumber<T extends Number> implements IRationalNumber<T> {
	
	private T numerator;
	private T denominator;
	
	public RationalNumber(T numerator, T denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public void addRational(RationalNumber<Number> rationalToBeAdded) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void multiplyRational(RationalNumber<Number> rationalFactor) {
		this.numerator = multiply(numerator, (T)rationalFactor.getNumerator());
		this.denominator = divide(denominator, (T)rationalFactor.getDenominator());
	}
	private T multiply(T n1, T n2) {
		T number = null;
		
		if(n1 instanceof Long && n2 instanceof Long) {
			number = (T)Long.valueOf(n1.longValue()*n2.longValue());
		}else if(n1 instanceof Short && n2 instanceof Short) {
			number = (T)Short.valueOf((short) (n1.shortValue()*n2.shortValue()));
		}else {
			//number = n1.intValue()*n2.intValue();
		}
		
		return number;
	}
	
	private T divide(T d1, T d2) {
		T number = null;
		return null;
	}

	@Override
	public void divideRational(RationalNumber<Number> rationalQuocient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simplifyRational() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rationalInverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void squaredRational() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Number getNumerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number getDenominator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
