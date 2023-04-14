package Utility;

import Entity.Booking;
import Entity.Room;

import java.time.LocalTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static int validNumber(String id) throws  Exception {

        Pattern pattern = Pattern.compile("\\D");
        Matcher matcher = pattern.matcher(id);
        if(matcher.find()){
            throw new Exception("Only numbers are allowed\n--------------------------");
        }
        return Integer.parseInt(id);
    }


    public static Room getNormalRoom(List<Room> roomList) {
        for(Room room :roomList){
            if(room.getRoomType().equals("NORMAL") && !room.isBooked()) return room;
        }

        return  null;
    }
    public static Room getDeluxeRoom(List<Room> roomList) {
        for(Room room :roomList){
            if(room.getRoomType().equals("DELUXE") && !room.isBooked()) return room;
        }

        return  null;
    }
    public static Room getLuxuryRoom(List<Room> roomList) {
        for(Room room :roomList){
            if(room.getRoomType().equals("LUXURY") && !room.isBooked()) return room;
        }

        return  null;
    }

    public static void confirmBooking(List<Booking> bookingList, String name, int guestCount, Room room, Booking newBooking) {

        int bookingId = (int)(Math.random()*100+50);
        newBooking.setId(bookingId);
        newBooking.setBookingTime(LocalTime.now());
        newBooking.setName(name);
        newBooking.setGuestCount(guestCount);
        room.setBooked(true);
        newBooking.setRoom(room);

        bookingList.add(newBooking);

    }

    public static List<Room> createLists(List<Room> roomList) {
        for (int i = 0; i < 10; i++) {

            int id = 100 + i;
            int capacity = (int) (Math.random() * 3 + 1) * 5;
            String type;
            if (capacity == 5) type = "NORMAL";
            else if (capacity == 10) type = "DELUXE";
            else type = "LUXURY";
            boolean ac = false;
            if (!type.equals("NORMAL")) ac = true;

            Room newRoom = new Room();
            newRoom.setRoomType(type);
            newRoom.setCapacity(capacity);
            newRoom.setId(id);
            newRoom.setAcAvailable(ac);
            newRoom.setBooked(false);
            roomList.add(newRoom);


        }
        return roomList;
    }

    public static boolean sameRoomSelected(int choice, String roomType) {
        if(choice == 1 && roomType.equals("NORMAL")) return true;
        if(choice == 2 && roomType.equals("DELUXE")) return true;
        if(choice == 3 && roomType.equals("LUXURY")) return true;
        return false;
    }
}
