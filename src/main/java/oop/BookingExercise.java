package oop;

public class BookingExercise {
public static void main (String[] args){
  User user= new User ("Alex", "alex@test.com", 28);
  Room room = new Room(101,"Standard");

  User user1= new User ("Den", "den@test.com", 28);
  Room room1 = new Room(103,"Standard");

  Booking booking1=new Booking(user,room,BookingStatus.CREATED);
  Booking booking2=new Booking(user1,room1,BookingStatus.CONFIRMED);
  BookingService service = new BookingService();
  service.addBooking(booking1);
  service.addBooking(booking2);
  System.out.println("name: "+booking1.user.name+"; room: "+booking1.room.roomNumber+"; status: "+booking1.status);
  System.out.println(booking1.isValid());
  System.out.println(booking1);
  System.out.println(service);
  //System.out.println(service.bookings);

}
}
