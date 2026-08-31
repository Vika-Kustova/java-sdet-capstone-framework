package examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void shouldSumTwoPositiveNumbers() {
    //Calculator calculator=new Calculator();
    int result = calculator.sum(2, 3);
    assertEquals(5, result);
  }

  @Test
  void shouldSumTwoPositiveNumbers1() {
    int result = calculator.sum(4, 8);
    assertEquals(12, result);
  }

  @Test
  void shouldSumWithZero() {
    int result = calculator.sum(0, 2);
    assertEquals(2, result);
  }
}
