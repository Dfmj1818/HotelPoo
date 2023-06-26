package Exceptions;

public class InsufficientFundsException extends RuntimeException{

	public InsufficientFundsException() {
		super("Fondos Insuficientes en la Tarjeta");
	}
}
