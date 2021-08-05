package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage {

    WebDriver webdriver;

    public CalendarPage(WebDriver webdriver){
        this.webdriver = webdriver;
    }

    private final By PROFILE_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");

    private final By LOGOUT_ICON = By.xpath("//*/mat-icon[2]");
    private final By TRAINING_TYPE = By.xpath("//*[contains(@class,'details')]");
    private final By TRAINING_NAME = By.xpath("//*[contains(@class,'name')]");
    private final By TRAINING_DATE = By.xpath("//*[contains(@class,'time')]");
    private final By TRAINING_PRICE = By.xpath("//*[contains(@class,'price')]");

    private final By ACCEPT_COOKIES_BUTTON = By.xpath("//*/section/button");
    private final By HAMBURGER_BUTTON = By.xpath("//*/mat-icon");
    private final By LOGIN_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[1]/div/span/div[1]");
    private final By REGISTRATION_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[2]/div/span/div[1]");
    private final By CALENDAR_BUTTON = By.xpath("//*/mat-nav-list/a[3]/div/span/div[1]");
    private final By TRAINER_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");


    public void navigateToURL(String url){
        webdriver.get(url);
    }

    public void clickHamburgerButton(){
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickLoginButton(){
        webdriver.findElement(LOGIN_PAGE_BUTTON).click();
        new LoginPage(webdriver);
    }

    public void clickRegistrationButton(){
        webdriver.findElement(REGISTRATION_PAGE_BUTTON).click();
        new RegistrationPage(webdriver);
    }

    public void profileButtonClick(){
        webdriver.findElement(PROFILE_BUTTON).click();
        new PersonalDetails(webdriver);
    }

    public void logout(){
        webdriver.findElement(LOGOUT_ICON).click();
    }

    public void clickCookiesAcceptButton(){
        webdriver.findElement(ACCEPT_COOKIES_BUTTON).click();
    }

    public void clickCalendarButton(){
        webdriver.findElement(CALENDAR_BUTTON).click();
    }

    public void clickTrainerButton(){
        webdriver.findElement(TRAINER_BUTTON);
    }

}
