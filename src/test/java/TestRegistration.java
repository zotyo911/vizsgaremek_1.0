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

    @BeforeEach
    public void Setup() {
        Util.getDriver();
    }

    @Test
    @DisplayName("RI-01")
    @Order(1)
    public void TestRegistrationNoEmailAddress() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoEmailAddress();

        Assertions.assertEquals("There was a problem", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText());
    }

    @Test
    @DisplayName("RI-02")
    @Order(2)
    public void TestRegistrationNoName() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoName();

        Assertions.assertEquals("Enter your name", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    @DisplayName("RI-03")
    @Order(3)
    public void TestRegistrationNoPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoPassword();

        Assertions.assertEquals("Enter your password", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    @DisplayName("RI-04")
    @Order(4)
    public void TestRegistrationNotValidPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNotValidPassword();

        Assertions.assertEquals("There was a problem", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText());
    }

    @Test
    @DisplayName("RI-05")
    @Order(5)
    public void TestRegistrationNoMatchPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoMatchPassword();

        Assertions.assertEquals("Passwords must match", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    @DisplayName("RI-06")
    @Order(6)
    public void TestValidRegistration(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.validRegistration();

        Assertions.assertEquals("Enter the characters above", Util.getDriver().findElement(By.xpath("//*/div[1]/label")).getText());
    }

    @AfterEach
    public void Close() {
        Util.closeDriver();
    }
}
