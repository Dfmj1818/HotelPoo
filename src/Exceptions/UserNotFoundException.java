package Exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super("El usuario No se Encontro en Nuestra base De datos,vuelve a intentarlo");
	}
	
}
