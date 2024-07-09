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

    @BeforeEach
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void SwitchOff() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testBlock() {
        driver.get("http://mts.by");

        // Подтверждения cookies
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        acceptCookiesButton.click();

        // 1. Проверить название указанного блока
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")));
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText());

        // 2. Проверить наличие логотипов платёжных систем
        WebElement logosList = driver.findElement(By.xpath("//div[@class='pay__partners']/ul"));
        assertTrue(logosList.findElement(By.xpath(".//img[@alt='Visa']")).isDisplayed());
        assertTrue(logosList.findElement(By.xpath(".//img[@alt='Verified By Visa']")).isDisplayed());
        assertTrue(logosList.findElement(By.xpath(".//img[@alt='MasterCard']")).isDisplayed());
        assertTrue(logosList.findElement(By.xpath(".//img[@alt='MasterCard Secure Code']")).isDisplayed());
        assertTrue(logosList.findElement(By.xpath(".//img[@alt='Белкарт']")).isDisplayed());

        // 3. Проверить работу ссылки «Подробнее о сервисе»
        WebElement moreAboutServiceLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        assertTrue(moreAboutServiceLink.isDisplayed());
        moreAboutServiceLink.click();
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());

        driver.navigate().back();

        // 4. Заполнить поля и проверить работу кнопки «Продолжить»
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        sumInput.sendKeys("10");

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='connection-email']"));
        emailInput.sendKeys("test@example.com");

        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default ']"));
        continueButton.click();


    }
}