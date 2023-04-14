
<%@ page import="java.util.List" %>
<%@ page import="Entity.Room" %>
<head>
</head>
<body>


    <%

        out.println("Room Id | Room Capacity | Room Type ");%><br><%
        List<Room> roomList = (List<Room>)request.getAttribute("RoomList");
        for(Room room : roomList){
         if(!room.isBooked() ){

                        if(room.getCapacity() == 5)
                            out.println(room.getId()+"      |       "+room.getCapacity()+"        |  "+room.getRoomType());
                        else
                            out.println(room.getId()+"      |       "+room.getCapacity()+"       |  "+room.getRoomType());
                    }%><br><%
        }

    %>
</body>