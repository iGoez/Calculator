package numericSystem;

public class RationalNumber<T extends Number> implements IRationalNumber<T> {

	private T numerator;
	private T denominator;

	public RationalNumber(T numerator, T denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int verifyNumberData(T n1, T n2) {
		int value = 0;
		
		if (numerator instanceof Long || denominator instanceof Long) {
			value = 1;
		} else if (numerator instanceof Short || denominator instanceof Short) {
			value = 2;
		} else {
			value = 3;
		}
		
		return value;
	}

	@Override
	public void addRational(RationalNumber<Number> rationalToBeAdded) {
		if(denominator == rationalToBeAdded.getDenominator()) {
			if(numerator instanceof Long) {
				numerator = (T)Long.valueOf(numerator.longValue() + rationalToBeAdded.getNumerator().longValue());
			}else if(numerator instanceof Short) {
				numerator = (T)Short.valueOf((short) (numerator.shortValue() + rationalToBeAdded.getNumerator().shortValue()));
			}else {
			numerator = (T)Integer.valueOf(numerator.intValue() + rationalToBeAdded.getNumerator().intValue());
			}
		}else {
			switch (verifyNumberData(numerator, denominator)) {
			case 1:
				numerator = (T)Long.valueOf(numerator.longValue()*rationalToBeAdded.getDenominator().longValue()
											+denominator.longValue()*rationalToBeAdded.getNumerator().longValue());
				denominator = (T)Long.valueOf(denominator.longValue()*rationalToBeAdded.getDenominator().longValue());
				break;
			case 2:
				numerator = (T)Short.valueOf((short) (numerator.shortValue()*rationalToBeAdded.getDenominator().shortValue()
													+ denominator.shortValue()*rationalToBeAdded.getNumerator().shortValue()));
				denominator = (T)Short.valueOf((short)(denominator.shortValue()*rationalToBeAdded.getDenominator().shortValue()));
				
				break;
			case 3:
				numerator = (T)Integer.valueOf(numerator.intValue()*rationalToBeAdded.getDenominator().intValue()
												+denominator.intValue()*rationalToBeAdded.getNumerator().intValue());
				denominator = (T)Integer.valueOf(denominator.intValue()*rationalToBeAdded.getDenominator().intValue());
				break;
			}
		}
		simplifyRational();
	}

	@Override
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted) {
		if(denominator == rationalToBeSubstracted.getDenominator()) {
			if(numerator instanceof Long) {
				numerator = (T)Long.valueOf(numerator.longValue() - rationalToBeSubstracted.getNumerator().longValue());
			}else if(numerator instanceof Short) {
				numerator = (T)Short.valueOf((short) (numerator.shortValue() - rationalToBeSubstracted.getNumerator().shortValue()));
			}else {
			numerator = (T)Integer.valueOf(numerator.intValue() - rationalToBeSubstracted.getNumerator().intValue());
			}
		}else {
			switch (verifyNumberData(numerator, denominator)) {
			case 1:
				numerator = (T)Long.valueOf(numerator.longValue()*rationalToBeSubstracted.getDenominator().longValue()
											-denominator.longValue()*rationalToBeSubstracted.getNumerator().longValue());
				denominator = (T)Long.valueOf(denominator.longValue()*rationalToBeSubstracted.getDenominator().longValue());
				break;
			case 2:
				numerator = (T)Short.valueOf((short) (numerator.shortValue()*rationalToBeSubstracted.getDenominator().shortValue()
													- denominator.shortValue()*rationalToBeSubstracted.getNumerator().shortValue()));
				denominator = (T)Short.valueOf((short)(denominator.shortValue()*rationalToBeSubstracted.getDenominator().shortValue()));
				
				break;
			case 3:
				numerator = (T)Integer.valueOf(numerator.intValue()*rationalToBeSubstracted.getDenominator().intValue()
												-denominator.intValue()*rationalToBeSubstracted.getNumerator().intValue());
				denominator = (T)Integer.valueOf(denominator.intValue()*rationalToBeSubstracted.getDenominator().intValue());
				break;
			}
		}
		simplifyRational();
	}
	
