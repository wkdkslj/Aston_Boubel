import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentBlockTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
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
    public void testOnlineReplenishmentBlock() {
        // 1. Проверка названия указанного блока
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]")));
        Assert.assertTrue("Блок 'Онлайн пополнение без комиссии' не найден", blockTitle.isDisplayed());

        // 2. Проверка наличия логотипов платёжных систем
        int paymentLogosCount = driver.findElements(By.xpath("//div[@class='pay__partners']//img")).size();
        Assert.assertTrue("Логотипы платёжных систем не найдены", paymentLogosCount > 0);
    }
    @Test
    public void testDetailsLink() {

//         3. Проверка работы ссылки «Подробнее о сервисе»

        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")));
        link.click();
        wait.until(ExpectedConditions.titleContains("Порядок оплаты и безопасность интернет платежей"));
        Assert.assertTrue("Страница 'Подробнее о сервисе' не открылась", driver.getTitle().contains("Порядок оплаты и безопасность интернет платежей"));

        // Вернуться на главную страницу
        driver.navigate().back();
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]")));
        Assert.assertTrue("Переход на главную страницу не произведен", blockTitle.isDisplayed());

    }

    @Test
    public void testContinueButtonFunctionality() {
        // 4. Заполнить поля и проверить работу кнопки «Продолжить»

        WebElement phoneInput = driver.findElement(By.id("connection-phone")); // Предполагаем, что поле ввода имеет атрибут name='phone'
        phoneInput.sendKeys("297777777");
        Assert.assertTrue(phoneInput.isDisplayed());

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys("10");
        Assert.assertTrue(sumInput.isDisplayed());

        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}