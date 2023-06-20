package Model;

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

		HotelRoom hotelRoomType1=new HotelRoom(1,350000,"Piso 1",true,true,true, "habitación sencilla");
		addRoomsToHotel(hotelRoomType1);
		HotelRoom hotelRoom2Type1=new HotelRoom(1,35000,"Piso 1",true,true,true, "habitación doble"); 
		addRoomsToHotel(hotelRoom2Type1);
		HotelRoom hotelRoomType2=new HotelRoom(2,250000,"Piso 2",false,true,true, "Habitacion doble ");
		addRoomsToHotel(hotelRoomType2);
		HotelRoom hotelRoomType3=new HotelRoom(3,220000,"Piso 3",true,false,false,"Habitacion doble");
		addRoomsToHotel(hotelRoomType3);
		HotelRoom hotelRoom2Type3=new HotelRoom(4,22000,"Piso 3",true,false,false,"Habitacion Sencilla");
		addRoomsToHotel(hotelRoom2Type3);

	}

	public String showHotelRooms() {
		for(int i=0;i<hotelRoomsList.size();i++) {
			HotelRoom currentHotelRoom=hotelRoomsList.get(i);
			listAsString+="Id de la Habitacion : "+currentHotelRoom.getRoomPrice()+" Precio:"+currentHotelRoom.getRoomPrice()+" Ubicacion "+currentHotelRoom.getLocation()+"\n";
		}
		return listAsString;
	}


	public void createReserveForUser() {
       

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








}
