package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	private Scanner scannerForInt;
	private Scanner scannerForString;


	public View() {
		scannerForInt=new Scanner(System.in);
		scannerForString=new Scanner(System.in);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	//Este metodo Devuelve un valor de tipo string 
	public String readString() {
		return scannerForString.nextLine();
	}
	//Este metodo Devuelve un valor de tipo Entero
	public int readInt() {		
		return scannerForInt.nextInt();

	}

}
