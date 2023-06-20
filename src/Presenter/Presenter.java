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
	
	public Presenter() {
		view=new View();
		hotel=new Hotel();
		hotelRoom=new HotelRoom();
		
	}
	
	public void loginUser() {

		view.showMessage("Bienvenido al Hotel Four Seasons de Nueva York\n A continuacion le mostramos las opciones de Habitaciones que tenemos");
		view.showMessage("Ingresa tu correo Electronico");
		digitedMail=view.readString();
		view.showMessage("Digita tu contraseña");
		digitedPassword=view.readString();
		User user=new User(digitedMail,digitedPassword);
		hotel.addUserToUsersDataBase(user);
		
		
	}
	
	public void chooseRoom() {
		
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
