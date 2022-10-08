import java.util.ArrayList;

public class Hotel {

    private String name;
    private Room[] roomList;
    private boolean availability;

    public Hotel(String name, int roomNumber) {

        this.availability = true;
        this.name = name;
        this.roomList = new Room[roomNumber];

        for (int i = 0; i < roomNumber; i++) {
            roomList[i] = new Room(i);
        }

    }

    public Room[] getRoomList() {

        return roomList;
    }

    public String getName() {
        return name;
    }

    public boolean checkAvailability() {

        return availability;
    }

    public int checkNextAvailableRoom() {

        for (int i = 0; i < roomList.length; i++) {
            if (roomList[i].getAvailability()) {
                return i;
            }
        }
        return -1;
    }

    public void checkInHotel(int roomNumber) {
        if (roomNumber > roomList.length || roomNumber < 0) {
            System.out.println("Invalid room number");
            return;
        }

        roomList[roomNumber].setAvailability(false);
    }

    public void checkOutHotel(int roomNumber) {

        roomList[roomNumber].setAvailability(true);
    }

}
