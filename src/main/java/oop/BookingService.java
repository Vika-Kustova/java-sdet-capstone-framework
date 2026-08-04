package oop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class BookingService {

  List<Booking> bookings = new ArrayList<>();// принадлежит объекту BookingService
  public void addBooking (Booking newbooking){
    if(!newbooking.isValid()){
      throw new InvalidBookingException("Booking is invalid");
    }
    bookings.add(newbooking);

  }
 /* @Override
  public String toString() {
    return "Bookings count: " + bookings.size(); // size это метод списка
  }*/
  @Override
  public String toString() {
    return bookings.toString();
  }

  /*public void printAllBookings(){
    for (Booking currentBooking : bookings){//Для каждой брони из списка bookings, получим список без нумерации
      System.out.println(currentBooking);}*/
  public void printAllBookings(){
    for(int i=0;i<bookings.size();i++){
      System.out.println((i + 1) + ". " + bookings.get(i));
    }
  }

  public void findBookingsByUser(User targetUser){
    for (Booking currentBooking:bookings){
      if (currentBooking.user==targetUser){
        System.out.println (currentBooking);
      }
    }
  }
  public void findBookingsByName (String name){
    for (Booking currentBooking:bookings){
      if (name.equals(currentBooking.user.name)){
        System.out.println (currentBooking);
      }
    }
  }
  public void findBookingsByStatus (BookingStatus targetStatus){
    for (Booking currentBooking:bookings){
      if (currentBooking.status==targetStatus){
        System.out.println(currentBooking);
      }
    }
  }
  public Map<BookingStatus, List<Booking>> groupBookingsByStatus() {
    Map<BookingStatus, List<Booking>> bookingsByStatus = new HashMap<>();
    for (Booking booking : bookings) {

      BookingStatus status = booking.status;
      if(!bookingsByStatus.containsKey(status)){
        bookingsByStatus.put(status,new ArrayList<>());
      }
bookingsByStatus.get(status).add(booking);
    }


    return bookingsByStatus;
  }
}
