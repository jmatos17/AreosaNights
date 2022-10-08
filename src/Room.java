public class Room {

    private int roomNumber;
    private boolean availability;

    public Room(int roomNumber){

        this.availability = true;
        this.roomNumber = roomNumber;
    }

    public boolean getAvailability(){

        return availability;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setAvailability(boolean availability){
        this.availability = availability;
    }
}
