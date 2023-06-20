package Presenter;

import Model.Hotel;
import Model.HotelRoom;
import Model.User;
import View.View;

public class Presenter {

	private View view;
	private Hotel hotel;
	private HotelRoom hotelRoom;
	private String digitedMail;
	private String digitedPassword;
	private String hotelRoomInformation;
	private int digitedOptionForMenu;
	private String digitedName;
    private String yesOrNotAnswer;
	
	public Presenter() {
		view=new View();
		hotel=new Hotel();
		hotelRoom=new HotelRoom();

	}

	public void loginUser() {

		do {
			view.showMessage("Bienvenido al Hotel Four Seasons de Nueva York\n1.Presiona 1 para registrarte\n2.Digita 2 para Iniciar Sesion\n 3.Presiona 3 Para Ver las habitaciones disponibles del hotel\n4.Presiona 4 para Salir  ");

			switch(digitedOptionForMenu) {
			
			case 1:
				view.showMessage("Digita tu Correo Electronico");
				digitedMail=view.readString();
				view.showMessage("Digita tu contraseña");
				digitedPassword=view.readString();
				view.showMessage("Digita Un Nombre de Usuario");
				digitedName=view.readString();
				User user=new User(digitedMail,digitedPassword,digitedName);
				hotel.addUserToUsersDataBase(user);
				
				break;

			case 2:
				view.showMessage("Digita tu correo Electronico");
				digitedMail=view.readString();
				view.showMessage("Digita tu contraseña");
				digitedPassword=view.readString();
				view.showMessage("Digita el Nombre Del Usuario");
				digitedName=view.readString();
				User currentUser=hotel.getUserInUsersDataBase(new User(digitedMail,digitedPassword,digitedName));
				view.showMessage("Bienvenido "+currentUser.getUserName());
				break;
			case 3:
				viewAvaiablesRooms();
				break;
			case 4:
				view.showMessage("Saliendo de la aplicacion");
			    System.exit(0);
				break;
				
			default:
				view.showMessage("La opcion numero"+digitedOptionForMenu+" No existe,Por favor intentalo de nuevo");
                break;
			}




		}while(yesOrNotAnswer.equalsIgnoreCase("yes"));


	}



	public void viewAvaiablesRooms() {
		hotelRoomInformation=hotel.showHotelRooms();
		view.showMessage(hotelRoomInformation);

	}


	public void fillHotelRooms() {
		hotel.createHotelRooms();
	}






	public static void main(String[]args) {
		Presenter presenter=new Presenter();
		presenter.fillHotelRooms();
		presenter.loginUser();

	}



}
