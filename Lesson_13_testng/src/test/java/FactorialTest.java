import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @Test(description = "Тесты для факториала 5")
    public void testNumber5() {
        assertEquals(120,Factorial.factorial(5));
    }

    @Test(description = "Тесты для факториала 0")
    public void testNumber0() {
        assertEquals(1  , Factorial.factorial(0));
    }

    @Test(description = "Тесты для факториала 1")
    public void testNumber1() {
        assertEquals(1,Factorial.factorial(1));
    }

    @Test(description = "Тесты для факториала -5")
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, ()-> {
         Factorial.factorial(-5); });
    }
}
