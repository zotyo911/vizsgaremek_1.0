package pages;

import org.openqa.selenium.By;
import util.Util;

public class MainPageObjects {
    private static final By signInButton = By.cssSelector(".imdb-header__signin-text > .ipc-button__text");

    public static void clickSignInButton(){
        Util.getDriver().findElement(signInButton).click();
    }
}
