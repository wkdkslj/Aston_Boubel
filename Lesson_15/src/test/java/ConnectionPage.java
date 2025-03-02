import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConnectionPage {
    private WebDriver driver;

    // Конструктор
    public ConnectionPage(WebDriver driver) {
        this.driver = driver;
    }

    // Элементы страницы
    private By optionServices = By.xpath("//option[text()='Услуги связи']");
    private By optionArrears = By.xpath("//option[text()='Задолженность']");
    private By inputFieldPhone = By.id("connection-phone");
    private By inputFieldSum = By.id("connection-sum");
    private By inputFieldMail = By.id("connection-email");
    private By inputFieldPhoneArrears = By.id("score-arrears");
    private By inputFieldSumArrears = By.id("arrears-sum");
    private By inputFieldMailArrears = By.id("arrears-email");

    // Метод для выбора опции
    public void selectOption(String optionText) {
        if (optionText.equals("Услуги связи")) {
            driver.findElement(optionServices).click();
        } else if (optionText.equals("Задолженность")) {
            driver.findElement(optionArrears).click();
        }
    }

    // Метод для проверки плейсхолдеров
    public void checkPlaceholders(String optionText) {
        WebElement phoneField, sumField, mailField;

        if (optionText.equals("Услуги связи")) {
            phoneField = driver.findElement(inputFieldPhone);
            sumField = driver.findElement(inputFieldSum);
            mailField = driver.findElement(inputFieldMail);
        } else {
            phoneField = driver.findElement(inputFieldPhoneArrears);
            sumField = driver.findElement(inputFieldSumArrears);
            mailField = driver.findElement(inputFieldMailArrears);
        }

        String expectedPhonePlaceholder = optionText.equals("Услуги связи") ? "Номер счета на 44" : "Номер счета на 2073";
        String expectedSumPlaceholder = "Сумма";
        String expectedMailPlaceholder = "E-mail для отправки чека";

        Assert.assertEquals("Некорректный плейсхолдер для телефона", expectedPhonePlaceholder, phoneField.getAttribute("placeholder"));
        Assert.assertEquals("Некорректный плейсхолдер для суммы", expectedSumPlaceholder, sumField.getAttribute("placeholder"));
        Assert.assertEquals("Некорректный плейсхолдер для почты", expectedMailPlaceholder, mailField.getAttribute("placeholder"));
    }
}
