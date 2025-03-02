import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlineReplenishmentTest {
    private WebDriver driver;
    private OnlineReplenishmentPage page;
    private WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        page = new OnlineReplenishmentPage(driver);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        Thread.sleep(3000);
        if(!driver.findElements(By.xpath("//button[contains(text(), 'Принять')]")).isEmpty()) {
            WebElement continueButtonCookie = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            continueButtonCookie.click();
        }
    }

    @Test
    public void testEmptyFieldLabels() {
        page.checkEmptyFieldLabels();
    }

    @Test
    public void testServiceConnection() {
        WebElement serviceOption = driver.findElement(By.xpath("//input[@value='Услуги связи']"));
        serviceOption.click();

        WebElement phoneInput = driver.findElement(By.name("phone")); // Предполагаем, что поле ввода имеет атрибут name='phone'
        phoneInput.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();

        // Проверяем детали платежа
        page.checkPaymentDetails();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
