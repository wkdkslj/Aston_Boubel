import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlineReplenishmentPage {
    private WebDriver driver;

    // Элементы страницы
    private By servicesConnectionField = By.id("connection_service");
    private By homeInternetField = By.id("home_internet");
    private By installmentField = By.id("installment");
    private By debtField = By.id("debt");
    private By continueButton = By.id("continue_button");

    // Поля для реквизитов карты
    private By cardNumberField = By.id("card_number");
    private By expirationDateField = By.id("expiration_date");
    private By cvvField = By.id("cvv");

    public OnlineReplenishmentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Проверка надписей в незаполненных полях
    public void checkEmptyFieldLabels() {
        assert driver.findElement(servicesConnectionField).getAttribute("placeholder").equals("Услуги связи");
        assert driver.findElement(homeInternetField).getAttribute("placeholder").equals("Домашний интернет");
        assert driver.findElement(installmentField).getAttribute("placeholder").equals("Рассрочка");
        assert driver.findElement(debtField).getAttribute("placeholder").equals("Задолженность");
    }

    // Заполнение полей и проверка
    public void fillServiceFieldsAndContinue(String phoneNumber) {
        driver.findElement(servicesConnectionField).sendKeys(phoneNumber);
        driver.findElement(continueButton).click();
    }

    public void checkPaymentDetails() {
        // Проверка суммы, номера телефона и наличия иконок платёжных систем
        String amount = driver.findElement(By.id("amount_display")).getText();
        String phone = driver.findElement(By.id("phone_display")).getText();

        assert amount.equals("Ожидаемая сумма"); // Замените на ожидаемую сумму
        assert phone.equals("Ожидаемый номер"); // Замените на ожидаемый номер

        // Проверка наличия иконок платёжных систем
        WebElement paymentIcons = driver.findElement(By.cssSelector(".payment-icons"));
        assert paymentIcons.isDisplayed();
    }
}
