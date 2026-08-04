package oop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookingExercise {
public static void main (String[] args){
  User user= null;//new User ("Alex", "alex@test.com", 28);
  Room room = new Room(101,"Standard");

  User user1= new User ("Den", "den@test.com", 28);
  Room room1 = new Room(103,"Standard");

  User user2= new User ("Kamil", "alex@test.com", 28);
  Room room2 = new Room(102,"Standard");

  User user3 = new User ("Artem", "alex@test.com", 28);
  Room room3 =new Room(12,"Standard");

  Booking booking1=new Booking(user,room,BookingStatus.CREATED);
  Booking booking2=new Booking(user1,room1,BookingStatus.CONFIRMED);
  Booking booking3=new Booking(user2,room2,BookingStatus.CANCELLED);
  Booking booking4=new Booking(user3,room3,BookingStatus.CREATED);
  BookingService service = new BookingService();
  //service.addBooking(booking1);
  try {
    service.addBooking(booking1);
  }
  catch (InvalidBookingException e) {
    System.out.println("Error: " + e.getMessage());
  }

  System.out.println("Done");
  service.addBooking(booking2);
  service.addBooking(booking3);
  service.addBooking(booking4);
  service.printAllBookings();
  service.findBookingsByUser(user1);
  service.findBookingsByName("Alex");
  service.findBookingsByStatus(BookingStatus.CREATED);
  //System.out.println("name: "+booking1.user.name+"; room: "+booking1.room.roomNumber+"; status: "+booking1.status);
  //System.out.println(booking1.isValid());
  //System.out.println(booking1);
  //System.out.println(service);
  //System.out.println(service.bookings);

  Map<BookingStatus, List<Booking>> result =
      service.groupBookingsByStatus();
  System.out.println(result);


}
}
