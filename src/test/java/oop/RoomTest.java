package oop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RoomTest {

  @Test
  void shouldBeValidWhenRoomDataIsValid() {
    Room room = new Room(102, RoomType.SUITE);
    boolean result = room.isValid();
    assertTrue(result);
  }

  static Stream<Room> invalidRooms() {
    Room room = new Room(0, RoomType.STANDARD);
    Room room1 = new Room(-1, RoomType.SUITE);
    Room room2 = new Room(1, null);
    return Stream.of(room, room1, room2);
  }

  @ParameterizedTest
  @MethodSource("invalidRooms")
  void shouldBeInvalidWhenRoomDataIsInvalid(Room invalidRoom) {
    boolean result = invalidRoom.isValid();
    assertFalse(result);
  }
}
