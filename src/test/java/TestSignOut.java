import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.SignInPageObjects;
import pages.SignOutPageObjects;

public class TestSignOut extends BaseTest {

    @Test
    public void TestCompleteSignOut(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signIn();
        SignOutPageObjects.clickToDropDownButton();
        SignOutPageObjects.clickSignOutButton();

        Assertions.assertEquals("Sign In", driver.findElement(By.cssSelector(".imdb-header__signin-text > .ipc-button__text")).getText());
    }
}
