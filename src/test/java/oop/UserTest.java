package oop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class UserTest {

  @Test
  void shouldBeValidWhenUserDataIsValid() {
    User user = new User("Alex", "alex@test.com", 30);
    boolean result = user.isValid();
    assertTrue(result);

  }

  static Stream<User> invalidUsers() {
    User user = new User(null, "user@test.com", 28);
    User user1 = new User("Den", null, 28);
    User user2 = new User("Alex", "user@test.com", 0);
    User user3 = new User("Alex", "user@test.com", -1);
    return Stream.of(user, user1, user2, user3);

  }

  @ParameterizedTest
  @MethodSource("invalidUsers")
  void shouldBeInvalidWhenUserDataIsInvalid(User invalidUser) {
    boolean result = invalidUser.isValid();

    assertFalse(result);
  }
}
