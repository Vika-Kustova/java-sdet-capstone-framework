package oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookingService {

  List<Booking> bookings = new ArrayList<>();// принадлежит объекту BookingService

  public void addBooking(Booking newbooking) {
    if (!newbooking.isValid()) {
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
  public void printAllBookings() {
    for (int i = 0; i < bookings.size(); i++) {
      System.out.println((i + 1) + ". " + bookings.get(i));
    }
  }

  // service.findBookingsByUser(user1);
  public List<Booking> findBookingsByUser(User targetUser) {
    List<Booking> result = new ArrayList<>();
    for (Booking currentBooking : bookings) {
      if (currentBooking.getUser().equals(targetUser)) {
        result.add(currentBooking);
      }
    }
    return result;

  }

  public List<Booking> findBookingsByName(String name) {
    List<Booking> result = new ArrayList<>();
    for (Booking currentBooking : bookings) {
      if (name.equals(currentBooking.getUser().getName())) {
        result.add(currentBooking);
      }
    }
    return result;
  }

  public List<Booking> findBookingsByStatus(BookingStatus targetStatus) {
    List<Booking> result = new ArrayList<>();
    for (Booking currentBooking : bookings) {
      if (currentBooking.getStatus() == targetStatus) {
        result.add(currentBooking);
      }
    }
    return result;
  }

  public Map<BookingStatus, List<Booking>> groupBookingsByStatus() {
    Map<BookingStatus, List<Booking>> bookingsByStatus = new HashMap<>();
    for (Booking booking : bookings) {

      BookingStatus status = booking.getStatus();
      if (!bookingsByStatus.containsKey(status)) {
        bookingsByStatus.put(status, new ArrayList<>());
      }
      bookingsByStatus.get(status).add(booking);
    }

    return bookingsByStatus;
  }

  public int countBookingsByStatus(BookingStatus status) {
    int count = 0;
    for (Booking booking : bookings) {

      if (booking.getStatus() == status) {
        count = count + 1;
      }
    }
    return count;
  }
}
