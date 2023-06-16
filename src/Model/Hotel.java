package Model;

import java.util.ArrayList;

public class Hotel {
   private ArrayList<HotelRoom>hotelRoomsList;
   
   public Hotel() {
	   hotelRoomsList=new ArrayList<HotelRoom>();
   }
   
   public void addRoomsToHotel(HotelRoom hotelRoom) {
	   hotelRoomsList.add(hotelRoom);
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
	   HotelRoom hotelRoom2Type3=new HotelRoom(4,22000,"Piso 3",true,false,false,"Habitacion doble");
	   addRoomsToHotel(hotelRoom2Type3);
	   
	   
   }
   
   
   
   
   
}
