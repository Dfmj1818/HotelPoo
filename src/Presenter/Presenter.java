package Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Model.Hotel;
import Model.HotelRoom;
import Model.Reserve;
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
    private int digitedOptionForRoomMenu;
    private String arrivalDateString;
    private String departureDateString;
    
	public Presenter() {
		view=new View();
		hotel=new Hotel();
		hotelRoom=new HotelRoom();
        yesOrNotAnswer="";
	}

	public void loginUser() {

		do {
			view.showMessage("Bienvenido al Hotel Four Seasons de Nueva York\n1.Presiona 1 para registrarte\n2.Digita 2 para Iniciar Sesion\n3.Presiona 3 Para Ver las habitaciones disponibles del hotel\n4.Presiona 4 para Salir  ");
            digitedOptionForMenu=view.readInt();
   
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
				createUserReserve(user);
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
				createUserReserve(currentUser);
				break;
			case 3:
				
				break;
			case 4:
				view.showMessage("Saliendo de la aplicacion");
			    System.exit(0);
				break;
				
			default:
				view.showMessage("La opcion numero "+digitedOptionForMenu+" No existe,Por favor intentalo de nuevo");
                break;
			}




		}while(yesOrNotAnswer.equalsIgnoreCase("yes"));


	}
	
	public void createUserReserve(User user) {
		
		view.showMessage("Mira las Habitaciones Disponibles que tenemos\nPresiona el numero respectivo para Seleccionar la opcion que quieras Escoger");
		viewAvaiablesRooms();
		digitedOptionForRoomMenu=view.readInt();
		HotelRoom choosedRoomByUser=hotel.chooseRoom(digitedOptionForRoomMenu); 
		view.showMessage("Digita la fecha de llegada Al Hotel\n Por favor digitala en formato dia/mes/año");
		arrivalDateString=view.readString();
		DateTimeFormatter hotelDateFormat=DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate arrivalDate=LocalDate.parse(arrivalDateString,hotelDateFormat); 
		view.showMessage("Digita Tu Fecha de Salida Del Hotel\n Por favor Digitala en formato dia/mes/año");
		departureDateString=view.readString();
		DateTimeFormatter hotelDateFormat2=DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate departureDate=LocalDate.parse(departureDateString,hotelDateFormat2);
		Reserve currentReserve =hotel.createReserveForUser(user, choosedRoomByUser, arrivalDate, departureDate);
	    user.addReserveToList(currentReserve);
		
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
