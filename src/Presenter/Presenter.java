package Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import Exceptions.InsufficientFundsException;
import Model.Hotel;
import Model.HotelRoom;
import Model.Reserve;
import Model.User;
import Model.VirtualCard;
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
	private String arrivalDateString;
	private String departureDateString;

	public Presenter() {
		view=new View();
		hotel=new Hotel();
		hotelRoom=new HotelRoom();

	}
	
   // Se hizo Correccion 
	public void loginUser() {
		do {
			view.showMessage("Bienvenido al Hotel Four Seasons de Nueva York\n1.Presiona 1 para registrarte\n2.Digita 2 para Iniciar Sesion\n3.Presiona 3 para Salir  ");
			digitedOptionForMenu=view.readInt();

			switch(digitedOptionForMenu) {

			case 1:
				view.showMessage("Digita tu Correo Electronico");
				digitedMail=view.readString();
				view.showMessage("Digita tu contraseña");
				digitedPassword=view.readString();
				view.showMessage("Digita Un Nombre de Usuario");
				digitedName=view.readString();
				if(hotel.verifyMail(digitedMail)==true){
					User user=new User(digitedMail,digitedPassword,digitedName);
					hotel.addUserToUsersDataBase(user);
					runServices(user);
				}
				else {
					view.showMessage("Correo Escrito de Forma Incorrecta,Vuelve a Intentarlo\n");
					loginUser();
				}
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
				runServices(currentUser);
				break;
			case 3:
				view.showMessage("Saliendo de la aplicacion");
				System.exit(0);
				break;		

			default:
				view.showMessage("La opcion numero "+digitedOptionForMenu+" No existe,Por favor intentalo de nuevo");
				break;
			}




		}while(digitedOptionForMenu!=4);


	}
	//Se hizo Correccion
	public void runServices(User user) {
		int digitedOptionForSecondMenu;
		String yesOrNotAnswer;
		int choosedRoomByUser;
		view.showMessage("Hemos Verificado Tu Identidad,Bienvenido "+user.getUserName());
		view.showMessage("¿Que Deseas Hacer?\n1.Ver las Habitaciones Dispoinibles\n2.Ver Tu lista de Reservas\n3.Salir Al menu Principal");
		digitedOptionForSecondMenu=view.readInt();
		do {
			switch(digitedOptionForSecondMenu) {
			case 1:
				view.showMessage("Presiona La habitacion Que desees añadir a tu lista de reservas");
				viewAvaiablesRooms();
				choosedRoomByUser=view.readInt();
				view.showMessage("¿Deseas Hacer Una Reserva De esta Habitacion?"); 
				yesOrNotAnswer=view.readString();
				if(yesOrNotAnswer.equalsIgnoreCase("si")) {
					createUserReserve(user,choosedRoomByUser);
				}
				else {
					view.showMessage("Volviendo Al Menu Principal.....");
					loginUser();		
					break;
				}

			case 2:
				view.showMessage("Estas Son Tus Reservas Hasta El momento"+user.viewReservesList());
				view.showMessage("¿Deseas Hacer Otra reservacion?");
				yesOrNotAnswer=view.readString();
				if(yesOrNotAnswer.equalsIgnoreCase("No")){
					view.showMessage("Volviendo Al Menu Principal.....");
					loginUser();
					break;
				}
			case 3:
				view.showMessage("Saliendo Al Menu Principal.....");
				loginUser();
				break;

			default:
				view.showMessage("La opcion "+digitedOptionForSecondMenu+" No Existe por favor Intentelo de Nuevo");
				runServices(user);
				break;
			}

		}while(digitedOptionForSecondMenu!=3);

	}


	public void createUserReserve(User user,int choosedRoomByUser){
		try {
			
			HotelRoom choosedRoom=hotel.chooseRoom(choosedRoomByUser); 
			view.showMessage("Digita la fecha de llegada Al Hotel\n Por favor digitala en formato dia/mes/año");
			arrivalDateString=view.readString();
			DateTimeFormatter hotelDateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate arrivalDate=LocalDate.parse(arrivalDateString,hotelDateFormat); 
			view.showMessage("Digita Tu Fecha de Salida Del Hotel\n Por favor Digitala en formato dia/mes/año");
			departureDateString=view.readString();
			LocalDate departureDate=LocalDate.parse(departureDateString,hotelDateFormat);
			Reserve currentReserve =hotel.createReserveForUser(user, choosedRoom, arrivalDate, departureDate);
			view.showMessage("El valor total De la Reserva es de:"+hotel.calculateTotalValueOfReserve(currentReserve));
			if(verifyUserVirtualCardFunds(user,choosedRoom)==true) {
				view.showMessage("Reserva añadida Con Exito");
				user.addReserveToList(currentReserve);		 
			}
			else {
				throw new InsufficientFundsException();
			}

		}	
		   catch(DateTimeParseException dateException) {
			view.showMessage("Error al ingresar el formato de Fecha incorrecto"+dateException.getMessage()+dateException.getCause());
			
		   }
		    catch(Exception e) {
			  view.showMessage("Error: "+e.getMessage()+e.getCause());
			  
		   }

	}


	public boolean verifyUserVirtualCardFunds(User user,HotelRoom choosedRoomByUser) {

		int CCV;
		int cardCode;
		String expirationDateAsString;
		LocalDate expirationDate;
		boolean sufficientFundsOnCard;

		view.showMessage("Digita el Codigo de tu tarjeta");
		cardCode=view.readInt();
		view.showMessage("Digita el CCV de tu Tarjeta");
		CCV=view.readInt();
		view.showMessage("Digita la fecha De Expiracion de tu tarjeta");
		expirationDateAsString=view.readString();
		DateTimeFormatter expeditionDateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		expirationDate=LocalDate.parse(expirationDateAsString,expeditionDateFormat);
		VirtualCard virtualCard=new VirtualCard(user,cardCode,CCV,expirationDate);
		//Verifica Los Fondos de la tarjeta,Si los fondos son suficientes retorna True ,Si son Insuficientes Retorna False
		sufficientFundsOnCard=hotel.verifyUserFunds(virtualCard, choosedRoomByUser); 

		return sufficientFundsOnCard;

	}
	//Excepcion  de datos insertados
	//Excepcion de saldo insuficiente en la tarjeta 
	//


	public void viewAvaiablesRooms() {
		view.showMessage(hotel.showHotelRooms());
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
