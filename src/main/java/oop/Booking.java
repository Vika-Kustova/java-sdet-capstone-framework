package oop;

public class Booking implements Validatable {
User user;
Room room;
BookingStatus status;

public Booking(User user, Room room, BookingStatus status){
  this.user=user;
  this.room=room;
  this.status=status;
}
public boolean isValid(){
  return user != null && room != null && status != null;
}
@Override
  public String toString(){
  return "Booking{"+"name="+user.name+'\''+", room="+room.roomNumber+", status="+status+"}";
}
}
