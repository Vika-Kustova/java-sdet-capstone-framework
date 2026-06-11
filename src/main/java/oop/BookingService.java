package oop;
import java.util.ArrayList;
import java.util.List;
public class BookingService {

  List<Booking> bookings = new ArrayList<>();// принадлежит объекту BookingService
  public void addBooking (Booking booking){
    bookings.add(booking);

  }
 /* @Override
  public String toString() {
    return "Bookings count: " + bookings.size(); // size это метод списка
  }*/
  @Override
  public String toString() {
    return bookings.toString();
  }
}
