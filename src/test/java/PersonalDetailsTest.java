import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CalendarPage;
import pages.LoginPage;
import pages.PersonalDetails;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonalDetailsTest {

    WebDriver webdriver;
    LoginPage loginPage;
    CalendarPage calendarPage;
    PersonalDetails personalDetails;

    @BeforeEach
    public void Init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    @Order(1)
    public void testUploadUserPersonaDetails(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadPersonalDetails(Constants.USER_FIRSTNAME, Constants.USER_SURNAME, Constants.USER_NICKNAME);

        Assertions.assertEquals("Hello, " + Constants.USER_FIRSTNAME, webdriver.findElement(By.xpath("//*/mat-toolbar-row[1]/div/div/span")).getText());
    }

    @Test
    @Order(2)
    public void testAddWrongPasswordToChange(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.NOT_VALID_PASSWORD, Constants.USER_NEW_PASSWORD, Constants.USER_NEW_PASSWORD);

        Assertions.assertEquals("polite", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-live"));
    }

    @Test
    @Order(3)
    public void testAddWrongConfirmPassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.PASSWORD, Constants.USER_NEW_PASSWORD, Constants.NOT_MATCH_PASSWORD);

        Assertions.assertEquals("polite", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-live"));
    }

    @Test
    @Order(4)
    public void testChangePassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.PASSWORD, Constants.USER_NEW_PASSWORD, Constants.USER_NEW_PASSWORD);

        Assertions.assertEquals("true", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-atomic"));
    }

    @Test
    @Order(5)
    public void testUploadUserBillingDetails(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.USER_NEW_PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadBillingDetails(Constants.USER_FULLNAME, Constants.USER_COUNTRY, Constants.USER_POSTAL_CODE, Constants.USER_CITY, Constants.USER_ADDRESS);

        Assertions.assertEquals("cdk-overlay-container", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-overlay-container')]")).getAttribute("class"));
    }

    @Test
    @Order(6)
    public void testChangeBackToOriginalPassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.USER_NEW_PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.changePassword(Constants.USER_NEW_PASSWORD, Constants.USER_PASSWORD, Constants.USER_PASSWORD);

        Assertions.assertEquals("true", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-live-announcer-element cdk-visually-hidden')]")).getAttribute("aria-atomic"));
    }

    @Test
    @Order(7)
    public void testModifyUserBillingDetails(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadBillingDetails(Constants.USER_FULLNAME, Constants.USER_COUNTRY, Constants.USER_MODIFIED_POSTAL_CODE, Constants.USER_MODIFIED_CITY, Constants.USER_MODIFIED_ADDRESS);

        Assertions.assertEquals("cdk-overlay-container", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-overlay-container')]")).getAttribute("class"));
    }

    @Test
    @Order(8)
    public void testDeleteUserBillingDetails(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.deleteBillingDetails(Constants.USER_FULLNAME);

        Assertions.assertEquals("cdk-overlay-container", webdriver.findElement(By.xpath("//*[contains(@class,'cdk-overlay-container')]")).getAttribute("class"));
    }




 /*   @AfterEach
    public void Close() {
        webdriver.quit();
    }*/
}
