import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPageObjects;
import pages.NewAccountPageObjects;
import pages.SignInPageObjects;
import pages.SignOutPageObjects;
import util.Util;

import static util.Util.*;

public class TestSignOut {

    @Test
    public void TestCompleteSignOut(){
        MainPageObjects.clickSignInButton();
        NewAccountPageObjects.clickSignInWithIMDbButton();
        SignInPageObjects.signIn();
        SignOutPageObjects.clickToDropDownButton();
        SignOutPageObjects.clickSignOutButton();

        Assertions.assertEquals("Sign In", getDriver().findElement(By.cssSelector(".imdb-header__signin-text > .ipc-button__text")).getText());
    }

}
