package Exceptions;

public class AttemptsExceededException extends RuntimeException{

	public AttemptsExceededException() {
		super("Haz Excedido El numero De Intentos Para Tratar De registrarte,Por Favor Vuelve a intentarlo mas Tarde");
	}
}
