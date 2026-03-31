package model;

public class Reservation {
  private int room_number;
  private String guest_name;
  private String contact_number;
  private int reservation_id;
  private String reservation_date;
  public Reservation(int room_number,String guest_name,String contact_number){
    this.room_number = room_number;
    this.guest_name = guest_name;
    this.contact_number = contact_number;
  }

  public Reservation(int reservation_id,int room_number, String guest_name, String contact_number, String reservation_date){
    this.reservation_id = reservation_id;
    this.room_number = room_number;
    this.guest_name = guest_name;
    this.contact_number = contact_number;
    this.reservation_date = reservation_date;
  }
  //getters
  public int getId(){
    return reservation_id;
  }

  public String getReservationDate(){
    return reservation_date;
  }
  
  public String getGuestName(){
    return guest_name;
  }

  public int getRoomNumber(){
    return room_number;
  }

  public String getContactNumber(){
    return contact_number;
  }
  @Override
  public String toString(){
    return "Guest Name: " + getGuestName() + ", Room No: " + getRoomNumber() + ", Contact: " + getContactNumber();
  }

}