	@Override
	public void multiplyRational(RationalNumber<Number> rationalFactor) {
		this.numerator = multiply(numerator, (T) rationalFactor.getNumerator());
		this.denominator = multiply(denominator, (T) rationalFactor.getDenominator());
		simplifyRational();
	}

	private T multiply(T n1, T n2) {
		T number = null;

		switch (verifyNumberData(n1, n2)) {
		case 1:
			number = (T) Long.valueOf(n1.longValue() * n2.longValue());
			break;
		case 2:
			number = (T) Short.valueOf((short) (n1.shortValue() * n2.shortValue()));
			break;
		case 3:
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

	@Override
	public void simplifyRational() {
		T simplify = mcd();
		
		switch (verifyNumberData(numerator, denominator)) {
		case 1:
			numerator = (T)Long.valueOf(numerator.longValue() / simplify.longValue());
			denominator = (T)Long.valueOf(denominator.longValue() / simplify.longValue());
			break;
		case 2:
			numerator = (T)Short.valueOf((short) (numerator.shortValue() / simplify.shortValue()));
			denominator = (T)Short.valueOf((short) (denominator.shortValue() / simplify.shortValue()));
			break;
		case 3:
			numerator = (T)Integer.valueOf(numerator.intValue() / simplify.intValue());
			denominator = (T)Integer.valueOf(denominator.intValue() / simplify.intValue());
			break;
		}
	}

	private T mcd() {
		T u = null;
		T d = null;
		T aux = null;
		
		switch (verifyNumberData(numerator, denominator)) {
		case 1:
			u = (T) Long.valueOf(Math.abs(numerator.longValue()));
			d = (T) Long.valueOf(Math.abs(denominator.longValue()));
			while (d.longValue() != 0) {
				aux = (T) Long.valueOf(u.longValue() % d.longValue());
				u = d;
				d = aux;
			}
			break;
		case 2:
			u = (T) Short.valueOf((short) Math.abs(numerator.shortValue()));
			d = (T) Short.valueOf((short) Math.abs(denominator.shortValue()));
			while (d.shortValue() != 0) {
				aux = (T) Short.valueOf((short) (u.shortValue() % d.shortValue()));
				u = d;
				d = aux;
			}
			break;
		case 3:
			u = (T) Integer.valueOf(Math.abs(numerator.intValue()));
			d = (T) Integer.valueOf(Math.abs(denominator.intValue()));
			while (d.intValue() != 0) {
				aux = (T) Integer.valueOf(u.intValue() % d.intValue());
				u = d;
				d = aux;
			}
			break;
		}
	
		return u;
	}

	@Override
	public void rationalInverse() {
		T temp = numerator;
		
		switch (verifyNumberData(numerator, denominator)) {
		case 1:
			if(numerator.longValue()!=0) {
				numerator = denominator;
				denominator = temp;
			}
			break;
		case 2:
			if(numerator.shortValue()!=0) {
				numerator = denominator;
				denominator = temp;
			}
			break;
		case 3:
			if(numerator.intValue()!=0) {
				numerator = denominator;
				denominator = temp;
			}
			break;
		}
		simplifyRational();
	}

	@Override
	public void squaredRational() {
		
		switch (verifyNumberData(numerator, denominator)) {
		case 1:
			numerator = (T) Long.valueOf(numerator.longValue() * numerator.longValue());
			denominator = (T) Long.valueOf(denominator.longValue() * denominator.longValue());
			break;
		case 2:
			numerator = (T) Short.valueOf((short) (numerator.shortValue() * numerator.shortValue()));
			denominator = (T) Short.valueOf((short) (denominator.shortValue() * denominator.shortValue()));
			break;
		case 3:
			numerator = (T) Integer.valueOf(numerator.intValue() * numerator.intValue());
			denominator = (T) Integer.valueOf(denominator.intValue() * denominator.intValue());
			break;
		}
		simplifyRational();
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
