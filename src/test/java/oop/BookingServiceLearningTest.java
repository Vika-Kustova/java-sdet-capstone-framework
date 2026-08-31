package oop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BookingServiceLearningTest {

  User user;
  Room room;
  Booking booking;
  BookingService service;

  @BeforeEach
  void setUp() {
    user = new User("Alex", "alex@test.com", 28);
    room = new Room(101, RoomType.STANDARD);

    service = new BookingService();
  }

  @Test
  void shouldThrowExceptionForInvalidBookingWithoutUser() {
    Booking invalidBooking = new Booking(null, room, BookingStatus.CREATED);

    assertThrows(
        InvalidBookingException.class,//что ожидаем
        () -> service.addBooking(invalidBooking) // что нужно запустить. ()-> лямбда "выполни"
    );
    assertEquals(0, service.bookings.size());
  }


  @Test
  void shouldThrowExceptionForBookingWithoutRoom() {
    Booking invalidBooking = new Booking(user, null, BookingStatus.CREATED);

    assertThrows(InvalidBookingException.class, () -> service.addBooking(invalidBooking));
    assertEquals(0, service.bookings.size());
  }

  // Parameterized Test @ValueSource
  @ParameterizedTest
  @ValueSource(ints = {10, 18, 28})
  void shouldCreateUserWithDifferentAges(int age) {
    User user = new User("Alex", "alex@test.com", age);
    assertEquals(age, user.getAge());
  }

  // parameterized test @CsvSource
  @ParameterizedTest
  @CsvSource({
      "CREATED, 2",
      "CONFIRMED, 1",
      "CANCELLED, 1"
  })
  void shouldCountByStatus(BookingStatus status, int expectedCount) {
//Arrange
    User user1 = new User("Alex", "alex@test.com", 28);
    Room room1 = new Room(101, RoomType.SUITE);
    Booking booking1 = new Booking(user1, room1, BookingStatus.CREATED);

    User user2 = new User("Den", "den@test.com", 18);
    Room room2 = new Room(102, RoomType.STANDARD);
    Booking booking2 = new Booking(user2, room2, BookingStatus.CREATED);

    User user3 = new User("Kamil", "kamil@test.com", 2);
    Room room3 = new Room(103, RoomType.STANDARD);
    Booking booking3 = new Booking(user3, room3, BookingStatus.CONFIRMED);

    User user4 = new User("Vika", "vika@test.com", 8);
    Room room4 = new Room(104, RoomType.STANDARD);
    Booking booking4 = new Booking(user4, room4, BookingStatus.CANCELLED);

    service.addBooking(booking1);
    service.addBooking(booking2);
    service.addBooking(booking3);
    service.addBooking(booking4);

    //Act
    int result = service.countBookingsByStatus(status);
    //Assert
    assertEquals(expectedCount, result);
  }
}
