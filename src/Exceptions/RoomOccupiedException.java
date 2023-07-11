package Exceptions;

public class RoomOccupiedException extends RuntimeException{

	public RoomOccupiedException() {
		super("Hubo un Error,Al parecer esta habitacion esta ocupada");
	}
}
