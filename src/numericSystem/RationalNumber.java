package numericSystem;

public class RationalNumber<T extends Number> implements IRationalNumber<T> {

	private T numerator;
	private T denominator;

	public RationalNumber(T numerator, T denominator) {
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
		this.numerator = multiply(numerator, (T) rationalFactor.getNumerator());
		this.denominator = multiply(denominator, (T) rationalFactor.getDenominator());
		simplifyRational();
	}

	private T multiply(T n1, T n2) {
		T number = null;

		if (n1 instanceof Long || n2 instanceof Long) {
			number = (T) Long.valueOf(n1.longValue() * n2.longValue());
		} else if (n1 instanceof Short || n2 instanceof Short) {
			number = (T) Short.valueOf((short) (n1.shortValue() * n2.shortValue()));
		} else {
			number = (T) Integer.valueOf(n1.intValue() * n2.intValue());
		}
		return number;
	}

	@Override
	public void divideRational(RationalNumber<Number> rationalQuocient) {
		this.numerator = multiply(numerator, (T) rationalQuocient.getDenominator());
		this.denominator = multiply(denominator, (T) rationalQuocient.getNumerator());
		simplifyRational();
	}
	
	private T divide(T n1, T n2) {
		T number = null;

		if (n1 instanceof Long || n2 instanceof Long) {
			number = (T) Long.valueOf(n1.longValue() * n2.longValue());
		} else if (n1 instanceof Short || n2 instanceof Short) {
			number = (T) Short.valueOf((short) (n1.shortValue() * n2.shortValue()));
		} else {
			number = (T) Integer.valueOf(n1.intValue() * n2.intValue());
		}
		return number;
	}

	@Override
	public void simplifyRational() {
		T simplify = mcd();
		
		if (numerator instanceof Long || denominator instanceof Long) {
			numerator = (T)Long.valueOf(numerator.longValue() / simplify.longValue());
			denominator = (T)Long.valueOf(denominator.longValue() / simplify.longValue());
		} else if (numerator instanceof Short || denominator instanceof Short) {
			numerator = (T)Short.valueOf((short) (numerator.shortValue() / simplify.shortValue()));
			denominator = (T)Short.valueOf((short) (denominator.shortValue() / simplify.shortValue()));
		} else {
			numerator = (T)Integer.valueOf(numerator.intValue() / simplify.intValue());
			denominator = (T)Integer.valueOf(denominator.intValue() / simplify.intValue());
		}
	}

	private T mcd() {
		T u = null;
		T d = null;
		T aux = null;
		
		if (numerator instanceof Long || denominator instanceof Long) {
			u = (T) Long.valueOf(Math.abs(numerator.longValue()));
			d = (T) Long.valueOf(Math.abs(denominator.longValue()));
			while (d.longValue() != 0) {
				aux = (T) Long.valueOf(u.longValue() % d.longValue());
				u = d;
				d = aux;
			}
		} else if (numerator instanceof Short || denominator instanceof Short) {
			u = (T) Short.valueOf((short) Math.abs(numerator.shortValue()));
			d = (T) Short.valueOf((short) Math.abs(denominator.shortValue()));
			while (d.longValue() != 0) {
				aux = (T) Short.valueOf((short) (u.shortValue() % d.shortValue()));
				u = d;
				d = aux;
			}
		} else {
			u = (T) Integer.valueOf(Math.abs(numerator.intValue()));
			d = (T) Integer.valueOf(Math.abs(denominator.intValue()));
			while (d.longValue() != 0) {
				aux = (T) Integer.valueOf(u.intValue() % d.intValue());
				u = d;
				d = aux;
			}
		}
	
		return u;
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
		return this.numerator;
	}

	@Override
	public Number getDenominator() {
		// TODO Auto-generated method stub
		return this.denominator;
	}

}
