import org.example.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FactorialTest {

    @DisplayName("Тесты для факториала 5")
    @ParameterizedTest
    @ValueSource(ints = 5)

    public void testNumber5(int var) {
        Assertions.assertEquals(120, var);
    }

    @DisplayName("Тесты для факториала 0")
    @ParameterizedTest
    @ValueSource(ints = 0)

    public void testNumber0(int var) {
        Assertions.assertEquals(1, var);
    }

    @DisplayName("Тесты для факториала 1")
    @ParameterizedTest
    @ValueSource(ints = 1)
    public void testNumber1(int var) {
        Assertions.assertEquals(1, var);
    }

    @DisplayName("Тесты для факториала -5")
    @ParameterizedTest
    @ValueSource(ints = -5)
    public void testNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> Factorial.factorial(0));
    }
}
