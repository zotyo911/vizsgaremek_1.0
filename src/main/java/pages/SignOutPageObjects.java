package pages;

import org.openqa.selenium.By;
import util.Webdriver;

public class SignOutPageObjects {
    private static final By toDropDownButton = By.xpath("//*/label[2]/div/span");
    private static final By signOutButton = By.xpath("//*[@id=\"navUserMenu-contents\"]/ul/a[7]");

    public static void clickToDropDownButton(){
        Webdriver.getDriver().findElement(toDropDownButton).click();
    }

    public static void clickSignOutButton(){
        Webdriver.getDriver().findElement(signOutButton).click();
    }
}
