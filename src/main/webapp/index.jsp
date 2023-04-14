<html>
    <head>

    </head>
    <body>
        <form action="Data" >
            <center><button type="submit">Clickme to Generate Data</button></center>
        </form>
        <div><center>
            <h2>Welcome !</h2>
            <h3>Please Select A Option</h3>
            <form action = "book-room.jsp" method="post" >
                <button type="submit" name="option" value="1">Book Room</button>
            </form>
            <form action ="Menu" >
                <button type="submit" name="option" value="2">Update Booking</button>
            </form>

            <form action = "GetAvailableRooms" method="get">
                <button type="submit" name="option" value="3">Get Available Rooms</button>
            </form>
            <form action = "Menu">
                <button type="submit" name="option" value="4">Cancel Booking</button>
            </form>
            <form action = "Menu">
                <button type="submit" name="option" value="5">View Booking Details</button>
            </form>
        </center>
        </div>
    </body>
</html>
