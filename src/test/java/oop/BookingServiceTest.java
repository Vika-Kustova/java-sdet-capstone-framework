package oop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class BookingServiceTest {

  User user;
  Room room;
  Booking booking;
  BookingService service;

  @BeforeEach
  void setUp() {
    user = new User("Alex", "alex@test.com", 28);
    room = new Room(101, RoomType.STANDARD);
    booking = new Booking(user, room, BookingStatus.CREATED);
    service = new BookingService();
  }

  @Test
  void shouldAddValidBooking() {
    service.addBooking(booking);
    assertEquals(1, service.getBookings().size());
  }

  // Parameterized Test
  static Stream<Booking> invalidBookings() {
    User user = new User("Alex", "alex@test.com", 28);
    Room room = new Room(101, RoomType.STANDARD);
    Booking booking = new Booking(null, room, BookingStatus.CREATED);
    Booking booking1 = new Booking(user, null, BookingStatus.CREATED);
    Booking booking2 = new Booking(user, room, null);

    return Stream.of(booking, booking1, booking2);
  }

  @ParameterizedTest
  @MethodSource("invalidBookings")
  void shouldRejectInvalidBooking(Booking invalidBooking) {
    assertThrows(
        InvalidBookingException.class, () -> service.addBooking(invalidBooking)
    );
    assertEquals(0, service.getBookings().size());
  }


  // parameterized test @CsvSource
  //вспомогательный метод
  private Booking createBooking(BookingStatus status) {
    User user = new User("Alex", "alex@test.com", 28);
    Room room = new Room(101, RoomType.STANDARD);
    return new Booking(user, room, status);
  }

  @ParameterizedTest
  @CsvSource({
      "CREATED, 2",
      "CONFIRMED, 1",
      "CANCELLED, 1"
  })
  void shouldCountByStatus(BookingStatus status, int expectedCount) {
//Arrange
    Booking booking1 = createBooking(BookingStatus.CREATED);
    Booking booking2 = createBooking(BookingStatus.CREATED);
    Booking booking3 = createBooking(BookingStatus.CONFIRMED);
    Booking booking4 = createBooking(BookingStatus.CANCELLED);

    service.addBooking(booking1);
    service.addBooking(booking2);
    service.addBooking(booking3);
    service.addBooking(booking4);

    //Act
    int result = service.countBookingsByStatus(status);
    //Assert
    assertEquals(expectedCount, result);
  }


  @ParameterizedTest
  @CsvSource({
      "CREATED, 2",
      "CONFIRMED, 1",
      "CANCELLED, 1"
  })
  void shouldFindBookingsByStatus(BookingStatus status, int expectedCount) {
    //Arrange
    Booking booking1 = createBooking(BookingStatus.CREATED);
    Booking booking2 = createBooking(BookingStatus.CREATED);
    Booking booking3 = createBooking(BookingStatus.CONFIRMED);
    Booking booking4 = createBooking(BookingStatus.CANCELLED);

    service.addBooking(booking1);
    service.addBooking(booking2);
    service.addBooking(booking3);
    service.addBooking(booking4);
    //Act
    List<Booking> result = service.findBookingsByStatus(status);
    //Assert
    assertEquals(expectedCount, result.size());
  }

  @Test
  void shouldAddTwoBookings() {
    service.addBooking(booking);
    Booking booking1 = createBooking(BookingStatus.CREATED);
    service.addBooking(booking1);
    assertEquals(2, service.getBookings().size());
  }

  @Test
  void shouldGroupCreatedBookings() {
    service.addBooking(booking);
    Booking booking1 = createBooking(BookingStatus.CREATED);
    service.addBooking(booking1);
    Map<BookingStatus, List<Booking>> result = service.groupBookingsByStatus();
    assertEquals(2, result.get(BookingStatus.CREATED).size());
    assertEquals(1, result.size());
  }

  @Test
  void shouldGroupBookingsByDifferentStatuses() {
    //Arrange
    Booking booking1 = createBooking(BookingStatus.CREATED);
    Booking booking2 = createBooking(BookingStatus.CONFIRMED);
    Booking booking3 = createBooking(BookingStatus.CREATED);
    service.addBooking(booking1);
    service.addBooking(booking2);
    service.addBooking(booking3);
    //Act
    Map<BookingStatus, List<Booking>> result = service.groupBookingsByStatus();
    //Assert
    assertEquals(2, result.get(BookingStatus.CREATED).size());
    assertEquals(1, result.get(BookingStatus.CONFIRMED).size());
    assertEquals(2, result.size());
  }

  @Test
  void shouldReturnZeroWhenStatusNotFound() {
    Booking booking1 = createBooking(BookingStatus.CREATED);
    Booking booking2 = createBooking(BookingStatus.CONFIRMED);
    service.addBooking(booking1);
    service.addBooking(booking2);

    assertEquals(0, service.countBookingsByStatus(BookingStatus.CANCELLED));
  }

  @Test
  void shouldReturnZeroForEmptyBookingList() {
    assertEquals(0, service.countBookingsByStatus(BookingStatus.CANCELLED));
  }

  @Test
  void shouldFindBookingsByUser() {
    User user1 = new User("Den", "den@test.com", 30);
    Booking booking1 = new Booking(user1, room, BookingStatus.CREATED);
    Booking booking2 = new Booking(user, room, BookingStatus.CANCELLED);
    service.addBooking(booking);
    service.addBooking(booking1);
    service.addBooking(booking2);
    //Act
    List<Booking> result = service.findBookingsByUser(user);
    //Assert
    assertEquals(2, result.size());
  }

  @Test
  void shouldReturnEmptyListWhenUserHasNoBookings() {
    User user1 = new User("Den", "den@test.com", 10);
    service.addBooking(booking);
    List<Booking> result = service.findBookingsByUser(user1);
    assertEquals(0, result.size());
  }

  @ParameterizedTest
  @CsvSource({
      "Den,2",
      "Alex,1"
  })
  void shouldFindBookingsByName(String name, int expectedCount) {
    service.addBooking(booking);
    User user1 = new User("Den", "de@test.com", 10);
    Booking booking1 = new Booking(user1, room, BookingStatus.CANCELLED);
    Room room1 = new Room(13, RoomType.SUITE);
    Booking booking2 = new Booking(user1, room1, BookingStatus.CONFIRMED);
    service.addBooking(booking1);
    service.addBooking(booking2);
    List<Booking> result = service.findBookingsByName(name);
    assertEquals(expectedCount, result.size());
  }
}

