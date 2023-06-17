package Model;

public class HotelRoom {
  private int roomId;
  private int roomPrice;
  private String location;
  private String roomDescription;
  private boolean doubleBed;
  private boolean singleBed;
  private boolean jacuzzi;
    
  
  public HotelRoom(int roomId,int roomPrice,String location,boolean doubleBed,boolean singlebed,boolean jacuzzi,String roomDescription ) {
	  this.roomId=roomId;
	  this.roomPrice=roomPrice;
	  this.location=location;
	  this.doubleBed=doubleBed;
	  this.singleBed=singlebed;
	  this.jacuzzi=jacuzzi;
	  this.roomDescription =roomDescription;
  }
  
  public HotelRoom() {
	  
  }
  
  public void setRoomId(int roomId) {
	  this.roomId=roomId;
  }
  
  public int getRoomId() {
	  return roomId;
  }
  
  public void setRoomPrice(int roomPrice) {
	 this.roomPrice=roomPrice;  
  }
 
  public int getRoomPrice() {
	  return roomPrice;
  }
  
  public void setLocation(String location) {
	  this.location=location;
  }
  
  public String getLocation() {
	  return location;
  }
  
  public void setDoubleBed(boolean doubleBed) {
	  this.doubleBed=doubleBed;
  }
  
  public boolean getDoubleBed() {
	  return doubleBed;
  }
  
  public void setSingleBed(boolean singleBed) {
	  this.singleBed=singleBed;
  }
  
  public boolean getSingleBed() {
	  return singleBed;
  }
  
  public void setJacuzzi(boolean jacuzzi) {
	  this.jacuzzi=jacuzzi;
  }
  
  public boolean getJacuzzi() {
	  return jacuzzi;
  }
  
  public void setRoomDescription(String roomDescription) {
	  this.roomDescription=roomDescription;
  }
  
  public String getRoomDescription() {
	  return roomDescription;
  }
  

}
