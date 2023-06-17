package Model;

import java.util.ArrayList;

public class User {
	private String mail;
	private String password;
	private ArrayList<Reserve>reservesList;

	public User(String mail,String password) {
		this.mail=mail;
		this.password=password;

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
}
