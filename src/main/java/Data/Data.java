package Data;

import Entity.Booking;
import Entity.Room;
import Utility.Utility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Data")
public class Data extends HttpServlet {
    private static List<Room> roomList ;
    private static List<Booking> bookingList;


    @Override
    public void init() throws ServletException {

        roomList = new ArrayList<>();
        bookingList = new ArrayList<>();
        Utility.createLists(roomList);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    public static List<Room> getRoomList() {
        return roomList;
    }

    public static void setRoomList(List<Room> roomList) {
        Data.roomList = roomList;
    }

    public static List<Booking> getBookingList() {
        return bookingList;
    }

    public static void setBookingList(List<Booking> bookingList) {
        Data.bookingList = bookingList;
    }
}
