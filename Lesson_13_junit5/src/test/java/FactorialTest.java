import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.Factorial.factorial;

public class FactorialTest {

    @DisplayName("Тесты для факториала 5")
    @Test
    public void testNumber5() {
        Assertions.assertEquals(120, factorial(5));
    }

    @DisplayName("Тесты для факториала 0")
    @Test
    public void testNumber0() {
        Assertions.assertEquals(1, factorial(0));
    }

    @DisplayName("Тесты для факториала 1")
    @Test
    public void testNumber1() {
        Assertions.assertEquals(1, factorial(1));
    }

    @DisplayName("Тесты для факториала -5")
    @Test
    public void testNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> factorial(-5));
    }
}
