package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import Exceptions.DataCreditException;
import Exceptions.UserNotFoundException;
import View.View;

public class Hotel {
	private ArrayList<HotelRoom>hotelRoomsList;
	private ArrayList<User>usersDataBase;
	private ArrayList<Reserve>hotelReservesList;
	private View view;
	private String listAsString;


	public Hotel() {
		hotelRoomsList=new ArrayList<HotelRoom>();
		usersDataBase=new ArrayList<User>();
		hotelReservesList=new ArrayList<Reserve>();
		listAsString="";
	}

	public void addRoomsToHotel(HotelRoom hotelRoom) {
		hotelRoomsList.add(hotelRoom);
	}


	public void addUserToUsersDataBase(User user) {
		usersDataBase.add(user);

	}

	public void addReservesTohotelReservesList(Reserve reserve) {
		hotelReservesList.add(reserve);
	}

	public boolean checkRoomAvaiability(LocalDate arrivalDateOfCurrentReserve,LocalDate departureDateOfCurrentReserve) {
		for(int i=0;i<hotelReservesList.size();i++){
			if(arrivalDateOfCurrentReserve.isBefore(hotelReservesList.get(i).getDepartureDate())&&departureDateOfCurrentReserve.isAfter(hotelReservesList.get(i).getArrivalDate())||arrivalDateOfCurrentReserve.isEqual(hotelReservesList.get(i).arrivalDate)){
				return true;
			}
		}
		return false;

	}
	public User getUserInUsersDatabase(User user) {
		for(int i=0;i<usersDataBase.size();i++) {
			if(usersDataBase.get(i).getUserMail().equals(user.getUserMail())&&usersDataBase.get(i).getUserPassword().equals(user.getUserPassword())) {
				User userFound=usersDataBase.get(i);
				return userFound;		
			}
		}
		throw new UserNotFoundException();
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
		StringBuilder roomInformation=new StringBuilder();

		for(int i=0;i<hotelRoomsList.size();i++) {
			HotelRoom currentHotelRoom=hotelRoomsList.get(i);
			roomInformation.append("Id ");
			roomInformation.append(currentHotelRoom.getRoomId());
			roomInformation.append(" Precio ");
			roomInformation.append(currentHotelRoom.getRoomPrice());
			roomInformation.append(" Ubicacion ");
			roomInformation.append(currentHotelRoom.getLocation());
			roomInformation.append("\n");
		}	
		return roomInformation.toString();

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

	public boolean verifyMail(String mail) {
		return mail.contains("@gmail")&& mail.endsWith(".com");
	}

	public boolean verifyCCV(int CCV){
		String CCVAsString=String.valueOf(CCV);
		if(CCVAsString.length()==3){
			return true;
		}
		return false;
	}

	public boolean verifyCardCode(long cardCode) {
		String cardCodeAsString=String.valueOf(cardCode);
		if(cardCodeAsString.length()==10){
			return true;
		}		
		return false;
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
