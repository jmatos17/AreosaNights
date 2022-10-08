public class Person {

    private String name;
    private int roomNumber;
    private boolean isCheckedIn;

    public Person(String name) {
        this.name = name;
        this.roomNumber = -1;
        this.isCheckedIn = false;
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

   public boolean getIsCheckedIn(){
        return isCheckedIn;
   }

    public void checkIn(Hotel hotel) {

        if (!hotel.checkAvailability()) {
            System.out.println("We're sorry, no rooms available at the moment");
            return;
        }

        roomNumber = hotel.checkNextAvailableRoom();
        if (roomNumber > hotel.getRoomList().length || roomNumber < 0) {
            System.out.println("Invalid room number");
            return;
        }

        hotel.checkInHotel(roomNumber);
        isCheckedIn = true;
        System.out.println("Check in successful");
        System.out.println("Your room number is: Room " + roomNumber);

    }

    public void checkOut(Hotel hotel) {

        if (!isCheckedIn) {
            System.out.println("Please check in before checking out");
            return;
        }
        hotel.checkOutHotel(roomNumber);
        isCheckedIn = false;
        System.out.println("Check out successful");
        System.out.println("Room " + roomNumber + " is now free.");
        roomNumber = -1;
    }

}

