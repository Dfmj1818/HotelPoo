package Model;

import java.time.LocalDate;

public class Reserve {
	public LocalDate arrivalDate;
	public LocalDate departureDate;
	public User user;
	public HotelRoom hotelRoom;
	

	public Reserve(User user,HotelRoom hotelRoom,LocalDate arrivalDate,LocalDate departureDate) {
		this.user=user;
		this.hotelRoom=hotelRoom;
		this.arrivalDate=arrivalDate;
		this.departureDate=departureDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate=arrivalDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate=departureDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setUser(User user) {
		this.user=user;
	}

	public User getUser() {
		return user;
	}

	public void setHotelRoom(HotelRoom hotelRoom) {
		this.hotelRoom=hotelRoom;
	}

	public HotelRoom getHotelRoom() {
		return hotelRoom;
	}

}
