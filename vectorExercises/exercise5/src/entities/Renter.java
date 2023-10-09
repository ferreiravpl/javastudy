package entities;

public class Renter {

    String name;
    String email;
    int roomNumber;

    public Renter (String name, String email, int roomNumber) {
        this.name = name;
        this.email = email;
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

//    public void setRoomNumber(int roomNumber) {
//        this.roomNumber = roomNumber;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getEmail() {
        return email;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

}
