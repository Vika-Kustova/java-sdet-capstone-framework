package oop;

public class Room implements Validatable {

  private int roomNumber;
  private RoomType roomType;

  public Room(int roomNumber, RoomType roomType) {
    this.roomNumber = roomNumber;
    this.roomType = roomType;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  @Override
  public boolean isValid() {
    return roomNumber > 0 && roomType != null;
  }
}
