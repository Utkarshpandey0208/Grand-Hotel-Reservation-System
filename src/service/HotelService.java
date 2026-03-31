package service;

import java.sql.Connection;
import model.Reservation;
import repository.HotelDao;
import util.dbConnection;

public class HotelService {

    private final HotelDao hotelDao = new HotelDao();

    public boolean reserveRoom(Reservation reservation) {
        Connection con = null;
        try {
            con = dbConnection.getConnection();

            int entryStatus = hotelDao.reserveRoom(con, reservation);
            return entryStatus > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Reservation checkReservationById(int reservationId) {
        Connection con = null;
        try {
            con = dbConnection.getConnection();
            return hotelDao.checkReservationById(con, reservationId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Reservation checkReservationByName(String reservationName) {
        Connection con = null;
        try {
            con = dbConnection.getConnection();
            return hotelDao.checkReservationByName(con, reservationName);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Reservation checkReservationByRoomNumber(int roomNumber) {
        Connection con = null;
        try {
            con = dbConnection.getConnection();
            return hotelDao.checkReservationByRoomNumber(con, roomNumber);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}