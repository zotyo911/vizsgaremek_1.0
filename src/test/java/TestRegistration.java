import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.RegistrationPageObjects;
import util.Webdriver;

public class TestRegistration {

    public static WebDriver driver;

    @BeforeEach
    public void init(){
        driver = Webdriver.getDriver();
    }

    @Test
    public void TestRegistrationNoEmailAddress() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoEmailAddress();

        Assertions.assertEquals("There was a problem", Webdriver.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText());
    }

    @Test
    public void TestRegistrationNoName() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoName();

        Assertions.assertEquals("Enter your name", Webdriver.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestRegistrationNoPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoPassword();

        Assertions.assertEquals("Enter your password", Webdriver.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestRegistrationNotValidPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNotValidPassword();

        Assertions.assertEquals("There was a problem", Webdriver.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4")).getText());
    }

    @Test
    public void TestRegistrationNoMatchPassword() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.registrationNoMatchPassword();

        Assertions.assertEquals("Passwords must match", Webdriver.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestValidRegistration() {
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickNewAccountPageButton();
        RegistrationPageObjects.validRegistration();

        Assertions.assertEquals("Enter the characters above", Webdriver.getDriver().findElement(By.xpath("//*/div[1]/label")).getText());
    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }
}