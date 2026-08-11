package oop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingServiceTest {

  User user;
  Room room;
  Booking booking;
  BookingService service;

  @BeforeEach
  void setUp() {
    user = new User("Alex", "alex@test.com", 28);
    room = new Room(101, "Standard");
    booking = new Booking(user, room, BookingStatus.CREATED);
    service = new BookingService();
  }

  @Test
  void shouldAddValidBooking() {
    service.addBooking(booking);
    assertEquals(1, service.bookings.size());
  }

  @Test
  void shouldThrowExceptionForInvalidBooking() {
    Booking invalidBooking = new Booking(null, room, BookingStatus.CREATED);

    assertThrows(
        InvalidBookingException.class,//что ожидаем
        () -> service.addBooking(invalidBooking) // что нужно запустить. ()-> лямбда "выполни"
    );
    assertEquals(0, service.bookings.size());
  }

  @Test
  void shouldAddTwoBookings() {
    service.addBooking(booking);

    User user1 = new User("Den", "alex@test.com", 28);
    Room room1 = new Room(103, "Standard");
    Booking booking1 = new Booking(user1, room1, BookingStatus.CREATED);

    service.addBooking(booking1);
    assertEquals(2, service.bookings.size());
  }

  @Test
  void shouldGroupCreatedBookings() {
    service.addBooking(booking);
    User user1 = new User("Den", "alex@test.com", 28);
    Room room1 = new Room(103, "Standard");
    Booking booking1 = new Booking(user1, room1, BookingStatus.CREATED);

    service.addBooking(booking1);
    Map<BookingStatus, List<Booking>> result = service.groupBookingsByStatus();
    assertEquals(2, result.get(BookingStatus.CREATED).size());
    assertEquals(1, result.size());
  }
  @Test
  void shouldGroupBookingsByDifferentStatuses(){
    service.addBooking(booking);
    User user1 = new User("Den", "den@test.com", 10);
    Room room1 = new Room(103, "Standard");
    Booking booking1 = new Booking(user1, room1, BookingStatus.CONFIRMED);

    service.addBooking(booking1);

    User user2 = new User("Kamil", "kamil@test.com", 2);
    Room room2 = new Room(103, "Standard");
    Booking booking2 = new Booking(user2, room2, BookingStatus.CREATED);

    service.addBooking(booking2);
    Map<BookingStatus, List<Booking>> result = service.groupBookingsByStatus();
    assertEquals(2, result.get(BookingStatus.CREATED).size());
    assertEquals(1, result.get(BookingStatus.CONFIRMED).size());
    assertEquals(2, result.size());
  }
}

