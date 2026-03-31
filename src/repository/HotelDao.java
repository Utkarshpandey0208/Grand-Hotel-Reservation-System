package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Reservation;
public class HotelDao{
  public int reserveRoom(Connection con,Reservation reservation) throws SQLException{
    String query = "Insert into reservations (guest_name,room_number,contact_number) values (?, ?, ?);";

    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1,reservation.getGuestName());
    ps.setInt(2,reservation.getRoomNumber());
    ps.setString(3,reservation.getContactNumber());
    int entryStatus = ps.executeUpdate();
    return entryStatus;
  }

  private Reservation mapRowToReservation(ResultSet rs) throws SQLException {
    return new Reservation(
        rs.getInt("reservation_id"),
        rs.getInt("room_number"),
        rs.getString("guest_name"),
        rs.getString("contact_number"),
        rs.getString("reservation_date")
    );
}

  public Reservation checkReservationById(Connection con,int reservationId) throws SQLException{
    String query = "Select * from reservations where reservation_id = ?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1,reservationId);
    ResultSet rs = ps.executeQuery();
    Reservation reservation = null;

    if(rs.next()){
      if (rs.next()) {
      reservation = mapRowToReservation(rs);
      }
    }
    rs.close();
    ps.close();
    return reservation;
  }

  public Reservation checkReservationByName(Connection con, String reservationName) throws SQLException{
    String query = "SELECT * FROM reservations WHERE LOWER(guest_name) = LOWER(?)";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1,reservationName);
    ResultSet rs = ps.executeQuery();
    Reservation reservation = null;
    if(rs.next()){
      if (rs.next()) {
        reservation = mapRowToReservation(rs);
      }
    }
    rs.close();
    ps.close();
    return reservation;
  }

  public Reservation checkReservationByRoomNumber(Connection con, int reservationRoomNumber) throws SQLException{
    String query = "SELECT * FROM reservations WHERE room_number = ?";
    PreparedStatement ps = con.prepareStatement(query);
    ps.setInt(1,reservationRoomNumber);
    ResultSet rs = ps.executeQuery();
    Reservation reservation = null;
    if(rs.next()){
      if (rs.next()) {
        reservation = mapRowToReservation(rs);
      }
    }
    rs.close();
    ps.close();
    return reservation;
  }
}