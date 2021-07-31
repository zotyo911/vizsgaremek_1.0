import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.RegistrationPageObjects;
import util.Util;

public class TestRegistration {

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
    public void driverClose(){
        Util.closeDriver();
    }
}
