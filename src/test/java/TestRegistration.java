import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.RegistrationPageObjects;
import util.Util;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class TestRegistration {

    public WebDriver driver;

    @BeforeEach
    public void Setup() {
        driver = Util.getDriver();
    }

    @Test
    public void TestRegistrationNoEmailAddress() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoEmailAddress();

        Assertions.assertEquals("There was a problem", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText());
    }

    @Test
    public void TestRegistrationNoName() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoName();

        Assertions.assertEquals("Enter your name", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestRegistrationNoPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoPassword();

        Assertions.assertEquals("Enter your password", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestRegistrationNotValidPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNotValidPassword();

        Assertions.assertEquals("There was a problem", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText());
    }

    @Test
    public void TestRegistrationNoMatchPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoMatchPassword();

        Assertions.assertEquals("Passwords must match", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestValidRegistration(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.validRegistration();

        Assertions.assertEquals("Enter the characters above", Util.getDriver().findElement(By.xpath("//*/div[1]/label")).getText());
    }

    @AfterEach
    public void Close() {
        driver.close();
    }
}
