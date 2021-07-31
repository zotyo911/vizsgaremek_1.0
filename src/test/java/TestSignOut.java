import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.SignInPageObjects;
import pages.SignOutPageObjects;
import util.Util;

public class TestSignOut {

    public WebDriver driver;

    @BeforeEach
    public void Setup() {
        driver = Util.getDriver();
    }


    @Test
    public void TestCompleteSignOut(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signIn();
        SignOutPageObjects.clickToDropDownButton();
        SignOutPageObjects.clickSignOutButton();

        Assertions.assertEquals("Sign In", Util.getDriver().findElement(By.cssSelector(".imdb-header__signin-text > .ipc-button__text")).getText());
    }

    @AfterEach
    public void Close() {
        driver.close();
    }
}
