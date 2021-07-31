import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.SignInPageObjects;
import pages.SignOutPageObjects;
import util.Util;

public class TestSignOut {

    @BeforeEach
    public void Setup() {
        Util.getDriver();
    }

    @Test
    @DisplayName("LO-01")
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
        Util.closeDriver();
    }
}
