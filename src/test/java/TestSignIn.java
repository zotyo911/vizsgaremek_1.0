import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.SignInPageObjects;
import util.Util;

import java.util.concurrent.TimeUnit;

public class TestSignIn {

    public WebDriver driver;

    @BeforeEach
    public void Setup() {
        driver = Util.getDriver();
    }

    @Test
    public void TestSignInEmptyNameInputField(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signInEmptyNameInputField();

        Assertions.assertEquals("Enter your email or mobile phone number", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).getText());
    }

    @Test
    public void TestSignInEmptyPasswordField(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signInEmptyPasswordField();

        Assertions.assertEquals("Enter your password", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getText());
    }

    @Test
    public void TestSignInWrongPassword(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signInWrongPassword();

        Assertions.assertEquals("Your password is incorrect", Util.getDriver().findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestSignIn(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signIn();

        Assertions.assertEquals("Soós", Util.getDriver().findElement(By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/span")).getText());
    }

    @AfterEach
    public void Close() {
        driver.close();
    }
}
