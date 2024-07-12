import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

public class Mts {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mts.by");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    // Метод для принятия cookies
    private void acceptCookies() {
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        acceptCookiesButton.click();
    }

    // Метод для проверки placeholder'ов
    private void verifyPlaceholders(String option, String phoneId, String phonePlaceholder, String sumId, String sumPlaceholder, String emailId, String emailPlaceholder) {
        WebElement servicesOption = driver.findElement(By.xpath("//span[@class='select__now' and contains(text(), '" + option + "')]"));
        assertTrue(servicesOption.isDisplayed());

        WebElement phonePlaceholderElement = driver.findElement(By.xpath("//input[@id='" + phoneId + "']"));
        assertEquals(phonePlaceholder, phonePlaceholderElement.getAttribute("placeholder"));

        WebElement sumPlaceholderElement = driver.findElement(By.xpath("//input[@id='" + sumId + "']"));
        assertEquals(sumPlaceholder, sumPlaceholderElement.getAttribute("placeholder"));

        WebElement emailPlaceholderElement = driver.findElement(By.xpath("//input[@id='" + emailId + "']"));
        assertEquals(emailPlaceholder, emailPlaceholderElement.getAttribute("placeholder"));
    }

    // Метод для выбора услуги
    private void selectOption(String optionText) {
        WebElement selectWrapper = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.select__wrapper")));
        WebElement selectHeader = selectWrapper.findElement(By.cssSelector("button.select__header"));
        selectHeader.click();

        WebElement optionElement = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), '" + optionText + "')]"));
        optionElement.click();
    }

    // Метод для заполнения полей
    private void fillField(By locator, String value) {
        WebElement field = driver.findElement(locator);
        field.sendKeys(value);
    }

    // Метод для проверки текста
    private void assertLabelText(By locator, String expectedText) {
        WebElement label = driver.findElement(locator);
        assertEquals(expectedText, label.getText());
    }
    @Test
    public void testBlock() throws InterruptedException {
        acceptCookies();
        verifyPlaceholders("Услуги связи", "connection-phone", "Номер телефона", "connection-sum", "Сумма", "connection-email", "E-mail для отправки чека");

        selectOption("Домашний интернет");
        Thread.sleep(2000);
        verifyPlaceholders("Домашний интернет", "internet-phone", "Номер абонента", "internet-sum", "Сумма", "internet-email", "E-mail для отправки чека");

        selectOption("Рассрочка");
        Thread.sleep(2000);
        verifyPlaceholders("Рассрочка", "score-instalment", "Номер счета на 44", "instalment-sum", "Сумма", "instalment-email", "E-mail для отправки чека");

        selectOption("Задолженность");
        Thread.sleep(2000);
        verifyPlaceholders("Задолженность", "score-arrears", "Номер счета на 2073", "arrears-sum", "Сумма", "arrears-email", "E-mail для отправки чека");

        selectOption("Услуги связи");
        Thread.sleep(2000);


        fillField(By.id("connection-phone"), "297777777");
        fillField(By.id("connection-sum"), "2");
        fillField(By.id("connection-email"), "test@example.com");


        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default ']"));
        continueButton.click();


        WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(frameElement);

        // Проверка суммы
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='2.00 BYN']")));
        assertEquals("2.00 BYN", amountElement.getText());

        // Проверка кнопки "Оплатить"
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and contains(text(), 'Оплатить')]")));
        assertEquals("Оплатить 2.00 BYN", payButton.getText().trim());

        // Проверка надписей для ввода реквизитов карты
        assertLabelText(By.xpath("//label[text()='Номер карты']"), "Номер карты");
        assertLabelText(By.xpath("//label[text()='Срок действия']"), "Срок действия");
        assertLabelText(By.xpath("//label[text()='CVC']"), "CVC");
        assertLabelText(By.xpath("//label[text()='Имя держателя (как на карте)']"), "Имя держателя (как на карте)");

        // Проверка номера телефона
        WebElement phoneNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Оплата: Услуги связи') and contains(text(), '375297777777')]")));
        assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumberElement.getText().replaceAll("[\\t\\n\\r]+", " "));

        // Проверка наличия иконок платежных систем
        WebElement mastercardIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'mastercard-system.svg')]")));
        assertTrue(mastercardIcon.isDisplayed());

        WebElement visaIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'visa-system.svg')]")));
        assertTrue(visaIcon.isDisplayed());

        WebElement belkartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'belkart-system.svg')]")));
        assertTrue(belkartIcon.isDisplayed());

        WebElement mirIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'mir-system-ru.svg')]")));
        assertTrue(mirIcon.isDisplayed());


        driver.switchTo().defaultContent();
    }


}