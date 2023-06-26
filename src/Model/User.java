package Model;

import java.util.ArrayList;

public class User {
	private String mail;
	private String password;
	private ArrayList<Reserve>reservesList;
	private String userName;
	private String listAsString;

	public User(String mail,String password,String userName) {
		this.mail=mail;
		this.password=password;
		this.userName=userName;
		reservesList=new ArrayList<Reserve>();
		listAsString="";
	}

	public void addReserveToList(Reserve reserve) {
		reservesList.add(reserve);
	}

	public void setUserMail(String mail) {
		this.mail=mail;
	}

	public String getUserMail() {
		return mail;
	}

	public void setUserPassword(String password) {
		this.password=password;
	}

	public String getUserPassword() {
		return password;
	}

	public void setReservesList(ArrayList<Reserve>reservesList) {
		this.reservesList=reservesList;
	}

	public ArrayList<Reserve>getReservesList(){
		return reservesList;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getUserName() {
		return userName;
	}

	public String viewReservesList() {
		for(int i=0;i<reservesList.size();i++) {
			Reserve currentReserve=reservesList.get(i);
			listAsString+="Datos de la Habitacion del Hotel: "+currentReserve.getHotelRoom().getRoomDescription()+"\nFecha de llegada Al hotel "+currentReserve.getArrivalDate()+"\nFecha de Salida Del hotel "+currentReserve.getDepartureDate()+"\n";
		}
		return listAsString;
	}
}
