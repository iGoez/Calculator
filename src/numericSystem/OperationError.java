package numericSystem;

public class OperationError extends Exception{

	public OperationError() {
		super("El denominador de la fracción es igual a 0");
	}
}
