import Data.Data;
import Entity.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetAvailableRooms")
public class GetAvailableRooms extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> roomList = Data.getRoomList();
        request.setAttribute("RoomList",roomList);
        request.getRequestDispatcher("/display-available-rooms.jsp").forward(request,response);

    }
}
