package pages;

import org.openqa.selenium.By;
import util.Webdriver;

public class MainPageObjects {

    private static final By signInButton = By.xpath("//*/div[2]/div[5]/a/div");

    public static void clickSignInButton(){
        Webdriver.getDriver().findElement(signInButton).click();
    }
}
