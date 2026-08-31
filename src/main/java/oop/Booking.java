package oop;

public class Booking implements Validatable {

  private User user;
  private Room room;
  private BookingStatus status;

  public Booking(User user, Room room, BookingStatus status) {
    this.user = user;
    this.room = room;
    this.status = status;
  }

  @Override
  public boolean isValid() {
    return user != null
        && user.isValid()
        && room != null
        && room.isValid()
        && status != null;
  }

  public User getUser() {
    return user;
  }

  public BookingStatus getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "Booking{" + "name=" + user.getName() + '\'' + ", room=" + room.getRoomNumber()
        + ", status=" + status + "}";
  }
}
