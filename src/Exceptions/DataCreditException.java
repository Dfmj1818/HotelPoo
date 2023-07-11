package Exceptions;

public class DataCreditException extends RuntimeException{
  
	public DataCreditException() {
		super("Ocurrio un Error al digitar la informacion de tu tarjeta");
	}
}
