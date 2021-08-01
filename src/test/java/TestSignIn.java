import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.SignInPageObjects;

public class TestSignIn extends BaseTest {

    @Test
    public void TestSignInEmptyNameInputField(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signInEmptyNameInputField();

        Assertions.assertEquals("Enter your email or mobile phone number", driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).getText());
    }

    @Test
    public void TestSignInEmptyPasswordField(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signInEmptyPasswordField();

        Assertions.assertEquals("Enter your password", driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getText());
    }

    @Test
    public void TestSignInWrongPassword(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signInWrongPassword();

        Assertions.assertEquals("Your password is incorrect", driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText());
    }

    @Test
    public void TestSign(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signIn();

        Assertions.assertEquals("Soós", driver.findElement(By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/span")).getText());
    }
}
