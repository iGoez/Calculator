package numericSystem;

public class OperationError extends Exception{

	public OperationError() {
		super("El denominador de la fracci�n es igual a 0");
	}
}
