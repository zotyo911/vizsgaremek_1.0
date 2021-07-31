package pages;

import org.openqa.selenium.By;
import util.Util;

public class NewAccountPageObjects {

    private static final By createANewAccountButton = By.xpath("//*/div/div[2]/a");
    private static final By signInWithIMDbButton = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]/span[2]");

    public static void clickNewAccountPageButton(){
        Util.getDriver().findElement(createANewAccountButton).click();
    }

    public static void clickSignInWithIMDbButton(){
        Util.getDriver().findElement(signInWithIMDbButton).click();
    }
}
