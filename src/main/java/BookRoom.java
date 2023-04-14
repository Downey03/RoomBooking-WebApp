import Data.Data;
import Entity.Booking;
import Entity.Room;
import Utility.Utility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/BookRoom")
public class BookRoom extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookingList = Data.getBookingList();
        List<Room> roomList = Data.getRoomList();

        String name = request.getParameter("GuestName");
        String guestCount = request.getParameter("GuestCount");
        String roomType = request.getParameter("RoomType");

        try{
            PrintWriter out = response.getWriter();
            bookRoom(roomList,bookingList,name,guestCount,roomType,out);
        }catch (Exception e){
            String message = e.getMessage();
            request.setAttribute("message",message);
            request.getRequestDispatcher("exception-page.jsp").forward(request,response);
        }
    }

    public void bookRoom(List<Room> roomList, List<Booking> bookingList, String name, String count, String roomType, PrintWriter out) throws Exception {
        if(bookingList.size()==10) throw new Exception("Sorry! All Rooms Are Booked");

        int guestCount = -1;                        //getting guest count and name
        try {
            guestCount = Utility.validNumber(count);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        Room room;
        Booking booking = new Booking();
        if(guestCount >14){                     //guest count > 14 can only book luxury room

            room = Utility.getLuxuryRoom(roomList);

            if(room == null) throw new Exception("Sorry! Luxury rooms not available at the moment");

            Utility.confirmBooking(bookingList,name,guestCount,room,booking);

        }
        else if(guestCount > 5 ){               //guest count > 5 can book luxury and deluxe rooms

//            System.out.println("Please select the room type");
//            System.out.println("1) Deluxe - A/C");
//            System.out.println("2) Luxury - A/C");
//
//
//            if(choice != 1 && choice!= 2) throw new InvalidChoiceException("Please enter the correct choice\n---------------------------");
//
//            if(choice == 1) room = Utility.getDeluxeRoom(roomList);
//            else room = Utility.getLuxuryRoom(roomList);

      //      Utility.confirmBooking(bookingList,name,guestCount,room,booking);
        }
        else {                                     // guest count less than 5 can book any type of room

//            System.out.println("Please select the room type");
//            System.out.println("1) Normal - Non-A/C");
//            System.out.println("2) Deluxe - A/C");
//            System.out.println("3) Luxury - A/C");
//
//            int choice = sc.nextInt();
//            if(choice != 1 && choice != 2 && choice !=3) throw new InvalidChoiceException("Please enter the correct choice");
//
//            if(choice == 1) room = Utility.getNormalRoom(roomList);
//            else if(choice == 2) room = Utility.getDeluxeRoom(roomList);
//            else room = Utility.getLuxuryRoom(roomList);
//
//            if(room == null) throw new NoRoomsAvailableException("Sorry! All rooms of this type are filled");
//            Utility.confirmBooking(bookingList,name,guestCount,room,booking);
        }

    }

}
