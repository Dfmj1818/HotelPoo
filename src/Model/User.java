package Model;

import java.util.ArrayList;

public class User {
	private String mail;
	private String password;
	private ArrayList<Reserve>reservesList;
	private String userName;

	public User(String mail,String password,String userName) {
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
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void viewReservesList() {
		for(int i=0;i<reservesList.size();i++) {
			Reserve currentReserve=reservesList.get(i);
			
		}
	}
}
