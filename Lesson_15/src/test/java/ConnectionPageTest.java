import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectionPageTest {
    private WebDriver driver;

    @Test
    public void testConnectionPage() {
        // Инициализация драйвера
        driver = new ChromeDriver();
        driver.get("URL_ВАШЕЙ_СТРАНИЦЫ"); // Замените на URL вашей страницы

        ConnectionPage connectionPage = new ConnectionPage(driver);

        // Тест для "Услуги связи"
        connectionPage.selectOption("Услуги связи");
        connectionPage.checkPlaceholders("Услуги связи");

        // Тест для "Задолженность"
        connectionPage.selectOption("Задолженность");
        connectionPage.checkPlaceholders("Задолженность");

        // Закрытие драйвера
        driver.quit();
    }
}
