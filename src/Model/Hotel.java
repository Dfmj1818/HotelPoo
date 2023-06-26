package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import View.View;

public class Hotel {
	private ArrayList<HotelRoom>hotelRoomsList;
	private ArrayList<User>usersDataBase;
	private View view;
	private String listAsString;

	public Hotel() {
		hotelRoomsList=new ArrayList<HotelRoom>();
		usersDataBase=new ArrayList<User>();
		listAsString="";
	}

	public void addRoomsToHotel(HotelRoom hotelRoom) {
		hotelRoomsList.add(hotelRoom);
	}


	public void addUserToUsersDataBase(User user) {
		usersDataBase.add(user);

	}

	public User getUserInUsersDataBase(User user) {
		for(int i=0;i<usersDataBase.size();i++) {
			if(usersDataBase.get(i).getUserMail().equals(user.getUserMail())&&usersDataBase.get(i).getUserPassword().equals(user.getUserPassword())) {
				User userFound=usersDataBase.get(i);
				return userFound;		
			}

		}
		return null;
	}

	public void deleteHotelRoom(int idToDelete) {
		for(int i=0;i<hotelRoomsList.size();i++) {
			if(hotelRoomsList.get(i).getRoomId()==idToDelete){
				hotelRoomsList.remove(i);
				break;
			}
		}
	}



	public void createHotelRooms() {

		HotelRoom premiumHotelRoom=new HotelRoom(1,350000,"Piso 3",false,true,true, "Habitacion Premium Que viene con jacuzzi,Cama Doble ");
		addRoomsToHotel(premiumHotelRoom);		
		HotelRoom semiPremiumHotelRoom=new HotelRoom(2,320000,"Piso 2",true,false,false,"Habitacion semiPremium Que viene con camaDoble y Television ");
		addRoomsToHotel(semiPremiumHotelRoom);
		HotelRoom simpleHotelRoom=new HotelRoom(3,50000,"Piso 1",false,false,false," Habitacion Sencilla que viene con unicamente una cama sencilla y television");
		addRoomsToHotel(simpleHotelRoom);
	}

	public String showHotelRooms() {
		for(int i=0;i<hotelRoomsList.size();i++) {
			HotelRoom currentHotelRoom=hotelRoomsList.get(i);
			listAsString+="Id: "+currentHotelRoom.getRoomId()+" Precio:"+currentHotelRoom.getRoomPrice()+" Ubicacion "+currentHotelRoom.getLocation()+"\n";
		}	
		return listAsString;
	}



	public Reserve createReserveForUser(User user,HotelRoom hotelRoom,LocalDate arrivalDate,LocalDate departureDate ) {
		Reserve reserve=new Reserve(user,hotelRoom,arrivalDate,departureDate);
		return reserve;     

	}



	public HotelRoom chooseRoom(int choosedId) {
		for(int i=0;i<hotelRoomsList.size();i++) {
			if(hotelRoomsList.get(i).getRoomId()==choosedId) {
				HotelRoom choosedHotelRoom=hotelRoomsList.get(i);
				return choosedHotelRoom;
			}

		}
		return null;
	}

    //se Modifico
	public boolean verifyMail(String mail) {
		return mail.contains("@")&& mail.endsWith(".com");
	}

	public long calculateTotalValueOfReserve(Reserve reserve) {
		int currentPriceReserve=reserve.getHotelRoom().getRoomPrice();
		long daysInTheHotel=ChronoUnit.DAYS.between(reserve.getArrivalDate(),reserve.getDepartureDate());
		long totalValueOfReserve=currentPriceReserve*daysInTheHotel;

		   return totalValueOfReserve;
	}
// Se hizo Correccion
	public boolean verifyUserFunds(VirtualCard virtualCard,HotelRoom choosedRoomByUser) {
		//Funciona Como un If Else,retorna true si se cumple la condicion,Retorna False en caso de No Cumplir la Condicion
		return virtualCard.generateRandomFunds()>choosedRoomByUser.getRoomPrice();
		
	}


}
